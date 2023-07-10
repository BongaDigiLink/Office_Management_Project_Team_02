CREATE TABLE ClientALPHA(
client_id int not null primary key,
client_name nvarchar(255) not null,
street_address nvarchar(255) not null,
city nvarchar(255) not null,
surburb nvarchar(255) not null,
postal_code int not null,
province nvarchar not null
)


CREATE TABLE RolesAlpha(
roles_id int not null primary key,
role_name nvarchar (255)
)

CREATE TABLE UsersAlpha(
users_id int not null primary key,
first_name nvarchar (255) not null,
last_name nvarchar (255) not null,
email nvarchar (255) not null,
password_ nvarchar(255) not null,

)