package com.example.reptile.Runnable;

import com.example.reptile.function.Method;
import java.io.IOException;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        Method method = new Method();
        try {
            method.method1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
