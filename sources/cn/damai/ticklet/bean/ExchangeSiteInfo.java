package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ExchangeSiteInfo implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int OPEN_EXCHANGE_SITE = 1;
    public static final int UNOPEN_EXCHANGE_SITE = 2;
    private static final long serialVersionUID = 1;
    public String businessHoursNote;
    public String detailLocation;
    public String distanceDesc;
    public String lat;
    public String lng;
    public String remark;
    public String siteName;

    public String getDetailLocation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "8258898") ? (String) ipChange.ipc$dispatch("8258898", new Object[]{this}) : this.detailLocation;
    }

    public String getDistanceDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1235069586") ? (String) ipChange.ipc$dispatch("1235069586", new Object[]{this}) : this.distanceDesc;
    }

    public String getLat() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1850128681") ? (String) ipChange.ipc$dispatch("1850128681", new Object[]{this}) : this.lat;
    }

    public String getLng() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1622361169") ? (String) ipChange.ipc$dispatch("-1622361169", new Object[]{this}) : this.lng;
    }

    public String getSiteName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1320461474") ? (String) ipChange.ipc$dispatch("-1320461474", new Object[]{this}) : this.siteName;
    }

    public void setDetailLocation(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1138919116")) {
            ipChange.ipc$dispatch("1138919116", new Object[]{this, str});
        } else {
            this.detailLocation = str;
        }
    }

    public void setDistanceDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "30332556")) {
            ipChange.ipc$dispatch("30332556", new Object[]{this, str});
        } else {
            this.distanceDesc = str;
        }
    }

    public void setLat(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1357004947")) {
            ipChange.ipc$dispatch("-1357004947", new Object[]{this, str});
        } else {
            this.lat = str;
        }
    }

    public void setLng(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1630007897")) {
            ipChange.ipc$dispatch("-1630007897", new Object[]{this, str});
        } else {
            this.lng = str;
        }
    }

    public void setSiteName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2133039424")) {
            ipChange.ipc$dispatch("2133039424", new Object[]{this, str});
        } else {
            this.siteName = str;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62615444")) {
            return (String) ipChange.ipc$dispatch("-62615444", new Object[]{this});
        }
        return "Site{location='" + this.detailLocation + "', distDesc='" + this.distanceDesc + "', lat='" + this.lat + "', lng='" + this.lng + "', siteName='" + this.siteName + "'}";
    }
}
