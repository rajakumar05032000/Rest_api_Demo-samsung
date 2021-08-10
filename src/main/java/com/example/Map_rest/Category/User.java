package com.example.Map_rest.Category;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;

    @Entity
    @Table(name = "user")
    public class User {
        String name;
        String password;
        int id;

        public User() {
        }

        public User(String name, String password, int id) {
            this.name = name;
            this.password = password;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public int getId() {
            return id;
        }

    }
