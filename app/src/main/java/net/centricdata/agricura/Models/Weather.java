package net.centricdata.agricura.Models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity

public class Weather {

    @Id(autoincrement = true)
    Long id;

    String city;
    String currentTemp;
    @Generated(hash = 588308236)
    public Weather(Long id, String city, String currentTemp) {
        this.id = id;
        this.city = city;
        this.currentTemp = currentTemp;
    }
    @Generated(hash = 556711069)
    public Weather() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCurrentTemp() {
        return this.currentTemp;
    }
    public void setCurrentTemp(String currentTemp) {
        this.currentTemp = currentTemp;
    }
}
