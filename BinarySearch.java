package BasicProgram;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String args[]){
		
        int arr[],mid,fst_index,lst_index;	
		arr =new int[] {2,3,7,10,12,15,53}; 
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter number to find the index of thise number : ");
		int key=sc.nextInt();
		
		fst_index=0; 
		lst_index = arr.length-1;
		
		while( fst_index <= lst_index ){	
			mid = (fst_index + lst_index)/2;
			if(arr[mid]<key) {
				fst_index = mid+1;
			}else if(arr[mid]==key){
				System.out.println("The number "+key+" is found at index "+mid);
				break;
			}else {
				lst_index=mid-1;
			}
		}
		sc.close();
	}
}
