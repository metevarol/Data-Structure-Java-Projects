 /** Represents an OrderInfo Class.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
public class OrderInfo{

	/** Item object which the item for sale is kept.
	*/
	public Item orderedItem;
	/** ID of the purchasing customer.
	*/
	public int customerId;
	/** Address of the purchasing customer.
	*/
	public String address;
	/** Phone Number of the purchasing customer.
	*/
	public int phoneNumber;

	/** Constructor of OrderInfo class.
	* @param orderedItem Item object which the item for sale is kept.
	* @param customerId ID of the purchasing customer.
	* @param address Address of the purchasing customer.
	* @param phoneNumber Phone Number of the purchasing customer.
	*/
	public OrderInfo(Item orderedItem,int customerId,String address,int phoneNumber){
			this.orderedItem = orderedItem;
			this.customerId = customerId;
			this.address = address;
			this.phoneNumber = phoneNumber;
		}

	}