package iuh.edu.vn.backend.services;

import iuh.edu.vn.backend.models.LoaiXe;
import iuh.edu.vn.backend.repositories.CartypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoaiXeService {
    @Autowired
    CartypeRepository loaiXeRepository;

    public void add(LoaiXe loaiXe) {
        loaiXeRepository.save(loaiXe);
    }

    public void update(LoaiXe loaiXe) {
        loaiXeRepository.save(loaiXe);
    }

    public void delete(LoaiXe loaiXe) {
        loaiXeRepository.delete(loaiXe);
    }

    public LoaiXe findById(Long id) {
        return loaiXeRepository.findById(id).orElse(null);
    }

    public Iterable<LoaiXe> findAll() {
        return loaiXeRepository.findAll();
    }

}
