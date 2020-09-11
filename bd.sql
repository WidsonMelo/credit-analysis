create database db;

use db;

create table if not exists endereco(
	id bigint auto_increment,
	rua varchar(250),
	numero varchar(10),
	complemento varchar(200),
	cep varchar(9), 
	cidade varchar(50),
	estado varchar(20),
	pais varchar(20),
	primary key(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

create table if not exists candidato(
	id bigint not null auto_increment,
	nome varchar(250),
	data_nascimento varchar(10),
	salario float(8, 2),
	profissao varchar(50), 
	cpf varchar(15), 
	estado_civil varchar(20),
	sexo varchar (50),
	quantidade_dependentes int,
	endereco_id bigint,
	primary key(id),
	foreign key (endereco_id) references endereco(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

create table if not exists usuario(
	id bigint not null auto_increment,
	nome varchar(250),
	login varchar(50),
	senha varchar(50),
	funcao varchar(20), 
	primary key(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

create table if not exists proposta(
	id bigint not null auto_increment,
	status varchar(50) not null,
	usuario_id bigint,
	candidato_id bigint,
	primary key(id),
	foreign key (usuario_id) references usuario(id),
	foreign key (candidato_id) references candidato(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO endereco (rua,	numero, cep, cidade, estado, pais) VALUES ('Rua José Vieira de Lima', '199', '58417-393', 'Campina Grande', 'Paraíba', 'Brasil');
INSERT INTO endereco (rua,	numero, cep, cidade, estado, pais) VALUES ('Rua Raul Farias', '200', '58100-393', 'Santa Cruz do Capibaribe', 'Pernambuco', 'Brasil');
INSERT INTO endereco (rua,	numero, cep, cidade, estado, pais) VALUES ('Avenida Almirante Barroso', '137-B', '58200-393', 'Natal', 'Rio Grande do Norte', 'Brasil');
INSERT INTO endereco (rua,	numero, cep, cidade, estado, pais) VALUES ('Rua 51', '200-A', '56000-100', 'Gramado', 'Rio Grande do Sul', 'Brasil');
INSERT INTO endereco (rua,	numero, cep, cidade, estado, pais) VALUES ('Av Olinda', '129', '58999-999', 'Olinda', 'Pernambuco', 'Brasil');
INSERT INTO endereco (rua,	numero, cep, cidade, estado, pais) VALUES ('Avenida Prof. José dos Anjos', '1090', '78562-098', 'Recife', 'Pernambuco', 'Brasil');
INSERT INTO endereco (rua,	numero, cep, cidade, estado, pais) VALUES ('R. Couto Magalhães', '20', '44562-333', 'Recife', 'Pernambuco', 'Brasil');
INSERT INTO endereco (rua,	numero, cep, cidade, estado, pais) VALUES ('Rua Bolivar', '888', '88777-222', 'Recife', 'Pernambuco', 'Brasil');
INSERT INTO endereco (rua,	numero, cep, cidade, estado, pais) VALUES ('Av Sen. Rui Carneiro', '12', '88833-900', 'João Pessoa', 'Paraíba', 'Brasil');
INSERT INTO endereco (rua,	numero, cep, cidade, estado, pais) VALUES ('Avenida Presidente Epitácio Pessoa', '44213', '010234-77', 'João Pessoa', 'Paraíba', 'Brasil');

INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Calos André da Silva', '07/05/1990', 2900.10, 'Técnico em Logística', '073.234.654-09', 'Solteiro', 'Masculino', 3, 1);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Luís Antônio da Silva', '20/01/1977', 1290.20, 'Advogado', '012.124.624-09', 'Casado', 'Masculino', 0, 2);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Luis Jairo', '22/10/1976', 2600.30, 'Engenheiro Civil', '111.222.333-09', 'Solteiro', 'Masculino', 2, 4);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Samuel Duarte', '01/12/1996', 1928.45, 'Autônomo', '222.333.444-09', 'Divorciado', 'Masculino', 1, 4);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Eduardo Valadares', '12/02/1989', 1220.33, 'Eletrocista', '333.444.555-09', 'Divorciado', 'Masculino', 0, 5);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Yasmyne Silva', '17/05/1995', 1220.90, 'Barbeiro', '444.555.666-09', 'Casado', 'Feminino', 0, 6);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Paulo Eduardo SIlva e Barbosa', '27/01/1945', 8760.24, 'Carpinteiro', '555.666.777-09', 'Solteiro', 'Masculino', 1, 6);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Estêvão Duarte Farias', '22/02/1955', 10999.8, 'Estudante', '666.777.888-09', 'Casado', 'Masculino', 2, 5);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Ricardo Fernandes', '21/03/1957', 3080.89, 'Professor', '777.888.999-09', 'Solteiro', 'Masculino', 2, 7);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Bruno Andrade', '12/04/1979', 1088.23, 'Analista de Sistemas', '888.999.000-09', 'Casado', 'Masculino', 5, 6);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Livia Caroline da Silva', '14/07/1981', 1882.23, 'Engenheiro de Materiais', '999.000.111-09', 'Casado', 'Feminino', 7, 5);
INSERT INTO candidato (nome, data_nascimento, salario, profissao, cpf, estado_civil, sexo, quantidade_dependentes, endereco_id) VALUES ('Ricardo da Silva Fernandes', '15/08/1982', 1999.10, 'Vendedor', '003.200.777-69', 'Divorciado', 'Masculino', 7, 4);

INSERT INTO usuario (nome,	login, senha, funcao) VALUES ('Edvanda Gomes da Silva', 'root', '1234', 'Analista');
INSERT INTO usuario (nome,	login, senha, funcao) VALUES ('Gabrielle Rodrigues Almeira', 'toor', '1234', 'Captador');
INSERT INTO usuario (nome,	login, senha, funcao) VALUES ('Caroline Ramalho', 'toor', '1234', 'Analista');
INSERT INTO usuario (nome,	login, senha, funcao) VALUES ('Joselito Costa Ramalho', 'toor', '1234', 'Captador');
INSERT INTO usuario (nome,	login, senha, funcao) VALUES ('Wilder Gomes', 'toor', '1234', 'Analista');
INSERT INTO usuario (nome,	login, senha, funcao) VALUES ('Ellen Soraya', 'toor', '1234', 'Captador');
INSERT INTO usuario (nome,	login, senha, funcao) VALUES ('Allef Gomes da Costa', 'toor', '1234', 'Analista');
INSERT INTO usuario (nome,	login, senha, funcao) VALUES ('Achiles Luciano', 'toor', '1234', 'Captador');

INSERT INTO proposta (status, usuario_id, candidato_id) VALUES ('Pendente', 1, 1);
INSERT INTO proposta (status, usuario_id, candidato_id) VALUES ('Pendente', 3, 2);
INSERT INTO proposta (status, usuario_id, candidato_id) VALUES ('Pendente', 5, 3);
INSERT INTO proposta (status, usuario_id, candidato_id) VALUES ('Pendente', 7, 4);
INSERT INTO proposta (status, usuario_id, candidato_id) VALUES ('Pendente', 1, 5);
INSERT INTO proposta (status, usuario_id, candidato_id) VALUES ('Pendente', 3, 6);