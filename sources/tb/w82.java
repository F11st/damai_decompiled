package tb;

import android.os.Handler;
import android.os.HandlerThread;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.seat.bean.IPriceManager;
import cn.damai.seat.bean.biz.CompressSeatStatus;
import cn.damai.seat.listener.OnTListener;
import cn.damai.seat.listener.RegionSeatRequestChecker;
import cn.damai.seat.support.combine.ICombiner;
import cn.damai.seat.support.combine.OnSeatCombineListener;
import cn.damai.seat.support.combine.SeatCombineTask;
import cn.damai.seat.support.combine.SeatStateParent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class w82 implements RegionSeatRequestChecker, ICombiner {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HandlerThread a;
    private final List<String> b;
    private final Handler c;
    private SeatBox d;
    private IPriceManager e;
    private SeatStateParent f;
    private OnSeatCombineListener g;
    private boolean h;
    private boolean i;
    private final long j;
    private final long k;
    private final int l;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements OnTListener<List<String>> {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.seat.listener.OnTListener
        /* renamed from: a */
        public void call(List<String> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1829537108")) {
                ipChange.ipc$dispatch("-1829537108", new Object[]{this, list});
                return;
            }
            w82.this.b.addAll(list);
            if (w82.this.g != null) {
                OnSeatCombineListener onSeatCombineListener = w82.this.g;
                w82 w82Var = w82.this;
                onSeatCombineListener.onSeatCombineFinish(w82Var, w82Var.d);
            }
        }
    }

    public w82(OnSeatCombineListener onSeatCombineListener, long j, long j2, int i) {
        HandlerThread handlerThread = new HandlerThread("seat_combine");
        this.a = handlerThread;
        this.b = new ArrayList();
        this.h = false;
        this.i = false;
        this.j = j;
        this.k = j2;
        this.l = i;
        this.g = onSeatCombineListener;
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public void combineIfNeed() {
        SeatBox seatBox;
        SeatStateParent seatStateParent;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1120109876")) {
            ipChange.ipc$dispatch("-1120109876", new Object[]{this});
        } else if (this.i || (seatBox = this.d) == null || (seatStateParent = this.f) == null || !this.h) {
        } else {
            this.c.post(new SeatCombineTask(this.j, this.k, this.l, seatBox, this.e, seatStateParent, new a()));
        }
    }

    public SeatBox d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2068033719") ? (SeatBox) ipChange.ipc$dispatch("2068033719", new Object[]{this}) : this.d;
    }

    public void e(SeatBox seatBox) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-680629451")) {
            ipChange.ipc$dispatch("-680629451", new Object[]{this, seatBox});
            return;
        }
        r92.f("put SeatBox");
        this.d = seatBox;
        combineIfNeed();
    }

    public void f(IPriceManager iPriceManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2005101089")) {
            ipChange.ipc$dispatch("2005101089", new Object[]{this, iPriceManager});
            return;
        }
        this.h = true;
        this.e = iPriceManager;
        combineIfNeed();
    }

    public void g(CompressSeatStatus compressSeatStatus) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "715524077")) {
            ipChange.ipc$dispatch("715524077", new Object[]{this, compressSeatStatus});
            return;
        }
        r92.f("put CompressSeatStatus");
        if (compressSeatStatus != null) {
            compressSeatStatus.decompress();
        }
        this.f = compressSeatStatus;
        combineIfNeed();
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1207428765")) {
            ipChange.ipc$dispatch("1207428765", new Object[]{this});
            return;
        }
        this.i = true;
        this.a.quit();
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public boolean isPrepared() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1196546775") ? ((Boolean) ipChange.ipc$dispatch("-1196546775", new Object[]{this})).booleanValue() : this.b.size() > 0;
    }

    @Override // cn.damai.seat.listener.RegionSeatRequestChecker
    public boolean isRegionSeatRequestFinished(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "279883022") ? ((Boolean) ipChange.ipc$dispatch("279883022", new Object[]{this, str})).booleanValue() : this.b.contains(str);
    }

    @Override // cn.damai.seat.support.combine.ICombiner
    public void removeDynamic() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1077181571")) {
            ipChange.ipc$dispatch("1077181571", new Object[]{this});
            return;
        }
        this.c.removeCallbacksAndMessages(null);
        this.h = false;
        this.f = null;
        this.e = null;
        this.b.clear();
    }
}
