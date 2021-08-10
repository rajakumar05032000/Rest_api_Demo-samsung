package com.example.Map_rest.Controller;

import com.example.Map_rest.Category.Network;
import com.example.Map_rest.Service.service_class_network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;



@RestController
@RequestMapping("/network")
public class network_controller {
    @Autowired
    service_class_network scobj;

    @GetMapping("")
    public List<Network> list() {
        return scobj.listAlldata_network();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Network> get(@PathVariable Integer id) {
        try {
            Network network = scobj.getnetwork_status(id);
            return new ResponseEntity<Network>(network, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Network>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Network network) {
        scobj.savedata_network(network);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Network network, @PathVariable Integer id) {
        try {
            Network network1 = scobj.getnetwork_status(id);
            network1.setId(id);
            scobj.savedata_network(network);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        scobj.deletenetwork_status(id);
    }

}
