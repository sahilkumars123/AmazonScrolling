package amazon;

public class DemoAmazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
      Amazon az = new Amazon();
      az.invokeBrowser();
      String result = az.searchProduct("apple watch", "Electronics");
      System.out.println("Search Results are : "+result);
     // az.getNthProductInfo(15);
      az.getAllProductInfo();
      //az.getAllProductInfoViaScrollDown();
		/*
		 * int lastProduct = az.getAllProductInfo();
		 * System.out.println("Last Product Number is :: "+lastProduct);
		 * //az.getNthProductInfo(lastProduct);
		 */      
      
	}

}
