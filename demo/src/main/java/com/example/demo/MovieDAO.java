package com.example.demo;

import java.util.List;
import javax.sql.DataSource;

public interface MovieDAO {
    public void setDataSource(DataSource ds);
    public List<Movie> allMovies();
}