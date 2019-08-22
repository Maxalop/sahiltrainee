package com.hexaware.MLP156.model;
import java.util.Objects;

/**
 * Employee class used to display employee information.
 * @author hexware
 */
public class Employee {
/**
 * empId to store Employee Id.
 * empName to store Employee name.
 * empUserName to store Employee username.
 * empPwd to store Employee Password.
 * empEmailId to store Employee Email Id
 * empMobileNo to store Employee Mobile number.
 * empAdd to store Employee address.
 * empWlt to store Employee Wallet balance.
 */
  private int empId;
  private String empName;
  private String empUserName;
  private String empPwd;
  private String empEmailId;
  private String empMobileNo;
  private String empAdd;
  private double empWlt;
  /**
   * Default Constructor.
   */
  public Employee() {

  }
 /**
   * @param argEmpId       to intialize employee id.
   * @param argEmpName     to intialize employee name.
   * @param argEmpUserName to intialize employee username.
   * @param argEmpPwd      to intialize employee password.
   * @param argEmpEmailId  to intialize employee email id.
   * @param argEmpMobileNo to intialize employee mobile number.
   * @param argEmpAdd      to intialize employee address.
   * @param argEmpWlt      to intialize employee wallet balance. used to get
   *                       details through constructor.
   */
  public Employee(final int argEmpId, final String argEmpName, final String argEmpUserName,
                final String argEmpPwd, final String argEmpEmailId, final String argEmpMobileNo,
                final String argEmpAdd, final double argEmpWlt) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empUserName = argEmpUserName;
    this.empPwd = argEmpPwd;
    this.empEmailId = argEmpEmailId;
    this.empMobileNo = argEmpMobileNo;
    this.empAdd = argEmpAdd;
    this.empWlt = argEmpWlt;
  }

  @Override
  public final boolean equals(final Object obj) {

    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId) && Objects.equals(empName, emp.empName)
        && Objects.equals(empUserName, emp.empUserName) && Objects.equals(empPwd, emp.empPwd)
        && Objects.equals(empEmailId, emp.empEmailId) && Objects.equals(empMobileNo, emp.empMobileNo)
        && Objects.equals(empAdd, emp.empAdd) && Objects.equals(empWlt, emp.empWlt)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empUserName, empPwd, empEmailId, empMobileNo, empAdd, empWlt);
  }

  /**
   *@return this employee ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *@param argEmpId gets the employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
/**
   *@return this employee ID.
   */
  public final String getEmpName() {
    return empName;
  }

  /**
   *@param argEmpName gets the employee name.
   */

  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }
/**
   *@return this employee ID.
   */
  public final String getEmpUserName() {
    return empUserName;
  }

  /**
   *@param argEmpUserName gets the employee username.
   */

  public final void setEmpUserName(final String argEmpUserName) {
    this.empUserName = argEmpUserName;
  }
/**
   *@return this employee ID.
   */
  public final String getEmpPwd() {
    return empPwd;
  }

  /**
   *@param argEmpPwd gets the employee password.
   */

  public final void setEmpPwd(final String argEmpPwd) {
    this.empPwd = argEmpPwd;
  }
/**
   *@return this employee ID.
   */
  public final String getEmpEmailId() {
    return empEmailId;
  }

  /**
   *@param argEmpEmailId gets the employee email id.
   */

  public final void setEmpEmailId(final String argEmpEmailId) {
    this.empEmailId = argEmpEmailId;
  }
/**
   *@return this employee ID.
   */
  public final String getEmpMobileNo() {
    return empMobileNo;
  }

  /**
   *@param argEmpMobileNo gets the employee mobile number.
   */

  public final void setEmpMobileNo(final String argEmpMobileNo) {
    this.empMobileNo = argEmpMobileNo;
  }
/**
   *@return this employee ID.
   */
  public final String getEmpAdd() {
    return empAdd;
  }

  /**
   *@param argEmpAdd gets the employee address.
   */

  public final void setEmpAdd(final String argEmpAdd) {
    this.empAdd = argEmpAdd;
  }
/**
   *@return this employee ID.
   */
  public final double getEmpWlt() {
    return empWlt;
  }
  /**
     *@param argEmpWlt gets the employee wallet balance.
     */
  public final void setEmpWlt(final double argEmpWlt) {
    this.empWlt = argEmpWlt;
  }

  @Override
  public final String toString() {
    return "Employee [empAdd=" + empAdd + ", empEmailId=" + empEmailId + ", empId=" + empId + ", empMobileNo="
        + empMobileNo + ", empName=" + empName + ", empPwd=" + empPwd + ", empUserName=" + empUserName + ", empWlt="
        + empWlt + "]";
  }
}
