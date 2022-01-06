package com.cognizant.customer.beans;

public class Register {
        private String name;
        private String emailid;
        private String phoneNumber;
        private String password;
        private int customerid;
       
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmailid() {
			return emailid;
		}
		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getCustomerid() {
			return customerid;
		}
		public void setCustomerid(int customerid) {
			this.customerid = customerid;
		}
		@Override
		public String toString() {
			return "Register [name=" + name + ", emailid=" + emailid + ", phoneNumber=" + phoneNumber 
					 + ", customerid=" + customerid + "]"+"\n";
		}
        
}
