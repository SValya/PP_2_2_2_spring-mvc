package web.service;

import org.springframework.stereotype.Service;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(1, "model1", "series1"));
        cars.add(new Car(2, "model2", "series2"));
        cars.add(new Car(3, "model3", "series3"));
        cars.add(new Car(4, "model4", "series4"));
        cars.add(new Car(5, "model5", "series5"));
    }

    public List<Car> getCars(int id) {
        return id <= 0 ? cars : cars.stream().filter(car -> car.getId() <= id).collect(Collectors.toList());
    }
}
