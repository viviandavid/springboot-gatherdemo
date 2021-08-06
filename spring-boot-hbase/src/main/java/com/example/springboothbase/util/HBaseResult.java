package com.example.springboothbase.util;

import com.example.springboothbase.bean.HBaseBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.*;

/**
 * @Author lijianlei
 * @Date 2020/5/18 13:42
 * @Version 1.0
 */
@Slf4j
public class HBaseResult {

    public static HBaseBean toHBaseBean(Result rs){
        List<Cell> cells = rs.listCells();
        HBaseBean  hBaseBean=new HBaseBean();
        cells.forEach(cell -> {
            hBaseBean.setRowKey(Bytes.toString(CellUtil.cloneRow(cell)));
            hBaseBean.setColumnFamily(Bytes.toString(CellUtil.cloneFamily(cell)));
            hBaseBean.setColumnQualifier(Bytes.toString(CellUtil.cloneQualifier(cell)));
            hBaseBean.setTimeStamp(cell.getTimestamp());
            hBaseBean.setType(cell.getType().toString());
            hBaseBean.setValue(Bytes.toString(CellUtil.cloneValue(cell)));
        });
        return hBaseBean;
    }

    public static List<HBaseBean> toHBaseBeans(Result rs){
        List<HBaseBean>  hBaseBeans=new ArrayList<>();
            List<Cell> cells = rs.listCells();
            cells.forEach(cell -> {
                HBaseBean  hBaseBean=new HBaseBean();
                hBaseBean.setRowKey(Bytes.toString(CellUtil.cloneRow(cell)));
                hBaseBean.setColumnFamily(Bytes.toString(CellUtil.cloneFamily(cell)));
                hBaseBean.setColumnQualifier(Bytes.toString(CellUtil.cloneQualifier(cell)));
                hBaseBean.setTimeStamp(cell.getTimestamp());
                hBaseBean.setType(cell.getType().toString());
                hBaseBean.setValue(Bytes.toString(CellUtil.cloneValue(cell)));
                hBaseBeans.add(hBaseBean);
            });
        return hBaseBeans;
    }

    public static List<HBaseBean> toHBaseBeans(Iterator<Result> resultIterator){
        List<HBaseBean>  hBaseBeans=new ArrayList<>();
        while (resultIterator.hasNext()){
            Result rs = resultIterator.next();
            List<Cell> cells = rs.listCells();
            cells.forEach(cell -> {
                HBaseBean  hBaseBean=new HBaseBean();
                hBaseBean.setRowKey(Bytes.toString(CellUtil.cloneRow(cell)));
                hBaseBean.setColumnFamily(Bytes.toString(CellUtil.cloneFamily(cell)));
                hBaseBean.setColumnQualifier(Bytes.toString(CellUtil.cloneQualifier(cell)));
                hBaseBean.setTimeStamp(cell.getTimestamp());
                hBaseBean.setType(cell.getType().toString());
                hBaseBean.setValue(Bytes.toString(CellUtil.cloneValue(cell)));
                hBaseBeans.add(hBaseBean);
            });
        }
        return hBaseBeans;
    }


    /**
     * 获取单行结果
     * @return
     */
    public static  Map<String, String> getRowData(Result rs) {
        Map<String, String> column = new HashMap<>();
        column.put("rowKey", Bytes.toString(rs.getRow()));
        List<Cell> cells = rs.listCells();
        for (Cell cell : cells) {
            String columnName = Bytes.toString(CellUtil.cloneQualifier(cell));
            String columnValue =  Bytes.toString(CellUtil.cloneValue(cell));
            column.put(columnName, columnValue);
        }
        return column;
    }

    public static void setStartAndStop(String startRow, String stopRow, Scan scan) {
        if (!StringUtils.isEmpty(startRow)) {
            scan.withStartRow(Bytes.toBytes(startRow));
        }

        if (!StringUtils.isEmpty(stopRow)) {
            scan.withStopRow(Bytes.toBytes(stopRow));
        }
    }
}