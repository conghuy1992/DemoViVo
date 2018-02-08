package com.mobile.vivo.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by maidinh on 7/24/2017.
 */

public class MenuDto implements Serializable{
    public String title = "";
    public int icon;
    public int id;
    public int type;

    public List<MenuDto> dtoList;
}
