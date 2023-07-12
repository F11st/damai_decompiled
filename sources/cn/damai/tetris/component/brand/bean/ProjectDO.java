package cn.damai.tetris.component.brand.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ProjectDO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String id;
    private String name;
    private String priceStr;
    private String showTime;
    private String subTitle;
    private String venueCity;
    private String venueName;
    private String verticalPic;

    public String getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "230626294") ? (String) ipChange.ipc$dispatch("230626294", new Object[]{this}) : this.id;
    }

    public String getName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1635547802") ? (String) ipChange.ipc$dispatch("-1635547802", new Object[]{this}) : this.name;
    }

    public String getPriceStr() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "759199363") ? (String) ipChange.ipc$dispatch("759199363", new Object[]{this}) : this.priceStr;
    }

    public String getShowTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1948448965") ? (String) ipChange.ipc$dispatch("1948448965", new Object[]{this}) : this.showTime;
    }

    public String getSubTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2007390637") ? (String) ipChange.ipc$dispatch("-2007390637", new Object[]{this}) : this.subTitle;
    }

    public String getVenueCity() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-154769739") ? (String) ipChange.ipc$dispatch("-154769739", new Object[]{this}) : this.venueCity;
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-810584107") ? (String) ipChange.ipc$dispatch("-810584107", new Object[]{this}) : this.venueName;
    }

    public String getVerticalPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "329389935") ? (String) ipChange.ipc$dispatch("329389935", new Object[]{this}) : this.verticalPic;
    }

    public void setId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1695799976")) {
            ipChange.ipc$dispatch("1695799976", new Object[]{this, str});
        } else {
            this.id = str;
        }
    }

    public void setName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "544868920")) {
            ipChange.ipc$dispatch("544868920", new Object[]{this, str});
        } else {
            this.name = str;
        }
    }

    public void setPriceStr(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2116951365")) {
            ipChange.ipc$dispatch("-2116951365", new Object[]{this, str});
        } else {
            this.priceStr = str;
        }
    }

    public void setShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390047929")) {
            ipChange.ipc$dispatch("390047929", new Object[]{this, str});
        } else {
            this.showTime = str;
        }
    }

    public void setSubTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1981895445")) {
            ipChange.ipc$dispatch("-1981895445", new Object[]{this, str});
        } else {
            this.subTitle = str;
        }
    }

    public void setVenueCity(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1826867809")) {
            ipChange.ipc$dispatch("1826867809", new Object[]{this, str});
        } else {
            this.venueCity = str;
        }
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1323508415")) {
            ipChange.ipc$dispatch("-1323508415", new Object[]{this, str});
        } else {
            this.venueName = str;
        }
    }

    public void setVerticalPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-678797849")) {
            ipChange.ipc$dispatch("-678797849", new Object[]{this, str});
        } else {
            this.verticalPic = str;
        }
    }
}
