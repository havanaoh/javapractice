package dto;

public class Board {
	int boardno;
	String title;
	String content;
	String regtime;
	int hits;
	int memberno;
	
	public Board(int boardno, String title, String content, String regtime, int hits, int memberno) {
		super();
		this.boardno = boardno;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
		this.memberno = memberno;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
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

	public String getRegtime() {
		return regtime;
	}

	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	@Override
	public String toString() {
		return "Board [boardno=" + boardno + ", title=" + title + ", content=" + content + ", regtime=" + regtime
				+ ", hits=" + hits + ", memberno=" + memberno + "]";
	}
	
	
}
