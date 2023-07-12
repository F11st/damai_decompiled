package cn.damai.commonbusiness.seatbiz.seat.common.helper.seat.parser.quantumbinrary.binary.model;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.pa;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class Chair {
    private static transient /* synthetic */ IpChange $ipChange;
    public long groupId;
    public long groupPriceId;
    public long priceId;
    public long sid;
    public short x;
    public short y;
    private FloorId mFloorId = new FloorId();
    private RowId mRowId = new RowId();
    private ChairId mChairId = new ChairId();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class ChairId extends pa {
        public ChairId() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class FloorId extends pa {
        public FloorId() {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class RowId extends pa {
        public RowId() {
        }
    }

    public ChairId chairId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "228588084") ? (ChairId) ipChange.ipc$dispatch("228588084", new Object[]{this}) : this.mChairId;
    }

    public FloorId floorId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1897350292") ? (FloorId) ipChange.ipc$dispatch("1897350292", new Object[]{this}) : this.mFloorId;
    }

    public RowId rowId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "295137172") ? (RowId) ipChange.ipc$dispatch("295137172", new Object[]{this}) : this.mRowId;
    }
}
