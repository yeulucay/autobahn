package com.bahcesehir.autobahn.services.helpers;


public class JdbcHelper {

    private static JdbcHelper helper;

    private JdbcHelper(){}

    public static synchronized JdbcHelper Instance(){
        if(helper == null){
            helper = new JdbcHelper();
        }
        return helper;
    }

    public String getJdbcType(String enrichmentSourceType){
        String jdbcType = "";
        switch (enrichmentSourceType){
            case "MYSQL":
                jdbcType = "mysql";
                break;
            case "POSTGRESQL":
                jdbcType = "postgresql";
                break;
        }
        return jdbcType;
    }

    public String getJdbcUrl(String type, String address, String port, String databaseName){
        return String.format("jdbc:%s://%s:%s/%s",
                type,
                address,
                port,
                databaseName);
    }
}
