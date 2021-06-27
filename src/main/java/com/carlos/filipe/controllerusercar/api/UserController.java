package com.carlos.filipe.controllerusercar.api;

import com.carlos.filipe.controllerusercar.model.Car;
import com.carlos.filipe.controllerusercar.model.User;
import com.carlos.filipe.controllerusercar.model.dto.CarDTO;
import com.carlos.filipe.controllerusercar.model.dto.UserDTO;
import com.carlos.filipe.controllerusercar.service.CarService;
import com.carlos.filipe.controllerusercar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UserController {

    @Autowired
    UserService service;
    @Autowired
    CarService carService;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<UserDTO> search(@PathVariable("userId") Long id) {
        var user = service.search(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User add(@Validated @RequestBody User user) {
        return service.add(user);
    }

    @PostMapping("/{usuarioId}/veiculo")
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO addCar(@Validated @RequestBody Car car, @PathVariable("userId") Long id) {
        return carService.add(car, id);
    }
}
