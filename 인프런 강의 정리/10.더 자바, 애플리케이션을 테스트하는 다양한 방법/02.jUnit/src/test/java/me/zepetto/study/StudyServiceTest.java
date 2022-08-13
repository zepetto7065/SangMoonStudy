package me.zepetto.study;

import me.zepetto.domain.Member;
import me.zepetto.domain.Study;
import me.zepetto.member.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) //mockito에서 제공하는 extension
class StudyServiceTest {

    // @ExtendWith과 같이 사용해주자
    @Mock
    MemberService memberService;

    @Mock
    StudyRepository studyRepository;


    @Test
    void createStudyService() {
        //구현체는 없지만 인터페이스만 알고 있을때 코드가 제대로 작동하는지 확인을 하려면
        //mocking을 해야함
        MemberService memberService = new MemberService() {
            @Override
            public Optional<Member> findById(Long memberId) {
                return Optional.empty();
            }

            @Override
            public void validate(Long memberId) {

            }

            @Override
            public void notify(Study newStudy) {

            }
        };
        //직접 ..
        StudyRepository studyRepository = new StudyRepository() {
            @Override
            public List<Study> findAll() {
                return null;
            }

            @Override
            public List<Study> findAll(Sort sort) {
                return null;
            }

            @Override
            public List<Study> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public <S extends Study> List<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Study> S saveAndFlush(S s) {
                return null;
            }

            @Override
            public void deleteInBatch(Iterable<Study> iterable) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Study getOne(Long aLong) {
                return null;
            }

            @Override
            public <S extends Study> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Study> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public Page<Study> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Study> S save(S s) {
                return null;
            }

            @Override
            public Optional<Study> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Study study) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> iterable) {

            }

            @Override
            public void deleteAll(Iterable<? extends Study> iterable) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public <S extends Study> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Study> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Study> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Study> boolean exists(Example<S> example) {
                return false;
            }
        };
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Test
    void createMokitoStudyService() {

        MemberService memberService = mock(MemberService.class);
        //만들려는 인터페이스 또는 클래스에 타입을 주면 가짜 객체를 만들어준다.
        StudyRepository studyRepository = mock(StudyRepository.class);


    }

    //파라미터 형식으로 만드는 방법
    @Test
    void createMokitoParameterStudyService(@Mock MemberService memberService,
                                           @Mock StudyRepository studyRepository) {
        Optional<Member> optional = memberService.findById(1L);
        memberService.validate(2L);


        Member member = new Member();
        member.setId(1L);
        member.setEmail("tesdt@email.com");

        //stubbing
        when(memberService.findById(1L)).thenReturn(optional.of(member));


        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);
    }

    @Test
    void createNewStudy(@Mock MemberService memberService,
                        @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("test@email.com");

        //stubbing - 특정한 매개변수를 받았을때 return 조작,
        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        //파라미터는 argument matchers로 더 조작가능
//        when(memberService.findById(any())).thenReturn(Optional.of(member));


        Study study = new Study(10, "java");
        studyService.createNewStudy(1L, study);

        //mock객체 memberService가 그대로 전달된다.
        Optional<Member> findById = memberService.findById(1L);
        assertEquals("test@email.com", findById.get().getEmail());

//        //예외를 던짐
//        when(memberService.findById(1L)).thenThrow(new RuntimeException());
//        //또는
        doThrow(new IllegalArgumentException()).when(memberService).validate(1L);
//
        assertThrows(IllegalArgumentException.class, () -> {
            memberService.validate(1L);
        });


//        studyService.createNewStudy(1L, study);

    }

    //파라미터 형식으로 만드는 방법
    @Test
    void createNewStudy2(@Mock MemberService memberService,
                         @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("test@email.com");

        //횟수에 따라 다르게 return or Throw
        when(memberService.findById(any()))
                .thenReturn(Optional.of(member))
                .thenThrow(new RuntimeException())
                .thenReturn(Optional.empty());

        Optional<Member> byId = memberService.findById(1L);
        assertEquals("test@email.com", byId.get().getEmail());

        assertThrows(RuntimeException.class, () -> {
            memberService.findById(2L);
        });

        assertEquals(Optional.empty(), memberService.findById(3L));
    }

    //stubbing 연습문제
    @Test
    void createNewStudy3(@Mock MemberService memberService,
                         @Mock StudyRepository studyRepository) {
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("test@email.com");

        Study study = new Study(10, "테스트");

        //TODO memberService 객체에 findById 메소드를 1L 값으로 호출하면 member 객체를 리터하도록 stubbing
        when(memberService.findById(1L)).thenReturn(Optional.of(member));

        //TODO studyRepository 객체에 save 메소드를 study 객체로 호출하면 study 객체 그대로 리턴하도록 stubbing
        when(studyRepository.save(study)).thenReturn(study);

        studyService.createNewStudy(1L, study);
        assertEquals(member, study.getOwner());
    }

    //Mock 객체 확인
    @Test
    void createNewStudy4() {
        //Given
        StudyService studyService = new StudyService(memberService, studyRepository);
        assertNotNull(studyService);

        Member member = new Member();
        member.setId(1L);
        member.setEmail("test@email.com");

        Study study = new Study(10, "테스트");

        when(memberService.findById(1L)).thenReturn(Optional.of(member));
        when(studyRepository.save(study)).thenReturn(study);

        given(memberService.findById(1L)).willReturn(Optional.of(member));
        given(studyRepository.save(study)).willReturn(study);

        //When
        studyService.createNewStudy(1L, study);
        //Then
        assertEquals(member, study.getOwner());

        //notify가 호출이 되었는지?
        //몇번을 정확히 얼마나? 1번 호출이 되어야 한다.
        verify(memberService, times(1)).notify(any());
        verify(memberService, never()).validate(any());

        then(memberService).should(times(1)).notify(study);
    }

}