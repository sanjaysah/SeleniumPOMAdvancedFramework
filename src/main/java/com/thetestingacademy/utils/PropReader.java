package com.thetestingacademy.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Properties;

public class PropReader {

    static Properties prop;

    static FileInputStream fis;

    static HashMap<String, String> PROP_KEYS = new HashMap<>();

    static String pathConfigFile = System.getProperty("user.dir")+"/src/test/resources/config.properties";

    static{
        try{
            prop = new Properties();
            fis = new FileInputStream(new File(pathConfigFile));
            prop.load(fis);
            for(Object key: prop.keySet()){
                PROP_KEYS.put(String.valueOf(key),prop.getProperty(String.valueOf(key)));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                if(Objects.nonNull(fis))
                        fis.close();;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static String getValue(String key) throws Exception {
        if(key!=null && PROP_KEYS.get(key)!=null)
                return PROP_KEYS.get(key);
        else
            throw new Exception("Property not found!!");
    }
}
