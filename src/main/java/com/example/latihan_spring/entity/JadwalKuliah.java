package com.example.latihan_spring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

@Entity @Table(name = "t_jadwal")
public class JadwalKuliah {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Temporal(TemporalType.DATE) //agar yang disimpan tanggal saja
    private Date mulai;

    @Temporal(TemporalType.DATE) //agar yang disimpan tanggal saja
    private Date selesai;
    
    @ManyToOne
    @JoinColumn(name = "id_matkul", nullable = false)
    private MataKuliah matkul;
    
    @ManyToMany
    @JoinTable(name = "t_jadwal_mahasiswa",
            joinColumns = @JoinColumn(name = "id_jadwal_mahasiswa"),
            inverseJoinColumns = @JoinColumn(name = "id_mahasiswa")
    )
    private List<Mahasiswa> daftarMahasiswa = new ArrayList<>();
}
