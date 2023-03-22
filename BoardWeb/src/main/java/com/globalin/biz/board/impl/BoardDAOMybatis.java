package com.globalin.biz.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globalin.biz.board.BoardVO;

@Repository
//public class BoardDAOMybatis extends SqlSessionDaoSupport { // 첫번재 방법

public class BoardDAOMybatis { // 두번재 방법
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//		// TODO Auto-generated method stub
//		super.setSqlSessionFactory(sqlSessionFactory);
//	}
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis로  insertBoard() 기능처리...");
//		getSqlSession().insert("BoardDAO.insertBoard", vo);
		mybatis.insert("BoardDAO.insertBoard", vo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis로  updateBoard() 기능처리...");
//		getSqlSession().update("BoardDAO.updateBoard", vo);
		mybatis.update("BoardDAO.updateBoard", vo);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis로  deleteBoard() 기능처리...");
//		getSqlSession().delete("BoardDAO.deleteBoard", vo);
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> Mybatis로  getBoard() 기능처리...");
//		return (BoardVO)getSqlSession().selectOne("BoardDAO.getBoard", vo);
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard", vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis로  getBoardList() 기능처리...");
//		return getSqlSession().selectList("BoardDAO.getBoardList", vo);
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}

}
