
--Creating a database called Jukebox if it does not already exist.
    create Database  if not exists `Jukebox`;

-- Telling the database to use the jukebox database.
    use `jukebox`;

-- This is creating a table called songsList with the following columns: song_id, song_name, artist_name, album_name, song_genre, song_duration.
    CREATE TABLE `songsList` (
    `song_id` INT NOT NULL PRIMARY KEY,
    `song_name` VARCHAR(50),
    `artist_name` VARCHAR(50),
    `album_name` VARCHAR(50),
    `song_genre` VARCHAR(50),
    `song_duration` VARCHAR(20)
);
);

-- This is inserting the values into the table songsList.
INSERT INTO `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genre`, `song_duration`) VALUES('1', 'Ajeeb Dastaan Hai Yeh', 'Lata Didi', 'Ajeeb Dastaan Hai Yeh','Melody','0:30');
INSERT INTO `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genre`, `song_duration`) VALUES ('2', 'Matargashti', 'Mohit Chauhan', 'Tamasha', 'Party', '0:30');
INSERT INTO `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genre`, `song_duration`) VALUES ('3', 'Mere Sapnon Ki Rani ', 'Kishore Kumar', 'Aradhana', 'Retro', '0:30');
INSERT INTO `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genre`, `song_duration`) VALUES ('4', 'Dil Se Re', 'A R Rehman', 'Dil Se', 'Golden Era', '0:30');
INSERT INTO `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genre`, `song_duration`) VALUES ('5', 'Agar Tum Saath Ho', 'Arijit Singh', 'Tamasha', 'New Era', '0:30');
INSERT INTO `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genre`, `song_duration`) VALUES ('6', 'airanichya deva', 'Lata Didi', 'MarathiHits', 'Marathi', '3:25');
INSERT INTO `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genre`, `song_duration`) VALUES ('7', 'Yeh Kya Hua', 'Rajesh Khanna', 'Amar Prem', 'Hindi Retro', '0:30');
INSERT INTO `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genre`, `song_duration`) VALUES ('8', ' Jai Ho', 'Sukhvindar', 'Slumdog', '2010 Hits', '0:30');
INSERT INTO `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genre`, `song_duration`) VALUES ('9', 'Yeh Jo Mohabbat Hai', 'Kishore Kumar', 'Kati Patang', 'Retro', '0:30');
INSERT INTO `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genre`, `song_duration`) VALUES ('10', ' Kabhi Neem Neem', 'A R Rehman', 'Yuva', 'Golden Era', '0:30');






