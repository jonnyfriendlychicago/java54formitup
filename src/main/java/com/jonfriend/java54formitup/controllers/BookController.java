package com.jonfriend.java54formitup.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonfriend.java54formitup.models.Book;
import com.jonfriend.java54formitup.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookservice; 
	
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> bookListy = bookservice.allBooks(); 
		model.addAttribute("bookListy", bookListy);

//		List<Book> books = bookservice.allBooks();
//	    model.addAttribute("books", books);
//		model.addAttribute("book", book); 
		
		return "booklist.jsp";
	}


	@RequestMapping("/books/{bookId}") 
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
		Book book = bookservice.findBook(bookId); 
		model.addAttribute("book", book);  
		 
		
//		List<Book> bookListy = bookservice.allBooks(); 
//		model.addAttribute("bookListy", bookListy); 
		
		return "bookprofile.jsp"; 
	}

	@RequestMapping("/books/new")
	public String createBook( @ModelAttribute("book") Book book ) {
		return "bookcreatenew.jsp";
	}
	
	@PostMapping("/processNewBook") 
		public String processNewBook(
//			@RequestParam("title") String title
//			, @RequestParam("description") String description
//			, @RequestParam("language") String language
//			, @RequestParam("numberOfPages") Integer numberOfPages
			@Valid 
			@ModelAttribute("book") Book book, 
			BindingResult result
			
		) {

//		Book bookInternalVar = new Book(title, description, language, numberOfPages); 
//		bookInternalVar = bookservice.createBook(bookInternalVar);
//		bookservice.createBook(book); 
//		return "redirect:/books";
			
			if (result.hasErrors()) {
	//          return "/books/bookcreatenew.jsp";
	//			above terrible: loses the user-entered data, don't do it!
	            return "bookcreatenew.jsp";
//	            return "redirect:/books/new"; 
	        } else {
	        	bookservice.createBook(book);
	            return "redirect:/books";
	        }
		}
	
// end of methods
}
