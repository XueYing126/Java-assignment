package factory;
import factory.models.Kid;
import factory.models.Product;
import factory.models.OompaLoompa;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;
import java.lang.NullPointerException;
public class Register_sale {
    
    public static void main(String [] args)throws FileNotFoundException{
		
	Scanner scanner = new Scanner(System.in);
	
	//All the products should be registered in a list :
	File file = new File("Product_registration.txt");
	Scanner input = new Scanner(file); 
	ArrayList<Product> products = new ArrayList<>();
		while (input.hasNext()) {
			 String description = input.next();
			 long barcode = input.nextInt();
			 String serialNumber = input.next();
			 Product p = new Product(description,barcode,serialNumber);
			 products.add(p);
			}
	

	//All beings that enter the factory must be registered:
	ArrayList<Kid> kids = new ArrayList<Kid>(); 
	Kid k1 = new Kid("Yuki","123");   kids.add(k1);
	Kid k2 = new Kid("Alice","234");  kids.add(k2);
	Kid k3 = new Kid("Amy","345");    kids.add(k3);
	Kid k4 = new Kid("Jack","456");   kids.add(k4);
	Kid k5 = new Kid("Tonny","567");  kids.add(k5);
	Kid k6 = new Kid("John","678");   kids.add(k6);

	ArrayList<OompaLoompa> OompaLoompas = new ArrayList<OompaLoompa>(); 
	OompaLoompa Op1 = new OompaLoompa("oompa1","00001",52,"Apple"); OompaLoompas.add(Op1);
	OompaLoompa Op2 = new OompaLoompa("oompa2","00002",48,"Apple"); OompaLoompas.add(Op2);
	OompaLoompa Op3 = new OompaLoompa("oompa3","00003",59,"Apple"); OompaLoompas.add(Op3);
	OompaLoompa Op4 = new OompaLoompa("oompa4","00004",62,"Apple"); OompaLoompas.add(Op4);
	OompaLoompa Op5 = new OompaLoompa("oompa5","00005",52,"Apple"); OompaLoompas.add(Op5);
	OompaLoompa Op6 = new OompaLoompa("oompa6","00006",50,"Apple"); OompaLoompas.add(Op6);	
		

	System.out.println("How many GoldenTickets should be created?");
	int num_goldT = scanner.nextInt();
	
	if(num_goldT>Product.numOfProducts()){
		System.out.println("GoldenTickets is more than products.Then Every product has GoldenTicket.");
		num_goldT=Product.numOfProducts();
	}
	Collections.shuffle(products);
	Date d = new Date();
	for(int i=0;i<num_goldT;i++){
		//giving a random code and the current date
			Random rand = new Random();
			int n = rand.nextInt(50) + 1;
			products.get(i).setGoldenTicket(""+n,d);
		}
	//List all prize tickets
	System.out.println("List all prize tickets:");
    for(Product p:products ){
		if(p.hasGoldenTicket()){
			System.out.println(p);
		}
	}
	System.out.println("\n");
	
	int option = 0;
	do{
		       System.out.println("\nSelect : "
				+"\n 1- Register sale \n 0- exit" );
		    
			option = scanner.nextInt();			
			switch(option){
				case 1:
					System.out.println("\nPlease give me the user code.");
					String user_code = scanner.next();
					Boolean existK = false;
					for (int i=0;i<kids.size();i++){
						if (kids.get(i).getCode().equals(user_code)){
							existK=true;
							System.out.println(kids.get(i).getName());
						}
					  }
					if(!existK){
						System.out.println("\nThere is no kid with such code.");
						}
					else{
					
					System.out.println("\nPlease give me the barcode of the product.");
					long product_barcode = scanner.nextLong();
					
					ArrayList<Product> this_kind_products = new ArrayList<>();
					Boolean ExistP = false;
					for (int i=0;i<products.size();i++){						
						if (products.get(i).getBarcode()==(product_barcode)){
							this_kind_products.add(products.get(i));
							ExistP = true;
						}
						
						
					}
					if (!ExistP){ 
					System.out.println("\nThere is no product with such barcode.");
					} else{						
						Collections.shuffle(this_kind_products);
						// it randomly take one product from that barcode 
						Product randomly_product = this_kind_products.get(0);
						products.remove(randomly_product);//removes it from the general list of products.
						System.out.println(randomly_product);
						//adds it to the kids products list
						for (int i=0;i<kids.size();i++){
						if (kids.get(i).getCode().equals(user_code)){
							
							kids.get(i).purchase_a_product(randomly_product);
						}
					  }
						
					}
					}
				
					break;				
				case 0:				
					break;
					
				default:
					System.out.println("wrong option");
			}
		
	}while(option!=0);
	//This goes through all the registered kids and check if they have bought any product with GoldenTicket in it, 
	//if that's the case, it prints out the name of the kid
	
	System.out.println("(List winners)The lucky kids are: ");
	for(int i=0;i<kids.size();i++){
		if(kids.get(i).getGoldenticket()){
			System.out.println(kids.get(i).getName());
		}
	}
	
	
    }
}
