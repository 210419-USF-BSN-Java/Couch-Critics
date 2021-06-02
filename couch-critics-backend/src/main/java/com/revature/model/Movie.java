package com.revature.model;

public class Movie {

	private String original_title;
	private String imdb_id;
	private int runtime;
	private int budget;
	private boolean adult;
	
	public Movie() {
		super();
		
	}
	public Movie(String original_title, String imdb_id, int runtime, int budget, boolean adult) {
		super();
		this.original_title = original_title;
		this.imdb_id = imdb_id;
		this.runtime = runtime;
		this.budget = budget;
		this.adult = adult;
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
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adult ? 1231 : 1237);
		result = prime * result + budget;
		result = prime * result + ((imdb_id == null) ? 0 : imdb_id.hashCode());
		result = prime * result + ((original_title == null) ? 0 : original_title.hashCode());
		result = prime * result + runtime;
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
		if (runtime != other.runtime)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Movie [original_title=" + original_title + ", imdb_id=" + imdb_id + ", runtime=" + runtime + ", budget="
				+ budget + ", adult=" + adult + "]";
	}
	
}
