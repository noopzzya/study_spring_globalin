package com.globalin.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.stereotype.Repository;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;
import com.globalin.biz.common.JDBCUtil;

//DAO(Data Access Object)
@Repository("boardDAO")
public class BoardDAO{
	//JDBC 관련 변수 선언
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	//sql 명령어들
	private String BOARD_INSERT="insert into board(seq, title, writer, content) values((select nvl(max(seq),0)+1 from board),?,?,?)";
	private String BOARD_UPDATE="update board set title=?, content=? where seq=?";
	private String BOARD_DELETE="delete from board where seq=?";
	private String BOARD_GET="select * from board where seq=?";
	private String BOARD_LIST="select * from board order by seq desc";
	
	//CRUD 메소드 구현

	//글 등록
	
	public void insertBoard(BoardVO vo) {
		System.out.println("=====>JDBC로 insertBoard() 기능 처리");
		
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
//	글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("=====>JDBC로 updateBoard() 기능 처리");
		
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
		
	}
	
//	글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("=====>JDBC로 deleteBoard() 기능 처리");
		
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
//	글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("=====>JDBC로 getBoard() 기능 처리");
		BoardVO board=null;
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs=stmt.executeQuery();

			if(rs.next()) {
				board=new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getNString("title"));
				board.setWriter(rs.getNString("writer"));
				board.setContent(rs.getNString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return board;
	}
	
//	글 목록 조회
	public List<BoardVO> getBoardList() {
		System.out.println("=====>JDBC로 getBoardList() 기능 처리");
		List<BoardVO> boardList=new ArrayList<BoardVO>();
		
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARD_LIST);
			rs=stmt.executeQuery();
			
			BoardVO board=null;

			while(rs.next()) {
				board=new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getNString("title"));
				board.setWriter(rs.getNString("writer"));
				board.setContent(rs.getNString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		
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