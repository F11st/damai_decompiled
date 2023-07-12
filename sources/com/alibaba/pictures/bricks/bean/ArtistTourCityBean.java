package com.alibaba.pictures.bricks.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class ArtistTourCityBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HAS_PRODUCT = "1";
    public static final String IS_HOT = "1";
    public static final String IS_WANT = "1";
    public String actionUrl;
    public String address;
    public String cityId;
    public String cityName;
    public String hotStatus;
    public String id;
    public String showTime;
    public String status;
    public String wantSeeStatus;

    public static String getOperateType(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1862369260") ? (String) ipChange.ipc$dispatch("1862369260", new Object[]{str}) : isWant(str) ? "0" : "1";
    }

    public static boolean hasProduct(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-362275701") ? ((Boolean) ipChange.ipc$dispatch("-362275701", new Object[]{str})).booleanValue() : Objects.equals(str, "1");
    }

    public static boolean isHot(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "712354979") ? ((Boolean) ipChange.ipc$dispatch("712354979", new Object[]{str})).booleanValue() : Objects.equals(str, "1");
    }

    public static boolean isWant(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1302247110") ? ((Boolean) ipChange.ipc$dispatch("1302247110", new Object[]{str})).booleanValue() : Objects.equals(str, "1");
    }
}
