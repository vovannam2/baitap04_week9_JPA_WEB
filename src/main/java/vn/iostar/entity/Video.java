package vn.iostar.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name = "videos")
@NamedQuery(name = "Video.findAll", query = "SELECT c FROM Video c")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id

	@Column(name = "videoId")
	private String videoId;
	@Column(name = "active")
	private boolean active;
	@Column(name = "description", columnDefinition = "NVARCHAR(MAX) NULL")
	private String description;
	@Column(name = "poster", columnDefinition = "NVARCHAR(255) NULL")
	private String poster;
	@Column(name = "title", columnDefinition = "NVARCHAR(255) NULL")
	private String title;
	@Column(name = "views")
	private int views;
	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	public Video() {
		
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
