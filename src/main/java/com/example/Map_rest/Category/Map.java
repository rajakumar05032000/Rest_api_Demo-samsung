package com.example.Map_rest.Category;
import javax.persistence.*;

@Entity
@Table(name = "map")
public class Map {
    int id;
    String latitude;
    String longitude;

    public Map() {
    }

    public Map(int id, String latitude, String longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

}
