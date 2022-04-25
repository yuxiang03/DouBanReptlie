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

//优化：1.mybatis plus
// 2. Redis去重（HSETNX）
// 3. 进度条
// 4. 精简线程的重复代码

public class Threadk {

    public static void main(String[] args) throws Exception {

        /*reptileTest2 t = new reptileTest2();
        t.call();*/

        Runnable target = new MyRunnable();
        Thread t = new Thread(target);
        t.start();

        for (int i = 25;i<226;i += 50) {
            String url = "https://movie.douban.com/top250?start="+i+"&filter=";
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
            //4.执行方法


            Lottery lottery = new Lottery();

            for (Element img : imgs) {
                String src = img.attr("src");
                String alt = img.attr("alt");
                if(src.length() == 110){
                    break;
                }else {
                    lottery.setVideoName(alt);
                    lottery.setAddress(src);
                }

                htmlParseMapper.parseBidding(lottery);
            }
            //获取SqlSessionFactory


            System.out.println(lottery.getId());
            //5.释放资源
            sqlSession.close();
        }
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0;i<226;i += 50) {
            String url = "https://movie.douban.com/top250?start="+i+"&filter=";
            Document document = null;
            try {
                document = Jsoup.parse(new URL(url), 10000);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Element content = document.getElementById("wrapper");
            Elements imgs = content.getElementsByTag("img");

            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            //获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession(true);  //true表示自动提交事务

            //获取Mapper接口的代理对象
            HtmlParseMapper htmlParseMapper = sqlSession.getMapper(HtmlParseMapper.class);
            //4.执行方法


            Lottery lottery = new Lottery();

            for (Element img : imgs) {
                String src = img.attr("src");
                String alt = img.attr("alt");
                if(src.length() == 110){
                    break;
                }else{
                    lottery.setVideoName(alt);
                    lottery.setAddress(src);
                }

                htmlParseMapper.parseBidding(lottery);
            }
            //获取SqlSessionFactory


            System.out.println(lottery.getId());
            //5.释放资源
            sqlSession.close();
        }
    }
}
