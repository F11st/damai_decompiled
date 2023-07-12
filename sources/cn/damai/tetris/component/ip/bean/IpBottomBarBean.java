package cn.damai.tetris.component.ip.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class IpBottomBarBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String discount;
    public boolean focus;
    public String ipId;
    private String ipvuv;
    private List<BottomItem> items;
    private int prepareCities;
    private int tourCities;

    public String getDiscount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1368874089") ? (String) ipChange.ipc$dispatch("-1368874089", new Object[]{this}) : this.discount;
    }

    public String getIpvuv() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1332261456") ? (String) ipChange.ipc$dispatch("-1332261456", new Object[]{this}) : this.ipvuv;
    }

    public List<BottomItem> getItems() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-999885817") ? (List) ipChange.ipc$dispatch("-999885817", new Object[]{this}) : this.items;
    }

    public int getPrepareCities() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1712077251") ? ((Integer) ipChange.ipc$dispatch("1712077251", new Object[]{this})).intValue() : this.prepareCities;
    }

    public int getTourCities() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-257233828") ? ((Integer) ipChange.ipc$dispatch("-257233828", new Object[]{this})).intValue() : this.tourCities;
    }

    public void setDiscount(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "632248359")) {
            ipChange.ipc$dispatch("632248359", new Object[]{this, str});
        } else {
            this.discount = str;
        }
    }

    public void setIpvuv(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-154031930")) {
            ipChange.ipc$dispatch("-154031930", new Object[]{this, str});
        } else {
            this.ipvuv = str;
        }
    }

    public void setItems(List<BottomItem> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1392405565")) {
            ipChange.ipc$dispatch("1392405565", new Object[]{this, list});
        } else {
            this.items = list;
        }
    }

    public void setPrepareCities(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "923893671")) {
            ipChange.ipc$dispatch("923893671", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.prepareCities = i;
        }
    }

    public void setTourCities(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-324437050")) {
            ipChange.ipc$dispatch("-324437050", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.tourCities = i;
        }
    }
}
