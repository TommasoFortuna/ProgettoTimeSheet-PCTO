package com.fortuna.ProgettoTimeSheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
public class TimeSheetController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    public boolean login(@RequestBody User inputUser) throws Exception {
        List<User> users = jdbcTemplate.query(
            "SELECT C_USR, C_PWD FROM TS001_USR",
            (rs, rowNum) -> new User(
                rs.getString("C_USR"),
                rs.getString("C_PWD")
            )
        );

        if (users.stream()
                .anyMatch(u -> u.getUsername().equals(inputUser.getUsername()) && u.getPassword().equals(inputUser.getPassword()))) {
            return true;
        }
        else if (users.stream()
                .anyMatch(u -> u.getUsername().equals(inputUser.getUsername()))) {
            throw new Exception("Password errata");
        } else if (users.stream()
                .noneMatch(u -> u.getUsername().equals(inputUser.getUsername()))) {
            throw new Exception("Utente non trovato");
        }
        return false;
    }

    @GetMapping("/index")
    public List<Commessa> getListCommesse() {
        return jdbcTemplate.query(
            "SELECT C_AZN, C_COM, T_COM FROM TS001_COM INNER JOIN TS001_USR ON TS001_COM.C_AZN = TS001_USR.C_AZN",
            (rs, rowNum) -> new Commessa(
                rs.getString("C_AZN"),
                rs.getString("C_COM"),
                rs.getString("T_COM")
            )
        );
    }

    @PutMapping("/updatecommessa")
    public int updateCommessa(@RequestBody Commessa commessa) {
        return jdbcTemplate.update("UPDATE TS001_COM SET T_COM = ? WHERE C_AZN = ? AND C_COM = ?", commessa.getT_COM(), commessa.getC_AZN(), commessa.getC_COM());
    }

    @DeleteMapping("/deletecommessa")
    public int deleteCommessa(@RequestBody Commessa commessa) {
        return jdbcTemplate.update("DELETE FROM TS001_COM WHERE C_AZN = ? AND C_COM = ?", commessa.getC_AZN(), commessa.getC_COM());
    }
}
