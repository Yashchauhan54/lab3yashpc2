package org.example.hrmanagementyash;

public class employee{
        private int employeeId;
        private String employeeName;
        private String phone ;
        private String salary;

        public int getEmployeeId() {
                return employeeId;
        }

        public void setEmployeeId(int employeeId) {
                this.employeeId = employeeId;
        }

        public String getEmployeeName() {
                return employeeName;
        }

        public void setEmployeeName(String employeeName) {
                this.employeeName = employeeName;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getSalary() {
                return salary;
        }

        public void setSalary(String salary) {
                this.salary = salary;
        }

        public employee(int employeeId, String employeeName, String phone, String salary) {
                this.employeeId = employeeId;
                this.employeeName = employeeName;
                this.phone = phone;
                this.salary = salary;
        }
}
