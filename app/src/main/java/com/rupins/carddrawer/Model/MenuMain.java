package com.rupins.carddrawer.Model;

import java.io.Serializable;

/**
 * Created by Arbaz.
 * Date: 31/3/18
 * Time: 3:17 PM
 */
public class MenuMain implements Serializable {
    public String ItemName;
    public int imgResID;

    public MenuMain(String itemName) {
        ItemName = itemName;
    }

    public MenuMain(String itemName, int imgResID) {
        ItemName = itemName;
        this.imgResID = imgResID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public int getImgResID() {
        return imgResID;
    }

    public void setImgResID(int imgResID) {
        this.imgResID = imgResID;
    }
}
