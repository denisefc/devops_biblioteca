FROM postgres:latest
COPY init.sql /docker-entrypoint-initdb.d/
EXPOSE 5432
ENV POSTGRES_PASSWORD=root
ENV POSTGRES_DB=livro