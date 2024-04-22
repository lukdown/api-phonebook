package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {

	@Autowired
	private PhonebookDao phonebookDao;

	// 삭제
	public int exeRemove(PersonVo personVo) {
		System.out.println("PhonebookService.exeRemove()");

		int count = phonebookDao.phonebookDelete(personVo);
		return count;
	}

	// 수정폼(1명 데이터가져오기)
	public PersonVo exeModifyForm(int no) {
		System.out.println("UserService.exeModifyForm()");

		PersonVo personVo = phonebookDao.phonebookSelectOne(no);
		return personVo;
	}

	// 수정
	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");

		int count = phonebookDao.phonebookModify(personVo);

		return count;
	}

	// 저장 +1개 가져오기
	public PersonVo exeAddandPhone(PersonVo personVo) {
		System.out.println("PhonebookService.exeAddandPhone()");

		// 등록
		int count = phonebookDao.insertSelectKey(personVo);

		// no 의 데이터 가져오기
		// no값 확인
		int no = personVo.getPersonId();
		// no데이터 가져오기

		PersonVo pVo = phonebookDao.phonebookSelectOne(no);
		return pVo;
	}

	// 리스트 가져오기
	public List<PersonVo> exePhoneList() {
		System.out.println("PhonebookService.exePhoneList()");

		List<PersonVo> phonebookList = phonebookDao.phonebookSelectList();

		return phonebookList;
	}

}
