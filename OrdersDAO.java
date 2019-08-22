package com.hexaware.MLP156.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP156.model.Orders;
/**
 * OrdersDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrdersDAO {
    /**
     * @return the all the Orders record.
     */
  @SqlQuery("Select * from Orders")
    @Mapper(OrdersMapper.class)
    List<Orders> show();

   /**
   * @return the all the placed Orders record.
   * @param vId vendor Id
   */
  @SqlQuery("SELECT * from Orders o,Menu m where o.FOOD_ID=m.FOOD_ID and ORD_STATUS='PLACED' and m.VENDOR_ID=:vId")
     @Mapper(OrdersMapper.class)
     List<Orders> getAllPlacedOrders(@Bind("vId") final int vId);
    /**
     * @return the all the placed Orders record.
     * @param vId vendor id
     */
  @SqlQuery("SELECT * from Orders o,Menu m where o.FOOD_ID=m.FOOD_ID and ORD_STATUS='PLACED' and m.VENDOR_ID=:vId")
     @Mapper(OrdersMapper.class)
     Orders validategetOrders(@Bind("vId") int vId);
    /**
     * @return the accepted order
     * @param id to get orderid
     */
  @SqlUpdate("Update Orders set ORD_STATUS='ACCEPTED' where ORD_ID=:id")
    int acceptOrderGivenId(@Bind("id") int id);
    /**
     * @return the rejected order
     * @param id to get orderid
     * @param msg message
     */
  @SqlUpdate("Update Orders set ORD_STATUS='CANCELLED',ORD_MSG= :msg where ORD_ID=:id")
    int rejectOrderGivenId(@Bind("id") int id, @Bind("msg") String msg);
   /**
   * @param empID employee id
   * @param foodID food id
   * @param ordItem ordered item
   * @param ordQty ordered quantity
   * @param ordTmt ordered total amount
   * @param ordStatus order status
   * @return insert into orders
   */
  @SqlUpdate("insert into ORDERS(EMPLOYEE_ID, FOOD_ID, ORD_ITEM, ORD_QTY, ORD_TAMT, ORD_STATUS)"
      + "values(:empID, :foodID, :ordItem, :ordQty, :ordTmt, :ordStatus)")
    int insertOrder(@Bind("empID") int empID,
                        @Bind("foodID") int foodID,
                        @Bind("ordItem") String ordItem,
                        @Bind("ordQty") int ordQty,
                        @Bind("ordTmt") double ordTmt,
                        @Bind("ordStatus") String ordStatus);

   /**
     * @param eid the all the history.
     * @return the all the Orders record.
     */
  @SqlQuery("select * from Orders where EMPLOYEE_ID= :empID ")
    @Mapper(OrdersMapper.class)
    List<Orders> employeeorderhistory(@Bind("empID") int eid);
   /**
     * @param venID the all the history.
     * @return the all the Orders record.
     */
  @SqlQuery("select o.* from Orders o join menu m on o.FOOD_ID=m.FOOD_ID where m.VENDOR_ID = :venID")
    @Mapper(OrdersMapper.class)
    List<Orders> vendororderhistory(@Bind("venID") int venID);
   /**
    * @param ordId order id
    * @return order details
    */
  @SqlQuery("SELECT * from Orders  where ORD_ID=:ordId")
    @Mapper(OrdersMapper.class)
    Orders getIdGivenOrderDetails(@Bind("ordId") int ordId);
}
