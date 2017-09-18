package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
       // SqlSession session =  sessionInit();
//        Category c= new Category();
//        c.setName("new category");
//        System.out.println("*******insert test********");
//        insert(session,c);
//        list(session);
//        session.commit();
//
//
//        System.out.println("*******delete test********");
//        delete(session,3);
//        list(session);
//        session.commit();
//
//        System.out.println("*******selectone test********");
//        System.out .print(selectOne(session,4).getName());
//
//
//        System.out.println("*******update test********");
//        Category c1 = selectOne(session,2);
//        c1.setName("nameupdated");
//        update(session,c1);
//        list(session);
//        session.commit();
//        session.close();

//         System.out.println("******blur select test******");
//          List<Category>cs =  selectByName(session,"Cat");
//        for (Category c:cs) {
//            System.out.println(c.getName());
//        }
//          session.commit();
//          session.close();
//    }
        String source = "resource/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session =  sqlSessionFactory.openSession();
      List<Category>cs =  selectByNameAndId(session,1,"cat");
        for (Category c:cs) {
            System.out.println(c.getName());
        }
          session.commit();
          session.close();

        SqlSession session2 =  sqlSessionFactory.openSession();
        List<Category>cx =  selectByNameAndId(session2,1,"cat");
        for (Category c:cx) {
            System.out.println(c.getName());
        }
        session2.commit();
        session2.close();
    }


    public static SqlSession sessionInit() throws  IOException{
        String source = "resource/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session =  sqlSessionFactory.openSession();
        return  session;

    }

    public static void insert(SqlSession session,Category category){
                  session.insert("addCategory",category);


    }

    public static void list(SqlSession session){

            List<Category>cs = session.selectList("listCategory");
            for(Category c :cs){
                System.out.println(c.getName());
            }

    }

    public static void delete(SqlSession session,int id ){
            session.delete("deleteCategory",id);
    }


    public static Category selectOne(SqlSession session,int id){
        return  session.selectOne("getCategory",id);
    }


    public static void update(SqlSession session,Category category ){

        session.update("updateCategory",category);
    }

    public static List<Category> selectByName(SqlSession session,String name){
        return session.selectList("listCategoryByName",name);

    }

    public static List<Category> selectByNameAndId(SqlSession session,int id,String name){
        Map<String,Object> args= new HashMap<>();
        args.put("id",id);
        args.put("name",name);
       return session.selectList("listCategoryByNameAndId",args);

    }
}
