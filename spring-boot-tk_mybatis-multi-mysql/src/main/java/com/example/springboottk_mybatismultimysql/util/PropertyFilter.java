/************************ CHANGE REPORT HISTORY ******************************\
** Product VERSION,UPDATED BY,UPDATE DATE                                     *
*   DESCRIPTION OF CHANGE: modify(M),add(+),del(-)                             *

*-----------------------------------------------------------------------------*
* V1.0DEMO,maxp,2016-3-26
* M 注释
*-----------------------------------------------------------------------------*
* V1.0DEMO,maxp,2016-3-26
* + removePropertyFilter 根据传递的参数将list中包含有name的参数移除返回
*-----------------------------------------------------------------------------*
* V1.0β,maxp,2016-8-1
* M #1086 MatchType 新增notin 操作
* -----------------------------------------------------------------------------*
* V1.2.0,maxp,2017-06-27
* M #1086 MatchType 新增isNULL 操作
*-----------------------------------------------------------------------------*
* V2.0.4 2018-1-22
* M RDM#8821 检查规范修正 by maxp
*-----------------------------------------------------------------------------*
* V1.0DEMO,maxp,2016-3-12
* M  {modifyComment}
* -  {delComment}
* +  {addCommnet}
\*************************** END OF CHANGE REPORT HISTORY ********************/
package com.example.springboottk_mybatismultimysql.util;


import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 与具体ORM实现无关的属性过滤条件封装类, 主要记录页面中简单的搜索过滤条件.
 * 
 * @author maxp
 */
 
public class PropertyFilter {

	/** 多个属性间OR关系的分隔符. */
	public static final String OR_SEPARATOR = "_OR_";

	/** 属性比较类型. */
	public enum MatchType {
		//
		EQ,
		//
		LIKE,
		//
		LT,
		//
		GT,
		//
		LE,
		//
		GE,
		//
		IN,
		//
		NIN,
		//
		ISN,
		//
		NOTN;
		
	}

	/** 属性数据类型. */
	public enum PropertyType {
		//
		S(String.class),
	    //
		I(Integer.class),
		//
		L(Long.class),
		//
		N(Double.class), 
		//
		D(Date.class),
		//
		B(Boolean.class);

		private Class<?> clazz;

		private PropertyType(Class<?> clazz) {
			this.clazz = clazz;
		}

		public Class<?> getValue() {
			return clazz;
		}
	}

	private MatchType matchType = null;
	private Object matchValue = null;

	private Class<?> propertyClass = null;
	private String[] propertyNames = null;

	public PropertyFilter() {
	}

	/**
	 * @param filterName 比较属性字符串,含待比较的比较类型、属性值类型及属性列表. 
	 *                   eg. LIKES_NAME_OR_LOGIN_NAME
	 * @param value 待比较的值.
	 */
	public PropertyFilter(final String filterName, final String value) {

		String firstPart = StringUtils.substringBefore(filterName, "_");
		String matchTypeCode = StringUtils.substring(firstPart, 0, firstPart.length() - 1);
		String propertyTypeCode = StringUtils.substring(firstPart, firstPart.length() - 1, firstPart.length());

		try {
			matchType = Enum.valueOf(MatchType.class, matchTypeCode);
		} catch (RuntimeException e) {
			throw new IllegalArgumentException("filter名称" + filterName + "没有按规则编写,无法得到属性比较类型.", e);
		}

		try {
			propertyClass = Enum.valueOf(PropertyType.class, propertyTypeCode).getValue();
		} catch (RuntimeException e) {
			throw new IllegalArgumentException("filter名称" + filterName + "没有按规则编写,无法得到属性值类型.", e);
		}

		String propertyNameStr = StringUtils.substringAfter(filterName, "_");
		Assert.isTrue(StringUtils.isNotBlank(propertyNameStr), "filter名称" + filterName + "没有按规则编写,无法得到属性名称.");
		propertyNames = StringUtils.splitByWholeSeparator(propertyNameStr, PropertyFilter.OR_SEPARATOR);

		if(this.matchType == MatchType.IN) 
		{
			this.matchValue = ConvertUtils.convertStringToObjectArray(value, propertyClass);
			
			Object[] tempObejct=(Object[])this.matchValue;
			this.matchValue = Arrays.asList(tempObejct);
		}else if(this.matchType == MatchType.NIN) 
			
		{
			//maxp,2016-8-1 M #1086 针对 notin 做特殊处理 
			this.matchValue = ConvertUtils.convertStringToObjectArray(value, propertyClass);
			
			Object[] tempObejct=(Object[])this.matchValue;
			this.matchValue = Arrays.asList(tempObejct);
		}else if("NULL".equals(value))	{
			//maxp2017-06-27 针对值等于null的处理
			this.matchType= MatchType.ISN;
		}
		else
		{
			this.matchValue = ConvertUtils.convertStringToObject(value, propertyClass);
		}
	}

	/**
	 * 从HttpRequest中创建PropertyFilter列表, 默认Filter属性名前缀为filter.
	 * 
	 * @see #buildFromHttpRequest(HttpServletRequest, String)
	 */
	public static List<PropertyFilter> buildFromHttpRequest(final HttpServletRequest request) {
		return buildFromHttpRequest(request, "filter");
	}

	/**
	 * 从HttpRequest中创建PropertyFilter列表
	 * PropertyFilter命名规则为Filter属性前缀_比较类型属性类型_属性名.
	 * 
	 * eg.
	 * filter_EQS_name
	 * filter_LIKES_name_OR_email
	 */
	public static List<PropertyFilter> buildFromHttpRequest(final HttpServletRequest request, final String filterPrefix) {
		List<PropertyFilter> filterList = new ArrayList<PropertyFilter>();

		//从request中获取含属性前缀名的参数,构造去除前缀名后的参数Map.
		Map<String, Object> filterParamMap = ServletUtils.getParametersStartingWith(request, filterPrefix + "_");

		//分析参数Map,构造PropertyFilter列表
		for (Map.Entry<String, Object> entry : filterParamMap.entrySet()) {
			String filterName = entry.getKey();
			String value = (String) entry.getValue();
			//如果value值为空,则忽略此filter.
			if (StringUtils.isNotBlank(value)) {
				PropertyFilter filter = new PropertyFilter(filterName, value);
				filterList.add(filter);
			}
		}

		return filterList;
	}
	
	/**
	 * 从HttpRequest中找到PropertyFilter表达式并转化成List<String[]>形式, 默认Filter属性名前缀为filter.
	 * 
	 */
	public static List<String[]> buildFromHttpRequestWs(
			final HttpServletRequest request) {
		List<String[]> filterList = new ArrayList<String[]>();

		// 从request中获取含属性前缀名的参数,构造去除前缀名后的参数Map.
		Map<String, Object> filterParamMap = ServletUtils.getParametersStartingWith(request, "filter_");

		// 构造查询参数list，String[0]:比较类型属性类型_属性名;String[1]:属性值的xml
		for (Map.Entry<String, Object> entry : filterParamMap.entrySet()) {
			String filterName = entry.getKey();
			String value = (String) entry.getValue();
			// 如果value值为空,则忽略此filter.
			if (StringUtils.isNotBlank(value)) {
				String[] filter = new String[] { filterName, value };
				filterList.add(filter);
			}
		}

		return filterList;
	}

	/**
	 * 获取比较值的类型.
	 */
	public Class<?> getPropertyClass() {
		return propertyClass;
	}

	/**
	 * 获取比较方式.
	 */
	public MatchType getMatchType() {
		return matchType;
	}

	/**
	 * 获取比较值.
	 */
	public Object getMatchValue() {
		return matchValue;
	}

	/**
	 * 获取比较属性名称列表.
	 */
	public String[] getPropertyNames() {
		return propertyNames;
	}

	/**
	 * 获取唯一的比较属性名称.
	 */
	public String getPropertyName() {
		Assert.isTrue(propertyNames.length == 1, "There are not only one property in this filter.");
		return propertyNames[0];
	}

	/**
	 * 是否比较多个属性.
	 */
	public boolean hasMultiProperties() {
		return (propertyNames.length > 1);
	}

	
	/**
	 * 根据传递的参数将list中包含有name的参数移除返回
	 * + by maxp,2016-3-26
	 * @param list
	 * @param name
	 * @return
	 */
	public static  PropertyFilter removePropertyFilter(List<PropertyFilter> list,String name){
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getPropertyName().equals(name)){
			  return	list.remove(i);
			}
		}
		return null;
	}


	/**
	 * 重写equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof PropertyFilter) {
			return Arrays.toString(propertyNames).equals(Arrays.toString(((PropertyFilter)obj).getPropertyNames()));
		}else{
			return false;
		}
	}
	
	
	

}
