/** Represents an Person Interface.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
interface Person{

	/** Getter method which returns First Name of Person.
	*/	
	String getfirstName();
	/** Getter method which returns Last Name of Person.
	*/
	String getlastName();
	/** Getter method which returns password of Person.
	*/
	String getpassword();

	/** Setter method which sets Name of Person.
	* @param name Name of Person.
	*/
	void setfirstName(String name);
	/** Setter method which sets Last Name of Person.
	* @param lastName Name of Person.
	*/
	void setlasttName(String lastName);
	/** Setter method which sets password of Person.
	* @param password Password of Person.
	*/
	void setpassword(String password);

	}