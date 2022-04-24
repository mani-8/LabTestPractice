package mappingTable;
import java.util.List;
import java.util.Scanner;

import javax.security.auth.login.AccountNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Join {
	
	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	static Session session = factory.openSession();
	static Transaction tx =session.beginTransaction();
	static Scanner sc =new Scanner(System.in);
	static String author_name, book_name, book_company;static int book_id, author_id, book_price;
	public static void main(String[] args) {
		
		int choice;
    	
    	do {
	    	System.out.println("Press 1. To Create\nPress 2. To Display\nPress 3. To Update\nPress 4. To Delete"); 
	    	System.out.println("Enter your choice!"); 
	    	choice=sc.nextInt(); 
	    	
	    	switch(choice) {
	    	
	    	case 1: 
	    		create();
	    		break;
	    		
	    	case 2: 
	    		read();
	    		break;
	    		
	    	case 3: 
	    		update();
		    	break;
		    	
	    	case 4: 
	    		delete();
	    	    break;
	    		
	    	case 5:
	    		System.out.println("Thank You Visit Again!");
	    		break;
	    	}
    	}while(choice!=5);
}
	
    public static Author checkAvailable(int author_id) {
		
		Author aut =session.find(Author.class, author_id);
		
		try {
			if(aut==null) {
				throw new AccountNotFoundException("Account number not found!");
			}
		}catch (AccountNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return aut;
	}

	
	public static void delete() {
		
		System.out.println("Enter Author Id : ");
		author_id=sc.nextInt();
		Author au =checkAvailable(author_id);
		if(au!=null) {
			session.delete(au);
			tx.commit();
			System.out.println("Your row has been Deleted!");
		}			
	}

	public static void update() {
		System.out.println("Enter Author Id : ");
		author_id=sc.nextInt();
		Author au1 =checkAvailable(author_id);

		if(au1!=null) {
			System.out.println("Enter Book Id : ");
			book_id=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Book Name : ");
			book_name=sc.nextLine();
			System.out.println("Enter Book Price : ");
			book_price=sc.nextInt();
			Book bk = session.load(Book.class, book_id);
			bk.setBookName(book_name);
			bk.setBookPrice(book_price);
			session.update(bk);
			tx.commit();
			System.out.println("Your Account has been Updated!");
		}
		
	}

	public static void read() {

		System.out.println("Enter Author Id : ");
		author_id=sc.nextInt();
		Author au1 =checkAvailable(author_id);
		if(au1!=null) {
		Author au2 =session.load(Author.class, author_id);
		
		int size=au2.getBookList().size();
		for(int i=0;i<size;i++) {
        System.out.println("Book Id : "+au2.getBookList().get(i).getBookId());
        System.out.println("Book Name : "+au2.getBookList().get(i).getBookName());
        System.out.println("Book Company : "+au2.getBookList().get(i).getBookCompany());
        System.out.println("Book Price : "+au2.getBookList().get(i).getBookPrice()+"\n");
        
		}
		}
	}

	public static void create() {
		
		
		System.out.println("Enter Author Id : ");
		author_id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Author Name : ");
		author_name = sc.nextLine();
		
		Author aut =new Author();
		aut.setAuthorId(author_id);
		aut.setAuthorName(author_name);
		
		System.out.println("How many books to add : ");
		int listOfBook = sc.nextInt(); 
		
		for(int i=0;i<listOfBook;i++) {
			
			System.out.println("Enter Book "+(i+1)+" Id : ");
			book_id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Book "+(i+1)+" Name : ");
			book_name = sc.nextLine();
			System.out.println("Enter Book "+(i+1)+" Price : ");
			book_price = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Book "+(i+1)+" Company : ");
			book_company = sc.nextLine();
			
		Book bk = new Book();
		bk.setBookId(book_id);
		bk.setBookName(book_name);
		bk.setBookPrice(book_price);
		bk.setBookCompany(book_company);
		
        aut.getBookList().add(bk);
		}
		
        session.persist(aut);
        tx.commit();
	}
}