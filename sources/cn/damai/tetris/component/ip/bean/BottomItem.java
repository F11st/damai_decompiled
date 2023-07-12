package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class BottomItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String cityName;
    private String discount;
    private long id;
    private boolean isClosest;
    public String name;
    private long nearestTime;
    private String priceLow;
    private String showTime;
    private String startDate;
    private int total;
    private int type;
    private String venueName;
    public String verticalPic;

    public String getCityName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "828587993") ? (String) ipChange.ipc$dispatch("828587993", new Object[]{this}) : this.cityName;
    }

    public String getDiscount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1338234628") ? (String) ipChange.ipc$dispatch("1338234628", new Object[]{this}) : this.discount;
    }

    public long getId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "436052214") ? ((Long) ipChange.ipc$dispatch("436052214", new Object[]{this})).longValue() : this.id;
    }

    public boolean getIsClosest() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1924753858") ? ((Boolean) ipChange.ipc$dispatch("1924753858", new Object[]{this})).booleanValue() : this.isClosest;
    }

    public long getNearestTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2131638346") ? ((Long) ipChange.ipc$dispatch("-2131638346", new Object[]{this})).longValue() : this.nearestTime;
    }

    public String getPriceLow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2101084686") ? (String) ipChange.ipc$dispatch("2101084686", new Object[]{this}) : this.priceLow;
    }

    public String getShowTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "756649645") ? (String) ipChange.ipc$dispatch("756649645", new Object[]{this}) : this.showTime;
    }

    public String getStartDate() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2073990531") ? (String) ipChange.ipc$dispatch("2073990531", new Object[]{this}) : this.startDate;
    }

    public int getTotal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-747294692") ? ((Integer) ipChange.ipc$dispatch("-747294692", new Object[]{this})).intValue() : this.total;
    }

    public int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-18549642") ? ((Integer) ipChange.ipc$dispatch("-18549642", new Object[]{this})).intValue() : this.type;
    }

    public String getVenueName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "898342637") ? (String) ipChange.ipc$dispatch("898342637", new Object[]{this}) : this.venueName;
    }

    public void setCityName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "34096165")) {
            ipChange.ipc$dispatch("34096165", new Object[]{this, str});
        } else {
            this.cityName = str;
        }
    }

    public void setDiscount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1346727334")) {
            ipChange.ipc$dispatch("-1346727334", new Object[]{this, str});
        } else {
            this.discount = str;
        }
    }

    public void setId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "418130446")) {
            ipChange.ipc$dispatch("418130446", new Object[]{this, Long.valueOf(j)});
        } else {
            this.id = j;
        }
    }

    public void setIsClosest(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2001397578")) {
            ipChange.ipc$dispatch("2001397578", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.isClosest = z;
        }
    }

    public void setNearestTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-736214858")) {
            ipChange.ipc$dispatch("-736214858", new Object[]{this, Long.valueOf(j)});
        } else {
            this.nearestTime = j;
        }
    }

    public void setPriceLow(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826787984")) {
            ipChange.ipc$dispatch("826787984", new Object[]{this, str});
        } else {
            this.priceLow = str;
        }
    }

    public void setShowTime(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2098974673")) {
            ipChange.ipc$dispatch("2098974673", new Object[]{this, str});
        } else {
            this.showTime = str;
        }
    }

    public void setStartDate(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2096007853")) {
            ipChange.ipc$dispatch("-2096007853", new Object[]{this, str});
        } else {
            this.startDate = str;
        }
    }

    public void setTotal(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-142276498")) {
            ipChange.ipc$dispatch("-142276498", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.total = i;
        }
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-663588884")) {
            ipChange.ipc$dispatch("-663588884", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.type = i;
        }
    }

    public void setVenueName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113613097")) {
            ipChange.ipc$dispatch("113613097", new Object[]{this, str});
        } else {
            this.venueName = str;
        }
    }
}
