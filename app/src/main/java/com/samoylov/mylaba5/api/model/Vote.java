package com.samoylov.mylaba5.api.model;

import com.google.gson.annotations.SerializedName;

public class Vote {
    @SerializedName("id")
    private int id;

    public Vote(int vote_id) {
        this.id = vote_id;
    }

    public int getVote_id() {
        return id;
    }
}
