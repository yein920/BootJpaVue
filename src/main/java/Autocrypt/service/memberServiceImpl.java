package Autocrypt.service;//package Autocrypt.service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
//import Autocrypt.dto.Member;
//import lombok.Data;
//
//@Data
//@Service
//public class memberServiceImpl implements MemberService {
//
//	private static final Logger logger = LoggerFactory.getLogger(memberServiceImpl.class);
//
//	@Override		//db에 데이터가 있는지 확인 _ 입력데이터와 비교
//	public Map<String, Object> checkLoginAvailable(Map<String, Object> param) {
//
//		Map<String, Object> rs = new HashMap<String, Object>();
//
//		String id = (String) param.get("id");
//	    String password = (String)param.get("password");
//
//	    logger.info( id + password);
//
//	    Member member = new Member();
//
//
//	    //엔티티 매니저 팩토리 생성
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
//		EntityManager em = emf.createEntityManager();
//
//		//Member member = em.find(member, loginId);
//
//
//		//Query query = entityManager.createNativeQuery("SELECT id, password FROM Member");
//		//query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
//
//		      TypedQuery<Member> typedQuery = em.createQuery("SELECT * FROM MEMBER m where m.password = ?1 and m.id = ?2", Member.class);
//		      typedQuery.setParameter(1, password);
//		      typedQuery.setParameter(2, id);
//		    member = typedQuery.getSingleResult();			// 결과값 하나
//		      //return member;
//
//		//로그인 성공 또는 실패 여부를 controller로 보냄
//		if(member == null) {
//			rs.put("resultCode", "F1");
//			rs.put("msg", "해당 회원이 존재하지 않습니다.");
//		}else if (member.getPassword().equals(password) == false) {
//		//입력 비밀번호와 DB 비밀번호가 동일하지 않는 경우
//			rs.put("resultCode", "F2");
//			rs.put("msg", "비밀번호가 일치하지 않습니다.");
//		} else {
//			rs.put("resultCode", "S1");
//			rs.put("msg", "로그인 성공");
//		}
//
//		return rs;
//
//}
//
//}
