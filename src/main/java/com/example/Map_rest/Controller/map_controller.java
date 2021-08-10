package com.example.Map_rest.Controller;
import com.example.Map_rest.Category.Map;
import com.example.Map_rest.Service.service_class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;



@RestController
@RequestMapping("/Map")
public class map_controller {
    @Autowired
    service_class scobj;

    @GetMapping("")
    public List<Map> list() {
        return scobj.listAlldata();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> get(@PathVariable Integer id) {
        try {
            Map map = scobj.getMap_status(id);
            return new ResponseEntity<Map>(map, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Map>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")

    public void add(@RequestBody Map map) {
        scobj.savedata(map);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Map map, @PathVariable Integer id) {
        try {
            Map map1 = scobj.getMap_status(id);
            map1.setId(id);
            scobj.savedata(map);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        scobj.deleteMap_status(id);
    }

}
