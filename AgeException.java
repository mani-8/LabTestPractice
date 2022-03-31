package BasicProgram;

import java.util.Scanner;

@SuppressWarnings("serial")
 class AgeNotValidException extends Exception {

	public AgeNotValidException(String message) {
	super(message);
	}
}

public class AgeException {
	
	public static void main(String[] args) {
		int age; 
		String name;
		Scanner sc =new Scanner(System.in);
		
		//getting the name and age from the user
		System.out.println("Enter your name : ");
		name = sc.nextLine();
        System.out.println("Enter your age : ");
        age = sc.nextInt();
        sc.close();
        
		try {
			//checking the age for voting
			if (age<18) {
			 throw new AgeNotValidException("Your age is less than 18,so not valid to vote!!");
			}else {
				System.out.println(name+", welcome to vote");
			}
		} catch (AgeNotValidException e) {
			System.out.println(e.getMessage());
		}
       
	}

}
