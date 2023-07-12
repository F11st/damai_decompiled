package cn.damai.tetris.component.star.content.base.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class ContentFreeRootBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean artistVip;
    private Button button;
    private List<ContentItemBean> contents;
    private boolean hasNext;
    private String subPageUrl;
    private int type;

    public boolean getArtistVip() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1788398153") ? ((Boolean) ipChange.ipc$dispatch("1788398153", new Object[]{this})).booleanValue() : this.artistVip;
    }

    public Button getButton() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-250203627") ? (Button) ipChange.ipc$dispatch("-250203627", new Object[]{this}) : this.button;
    }

    public List<ContentItemBean> getContents() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1604078130") ? (List) ipChange.ipc$dispatch("1604078130", new Object[]{this}) : this.contents;
    }

    public boolean getHasNext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1289479406") ? ((Boolean) ipChange.ipc$dispatch("-1289479406", new Object[]{this})).booleanValue() : this.hasNext;
    }

    public String getSubPageUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1628671951") ? (String) ipChange.ipc$dispatch("-1628671951", new Object[]{this}) : this.subPageUrl;
    }

    public int getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "935830600") ? ((Integer) ipChange.ipc$dispatch("935830600", new Object[]{this})).intValue() : this.type;
    }

    public void setArtistVip(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2069338019")) {
            ipChange.ipc$dispatch("2069338019", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.artistVip = z;
        }
    }

    public void setButton(Button button) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-471828265")) {
            ipChange.ipc$dispatch("-471828265", new Object[]{this, button});
        } else {
            this.button = button;
        }
    }

    public void setContents(List<ContentItemBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1992236506")) {
            ipChange.ipc$dispatch("1992236506", new Object[]{this, list});
        } else {
            this.contents = list;
        }
    }

    public void setHasNext(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1204120826")) {
            ipChange.ipc$dispatch("1204120826", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.hasNext = z;
        }
    }

    public void setSubPageUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1059106355")) {
            ipChange.ipc$dispatch("-1059106355", new Object[]{this, str});
        } else {
            this.subPageUrl = str;
        }
    }

    public void setType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1142572454")) {
            ipChange.ipc$dispatch("-1142572454", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.type = i;
        }
    }
}
