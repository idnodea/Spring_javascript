package dto;

public class Board {
	private int  boardID;     //원시키
	private String boardTitle;
	private String memberID;  //외래키
	private String boardDate;
	private String boardContent;
	private int    hits;      //조회수늘리는 용도
	
	private int boardAvailable;

	
	public Board() {
		// TODO Auto-generated constructor stub
	}


	public Board(int boardID, String boardTitle, String memberID, String boardDate, String boardContent, int hits,
			int boardAvailable) {
		super();
		this.boardID = boardID;
		this.boardTitle = boardTitle;
		this.memberID = memberID;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.hits = hits;
		this.boardAvailable = boardAvailable;
	}


	public int getBoardID() {
		return boardID;
	}


	public void setBoardID(int boardID) {
		this.boardID = boardID;
	}


	public String getBoardTitle() {
		return boardTitle;
	}


	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}


	public String getMemberID() {
		return memberID;
	}


	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}


	public String getBoardDate() {
		return boardDate;
	}


	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}


	public String getBoardContent() {
		return boardContent;
	}


	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}


	public int getHits() {
		return hits;
	}


	public void setHits(int hits) {
		this.hits = hits;
	}


	public int getBoardAvailable() {
		return boardAvailable;
	}


	public void setBoardAvailable(int boardAvailable) {
		this.boardAvailable = boardAvailable;
	}


	@Override
	public String toString() {
		return "Board [boardID=" + boardID + ", boardTitle=" + boardTitle + ", memberID=" + memberID + ", boardDate="
				+ boardDate + ", boardContent=" + boardContent + ", hits=" + hits + ", boardAvailable=" + boardAvailable
				+ "]";
	}
	
	
	
//	
//	public Board(int boardID, String boardTitle, String memberID, String boardDate, String boardContent,
//			int boardAvailable) {
//		super();
//		this.boardID = boardID;
//		this.boardTitle = boardTitle;
//		this.memberID = memberID;
//		this.boardDate = boardDate;
//		this.boardContent = boardContent;
//		this.boardAvailable = boardAvailable;
//	}
//
//	public Board() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public int getBoardID() {
//		return boardID;
//	}
//
//	public void setBoardID(int boardID) {
//		this.boardID = boardID;
//	}
//
//	public String getBoardTitle() {
//		return boardTitle;
//	}
//
//	public void setBoardTitle(String boardTitle) {
//		this.boardTitle = boardTitle;
//	}
//
//	public String getMemberID() {
//		return memberID;
//	}
//
//	public void setMemberID(String memberID) {
//		this.memberID = memberID;
//	}
//
//	public String getBoardDate() {
//		return boardDate;
//	}
//
//	public void setBoardDate(String boardDate) {
//		this.boardDate = boardDate;
//	}
//
//	public String getBoardContent() {
//		return boardContent;
//	}
//
//	public void setBoardContent(String boardContent) {
//		this.boardContent = boardContent;
//	}
//
//	public int getBoardAvailable() {
//		return boardAvailable;
//	}
//
//	public void setBoardAvailable(int boardAvailable) {
//		this.boardAvailable = boardAvailable;
//	}
//
//	@Override
//	public String toString() {
//		return "Board [boardID=" + boardID + ", boardTitle=" + boardTitle + ", memberID=" + memberID + ", boardDate="
//				+ boardDate + ", boardContent=" + boardContent + ", boardAvailable=" + boardAvailable + "]";
//	}
//	
//	
	
	
	
}

