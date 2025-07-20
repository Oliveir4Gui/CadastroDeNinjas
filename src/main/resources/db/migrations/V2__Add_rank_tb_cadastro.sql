--V2: Migrations para adicionar coluna de RANK na tela de cadastros
ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);
