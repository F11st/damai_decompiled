package cn.damai.tetris.component.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TourCityItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String cityName;
    private long itemId;
    private String showTime;
    public String tourCityPic;
    private String venueName;

    public String getCityName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1783548668") ? (String) ipChange.ipc$dispatch("1783548668", new Object[]{this}) : this.cityName;
    }

    public long getItemId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1443905696") ? ((Long) ipChange.ipc$dispatch("-1443905696", new Object[]{this})).longValue() : this.itemId;
    }

    public String getShowTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1711610320") ? (String) ipChange.ipc$dispatch("1711610320", new Object[]{this}) : this.showTime;
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "437352490") ? (String) ipChange.ipc$dispatch("437352490", new Object[]{this}) : this.venueName;
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-426893982")) {
            ipChange.ipc$dispatch("-426893982", new Object[]{this, str});
        } else {
            this.cityName = str;
        }
    }

    public void setItemId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037241628")) {
            ipChange.ipc$dispatch("-1037241628", new Object[]{this, Long.valueOf(j)});
        } else {
            this.itemId = j;
        }
    }

    public void setShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1637984526")) {
            ipChange.ipc$dispatch("1637984526", new Object[]{this, str});
        } else {
            this.showTime = str;
        }
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1292179572")) {
            ipChange.ipc$dispatch("-1292179572", new Object[]{this, str});
        } else {
            this.venueName = str;
        }
    }
}
