package com.huawei.mlkit.sample;
import android.graphics.Bitmap;

public class ListInfo {
    private  String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPakName() {
        return pakName;
    }
    public void setPakName(String pakName) {
        this.pakName = pakName;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public Bitmap getIcon() {
        return icon;
    }
    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }
    private  String pakName;
    private String code;
    private Bitmap icon;
}
