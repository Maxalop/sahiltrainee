package com.hexaware.MLP156.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.hexaware.MLP156.factory.EmployeeFactory;
import com.hexaware.MLP156.factory.VendorFactory;
import com.hexaware.MLP156.factory.MenuFactory;
import com.hexaware.MLP156.factory.OrdersFactory;
import com.hexaware.MLP156.model.Employee;
import com.hexaware.MLP156.model.Menu;
import com.hexaware.MLP156.model.Orders;
import com.hexaware.MLP156.model.Vendor;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("  Canteen Management System  ");
    System.out.println("-----------------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Employee Login");
    System.out.println("3. Vendor Login");
    System.out.println("4. Exit");
    mainMenuDetails();
  }
/**
 * mainMenuDetails method  process the option selected from main menu.
 */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice: ");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullMenu();
          break;
        case 2:
          empLogin();
          break;
        case 3:
          venLogin();
          break;
        case 4:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose appropriate option.");
      }
    }   catch (Exception e) {
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }
/**
 * showFullMenu method  display the menu item stored in database.
 */
  private void showFullMenu() {
    Menu[] menu = MenuFactory.showMenu();
    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
    System.out.println("                                          MENU                                            ");
    System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
    System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s",
                      "FOOD_ID", "FOOD_NAME", "VENDOR_ID", "FOOD_TYPE", "CALORIES", "FOOD_AMT");
    System.out.println();
    for (Menu m : menu) {
      System.out.format("%-15d %-15s %-15d %-15s %-15s %-10.2f", m.getFoodId(), m.getFoodName(), m.getVenId(),
                        m.getFoodType(), m.getCalories(), m.getFoodAmt());
      System.out.println();
    }
  }
  private void empLogin() {
    try {
      System.out.println("Enter Employee UserName: ");
      String eName = option.next();
      System.out.println("Enter Password: ");
      String ePassword = option.next();
      Employee emp = EmployeeFactory.validateLogin(eName, ePassword);
      int eId = emp.getEmpId();
      if (emp == null) {
        System.out.println("Please enter valid details.");
        return;
      } else {
        empMenu(eName, ePassword, eId);
        System.out.println(emp);
        return;
      }
    } catch (Exception e) {
      System.out.println("Enter valid username and password");
    }
  }
  /**
   * @param eName employee name.
   * @param ePassword employee password.
   * @param eId employee id.
   */
  private void empMenu(final String eName, final String ePassword, final int eId) {
    System.out.println("      Employee Page      ");
    System.out.println("-------------------------");
    System.out.println("1. Check Wallet Balanace");
    System.out.println("2. Order History");
    System.out.println("3. Place Order");
    System.out.println("4. Go back to MAIN MENU");
    empMenuDetails(eName, ePassword, eId);
  }
  /**
   * @param eName employee name
   * @param ePassword employee password
   * @param eId employee id
   */
  public void empMenuDetails(final String eName, final String ePassword, final int eId) {
    try {
      System.out.println("Enter your choice: ");
      int empOption = option.nextInt();
      switch (empOption) {
        case 1:
          empWltBal(eId);
          empMenu(eName, ePassword, eId);
          break;
        case 2:
          showOrdersForEmployee(eId);
          break;
        case 3:
          placeOrder(eName, ePassword);
          break;
        case 4:
          mainMenu();
        default:
          System.out.println("Choose an appropriate option.");
      }
    }  catch (Exception e) {
      System.out.println("Enter a valid value.");
    }
    option.nextLine();
    empMenu(eName, ePassword, eId);
  }
  /**
   * @param eId employee id
   */
  private void empWltBal(final int eId) {
    double ebal = EmployeeFactory.empwalletbal(eId);
    System.out.println("Your Wallet Balance is " + ebal);
  }
  /**
   * @param eId employee id.
   */
  public void showOrdersForEmployee(final int eId) {
    Orders[] ven = OrdersFactory.employeeorderhistory(eId);
    System.out.println("- - - - - - - - - - - - - - - - - - - -ORDERS THAT ARE PLACED - - - - - - - - - - - - - - - - - - - - - ");
    System.out.printf("%-5s %-5s %-12s %-12s %-15s %-25s %-30s %-15s",
                        "Order_Id ", "Emp_Id ", "Food_Id ", "Food_Item ", "Order_Qty", "Total_Amount", "Order_Date", "Order_Status");
    System.out.println();
    for (Orders i : ven) {
      SimpleDateFormat sg = new SimpleDateFormat("yyyy-MM-dd");
      sg.setLenient(false);
      String d3 = sg.format(i.getordDate());
      System.out.format("%-10d %-8d %-10d %-15s %-15s %-20d %-34s %-15s", i.getordId(), i.getempId(), i.getfoodId(), i.getordItem(),
          i.getordQty(), i.getordAmnt(), d3, i.getordMsg());
      System.out.println();
    }
  }
  private void venLogin() {
    try {
      System.out.println("Enter Vendor UserName: ");
      String vName = option.next();
      System.out.println("Enter Password: ");
      String vPassword = option.next();
      Vendor ven = VendorFactory.validateVLogin(vName, vPassword);
      int vId = ven.getVendoorId();
      if (ven == null) {
        System.out.println("Please enter valid details");
        return;
      } else {
        venMenu(vName, vId);
        System.out.println(ven);
      }
    } catch (Exception e) {
      System.out.println("Enter a valid username and password");
    }
  }
  /**
   * @param vName vendor name.
   * @param vId vendor id.
   */
  private void venMenu(final String vName, final int vId) {
    System.out.println("      Vendor Page      ");
    System.out.println("-----------------------");
    System.out.println("1. Check Wallet Balance");
    System.out.println("2. Order History");
    System.out.println("3. Order Status");
    System.out.println("4. Go back to MAIN MENU");
    venMenuDetails(vName, vId);
  }
  /**
   * @param vName vendor name.
   * @param vId vendor id.
   */
  private void venMenuDetails(final String vName, final int vId) {
    try {
      System.out.println("Enter your choice: ");
      int venOption = option.nextInt();
      switch (venOption) {
        case 1:
          venWltBal(vId);
          venMenu(vName, vId);
          break;
        case 2:
          showOrdersForVendors(vId);
          break;
        case 3:
          subMenu1(vName, vId);
          break;
        case 4:
          mainMenu();
        default:
          System.out.println("Choose an appropriate option.");
      }
    } catch (Exception e) {
      System.out.println("Enter a valid value");
    }
    option.nextLine();
    venMenu(vName, vId);
  }
  /**
   * @param vName vendor name
   * @param vId vendor id
   */
  private void subMenu1(final String vName, final int vId) {
    System.out.println("Order Status- Accept or Reject order");
    System.out.println("-------------------------------------");
    System.out.println("1. Accept Order");
    System.out.println("2. Reject Order");
    System.out.println("3. Go Back to VENDOR PAGE");
    subMenu1Details(vName, vId);
  }
  /**
   * @param vId vendor id
   */
  public void showOrdersForVendors(final int vId) {
    Orders[] ven = OrdersFactory.vendororderhistory(vId);
    System.out.println("- - - - - - - - - - - - - - - - - - - -ORDERS THAT ARE PLACED - - - - - - - - - - - - - - - - - - - - - ");
    System.out.printf("%-5s %-5s %-12s %-12s %-15s %-25s %-30s %-15s",
                      "Order_Id ", "Emp_Id ", "Food_Id ", "Food_Item ", "Order_Qty", "Total_Amount", "Order_Date", "Order_Status");
    System.out.println();
    for (Orders o : ven) {
      SimpleDateFormat sg = new SimpleDateFormat("yyyy-MM-dd");
      sg.setLenient(false);
      String d3 = sg.format(o.getordDate());
      System.out.format("%-10d %-8d %-10d %-15s %-15s %-15d  %-30s %-15s", o.getordId(), o.getempId(), o.getfoodId(), o.getordItem(),
          o.getordQty(), o.getordAmnt(), d3, o.getordMsg());
      System.out.println();
    }
  }
  /**
   * @param vName vendor name
   * @param vId vendor id
   */
  private void subMenu1Details(final String vName, final int vId) {
    try {
      System.out.println("Enter your choice: ");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          acceptOrd(vId);
          break;
        case 2:
          rejectOrd(vId);
          break;
        case 3:
          venMenu(vName, vId);
        default:
          System.out.println("Choose an appropriate option.");
      }
    } catch (Exception e) {
      System.out.println("Enter a valid value.");
    }
    option.nextLine();
    subMenu1(vName, vId);
  }
  /**
  * showFullMenu method  display the menu item stored in database.
  *@param vId vendor id
  */
  void acceptOrd(final int vId) {
    try {
      Orders emp = OrdersFactory.getvalidateOrders(vId);
      if (emp != null) {
        showPlacedOrders(vId);
        System.out.println("Enter the Order ID to Accept :");
        int ordid = option.nextInt();
        Orders ordd = OrdersFactory.getOrderdetails(ordid);
        double ordamt = ordd.getordAmnt();
        System.out.println("Order amount is: " + ordamt);
        Vendor vend = VendorFactory.venwalletbalnce(vId);
        double ventamt = vend.getVenWallet();
        System.out.println("Vendor wallet is: " + ventamt);
        double vensum = ordamt + ventamt;
        System.out.println("Vendor sum is : " + vensum);
        int venwlt1 = VendorFactory.updatevendorwlt(vend, vensum);
        System.out.println(venwlt1);
        int val = OrdersFactory.acceptOrders(ordid);
        System.out.println("Succes value is :" + val);
        if (val == 1) {
          System.out.println("Accepted the Order");
        //return;
        }
      } else {
        System.out.println("---------No Placed Orders to Accept---------");
      //return;
      }
    } catch (Exception e) {
      System.out.println("Enter a valid Order ID.");
    }
  }
  /**
   * @param vId vendor id
   */
  private void showPlacedOrders(final int vId) {
    Orders[] ord = OrdersFactory.getOrders(vId);
    System.out.println("- - - - - - - - - - - - - - - - - - - -ORDERS THAT ARE PLACED - - - - - - - - - - - - - - - - - - - - - ");
    System.out.printf("%-15s %-15s %-15s %-15s %-15s",
                      "Order_Id ", "Food_Id ", "Ordered_Item ", "Order_Status ", "Order total amount");
    System.out.println();
    for (Orders o : ord) {
      System.out.format("%-15d %-15d %-15s %-15s %-15d", o.getordId(), o.getfoodId(), o.getordItem(), o.getordMsg(), o.getordAmnt());
      System.out.println();
    }
  }
  /**
  * showFullMenu method  display the menu item stored in database.
  *@param vId vendor id
  */
  void rejectOrd(final int vId) {
    try {
      Orders emp1 = OrdersFactory.getvalidateOrders(vId);
      if (emp1 != null) {
        showPlacedOrders(vId);
        System.out.println("Enter the Order ID to Reject :");
        int ordid = option.nextInt();
        Orders ordd1 = OrdersFactory.getOrderdetails(ordid);
        double amt = ordd1.getordAmnt();
        int emId = ordd1.getempId();
        Employee empall = EmployeeFactory.getempdetails(emId);
        double ewlt = empall.getEmpWlt();
        double sumfinal = ewlt + amt;
        int empu = EmployeeFactory.amountUpdate(sumfinal, emId);
        System.out.println(empu);
        System.out.println("Enter the reason to reject: ");
        String msg = option.next() + option.nextLine();
        int val = OrdersFactory.rejectOrders(ordid, msg);
        System.out.println("Succes value is :" + val);
        if (val == 1) {
          System.out.println("Rejected the Order");
        }
      } else {
        System.out.println("---------No Placed Orders to Reject---------");
      }
    } catch (Exception e) {
      System.out.println("Enter a valid order id");
    }
  }
  /**
   * @param eName employe name
   * @param ePassword employee password
   */
  private void placeOrder(final String eName, final String ePassword) {
    showFullMenu();
    System.out.println("Enter Menu ID: ");
    int menuid = option.nextInt();
    Menu ord = MenuFactory.validateMenuId(menuid); // validate the menu
    if (ord == null) {
      System.out.println("Enter a valid food ID");
      return;
    }
    double a = ord.getFoodAmt();
    System.out.println(ord);
    System.out.println("Enter the quantity: ");
    int qty = option.nextInt(); // validate the quantity
    double sum = a * qty;
    System.out.println("The total amount is: " + sum);
    Employee emp = EmployeeFactory.validateWalletdetail(eName, ePassword);
    if (EmployeeFactory.validateWallet(emp, sum)) {
      System.out.println("You have enough amount");
      Double wallet = emp.getEmpWlt();
      Double amount = wallet - sum;
      System.out.println("You have got balance: " + amount);
      int empID = emp.getEmpId();
      int empu = EmployeeFactory.amountUpdate(amount, empID);
      System.out.println(empu);
      String orderststus = "PLACED";
      System.out.println(orderststus);
      int ord1 = OrdersFactory.insertIntoOrder(empID, ord, qty, sum, orderststus);
      System.out.println(ord1);
    } else {
      System.out.println("You dont have enough amount");
    }
  }
/**
 *@param vid gets the vendor id.
 */
  public void venWltBal(final int vid) {
    double vbal = VendorFactory.venwalletbal(vid);
    System.out.println("Your Wallet Balance is " + vbal);
  }
/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
