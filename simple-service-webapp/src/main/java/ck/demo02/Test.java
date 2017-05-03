package ck.demo02;

import ck.demo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by soft01 on 2017/5/3.
 */
public class Test {
    private String state;
    private List<User> result = new ArrayList<User>();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }

    public void addUser(User user) {
        result.add(user);
    }


}
