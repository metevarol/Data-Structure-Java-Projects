/** Represents an Company Class.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
public class Company{

	/** Admin object. Admin managing the Company.
	*/
	public Admin adminobj;
	/** An array which stores Branch Objects.
	*/
	public Branch branchArr[];
	/** Number of Branch.
	*/
	public int numberOfBranch;
	/** An array which stores registered Customer Objects.
	*/
	public Customer registeredCustomers[];
	/** Number of Customer.
	*/
	public int numberOfCustomer;
	/** Number of all Employee in Company.
	*/
	public int numberOfEmployeeAll;

	/** No parameter constructor of Company class.
	*/
	public Company(){
		adminobj = new Admin();
		branchArr = new Branch[50];
		registeredCustomers = new Customer[50];
		numberOfCustomer = 0;
		numberOfBranch = 0;
		numberOfEmployeeAll = 0;
			}
	}