package com.example.pulent.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultDTO {

    @SerializedName("resultCount")
    @Expose
    private int resultCount;
    @SerializedName("results")
    @Expose
    private List<SongDTO> songDTOS = null;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<SongDTO> getSongDTOList() {
        return songDTOS;
    }

    public void setSongDTOS(List<SongDTO> songDTOS) {
        this.songDTOS = songDTOS;
    }

}
