package iuh.edu.vn.backend.services;

import iuh.edu.vn.backend.models.Xe;
import iuh.edu.vn.backend.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XeService  {
    @Autowired
    private CarRepository carRepository;

    public void add(Xe xe) {
        carRepository.save(xe);
    }

    public void update(Xe xe) {
        carRepository.save(xe);
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public Xe findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Xe> findAll() {
        return carRepository.findAll();
    }

    public List<Xe> TimKiem(String searchTerm, String searchCriteria) {
        switch (searchCriteria){
            case "tenXe":
                return carRepository.findByTenXeContainsIgnoreCase(searchTerm);
            case "namSx":
            default:
                return carRepository.findByNamSx(Integer.parseInt(searchTerm));
        }
    }
}
