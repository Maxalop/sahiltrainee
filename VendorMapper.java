package com.hexaware.MLP156.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP156.model.Vendor;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class VendorMapper implements ResultSetMapper<Vendor> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Vendor map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Vendor
       */
    int venId = rs.getInt("VEN_ID");
    String venName = rs.getString("VEN_NAME");
    String venUsername = rs.getString("VEN_USERNAME");
    String venPassword = rs.getString("VEN_PWD");
    String venEmail = rs.getString("VEN_EMAILID");
    String venMobileno = rs.getString("VEN_MOBILENO");
    String venAddress = rs.getString("VEN_ADD");
    double venWallet =  rs.getDouble("VEN_WLT");

    Vendor vnd = new Vendor(venId, venName, venUsername, venPassword, venEmail, venMobileno, venAddress, venWallet);
    return vnd;
  }
}
