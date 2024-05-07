CREATE TABLE livros (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    paginas INT,
    ano_de_lancamento INT,
    emprestado BOOLEAN DEFAULT FALSE
);
