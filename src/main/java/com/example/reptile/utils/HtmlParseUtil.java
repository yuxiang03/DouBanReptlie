package com.example.reptile.utils;

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

public class HtmlParseUtil {
    public static void Method(int i) throws IOException {
        String url = "https://movie.douban.com/top250?start=" + i + "&filter=";
        Document document = Jsoup.parse(new URL(url), 10000);
        Element content = document.getElementById("wrapper");
        Elements imgs = content.getElementsByTag("img");

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);  //true表示自动提交事务

        //获取Mapper接口的代理对象
        HtmlParseMapper htmlParseMapper = sqlSession.getMapper(HtmlParseMapper.class);

        Lottery lottery = new Lottery();

        for (Element img : imgs) {
            String src = img.attr("src");
            String alt = img.attr("alt");
            if (src.length() == 110) {
 //将https://img3.doubanio.com/f/movie/a02f6ed325fc52e220f299d51e730c422e2bcd16/pics/movie/douban_app_ad/qrcode.png排除
                break;
            } else {
                lottery.setVideoName(alt);
                lottery.setAddress(src);
            }
            htmlParseMapper.parseBidding(lottery);
        }

        System.out.println(lottery.getId());
        //5.释放资源
        sqlSession.close();
    }
}
