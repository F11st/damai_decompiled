package cn.damai.commonbusiness.seatbiz.seat.common.bean.region;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class RegionState {
    public static final int STATE_SALEABLE = 1;
    public static final int STATE_SOLD_OUT = 0;
    public String id;
    public int state = 0;
    public String vid;

    public RegionState(Region region) {
        this.id = region.id + "";
        this.vid = region.vid;
    }
}
