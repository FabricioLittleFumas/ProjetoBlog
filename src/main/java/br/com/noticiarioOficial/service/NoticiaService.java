package br.com.noticiarioOficial.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.noticiarioOficial.model.Noticia;
import br.com.noticiarioOficial.repository.NoticiaRepository;

@Service
public class NoticiaService {
	

	@Autowired
	private  NoticiaRepository noticiaRepository;

	public Noticia buscarPorid(long id) {
		Optional<Noticia> noticias = noticiaRepository.findById(id);
		if (noticias.isPresent()) {
			return noticias.get();
		}
		return noticias.orElseThrow(() ->  new RuntimeException("erro ao buscar noticia"));
	}

	public ArrayList<Noticia> buscarTodos() {
		// TODO Auto-generated method stub
		ArrayList<Noticia> noticias = (ArrayList<Noticia>) noticiaRepository.findAll();
 		return noticias;
	}

	public void deleteporId(long id) {
		noticiaRepository.deleteById(id);
	}
	
	

}
