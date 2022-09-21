--Telling the database to use the jukebox database.
    use `jukebox`;


-- Creating a table called playlist with the following columns: song_id, song_name, artist_name, album_name, song_genere,
-- song_duartion.
        create TABLE `playlist` (
            `song_id` INT NOT NULL PRIMARY KEY,
            `song_name` VARCHAR(50),
            `artist_name` VARCHAR(50),
            `album_name` VARCHAR(50),
            `song_genere` VARCHAR(50),
            `song_duartion` varchar(20)
        );