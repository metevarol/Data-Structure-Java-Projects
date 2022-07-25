/** Represents an Admin Class.
 * @author Hikmet Mete Varol
 * @version 1.0
 * @since 1.0
*/
public class Admin extends Employee implements Person{

	/** Adds Branch to the Company.
	* @param companyobj Company object which the branch is added.
	*/
	public void addBranch(Company companyobj){

		Branch branchObj = new Branch(companyobj.numberOfBranch+1);

		companyobj.branchArr[companyobj.numberOfBranch] =  branchObj;

		companyobj.numberOfBranch++;
		}

	/** Adds Employee to the Company.
	* @param branchObj Branch object which the Employee is added.
	* @param companyobj Company object which the Employee is added.
	*/
	public void addEmployee(Branch branchObj,Company companyobj){

		if(branchObj==null){

			throw new RuntimeException("Invalid branch selected."); 
		}

		Employee employeeobj = new Employee();

		branchObj.empArr[branchObj.numberOfEmployee] = employeeobj;

		branchObj.numberOfEmployee++;
		companyobj.numberOfEmployeeAll++;
	}

	}