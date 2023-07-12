package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes16.dex */
public class ProjectDynamicArtistBean implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long serialVersionUID = -3421669709263056768L;
    private String archives;
    private long artistId;
    private String artistName;
    private String picUrl;
    private String tag;
    private String type;

    public String getArchives() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "122714831") ? (String) ipChange.ipc$dispatch("122714831", new Object[]{this}) : this.archives;
    }

    public long getArtistId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1282391692") ? ((Long) ipChange.ipc$dispatch("-1282391692", new Object[]{this})).longValue() : this.artistId;
    }

    public String getArtistName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-778948080") ? (String) ipChange.ipc$dispatch("-778948080", new Object[]{this}) : this.artistName;
    }

    public String getPicUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "915419427") ? (String) ipChange.ipc$dispatch("915419427", new Object[]{this}) : this.picUrl;
    }

    public String getTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-649118478") ? (String) ipChange.ipc$dispatch("-649118478", new Object[]{this}) : this.tag;
    }

    public String getType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1711740184") ? (String) ipChange.ipc$dispatch("1711740184", new Object[]{this}) : this.type;
    }

    public void setArchives(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-373135377")) {
            ipChange.ipc$dispatch("-373135377", new Object[]{this, str});
        } else {
            this.archives = str;
        }
    }

    public void setArtistId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-188653488")) {
            ipChange.ipc$dispatch("-188653488", new Object[]{this, Long.valueOf(j)});
        } else {
            this.artistId = j;
        }
    }

    public void setArtistName(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-487470130")) {
            ipChange.ipc$dispatch("-487470130", new Object[]{this, str});
        } else {
            this.artistName = str;
        }
    }

    public void setPicUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1213106459")) {
            ipChange.ipc$dispatch("1213106459", new Object[]{this, str});
        } else {
            this.picUrl = str;
        }
    }

    public void setTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524255548")) {
            ipChange.ipc$dispatch("-1524255548", new Object[]{this, str});
        } else {
            this.tag = str;
        }
    }

    public void setType(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1231581382")) {
            ipChange.ipc$dispatch("1231581382", new Object[]{this, str});
        } else {
            this.type = str;
        }
    }
}
