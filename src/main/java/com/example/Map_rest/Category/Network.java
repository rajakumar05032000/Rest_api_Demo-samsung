package com.example.Map_rest.Category;
import javax.persistence.*;

@Entity
@Table(name = "network")
public class Network {
    String name;
    String req;
    int id;

    public void setId(int id) {
        this.id = id;
    }

    public Network()
    {

    }

    public Network(int id, String name, String req) {
        this.name = name;
        this.req = req;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
}
