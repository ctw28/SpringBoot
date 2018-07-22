package com.example.latihan_spring.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MahasiswaController {
    @RequestMapping("/mahasiswa")
    public Map<String, Object> halo(@RequestParam("nama") String nama){
        Map<String, Object> hasil = new HashMap<>();
        hasil.put("Nama", nama);
        return hasil;
    }
}
