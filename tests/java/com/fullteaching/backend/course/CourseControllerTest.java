package com.fullteaching.backend.course;

import com.fullteaching.backend.security.AuthorizationService;
import com.fullteaching.backend.user.User;
import com.fullteaching.backend.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CourseControllerTest {
    private CourseRepository courseRepository;
    private UserRepository userRepository;
    private AuthorizationService authService;

    // Criando mocks de classes de repositório por que não queremos os testes acessando o banco

    @BeforeAll
    void setUpBeforeAll(){
        authService = mock(AuthorizationService.class);
        courseRepository = mock(CourseRepository.class);
        userRepository = mock(UserRepository.class);

        // O método retorna NULL quando está autorizado
        when(authService.checkBackendLogged()).thenReturn(null);
    }
    @BeforeEach
    void setUpBeforeEach() {
        Set<Long> s = new HashSet<>();
        s.add((long) 1);

        User user1 = new User("ADELE", "pass", "ADELE", null, "student");
        User user2 = new User("ANA", "pass", "ANA", null, "teacher");

        Collection<User> students = new ArrayList<User>();
        Collection<User> teachers = new ArrayList<User>();
        Collection<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        students.add(user1);
        teachers.add(user2);

        when(userRepository.findAllById(s)).thenReturn((List<User>) user1);

    }

    @AfterEach
    void tearDown() {
    }

    /**
     * SHOULD GET ALL USER COURSES
     */
    @Test
    void shouldReturnCoursesList_GetCoursesTest() {
        Set<Long> s = new HashSet<>();
        s.add((long) 1);


//        when(courseRepository.findByAttenders(s));
    }

    @Test
    void shouldReturnNumberFormatErrorWhenGivingString_GetCoursesTest() {

    }

    @Test
    void getCourse() {
    }

    @Test
    void newCourse() {
    }

    @Test
    void modifyCourse() {
    }

    @Test
    void deleteCourse() {
    }

    @Test
    void addAttenders() {
    }

    @Test
    void deleteAttenders() {
    }
}