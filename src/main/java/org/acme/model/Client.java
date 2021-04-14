package org.acme.model;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class Client {

    public Client(String name, Car car, Address... address) {
        this.name = name;        
        this.car = car;
        this.address = address;
    }

    private String name;

    // @Schema(implementation = Address[].class)
    private Address[] address;

    private Car car;

    public static class Address {
        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }

        private String street;

        private int number;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

    public static class Car {

        public Car(String name, int year) {
            this.name = name;
            this.year = year;
        }

        private String name;

        private int year;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address[] getAddress() {
        return address;
    }

    public void setAddress(Address[] address) {
        this.address = address;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
