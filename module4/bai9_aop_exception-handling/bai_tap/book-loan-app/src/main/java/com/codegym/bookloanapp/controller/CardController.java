package com.codegym.bookloanapp.controller;

import com.codegym.bookloanapp.service.BookService;
import com.codegym.bookloanapp.service.CardService;
import com.codegym.bookloanapp.exception.BookException;
import com.codegym.bookloanapp.exception.CardException;
import com.codegym.bookloanapp.model.Book;
import com.codegym.bookloanapp.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CardController {
    @Autowired
    CardService cardService;

    @Autowired
    BookService bookService;

    @GetMapping("/card/list")
    public ModelAndView showCardList() {
        return new ModelAndView("card/card-list", "card", cardService.findAll());
    }

    @GetMapping("/card/view/{id}")
    public ModelAndView viewBorrowCard(@PathVariable Integer id) {
        return new ModelAndView("card/card-detail", "card", cardService.findByid(id));
    }

    @GetMapping("/card/{id}")
    public String borrowBook(@PathVariable Integer id, RedirectAttributes redirectAttributes) throws BookException {
        Card card = new Card();
        Book book = bookService.findById(id);
        if (book == null || book.getQuantity() == 0) {
            throw new BookException();
        } else {
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
            double borrowCardId =  (Math.random() * (99999 - 10000) + 10000);
            card.setId((int) borrowCardId);
            card.setBook(book);
            card = cardService.save(card);
        }
        redirectAttributes.addFlashAttribute("message", "Mượn sách " + book.getName() + " thành công");
        return "redirect:/card/view/" + card.getId();
    }

    @ExceptionHandler(BookException.class)
    public ModelAndView showBookErrorPage(){
        return new ModelAndView("book/error");
    }

    @GetMapping("/return")
    public ModelAndView returnBook(@RequestParam Integer cardId) {
        ModelAndView modelAndView = new ModelAndView("card/card-detail");
        Card card = cardService.findByid(cardId);
        Book book = card.getBook();
        book.setQuantity(book.getQuantity() + 1);
        cardService.delete(cardId);
        bookService.save(book);
        modelAndView.addObject("message", "Trả sách " + book.getName() + " thành công");
        return modelAndView;
    }

    @GetMapping("/card/search")
    public ModelAndView viewSearch() {
        return new ModelAndView("/card/card-search");
    }

    @PostMapping("/card/search")
    public ModelAndView search(@RequestParam Integer cardId) throws CardException {
        ModelAndView modelAndView = new ModelAndView("card/card-detail");
        Card card = cardService.findByid(cardId);
        if (card == null){
            throw new CardException();
        } else {
            modelAndView.addObject("card", card);
        }
        return modelAndView;
    }
    @ExceptionHandler(CardException.class)
    public ModelAndView showErrorPage(){
        return new ModelAndView("card/error");
    }
}
