package com.khmall.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //@Autowired = 클래스 안에 변수마다 하나씩 설정해주는것이고
//@RequiredArgsConstructor는 @Autowired 와 같지만 내부에서 하나씩 하나씩 해주는 것이 아니라 외부에서 전체적으로 설정
//@Autowired spring에서 만들어서 이름이 autowired lombok에서 만들어서 이름이 구체적으로 @RequiredArgsConstructor
public class EmailService {
	
	//자바 자체에서 제공하는 이메일 보내기 기능 틀
	//왜 틀만 제공하냐면 이메일을 전송하는데 어느회사 어느규격 이메일인지 알수 없기 때문에
	// 이메일을 보낼 때 보내는이 내용 받는이
	private final JavaMailSender javaMailSender;
	
	// 이메일을 보낼 이메일 주소값
	private static final String senderEmail = ""; //이메일을 보낼 담당자 이메일 작성
	//application.properties에서 가져온 이메일을 그대로 사용
	private static int number; // 인증번호를 보낼 숫자 공간
	
	//랜덤으로 인증번호 생성하는 메서드(기능= 동작) 설정
	//임의로 6자리를 생성하는 규칙
	/*
	 * Math.random() 0.0 ~1.0 미만의 임의의 소수(실수) 생성
	 *  예를 들어 0.0 부터 0.99999 사이의 값을 반환하는 등 실수 생성
	 * Math.random() 에 (90000) 곱하기를 해주면 0.0 부터 899999.999 사이의 값을 반환
	 * 정수의 경우에는 맨 앞자리나 001 0이 아닌 수가 나오기 전까지 모두 0이면
	 * 001 -> 1로 변하는 마법
	 * 01055556666 -> 1055556666
	 * 100000 ~ 189999 사이의 임의의 숫자 6자리 숫자를 생성
	 * 
	 * 만약에 5자리
	 * number = (int)(Math.random() * (9000)) + 10000;
	 * 
	 * */
	public static void 번호생성() {
		number = (int)(Math.random() * (90000)) + 100000;
	}
	//메일 양식 기능 
	public MimeMessage createMail(String mail) {
		//인증번호 생성
		번호생성();
		//생성된 인증번호를 담는 변수
		MimeMessage 메세지 = javaMailSender.createMimeMessage();
		// MimeMessage 이메일 본문 담당! 첨부파일 헤더 같이 보낼 수 있음
		// 자바에서 제공하는 기능
		// 메세지 보낼 공간 생성
		
		try {
			메세지.setFrom(senderEmail); // 인증번호를 전송하는 주최자 이메일 주소
			메세지.setRecipients(MimeMessage.RecipientType.TO, mail);// --> String 타입
			// 메세지.setRecipients(MimeMessage.RecipientType.TO, mail); -->address 타입
			// 태그로 img src 이미지 같이 보낼수 있음
			// 첨부파일 참조하는 태그들 이용해서 같이 보낼 수 있음
			메세지.setSubject("이메일 인증"); //보내는 제목
			String 이메일본문 = "";
			이메일본문 += "<h3>" + "요청하신 인증 번호입니다." +"</h3>";
			이메일본문 += "<h1>" + number+"</h1>";
			메세지.setText(이메일본문,"utf-8","html");
			
		} catch (MessagingException e) {
		
			e.printStackTrace();
		}
		return 메세지; //메세지. 으로 작성한 모든 내용 담아서 전달하기
		
	}
	
	public int sendMail(String mail) {
		MimeMessage 메세지 = createMail(mail);
		javaMailSender.send(메세지);
		return number;
	}


}
