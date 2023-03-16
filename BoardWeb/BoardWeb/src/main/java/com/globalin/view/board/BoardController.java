
package com.globalin.view.board;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.globalin.biz.board.BoardService;
import com.globalin.biz.board.BoardVO;
import com.globalin.biz.board.impl.BoardServiceImpl;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) {
		System.out.println("글 등록 처리");

		boardService.insertBoard(vo);

		return "getBoardList.do";
	}

//	@RequestMapping("/getBoardList.do")
//	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//
//		System.out.println("글 목록 조회");
//
//		mav.addObject("boardList", boardDAO.getBoardList());
//		mav.setViewName("getBoardList.jsp");
//
//		return mav;
//	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {

		System.out.println("글 목록 조회");
		
		model.addAttribute("boardList", boardService.getBoardList());

		return "getBoardList.jsp";
	}

	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap=new HashMap<String, String>();
		
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		
		return conditionMap;
	}
	
//	@RequestMapping("/getBoardList.do")
//	public String getBoardList(@RequestParam(value = "searchContidion", defaultValue = "TITLE", required = false) String condition,
//			@RequestParam(value = "searchKeyword", defaultValue = "", required = true) String keyword,
//			BoardDAO boardDAO, Model model) {
//
//		System.out.println("글 목록 검색 처리");
//		System.out.println("검색 조건 : "+condition);
//		System.out.println("검색 단어 : "+keyword);
//		model.addAttribute("boardList", boardDAO.getBoardList());
//
//		return "getBoardList.jsp";
//	}
	
	
//	글 상세조회
//	@RequestMapping("/getBoard.do")
//	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		
//		System.out.println("글 상세 조회 처리");
//		 
//		 mav.addObject("board", boardDAO.getBoard(vo));
//		 mav.setViewName("getBoard.jsp");
//		
//		 return mav;
//	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		
		System.out.println("글 상세 조회 처리");
		 
		//Model 정보 저장
		model.addAttribute("board", boardService.getBoard(vo));

		return "getBoard.jsp"; //View 이름을 리턴
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {		
		 System.out.println("글 수정 처리");
		 
		 System.out.println("번호 : "+vo.getSeq());
		 System.out.println("제목 : "+vo.getTitle());
		 System.out.println("작성자 이름 : "+vo.getWriter());
		 System.out.println("내용 : "+vo.getContent());
		 System.out.println("등록일 : "+vo.getRegDate());
		 System.out.println("조회수 : "+vo.getCnt());
		 
		 boardService.updateBoard(vo);
		 return "getBoardList.do";
	}
}