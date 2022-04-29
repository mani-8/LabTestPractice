package BasicProgram;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		
		int arr[],temp,len;
		
		arr =new int[] {5,2,53,21,8,7,12}; 
	    temp=0;
		len=arr.length;
		
		//Before sorting the elements
		System.out.println("Before sorting : ");	
		for(int i=0;i<len;i++) {
			System.out.print(arr[i]+" ");
		}
		
		//After sorting the elements
		System.out.println("\nAfter sorting : ");
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				
				if(arr[i]>arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
					
				}
			}
			System.out.print(arr[i]+" ");
		}
		
		//By using ArraysSort method
		System.out.println("\nBy using ArraysSort method : ");
		Arrays.sort(arr);
		for(int i=0;i<len;i++) {
        System.out.println(arr[i]+" ");
		}
		
		}
}
