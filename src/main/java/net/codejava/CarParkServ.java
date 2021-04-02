package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarParkServ {
    @Autowired
    private CarParkRepos repo;

    public List<CarPark> listAll() {
        return repo.findAll();
    }

    public void save(CarPark carPark) {
        repo.save(carPark);
    }

    public CarPark get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
