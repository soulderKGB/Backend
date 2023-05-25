package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@CrossOrigin(origins = "*")
 public class StoreReview {

    @Autowired
    JdbcTemplate jdbc;
    @RequestMapping(path="/addReview", method= RequestMethod.POST)
    public String storeData(@RequestBody String request) throws IOException{
        // System.out.print(request);
        ObjectMapper myMapper = new ObjectMapper();
        JsonNode extractedData = myMapper.readTree(request);

        String username = extractedData.get("username").asText();
        String UserReview = extractedData.get("UserReview").asText();
        // System.out.print(username);

        jdbc.execute("INSERT INTO `sys`.`reviewtable` (`name`, `review`) VALUES ('"+username+"','"+UserReview+"');");
        return "Review inserted Successfully";
    }
    

    @RequestMapping(path = "/getMovies", method = RequestMethod.GET)
    public List<Movie> getItems() throws IOException{
        List<Movie> items = jdbc.query("SELECT * FROM `sys`.`movielist`", new MovieMapper());
        return items;
    }


//     

//     @RequestMapping("/insert")
//     public String index(){
//         jdbc.execute("INSERT INTO `sys`.`all_items` (`item_id`, `item_title`, `item_price`) VALUES ('5', 'Narnia', '780');");
//         return "Insertion successful";
//     }
    
}
