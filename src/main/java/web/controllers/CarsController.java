package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarService carServiceImpl;

    @Autowired
    public CarsController(CarService carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping()
    public String show(@RequestParam(value = "count", required = false, defaultValue = "0") int id, Model model) {
        model.addAttribute("cars", carServiceImpl.show(id));
        return "cars/show";
    }
}
