package pl.edu.pjwstk.booksmpr.repository;

import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.booksmpr.model.Book;

import java.util.HashMap;
import java.util.List;

@Repository
public class BookRepository {

    private HashMap<Long, Book> bookHashMap = new HashMap<>();

    public Book createBook(Book book) {
        book.setId(findMaxId());
        bookHashMap.put(book.getId(), book);
        return book;
    }

    public void deleteBook(Long id){
        if(bookHashMap.containsKey(id)){
            bookHashMap.remove(id);
        }
         else throw new IllegalArgumentException();
    }

    public Book getBookById(Long id) {
        if (bookHashMap.containsKey(id)) {
            return bookHashMap.get(id);
        }
        throw new IllegalArgumentException();
    }

    public List<Book> getAllBooks(){
        return bookHashMap.values().stream().toList();
    }

    public Book updateBook(Long id, Book updatedBook){
        Book bookToUpdate = getBookById(id);

        if(updatedBook.getPublisher() != null ){
            bookToUpdate.setPublisher(updatedBook.getPublisher());
        }

        if(updatedBook.getTitle() != null){
            bookToUpdate.setTitle(updatedBook.getTitle());
        }

        if(updatedBook.getAuthor() != null){
            bookToUpdate.setAuthor(updatedBook.getAuthor());
        }

        bookHashMap.put(id, bookToUpdate);

        return bookToUpdate;

    }

    private Long findMaxId() {
        if(bookHashMap.size() == 0) {
            return 0L;
        }
        return bookHashMap.keySet().stream()
                .mapToLong(a-> a)
                .max()
                .getAsLong() + 1;
    }

}
