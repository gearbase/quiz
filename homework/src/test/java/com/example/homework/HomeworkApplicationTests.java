package com.example.homework;

import com.example.homework.dao.InterviewDAO;
import com.example.homework.dao.StudentDAO;
import com.example.homework.domain.Interview;
import com.example.homework.domain.Student;
import com.example.homework.service.CheckInterviewImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class HomeworkApplicationTests {
	@Mock
	InterviewDAO interviewDAO;
	@Mock
	StudentDAO studentDAO;
	@Autowired
	MessageSource messageSource;


	@Test
	void listHaveSize5elements() throws IOException {
		Locale.setDefault(Locale.ENGLISH);
		Assertions.assertEquals(5, interviewDAO.getInterviewList().size());
	}

	@Test
	void studentNotNull() {
		Assertions.assertNotNull(studentDAO.getStudentDAO());
	}

	private void initMocks() throws Exception {
		/*
		when(checkInterview.getQuestions()).thenReturn(list);


		doNothing().when(student).setFirstName(any());
		student.setFirstName("First Name From Mock");
		doNothing().when(student).setSecondName(any());
		student.setSecondName("Second Name From Mock");

		doCallRealMethod().when(checkInterview).letsCheckInterview();
		when(checkInterview.getStudent()).thenReturn(student);
		//checkInterview.getClass().getDeclaredFields()
		Scanner scanner = new Scanner(input);
		PowerMockito.whenNew(Scanner.class).withAnyArguments().thenReturn(scanner);*/
		//Перед запуском нужно закомментить @PostConstract метод в CheckInterviewImpl
		when(studentDAO.getStudentDAO()).thenReturn(new Student());

		List<Interview> list = List.of(
				new Interview()
		);
		Interview interview = list.get(0);
		interview.setAnswers(Collections.singletonList("1"));
		interview.setCorrectAnswer(1);
		interview.setNumber(1);
		interview.setQuestion("Это вопрос");

		when(interviewDAO.getInterviewList()).thenReturn(list);

		String input = "First name\n" +
				"Second name\n" +
				"1";
		System.setIn(new ByteArrayInputStream(input.getBytes()));
	}

	@Test
	void checkingInterview() throws Exception {
		initMocks();
		CheckInterviewImpl checkInterview = new CheckInterviewImpl(interviewDAO,studentDAO,messageSource);
		checkInterview.letsCheckInterview();
		System.setIn(System.in);
	}



}
