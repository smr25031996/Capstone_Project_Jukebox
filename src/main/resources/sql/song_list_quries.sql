
--Creating a database called Jukebox if it does not already exist.
    create Database  if not exists `Jukebox`;

-- Telling the database to use the jukebox database.
    use `jukebox`;

-- This is creating a table called songsList with the following columns: song_id, song_name, artist_name, album_name, song_genere, song_duartion.
    create TABLE `songsList` (
    `song_id` INT NOT NULL PRIMARY KEY,
    `song_name` VARCHAR(50),
    `artist_name` VARCHAR(50),
    `album_name` VARCHAR(50),
    `song_genere` VARCHAR(50),
    `song_duartion` FLOAT
);

-- This is inserting the values into the table songsList.
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('1', 'Aoge jab Tum', 'Ustad rashid Kahn', 'unplugged', 'classical', '3:26');
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('2', 'Voice of the moon', 'Anoushka Shankar', 'unplugged', 'instrumental', '13:59');
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('3', 'Apsara Ali', 'Ajay Atul', 'natrang', 'lavani', '3:51');
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('4', 'Chandra', 'Shreya Ghoshal', 'Chandramukhi', 'lavani', '5:21');
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('5', 'Chaudari', 'Mane Khan', 'Folk', 'rajsthani', '7:00');
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('6', 'Husna', 'Piyush Mishra', 'MTV', 'poem', '8:02');
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('7', 'Ki Banu Duniya Da', 'Gurdas Maan', 'MTV', 'punjabi', '7:59');
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('8', 'Raghupati Raghav', 'Ashit Desai', 'bhanjan', 'devotional', '4:14');
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('9', 'Rangpura Vihara', 'Shravan Kumar Raman', 'indian raga', 'carnatic', '3:14');
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('10', 'Samja vara gamna', 'Karthi', 'indian raga', 'carnatic', '5:20');
insert into `jukebox`.`songslist` (`song_id`, `song_name`, `artist_name`, `album_name`, `song_genere`, `song_duartion`) VALUES ('11', 'Tu mane ya na mane', 'Wadali Brothres', 'folk', 'rajsthani', '10:04');






