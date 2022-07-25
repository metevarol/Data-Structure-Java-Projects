import java.util.Scanner;

public class Main{

static int customerlog;

public static void main(String [] args)throws RuntimeException{

			Scanner input = new Scanner(System.in);



			int branchArrIndex=0;
			int empArrIndex=0;
			int registeredCustomersIndex=0;

			Company company2 = new Company();

			company2.adminobj.setemployeeId(111);
			company2.adminobj.setpassword("admin");

			company2.adminobj.addBranch(company2);  // COMPANY HAS TWO BRANCH
			company2.adminobj.addBranch(company2);

			company2.adminobj.addEmployee(company2.branchArr[0],company2); //TWO EMPLOYEE ADDED TO BRANCH 1
			company2.adminobj.addEmployee(company2.branchArr[0],company2);

			company2.adminobj.addEmployee(company2.branchArr[1],company2); //TWO EMPLOYEE ADDED TO BRANCH 2
			company2.adminobj.addEmployee(company2.branchArr[1],company2);

			company2.branchArr[0].empArr[0] = new Employee(100,"Flippo","Inzaghi","milano",1); //EMPLOYEE INITIALIZE BRANCH 1
			company2.branchArr[0].empArr[1] = new Employee(200,"Gennaro","Gattuso","milano",1);

			company2.branchArr[1].empArr[0] = new Employee(300,"Kaka","Leite","milano",2); //EMPLOYEE INITIALIZE BRANCH 2
			company2.branchArr[1].empArr[1] = new Employee(400,"Andrea","Pirlo","milano",2);

			Item item1 = new Item("Office Desk",001,"Black");   //ITEMS INITIALIZED
			Item item2 = new Item("Office Desk",002,"Brown");
			Item item3 = new Item("Office Desk",003,"Red");
			Item item4 = new Item("Office Chair",001,"Yellow");
			Item item5 = new Item("Office Chair",002,"Blue");
			Item item6 = new Item("Bookcase",001,"Brown");
			Item item7 = new Item("Bookcase",001,"Yellow");
			Item item8 = new Item("Bookcase",004,"Black");
			Item item9 = new Item("Bookcase",002,"Black");
			Item item10 = new Item("Office Table",005,"Orange");
			Item item11 = new Item("Office Table",002,"Purple");
			Item item12 = new Item("Office Table",003,"Red");
			Item item13 = new Item("Office Table",003,"Blue");
			Item item14 = new Item("Cabinets",002,"Black");
			Item item15 = new Item("Cabinets",002,"Brown");
			Item item16 = new Item("Cabinets",001,"Pink");


			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item1);  //ITEMS ADDED TO BRANCH 1
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item2);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item4);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item5);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item7);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item9);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item10);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item11);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item10);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item11);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item12);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item15);
			company2.branchArr[0].empArr[0].addItem(company2.branchArr[0],item16);

			company2.branchArr[1].empArr[0].addItem(company2.branchArr[1],item3);   //ITEMS ADDED TO BRANCH 2
			company2.branchArr[1].empArr[0].addItem(company2.branchArr[1],item2);
			company2.branchArr[1].empArr[0].addItem(company2.branchArr[1],item5);
			company2.branchArr[1].empArr[0].addItem(company2.branchArr[1],item7);
			company2.branchArr[1].empArr[0].addItem(company2.branchArr[1],item10);
			company2.branchArr[1].empArr[0].addItem(company2.branchArr[1],item11);
			company2.branchArr[1].empArr[0].addItem(company2.branchArr[1],item10);
			company2.branchArr[1].empArr[0].addItem(company2.branchArr[1],item12);
			company2.branchArr[1].empArr[0].addItem(company2.branchArr[1],item14);
			company2.branchArr[1].empArr[0].addItem(company2.branchArr[1],item16);
																					//CUSTOMERS ADDED TO COMPANY..
			Customer customer1 = new Customer("Zinedine","Zidane","zidane10@yahoo.com","halamadrid","344 Madrid,Spain",44235653);
			Customer customer2 = new Customer("Steven","Gerrard","gerrard08@gmail.com","ynwa","431 Glasgow,Scotland",3331125);
			Customer customer3 = new Customer("Lionel","Messi","messi10@yandex.com","cantdelbarca","216 B.Aries,Argentina",6782345);

			company2.branchArr[0].empArr[0].addCustomer(company2,customer1);
			company2.branchArr[0].empArr[0].addCustomer(company2,customer2);
			company2.branchArr[0].empArr[0].addCustomer(company2,customer3);



	int menu;

	while(true){
		System.out.println("--------THE FURNITURE COMPANY AUTOMATION SYSTEM-------\n");
		System.out.println("\t1.Login to Admin Management System");
		System.out.println("\t2.Login to Employee Operation System");
		System.out.println("\t3.Login to Customer Interface");
		System.out.println("\t4.Exit");
		System.out.println("Please choose one:");

		menu = input.nextInt();

		if(menu==1){
			
			int id;
			String password;
			int operation;
			boolean b;
			b = true;

			System.out.println("ADMINSTRATOR MANAGEMENT SYSTEM\n");

			System.out.println("(Admin ID: "+company2.adminobj.getemployeeId()+")");
			System.out.println("(Admin password: "+company2.adminobj.getpassword()+")");

			while(b){
			System.out.println("Login system:");

			System.out.print("ID: ");
			id = input.nextInt();
			input.nextLine();
			System.out.println();

			System.out.print("password: ");
			password = input.nextLine();
			System.out.println();


			if(company2.adminobj.getpassword().equals(password)&&company2.adminobj.getemployeeId()==id){
				System.out.println("Logged in as admin.");
				break;
			}
			else{
				System.out.println("ID or password wrong.");
				}

				}

			while(true){
			System.out.println("\nOPERATIONS:");
			System.out.println("\t1.Add Branch");
			System.out.println("\t2.Add Employee");
			System.out.println("\t3.Print List of Branches");
			System.out.println("\t4.Print List of Employees");
			System.out.println("\t5.See Stocks");
			System.out.println("\t6.Logout system");
			System.out.println("Please choose one:");
			operation = input.nextInt();
			input.nextLine();

			if(operation==1){
				company2.adminobj.addBranch(company2);

				System.out.println("\nBranch added to company successfully.\n");

			}	
			if(operation==2){
				int branch;
				int empid;
				String emppassword;
				String firstname;
				String lastname;


				System.out.println("List of Branches\n");
				for(int i=0;i<company2.numberOfBranch;i++)
				System.out.println((i+1)+"."+"Branch "+(i+1));
				System.out.println("Select branch to add employee:");
				branch = input.nextInt();
				input.nextLine();

				company2.adminobj.addEmployee(company2.branchArr[branch-1],company2);

				System.out.println("Enter ID of Employee:(only numbers)");
				empid = input.nextInt();
				input.nextLine();
				System.out.println("Enter firstname of Employee:");
				firstname = input.nextLine();
				System.out.println("Enter lastname of Employee");
				lastname = input.nextLine();
				System.out.println("Enter password of Employee");
				emppassword = input.nextLine();

				company2.branchArr[branch-1].empArr[company2.branchArr[branch-1].numberOfEmployee-1] = new Employee(empid,firstname,lastname,emppassword,1);

				}
			if(operation==3){
	
				System.out.println("\nList of Branches\n");

				for(int i=0;i<company2.numberOfBranch;i++)
				System.out.println((i+1)+"."+"Branch "+(i+1));
					
				}
			if(operation==4){

				for(int i=0;i<company2.numberOfBranch;i++){
					System.out.println("\nBranch "+(i+1));
					System.out.println();
					System.out.println("ID"+"\t"+"Name"+"\t\t"+"Password");
					for(int j=0;j<company2.branchArr[i].numberOfEmployee;j++){

							System.out.println((j+1)+"."+company2.branchArr[i].empArr[j].getemployeeId()+"\t"+
								company2.branchArr[i].empArr[j].getfirstName()+" "+
								company2.branchArr[i].empArr[j].getlastName()+"\t"+company2.branchArr[i].empArr[j].getpassword());
							
						}
					}
				}	
			if(operation==5){
				company2.registeredCustomers[0].printInventoryAllBranches(company2);
			}
			if(operation==6) break;
			}

			}

		if(menu==2){

			int id;
			String password;
			int operation;
			

			System.out.println("EMPLOYEE MANAGEMENT SYSTEM\n");

			System.out.println("(From registered employee)");
			System.out.println("(Example ID: "+company2.branchArr[0].empArr[0].getemployeeId()+")");
			System.out.println("(Example password: "+company2.branchArr[0].empArr[0].getpassword()+")");
			System.out.println();

			boolean b = true;
			while(b){

			boolean outerbreak1 = false;
			boolean outerbreak2 = false;
			boolean outerbreak3 = false;

			System.out.println("Login system:");

			System.out.print("ID: ");
			id = input.nextInt();
			input.nextLine();
			System.out.println();

			System.out.print("password: ");
			password = input.nextLine();
			System.out.println();
		
			for(int i=0;i<company2.numberOfBranch;i++){

				if(outerbreak1){
					outerbreak2 = true;
					break;
				} 
				for(int j=0;j<company2.branchArr[i].numberOfEmployee;j++){
				if(company2.branchArr[i].empArr[j].getpassword().equals(password)&&company2.branchArr[i].empArr[j].getemployeeId()==id){
					System.out.println("Logged in as Employee.\n");
					outerbreak1 = true;
					break;
						}
					}

				}

			if(outerbreak2) break;

			System.out.println("ID or password wrong.\n");
				
			}
			
			
			while(true){
			System.out.println("OPERATIONS:");
			System.out.println("\t1.Print Inventory List");
			System.out.println("\t2.Print Customers List");
			System.out.println("\t3.Add Item");
			System.out.println("\t4.Remove Item");
			System.out.println("\t5.Add Customer to system");
			System.out.println("\t6.Make Sale");
			System.out.println("\t7.Logout system");
			System.out.println("Please choose one:");

			operation = input.nextInt();
			input.nextLine();

			if(operation==1){

			    for(int i=0;i<company2.numberOfBranch;i++){
				System.out.println("Inventory List of Branch"+" "+(i+1));
				System.out.println();
				company2.branchArr[0].empArr[0].printInventory(company2.branchArr[i]);	
				}
			

				}
			if(operation==2){
		
				System.out.println("\nList of Customer:");
				System.out.println();
				company2.branchArr[0].empArr[0].printCustomers(company2);	
			

				}
			if(operation==3){

				int branch;
				Item itemforadd = new Item();

				System.out.println("\nList of Branches:");

				for(int i=0;i<company2.numberOfBranch;i++)
				System.out.println((i+1)+"."+"Branch"+" "+(i+1));

				System.out.println("Choose the branch you want to add Item:");
				branch = input.nextInt();
				input.nextLine();

				System.out.println("Enter Category of Item:");
				itemforadd.setCategory(input.nextLine());
				System.out.println("Enter Model No of Item:(only numbers)");
				itemforadd.setModelNo(input.nextInt());
				input.nextLine();
				System.out.println("Enter Color of Item:");
				itemforadd.setColor(input.nextLine());

				try{
				company2.branchArr[0].empArr[0].addItem(company2.branchArr[branch-1],itemforadd);
				System.out.println("Item added successfully.\n");
				}catch(RuntimeException e){
				System.out.println(e);
				System.exit(1);
				}

				}
			if(operation==4){
				int branch;
				int item;

				System.out.println("\nList of Branches:");

				for(int i=0;i<company2.numberOfBranch;i++)
				System.out.println((i+1)+"."+"Branch"+" "+(i+1));

				System.out.println("Choose the branch you want to remove Item:");
				branch = input.nextInt();
				input.nextLine();

				System.out.println("Inventory List of Branch"+" "+branch);
				System.out.println();
				company2.branchArr[0].empArr[0].printInventory(company2.branchArr[branch-1]);	
				System.out.println();
				System.out.println("Choose the Item number you want to remove:");
				item = input.nextInt();

				try{
				company2.branchArr[0].empArr[0].removeItem(company2.branchArr[branch-1],(item-1));
				System.out.println("Item removed successfully.");
				}catch(RuntimeException e){
				System.out.println(e);
				System.exit(1);
				}

				}
			if(operation==5){
				Customer customerforadd = new Customer();

				System.out.println("Enter Name of Customer:");
				customerforadd.setfirstName(input.nextLine());
				System.out.println("Enter Lastname of Customer:");
				customerforadd.setlasttName(input.nextLine());
				System.out.println("Enter Email of Customer:");
				customerforadd.setemail(input.nextLine());
				System.out.println("Enter password of Customer:");
				customerforadd.setpassword(input.nextLine());
				System.out.println("Enter Address of Customer:");
				customerforadd.setaddress(input.nextLine());
				System.out.println("Enter Phone Number of Customer:(only numbers)");
				customerforadd.setphoneNumber(input.nextInt());
				input.nextLine();

				System.out.println();		

				try{
				company2.branchArr[0].empArr[0].addCustomer(company2,customerforadd);
				System.out.println("Customer added to system successfully.\n");
				}catch(RuntimeException e){
				System.out.println(e);
				System.exit(1);
				}

				}
			if(operation==6){

				int branch;
				int item;
				int customer;

				System.out.println("\nList of Branches:");

				for(int i=0;i<company2.numberOfBranch;i++)
				System.out.println((i+1)+"."+"Branch"+" "+(i+1));

				System.out.println("Choose the branch where the Item will be sold:");
				branch = input.nextInt();
				input.nextLine();

				System.out.println("Inventory List of Branch"+" "+branch);
				System.out.println();
				try{
				company2.branchArr[0].empArr[0].printInventory(company2.branchArr[branch-1]);
				}catch(RuntimeException e){
				System.out.println(e);
				 System.exit(1);
				}
					
				System.out.println();
				System.out.println("Choose the Item you want to Sale:");
				item = input.nextInt();

				System.out.println("\nList of Customer:");
				System.out.println();
				company2.branchArr[0].empArr[0].printCustomers(company2);
				System.out.println("Choose the Customer who will buy the Item:");
				customer = input.nextInt();	

				try{
				company2.branchArr[0].empArr[0].makeSale(company2.branchArr[branch-1],company2.registeredCustomers[customer-1],(item-1));
				System.out.println("Item sold successfully.\n");
				}catch(RuntimeException e){
				System.out.println(e);
				System.exit(1);
				}
				

				}
			if(operation==7){
				break;
					}
				}
			}	
		
		if(menu==3){

			int id;
			String password;
			int operation;
			

			System.out.println("CUSTOMER INTERFACE\n");

			System.out.println("(From registered customer)");
			System.out.println("(Example ID: "+company2.registeredCustomers[0].getcustomerId()+")");
			System.out.println("(Example password: "+company2.registeredCustomers[0].getpassword()+")");
			System.out.println();

			boolean b = true;
			while(b){

			boolean outerbreak1 = false;
			boolean outerbreak2 = false;
			boolean outerbreak3 = false;

			System.out.println("Login system:");

			System.out.print("ID: ");
			id = input.nextInt();
			input.nextLine();
			System.out.println();

			System.out.print("password: ");
			password = input.nextLine();
			System.out.println();

			for(int i=0;i<company2.numberOfCustomer;i++){
						
				if(company2.registeredCustomers[i].getpassword().equals(password)&&company2.registeredCustomers[i].getcustomerId()==id){
					customerlog = i;
					System.out.println("Logged in as Customer.\n");
					outerbreak2 = true;
					break;
				}
			}

			if(outerbreak2) break;
			System.out.println("ID or password wrong.\n");
			}

			while(true){
			System.out.println("OPERATIONS:");
			System.out.println("\t1.Print List of Products");
			System.out.println("\t2.Shop Online");
			System.out.println("\t3.See Previous Orders");
			System.out.println("\t4.Logout system");
			System.out.println("Please choose one:");

			operation = input.nextInt();
			input.nextLine();

			if(operation==1){
				company2.registeredCustomers[0].printInventoryAllBranches(company2);
				}
			if(operation==2){

				int branch;
				int item;
				String address;
				int phonenumber;
				

				System.out.println("\nList of Branches:");

				for(int i=0;i<company2.numberOfBranch;i++)
				System.out.println((i+1)+"."+"Branch"+" "+(i+1));

				System.out.println("Choose the branch:");
				branch = input.nextInt();
				input.nextLine();

				System.out.println("Inventory List of Branch"+" "+branch);
				System.out.println();
				company2.branchArr[0].empArr[0].printInventory(company2.branchArr[branch-1]);	
				System.out.println();
				System.out.println("Choose the Item to purchase online:");
				item = input.nextInt();
				input.nextLine();

				System.out.println("Enter delivery address:");
				address = input.nextLine();
				System.out.println("Enter Phone Number:(only numbers)");
				phonenumber = input.nextInt();
				input.nextLine();

				company2.registeredCustomers[customerlog].shopOnline(address,phonenumber,company2.registeredCustomers[customerlog]);

				company2.branchArr[0].empArr[0].makeSale(company2.branchArr[branch-1],company2.registeredCustomers[customerlog],(item-1));

				System.out.println("Item purchased successfully:\n");
			

				}
			if(operation==3){
				company2.registeredCustomers[customerlog].printPreviousOrder(company2.registeredCustomers[customerlog]);
				}
			if(operation==4){
				break;
				}

			}


			}
		
		if(menu==4){
			break;
			}

		}



	}
}