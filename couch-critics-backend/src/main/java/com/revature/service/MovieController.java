package com.revature.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Movie;

@RestController
@RequestMapping(value="/movie")
public class MovieController {

	//Gets the movie id from the path variable
	//Returns a custom movie object
	//Request may take up to a minute
	@GetMapping(value="/{id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable("id") Integer movieId){
		RestTemplate rt = new RestTemplate();
		String apiKey = System.getenv("movie_api_key");
		String url = "https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey;
		return rt.getForEntity(url, Movie.class);
	}
}
