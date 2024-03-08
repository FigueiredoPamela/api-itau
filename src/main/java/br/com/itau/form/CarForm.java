package br.com.itau.form;

import br.com.itau.model.Car;
import com.sun.istack.NotNull;

public class CarForm {

    @NotNull
    private String chassi;
    private String name;
    private String manufacturer;
    private int year;
    private String color;
    private String status;
    @NotNull
    private String placa;

    public CarForm() {
    }

    public CarForm(String chassi, String name, String manufacturer, int year, String color, String status, String placa) {
        this.chassi = chassi;
        this.name = name;
        this.manufacturer = manufacturer;
        this.year = year;
        this.color = color;
        this.status = status;
        this.placa = placa;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public Car converter(CarForm carForm) {

        return new Car(chassi, name, manufacturer, year, color, status, placa);
}

}
