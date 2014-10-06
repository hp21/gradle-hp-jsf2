package org.hp;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 * Created by U292148 on 2014.10.06..
 */
@ManagedBean(name = "vbean")
public class VBean implements Serializable {

    String username = "a";


    public String doit() {
        return "opt-valid-next-page";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
