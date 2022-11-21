package pl.edu.pjwstk.booksmpr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr.model.Author;
import pl.edu.pjwstk.booksmpr.model.Book;
import pl.edu.pjwstk.booksmpr.repository.BookRepository;
import pl.edu.pjwstk.booksmpr.repository.model.enums.BookType;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.getReferenceById(id);
    }

    public void deleteAuthorById(Long id){
        bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updatedBook){
        Book bookToUpdate = getBookById(id);

        if (updatedBook.getPublisher() != null){
            bookToUpdate.setPublisher(updatedBook.getPublisher());
        }

        if (updatedBook.getTitle() != null){
            bookToUpdate.setTitle(updatedBook.getTitle());
        }

        if (updatedBook.getAuthor() != null){
            bookToUpdate.setAuthor(updatedBook.getAuthor());
        }
        return bookRepository.save(updatedBook);
    }

    List<Book> getBookByBookType(BookType bookType){
        return bookRepository.findBooksByBookType(bookType);
    }
}
