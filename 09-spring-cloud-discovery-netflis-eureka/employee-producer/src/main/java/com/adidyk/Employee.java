package com.adidyk;

/**
 * Class Employee.
 */
public class Employee {
    /**
     * @param epmId - employee id.
     */
    private String empId;

    /**
     * @param name - employee name.
     */
    private String name;

    /**
     * @param designation - designation employee.
     */
    private String designation;

    /**
     * @param salary - employee salary.
     */
    private double salary;

    /**
     * Employee - constructor.
     */
    public Employee() {

    }

    /**
     * getName - get name.
     * @return - get name.
     */
    public String getName() {
        return name;
    }

    /**
     * setName - set name.
     * @param name - name employee.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getDesignation - get designation.
     * @return - get designation.
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * setDesignation - set designation.
     * @param designation - designation.
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * getSalary - get salary.
     * @return - get salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * setSalary - set salary.
     * @param salary - salary.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * getEpmId - get employee id.
     * @return - get employee id.
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * setEpmId - set employee id.
     * @param empId - set employee id.
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

}