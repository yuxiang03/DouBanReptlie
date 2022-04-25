package com.example.reptile.domain;

import com.example.reptile.Runnable.MyRunnable;
import com.example.reptile.function.Method;

import java.io.IOException;

public class DouBan {
    public static void main(String[] args) throws IOException {
        Runnable target = new MyRunnable();
        Thread t = new Thread(target);
        t.start();
        Method method = new Method();
        method.method2();
    }
}
