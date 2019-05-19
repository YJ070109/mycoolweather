package com.example.y.mycoolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Y on 2019/5/19.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {

        @SerializedName("loc")
        public String updateTime;

    }
}
