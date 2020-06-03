package com.bookit.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    // THis is class have constants (properties) that we need in application values will be getting properties
    // based on environment it will take values and defined the values.
    // We have different envs -> dev,qa,stagin,
    // for every envs we create properties file under resources
    // properties will be loaded based on env name on configration.properties
    // same keys but different values for environmnets.
    // lets say if env is qa1 it will load the values from there
    // that execution happens here.
    // all environments are same but different content.
    // for exampe Url is url in every envoirmnet but value is different.
    // and all values will be provided when this class being called.
    public static final String URL;
    public static final String DB_USERNAME;
    public static final String DB_PASSWORD;
    public static final String DB_HOST;
    public static final String BASE_URI;
    public static final String TEACHER_USERNAME;
    public static final String TEACHER_PASSWORD;
    public static final String MEMBER_USERNAME;
    public static final String MEMBER_PASSWORD;
    public static final String LEADER_USERNAME;
    public static final String LEADER_PASSWORD;

    static {
        Properties properties = null;
        String environment = ConfigurationReader.getProperty("environment");
        try {
            //https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
            String path = System.getProperty("user.dir") + String.format("/src/test/resources/environment/%s.properties", environment);
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL = properties.getProperty("url");
        DB_HOST = properties.getProperty("db_host");
        DB_USERNAME = properties.getProperty("db_username");
        DB_PASSWORD = properties.getProperty("db_password");
        BASE_URI = properties.getProperty("base_url");
        TEACHER_USERNAME = properties.getProperty("teacher_email");
        TEACHER_PASSWORD = properties.getProperty("teacher_password");
        MEMBER_USERNAME = properties.getProperty("team_member_email");
        MEMBER_PASSWORD = properties.getProperty("team_member_password");
        LEADER_USERNAME = properties.getProperty("team_leader_email");
        LEADER_PASSWORD = properties.getProperty("team_leader_password");
    }
}
