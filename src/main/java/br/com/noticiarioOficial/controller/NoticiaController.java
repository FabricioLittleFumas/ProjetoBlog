package br.com.noticiarioOficial.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.noticiarioOficial.model.Noticia;
import br.com.noticiarioOficial.service.NoticiaService;

@RestController
@RequestMapping("/noticia")
public class NoticiaController {

	@Autowired
	private NoticiaService noticiaService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Noticia> buscarPorId(@PathVariable(name = "id") long id){
		Noticia noticias = noticiaService.buscarPorid(id);
		return new ResponseEntity<Noticia>(noticias, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<ArrayList<Noticia>> buscarTodos(){
		ArrayList<Noticia> noticias = noticiaService.buscarTodos();
		return new ResponseEntity<ArrayList<Noticia>>(noticias, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteporId(@PathVariable(name = "id") long id){
		noticiaService.deleteporId(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
}
