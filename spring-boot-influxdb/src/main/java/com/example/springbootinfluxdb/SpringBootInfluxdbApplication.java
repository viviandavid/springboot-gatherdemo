package com.example.springbootinfluxdb;

import org.influxdb.BatchOptions;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringBootInfluxdbApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(SpringBootInfluxdbApplication.class, args);
        System.out.println("welcome to my world");
        test();
    }

    public static void test() throws InterruptedException {
        // 直接拷贝就完事了^V^
        // Create an object to handle the communication with InfluxDB.
        // (best practice tip: reuse the 'influxDB' instance when possible)
        final String serverURL = "http://10.20.4.221:8086", username = "", password = "";
//        final InfluxDB influxDB = InfluxDBFactory.connect(serverURL, username, password);
        final InfluxDB influxDB = InfluxDBFactory.connect(serverURL);

        // Create a database...
        // https://docs.influxdata.com/influxdb/v1.7/query_language/database_management/
        String databaseName = "NOAA_water_database";
        influxDB.query(new Query("CREATE DATABASE " + databaseName));
        influxDB.setDatabase(databaseName);

        // ... and a retention policy, if necessary.
        // https://docs.influxdata.com/influxdb/v1.7/query_language/database_management/
        String retentionPolicyName = "one_day_only";
        influxDB.query(new Query("CREATE RETENTION POLICY " + retentionPolicyName
                + " ON " + databaseName + " DURATION 1d REPLICATION 1 DEFAULT"));
        influxDB.setRetentionPolicy(retentionPolicyName);

        // Enable batch writes to get better performance.
        influxDB.enableBatch(BatchOptions.DEFAULTS);

        // Write points to InfluxDB.
        influxDB.write(Point.measurement("h2o_feet")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("location", "santa_monica")
                .addField("level description", "below 3 feet")
                .addField("water_level", 2.064d)
                .build());

        influxDB.write(Point.measurement("h2o_feet")
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .tag("location", "coyote_creek")
                .addField("level description", "between 6 and 9 feet")
                .addField("water_level", 8.12d)
                .build());

        // Wait a few seconds in order to let the InfluxDB client
        // write your points asynchronously (note: you can adjust the
        // internal time interval if you need via 'enableBatch' call).
        Thread.sleep(5_000L);

        // Query your data using InfluxQL.
        // https://docs.influxdata.com/influxdb/v1.7/query_language/data_exploration/#the-basic-select-statement
        QueryResult queryResult = influxDB.query(new Query("SELECT * FROM h2o_feet"));

        System.out.println(queryResult);
        // It will print something like:
        // QueryResult [results=[Result [series=[Series [name=h2o_feet, tags=null,
        //      columns=[time, level description, location, water_level],
        //      values=[
        //         [2020-03-22T20:50:12.929Z, below 3 feet, santa_monica, 2.064],
        //         [2020-03-22T20:50:12.929Z, between 6 and 9 feet, coyote_creek, 8.12]
        //      ]]], error=null]], error=null]

        // Close it if your application is terminating or you are not using it anymore.
        influxDB.close();
    }

}
