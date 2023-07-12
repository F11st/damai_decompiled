package cn.damai.common.badge.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class BadgeNodeItem implements Serializable, Cloneable {
    private static transient /* synthetic */ IpChange $ipChange;
    private int count;
    private int elimination;
    private String ext;
    private String nodeId;
    private int style;
    private String text;
    private long version;

    public Object clone() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1396566488")) {
            return ipChange.ipc$dispatch("-1396566488", new Object[]{this});
        }
        try {
            return super.clone();
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "28780253") ? ((Integer) ipChange.ipc$dispatch("28780253", new Object[]{this})).intValue() : this.count;
    }

    public int getElimination() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-604650841") ? ((Integer) ipChange.ipc$dispatch("-604650841", new Object[]{this})).intValue() : this.elimination;
    }

    public String getExt() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-465899000") ? (String) ipChange.ipc$dispatch("-465899000", new Object[]{this}) : this.ext;
    }

    public String getNodeId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1170131436") ? (String) ipChange.ipc$dispatch("1170131436", new Object[]{this}) : this.nodeId;
    }

    public int getStyle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1896251653") ? ((Integer) ipChange.ipc$dispatch("-1896251653", new Object[]{this})).intValue() : this.style;
    }

    public String getText() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "581853532") ? (String) ipChange.ipc$dispatch("581853532", new Object[]{this}) : this.text;
    }

    public long getVersion() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1989299851") ? ((Long) ipChange.ipc$dispatch("-1989299851", new Object[]{this})).longValue() : this.version;
    }

    public void setCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1853756979")) {
            ipChange.ipc$dispatch("-1853756979", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i < 0) {
            i = 0;
        }
        this.count = i;
    }

    public void setElimination(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-644243389")) {
            ipChange.ipc$dispatch("-644243389", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.elimination = i;
        }
    }

    public void setExt(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-139419026")) {
            ipChange.ipc$dispatch("-139419026", new Object[]{this, str});
        } else {
            this.ext = str;
        }
    }

    public void setNodeId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519244146")) {
            ipChange.ipc$dispatch("519244146", new Object[]{this, str});
        } else {
            this.nodeId = str;
        }
    }

    public void setStyle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1400203921")) {
            ipChange.ipc$dispatch("-1400203921", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.style = i;
        }
    }

    public void setText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "564833538")) {
            ipChange.ipc$dispatch("564833538", new Object[]{this, str});
        } else {
            this.text = str;
        }
    }

    public void setVersion(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "984508631")) {
            ipChange.ipc$dispatch("984508631", new Object[]{this, Long.valueOf(j)});
        } else {
            this.version = j;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1086565751")) {
            return (String) ipChange.ipc$dispatch("-1086565751", new Object[]{this});
        }
        return "BadgeNodeItem{nodeId='" + this.nodeId + "', version=" + this.version + ", count=" + this.count + ", elimination=" + this.elimination + ", style=" + this.style + ", ext='" + this.ext + "', text='" + this.text + "'}";
    }
}
