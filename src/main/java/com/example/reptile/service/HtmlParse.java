package com.example.reptile.service;

import com.example.reptile.pojo.Lottery;

import java.io.IOException;
import java.util.List;

public interface HtmlParse {
    public List<Lottery> parseBidding(Lottery lottery) throws IOException;
}
