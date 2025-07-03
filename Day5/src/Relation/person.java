package Relation;

public class person{

		 private String name;
	     private int  mobileno;
	     
		 public String getName() {
			 return name;
		 }
		 public void setName(String name) {
			 this.name = name;
		 }
		 public int getMobileno() {
			 return mobileno;
		 }
		 public void setMobileno(int mobileno) {
			 this.mobileno = mobileno;
		 }
		 
		 public person(String name, int mobileno) {
			super();
			this.name = name;
			this.mobileno = mobileno;
		 }
		 
		 public void display()
		 {
			 System.out.print("name-");
			 System.out.println(name);
			 System.out.print("mobile- ");
			 System.out.println(mobileno);
			 
		 }
	     
	     
	}


