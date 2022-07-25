/** Represents an Branch Class.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
public class Branch{

	/** Index of Branch.
	*/
	public int branchNo;
	/** An array which stores Employee Objects.
	*/
	public Employee empArr[];
	/** An array which stores Item Objects.
	*/
	public Item stockInventory[];
	
	/** Number of Employees.
	*/
	public int numberOfEmployee;
	/** Number of Items. Stock.
	*/
	public int amountOfStock;
	
	/** Constructor of Branch class.
	* @param branchNo Branch object.
	*/
	public Branch(int branchNo){
		this.branchNo = branchNo;
		empArr = new Employee[50];
		stockInventory = new Item[50];
		numberOfEmployee = 0;
		amountOfStock = 0;

		}

	}