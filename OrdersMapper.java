package com.hexaware.MLP156.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import com.hexaware.MLP156.model.Orders;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

/**
 * OrdersMapper class used to fetch orders data from database.
 * @author hexware
 */
public class OrdersMapper implements ResultSetMapper<Orders> {
  private Orders ord;
  /**
   * @param idx the index
   * @param rs  the resultset
   * @param ctx the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the
   *                      resultset
   */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    int ordId = rs.getInt("ORD_ID");
    int empId = rs.getInt("EMPLOYEE_ID");
    int foodId = rs.getInt("FOOD_ID");
    String ordItem = rs.getString("ORD_ITEM");
    String ordQty = rs.getString("ORD_QTY");
    int ordAmnt = rs.getInt("ORD_TAMT");
    String ordDate = rs.getString("ORD_DATE_TIME");
    String ordEst = rs.getString("ORD_EST_TIME");
    String ordStat = rs.getString("ORD_STATUS");
    String ordMsg = rs.getString("ORD_MSG");
    int ordRat = rs.getInt("RATING");
    try {
      ord = new Orders(ordId, empId, foodId, ordItem, ordQty, ordAmnt, ordDate, ordEst, ordStat, ordMsg, ordRat);
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return ord;
    //return new Orders(rs.getInt("food_id"));
  }
}
