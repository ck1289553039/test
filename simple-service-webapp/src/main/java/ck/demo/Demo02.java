package ck.demo;


import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import java.io.*;

/**
 * Created by soft01 on 2017/5/2.
 */
@Path("Demo02")
public  class Demo02 {
    @GET
    @Produces("application/json")
    public String get(@QueryParam("name") String name,@QueryParam( "password" )String password) {
        File file = new File("C:/Users/soft01/ck/abc.txt");
        BufferedInputStream bis;
        BufferedReader br ;
        String json= null;
        System.out.println(1);
        try {
            FileInputStream fos = new FileInputStream(file);
            bis= new BufferedInputStream( fos );
            InputStreamReader isr = new InputStreamReader(bis);
            br = new BufferedReader(isr);
            String s ;
            System.out.println(1);
            while((s=br.readLine())!=null){
                User user = new User();
                user.setName(name);
                user.setPassword( password );
                System.out.println(user.getName());
                if(name.equals(user.getName())){
                    json = JSON.toJSONString(user);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
