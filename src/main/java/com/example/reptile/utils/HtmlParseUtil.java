package com.example.reptile.utils;

import com.example.reptile.pojo.Lottery;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HtmlParseUtil {
    public List<Lottery> parseBidding() throws IOException {
        String url = "https://movie.douban.com/top250";
        Document document = Jsoup.parse(new URL(url), 10000);
        Element content = document.getElementById("wrapper");
        Elements imgs = content.getElementsByTag("img");

        List<Lottery> list = new ArrayList<Lottery>();
        for (Element img : imgs) {
            String src = img.attr("src");
            String alt = img.attr("alt");
            Lottery user = new Lottery();
            user.getVideoName(alt);
            user.setAddress(src);
            list.add(user);
        }
        return list;
    }
}
