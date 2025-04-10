CREATE DATABASE IF NOT EXISTS livro;

USE livro;

CREATE TABLE  IF NOT EXISTS public.livro(
    id bigint NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO public.livro(titulo, autor) VALUES('Titulo1', 'Autor1');
INSERT INTO public.livro(titulo, autor) VALUES('Titulo2', 'Autor2');
INSERT INTO public.livro(titulo, autor) VALUES('Titulo3', 'Autor3');
