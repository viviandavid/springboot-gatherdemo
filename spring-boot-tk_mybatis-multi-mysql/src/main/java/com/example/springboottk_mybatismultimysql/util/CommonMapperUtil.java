/************************ CHANGE REPORT HISTORY ******************************\
** Product VERSION,UPDATED BY,UPDATE DATE                                     *
*   DESCRIPTION OF CHANGE: modify(M),add(+),del(-)                             *

*-----------------------------------------------------------------------------*
* V1.0DEMO,maxp,2016-3-26
* M 注释
*-----------------------------------------------------------------------------*
* V1.0DEMO,maxp,2016-3-26
* + buildCriterionByPropertyFilter 新增构造查询条件方法，满足自定义查询的要求
*-----------------------------------------------------------------------------*
* V1.0β,maxp,2016-8-1
* M #1086 buildCriterionByPropertyFilter 新增notin 操作
* -----------------------------------------------------------------------------*
* V1.2.0,maxp,2017-06-27
* M #1086 ISN  
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


import org.springframework.util.Assert;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.ArrayList;
import java.util.List;

public class CommonMapperUtil {

	
	/**
	 * 按属性条件参数创建Criterion,辅助函数.
	 * maxp,2016-8-1 新增notin 操作
	 * maxp, 2017-6-27 
	 */
	private static Criteria buildCriterion(Criteria example,final String propertyName, final Object propertyValue, final PropertyFilter.MatchType matchType) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criteria criterion = null;
		//根据MatchType构造criterion
	
		switch (matchType) {
		case EQ:
			criterion = example.andEqualTo(propertyName, propertyValue);
			break;
		case LIKE:
			criterion = example.andLike(propertyName, "%"+propertyValue+"%");
			break;
		case LE:
			criterion =  example.andLessThanOrEqualTo(propertyName, propertyValue);
			break;
		case LT:
			criterion =  example.andLessThan(propertyName, propertyValue);
			break;
		case GE:
			criterion =  example.andGreaterThanOrEqualTo(propertyName, propertyValue);
			break;
		case GT:
			criterion =  example.andGreaterThan(propertyName, propertyValue);
			break;
		case IN:
			criterion = example.andIn(propertyName, (List<Object>)propertyValue);
			break;
		case NIN:
			criterion = example.andNotIn(propertyName, (List<Object>)propertyValue);
			break;
		case ISN:
			criterion = example.andIsNull(propertyName);
			break;
		case NOTN:
			criterion = example.andIsNotNull(propertyName);
			break;
		default:
			criterion = null;
			break;
		}
		return criterion;
	}
	
	
	/**
	 * 按属性条件参数创建Criterion,辅助函数.
	 *  maxp,2016-8-1 新增notin 操作
	 */
	private static  Criteria buildOrCriterion(Criteria example,final String propertyName, final Object propertyValue, final PropertyFilter.MatchType matchType) {
		Assert.hasText(propertyName, "propertyName不能为空");
		Criteria criterion = null;
		//根据MatchType构造criterion
		switch (matchType) {
		case EQ:
			criterion = example.andEqualTo(propertyName, propertyValue);
			break;
		case LIKE:
			criterion = example.andLike(propertyName, "%"+propertyValue+"%");
			break;
		case LE:
			criterion =  example.andLessThanOrEqualTo(propertyName, propertyValue);
			break;
		case LT:
			criterion = example.andLessThan(propertyName, propertyValue);
			break;
		case GE:
			criterion =  example.andGreaterThanOrEqualTo(propertyName, propertyValue);
			break;
		case GT:
			criterion = example.andGreaterThan(propertyName, propertyValue);
			break;
		case IN:
			criterion = example.andIn(propertyName, (List<Object>)propertyValue);
			break;
		case NIN:
			criterion = example.andNotIn(propertyName, (List<Object>)propertyValue);
			break;
		case ISN:
			criterion = example.andIsNull(propertyName);
			break;
		case NOTN:
			criterion = example.andIsNotNull(propertyName);
			break;
		default:
			criterion=null;
			break;
		}
		return criterion;
	}

	/**
	 * 按属性条件列表创建Criteria数组,辅助函数.
	 */
	public static  Criteria[] buildCriterionByPropertyFilter(Example example,final List<PropertyFilter> filters) {
		List<Criteria> criterionList = new ArrayList<Criteria>();
		  Criteria criteria=example.createCriteria();
		for (PropertyFilter filter : filters) {
			if (!filter.hasMultiProperties()) { //只有一个属性需要比较的情况.
				Criteria criterion = buildCriterion(criteria,filter.getPropertyName(), filter.getMatchValue(), filter
						.getMatchType());
				criterionList.add(criterion);
			} else {//包含多个属性需要比较的情况,进行or处理.
 				for (String param : filter.getPropertyNames()) {
					Criteria criterion = buildOrCriterion(criteria,param, filter.getMatchValue(), filter.getMatchType());
					criterionList.add(criterion);
				}
 			}
		}
		return criterionList.toArray(new Criteria[criterionList.size()]);
	}
	
	/**
	 * 按属性条件列表创建Criteria数组,辅助函数.
	 * 提供根据传递的Criteria
	 * 用于外部可以组装自定义的查询条件
	 */
	public static  Criteria[] buildCriterionByPropertyFilter(Criteria criteria,final List<PropertyFilter> filters) {
		List<Criteria> criterionList = new ArrayList<Criteria>();
		for (PropertyFilter filter : filters) {
			if (!filter.hasMultiProperties()) { //只有一个属性需要比较的情况.
				Criteria criterion = buildCriterion(criteria,filter.getPropertyName(), filter.getMatchValue(), filter
						.getMatchType());
				criterionList.add(criterion);
			} else {//包含多个属性需要比较的情况,进行or处理.
 				for (String param : filter.getPropertyNames()) {
					Criteria criterion = buildOrCriterion(criteria,param, filter.getMatchValue(), filter.getMatchType());
					criterionList.add(criterion);
				}
 			}
		}
		return criterionList.toArray(new Criteria[criterionList.size()]);
	}
	
}
