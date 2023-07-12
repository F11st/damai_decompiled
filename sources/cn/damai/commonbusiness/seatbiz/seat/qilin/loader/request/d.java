package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.seat.SeatNew;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.seatdecoder.common.bean.StaticSeat;
import cn.damai.seatdecoder.common.bean.StaticStandSeat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import java.util.ArrayList;
import java.util.List;
import tb.a92;
import tb.e92;
import tb.jh1;
import tb.jq1;
import tb.kn1;
import tb.mu0;
import tb.qc0;
import tb.r92;
import tb.sc0;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class d extends cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a<SeatBox, e92> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final sc0 b;
    private int c;
    private e d;
    private jh1 e;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a extends com.taobao.downloader.request.a {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RequestListener a;

        a(RequestListener requestListener) {
            this.a = requestListener;
        }

        @Override // com.taobao.downloader.request.a, com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "411964496")) {
                ipChange.ipc$dispatch("411964496", new Object[]{this, str, Integer.valueOf(i), str2});
            } else {
                d.this.i(this.a);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x012c, code lost:
            tb.w92.e(r12, "-1", "pb解析结果为null", r2, r0);
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00e5 A[Catch: all -> 0x0185, TryCatch #0 {all -> 0x0185, blocks: (B:6:0x001c, B:8:0x00ac, B:10:0x00b1, B:13:0x00b8, B:15:0x00be, B:18:0x00ca, B:21:0x00e5, B:22:0x010c, B:19:0x00d1, B:24:0x012c, B:32:0x017d, B:25:0x0135, B:27:0x013d, B:31:0x0164, B:28:0x014d, B:30:0x0155), top: B:37:0x001c }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x010c A[Catch: all -> 0x0185, TryCatch #0 {all -> 0x0185, blocks: (B:6:0x001c, B:8:0x00ac, B:10:0x00b1, B:13:0x00b8, B:15:0x00be, B:18:0x00ca, B:21:0x00e5, B:22:0x010c, B:19:0x00d1, B:24:0x012c, B:32:0x017d, B:25:0x0135, B:27:0x013d, B:31:0x0164, B:28:0x014d, B:30:0x0155), top: B:37:0x001c }] */
        @Override // com.taobao.downloader.request.a, com.taobao.downloader.request.DownloadListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onDownloadFinish(java.lang.String r12, java.lang.String r13) {
            /*
                Method dump skipped, instructions count: 426
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.d.a.onDownloadFinish(java.lang.String, java.lang.String):void");
        }

        @Override // com.taobao.downloader.request.a, com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1421362324")) {
                ipChange.ipc$dispatch("-1421362324", new Object[]{this, Integer.valueOf(i), jq1Var, networkLimitCallback});
            } else {
                this.a.onFail(d.this.a, "onNetLimit", "");
            }
        }
    }

    static {
        sc0.e(mu0.a());
    }

    public d(kn1<e92> kn1Var) {
        super(kn1Var);
        this.e = new jh1();
        this.b = sc0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayMap<String, List<SeatNew>> h(List<StaticStandSeat> list, e92 e92Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "838607150")) {
            return (ArrayMap) ipChange.ipc$dispatch("838607150", new Object[]{this, list, e92Var});
        }
        if (list == null || e92Var == null) {
            return null;
        }
        int i = e92Var.d ? 12 : 0;
        ArrayMap<String, List<SeatNew>> arrayMap = new ArrayMap<>(256);
        for (int i2 = 0; i2 < list.size(); i2++) {
            StaticStandSeat staticStandSeat = list.get(i2);
            if (staticStandSeat != null && staticStandSeat.getSeats() != null) {
                ArrayList arrayList = new ArrayList();
                String valueOf = String.valueOf(staticStandSeat.getStand());
                List<StaticSeat> seats = staticStandSeat.getSeats();
                for (int i3 = 0; i3 < seats.size(); i3++) {
                    StaticSeat staticSeat = seats.get(i3);
                    SeatNew seatNew = new SeatNew();
                    seatNew.sid = staticSeat.getSid();
                    seatNew.x = (staticSeat.getX() / e92Var.c) + i;
                    seatNew.y = (staticSeat.getY() / e92Var.c) + i;
                    seatNew.priceLevel = staticSeat.getPlid();
                    seatNew.packageCombinedId = staticSeat.getGroupId();
                    seatNew.isPackaged = staticSeat.getGroupId() != 0;
                    seatNew.packagedPriceIndexId = staticSeat.getGroupPriceId();
                    seatNew.sn = staticSeat.getChint();
                    seatNew.rn = staticSeat.getRhint();
                    seatNew.fn = staticSeat.getFn();
                    seatNew.state = 8;
                    seatNew.kanTaiId = valueOf;
                    seatNew.angle = (float) staticSeat.getAngle();
                    seatNew.i = staticSeat.getI();
                    arrayList.add(seatNew);
                }
                arrayMap.put(valueOf, arrayList);
            }
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(RequestListener<SeatBox, e92> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-280528211")) {
            ipChange.ipc$dispatch("-280528211", new Object[]{this, requestListener});
            return;
        }
        ((e92) this.a.a()).c(true);
        e eVar = new e(this.a);
        this.d = eVar;
        eVar.d(requestListener);
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    protected void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-970427163")) {
            ipChange.ipc$dispatch("-970427163", new Object[]{this});
            return;
        }
        this.b.a(this.c);
        e eVar = this.d;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void d(@NonNull RequestListener<SeatBox, e92> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1502652467")) {
            ipChange.ipc$dispatch("1502652467", new Object[]{this, requestListener});
            return;
        }
        this.e.i();
        String d = this.a.d();
        r92.f("Load seat url = " + d);
        qc0 qc0Var = new qc0(d);
        a92.d(a92.a(a92.b));
        qc0Var.b.f = a92.a(a92.b).getAbsolutePath();
        qc0Var.a.get(0).d = "seat.gz";
        qc0Var.b.m = false;
        this.c = this.b.b(qc0Var, new a(requestListener));
    }
}
