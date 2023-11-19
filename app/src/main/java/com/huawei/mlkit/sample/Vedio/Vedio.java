package com.huawei.mlkit.sample.Vedio;
public class Vedio {
    private String name;    //康复视频名字
    private int imageId;    //List中插图id号
    private String url; //视频url地址
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private int id;    //视频序号
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
