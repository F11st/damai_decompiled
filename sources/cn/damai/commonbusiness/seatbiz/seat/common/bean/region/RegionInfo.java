package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionInfo {
    public long cityId;
    public String compressMode;
    public boolean isZWB2b2c;
    public ArrayMap<String, Region> mRegionArrayMap;
    public ArrayMap<String, String> mRegionIdMatchList;
    public long performanceId;
    public boolean rainbowSupport;
    public boolean rainbowSupportII;
    public String rainbowSvgImg;
    public List<List<String>> regionIdGroup;
    public ArrayList<Region> regionList;
    public int renderMode;
    public String seatImg;
    public String seatOssImg;
    public int seatStyle;
    public String seatSvgImg;
    public HashMap<String, HashMap<String, String>> standColorList = new HashMap<>();
    public int venueScale;
    public int vesion;
    @Deprecated
    public int zwvesion;
}
