package com.example.reptile.serviceImpl;

import com.example.reptile.pojo.Lottery;
import com.example.reptile.service.HtmlParse;
import com.example.reptile.utils.HtmlParseUtil;

import java.io.IOException;
import java.util.List;

public class HtmlParseImpl implements HtmlParse {
    @Override
    public List<Lottery> parseBidding(Lottery lottery) throws IOException {
        List<Lottery> list = new HtmlParseUtil().parseBidding();

        return list;
    }
}
