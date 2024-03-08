package br.com.itau.controller;

import br.com.itau.dto.CarDto;
import br.com.itau.form.CarForm;
import br.com.itau.model.Car;
import br.com.itau.model.CarStatusEnum;
import br.com.itau.repository.CarRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    public CarRepository carRepository;

    @PostMapping("/create")
    public ResponseEntity<CarDto> createCar(@RequestBody @Valid CarForm carForm) {
        Car car = carForm.converter(carForm);
        List<Car> listCars = carRepository.findByChassiOrPlaca(car.getChassi(), car.getPlaca());
        if (!listCars.isEmpty()) {
            throw new RuntimeException("Um mesmo carro com este chassi ou placa já existe!");
        }
        if (!CarStatusEnum.isValidCarStatus(car.getStatus())) {
            throw new RuntimeException("Status de carro inválido!");
        }
        carRepository.save(car);
        CarDto carDto = new CarDto(car);
        return ResponseEntity.ok().body(carDto);
    }

    @PutMapping("/changeStatus/{id}")
    public CarDto changeStatus(@PathVariable long id, @RequestBody @Valid CarForm carForm) {
        Car carFromClient = carForm.converter(carForm);
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isEmpty()) {
            throw new RuntimeException("Id inválido!");
        }
        if (!CarStatusEnum.isValidCarStatus(carFromClient.getStatus())) {
            throw new RuntimeException("Status de carro inválido!");
        }
        Car existingCar = carFromClient;
        carRepository.save(existingCar);
        CarDto carDto = new CarDto(existingCar);
        return carDto;
    }

    @GetMapping("/list")
    public ResponseEntity<List<CarDto>> list() {
        List<Car> cars = carRepository.findAll();
        CarDto.validEmptyList(cars);
        return CarDto.generateList(cars);
    }

    @GetMapping("/listByName/{name}")
    public ResponseEntity<List<CarDto>> getListByName(@PathVariable String name) {
        List<Car> cars = carRepository.findByName(name);
        CarDto.validEmptyList(cars);
        return CarDto.generateList(cars);
    }

    @GetMapping("/listByManufacturer/{manufacturer}")
    public ResponseEntity<List<CarDto>> getListByManufacturer(@PathVariable String manufacturer) {
        List<Car> cars = carRepository.findByManufacturer(manufacturer);
        CarDto.validEmptyList(cars);
        return CarDto.generateList(cars);
    }

    @GetMapping("/listByYear/{year}")
    public ResponseEntity<List<CarDto>> getListByYear(@PathVariable int year) {
        List<Car> cars = carRepository.findByCarYear(year);
        CarDto.validEmptyList(cars);
        return CarDto.generateList(cars);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isEmpty()) {
            throw new RuntimeException("Id inválido!");
        }
        carRepository.delete(optionalCar.get());
        return ResponseEntity.ok("Carro deletado!");
    }
    
    @GetMapping("/details/{id}")
    public ResponseEntity<CarDto> getDetails(@PathVariable long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isEmpty()) {
            throw new RuntimeException("Id inválido!");
        }
        CarDto cardto = new CarDto(optionalCar.get());
        return ResponseEntity.ok(cardto);
    }
    
}
