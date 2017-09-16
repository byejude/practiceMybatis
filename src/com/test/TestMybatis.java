package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.pojo.Category;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by byebyejude on 2017/9/16.
 */
public class TestMybatis {

    public static void main(String[]args) throws IOException{
        String source = "resource/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session =  sqlSessionFactory.openSession();
        List<Category>cs = session.selectList("listCategory");
        for(Category c :cs){
            System.out.println(c.getName());


        }
    }
}
