package com.hexaware.MLP156.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.MLP156.model.Employee;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class EmployeeMapper implements ResultSetMapper<Employee> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Employee map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Employee
       */
    int empId = rs.getInt("EMP_ID");
    String empName = rs.getString("EMP_NAME");
    String empUserName = rs.getString("EMP_USERNAME");
    String empPwd = rs.getString("EMP_PWD");
    String empEmailId = rs.getString("EMP_EMAILID");
    String empMobileNo = rs.getString("EMP_MOBILENO");
    String empAdd = rs.getString("EMP_ADD");
    double empWlt = rs.getDouble("EMP_WLT");

    Employee emp = new Employee(empId, empName, empUserName, empPwd, empEmailId, empMobileNo, empAdd, empWlt);
    return emp;
  }
}
