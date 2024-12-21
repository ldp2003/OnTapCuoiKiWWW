package iuh.edu.vn.backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car", schema = "car")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tenXe", nullable = false)
    private String tenXe;

    @Column(name = "gia", nullable = false)
    private Double gia;

    @Column(name = "namSx", nullable = false)
    private Integer namSx;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "maLoai")
    @JsonIgnoreProperties({"cars"})
    private LoaiXe maLoai;

    @Column(name = "maXe", nullable = false)
    private Long maXe;

    @Column(name = "ngayChinhSua", nullable = false)
    private LocalDate ngayChinhSua;

    @Column(name = "trangThai", nullable = false)
    private Boolean trangThai = false;

}