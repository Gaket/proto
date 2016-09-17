package ru.innopolis.yorsogettingxbox.models;

import com.google.gson.annotations.SerializedName;

public class Deal {
    @SerializedName("Id")
    private Integer id;
    @SerializedName("Title")
    private String title;
    @SerializedName("Description")
    private String description;

    public Deal(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Deal{");
        sb.append("\n\t").append("id=").append(id);
        sb.append(", \n\t").append("title='").append(title).append('\'');
        sb.append(", \n\t").append("description='").append(description).append('\'');
        sb.append("\n").append('}');
        return sb.toString();
    }
}
