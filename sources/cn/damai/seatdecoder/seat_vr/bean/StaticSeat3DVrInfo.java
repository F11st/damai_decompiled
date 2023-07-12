package cn.damai.seatdecoder.seat_vr.bean;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class StaticSeat3DVrInfo {
    private static transient /* synthetic */ IpChange $ipChange;
    private Long floorId;
    private double fov;
    private double horizontal;
    private String img;
    private String imgHash;
    private Long sid;
    private String thumb;
    private double vertical;

    public Long getFloorId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1826755080") ? (Long) ipChange.ipc$dispatch("1826755080", new Object[]{this}) : this.floorId;
    }

    public double getFov() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1137811093") ? ((Double) ipChange.ipc$dispatch("1137811093", new Object[]{this})).doubleValue() : this.fov;
    }

    public double getHorizontal() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-506815296") ? ((Double) ipChange.ipc$dispatch("-506815296", new Object[]{this})).doubleValue() : this.horizontal;
    }

    public String getImg() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1523944655") ? (String) ipChange.ipc$dispatch("1523944655", new Object[]{this}) : this.img;
    }

    public String getImgHash() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1228260099") ? (String) ipChange.ipc$dispatch("-1228260099", new Object[]{this}) : this.imgHash;
    }

    public Long getSid() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "350939471") ? (Long) ipChange.ipc$dispatch("350939471", new Object[]{this}) : this.sid;
    }

    public String getThumb() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1654443230") ? (String) ipChange.ipc$dispatch("-1654443230", new Object[]{this}) : this.thumb;
    }

    public double getVertical() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-806013842") ? ((Double) ipChange.ipc$dispatch("-806013842", new Object[]{this})).doubleValue() : this.vertical;
    }

    public void setFloorId(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "283505592")) {
            ipChange.ipc$dispatch("283505592", new Object[]{this, l});
        } else {
            this.floorId = l;
        }
    }

    public void setFov(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1445731349")) {
            ipChange.ipc$dispatch("-1445731349", new Object[]{this, Double.valueOf(d)});
        } else {
            this.fov = d;
        }
    }

    public void setHorizontal(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "528467384")) {
            ipChange.ipc$dispatch("528467384", new Object[]{this, Double.valueOf(d)});
        } else {
            this.horizontal = d;
        }
    }

    public void setImg(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1416192135")) {
            ipChange.ipc$dispatch("1416192135", new Object[]{this, str});
        } else {
            this.img = str;
        }
    }

    public void setImgHash(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1037610983")) {
            ipChange.ipc$dispatch("-1037610983", new Object[]{this, str});
        } else {
            this.imgHash = str;
        }
    }

    public void setSid(Long l) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1401099439")) {
            ipChange.ipc$dispatch("-1401099439", new Object[]{this, l});
        } else {
            this.sid = l;
        }
    }

    public void setThumb(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1551732332")) {
            ipChange.ipc$dispatch("-1551732332", new Object[]{this, str});
        } else {
            this.thumb = str;
        }
    }

    public void setVertical(double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1694152394")) {
            ipChange.ipc$dispatch("1694152394", new Object[]{this, Double.valueOf(d)});
        } else {
            this.vertical = d;
        }
    }
}
