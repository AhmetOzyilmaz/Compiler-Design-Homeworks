package com.company;

import java.util.Vector;

/**
 * Created by ASUS on 6.05.2017.
 */


public class register {
    private Vector<mmry>reg;

    public register() {
        mmry temp = new mmry();
        for (int i = 0; i <8 ; i++)
            temp.index = i;
            temp.value = 0;
            reg.add(temp);
    }

    public register(Vector<mmry> data) {

        reg = data;
    };



}
