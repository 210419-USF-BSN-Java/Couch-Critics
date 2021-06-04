package com.revature.model;

public class Movie {

	private String original_title;
	private String imdb_id;
	private Integer runtime;
	private Integer budget;
	private Boolean adult;
	private String overview;
	private Double popularity;
	private Double vote_average;
	private Integer vote_count;
	private String homepage;
	private String poster_path;
	
	public Movie() {
		super();
	}
	
	public Movie(String original_title, String imdb_id, Integer runtime, Integer budget, Boolean adult, String overview,
			Double popularity, Double vote_average, Integer vote_count, String homepage, String poster_path) {
		super();
		this.original_title = original_title;
		this.imdb_id = imdb_id;
		this.runtime = runtime;
		this.budget = budget;
		this.adult = adult;
		this.overview = overview;
		this.popularity = popularity;
		this.vote_average = vote_average;
		this.vote_count = vote_count;
		this.homepage = homepage;
		this.poster_path = poster_path;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public Integer getBudget() {
		return budget;
	}

	public void setBudget(Integer budget) {
		this.budget = budget;
	}

	public Boolean isAdult() {
		return adult;
	}

	public void setAdult(Boolean adult) {
		this.adult = adult;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public Double getPopularity() {
		return popularity;
	}

	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}

	public Double getVote_average() {
		return vote_average;
	}

	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}

	public Integer getVote_count() {
		return vote_count;
	}

	public void setVote_count(Integer vote_count) {
		this.vote_count = vote_count;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	@Override
	public int hashCode() {
		final Integer prime = 31;
		Integer result = 1;
		result = prime * result + (adult ? 1231 : 1237);
		result = prime * result + budget;
		result = prime * result + ((homepage == null) ? 0 : homepage.hashCode());
		result = prime * result + ((imdb_id == null) ? 0 : imdb_id.hashCode());
		result = prime * result + ((original_title == null) ? 0 : original_title.hashCode());
		result = prime * result + ((overview == null) ? 0 : overview.hashCode());
		result = prime * result + ((popularity == null) ? 0 : popularity.hashCode());
		result = prime * result + ((poster_path == null) ? 0 : poster_path.hashCode());
		result = prime * result + runtime;
		result = prime * result + ((vote_average == null) ? 0 : vote_average.hashCode());
		result = prime * result + ((vote_count == null) ? 0 : vote_count.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (adult != other.adult)
			return false;
		if (budget != other.budget)
			return false;
		if (homepage == null) {
			if (other.homepage != null)
				return false;
		} else if (!homepage.equals(other.homepage))
			return false;
		if (imdb_id == null) {
			if (other.imdb_id != null)
				return false;
		} else if (!imdb_id.equals(other.imdb_id))
			return false;
		if (original_title == null) {
			if (other.original_title != null)
				return false;
		} else if (!original_title.equals(other.original_title))
			return false;
		if (overview == null) {
			if (other.overview != null)
				return false;
		} else if (!overview.equals(other.overview))
			return false;
		if (popularity == null) {
			if (other.popularity != null)
				return false;
		} else if (!popularity.equals(other.popularity))
			return false;
		if (poster_path == null) {
			if (other.poster_path != null)
				return false;
		} else if (!poster_path.equals(other.poster_path))
			return false;
		if (runtime != other.runtime)
			return false;
		if (vote_average == null) {
			if (other.vote_average != null)
				return false;
		} else if (!vote_average.equals(other.vote_average))
			return false;
		if (vote_count == null) {
			if (other.vote_count != null)
				return false;
		} else if (!vote_count.equals(other.vote_count))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [original_title=" + original_title + ", imdb_id=" + imdb_id + ", runtime=" + runtime + ", budget="
				+ budget + ", adult=" + adult + ", overview=" + overview + ", popularity=" + popularity
				+ ", vote_average=" + vote_average + ", vote_count=" + vote_count + ", homepage=" + homepage
				+ ", poster_path=" + poster_path + "]";
	}
	
}
	
