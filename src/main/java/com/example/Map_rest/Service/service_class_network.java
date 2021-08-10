package com.example.Map_rest.Service;
import com.example.Map_rest.Repo.network_repo;
import com.example.Map_rest.Category.Network;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class service_class_network {

        @Autowired
        private network_repo nr_obj;

        public List<Network> listAlldata_network() {
            return nr_obj.findAll();
        }

        public void savedata_network(Network np) {
            nr_obj.save(np);
        }

        public Network getnetwork_status(Integer id) {
            return nr_obj.findById(id).get();
        }

        public void deletenetwork_status(Integer id) {
            nr_obj.deleteById(id);
        }

    }

