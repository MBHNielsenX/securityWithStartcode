package dat3.cars.repository;

import dat3.cars.entity.Member;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;
/*
    static String memb1;
    static String memb2;
    @BeforeAll
    public static void setUpData(@Autowired MemberRepository memberRepository) {
        Member m1 = new Member("aa", "bb", "cc", "dd");
        Member m2 = new Member("ee","ff","gg","hh");

        memberRepository.save(m1);
        memberRepository.save(m2);

        memb1 = m1.getUsername();
        memb2 = m2.getUsername();
    }

    @Test
    public void testFindByUsername() {
        Member found = memberRepository.findMemberByUsername(memb1);
        assertEquals(memb1, found.getUsername());
    }

    @Test
    public void testFindByEmail() {
        Member found = memberRepository.findMemberByEmail("gg");
        assertEquals(memb2, found.getUsername());
    }


 */

}