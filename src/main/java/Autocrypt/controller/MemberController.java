package Autocrypt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import Autocrypt.dto.Member;
import Autocrypt.dto.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 생성자 만들기
@SessionAttributes("member") // model 정보를 http세션에 담아주는 어노테이션 _ 여러 화면/요청에서 사용해야 하는 객체를 공유할 때 사용
// model.addAttribute의 attributeName과 @SessionAttributes의 괄호값이 같다면 model에 추가될 때
// 자동으로 세션으로 넣어줌
@RestController
public class MemberController {

	private final MemberRepository memberR;
	// private final MemberService memberService ;

//	@RequestMapping("/")      //로그인화면 꺼내
//	public String showLogin() {
//		System.out.println("showLogin 호출해주라..");
//		return "Login";
//	}

	@GetMapping("signIn/into") // 데이터 받아 가져왔습니다. 가능한지 봐주십쇼 _ 로그인 비교 로직
	public String Signin(String id, String password) {
		Member member = memberR.findByIdAndPassword(id, password);
		if(member != null) {
			return "loginOK";
		} else {
			return "loginFail";
		}
	}
	@GetMapping("logout")
	public String Logout(HttpSession session) { // 로그아웃하자
		session.invalidate();

		return "로그아웃되었습니다.";
	}

	@RequestMapping("signup") // 회원가입 입력 화면가져와
	public String Signup() {
		return "Signup";
	}

	@GetMapping("signup/save") // 회원가입 로직
	public Member SignupSave(String id, String password) {
		//member.setDate(LocalDate.now());
		Member member = new Member(id, password);
		return memberR.save(member);

	}
}
