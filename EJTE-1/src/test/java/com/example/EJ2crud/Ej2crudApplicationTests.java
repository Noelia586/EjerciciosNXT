package com.example.EJ2crud;

import com.example.EJ2crud.Person.application.PersonService;
import com.example.EJ2crud.Person.domain.Person;
import com.example.EJ2crud.Person.infrastructure.PersonController;
import com.example.EJ2crud.Person.infrastructure.dto.PersonInputDTO;
import com.example.EJ2crud.Person.infrastructure.dto.PersonOutputDTO;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class Ej2crudApplicationTests {

	@Mock
	PersonService personServiceMock;

	@InjectMocks
	PersonController personController;

	PersonInputDTO personInputDTO =
			new PersonInputDTO(
					1,
					"noelia01",
					"",
					"noelia",
					"herrera",
					"koijih@gmail.com",
					"fttftf@gmail.com",
					"Madrid",
					true,
					new Date(),
					"",
					new Date());
	PersonOutputDTO personOutputDTO =
			new PersonOutputDTO(
					1,
					"noelia01",
					"noelia",
					"herrera",
					"koijih@gmail.com",
					"fttftf@gmail.com",
					"Madrid",
					true,
					new Date(),
					"",
					new Date());
	List<PersonOutputDTO> personOutputDTOList;
	@Before
	void before() {
		System.out.println("Before");
		personOutputDTOList = new ArrayList<>();
		personOutputDTOList.add(personOutputDTO);
	}

	@Test
	void findByIdTest() throws Exception {
		System.out.println("TEST1");
		when(personServiceMock.findById(1)).thenReturn(personOutputDTO);
		assertEquals(personOutputDTO, personController.getPersonById(1));
		System.out.println(personOutputDTO);
	}

	@Test
	void findAllTest() throws Exception {
		System.out.println("TEST2");
		when(personServiceMock.findAll()).thenReturn(personOutputDTOList);
		assertEquals(personOutputDTOList, personController.getPeople());
		System.out.println(personOutputDTOList);
	}

	@Test
	void findByNameTest() throws Exception {
		System.out.println("TEST3");
		when(personServiceMock.findByName("luis")).thenReturn(personOutputDTOList);
		assertEquals(personOutputDTOList, personController.getPeopleByName("luis"));
		System.out.println(personOutputDTOList);
	}

	@Test
	void addPersonTest() throws Exception {
		System.out.println("TEST4");
		when(personServiceMock.addPerson(personInputDTO))
				.thenReturn(new PersonOutputDTO(new Person(personInputDTO)));
		assertEquals(personOutputDTO, personController.insertPerson(personInputDTO));
		System.out.println(personOutputDTO);
	}

	@Test
	void deletePersonTest() throws Exception {
		System.out.println("TEST5");
		when(personServiceMock.deletedById(1)).thenReturn(new Person(personInputDTO));
		assertEquals(new Person(personInputDTO), personController.deletePersonById(1));
	}
}
