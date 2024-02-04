-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
-- reiniciar la secuencia TASK_SEQ con un valor específico
-- Eliminar la secuencia existente si existe
drop sequence if exists TASK_SEQ;

-- Crear la secuencia TASK_SEQ con un valor específico
create sequence TASK_SEQ start with 1 increment by 1;
