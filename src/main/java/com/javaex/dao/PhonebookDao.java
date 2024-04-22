package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {

	@Autowired
	private SqlSession sqlSession;

	// 삭제
	public int phonebookDelete(PersonVo personVo) {
		System.out.println("PhonebookDao.phonebookDelete()");

		int count = sqlSession.delete("phonebook.delete", personVo);
		return count;
	}

	// 수정
	public int phonebookModify(PersonVo personVo) {
		System.out.println("PhonebookDao.phonebookModify()");

		int count = sqlSession.update("phonebook.update", personVo);
		return count;
	}

	// 방명록 글 저장 ajax selectKey
	public int insertSelectKey(PersonVo personVo) {
		System.out.println("PhonebookDao.insertSelectKey()");

		int count = sqlSession.insert("phonebook.insertSelectKey", personVo);
		return count;
	}

	// 1개정보
	public PersonVo phonebookSelectOne(int no) {
		System.out.println("PhonebookDao.phonebookSelectOne()");

		PersonVo personVo = sqlSession.selectOne("phonebook.selectOne", no);
		return personVo;
	}

	// 리스트 가져오기
	public List<PersonVo> phonebookSelectList() {
		System.out.println("PhonebookDao.phonebookSelectList()");

		List<PersonVo> phonebookList = sqlSession.selectList("phonebook.selectList");
		System.out.println(phonebookList);

		return phonebookList;
	}
}
