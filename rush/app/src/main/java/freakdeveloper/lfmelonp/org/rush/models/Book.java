package freakdeveloper.lfmelonp.org.rush.models;

import java.util.List;

import co.uk.rushorm.core.RushCallback;
import co.uk.rushorm.core.RushCore;
import co.uk.rushorm.core.RushObject;
import co.uk.rushorm.core.annotations.RushList;

/**
 * Created by a67233924 on 11/8/16.
 */
public class Book extends RushObject{
    private String bookName;
    private String bookEdition;
    private Author author;

    @RushList(classType = Author.class)
    private List<Author> bookColaborators;

    public Book() {
    }

    public Book(String bookName, String bookEdition, Author author, List<Author> bookColaborators) {
        this.bookName = bookName;
        this.bookEdition = bookEdition;
        this.author = author;
        this.bookColaborators = bookColaborators;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(String bookEdition) {
        this.bookEdition = bookEdition;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Author> getBookColaborators() {
        return bookColaborators;
    }

    public void setBookColaborators(List<Author> bookColaborators) {
        this.bookColaborators = bookColaborators;
    }

    @Override
    public String toString() {
        String colaborators = "[";
        for(int i = 0; i < bookColaborators.size();i++){
            colaborators.concat(bookColaborators.get(i).toString());
        }
        colaborators.concat("]");
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookEdition='" + bookEdition + '\'' +
                ", author=" + author +
                ", bookColaborators=" + colaborators +
                '}';
    }


    @Override
    public void save() { RushCore.getInstance().save(this); }
    @Override
    public void save(RushCallback callback) { RushCore.getInstance().save(this, callback); }
    @Override
    public void delete() { RushCore.getInstance().delete(this); }
    @Override
    public void delete(RushCallback callback) { RushCore.getInstance().delete(this, callback); }
    @Override
    public String getId() { return RushCore.getInstance().getId(this); }
}
