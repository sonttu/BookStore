package Haagahelia.BookStore.web;


import Haagahelia.Book.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookStoreController {

    private List<Book> books = new ArrayList<>();

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("books", books);
        model.addAttribute("newBook", new Book()); // Add an empty Book object for the form
        return "index";
    }

    @RequestMapping("/addBook")
    public String showBookForm(Model model) {
        model.addAttribute("newBook", new Book()); // Add an empty Book object for the form
        return "bookForm";
    }

    @PostMapping("/saveBook") // Change the mapping to /saveBook
    public String addBook(Book book) {
        books.add(book);
        return "redirect:/index"; // Redirect to the index page after adding a book
    }
    
    @PostMapping("/clearBookList") // Handler for clearing the book list
    public String clearBookList() {
        books.clear();
        return "redirect:/index"; // Redirect to the index page after clearing the list
    }
 }

