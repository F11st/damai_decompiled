package cn.damai.ticklet.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class AnnouncementVO implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = 1;
    public String announcementImageUrl;
    public String announcementSkipURL;
    public String announcementText;

    public String getAnnouncementImageUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-365321841") ? (String) ipChange.ipc$dispatch("-365321841", new Object[]{this}) : this.announcementImageUrl;
    }

    public String getAnnouncementText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1616882136") ? (String) ipChange.ipc$dispatch("-1616882136", new Object[]{this}) : this.announcementText;
    }

    public void setAnnouncementImageUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "617614127")) {
            ipChange.ipc$dispatch("617614127", new Object[]{this, str});
        } else {
            this.announcementImageUrl = str;
        }
    }

    public void setAnnouncementText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "244466614")) {
            ipChange.ipc$dispatch("244466614", new Object[]{this, str});
        } else {
            this.announcementText = str;
        }
    }
}
