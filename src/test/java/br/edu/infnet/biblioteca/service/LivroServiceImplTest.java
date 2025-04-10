package br.edu.infnet.biblioteca.service;

import br.edu.infnet.biblioteca.exception.BusinessException;
import br.edu.infnet.biblioteca.model.Livro;
import br.edu.infnet.biblioteca.repository.LivroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LivroServiceImplTest {
    @InjectMocks
    LivroServiceImpl livroServiceImpl;

    @Mock
    LivroRepository livroRepository;

    Livro livro;

    @BeforeEach
    public void setUp() {
        livro = new Livro(1L,"A casa torta", "Agatha Christie");
    }

    @Test
    @DisplayName("Deve buscar livros por autor com sucesso")
    public void deveBuscarLivrosPorAutorComSucesso() {
        Mockito.when(livroRepository.findByAutor(livro.getAutor())).thenReturn(Collections.singletonList(livro));

        List<Livro> livros = livroServiceImpl.findByAutor(livro.getAutor());

        assertEquals(Collections.singletonList(livro), livros);
        verify(livroRepository).findByAutor(livro.getAutor());
        verifyNoMoreInteractions(livroRepository);
    }

    @Test
    @DisplayName("Não deve chamar o repository caso autor seja nulo")
    void naoDeveChamaroRepositoryCasoParametroAutorNulo(){
        final BusinessException e = assertThrows(BusinessException.class, () -> {
            livroServiceImpl.findByAutor(null);
        });

        assertThat(e, notNullValue());
        assertThat(e.getMessage(), is("Erro ao buscar livros por autor = null"));
        assertThat(e.getCause(), notNullValue());
        assertThat(e.getCause().getMessage(), is("Autor é obrigatório!"));
        verifyNoInteractions(livroRepository);

    }
}
