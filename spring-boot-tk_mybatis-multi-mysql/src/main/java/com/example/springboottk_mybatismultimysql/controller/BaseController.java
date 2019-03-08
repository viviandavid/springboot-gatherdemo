package com.example.springboottk_mybatismultimysql.controller;


import com.example.springboottk_mybatismultimysql.util.DateUtils;
import com.example.springboottk_mybatismultimysql.util.Page;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
public class BaseController {

    private static Log logger = LogFactory.getLog(BaseController.class);
    /**
     * 设置返回数据格式以及状态码
     * @param response
     */
    public  void setResponse(final HttpServletResponse response)  {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setHeader("Date", DateUtils.getNowTime());
    }

    /**
     * 设置分页及排序 分页参数： start（起始记录数）, limit（每页的记录数） 排序参数：sort （排序字段）， dir（排序方向）
     *
     * 供子类列表函数调用
     *
     */
    protected void prePage(HttpServletRequest request, Page page) {
        // 读取的行数
        Integer limit = 5;
        Integer start = 0;
        String startStr = request.getParameter("current");  //RDM#64 参数错误  start -> iDisplayStart; limit -> iDisplayLength
        String limitStr = request.getParameter("size");
        String sort = request.getParameter("sort");  //format: (col desc|asc)
        String sortType = request.getParameter("sortType");  //@see cn.lsmsp.common.Page.SortType
        String dir = request.getParameter("dir");


        // 加载数据
        if (startStr != null && !"".equals(startStr.trim())) {
            start = Integer.parseInt(startStr);
        }

        if (limitStr != null && !"".equals(limitStr.trim())) {
            limit = Integer.parseInt(limitStr);
        }
        // 设置页数
        page.setPageNo(start);

        // 设置每页显示多少记录
        page.setPageSize(limit);

        // 设置默认排序方式
        if (sort != null && !"".equals(sort.trim())) {
            page.setOrderBy(sort);
            //RDM#6172 xull 2017-8-15 添加支持中文排序、ip排序
            if(StringUtils.isBlank(sortType)) {//没传默认使用普通排序
                page.setOrderType(Page.SortType.NORMAL.getValue());
            }
            try {
                //传递参数不为数字使用默认排序
                page.setOrderType(Integer.valueOf(sortType));
            } catch (Exception e) {
                page.setOrderType(Page.SortType.NORMAL.getValue());
            }

			/* //RDM#64 暂不用dir参数
			if (dir != null && !"".equals(dir)) {
				page.setOrder(dir);
			} else {
				page.setOrder(Page.ASC);
			}*/
        }
    }


    /**
     * 获取datatables返回的数据类型 ，此块针对前端datatables生成的数据格式
     * @param list
     * @param total
     * @param start
     * @return
     */
    protected Map<String, Object> getDatatableResponse(Collection<?> list, Integer total, Integer start){
        // 将要转换的对象
        Map<String, Object> dtResponse = new HashMap<String, Object>();
        // 总记录条数
        if (total == -1)
        {
            dtResponse.put("iTotalRecords", 0);
        } else
        {
            dtResponse.put("iTotalRecords", total);
        }
        // 数据行
        if (null == list)
        {
            list = new ArrayList<Object>();
        }
        dtResponse.put("aaData", list);
        if (null == total)
        {
            total = 0;
        }
        dtResponse.put("iTotalDisplayRecords", total);
        dtResponse.put("iDisplayStart", start);
        return dtResponse;
    }

    /**
     * 获取datatables返回的数据类型 ，此块针对前端datatables生成的数据格式
     * @param list
     * @param total
     * @param start
     * @return
     */
    protected ArrayList< Map<String, Object>> getDatatableResponse(Object[] list, Long total, Integer start){
        ArrayList< Map<String, Object>> rt=new ArrayList<Map<String,Object>>();
        // 将要转换的对象
        Map<String, Object> dtResponse = new HashMap<String, Object>();
        // 总记录条数
        if (total == -1)
        {
            dtResponse.put("iTotalRecords", 0);
        } else
        {
            dtResponse.put("iTotalRecords", total);
        }
        // 数据行
        if (null == list)
        {
            list = new Object[0];
        }
        dtResponse.put("aaData", list);
        if (null == total)
        {
            total = 0L;
        }
        dtResponse.put("iTotalDisplayRecords", total);
        dtResponse.put("iDisplayStart", start);
        rt.add(dtResponse);
        return rt;
    }

}
