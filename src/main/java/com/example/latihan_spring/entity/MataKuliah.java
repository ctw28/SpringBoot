package com.example.latihan_spring.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name = "t_matkul")
public class MataKuliah {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(name = "kode_matkul", nullable = true, unique = true, length = 10)
    private String KodeMatkul;
    
    @Column(name = "nama_matkul", nullable = true)
    private String NamaMatkul;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "matkul")
    private List<JadwalKuliah> daftarJadwalKuliah = new ArrayList<>();
    
    
}
