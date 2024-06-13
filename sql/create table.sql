Create table Song(`id` int(8) not null auto_increment,
                    name varchar(255) not null,
                    style varchar(255),
                    issue_date date,
                    duration time,
                    lyricist_id int(8),
                    composer_id int(8),
                    album_id int (8),
                    primary key(`id`));

Create table Album(`id` int(8) not null auto_increment,
                    name varchar(255) not null,
                    issue_date date,
                    title_song_id int(8),
                    performer_id int(8),
                    primary key(`id`));

Create table Performer(`id` int(8) not null auto_increment,
                    company_id int(8),
                    primary key(`id`));

Create table Band(`id` int(8) not null auto_increment,
                    name varchar(255) not null,
                    region varchar(255),
                    performer_id int(8),
                    primary key(`id`));

Create table Singer(`id` int(8) not null auto_increment,
                    name varchar(255) not null,
                    gender varchar(255),
                    region varchar(255),
                    performer_id int(8),
                    primary key(`id`));

Create table Company(`id` int(8) not null auto_increment,
                    name varchar(255) not null,
                    region varchar(255),
                    established_time date,
                    primary key(`id`));

Create table Lyricist(`id` int(8) not null auto_increment,
                    name varchar(255) not null,
                    gender varchar(255),
                    primary key(`id`));

Create table Composer(`id` int(8) not null auto_increment,
                    name varchar(255) not null,
                    gender varchar(255),
                    primary key(`id`));

Create table SingSong(song_id int(8) not null,
                    performer_id int(8) not null,
                    primary key(song_id,performer_id));

Create table BandMember(band_id int(8) not null,
                    singer_id int(8) not null,
                    primary key(band_id,singer_id));