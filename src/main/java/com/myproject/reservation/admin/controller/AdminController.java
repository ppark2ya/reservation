package com.myproject.reservation.admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.reservation.admin.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/admin/manage")
	public ModelAndView managePage(ModelAndView mView){
		mView.setViewName("admin/adminPage");
		return mView;
	}

	@RequestMapping(value = {"/admin/customerList", "/admin/boardList",
							"/admin/roomList", "/admin/resvList"},
					method = RequestMethod.GET)
	public @ResponseBody List<Map<String, Object>> getList(@RequestParam String type){
		System.out.println(adminService.getList(type));
		return adminService.getList(type);
	}

	/*
		@RequestBody 어노테이션과 @ResponseBody 어노테이션은
		각각 HTTP 요청 몸체를 자바 객체로 변환하고 자바 객체를 HTTP 응답 몸체로 변환하는 데 사용된다.

		@RequestBody 어노테이션을 이용하면 HTTP 요청 몸체를 자바 객체로 전달받을 수 있다.
		비슷하게 @ResponseBody 어노테이션을 이용하면 자바 객체를 HTTP 응답 몸체로 전송할 수 있다.

		1. HttpMessageConverter를 이용한 변환 처리

		AnnotationMethodHandlerAdapter 클래스는 @RequestBody 어노테이션이 적용된 파라미터나
		@ResponseBody 어노테이션이 적용된 메서드에 대해 HttpMessageConverter를 사용해서 변환을 처리한다.
		주요 HttpMessageConverter 구현 클래스는 다음과 같다.


		* 구현 클래스

		 설 명

		1. ByteArrayHttpMessageConverter(*)

		 HTTP 메시지와 byte 배열 사이의 변환을 처리한다. 컨텐츠 타입은  application/octet-stream이다.

		2. StringHttpMessageConverter(*)

		 HTTP 메시지와 String 사이의 변환을 처리한다. 컨텐츠 타입은  text/plain;charset=ISO-8859-1이다.

		3. FormHttpMessageConverter(*)

		 HTML 폼 데이터를 MultiValueMap으로 전달받을 때 사용된다. 지원하는 컨텐  츠 타입은 application-x-www-form-urlencorded이다.

		4. SourceHttpMessageConverter(*)

		 HTTP 메시지와 javax.xml.transform.Source 사이 변환을 처리한다. 컨텐츠 타  입은 application/xml 또는 text/xml이다.

		5. MarshallingHttpMessageConverter(*)

		 스프링의 Marshaller와 unMarshaller를 이용해서 XML HTTP 메시지와 객체 사  이의 변환을 처리한다. 컨텐츠 타입은 application/xml 또는 text/xml이다.

		6. MappingJacksonHttpMessageConverter(*)

		 Jackson 라이브러리를 이용해서 JSON HTTP 메시지와 객체 사이의 변환을 처  리한다. 컨텐츠 타입은 applicaion/json이다.

	*/

	@RequestMapping(value = {"/admin/custRemoveRow", "/admin/boardRemoveRow",
							"/admin/roomRemoveRow", "/admin/resvRemoveRow"},
					method = RequestMethod.POST)
	public @ResponseBody void removeRow(@RequestBody String json) throws JsonProcessingException, IOException{
		System.out.println(json);
		// post 요청으로 받아온 json 데이터를 이용해 해당 컬럼을 삭제
		adminService.removeRow(json);
	}


}