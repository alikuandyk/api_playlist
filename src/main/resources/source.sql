create table users(
    id serial8 primary key,
    name varchar(255) not null,
    email varchar unique,
    created timestamp
);

create table tracks(
    id serial8 primary key,
    name varchar(255) not null,
    artists varchar
);

create table playlists(
    id serial8 primary key,
    author_id int8 references users(id)
);

create table tracks_playlists(
    track_id int8 references tracks(id),
    playlist_id int8 references playlists(id),
    primary key (track_id, playlist_id)
);
