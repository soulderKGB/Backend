package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MovieMapper implements RowMapper {
    
    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException{
        Movie movie = new Movie();
        movie.setMovieID(rs.getString("Movie_ID"));
        movie.setMoviePic(rs.getString("Movie_Pic"));
        movie.setMovieTitle(rs.getString("Movie_Title"));
        movie.setMovieDes(rs.getString("Movie_Des"));
       
        return movie;

}
}
