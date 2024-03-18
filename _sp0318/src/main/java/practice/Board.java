package practice;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
public class Board {
	private int num;
	private String writer;
	private String title;
	private String content;
	private String regtime;
	private int hits;
	private int memberno;
	
	public Board() {
		
	}
	
	

	
	
}
