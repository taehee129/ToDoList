package model.board;

public class MemoVO {
	private int id;
	private int parentId;
	private String title;
	private String content;
	@Override
	public String toString() {
		return "MemoVO [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
