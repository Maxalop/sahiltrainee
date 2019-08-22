package com.hexaware.MLP156.factory;

import com.hexaware.MLP156.persistence.VendorDAO;
import com.hexaware.MLP156.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLP156.model.Vendor;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   *  Protected constructor.
   */
  protected VendorFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Vendor[] showMenu() {
    List<Vendor> vendor = dao().show();
    return vendor.toArray(new Vendor[vendor.size()]);
  }
/**
 *
 * @param eN gets the vendor username.
 * @param eP gets the vendor password.
 * @return the validation.
 */
  public static Vendor validateVLogin(final String eN, final String eP) {
    VendorDAO vDAO = dao();
    Vendor ven = vDAO.validateVLogin(eN, eP);
    return ven;
  }
/**
 * @param vid gets the vendor id.
 * @return the wallet balance.
 */
  public static double venwalletbal(final int vid) {
    VendorDAO vDAO1 = dao();
    double vwlt = vDAO1.venwalletbal(vid);
    return vwlt;
  }
  /**
   * @param vid vendor id
   * @return vendor
   */
  public static Vendor venwalletbalnce(final int vid) {
    VendorDAO vDAO1 = dao();
    Vendor vwlt = vDAO1.venwalletbalce(vid);
    return vwlt;
  }
  /**
   * @param ven vendor id
   * @param venwlt vendor wallet
   * @return wallet
   */
  public static int updatevendorwlt(final Vendor ven, final Double venwlt) {
    int vId = ven.getVendoorId();
    VendorDAO vDAO1 = dao();
    int vwlt = vDAO1.venwalletupdate(vId, venwlt);
    return vwlt;
  }
}
