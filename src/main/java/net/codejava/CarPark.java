package net.codejava;

import javax.persistence.*;

@Entity
public class CarPark {

    private Long id;

    private String car_type;

    private String car_manufacturer;

    private String government_number;

    protected CarPark() {
    }

    public void setId(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getCar_manufacturer() {
        return car_manufacturer;
    }

    public void setCar_manufacturer(String car_manufacturer) {
        this.car_manufacturer = car_manufacturer;
    }

    public String getGovernment_number() {
        return government_number;
    }

    public void setGovernment_number(String government_number) {
        this.government_number = government_number;
    }
}
