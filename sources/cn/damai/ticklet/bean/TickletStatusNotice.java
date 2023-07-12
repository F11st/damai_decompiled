package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TickletStatusNotice implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    private String announcementSkipURL;
    public String imageUrl;
    private String notice;
    private String popupContent;
    private String popupTitle;

    public String getAnnouncementSkipURL() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-929533247") ? (String) ipChange.ipc$dispatch("-929533247", new Object[]{this}) : this.announcementSkipURL;
    }

    public String getNotice() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-816414666") ? (String) ipChange.ipc$dispatch("-816414666", new Object[]{this}) : this.notice;
    }

    public String getPopupContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "101987531") ? (String) ipChange.ipc$dispatch("101987531", new Object[]{this}) : this.popupContent;
    }

    public String getPopupTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1167453462") ? (String) ipChange.ipc$dispatch("-1167453462", new Object[]{this}) : this.popupTitle;
    }

    public void setAnnouncementSkipURL(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1371037483")) {
            ipChange.ipc$dispatch("-1371037483", new Object[]{this, str});
        } else {
            this.announcementSkipURL = str;
        }
    }

    public void setNotice(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-934142872")) {
            ipChange.ipc$dispatch("-934142872", new Object[]{this, str});
        } else {
            this.notice = str;
        }
    }

    public void setPopupContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-735472781")) {
            ipChange.ipc$dispatch("-735472781", new Object[]{this, str});
        } else {
            this.popupContent = str;
        }
    }

    public void setPopupTitle(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "353764916")) {
            ipChange.ipc$dispatch("353764916", new Object[]{this, str});
        } else {
            this.popupTitle = str;
        }
    }
}
