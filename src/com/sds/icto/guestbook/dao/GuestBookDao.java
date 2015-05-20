package com.sds.icto.guestbook.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.sds.icto.guestbook.vo.GuestBookVo;

@Repository
public class GuestBookDao {
	@Autowired
	SqlMapClientTemplate sqlMapClientTemplate;

	public void guestBookInsert(GuestBookVo vo) {
		sqlMapClientTemplate.insert("guestbook.insert",vo);
	}

	public List<GuestBookVo> fetch() {

		@SuppressWarnings("unchecked")
		List<GuestBookVo> list = 
				sqlMapClientTemplate.queryForList("guestbook.list");
				 
		return list;
	}

	public void guestBookDelete(String no, String password){
		
		Map map = new HashMap();
		map.put("n", no);
		map.put("p", password);
		sqlMapClientTemplate.delete("guestbook.delete",map);
		
	}
}
