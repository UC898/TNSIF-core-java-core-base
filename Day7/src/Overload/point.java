package Overload;

//constructor overloading 
public class point {

	private float x;
	private float y;
	
	
	public point()
	{
		x=0.0f;
		y=0.0f;
	}


	public point(float x) {
		this.x = x; 
		this.y = y;
	}


	public point(float x, float y) {
		this.x = x;
		this.y = y;
	}


	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
	
}