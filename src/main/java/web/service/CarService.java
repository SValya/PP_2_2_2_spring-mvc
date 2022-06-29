package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    private static int CARS_COUNT;
    private final List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CARS_COUNT, "model1", "series1"));
        cars.add(new Car(++CARS_COUNT, "model2", "series2"));
        cars.add(new Car(++CARS_COUNT, "model3", "series3"));
        cars.add(new Car(++CARS_COUNT, "model4", "series4"));
        cars.add(new Car(++CARS_COUNT, "model5", "series5"));
    }

    public List<Car> show(int id) {
        if (id <= 0) {
            return cars;
        } else {
            return cars.stream().filter(car -> car.getId() <= id).limit(5).collect(Collectors.toList());
        }
    }
}
