package com.luizstocco.todo.services;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizstocco.todo.domain.Todo;
import com.luizstocco.todo.repositories.TodoRepository;

@Service
public class DBService {
	@Autowired
	private TodoRepository todoRepository;

	public void instaciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Todo t1 = new Todo(null, "Estudar", "Estudar Spring Boot 2 e Angular",
				(Date) sdf.parse("15/08/2022") ,true);
		Todo t2 = new Todo(null, "Trabalho", "Rejuntar o piso ", (Date) sdf.parse("13/08/2022 "),
				false);
		Todo t3 = new Todo(null, "Faculdade", "Aula Mobile ", (Date) sdf.parse("16/08/2022"),
				true);
		Todo t4 = new Todo(null, "Academia", "Treino de Muay Thai", (Date) sdf.parse("15/08/2022"),
				false);
		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
	}
}
