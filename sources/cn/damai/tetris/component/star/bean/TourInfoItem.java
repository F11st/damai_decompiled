package cn.damai.tetris.component.star.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TourInfoItem implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String tourDesc;
    private String tourName;
    private String tourPic;
    private String tourPriceLow;
    private List<String> tourTags;

    public String getTourDesc() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-786928910") ? (String) ipChange.ipc$dispatch("-786928910", new Object[]{this}) : this.tourDesc;
    }

    public String getTourName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1920017900") ? (String) ipChange.ipc$dispatch("1920017900", new Object[]{this}) : this.tourName;
    }

    public String getTourPic() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "842486399") ? (String) ipChange.ipc$dispatch("842486399", new Object[]{this}) : this.tourPic;
    }

    public String getTourPriceLow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1346152020") ? (String) ipChange.ipc$dispatch("-1346152020", new Object[]{this}) : this.tourPriceLow;
    }

    public List<String> getTourTags() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1596352351") ? (List) ipChange.ipc$dispatch("-1596352351", new Object[]{this}) : this.tourTags;
    }

    public void setTourDesc(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1492679724")) {
            ipChange.ipc$dispatch("1492679724", new Object[]{this, str});
        } else {
            this.tourDesc = str;
        }
    }

    public void setTourName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491315086")) {
            ipChange.ipc$dispatch("-491315086", new Object[]{this, str});
        } else {
            this.tourName = str;
        }
    }

    public void setTourPic(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1268978985")) {
            ipChange.ipc$dispatch("-1268978985", new Object[]{this, str});
        } else {
            this.tourPic = str;
        }
    }

    public void setTourPriceLow(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616841394")) {
            ipChange.ipc$dispatch("1616841394", new Object[]{this, str});
        } else {
            this.tourPriceLow = str;
        }
    }

    public void setTourTags(List<String> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1563139403")) {
            ipChange.ipc$dispatch("1563139403", new Object[]{this, list});
        } else {
            this.tourTags = list;
        }
    }
}
