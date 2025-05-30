CREATE TABLE IF NOT EXISTS bandas (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    lore TEXT
);

CREATE TABLE IF NOT EXISTS albuns (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    id_banda INT NOT NULL REFERENCES bandas(id) ON DELETE CASCADE,
    ano_lancamento INT
);

CREATE TABLE IF NOT EXISTS musicas (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    id_banda INT NOT NULL REFERENCES bandas(id) ON DELETE CASCADE,
    id_album INT REFERENCES albuns(id) ON DELETE SET NULL,
    ano_lancamento INT
);