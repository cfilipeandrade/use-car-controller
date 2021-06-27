package com.carlos.filipe.controllerusercar.service;

import com.carlos.filipe.controllerusercar.exception.BusinessException;
import com.carlos.filipe.controllerusercar.exception.EntityNotFoundException;
import com.carlos.filipe.controllerusercar.model.User;
import com.carlos.filipe.controllerusercar.model.dto.CarDTO;
import com.carlos.filipe.controllerusercar.model.dto.UserDTO;
import com.carlos.filipe.controllerusercar.repository.CarRepository;
import com.carlos.filipe.controllerusercar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    CarRepository carRepository;
    @Autowired
    CarService carService;

    public UserDTO search(Long id) {
        var user = repository.getById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Usuario de id %d não encontrado.", id)));
        var car = carRepository.findByUserId(user);
        var carDTO = car.stream()
                .map(car1 -> new CarDTO(car1))
                .collect(Collectors.toList());
        carDTO = carService.calcRotation(carDTO);
        var userDTO = new UserDTO(user);
        userDTO.setCars(carDTO);
        return userDTO;
    }

    public User add(User user) {
        var userPresent = repository.findByEmailOrCpf(user.getEmail(), user.getCpf());
        if (userPresent != null && userPresent.equals(user)) {
            throw new BusinessException("Já existe um usuário com este e-mail ou cpf");
        }
        return repository.save(user);
    }

}
