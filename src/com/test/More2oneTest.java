package com.test;

import com.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by byebyejude on 2017/9/17.
 */
public class More2oneTest {
      public static void main(String[]args) throws IOException{
          String source = "resource/mybatis-config.xml";
          InputStream inputStream = Resources.getResourceAsStream(source);
          SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
          SqlSession session =  sqlSessionFactory.openSession();
//          System.out.println("********查询所有的*****");
//          //查询所有的
//          List<Product> ps = session.selectList("listProductAll");
//          for (Product p:ps
//               ) {
//              System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
//          }
//
          System.out.println("********模糊查询*****");
          //模糊查询
          Map<String,String> m = new HashMap();
          m.put("name","a");
          List<Product> px = session.selectList("listProductByName",m);
          for (Product p:px
                  ) {
              System.out.println(p);
          }
//
//          System.out.println("********if 标签*****");
//          Map arg = new HashMap();
//           arg.put("name","a");
//        //  arg.put("price","88.88");
//          List<Product> pc = session.selectList("listProductAll",arg);
//          for (Product p:pc
//                  ) {
//              System.out.println(p);
//          }

//          List<Integer>ids = new ArrayList();
//          ids.add(1);
//          ids.add(3);
//          ids.add(5);
//
//          List<Product>ps = session.selectList("listProductAll",ids);
//          for (Product p:ps
//                  ) {
//              System.out.println(p);
//          }
      }
}
