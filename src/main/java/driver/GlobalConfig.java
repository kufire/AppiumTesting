package driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class GlobalConfig {
    public AppiumConfig appium;
    public XueqiuConfig xueqiu;


    public static GlobalConfig load(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        ArrayList<String> strzixuan=new ArrayList<String>();
        try {
            GlobalConfig config = mapper.readValue(GlobalConfig.class.getResource(path), GlobalConfig.class);
            return config;
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }



    }
}

