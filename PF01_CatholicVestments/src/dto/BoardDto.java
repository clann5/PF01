package dto;

import java.sql.Date;

public class BoardDto {
	private int no;
	private String title; 
	private String userId; 
	private String content;
	private int boardAble; // 0: 삭제, 1: 읽기가능
	private Date writeDate;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
}
