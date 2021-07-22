package Autocrypt.dto;

import org.springframework.data.jpa.repository.JpaRepository;

//어노테이션 없어도 JpaRepository 상속을 하면 IoC등록이 자동으로 된다.
public interface MemberRepository extends JpaRepository<Member, String> {

	Member findByIdAndPassword(String id, String password);
}
