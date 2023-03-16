package com.globalin.biz.user;

import java.util.List;

import com.globalin.biz.board.BoardVO;

public interface UserService {
	// CRUD 기능의 메소드 구현
	void insertUser(UserVO vo);

	void updateUser(UserVO vo);

	void deleteUser(UserVO vo);

	UserVO getUser(UserVO vo);

	List<UserVO> getUserList();
}
