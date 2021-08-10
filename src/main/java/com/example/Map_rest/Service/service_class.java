package com.example.Map_rest.Service;

import com.example.Map_rest.Category.Map;
import com.example.Map_rest.Repo.map_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class service_class {

    @Autowired
    private map_repo mr_obj;

    public List<Map> listAlldata() {
        return mr_obj.findAll();
    }

    public void savedata(Map np) {
        mr_obj.save(np);
    }

    public Map getMap_status(Integer id) {
        return mr_obj.findById(id).get();
    }

    public void deleteMap_status(Integer id) {
        mr_obj.deleteById(id);
    }

}
