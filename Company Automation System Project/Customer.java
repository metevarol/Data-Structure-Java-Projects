/** Represents an Customer Class.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
public class Customer implements Person{

	/** ID of Customer. Generated automatically.
	*/
	public int customerId;
	/** First Name of Customer.
	*/
	public String firstName;
	/** Last Name of Customer.
	*/
	public String lastName;
	/** E-mail of Customer.
	*/
	public String email;
	/** Password of Customer.
	*/
	public String password;
	/** Booelan which checks order is first or not.
	*/
	public boolean isFirstOrder;
	/** Index of Order.
	*/
	public int orderIndex;
	/** An array which stores OrderInfo Objects.
	*/
	public OrderInfo previousOrders[];
	/** Address of Customer.
	*/
	public String address;
	/** Phone Number of Customer.
	*/
	public int phoneNumber;

	/** No parameter constructor of Customer class.
	*/
	public Customer(){
		customerId = (int) (Math.random() * (3500 - 3400 + 1) + 3400);
		previousOrders = new OrderInfo[50];
		isFirstOrder = true;
		orderIndex = 0;
	}

	/** Constructor of Customer class.
	* @param firstName First Name of Customer.
	* @param lastName Last Name of Customer.
	* @param email E-mail of Customer.
	* @param password Password of Customer.
	* @param address Address of Customer.
	* @param phoneNumber Phone Number of Customer.
	*/
	public Customer(String firstName,String lastName,String email,String password,String address,int phoneNumber){

		customerId = (int) (Math.random() * (3500 - 3400 + 1) + 3400);

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;

		previousOrders = new OrderInfo[50];
		isFirstOrder = true;
		orderIndex = 0;
	}

	//GETTERS

	/** Getter method which returns ID of Customer.
	*/	
	public int getcustomerId(){
		return customerId;
		}
	/** Getter method which returns First Name of Customer.
	*/	
	public String getfirstName(){
		return firstName;
		}
	/** Getter method which returns Last Name of Customer.
	*/	
	public String getlastName(){
		return lastName;
		}
	/** Getter method which returns E-mail of Customer.
	*/	
	public String getemail(){
		return email;
		}	
	/** Getter method which returns Password of Customer.
	*/	
	public String getpassword(){
		return password;
		}
	/** Getter method which returns first order check of Customer.
	*/	
	public boolean getisFirstOrder(){
		return isFirstOrder;
		}
	/** Getter method which returns Address of Customer.
	*/	
	public String getaddress(){
		return address;
		}	
	/** Getter method which returns Phone Number of Customer.
	*/
	public int getphoneNumber(){
		return phoneNumber;
		}
	
	//SETTERS	
	
	/** Setter method which sets ID of Customer.
	* @param customerId ID of Customer.
	*/
	public void setcustomerId(int customerId){
		this.customerId = customerId;
		}
	/** Setter method which sets First Name of Customer.
	* @param name Name of Customer.
	*/
	public void setfirstName(String name){
		this.firstName = name;
		}
	/** Setter method which sets Last Name of Customer.
	* @param lastName Last Name of Customer.
	*/
	public void setlasttName(String lastName){
		this.lastName = lastName;
		}
	/** Setter method which sets E-mail of Customer.
	* @param email E-mail of Customer.
	*/
	public void setemail(String email){
		this.email = email;
		}
	/** Setter method which sets Password of Customer.
	* @param password Password of Customer.
	*/
	public void setpassword(String password){
		this.password = password;
		}
	/** Setter method which sets first order check of Customer.
	* @param isFirstOrder First order check of Customer.
	*/
	public void setisFirstOrder(boolean isFirstOrder){
		this.isFirstOrder = isFirstOrder;
		}
	/** Setter method which sets Address of Customer.
	* @param address Address of Customer.
	*/
	public void setaddress(String address){
		this.address = address;
		}
	/** Setter method which sets Phone Number of Customer.
	* @param phoneNumber Phone Number of Customer.
	*/
	public void setphoneNumber(int phoneNumber){
		this.phoneNumber = phoneNumber;
		}
	//CUSTOMER OPERATIONS

	/** Prints Inventories of all Branches in Company.
	* @param companyobj Company object.
	*/
	public void printInventoryAllBranches(Company companyobj){

		

		for(int i=0;i<companyobj.numberOfBranch;i++){

			System.out.println("Inventory List of Branch"+" "+(i+1));
			System.out.println();
			System.out.println("Category"+"\t\t"+"Model No"+"\t"+"Color\n");
			for(int j=0;j<companyobj.branchArr[i].amountOfStock;j++){



			System.out.println((j+1)+"."+companyobj.branchArr[i].stockInventory[j].category+"\t\t"+companyobj.branchArr[i].stockInventory[j].modelNo+"\t\t"+
			companyobj.branchArr[i].stockInventory[j].color);	

			}

			System.out.println();
			System.out.println("Amount of stock : "+companyobj.branchArr[i].amountOfStock);
			System.out.println();

		}
			
		}

	/** Provides online shopping from any branch.
	* @param address Delivery Address.
	* @param phoneNumber Delivery Phone Number.
	* @param customerobj Customer object of purchasing customer.
	*/
	public void shopOnline(String address,int phoneNumber,Customer customerobj){
		customerobj.setaddress(address);
		customerobj.setphoneNumber(phoneNumber);
		customerobj.setisFirstOrder(false);
		}
	
	/** Prints Previous Orders of Customer.
	* @param customerobj Customer object.
	*/	
	public void printPreviousOrder(Customer customerobj){

		System.out.println("\nPrevious Orders:\n");
		System.out.println("Category"+"\t"+"Model No"+"\t"+"Color"+"\t"+"Delivery Address"+"\t"+"Phone Number\n");

		for(int i=0;i<customerobj.orderIndex;i++){

			System.out.println((i+1)+"."+customerobj.previousOrders[i].orderedItem.getCategory()+"\t"+customerobj.previousOrders[i].orderedItem.getModelNo()
			+"\t\t"+customerobj.previousOrders[i].orderedItem.getColor()+"\t"+customerobj.previousOrders[i].address+"\t\t"+
			customerobj.previousOrders[i].phoneNumber);
		}
	}


	}