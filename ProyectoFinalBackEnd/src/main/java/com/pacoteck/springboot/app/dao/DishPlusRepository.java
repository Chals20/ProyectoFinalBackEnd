package com.pacoteck.springboot.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pacoteck.springboot.app.dto.DishPlus;

@Repository
public class DishPlusRepository {

	@Autowired
	private JdbcOperations jdbc;
	
    
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
	
	
    public List<DishPlus> findAllUsernames(int ticket) {
        return jdbc.queryForObject(
        		"SELECT dishs.id,dishs.namee,dishs.img,dishs.price,dish_order.amount "
        				+ "FROM orders JOIN dish_order ON orders.id = dish_order.orden " + 
        				"JOIN dishs ON dishs.id = dish_order.dish " +
        				"WHERE orders.id ="+ticket,
                new usuarioListaRowMapper() );
    }
    private class usuarioRowMapper implements RowMapper<DishPlus> {

        @Override
        public DishPlus mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new DishPlus(
                    rs.getLong("id"),
                    rs.getString("namee"),
                    rs.getString("img"),
                    rs.getDouble("price"),
                    rs.getInt("amount"));
        }
    }
    
    private  class usuarioListaRowMapper implements RowMapper<List<DishPlus>> {
        @Override
        public List<DishPlus> mapRow(ResultSet rs, int rowNum) throws SQLException {
            ArrayList<DishPlus> listaUsuarios = new ArrayList();
            do
            {listaUsuarios.add(new DishPlus(
                        rs.getLong("id"),
                        rs.getString("namee"),
                        rs.getString("img"),
                        rs.getDouble("price"),
                        rs.getInt("amount")));
            } while (rs.next());
            return listaUsuarios;
        }
    }
}
