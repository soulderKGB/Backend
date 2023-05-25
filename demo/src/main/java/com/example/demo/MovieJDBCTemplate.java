package com.example.demo;


import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MovieJDBCTemplate implements MovieDAO{
    DataSource dataSource;
    JdbcTemplate myTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.myTemplate = new JdbcTemplate((dataSource));
    }

    public List<Movie> allMovies(){
        String fetchMovies = "SELECT * FROM `sys`.`movies_list`";
        List<Movie> movies = myTemplate.query(fetchMovies, new MovieMapper());
        return movies;
    }
}