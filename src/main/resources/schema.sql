create table if not exists users(
    id serial8 primary key,
    name varchar(255) not null,
    email varchar unique,
    created timestamp
);

create table if not exists tracks(
    id serial8 primary key,
    name varchar(255) not null,
    artist varchar
);

create table if not exists playlists(
    id serial8 primary key,
    name varchar not null,
    author_id int8 references users(id)
);

create table if not exists tracks_playlists(
    track_id int8 references tracks(id),
    playlist_id int8 references playlists(id),
    primary key (track_id, playlist_id)
);
