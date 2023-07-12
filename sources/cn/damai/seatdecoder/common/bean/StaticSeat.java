package cn.damai.seatdecoder.common.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class StaticSeat implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange;
    public double angle;
    public String chint;
    public String fn;
    public long groupId;
    public long groupPriceId;
    public int i = -1;
    public long plid;
    public String rhint;
    public long sid;
    public int x;
    public int y;

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-36250601")) {
            return ((Boolean) ipChange.ipc$dispatch("-36250601", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.sid == ((StaticSeat) obj).sid;
    }

    public double getAngle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "115438471") ? ((Double) ipChange.ipc$dispatch("115438471", new Object[]{this})).doubleValue() : this.angle;
    }

    public String getChint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1123635518") ? (String) ipChange.ipc$dispatch("1123635518", new Object[]{this}) : this.chint;
    }

    public String getFn() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-733950934") ? (String) ipChange.ipc$dispatch("-733950934", new Object[]{this}) : this.fn;
    }

    public long getGroupId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "250564934") ? ((Long) ipChange.ipc$dispatch("250564934", new Object[]{this})).longValue() : this.groupId;
    }

    public long getGroupPriceId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-154524979") ? ((Long) ipChange.ipc$dispatch("-154524979", new Object[]{this})).longValue() : this.groupPriceId;
    }

    public int getI() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1446953034") ? ((Integer) ipChange.ipc$dispatch("-1446953034", new Object[]{this})).intValue() : this.i;
    }

    public long getPlid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2038236987") ? ((Long) ipChange.ipc$dispatch("2038236987", new Object[]{this})).longValue() : this.plid;
    }

    public String getRhint() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "30266445") ? (String) ipChange.ipc$dispatch("30266445", new Object[]{this}) : this.rhint;
    }

    public long getSid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1395585906") ? ((Long) ipChange.ipc$dispatch("1395585906", new Object[]{this})).longValue() : this.sid;
    }

    public int getX() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1446506169") ? ((Integer) ipChange.ipc$dispatch("-1446506169", new Object[]{this})).intValue() : this.x;
    }

    public int getY() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1446476378") ? ((Integer) ipChange.ipc$dispatch("-1446476378", new Object[]{this})).intValue() : this.y;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "875814350")) {
            return ((Integer) ipChange.ipc$dispatch("875814350", new Object[]{this})).intValue();
        }
        long j = this.sid;
        return (int) (j ^ (j >>> 32));
    }

    public void setAngle(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "832643129")) {
            ipChange.ipc$dispatch("832643129", new Object[]{this, Double.valueOf(d)});
        } else {
            this.angle = d;
        }
    }

    public void setChint(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330637064")) {
            ipChange.ipc$dispatch("-1330637064", new Object[]{this, str});
        } else {
            this.chint = str;
        }
    }

    public void setFn(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1858676980")) {
            ipChange.ipc$dispatch("1858676980", new Object[]{this, str});
        } else {
            this.fn = str;
        }
    }

    public void setGroupId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1700840230")) {
            ipChange.ipc$dispatch("1700840230", new Object[]{this, Long.valueOf(j)});
        } else {
            this.groupId = j;
        }
    }

    public void setGroupPriceId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2039004137")) {
            ipChange.ipc$dispatch("-2039004137", new Object[]{this, Long.valueOf(j)});
        } else {
            this.groupPriceId = j;
        }
    }

    public void setI(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1828013588")) {
            ipChange.ipc$dispatch("1828013588", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.i = i;
        }
    }

    public void setPlid(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1327711895")) {
            ipChange.ipc$dispatch("-1327711895", new Object[]{this, Long.valueOf(j)});
        } else {
            this.plid = j;
        }
    }

    public void setRhint(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865339959")) {
            ipChange.ipc$dispatch("-865339959", new Object[]{this, str});
        } else {
            this.rhint = str;
        }
    }

    public void setSid(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2044641158")) {
            ipChange.ipc$dispatch("-2044641158", new Object[]{this, Long.valueOf(j)});
        } else {
            this.sid = j;
        }
    }

    public void setX(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1841866403")) {
            ipChange.ipc$dispatch("1841866403", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.x = i;
        }
    }

    public void setY(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1842789924")) {
            ipChange.ipc$dispatch("1842789924", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.y = i;
        }
    }
}
