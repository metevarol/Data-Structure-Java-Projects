/** Represents an Employee Class.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
public class Employee implements Person{

	/** ID of Employee.
	*/
	public int employeeId;
	/** First Name of Employee.
	*/
	public String firstName;
	/** Last Name of Employee.
	*/
	public String lastName;
	/** Password of Employee.
	*/
	public String password;
	/** Index of Branch.
	*/
	public int branchNo;
	
	//CONSTRUCTORS
	
	/** No parameter constructor of Employee class.
	*/
	public Employee(){}
	
	/** Constructor of Employee class.
	* @param employeeId ID of Employee.
	* @param firstName First Name of Employee.
	* @param lastName Last Name of Employee.
	* @param password Password of Employee.
	* @param branchNo Branch Number of Employee.
	*/
	public Employee(int employeeId,String firstName,String lastName,String password,int branchNo){
		 this.employeeId = employeeId;
		 this.firstName = firstName;
		 this.lastName = lastName;
		 this.password = password;
		 this.branchNo = branchNo;
		}
	
	//GETTERS
	
	/** Getter method which returns ID of Employee.
	*/	
	public int getemployeeId(){
		return employeeId;
		}
	/** Getter method which returns First Name of Employee.
	*/	
	public String getfirstName(){
		return firstName;
		}
	/** Getter method which returns Last Name of Employee.
	*/
	public String getlastName(){
		return lastName;
		}
	/** Getter method which returns Password of Employee.
	*/	
	public String getpassword(){
		return password;
		}
	/** Getter method which returns Branch Number of Employee.
	*/	
	public int getbranchNo(){
		return branchNo;
		}
	//SETTERS	
	
	/** Setter method which sets ID of Employee.
	* @param employeeId ID of Employee.
	*/
	public void setemployeeId(int employeeId){
		this.employeeId = employeeId;
		}
	/** Setter method which sets First Name of Employee.
	* @param name Name of Employee.
	*/
	public void setfirstName(String name){
		this.firstName = name;
		}
	/** Setter method which sets Last Name of Employee.
	* @param lastName Last Name of Employee.
	*/
	public void setlasttName(String lastName){
		this.lastName = lastName;
		}
	/** Setter method which sets Password of Employee.
	* @param password Password of Employee.
	*/
	public void setpassword(String password){
		this.password = password;
		}
	/** Setter method which sets Branch Number of Employee.
	* @param branchNo Branch Number of Employee.
	*/
	public void setbranchNo(int branchNo){
		this.branchNo = branchNo;
		}
	//EMPLOYEE AUTHORITIES
	
	/** Prints Inventories of Branch.
	* @param branchObj Branch object.
	*/
	public void printInventory(Branch branchObj){

		if(branchObj==null){

			throw new RuntimeException("Invalid branch selected."); 
		}

		System.out.println("Category"+"\t\t"+"Model No"+"\t"+"Color\n");

		for(int i=0;i<branchObj.amountOfStock;i++){

			System.out.println((i+1)+"."+branchObj.stockInventory[i].category+"\t\t"+branchObj.stockInventory[i].modelNo+"\t\t"+branchObj.stockInventory[i].color);
		}
			System.out.println();
			System.out.println("Amount of stock : "+branchObj.amountOfStock);
			System.out.println();

		}
	/** Adds Item to Branch.
	* @param branchObj A branch object which item will be added.
	* @param itemobj Item object.
	*/
	public void addItem(Branch branchObj,Item itemobj){

		if(branchObj==null){

			throw new RuntimeException("Invalid branch selected."); 
		}

		if(itemobj==null){

			throw new RuntimeException("Invalid item selected."); 
		}


		branchObj.stockInventory[branchObj.amountOfStock] = itemobj;

		branchObj.amountOfStock++;

		}
	/** Removes Item from Branch.
	* @param branchObj A branch object which item will be removed.
	* @param index Index of removed item.
	*/
	public void removeItem(Branch branchObj,int index){

		if(branchObj==null){

			throw new RuntimeException("Invalid branch selected."); 
		}


		if(branchObj.stockInventory[index]==null){

			throw new RuntimeException("Invalid item selected."); 
		}



		branchObj.stockInventory[index] = null;

		for(int i=index;i<branchObj.stockInventory.length-1;i++){
			branchObj.stockInventory[i] = branchObj.stockInventory[i+1];
		}
		branchObj.amountOfStock--;
		}
	/** Make sales from Branch.
	* @param branchObj A branch object which item will be saled.
	* @param customerobj Customer object.
	* @param index Index of saled item.
	*/
	public void makeSale(Branch branchObj,Customer customerobj,int index){

		if(branchObj==null){

			throw new RuntimeException("Invalid branch selected."); 
		}

		if(customerobj==null){

			throw new RuntimeException("Invalid customer selected."); 
		}


		if(branchObj.stockInventory[index]==null){

			throw new RuntimeException("Invalid item selected."); 
		}
	
		OrderInfo orderobj = new OrderInfo(branchObj.stockInventory[index],customerobj.getcustomerId(),
			customerobj.getaddress(),customerobj.getphoneNumber());

		customerobj.previousOrders[customerobj.orderIndex++] = orderobj;
		
		removeItem(branchObj,index);

		}
	/** Adds Customer to Branch.
	* @param companyobj Company object.
	* @param customerobj Customer object.
	*/
	public void addCustomer(Company companyobj,Customer customerobj){

		companyobj.registeredCustomers[companyobj.numberOfCustomer] = customerobj;

		companyobj.numberOfCustomer++;
		}
	/** Prints Cusrtomers of Company.
	* @param companyobj Company object.
	*/
	public void printCustomers(Company companyobj){

		System.out.println("ID"+"\t"+"Name"+"\t\t"+"e-mail"+"\t\t\t"+"Adress"+"\t\t\t"+"Phone Number\n");

		for(int i=0;i<companyobj.numberOfCustomer;i++){

			System.out.println((i+1)+"."+companyobj.registeredCustomers[i].customerId+"\t"+companyobj.registeredCustomers[i].firstName+" "+
				companyobj.registeredCustomers[i].lastName+"\t"+companyobj.registeredCustomers[i].email+"\t"+
				companyobj.registeredCustomers[i].address+"\t"+
				companyobj.registeredCustomers[i].phoneNumber);
		}
			System.out.println();
			System.out.println("Number of customers : "+companyobj.numberOfCustomer);
			System.out.println();
	}



	}// END OF EMPLOYEE CLASS