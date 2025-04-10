package br.edu.infnet.biblioteca.service;

import br.edu.infnet.biblioteca.model.Livro;

import java.util.List;

public interface LivroService {
    Livro save(Livro livro);
    List<Livro> findAll();
    void deleteById(Long id);
    List<Livro> findByAutor(String autor);
}
