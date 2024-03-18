package dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class BoardDto {
    private int    num     = 0;
    private String writer  = "";
    private String title   = "";
    private String content = "";
    private String regtime = "";
    private int    hits    = 0;
    
    private int memberno;
    
    //게터세터삭제
    
}