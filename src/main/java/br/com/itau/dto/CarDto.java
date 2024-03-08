package br.com.itau.dto;

import br.com.itau.exception.CarException;
import br.com.itau.model.Car;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public class CarDto {

    private long id;
    private String chassi;
    private String name;
    private String manufacturer;
    private int carYear;
    private String color;
    private String status;
    private String placa;

    public CarDto(Car car) {
        this.id = car.getId();
        this.chassi = car.getChassi();
        this.name = car.getName();
        this.manufacturer = car.getManufacturer();
        this.carYear = car.getCarYear();
        this.color = car.getColor();
        this.status = car.getStatus();
        this.placa = car.getPlaca();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public static List<CarDto> converter(List<Car> cars) {
        return cars.stream().map(CarDto::new).collect(Collectors.toList());
    }

    public static List<Car> groupByManufacturerOrderByNameAndYear(List<Car> cars) {
        return cars.stream()
                .sorted((c1, c2) -> {
                    if (!c1.getManufacturer().equals(c2.getManufacturer())) {
                        return c1.getManufacturer().compareTo(c2.getManufacturer());
                    } else if (!c1.getName().equals(c2.getName())) {
                        return c1.getName().compareTo(c2.getName());
                    } else {
                        return Integer.compare(c1.getCarYear(), c2.getCarYear());
                    }
                })
                .collect(Collectors.toList());
    }

    public static ResponseEntity<List<CarDto>> generateList(List<Car> cars) {
        validEmptyList(cars);
        cars = groupByManufacturerOrderByNameAndYear(cars);
        List<CarDto> carDtoList = converter(cars);
        return ResponseEntity.ok().body(carDtoList);
    }

    public static void validEmptyList(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista Vazia!");
        }
    }

}
