package iuh.edu.vn.backend.repositories;

import iuh.edu.vn.backend.models.LoaiXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartypeRepository extends JpaRepository<LoaiXe, Long> {
}