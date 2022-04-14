package BasicProgram;

import java.util.ArrayList;

public class RemoveElement {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Manikandan");
		arr.add("Monalisa mam");
		arr.add("Ajith");
		arr.add("Ramesh");
		
		System.out.println("***** Before removing element *****");
		
		//Before removing element
		for(String name : arr) {
			System.out.println(name);
		}
        System.out.println();
        
		arr.remove(3);
	
        System.out.println("***** After removing element *****");
		
		//After removing element
		for(String name : arr) {
			System.out.println(name);
		}

	}

}
