package com.carlos.filipe.controllerusercar.service;

import com.carlos.filipe.controllerusercar.exception.BadRequestException;
import com.carlos.filipe.controllerusercar.exception.EntityNotFoundException;
import com.carlos.filipe.controllerusercar.model.Car;
import com.carlos.filipe.controllerusercar.model.Fipe;
import com.carlos.filipe.controllerusercar.model.User;
import com.carlos.filipe.controllerusercar.model.dto.CarDTO;
import com.carlos.filipe.controllerusercar.repository.CarRepository;
import com.carlos.filipe.controllerusercar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

@Service
public class CarService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    FipeService service;

    public CarDTO add(Car car, Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuario de id " + id + " não encontrado."));
        var brands = service.getBrand();
        var brand = new Fipe();
        var models = service.getModels(brand.getCode()).getModels();
        var model = new Fipe();
        var years = service.getYears(brand.getCode(), model.getCode());
        var year = new Fipe();
        brand = listContains(car.getBrand(), brands);
        if (brand == null)
            throw new BadRequestException(car.getBrand() + " não encontrada.");
        model = listContains(car.getModel(), models);
        if (model == null)
            throw new BadRequestException(car.getModel() + " não encontrado.");
        year = listContains(car.getYear(), years);
        if (year == null)
            throw new BadRequestException(car.getYear() + " não encontrado.");
        var carDTO = service.getCars(brand.getCode(), model.getCode(), year.getCode());
        car = new Car(carDTO);
        car.setUser(user);
        carDTO.setRotationDay(car.rotationDay());
        car = carRepository.save(car);
        carDTO = new CarDTO(car);
        return carDTO;
    }

    private Fipe listContains(String item, List<Fipe> list) {
        list.stream()
                .filter(i -> i.getName().equalsIgnoreCase(item))
                .collect(Collectors.toList());
        return list.get(0);
    }

    CarDTO calcRotation(CarDTO car) {
        var date = new Date();
        var formatter = new SimpleDateFormat("EEEE", new Locale("pt", "BR"));
        var today = formatter.format(date);

        if (car.getRotationDay().equals(today))
            car.setRotation(true);

        return car;
    }

    List<CarDTO> calcRotation(List<CarDTO> cars) {
        range(0, cars.size())
                .forEach(i -> cars.set(i, calcRotation(cars.get(i))));
        return cars;
    }

}
