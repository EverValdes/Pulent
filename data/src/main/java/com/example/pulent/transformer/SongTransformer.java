package com.example.pulent.transformer;

import com.example.pulent.dto.SongDTO;
import models.Song;

import java.util.ArrayList;
import java.util.List;

public class SongTransformer {

    public SongDTO transform(Song song) {
        SongDTO songDTO = new SongDTO();
        songDTO.setTrackName(song.getName());
        songDTO.setArtworkUrl100(song.getImage());
        songDTO.setArtistName(song.getArtist());
        songDTO.setPreviewUrl(song.getAlbum());

        return songDTO;
    }

    public Song transform(SongDTO songDTO) {
        return new Song(songDTO.getTrackName(), songDTO.getCollectionName(), songDTO.getArtworkUrl100(), songDTO.getArtistName());
    }

    public List<Song> transformDTOList(List<SongDTO> songDTOList) {
        List<Song> songList = new ArrayList<>();
        for (SongDTO songDTO : songDTOList) {
            songList.add(transform(songDTO));
        }
        return songList;
    }

    public List<SongDTO> transformSongList(List<Song> songList) {
        List<SongDTO> songDTOList = new ArrayList<>();
        for (Song song : songList) {
            songDTOList.add(transform(song));
        }
        return songDTOList;
    }
}
