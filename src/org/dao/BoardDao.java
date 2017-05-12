package org.dao;

import java.util.List;

import org.model.Board;

public interface BoardDao {
	//-----------------------------------增---------------------------------------
	public long addBoard(Board b);
	//-----------------------------------删---------------------------------------
	public boolean deleteBoard(long id);
	//-----------------------------------改---------------------------------------
	public boolean updateBoard(Board b);
	//-----------------------------------查---------------------------------------
	public List getBoardList();
}
