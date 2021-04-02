package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private CarParkServ service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        return "mainpage";
    }

    @GetMapping("/contacts")
    public String viewContactsPage(Model model) {
        return "contacts";
    }

    @GetMapping("/showCarPark")
    public String showAll(Model model) {
        List<CarPark> listCarPark = service.listAll();
        model.addAttribute("listCarPark", listCarPark);

        return "requests";
    }

    @GetMapping("/new")
    public String showNewCarPage(Model model) {
        CarPark carPark = new CarPark();
        model.addAttribute("carPark", carPark);

        return "new_Car";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCar(@ModelAttribute("car") CarPark carPark) {
        service.save(carPark);

        return "redirect:/showCarPark";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_carPark");
        CarPark carPark = service.get(id);
        mav.addObject("carPark", carPark);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "forward:/showCarPark";
    }
}
