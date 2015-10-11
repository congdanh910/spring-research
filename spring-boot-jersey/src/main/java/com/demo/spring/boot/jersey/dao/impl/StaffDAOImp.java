package com.demo.spring.boot.jersey.dao.impl;

import com.demo.spring.boot.jersey.dao.StaffDAO;
import com.demo.spring.boot.jersey.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by CongDanh on 10/11/15.
 */
@Repository
public class StaffDAOImp implements StaffDAO {

    private static final String TABLE_NAME = "staffs";
    @Autowired
    @Qualifier("dropwizardJdbcTemplate") // @Qualifier("springBootJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Staff> fetchAll() {
        String query = "SELECT * FROM " + TABLE_NAME;
        return jdbcTemplate.query(query, staffMapper);
    }

    private static final RowMapper<Staff> staffMapper = new RowMapper<Staff>() {
        public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
            Staff staff = new Staff();
            staff.setId(rs.getLong("id"));
            staff.setFirstName(rs.getString("first_name"));
            staff.setLastName(rs.getString("last_name"));
            staff.setMiddleName(rs.getString("middle_name"));
            staff.setAddress(rs.getString("address"));
            staff.setBirthday(rs.getTimestamp("birthday"));
            staff.setSalary(rs.getInt("salary"));
            staff.setCurrency(rs.getString("currency"));
            return staff;
        }
    };
}
