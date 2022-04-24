package mappingTable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="author_table")
public class Author {
@Id
@Column(name="author_id")
private int authorId;

private String authorName;

@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
@JoinColumn(name = "author_id")
private List<Book> BookList = new ArrayList<Book>();

public int getAuthorId() {
	return authorId;
}

public void setAuthorId(int authorId) {
	this.authorId = authorId;
}

public String getAuthorName() {
	return authorName;
}

public void setAuthorName(String authorName) {
	this.authorName = authorName;
}

public List<Book> getBookList() {
	return BookList;
}

public void setBookList(List<Book> bookList) {
	BookList = bookList;
}



}
