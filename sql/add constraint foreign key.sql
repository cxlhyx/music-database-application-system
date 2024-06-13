alter table Song
    add constraint lyricsBy foreign key (lyricist_id)
    references Lyricist (`id`) 
    ON DELETE SET NULL 
    ON UPDATE SET NULL;

alter table Song
    add constraint Compose foreign key (composer_id)
    references Composer (`id`) 
    ON DELETE SET NULL 
    ON UPDATE SET NULL;

alter table Song
    add constraint album_member foreign key (album_id)
    references Album (`id`) 
    ON DELETE SET NULL 
    ON UPDATE SET NULL;

alter table Album
    add constraint title_song foreign key (title_song_id)
    references Song (`id`) 
    ON DELETE SET NULL 
    ON UPDATE SET NULL;

alter table Album
    add constraint create_album foreign key (performer_id)
    references Performer (`id`) 
    ON DELETE SET NULL 
    ON UPDATE SET NULL;

alter table Performer
    add constraint work_on foreign key (company_id)
    references Company (`id`) 
    ON DELETE SET NULL 
    ON UPDATE SET NULL;

alter table Band
    add constraint performer_band foreign key (performer_id)
    references Performer (`id`) 
    ON DELETE SET NULL 
    ON UPDATE SET NULL;

alter table Singer
    add constraint performer_Singer foreign key (performer_id)
    references Performer (`id`) 
    ON DELETE SET NULL 
    ON UPDATE SET NULL;

alter table SingSong
    add constraint sing_song foreign key (song_id)
    references Song (`id`) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE;

alter table SingSong
    add constraint song_performer foreign key (performer_id)
    references Performer (`id`) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE;

alter table BandMember
    add constraint bandmember_band foreign key (band_id)
    references Band (`id`) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE;

alter table BandMember
    add constraint bandmember_singer foreign key (singer_id)
    references Singer (`id`) 
    ON DELETE CASCADE 
    ON UPDATE CASCADE;