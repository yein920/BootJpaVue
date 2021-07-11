package Autocrypt.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity              	             						//이 클래스를 테이블과 맵핑하도록!
@AllArgsConstructor                  						//생성자 자동생성 (클래스 내 모든 필드에 대한 생성자를 자동으로 생성)//static 필드들은 스킵
@NoArgsConstructor                  						//생성자 자동생성    (파라미터가 없는 생성자를 생성 / 필드가 final일 경우, 필드 초기화 불가로 오류발생)//static 필드들은 스킵
@Data                               						//getter, setter 자동 생성
public class Member {

																								//기본키 자동생성
	@Id                      						//식별자 필드 (PK에 맵핑)
	@GeneratedValue    							//기본키 생성을 DB에 위임함
	private long seq;



	private String id;@NotEmpty              				//Null과 공백 문자열을 허용하지 않음
	private String password;@NotEmpty


//   @Column         //필드를 컬럼에 맵핑 /객체 명과 DB컬럼명을 다르게 하고플 경우, DB 컬럼명으로 설정할 이름을 " "에 적는다. ex. (name = "name")
//   @DateTimeFormat(pattern = "yyyy-MM-dd")
//   private LocalDate date;

	public Member(@NotEmpty String id, @NotEmpty String password) {
		this.id = id;
		this.password = password;
	}
}
