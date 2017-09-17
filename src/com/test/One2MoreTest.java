package com.test;

import com.pojo.Category;
import com.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by byebyejude on 2017/9/17.
 */
public class One2MoreTest {

    public static void main(String[]args) throws IOException{
        String source = "resource/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session =  sqlSessionFactory.openSession();
        List<Category> cs = session.selectList("listCategory");
        for (Category c:cs
             ) {
            System.out.println(c);
            for (Product p:c.getProducts()
                 ) {
                System.out.println(p);
            }
        }

    }
}
