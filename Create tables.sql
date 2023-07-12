CREATE TABLE EmpSignTypeAlpha(
sign_type_id int not null,
event_name nvarchar(50) not null) 

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

CREATE TABLE Userss(
users_id int not null primary key,
first_name nvarchar (255) not null,
last_name nvarchar (255) not null,
email nvarchar (255) not null,
password_ nvarchar(255) not null,
role_id int not null,
client_id int not null

)

CREATE TABLE EmployeeRegisterAlpha(
emp_register_id int not null ,
date_time_in datetime,
date_time_out datetime,
sign_type_id int not null
)


CREATE TABLE AssetsAlpha(
asset_id int not null,
asset nvarchar(255) not null,
serial_number nvarchar(50) not null,
asset_tag nvarchar(50),
Condition nvarchar(50) not null,
users_id int not null,
client_id int not null
)

CREATE TABLE AssetLogAlpha(
assetlog_ID int not null,
signout_date datetime not null,
signin_date datetime,
sign_out_declaration nvarchar(255),
asset_id int not null,
users_id int not null
)

CREATE TABLE MeetingRoomBookingsAlpha(
room_bookings_id int not null,
date_time_in datetime not null,
date_time_out datetime not null,
users_id int not null,
room_id int not null
)

CREATE TABLE MeetingRoomsAlpha(
room_id int not null,
availability_status nvarchar(50) not null,
persons_capacity int not null,
room_color nvarchar(30) not null,
room_type_id int not null
)

CREATE TABLE RoomTypeAlpha(
room_type_id int not null,
room_type nvarchar not null
)

CREATE TABLE FoodInventoryAlpha
(
food_item_id int not null,
food_item_name nvarchar(50) not null,
total_units int not null
)
