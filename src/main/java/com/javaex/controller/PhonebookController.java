package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;

@RestController
public class PhonebookController {

	
	@Autowired
	private PhonebookService phonebookService;
	
	// 삭제
	@DeleteMapping(value = "/api/phonebooks")
	public String remove(@RequestBody PersonVo personVo) {
		System.out.println("PhonebookController.remove()");

		// 삭제
		// 코드작성할것
		int count = phonebookService.exeRemove(personVo);

		String result = "{\"count\": " + count + "}";
		System.out.println(result);

		return result;
	}

	// 수정폼
	@GetMapping(value = "/api/phonebooks/modify/{no}")
	public PersonVo modifyform(@PathVariable(value = "no") int no) {
		System.out.println("PhonebookController.modifyform()");
		// personVo.setPersonId(no);
		// System.out.println(personVo);

		// 코드작성할것
		PersonVo pVo = phonebookService.exeModifyForm(no);

		return pVo;
	}

	// 수정
	@PutMapping(value = "/api/phonebooks/modify/{no}")
	public String modify(@RequestBody PersonVo personVo, @PathVariable(value = "no") int no) {
		System.out.println("PhonebookController.modify()");

		personVo.setPersonId(no);
		System.out.println(personVo);

		// 삭제
		// 코드작성할것
		int count = phonebookService.exeModify(personVo);

		String result = "{\"count\": " + count + "}";
		System.out.println(result);

		return result;
	}

	// 저장
	@PostMapping(value = "/api/phonebooks")
	public PersonVo add(@RequestBody PersonVo personVo) {
		System.out.println("GuestbookController.add()");
		System.out.println(personVo);

		PersonVo phoneVo = phonebookService.exeAddandPhone(personVo);
		System.out.println(phoneVo);

		return phoneVo;
	}

	// 리스트 가져오기
	@GetMapping(value = "/api/phonebooks")
	public List<PersonVo> list() {
		System.out.println("PhonebookController.list()");

		List<PersonVo> personList = phonebookService.exePhoneList();

		System.out.println(personList);
		return personList;
	}

}
