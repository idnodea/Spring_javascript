package com.idea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.idea.dto.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> selectBoardList();
	
	int selectCount();
	
	void insertBoard(BoardDto board);   //sql-board.xml 이름과 같아야함

//	BoardDto selectBoardDetail(int boardIdx);
//
//	void updateHitCount(int boardIdx);
//	
	void updateBoard(BoardDto board);
	
	void deleteBoard(int id);  //매개변수값은 상관없
}
