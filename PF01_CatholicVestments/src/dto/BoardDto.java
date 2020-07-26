package dto;

import java.sql.Date;

public class BoardDto {
	private int no;
	private String title; 
	private String user_id; 
	private String content;
	private int boardAble; // 0: 삭제, 1: 읽기가능
	private Date write_date;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBoardAble() {
		return boardAble;
	}
	public void setBoardAble(int boardAble) {
		this.boardAble = boardAble;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	
	
}
