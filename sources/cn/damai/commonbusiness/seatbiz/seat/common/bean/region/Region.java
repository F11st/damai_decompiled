package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Region implements Serializable {
    public String color;
    public long id;
    public String imaggeurl;
    public String name;
    public ArrayList<RegionLocation> regionLocationList;
    public int state;
    public String vid;
    public boolean flag = false;
    public ArrayList<Long> priceLevelIdList = new ArrayList<>();
    public HashMap<String, String> rainbowColorList = new HashMap<>();
}
