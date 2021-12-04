package com.example.vehicleproject;


public class Users {
    String ownerName, vehicleNumberplate, registeringAuthority,  vehicleClass,
            RCstatus, fuelType, vehicleAge, registrationDate, insuraceValidupto,secondowner,secondowneraadhaar,thirdowner,thirdowneraadhaar,owneraadhaar;

    public Users() {
    }

    public Users(String ownerName, String vehicleNumberplate, String registeringAuthority, String vehicleClass, String RCstatus, String fuelType, String vehicleAge, String registrationDate, String insuraceValidupto,String secondowner,String secondowneraadhaar,String thirdowner,String thirdowneraadhaar,String owneraadhaar) {
        this.ownerName = ownerName;
        this.vehicleNumberplate = vehicleNumberplate;
        this.registeringAuthority = registeringAuthority;
        this.vehicleClass = vehicleClass;
        this.RCstatus = RCstatus;
        this.fuelType = fuelType;
        this.vehicleAge = vehicleAge;
        this.registrationDate = registrationDate;
        this.insuraceValidupto = insuraceValidupto;
        this.secondowner=secondowner;
        this.secondowneraadhaar=secondowneraadhaar;
        this.thirdowner=thirdowner;
        this.thirdowneraadhaar=thirdowneraadhaar;
        this.owneraadhaar=owneraadhaar;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getVehicleNumberplate() {
        return vehicleNumberplate;
    }

    public void setVehicleNumberplate(String vehicleNumberplate) {
        this.vehicleNumberplate = vehicleNumberplate;
    }

    public String getRegisteringAuthority() {
        return registeringAuthority;
    }

    public void setRegisteringAuthority(String registeringAuthority) {
        this.registeringAuthority = registeringAuthority;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public String getRCstatus() {
        return RCstatus;
    }

    public void setRCstatus(String RCstatus) {
        this.RCstatus = RCstatus;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getVehicleAge() {
        return vehicleAge;
    }

    public void setVehicleAge(String vehicleAge) {
        this.vehicleAge = vehicleAge;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
    public String getSecondowner() {
        return secondowner;
    }

    public void setSecondowner(String secondowner) {
        this.secondowner = secondowner;
    }
    public String getSecondowneraadhaar() {
        return secondowneraadhaar;
    }

    public void setSecondowneraadhaar(String secondowneraadhaar) {
        this.secondowneraadhaar = secondowneraadhaar;
    }

    public String getThirdowner() {
        return thirdowner;
    }

    public void setThirdowner(String thirdowner) {
        this.thirdowner = thirdowner;
    }
    public String getThirdowneraadhaar() {
        return thirdowneraadhaar;
    }

    public void setThirdowneraadhaar(String thirdowneraadhaar) {
        this.thirdowneraadhaar = thirdowneraadhaar;
    }
    public String getOwneraadhaar() {
        return owneraadhaar;
    }

    public void setOwneraadhaar(String owneraadhaar) {
        this.owneraadhaar = owneraadhaar;
    }

    public String getInsuraceValidupto() {
        return insuraceValidupto;
    }

    public void setInsuraceValidupto(String insuraceValidupto) {
        this.insuraceValidupto = insuraceValidupto;
    }
}
