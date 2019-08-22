package com.hexaware.MLP156.persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.MLP156.model.Menu;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class MenuMapper implements ResultSetMapper<Menu> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final Menu map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    /**
     * @return Menu
     */
    int id = rs.getInt("FOOD_ID");
    String foodName = rs.getString("FOOD_NAME");
    int venId = rs.getInt("VENDOR_ID");
    String fType = rs.getString("FOOD_TYPE");
    String calories = rs.getString("CALORIES");
    double amt = rs.getDouble("FOOD_AMT");

    Menu mnu = new Menu(id, foodName, venId, fType, calories, amt);
    return mnu;
  //return new Menu(rs.getInt("food_id"));
  }
}
