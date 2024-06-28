create database ProjetoPC;

user ProjetoPc;

create table Equipamentos(
	tipoEquipamento varchar(15) not null,
	notaFiscal varchar(50) not null,
	patrimonio varchar(12) not null,
	destino varchar (50),
	responsavel varchar(30),
	estado varchar(15) not null
); 

create table Usuarios (
	tipoUsuario varchar(30) not null,
	nomeUsuario VARCHAR(35) not null,
	usuario varchar(10) not null,
	senha varchar(8) not null
);


