package cn.damai.seatdecoder.common.decoder.serialize.quantumbinrary.binary.model.orig;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Objects;
import tb.sh2;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class OrigChair implements Comparable<OrigChair> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int angle;
    private String chairId;
    private String floorId;
    private long groupId;
    private long groupPriceId;
    private long priceId;
    private String rowId;
    private int secondIndex;
    private long sid;
    private int x;
    private int y;

    public OrigChair() {
    }

    private int compareImpl(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-186461529")) {
            return ((Integer) ipChange.ipc$dispatch("-186461529", new Object[]{this, str, str2})).intValue();
        }
        int a = sh2.a(str);
        int a2 = sh2.a(str2);
        return a != a2 ? a - a2 : str.compareTo(str2);
    }

    public boolean equals(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1775973062")) {
            return ((Boolean) ipChange.ipc$dispatch("1775973062", new Object[]{this, obj})).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OrigChair origChair = (OrigChair) obj;
        return this.sid == origChair.sid && this.x == origChair.x && this.y == origChair.y && this.priceId == origChair.priceId && this.groupId == origChair.groupId && this.groupPriceId == origChair.groupPriceId && this.angle == origChair.angle && this.secondIndex == origChair.secondIndex && Objects.equals(this.floorId, origChair.floorId) && Objects.equals(this.rowId, origChair.rowId) && Objects.equals(this.chairId, origChair.chairId);
    }

    public int getAngle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-730920901") ? ((Integer) ipChange.ipc$dispatch("-730920901", new Object[]{this})).intValue() : this.angle;
    }

    public String getChairId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-734039995") ? (String) ipChange.ipc$dispatch("-734039995", new Object[]{this}) : this.chairId;
    }

    public String getFloorId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1438286260") ? (String) ipChange.ipc$dispatch("-1438286260", new Object[]{this}) : this.floorId;
    }

    public long getGroupId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1351977419") ? ((Long) ipChange.ipc$dispatch("-1351977419", new Object[]{this})).longValue() : this.groupId;
    }

    public long getGroupPriceId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1903934270") ? ((Long) ipChange.ipc$dispatch("1903934270", new Object[]{this})).longValue() : this.groupPriceId;
    }

    public long getPriceId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "197323179") ? ((Long) ipChange.ipc$dispatch("197323179", new Object[]{this})).longValue() : this.priceId;
    }

    public String getRowId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-835564518") ? (String) ipChange.ipc$dispatch("-835564518", new Object[]{this}) : this.rowId;
    }

    public int getSecondIndex() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1351394320") ? ((Integer) ipChange.ipc$dispatch("-1351394320", new Object[]{this})).intValue() : this.secondIndex;
    }

    public long getSid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "992471009") ? ((Long) ipChange.ipc$dispatch("992471009", new Object[]{this})).longValue() : this.sid;
    }

    public int getX() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-83798666") ? ((Integer) ipChange.ipc$dispatch("-83798666", new Object[]{this})).intValue() : this.x;
    }

    public int getY() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-83768875") ? ((Integer) ipChange.ipc$dispatch("-83768875", new Object[]{this})).intValue() : this.y;
    }

    public int hashCode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "29454973") ? ((Integer) ipChange.ipc$dispatch("29454973", new Object[]{this})).intValue() : Objects.hash(Long.valueOf(this.sid), this.floorId, this.rowId, this.chairId, Integer.valueOf(this.x), Integer.valueOf(this.y), Long.valueOf(this.priceId), Long.valueOf(this.groupId), Long.valueOf(this.groupPriceId), Integer.valueOf(this.angle), Integer.valueOf(this.secondIndex));
    }

    public void setAngle(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "365311023")) {
            ipChange.ipc$dispatch("365311023", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.angle = i;
        }
    }

    public void setChairId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1398310353")) {
            ipChange.ipc$dispatch("1398310353", new Object[]{this, str});
        } else {
            this.chairId = str;
        }
    }

    public void setFloorId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1041512618")) {
            ipChange.ipc$dispatch("1041512618", new Object[]{this, str});
        } else {
            this.floorId = str;
        }
    }

    public void setGroupId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-733332457")) {
            ipChange.ipc$dispatch("-733332457", new Object[]{this, Long.valueOf(j)});
        } else {
            this.groupId = j;
        }
    }

    public void setGroupPriceId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1643690438")) {
            ipChange.ipc$dispatch("1643690438", new Object[]{this, Long.valueOf(j)});
        } else {
            this.groupPriceId = j;
        }
    }

    public void setPriceId(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "50345825")) {
            ipChange.ipc$dispatch("50345825", new Object[]{this, Long.valueOf(j)});
        } else {
            this.priceId = j;
        }
    }

    public void setRowId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1936296036")) {
            ipChange.ipc$dispatch("-1936296036", new Object[]{this, str});
        } else {
            this.rowId = str;
        }
    }

    public void setSecondIndex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1976512538")) {
            ipChange.ipc$dispatch("1976512538", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.secondIndex = i;
        }
    }

    public void setSid(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1656301077")) {
            ipChange.ipc$dispatch("-1656301077", new Object[]{this, Long.valueOf(j)});
        } else {
            this.sid = j;
        }
    }

    public void setX(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1136126036")) {
            ipChange.ipc$dispatch("1136126036", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.x = i;
        }
    }

    public void setY(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137049557")) {
            ipChange.ipc$dispatch("1137049557", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.y = i;
        }
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "332266279")) {
            return (String) ipChange.ipc$dispatch("332266279", new Object[]{this});
        }
        return "OrigChair{sid=" + this.sid + ", floorId='" + this.floorId + "', rowId='" + this.rowId + "', chairId='" + this.chairId + "', x=" + this.x + ", y=" + this.y + ", priceId=" + this.priceId + ", groupId=" + this.groupId + ", groupPriceId=" + this.groupPriceId + ", angle=" + this.angle + ", secondIndex=" + this.secondIndex + '}';
    }

    public OrigChair(OrigChair origChair) {
        this.sid = origChair.getSid();
        this.floorId = origChair.getFloorId();
        this.rowId = origChair.getRowId();
        this.chairId = origChair.getChairId();
        this.x = origChair.getX();
        this.y = origChair.getY();
        this.priceId = origChair.getPriceId();
        this.groupId = origChair.getGroupId();
        this.groupPriceId = origChair.getGroupPriceId();
        this.angle = origChair.getAngle();
        this.secondIndex = origChair.getSecondIndex();
    }

    @Override // java.lang.Comparable
    public int compareTo(OrigChair origChair) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "403038039")) {
            return ((Integer) ipChange.ipc$dispatch("403038039", new Object[]{this, origChair})).intValue();
        }
        if (!this.floorId.equalsIgnoreCase(origChair.floorId)) {
            return compareImpl(this.floorId, origChair.floorId);
        }
        if (!this.rowId.equalsIgnoreCase(origChair.rowId)) {
            return compareImpl(this.rowId, origChair.rowId);
        }
        if (this.chairId.equalsIgnoreCase(origChair.chairId)) {
            return 0;
        }
        return compareImpl(this.chairId, origChair.chairId);
    }
}
