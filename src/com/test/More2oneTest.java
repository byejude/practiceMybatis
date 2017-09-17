package com.test;

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
public class More2oneTest {
      public static void main(String[]args) throws IOException{
          String source = "resource/mybatis-config.xml";
          InputStream inputStream = Resources.getResourceAsStream(source);
          SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
          SqlSession session =  sqlSessionFactory.openSession();
          List<Product> ps = session.selectList("listProduct");
          for (Product p:ps
               ) {
              System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
          }
      }
}
