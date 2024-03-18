package mvjsp.board.model;

public class Board {
	private int num;
	
	private String title;
	private String content;
	private String regtime;
	private int hits;
	private int memberno;
	
	
	private String name;
	
	
	
	public Board(String title, String content, String name) {
		super();
		this.title = title;
		this.content = content;
		this.name = name;
	}


	public Board(int num, String title, String content, String regtime, int hits, int memberno, String name) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
		this.memberno = memberno;
		this.name = name;
	}
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", content=" + content + ", regtime=" + regtime + ", hits="
				+ hits + ", memberno=" + memberno + ", name=" + name + "]";
	}
	
	
	
	

	
	//게터세터,유징필드,투스트링 dto
	
}
//mysql project1 board 테이블명=필드명
//직접 접근못하게 프라이베이트속성
//num, writer, title, content, regtime, hits

