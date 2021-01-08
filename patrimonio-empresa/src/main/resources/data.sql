
INSERT INTO Users (email, nome, senha, enabled) 
values ('felipemandupereira@outlook.com', 'Felipe Mandu Pereira', '$2y$10$9K4TLkvEgu9pGeYRBZsMneVFrsVNhSAsw1L1LoHeH0EMLCVFeuUy2', TRUE)
ON CONFLICT DO NOTHING;

insert into marca (nome) 
values('Dunder Mifflin Paper Company, Inc.') 
ON CONFLICT DO NOTHING;

Delete from patrimonio p where p.marca_id = (select marca_id from marca where nome = 'Dunder Mifflin Paper Company, Inc.');

BEGIN;
	CREATE table valor (valor uuid);
	
	insert into valor(valor) 
	values((select marca_id from marca where nome = 'Dunder Mifflin Paper Company, Inc.'));

	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple stapler', 'Stapler', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple File Holder', 'File Holder', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple File Storage', 'File Storage', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Desk Organizer', 'Desk Organizer', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple File Sorter', 'File Sorter', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Letter Tray', 'Letter Tray', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Label', 'Label', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Scissor', 'Scissor', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Envelope', 'Envelope', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Binder Clip', 'Binder Clip', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Calendar', 'Calendar', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Planner', 'Planner', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Pen', 'Pen', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Pencil', 'Pencil', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Correction', 'Correction', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Whiteout', 'Whiteout', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Marker', 'Marker', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Organizer', 'Organizer', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Calculator', 'Calculator', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Tape', 'Tape', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Brifcase', 'Briefcase', (select valor from valor));
	insert into patrimonio(descricao, nome, marca_id) 
	values ('A simple Eraser', 'Eraser', (select valor from valor));
	drop table valor;
commit;