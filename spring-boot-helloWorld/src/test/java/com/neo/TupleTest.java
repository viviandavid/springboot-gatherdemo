package com.neo;

import com.neo.util.TupleUtils;
import org.javatuples.Triplet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TupleTest {


    @Test
    public void test() {
        List<Triplet<Class, String, String>> roleList = new ArrayList<Triplet<Class, String, String>>();

        /*
            三元组，存储数据：对应实体类字节码文件、数据表主键名称、数据表毕业院校字段名称
         */
        Triplet<Class, String, String> studentTriplet = TupleUtils.with(String.class, "sid", "graduate");
        Triplet<Class, String, String> teacherTriplet = TupleUtils.with(Object.class, "tid", "graduate");
        Triplet<Class, String, String> programmerTriplet = TupleUtils.with(TupleUtils.class, "id", "graduate");

        roleList.add(studentTriplet);
        roleList.add(teacherTriplet);
        roleList.add(programmerTriplet);

        for (Triplet<Class, String, String> triplet : roleList) {
            System.out.println(triplet);
        }
    }
}
