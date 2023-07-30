package com.example.androidflavors;

public class Flavors {
    private String android_flavor_name;
    private String android_flavor_version;
    private int ImageResourceId;
    private int ButtonId;

    public Flavors(String flavour_name, String version){
        android_flavor_name = flavour_name;
        android_flavor_version = version;
    }

    public Flavors(String flavour_name, String version, int image_id){
        android_flavor_name = flavour_name;
        android_flavor_version = version;
        ImageResourceId = image_id;
    }

    public Flavors(String flavour_name, String version, int image_id, int button_id){
        android_flavor_name = flavour_name;
        android_flavor_version = version;
        ImageResourceId = image_id;
        ButtonId = button_id;
    }


    public String GetFlavorName(){
        String android_flavor_name = this.android_flavor_name;
        return android_flavor_name;
    }

    public String GetFlavorVerion(){
        String android_flavor_version = this.android_flavor_version;
        return android_flavor_version;
    }
    
    public int GetImageResorceId(){
        int imageResourceId = ImageResourceId;
        return imageResourceId;
    }

    public int GetButtonId(){
        return ButtonId;
    }
}
