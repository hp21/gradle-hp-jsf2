package org.hp;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

/**
 * Created by U292148 on 2014.09.26..
 */
@ManagedBean(name = "hp")
public class HP implements Serializable {

    @ManagedProperty( value = "#{hp1}")
    private HP1 hp1;

    public HP() {
        System.out.println(this.getClass().toString() + " instantiated.");
    }

    public Double zzz() {
        return hp1.interestRate();
    }

    public String date() {
        return ISODateTimeFormat.dateTime().print(DateTime.now());
    }

    public void setHp1(HP1 hp1) {
        this.hp1 = hp1;
    }
}
