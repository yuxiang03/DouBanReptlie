package com.example.reptile.Runnable;

import com.example.reptile.function.Method;
import com.example.reptile.mapper.HtmlParseMapper;
import com.example.reptile.pojo.Lottery;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

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
