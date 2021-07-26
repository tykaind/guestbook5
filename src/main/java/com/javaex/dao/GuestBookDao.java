package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.Session;

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
	
	
	public int guestDelete(int no, String password) {

		Map<String, Object> guestdeleteMap = new HashMap<String, Object>();
		guestdeleteMap.put("no", no);
		guestdeleteMap.put("password", password);
		System.out.println(guestdeleteMap);
		int count = sqlSession.delete("guestbook.guestdelete", guestdeleteMap);
		return count;
	}


}
