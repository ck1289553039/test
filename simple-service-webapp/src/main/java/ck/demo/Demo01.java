package ck.demo;

import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;

/**
 * Created by soft01 on 2017/5/2.
 */
@Path("Demo01")
public class Demo01 {
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public String post(@FormParam("name") String name,@FormParam("password") String password){
        System.out.println(name);
        System.out.println(password);
        File file  = new File("C:/Users/soft01/ck/abc.txt");
        OutputStreamWriter osw;
        PrintWriter pw = null;
       String json = null;
        try {
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bis = new BufferedOutputStream(fos);
            osw = new OutputStreamWriter(bis);
            pw = new PrintWriter(osw,true);
            System.out.println(password);
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            json = JSON.toJSONString(user);
            System.out.println(json);
            pw.println(json);
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }finally {
            pw.close();
        }
        return json;
    }

}
