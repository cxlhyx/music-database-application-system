create view PerformerName as 
    select Performer.id as id, Band.name as band_name, Singer.name as singer_name
    from Performer left outer join Band on (Performer.id=Band.performer_id)
                   left outer join Singer on (Performer.id=Singer.performer_id); 

create view SongOfPerformer as 
    select SingSong.performer_id, SingSong.song_id, Song.name 
    from  SingSong join Song on (SingSong.song_id=Song.id);

create view AlbumOfPerformer as 
    select performer_id, id as album_id, name as album_name 
    from  Album;

create view SingerInfor as 
    select Singer.id, Singer.name, Singer.gender, Singer.region, Singer.performer_id, Company.name as company_name, Company.id as company_id 
    from  Singer join Performer on (Singer.performer_id=Performer.id)
                 left join Company on (Performer.company_id=Company.id); 

create view BandInfor as 
    select Band.id, Band.name, Band.region, Band.performer_id, Company.name as company_name, Company.id as company_id 
    from  Band join Performer on (Band.performer_id=Performer.id)
                 left join Company on (Performer.company_id=Company.id); 
                    
create view SingerOfBand as 
    select BandMember.band_id, Singer.performer_id as singer_performer_id, Singer.name as singer_name
    from  BandMember join Band on (Band.id=BandMember.band_id)
                     join Singer on (Singer.id=BandMember.singer_id); 

create view SongInfor as 
    select Song.id, Song.name, Song.style, Song.issue_date, Song.duration, 
           lyricist_id, Lyricist.name as lyricist_name, 
           composer_id, Composer.name as composer_name, 
           album_id, Album.name as album_name
    from  Song left outer join Album on (Song.album_id=Album.id)
               left outer join Composer on (Song.composer_id=Composer.id)
               left outer join Lyricist on (Song.lyricist_id=Lyricist.id);

create view SongOfAlbum as 
    select Song.id as song_id, Song.name as song_name, Song.album_id
    from  Song;

create view AlbumInfor as 
    select Album.id, Album.name, Album.issue_date, title_song_id, performer_id, Song.name as title_song_name
    from  Album join Song on (Album.title_song_id=Song.id);
    
create view PerformerOfCompany as 
    select Company.id as company_id, Company.name as company_name, Performer.id as performer_id
    from  Company join Performer on (Company.id=Performer.company_id);