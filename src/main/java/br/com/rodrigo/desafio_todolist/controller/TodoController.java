package br.com.rodrigo.desafio_todolist.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.rodrigo.desafio_todolist.entity.Todo;
import br.com.rodrigo.desafio_todolist.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;



@RestController
@RequestMapping("/todos")
@Tag(name = "ToDo List")
public class TodoController {
	
	private TodoService todoService;
	
	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}
	
	@Operation(summary = "Cria a tarefa e salva no banco de dados", method = "POST")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa criada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
    })
	@PostMapping
	List<Todo> create(@RequestBody @Valid Todo todo){
		return todoService.create(todo);
	}
	
	@Operation(summary = "Lista todas as tarefas salvas no banco de dados", method = "GET")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefas listadas com sucesso"),
            @ApiResponse(responseCode = "404", description = "Lista de tarefas não encontrada"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
    })
	@GetMapping
	List<Todo> list(){
		return todoService.list();
	}
	
	@Operation(summary = "Atualiza os dados da tarefa no banco de dados", method = "PUT")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
    })
	@PutMapping
	List<Todo> update(@RequestBody Todo todo){
		return todoService.update(todo);
	}
	
	@Operation(summary = "Deleta a tarefa com o ID selecionado do banco de dados", method = "DELETE")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tarefa deletada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados inválidos"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor"),
    })
	@DeleteMapping("{id}")
	List<Todo> delete(@PathVariable("id") Long id){
		return todoService.delete(id);
	}

}
