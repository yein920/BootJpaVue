package Autocrypt.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//어노테이션 없어도 JpaRepository 상속을 하면 IoC등록이 자동으로 된다. 
public interface MemberRepository extends JpaRepository<Member, String> {
																									// 해당 엔티티, PK의 자료형
	
	//@Query("select m from Member m where id = :id and password = :password") // 더 섬세한 작업일 때 @Query사용
	Member findByIdAndPassword(String id, String password);  		   //로그인 
}
