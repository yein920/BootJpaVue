package Autocrypt.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import Autocrypt.dto.Member;
import Autocrypt.dto.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 							// final 생성자 만들기
@SessionAttributes("member") 							// model 정보를 http세션에 담아주는 어노테이션 _ 여러 화면/요청에서 사용해야 하는 객체를 공유할 때 사용
										// model.addAttribute의 attributeName과 @SessionAttributes의 괄호값이 같다면 model에 추가될 때
										// 자동으로 세션으로 넣어줌
@RestController
public class MemberController {

	private final MemberRepository memberR;
	
	//보안상 PostMapping을 사용하는 것이 맞다고 판단하여 사용하였지만, 계속되는 403에러로 임시방편으로 GetMapping으로 진행하였습니다.
	@GetMapping("signIn/into") 						// 로그인
	public String Signin(String id, String password) {
		Member member = memberR.findByIdAndPassword(id, password);	//jpaRepository 내 find메소드를 이용하여 해당 id와 password가 있는지 확인진행
		if(member != null) {						//DB에 저장되어있는지 확인 후 로그인 여부를 알려줍니다. 
			return "loginOK";					//실행시, 반환값을 개발자도구를 통해 확인했습니다.(영상)
		} else {
			return "loginFail";
		}
	}
	
	@GetMapping("logout")
	public String Logout(HttpSession session) {				 // 로그아웃
		session.invalidate();		    				 //세션 만료를 통해 로그아웃

		return "로그아웃되었습니다.";
	}

	@RequestMapping("signup")						 // 회원가입
	public String Signup() {
		return "Signup";
	}
	
	//보안상 PostMapping을 사용하는 것이 맞다고 판단하여 사용하였지만, 계속된 403에러로 임시방편으로 GetMapping으로 진행하였습니다.
	@GetMapping("signup/save") 						// 회원가입
	public Member SignupSave(String id, String password) {
		//member.setDate(LocalDate.now());
		Member member = new Member(id, password);
		return memberR.save(member);					//jpaRepository 내 save메소드를 이용하여 가입진행

	}
}
