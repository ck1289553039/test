package ck.demo02;

import ck.demo.Demo01;
import ck.demo.User;
import com.alibaba.fastjson.JSON;

import javax.ws.rs.*;
import java.io.*;

/**
 * Created by soft01 on 2017/5/3.
 */

@Path( "Test" )
public class Test02 {
        Test test = new Test();
        @GET
        @Produces("application/json")
        public String get(@QueryParam("name") String name, @QueryParam("password") String password) throws IOException {
            File file  = new File("C:/Users/soft01/ck/abc.txt");
            OutputStreamWriter osw;
            PrintWriter pw = null;
            String json = null;
            try {
                FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bis = new BufferedOutputStream(fos);
                osw = new OutputStreamWriter(bis);
                pw = new PrintWriter(osw,true);
                User user = new User();
                user.setName(name);
                user.setPassword(password);
                json = JSON.toJSONString(user);
                System.out.println(json);
                pw.println(json);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            read();
            String jsonStr = JSON.toJSONString( test );
            return jsonStr;
        }

        @POST
        @Produces("application/json")
        @Consumes("application/x-www-form-urlencoded")
        public String post(@FormParam("name") String name, @FormParam("password") String password) throws IOException {
            read();
            String jsonStr = JSON.toJSONString( test );
            return jsonStr;
        }


        public String read() {
            File file = new File("C:/Users/soft01/ck/abc.txt");
            FileInputStream fos = null;
            BufferedInputStream bis;
            BufferedReader br;
            String json= null;
            try {
                fos = new FileInputStream( file );
                bis = new BufferedInputStream( fos );
                InputStreamReader isr = new InputStreamReader( bis );
                br = new BufferedReader( isr );
                String s;
                System.out.println( 1 );
                while ((s = br.readLine()) != null) {
                    User users = JSON.parseObject( s, User.class );
                    test.addUser(users);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return json;
        }

    }

