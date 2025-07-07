package Overload;

public class overloading {

	public static void main(String[] args) {
		
		point p= new point(); // default
		System.out.println(p);
		
		point p1=new point(20.09f, 23.45f);
		System.out.println(p1);
		
		System.out.println("---Method Overloading---");
		System.out.println(methodoverloading.addition(3.14f, 23.67f));
		System.out.println(methodoverloading.addition(1, 2, 3));

	}

}