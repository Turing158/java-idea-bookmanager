package cn.itcast.bookmanager.util;

import cn.itcast.bookmanager.model.User;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {
    private static String userDataFileName="tb_bookmanager_user.txt";
    public static  List<User> getUserListFromDataFile() throws IOException {
        InputStream input=CSVUtils.class.getResourceAsStream("/"+userDataFileName);
        Reader in = (Reader) new InputStreamReader(input);
        // id,username,password,role,sex,phone
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader("id", "username",
                "password","role","sex","phone").parse(in);
        ArrayList<User> arrayList = new ArrayList<>();

        //第一行是标题，需要跳过
        int count=0;
        for (CSVRecord record:records){
            if (count>0) {
                User user = new User();
                //注意列从0开始对应
                user.setUserId(Integer.parseInt(record.get(0)));
                user.setUserName(record.get(1));
                user.setPassword(record.get(2));
                user.setRole(Integer.parseInt(record.get(3)));
                user.setSex(record.get(4));
                user.setPhone(record.get(5));
                arrayList.add(user);
            }
            count++;
        }
        return arrayList;
    }
}
