create table category(
Id IDENTITY,
name varchar(50),
description varchar(255),
img_url varchar(255),
is_active BOOLEAN,
CONSTRAINT pk_category_id PRIMARY KEY(Id)
);