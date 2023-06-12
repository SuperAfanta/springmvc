package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private List<Car> carList;
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
        this.carList = new ArrayList<>();
        this.carList.add(new Car("Brand 1", "Model 1", 2021));
        this.carList.add(new Car("Brand 2", "Model 2", 2022));
        this.carList.add(new Car("Brand 3", "Model 3", 2023));
        this.carList.add(new Car("Brand 4", "Model 4", 2024));
        this.carList.add(new Car("Brand 5", "Model 5", 2025));
    }


    @GetMapping
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        List<Car> carsToShow = carService.getCars(count, carList);
        model.addAttribute("carList", carsToShow);
        return "cars";
    }

}



