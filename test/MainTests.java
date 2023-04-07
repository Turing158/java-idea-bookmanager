import org.junit.Test;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class MainTests {
    @Test
    public void firstTest(){
        System.out.println("hello test");
        try{
            Properties properties=new Properties();  // 用/文件名， / 表示根目录
            InputStream input=MainTests.class.getResourceAsStream("/application.properties");
            properties.load(input);
            Enumeration<String> names=(Enumeration<String>) properties.propertyNames();
            while(names.hasMoreElements()){
                //这是key值
                String key=names.nextElement();
                String value=properties.getProperty(key);
                System.out.println(key+"="+value);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
