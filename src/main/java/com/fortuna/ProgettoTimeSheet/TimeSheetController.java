package com.fortuna.ProgettoTimeSheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeSheetController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostMapping("/login")
    public LoginStatus checkLogin(@RequestBody User inputUser) {
        List<User> users = jdbcTemplate.query(
                "SELECT C_USR, C_PWD FROM TS001_USR",
                (rs, rowNum) -> new User(
                        rs.getString("C_USR"),
                        rs.getString("C_PWD")));

        if (users.stream()
                .anyMatch(u -> u.getUsername().equals(inputUser.getUsername())
                        && u.getPassword().equals(inputUser.getPassword()))) {
            return new LoginStatus(true, "Login effettuato con successo");
        } else if (users.stream()
                .anyMatch(u -> u.getUsername().equals(inputUser.getUsername()))) {
            return new LoginStatus(false, "Password errata");
        } else if (users.stream()
                .noneMatch(u -> u.getUsername().equals(inputUser.getUsername()))) {
            return new LoginStatus(false, "Utente non trovato");
        }
        return new LoginStatus(false, "Login fallito");
    }

    @GetMapping("/index")
    public List<Commessa> getListCommesse() {
        return jdbcTemplate.query(
                "SELECT C_AZN, C_COM, T_COM, D_INS FROM TS001_COM INNER JOIN TS001_USR ON TS001_COM.C_AZN = TS001_USR.C_AZN ORDER BY D_INS DESC",
                (rs, rowNum) -> new Commessa(
                        rs.getString("C_AZN"),
                        rs.getString("C_COM"),
                        rs.getString("T_COM"),
                        rs.getDate("D_INS")));
    }

    @PostMapping("/add")
    public int addCommessa(@RequestBody Commessa commessa) {
        return jdbcTemplate.update("INSERT INTO TS001_COM (C_AZN, C_COM, T_COM, D_INS) VALUES (?, ?, ?, ?)",
                commessa.getC_AZN(), commessa.getC_COM(), commessa.getT_COM(), commessa.getD_INS());
    }

    @PutMapping("/update")
    public int updateCommessa(@RequestBody Commessa commessa) {
        return jdbcTemplate.update("UPDATE TS001_COM SET T_COM = ? WHERE C_AZN = ? AND C_COM = ?", commessa.getT_COM(),
                commessa.getC_AZN(), commessa.getC_COM());
    }

    @DeleteMapping("/delete")
    public int deleteCommessa(@RequestBody Commessa commessa) {
        return jdbcTemplate.update("DELETE FROM TS001_COM WHERE C_AZN = ? AND C_COM = ?", commessa.getC_AZN(),
                commessa.getC_COM());
    }
}
