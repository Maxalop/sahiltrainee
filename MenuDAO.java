package com.hexaware.MLP156.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.MLP156.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Menu")
    @Mapper(MenuMapper.class)
    List<Menu> show();
  /**
  * @return validate menu id
  * @param id menu id
  */
  @SqlQuery("SELECT * FROM MENU WHERE FOOD_ID= :id")
  @Mapper(MenuMapper.class)
  Menu validateMenuId(@Bind("id") int id);
}
