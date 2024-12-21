package iuh.edu.vn.backend.repositories;

import iuh.edu.vn.backend.models.Xe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Xe, Long> {
    @Query("select x from Xe x where upper(x.tenXe) like upper(concat('%', ?1, '%'))")
    List<Xe> findByTenXeContainsIgnoreCase(String tenXe);

    @Query("select x from Xe x where x.namSx = ?1")
    List<Xe> findByNamSx(int namSx);
}