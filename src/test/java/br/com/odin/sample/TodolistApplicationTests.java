package br.com.odin.sample;

import br.com.odin.sample.todolist.shared.dtos.ToDoRequestDTO;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodolistApplicationTests {

	@Test
	void contextLoads() {
		String dto = new ToDoRequestDTO().toAvro();
		System.out.println(dto);
	}

}
