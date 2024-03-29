package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String password;
	private String lastName;
	private String alternateEmail;
	private String department;
	
	private final int DEFAULT_PASS_LENGTH = 14;
	int mailboxCapacity;

	//Constructor
	public Email (String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		System.out.println("Email created: " + this.firstName + " " + this.lastName);

		// ask for the department and return it
		setDepartment();
		System.out.println(this.department);
		
		this.password = randomPw(DEFAULT_PASS_LENGTH);
		System.out.println("Your secret password: " + this.password);

		
	}
	// department getter
	protected String getDepartment() {
		return this.department;
	}

	private void setDepartment() {
		System.out.println("Enter your department number \n1 Sales\n2 Marketing \n3 Engineering \n4 Accounting \n5 Other.");
		Scanner in = new Scanner(System.in);

		while (this.department == null) {
			String deptCode = in.next();
			if (isInt(deptCode)) {
				int code = Integer.parseInt(deptCode);
				if(isValidDept(code)) {
					matchCode(code);
				}else {
					System.out.println("Please try again and input a valid department code.");
				}
				}else {
					System.out.println("Please try again and input an numeric code.");
				}
			}
		in.close();
		}

		
	private void matchCode(int code) {
		switch (code) {
		case 1:
			this.department = "Sales";
			break;
		case 2:
			this.department = "Marketing";
			break;
		case 3:
			this.department = "Engineering";
			break;
		case 4: 
			this.department = "Accounting";
			break;
		case 5:
			this.department = "Other";
			break;
		default:
			System.out.println("Error this department does not exist.");
		}
	}

	private boolean isInt(String s) {
		return s.matches("-?\\d+");
	}
	
	private boolean isValidDept(int i) {
		return (i < 6 && i >0);
	}

	//random pw generator
	private String randomPw(int length) {
		String pw = "";
		
		//ASCII Values relevant to typeable keys
		int max = 127;
		int min = 33;
		
		int range = max-min+1;
		for(int i =0; i< length; i++) {
			pw += (char)( (Math.random() * range) + min);
 		}
		return pw;
	}

	// set mailbox capacity

	// set alternate email

	//change pw
}
