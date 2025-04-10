package br.edu.infnet.biblioteca.service;

import br.edu.infnet.biblioteca.exception.BusinessException;
import br.edu.infnet.biblioteca.model.Livro;
import br.edu.infnet.biblioteca.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;
import static org.springframework.util.Assert.notNull;

@Service
@RequiredArgsConstructor
public class LivroServiceImpl implements LivroService {
    private final LivroRepository livroRepository;

    @Override
    public Livro save(Livro livro){
        livroRepository.save(livro);
        return livro;
    }

    @Override
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }

    @Override
    public List<Livro> findByAutor(String autor){
        try {
            notNull(autor, "Autor é obrigatório!");

            return livroRepository.findByAutor(autor);
        } catch (final Exception e) {
            throw new BusinessException(format("Erro ao buscar livros por autor = %s", autor), e);
        }}
}
