package day3;

public class TaxCalculation {
	
	public void calculateTax(person P )
	{
		if (P.getAge() > 65 || P.getGender().equalsIgnoreCase("Female"))
		{
			P.setTax(0);
			System.out.println("Tax is Not Applicable");
		}
		else if (P.getIncome()> 160000 && P.getIncome() <=500000)
				{
			P.setTax((P.getIncome() - 160000 )* 10/100);
				}
		else if (P.getIncome()> 500000 && P.getIncome() <=800000)
		        {
	        P.setTax((P.getIncome() - 500000 )* 30/100 + 34000);
		        }
		else 
                {
            P.setTax((P.getIncome() - 800000 )* 30/100 + 94000);
                }
	}

}
