package com.test;

import com.pojo.Order;
import com.pojo.OrderItem;
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
public class More2MoreTest {
    public static void main(String[]args) throws IOException{
        String source = "resource/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session =  sqlSessionFactory.openSession();

     //  addOrderItem(session);
       //deleteOderItem(session);
     //deleteWholeOrder(session,1);
        listOrder(session);

    }
    public static void listOrder(SqlSession session){
        List<Order> os = session.selectList("listOrder");
        for (Order o:os
             ) {
               System.out.println(o.getCode());
            for (OrderItem oi:o.getOis()
                 ) {
                System.out.format("\t%s\t%f\t%d%n", oi.getProduct().getName(),oi.getProduct().getPrice(),oi.getNumber());
            }
        }
    }

    public static void addOrderItem(SqlSession session){
           Order o1 = session.selectOne("getOrder",2);
           Product p6 = session.selectOne("getProduct",6);
           OrderItem oinew = new OrderItem();
           oinew.setOrder(o1);
           oinew.setProduct(p6);
           oinew.setNumber(300);
           session.insert("addOrderItem",oinew);

    }
     //将组成中间表的项查出来，组成要删除的中间表，再对起进行删除
    public static void deleteOderItem(SqlSession session,int OrderId,int productId){
            Order o1 = session.selectOne("getOrder",OrderId);
            Product p6 = session.selectOne("getProduct",productId);
            OrderItem oidel = new OrderItem();
            oidel.setOrder(o1);
            oidel.setProduct(p6);
            session.delete("deleteOrderItem",oidel);

    }

    public static void deleteWholeOrder(SqlSession session,int id ){
          Order o1del = session.selectOne("getOrder",id);
          List<OrderItem> oiWitho1del = o1del.getOis();

        for (OrderItem o:oiWitho1del
             ) {
                 System.out.println(o.getOrder()+"+++++++++++"+o.getProduct()+"++++++++"+o.getNumber());
                 deleteOderItem(session,id,o.getProduct().getId());
        }
           session.delete("deleteOrder",id);



    }
}
