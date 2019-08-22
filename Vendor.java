package com.hexaware.MLP156.model;
import java.util.Objects;

/**
 * Vendor class used to display vendor information.
 * @author hexware
 */
public class Vendor {
/*
 * venId to store venId.
 */
  private int venId;
  private String venName;
  private String venUsername;
  private String venPassword;
  private String venEmail;
  private String venMobileno;
  private String venAddress;
  private double venWallet;
  /**
   * Default Constructor.
   */
  public Vendor() {
  }

/**
 * @param argvenId  to initialize VendorID attributes.
 * @param argvenName  to initialize Vendorname attributes.
 * @param argvenUsername  to initialize Vendorusername attributes.
 * @param argvenPassword  to initialize Vendorpassowrd attributes.
 * @param argvenEmail to initialize Vendoremail attributes.
 * @param argvenMobileno  to initialize Vendormobile attributes.
 * @param argvenAddress  to initialize Vendoraddress attributes.
 * @param argvenWallet  to initialize Vendorwallet attributes.
 */
  public Vendor(final int argvenId, final String argvenName, final String argvenUsername, final String argvenPassword,
      final String argvenEmail, final String argvenMobileno, final String argvenAddress, final double argvenWallet) {
    this.venId = argvenId;
    this.venName = argvenName;
    this.venUsername = argvenUsername;
    this.venPassword = argvenPassword;
    this.venEmail = argvenEmail;
    this.venMobileno = argvenMobileno;
    this.venAddress = argvenAddress;
    this.venWallet = argvenWallet;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor vendor = (Vendor) obj;
    if (Objects.equals(venId, vendor.venId) && Objects.equals(venName, vendor.venName) && Objects.equals(venUsername, vendor.venUsername)
            && Objects.equals(venPassword, vendor.venPassword) && Objects.equals(venMobileno, vendor.venMobileno)
        && Objects.equals(venAddress, vendor.venAddress) && Objects.equals(venWallet, vendor.venWallet)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(venId, venName, venUsername, venPassword, venMobileno, venAddress, venWallet);
  }
  /**
  *@return this getter.
  */
  public final int getVendoorId() {
    return venId;
  }
  /**
  *@return this getter.
  */
  public final String getVenName() {
    return venName;
  }
  /**
  *@return this getter.
  */
  public final String getVenUsername() {
    return venUsername;
  }
  /**
  *@return this getter.
  */
  public final String getVenPassword() {
    return venPassword;
  }
  /**
  *@return this getter.
  */
  public final String getVenEmail() {
    return venEmail;
  }
  /**
  *@return this getter.
  */
  public final String getVenMobileno() {
    return venMobileno;
  }
  /**
  *@return this getter.
  */
  public final String getVenAddress() {
    return venAddress;
  }
  /**
  *@return this getter.
  */
  public final double getVenWallet() {
    return venWallet;
  }
  /**
  *@param argvenId gets the food id.
  */
  public final void setVendoorId(final int argvenId) {
    this.venId = argvenId;
  }
  /**
  *@param argvenName gets the food id.
  */
  public final void setVenName(final String argvenName) {
    this.venName = argvenName;
  }
  /**
  *@param argvenUsername gets the food id.
  */
  public final void setVenUsername(final String argvenUsername) {
    this.venUsername = argvenUsername;
  }
  /**
  *@param argvenPassword gets the food id.
  */
  public final void setVenPassword(final String argvenPassword) {
    this.venPassword = argvenPassword;
  }
  /**
  *@param argvenEmail gets the food id.
  */
  public final void setVenEmail(final String argvenEmail) {
    this.venEmail = argvenEmail;
  }
  /**
  *@param argvenMobileno gets the food id.
  */
  public final void setVenMobileno(final String argvenMobileno) {
    this.venMobileno = argvenMobileno;
  }
  /**
  *@param argvenAddress gets the food id.
  */
  public final void setVenAddress(final String argvenAddress) {
    this.venAddress = argvenAddress;
  }
  /**
  *@param argvenWallet gets the food id.
  */
  public final void setVenWallet(final double argvenWallet) {
    this.venWallet = argvenWallet;
  }

  @Override
  public final String toString() {
    return "Vendor [venAddress=" + venAddress + ", venEmail=" + venEmail + ", venId=" + venId + ", venMobileno="
        + venMobileno + ", venName=" + venName + ", venPassword=" + venPassword + ", venUsername=" + venUsername
        + ", venWallet=" + venWallet + "]";
  }
}
