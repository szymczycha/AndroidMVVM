package com.example.retrofit.model;

import com.google.gson.annotations.SerializedName;

public class Post {
    private int id;
    private int userId;
    private String title;

    @SerializedName("Body") // nazwa pola w API przekładana jest na naszą nazwę w aplikacji -
    private String text;    //  nie jest to konieczna operacja ale warto wiedzieć że się da

    @Override
    public String toString() {
        return "\nPost{\n" +
                "    id=" + id +
                ",\n    userId=" + userId +
                ",\n    title='" + title + '\'' +
                "\n}";
    }
}
