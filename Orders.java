package com.hexaware.MLP156.model;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Orders {
/**
 * ordId to store ordId.
 */
  private int ordId;
  private int empId;
  private int foodId;
  private String ordItem;
  private String ordQty;
  private int ordAmnt;
  private Date ordDate;
  private String ordEst;
  private String ordMsg;
  private String ordStat;
  private int ordRat;
  /**
   * Default Constructor.
   */
  public Orders() {

  }
/**
 * @param argordId to initialize food id.
   @param argempId to get employee id.
   @param argfoodId to get menu id.
   @param argordItem to initialize order item.
   @param argordQty to initialize order quantity.
   @param argordAmnt to initialize order amount.
   @param argordDate to initialize order date and time.
   @param argordEst to initialize estimated time.
   @param argordMsg to initialize order message.
   @param argordStat to initialize order status.
   @param argordRat to intialize order rating.
   @throws ParseException exception
    * used to get details through constructor.
 */
  public Orders(final int argordId, final int argempId, final int argfoodId, final String argordItem, final String argordQty,
                final int argordAmnt, final String argordDate,
                final String argordEst, final String argordMsg,
                final String argordStat, final int argordRat) throws ParseException {
    this.ordId = argordId;
    this.empId = argempId;
    this.foodId = argfoodId;
    this.ordItem = argordItem;
    this.ordQty = argordQty;
    this.ordAmnt = argordAmnt;
    String argd = argordDate;
    SimpleDateFormat sg = new SimpleDateFormat("yyyy-MM-dd");
    sg.setLenient(false);
    Date d3 = sg.parse(argd);
    // String d3 = sg.format(d2);
    this.ordDate = d3;
    this.ordEst = argordEst;
    this.ordMsg = argordMsg;
    this.ordStat = argordStat;
    this.ordRat = argordRat;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders odr = (Orders) obj;
    if (Objects.equals(ordId, odr.ordId) && Objects.equals(empId, odr.empId) && Objects.equals(foodId, odr.foodId)
        && Objects.equals(ordItem, odr.ordItem) && Objects.equals(ordQty, odr.ordQty)
        && Objects.equals(ordAmnt, odr.ordAmnt) && Objects.equals(ordDate, odr.ordDate)
        && Objects.equals(ordEst, odr.ordEst) && Objects.equals(ordMsg, odr.ordMsg)
        && Objects.equals(ordStat, odr.ordStat) && Objects.equals(ordRat, odr.ordRat)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(ordId, empId, foodId, ordItem, ordQty, ordAmnt, ordDate, ordEst, ordMsg, ordStat, ordRat);
  }
    /**
     * @return this Orders ID.
     */
  public final int getordId() {
    return ordId;
  }
  /**
     * @return this Employee ID.
     */
  public final int getempId() {
    return empId;
  }
  /**
     * @return this Menu ID.
     */
  public final int getfoodId() {
    return foodId;
  }
  /**
     * @return this Order Item.
     */
  public final String getordItem() {
    return ordItem;
  }
  /**
     * @return this Orders Quantity.
     */
  public final String getordQty() {
    return ordQty;
  }
  /**
     * @return this Orders Amount.
     */
  public final int getordAmnt() {
    return ordAmnt;
  }
  /**
     * @return this Orders Date.
     */
  public final Date getordDate() {
    // Date d1 = new Date( ordDate.getTime());
    // return d1;
    return ordDate;
  }
  /**
     * @return this Orders Estimated Time.
     */
  public final String getordEst() {
    return ordEst;
  }
  /**
     * @return this Orders Message.
     */
  public final String getordMsg() {
    return ordMsg;
  }
  /**
     * @return this Orders status.
     */
  public final String getordStat() {
    return ordStat;
  }
  /**
     *@return this Orders Rating.
     */
  public final int getordRat() {
    return ordRat;
  }
    /**
     *@param argordId gets the Orders id.
     */
  public final void setordId(final int argordId) {
    this.ordId = argordId;
  }
   /**
     *@param argempId gets the Employee id.
     */
  public final void setempId(final int argempId) {
    this.empId = argempId;
  }
   /**
     *@param argfoodId gets the Menu id.
     */
  public final void setfoodId(final int argfoodId) {
    this.foodId = argfoodId;
  }
   /**
     *@param argordItem gets the Orders Item.
     */
  public final void setordItem(final String argordItem) {
    this.ordItem = argordItem;
  }
   /**
     *@param argordQty gets the Orders Quantity.
     */
  public final void setordQty(final String argordQty) {
    this.ordQty = argordQty;
  }
   /**
     * @param argordAmnt gets the Orders Amount.
     */
  public final void setordAmnt(final int argordAmnt) {
    this.ordAmnt = argordAmnt;
  }
   /**
   * @param argordDate gets the Orders Date.
     */
  public final void setordDate(final Date argordDate) {
    Date d1 = new Date(argordDate.getTime());
    this.ordDate = d1;
  }
   /**
     * @param argordEst gets the Orders Estimate Time.
     */
  public final void setordEst(final String argordEst) {
    this.ordEst = argordEst;
  }
   /**
     * @param argordMsg gets the Orders Messages.
  */
  public final void setordMsg(final String argordMsg) {
    this.ordMsg = argordMsg;
  }
   /**
     *@param argordStat gets the Orders status.
     */
  public final void setordStat(final String argordStat) {
    this.ordStat = argordStat;
  }
  /**
  * @param argordRat gets the Orders Rating.
  */
  public final void setordRat(final int argordRat) {
    this.ordRat = argordRat;
  }

  @Override
  public final String toString() {
    return "Orders [empId=" + empId + ", foodId=" + foodId + ", ordAmnt=" + ordAmnt + ", ordDate=" + ordDate
        + ", ordEst=" + ordEst + ", ordId=" + ordId + ", ordItem=" + ordItem + ", ordMsg=" + ordMsg + ", ordQty="
        + ordQty + ", ordRat=" + ordRat + ", ordStat=" + ordStat + "]";
  }

}
