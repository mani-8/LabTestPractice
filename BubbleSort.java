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
			for(int j=1;j<len-i;j++) {
				if(arr[j-1]>arr[j]) {
		
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
		Arrays.stream(arr).forEach(a -> System.out.print(a+" "));
		
		//By using ArraysSort method
		System.out.println("\nBy using ArraysSort method : ");
		Arrays.sort(arr);
		for(int i=0;i<len;i++) {
        System.out.println(arr[i]+" ");
		}
		
		}
}
