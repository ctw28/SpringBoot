package com.example.latihan_spring.dao;


import com.example.latihan_spring.entity.Mahasiswa;
import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface MahasiswaDao extends PagingAndSortingRepository<Mahasiswa, String>{
    
}
