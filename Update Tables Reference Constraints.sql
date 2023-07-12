/* UsersAlpha table foreign keys */

alter table Userss add constraint FK_UsersAlpha_role_id foreign key (role_id) references Roles(role_id)
alter table Userss add constraint FK_UsersAlpha_client_id foreign key (client_id) references Client(client_id)

/* Meeting Rooms  table foreign keys */
alter table MeetingRooms add constraint FK_MeetingRooms_room_type_id foreign key (room_type_id) references RoomType(room_type_id)


/* Meeting Rooms Bookings  table foreign keys */

alter table MeetingRoomBookings add constraint FK_MeetingRoomBookings_users_id foreign key (users_id) references Userss(users_id)

alter table MeetingRoomBookings add constraint FK_MeetingRoomBookings_room_id foreign key (room_id) references MeetingRooms(room_id)


/* Employee Register table foreign keys */
alter table EmployeeRegister add constraint FK_EmployeeRegister_sign_type_id foreign key (sign_type_id) references EmpSignType(sign_type_id)

/* Assetss table foreign keys */

alter table Assetss add constraint FK_Assetss_users_id foreign key (users_id) references Userss(users_id)
alter table Assetss add constraint FK_Assetss_client_id foreign key (client_id) references Client(client_id)


/* Assets Log table foreign keys */
alter table AssetLog add constraint FK_AssetLog_users_id foreign key (users_id) references Userss(users_id)

alter table AssetLog add constraint FK_AssetLog_asset_id foreign key (asset_id) references Assetss(asset_id)
