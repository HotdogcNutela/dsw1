connect 'jdbc:derby:PacotesTuristicos;create=true;user=root;password=root';

create table Usuario(id bigint not null generated always as identity, 
					 email varchar(64) not null unique, 
					 senha varchar(64) not null, 
					 nome varchar(256) not null, 
					 papel varchar(16) not null, 
					 cpf varchar(32),
					 telefone varchar(32),
					 sexo char(2), 
					 dNasc varchar(16),
					 cnpj varchar(32),
					 descricao varchar(256),
					 constraint Usuario_PK primary key (id));

insert into Usuario(email, senha, nome, papel) 
	values ('admin@email.com', 'admin', 'Admin', 'ADMIN');

insert into Usuario(email, senha, nome, papel, cpf, telefone, sexo, dNasc) 
	values ('cliente1@email.com', 'cliente1', 'Fulano da Silva', 'CLIENTE', '123456789-00', '(16) 94444-5555', 'M', '13/06/1999');

insert into Usuario(email, senha, nome, papel, cpf, telefone, sexo, dNasc)
	values ('cliente2@email.com', 'cliente2', 'Ciclana de Souza', 'CLIENTE', '456789123-00', '(17) 98888-3333', 'F', '25/02/1987');

insert into Usuario(email, senha, nome, papel, cpf, telefone, sexo, dNasc)
	values ('cliente3@email.com', 'cliente3', 'Beltrano Barbosa', 'CLIENTE', '789123456-00', '(34) 97777-9999', 'M', '04/11/2002');

insert into Usuario(email, senha, nome, papel, cnpj, descricao)
	values ('agencia1@email.com', 'agencia1', 'Viagem+', 'AGENCIA', '13.444.222/0001-77', 'Agência de viagens');

insert into Usuario(email, senha, nome, papel, cnpj, descricao)
	values ('agencia2@email.com', 'agencia2', 'Tour Viagens', 'AGENCIA', '52.333.111/0001-99', 'Organizamos sua viagem para você!!!');

insert into Usuario(email, senha, nome, papel, cnpj, descricao)
	values ('agencia3@email.com', 'agencia3', 'Turisticando', 'AGENCIA', '15.111.555/0001-00', 'Quer planejar sua viagem? Vem com a gente!!');

disconnect;

quit;