/** Represents an Item Class.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
public class Item{

	/** Category of Item.
	*/
	public String category;
	/** Model No of Item.
	*/
	public int modelNo;
	/** Color of Item.
	*/
	public String color;

	/** No parameter constructor of Item class.
	*/
	public Item(){}

	/** Constructor of Item class.
	* @param category Category of Item.
	* @param modelNo Model No of Item.
	* @param color Color of Item.
	*/
	public Item(String category,int modelNo,String color){
		this.category = category;
		this.modelNo = modelNo;
		this.color = color;

		}

	/** Getter method which returns Category of Item.
	*/		
	public String getCategory(){
		return category;
		} 
	/** Getter method which returns Model No of Item.
	*/
	public int getModelNo(){
		return modelNo;
		}
	/** Getter method which returns Color of Item.
	*/
	public String getColor(){
		return color;
		} 

	/** Setter method which sets Category of Item.
	* @param category Category of Item.
	*/	
	public void setCategory(String category){
		this.category = category;
		}
	/** Setter method which sets Model No of Item.
	* @param modelNo Model No of Item.
	*/	
	public void setModelNo(int modelNo){
		this.modelNo = modelNo;
		}
	/** Setter method which sets Color of Item.
	* @param color Color of Item.
	*/	
	public void setColor(String color){
		this.color = color;
		}	

	}