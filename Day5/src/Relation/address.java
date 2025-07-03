package Relation;

public class address {
       public String street;
       public String city;
       public int pincode;
       
	   public address(String street, String city, int pincode) {
		super();
		this.street = street;
		this.city = city;
		this.pincode = pincode;
	   }

	   public String getStreet() {
		   return street;
	   }

	   public void setStreet(String street) {
		   this.street = street;
	   }

	   public String getCity() {
		   return city;
	   }

	   public void setCity(String city) {
		   this.city = city;
	   }

	   public int getPincode() {
		   return pincode;
	   }

	   public void setPincode(int pincode) {
		   this.pincode = pincode;
	   }
	   
       
}