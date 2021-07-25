package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<GuestBookVo> getGuestBookVo() {
		List<GuestBookVo> guestbookVo = sqlSession.selectList("guestbook.selectList");
		System.out.println(guestbookVo);
		return guestbookVo;
	}
	
	public int guestInsert(GuestBookVo guestbookVo) {
	
		int count = sqlSession.insert("guestbook.guestInsert", guestbookVo);
		
		return count;
	}


}
