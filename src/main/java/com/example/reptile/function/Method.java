package com.example.reptile.function;

import com.example.reptile.utils.HtmlParseUtil;
import java.io.IOException;

public class Method {
    public void method1() throws IOException {
        for (int i = 0; i < 226; i += 50) {
            HtmlParseUtil.Method(i);
        }
    }
    public void method2() throws IOException {
        for (int i = 25;i<226;i += 50) {
            HtmlParseUtil.Method(i);
        }
    }
}
