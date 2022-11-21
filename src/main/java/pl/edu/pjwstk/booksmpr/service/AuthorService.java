package pl.edu.pjwstk.booksmpr.service;

import com.sun.source.tree.OpensTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr.model.Author;
import pl.edu.pjwstk.booksmpr.model.Book;
import pl.edu.pjwstk.booksmpr.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id){
        return authorRepository.getReferenceById(id);
    }

    public Author updateAuthor(Long id, Author updatedAuthor){
        Author authorToUpdate = authorRepository.getReferenceById(id);

        if (updatedAuthor.getFirstName() != null){
            authorToUpdate.setFirstName(updatedAuthor.getFirstName());
        }

        if (updatedAuthor.getLastName() != null){
            authorToUpdate.setLastName(updatedAuthor.getLastName());
        }
        return authorRepository.save(authorToUpdate);
    }

    public Author findAuthorByNameAndLastName(String firstName, String lastName){
        Optional<Author> author = authorRepository.findAuthorByFirstNameAndLastName(firstName,lastName);
        if (author.isPresent()){
            return author.get();
        }
        throw new IllegalArgumentException();
    }

    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }
}
