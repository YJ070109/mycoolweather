package com.example.y.mycoolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Y on 2019/5/19.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More {

        @SerializedName("txt")
        public String info;

    }
}
