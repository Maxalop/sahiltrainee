package com.hexaware.MLP156.factory;

import com.hexaware.MLP156.persistence.OrdersDAO;
import com.hexaware.MLP156.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP156.model.Menu;
import com.hexaware.MLP156.model.Orders;
/**
 * OrdersFactory class used to fetch Orders data from database.
 * @author hexware
 */
public class OrdersFactory {
  /**
   *  Protected constructor.
   */
  protected OrdersFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   */
  public static Orders[] showOrders() {
    List<Orders> orders = dao().show();
    return orders.toArray(new Orders[orders.size()]);
  }
  /**
   * @param vId vendor id.
   * @return orders.
   */
  public static Orders[] getOrders(final int vId) {
    List<Orders> ord = dao().getAllPlacedOrders(vId);
    return ord.toArray(new Orders[ord.size()]);
  }
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param vId vendor id
   */
  public static Orders getvalidateOrders(final int vId) {
    OrdersDAO oDAo = dao();
    Orders ore = oDAo.validategetOrders(vId);
    return ore;
  }
  /**
   * Call the data base connection.
   * @return the accepted order.
   * @param id give order id.
   */
  public static int acceptOrders(final int id) {
    OrdersDAO oDAO = dao();
    int val = oDAO.acceptOrderGivenId(id);
    return val;
  }
  /**
   * Call the data base connection.
   * @return the rejected order.
   * @param id give order id.
   * @param msg message
   */
  public static int rejectOrders(final int id, final String msg) {
    OrdersDAO oDAO = dao();
    int val = oDAO.rejectOrderGivenId(id, msg);
    return val;
  }
   /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param empID employee id.
   * @param ord menu.
   * @param qty Quantity.
   * @param sum Sum of amount.
   * @param orderststus Orderstatus.
   */
  public static int insertIntoOrder(final int empID, final Menu ord, final int qty, final Double sum, final String orderststus) {
    OrdersDAO oDao = dao();
    int menuID = ord.getFoodId();
    String menuName = ord.getFoodName();
    int ord1 = oDao.insertOrder(empID, menuID, menuName, qty, sum, orderststus);
    return ord1;
  }
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param a the array of orders object.
   */
  public static  Orders[] vendororderhistory(final int a) {
    List<Orders> ord = dao().vendororderhistory(a);
    return ord.toArray(new Orders[ord.size()]);
  }
  /**
   * Call the data base connection.
   * @return the array of Orders object.
   * @param a the array of orders object.
   */
  public static  Orders[] employeeorderhistory(final int a) {
    List<Orders> ord1 = dao().employeeorderhistory(a);
    return ord1.toArray(new Orders[ord1.size()]);
  }
  /**
   * @param ordid order id
   * @return order details
   */
  public static Orders getOrderdetails(final int ordid) {
    OrdersDAO oDao = dao();
    Orders val = oDao.getIdGivenOrderDetails(ordid);
    return val;
  }
}
