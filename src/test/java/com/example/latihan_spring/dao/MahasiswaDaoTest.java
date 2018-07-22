
package com.example.latihan_spring.dao;

import com.example.latihan_spring.entity.Mahasiswa;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

@Sql(
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = "/data/mahasiswa.sql"
)
public class MahasiswaDaoTest {
    @Autowired
    private MahasiswaDao md; 
    
    @Autowired    
    private DataSource ds;
    
    
    @Test
    public void testHitung(){
        Long jumlahBaris = md.count();
        Assert.assertEquals(3L, jumlahBaris.longValue());
    }
    
    @Test
    public void testInsert() throws SQLException{
        Mahasiswa m = new Mahasiswa();
        m.setNama("Rigi");
        m.setEmail("mbandrigo@gmail.com");
        m.setTanggalLahir(new Date());
        md.save(m);
        
        String sql ="SELECT COUNT(*) as jumlah FROM t_mahasiswa WHERE email='mbandrigo@gmail.com'";
        Connection c = ds.getConnection();
        
        ResultSet rs = c.createStatement().executeQuery(sql);
        Assert.assertTrue(rs.next());
        
        Long jumlahBaris = rs.getLong("jumlah");
        
        Assert.assertEquals(1L, jumlahBaris.longValue());
        
        c.close();
        
    }

    
    
}
