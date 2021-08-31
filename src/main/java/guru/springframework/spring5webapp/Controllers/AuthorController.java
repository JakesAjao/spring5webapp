package guru.springframework.spring5webapp.Controllers;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final AuthorService authorService;

    public AuthorController(AuthorRepository authorRepository, AuthorService authorService) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthor(Model model){
        model.addAttribute("authors",authorRepository.findAll());

        return "authorlist";
    }
    @RequestMapping(value= "/author/edit/{authorId}", method = RequestMethod.GET)
    public String updateAuthor(@PathVariable("authorId")Long authorId, ModelMap model){
        Author author = authorService.findByAuthorId(authorId);
        model.put("author", author);
        return "editauthor";
    }

    //public String saveAppel(@ModelAttribute("editappel") Appel editappel, BindingResult result, ModelMap model) {

    @RequestMapping(value="/updateauthors",method=RequestMethod.POST)
    public String saveAuthor(@ModelAttribute("author") Author author, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "redirect:/authors";
        }
        System.out.println("Updated First NAME: "+author.getFirstName());
        System.out.println("Updated Last NAME: "+author.getLastName());
        authorService.UpdateAuthor(author);
        return  "redirect:/authors";
    }
}
