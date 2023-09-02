import java.util.*;

public class Employee {

	private int empno;
	private String ename;
	private int salary;
	
	Employee(int empno, String ename, int salary){
		this.empno = empno;
		this.ename = ename;
		this.salary = salary;
	}
	
	public int getEmpno() {
		return empno;
	}
	public int getSalary() {
		return salary;
	}
	public String getEname() {
		return ename;
	}
	public String toString() {
		return empno+" "+ename+" "+salary;
	}
}
class CRUD{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Scanner ss=new Scanner(System.in); //Separate instance for the String Scanner
		
		List<Employee> empList = new ArrayList<Employee>();
		int ch;
	do {
		System.out.println("1.INSERT");
		System.out.println("2.DISPLAY");
		System.out.println("3.SEARCH");
		System.out.println("4.DELETE");
		System.out.println("5.UPDATE");
		System.out.println();
		System.out.print("Enter Operation Choice: ");
		ch=sc.nextInt();
		
		switch(ch) {
		case 1: 
			
			System.out.print("Enter Employee Number: ");
			int eno = sc.nextInt();
			System.out.print("Enter Employee Name: ");
			String ename = ss.nextLine();
			System.out.print("Enter Employee Salary: ");
			int salary = sc.nextInt();
			
			empList.add(new Employee(eno, ename, salary));
			break;
			
		case 2: 
			
			System.out.println("----------------------------");
			Iterator<Employee> i = empList.iterator();
			while(i.hasNext()) {
				Employee e = i.next();
				System.out.println(e); // this will call the toString function
			}
			System.out.println("----------------------------");
			break;
			
		case 3: 
			
			boolean found = false;
			System.out.println("Enter Employee Number to Search:");
			int empX=sc.nextInt();
			
			System.out.println("----------------------------");
			 i = empList.iterator();
			while(i.hasNext()) {
				Employee e = i.next();
				if(e.getEmpno() == empX) {
				System.out.println(e); // this will call the toString function
				found=true;
				}
			}
			if(!found)
				System.out.println("Record Not Found");
			System.out.println("----------------------------");
			break;
			
		case 4: 
			
			found = false;
			System.out.println("Enter Employee Number to Delete:");
			 empX=sc.nextInt();
			
			System.out.println("----------------------------");
			 i = empList.iterator();
			while(i.hasNext()) {
				Employee e = i.next();
				if(e.getEmpno() == empX) {
				i.remove();
				found=true;
				}
			}
			if(!found)
				System.out.println("Record Not Found");
			else
				System.out.println("Record Deleted Successfully!");
			System.out.println("----------------------------");
			break;

		case 5: 
			
			found = false;
			System.out.println("Enter Employee Number to Update:");
			empX=sc.nextInt();
			
			ListIterator<Employee> li = empList.listIterator(); //because update can only be performed on a List
			while(li.hasNext()) {
				Employee e = li.next();
				if(e.getEmpno() == empX) {
				System.out.print("Enter new Name: ");
				 ename = ss.nextLine();
				 
				 System.out.print("Enter new Salary: ");
				 salary = sc.nextInt();
				 li.set(new Employee(empX,ename, salary));
				 found=true;
				}
			}
			if(!found)
				System.out.println("Record Not Found");
			else
				System.out.println("Record Updated Successfully!");
			
			break;			
		}
		
	} while(ch!=0);
		
	}

}
