package com.globalin.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;

//Spring-jdbc를 활용하는 첫번째 방법 따단
//첫 번째 방법 : JdbcDaoSupport 클래스를 상속받아 활용

//DAO(Data Access Object)
@Repository
//public class BoardDAOSpring extends JdbcDaoSupport{ //주석1
public class BoardDAOSpring{
	
	//sql 명령어들
	private String BOARD_INSERT="insert into board(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
//	private String BOARD_INSERT="insert into board(seq, title, writer, content) values(?,?,?,?)";
	private String BOARD_UPDATE="update board set title=?, content=? where seq=?";
	private String BOARD_DELETE="delete from board where seq=?";
	private String BOARD_GET="select * from board where seq=?";
	private String BOARD_LIST="select * from board order by seq desc";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	@Autowired //주석2
//	public void setSuperDataSource(DataSource dataSource) {
//		super.setDataSource(dataSource);
//	}
	
	
	//CRUD 메소드 구현

	//글 등록
	
	public void insertBoard(BoardVO vo) {
		System.out.println("=====>Spring JDBC로 insertBoard() 기능 처리");
		
//		getJdbcTemplate().update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
		jdbcTemplate.update(BOARD_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent());
//		jdbcTemplate.update(BOARD_INSERT,vo.getSeq(),vo.getTitle(),vo.getWriter(),vo.getContent());
		
	}
	
//	글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("=====>Spring JDBC로 updateBoard() 기능 처리");
//		getJdbcTemplate().update(BOARD_UPDATE,vo.getTitle(),vo.getContent(),vo.getSeq());
		jdbcTemplate.update(BOARD_UPDATE,vo.getTitle(),vo.getContent(),vo.getSeq());
		
	}
	
//	글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("=====>Spring JDBC로 deleteBoard() 기능 처리");
//		getJdbcTemplate().update(BOARD_DELETE,vo.getSeq());
		jdbcTemplate.update(BOARD_DELETE,vo.getSeq());
	}
	
//	글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("=====>Spring JDBC로 getBoard() 기능 처리");
		
//		BoardVO board=getJdbcTemplate().queryForObject(BOARD_GET,new Object[]{vo.getSeq()} ,new BoardRowMapper());
		BoardVO board=jdbcTemplate.queryForObject(BOARD_GET,new Object[]{vo.getSeq()} ,new BoardRowMapper());
		
		return board;
	}
	
//	글 목록 조회
	public List<BoardVO> getBoardList() {
		System.out.println("=====>Spring JDBC로 getBoardList() 기능 처리");
//		List<BoardVO> boardList=getJdbcTemplate().query(BOARD_LIST, new BoardRowMapper());
		List<BoardVO> boardList=jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
		return boardList;
	}
	
//	public static void main(String[] args) {
//		BoardDAO dao=new BoardDAO();
//		
//		List<BoardVO> list=dao.getBoardList();
//		
//		BoardVO vo=list.get(0);
//		
//		System.out.println(vo.getTitle());
//		
//	}

}
