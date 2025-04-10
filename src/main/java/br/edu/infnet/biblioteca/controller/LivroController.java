package br.edu.infnet.biblioteca.controller;

import br.edu.infnet.biblioteca.model.Livro;
import br.edu.infnet.biblioteca.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class LivroController {
    @Autowired
    LivroService livroService;

    @PostMapping("/livros")
    public ResponseEntity<Livro> salvarLivro(@RequestBody @Valid Livro livro) {
        livroService.save(livro);
        return new ResponseEntity<> (HttpStatus.CREATED);
    }

    @GetMapping("/livros")
    public List<Livro> encontrarTodosLivros() {
        return livroService.findAll();
    }

    @GetMapping("/livros/{autor}")
    public List<Livro> encontrarLivrosAutor(@PathVariable String autor) {
        return livroService.findByAutor(autor);
    }

    @PutMapping("livros/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody @Valid Livro livro) {
        livro.setId(id);
        return livroService.save(livro);
    }

    @DeleteMapping("livros/{id}")
    public ResponseEntity<?> deletarLivro(@PathVariable Long id){
        livroService.deleteById(id);
        return new ResponseEntity<> (HttpStatus.NO_CONTENT);
    }
}
