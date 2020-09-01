package model;


public class Post {
	
	private int id;
	private String post;
	private int likeCount;
	private int dislikeCount;
	private int userId;
	
	public Post() {
		super();
	}

	public Post(int id, String post, int likeCount, int dislikeCount, int userId) {
		super();
		this.id = id;
		this.post = post;
		this.likeCount = likeCount;
		this.dislikeCount = dislikeCount;
		this.userId = userId;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getDislikeCount() {
		return dislikeCount;
	}
	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
