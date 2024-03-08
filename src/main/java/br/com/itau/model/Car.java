package br.com.itau.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String chassi;
    private String name;
    private String manufacturer;
    @Column(name = "caryear")
    private int carYear;
    private String color;
    private String status;
    private String placa;

    public Car() {
    }

    public Car(String chassi, String name, String manufacturer, int carYear, String color, String status, String placa) {
        this.chassi = chassi;
        this.name = name;
        this.manufacturer = manufacturer;
        this.carYear = carYear;
        this.color = color;
        this.status = status;
        this.placa = placa;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (!Objects.equals(this.chassi, other.chassi)) {
            return false;
        }
        return Objects.equals(this.placa, other.placa);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.chassi);
        hash = 53 * hash + Objects.hashCode(this.placa);
        return hash;
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
}
