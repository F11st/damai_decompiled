package cn.damai.commonbusiness.seatbiz.seat.common.bean.seat;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SeatInfo implements Serializable {
    @JSONField(name = "sid")
    public long seatId;
    @JSONField(name = "s")
    public short seatState;
}
