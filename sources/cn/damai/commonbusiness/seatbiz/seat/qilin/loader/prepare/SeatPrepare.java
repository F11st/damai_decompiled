package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatExtInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ClickedPerform;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.OnAreaInfoListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.ImageExtra;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.option.Option;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopBBCAreaInfoRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.BasicInfoBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import tb.cr;
import tb.fb;
import tb.fe0;
import tb.fr1;
import tb.h82;
import tb.i12;
import tb.k92;
import tb.ke0;
import tb.l92;
import tb.ln1;
import tb.p11;
import tb.q82;
import tb.r11;
import tb.u01;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SeatPrepare implements OnAreaInfoListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int TYPE_COUNT_DOWN = 18;
    public static final int TYPE_RELOAD = 17;
    private final Activity b;
    private long c;
    private boolean f;
    private final long h;
    private final i12 a = new i12();
    private final LongSparseArray<MtopBusiness> d = new LongSparseArray<>();
    private final LongSparseArray<Long> e = new LongSparseArray<>();
    private boolean g = true;
    private boolean i = false;
    private ln1 j = new ln1();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnSeatPrepareListener {
        void onSeatPageOpened();

        void showLoading(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements OnAreaInfoListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ OnSeatPrepareListener a;
        final /* synthetic */ ClickedPerform b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;

        a(OnSeatPrepareListener onSeatPrepareListener, ClickedPerform clickedPerform, String str, int i) {
            this.a = onSeatPrepareListener;
            this.b = clickedPerform;
            this.c = str;
            this.d = i;
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.OnAreaInfoListener
        public void onFail(String str, long j, String str2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1598031437")) {
                ipChange.ipc$dispatch("1598031437", new Object[]{this, str, Long.valueOf(j), str2, str3});
                return;
            }
            this.a.showLoading(false);
            SeatPrepare.this.k(str3);
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.OnAreaInfoListener
        public void onSuccess(String str, long j, long j2, RegionData regionData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1983274115")) {
                ipChange.ipc$dispatch("1983274115", new Object[]{this, str, Long.valueOf(j), Long.valueOf(j2), regionData});
                return;
            }
            this.a.showLoading(false);
            this.a.onSeatPageOpened();
            SeatPrepare.this.j(j, j2, regionData);
            SeatPrepare.this.g(this.b, str, this.c, this.d, regionData);
        }
    }

    public SeatPrepare(@NonNull Activity activity, long j) {
        this.b = activity;
        this.h = j;
        this.f = OrangeConfigCenter.c().a("damai_seat_data_preload_switch", "damai_seat_data_preload", 1) == 1;
    }

    private synchronized MtopBusiness e(final String str, final long j, final long j2, final OnAreaInfoListener onAreaInfoListener) {
        MtopRegionDataListener mtopRegionDataListener;
        try {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1156198163")) {
                return (MtopBusiness) ipChange.ipc$dispatch("-1156198163", new Object[]{this, str, Long.valueOf(j), Long.valueOf(j2), onAreaInfoListener});
            }
            u01.c(this.h, j, false);
            MtopBBCAreaInfoRequest mtopBBCAreaInfoRequest = new MtopBBCAreaInfoRequest(str, j2, (String) null, cr.c());
            try {
                mtopRegionDataListener = new MtopRegionDataListener(this.h, str, j, j2, this.a) { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare.2
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener
                    public void onBizFail(String str2, String str3) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-244283923")) {
                            ipChange2.ipc$dispatch("-244283923", new Object[]{this, str2, str3});
                        } else {
                            onAreaInfoListener.onFail(str, j2, str2, str3);
                        }
                    }

                    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener
                    public void onRegionData(@NonNull RegionData regionData) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-277819597")) {
                            ipChange2.ipc$dispatch("-277819597", new Object[]{this, regionData});
                        } else {
                            onAreaInfoListener.onSuccess(str, j, j2, regionData);
                        }
                    }
                };
            } catch (Throwable th) {
                th = th;
            }
            try {
                mtopRegionDataListener.setRequest4Preload(this.i);
                return mtopBBCAreaInfoRequest.request(mtopRegionDataListener);
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(@NonNull ClickedPerform clickedPerform, String str, @Nullable String str2, int i, RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1692579324")) {
            ipChange.ipc$dispatch("1692579324", new Object[]{this, clickedPerform, str, str2, Integer.valueOf(i), regionData});
            return;
        }
        PerformBean performBean = clickedPerform.perform;
        int i2 = performBean.limitQuantity;
        int i3 = performBean.itemLimitPerOrder;
        long j = 0;
        PriceBean priceBean = clickedPerform.price;
        if (priceBean != null && performBean.containSkuId(priceBean.skuId)) {
            j = clickedPerform.price.skuId;
        }
        BasicInfoBean basicInfoBean = clickedPerform.basic;
        TbParams tbParams = new TbParams(str, basicInfoBean.projectId, basicInfoBean.itemId, performBean.performId, i, j, i2, i3, str2, clickedPerform.appNewUlTron(), clickedPerform.h5NewUlTron(), null, performBean.hasPromotion);
        boolean isJPG = regionData.isJPG();
        boolean isSmallVenue = regionData.isSmallVenue();
        if (isJPG) {
            fb.b(this.b, tbParams, isSmallVenue, 2000);
            return;
        }
        fb.a(this.b, tbParams, regionData);
        fb.c(this.b, tbParams, 2000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(long j, long j2, RegionData regionData) {
        RegionSeatExtInfo regionSeatExtInfo;
        RegionSeat3DVrInfo regionSeat3DVrInfo;
        q82 g;
        Option<ImageExtra>[] f;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1995228813")) {
            ipChange.ipc$dispatch("-1995228813", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), regionData});
            return;
        }
        if (!(regionData.isJPG() && regionData.isSmallVenue()) && (f = r11.f(regionData, true, j2)) != null) {
            p11.t().r(new fe0(), f);
            this.j.d(f);
        }
        l92 g2 = l92.g(this.h, j, regionData, true, j2);
        if (g2 != null) {
            k92.r().h(g2, new ke0());
            this.j.e(g2);
        }
        RegionSeatData regionSeatData = regionData.regionSeatData;
        if (regionSeatData == null || (regionSeatExtInfo = regionSeatData.seatExtInfo) == null || (regionSeat3DVrInfo = regionSeatExtInfo.seat3dvrInfo) == null || (g = q82.g(regionSeat3DVrInfo, false, j2)) == null) {
            return;
        }
        h82.r().h(g, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058338751")) {
            ipChange.ipc$dispatch("1058338751", new Object[]{this, str});
        } else if (this.b.isFinishing()) {
        } else {
            ToastUtil.a().e(this.b, str);
        }
    }

    public void d(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "879554233")) {
            ipChange.ipc$dispatch("879554233", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.g = z;
        }
    }

    public synchronized void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-860040226")) {
            ipChange.ipc$dispatch("-860040226", new Object[]{this});
            return;
        }
        try {
            int size = this.d.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    MtopBusiness valueAt = this.d.valueAt(i);
                    if (!valueAt.isTaskCanceled()) {
                        valueAt.cancelRequest();
                    }
                }
            }
            k92.r().p();
            h82.r().p();
            p11.t().p();
            this.a.d(this.c);
            p11.t().d(this.j.a());
            k92.r().d(this.j.b());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void h(@NonNull ClickedPerform clickedPerform, String str, @Nullable String str2, int i, OnSeatPrepareListener onSeatPrepareListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1597874518")) {
            ipChange.ipc$dispatch("-1597874518", new Object[]{this, clickedPerform, str, str2, Integer.valueOf(i), onSeatPrepareListener});
        } else if (!clickedPerform.isHasPerform() || onSeatPrepareListener == null) {
        } else {
            long j = clickedPerform.perform.performId;
            long a2 = fr1.a(j);
            RegionData a3 = this.a.a(a2);
            if (a2 == this.c && a3 != null) {
                onSeatPrepareListener.onSeatPageOpened();
                g(clickedPerform, str, str2, i, a3);
                return;
            }
            onSeatPrepareListener.showLoading(true);
            this.i = false;
            e(str, j, a2, new a(onSeatPrepareListener, clickedPerform, str2, i));
        }
    }

    public synchronized void i(int i, String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225883769")) {
            ipChange.ipc$dispatch("-1225883769", new Object[]{this, Integer.valueOf(i), str, Long.valueOf(j)});
        } else if (this.f) {
            long a2 = fr1.a(j);
            if (this.c != a2) {
                this.i = true;
                this.d.put(a2, e(str, j, a2, this));
            } else {
                if (i == 18) {
                    Long l = this.e.get(a2);
                    if (System.currentTimeMillis() - (l != null ? l.longValue() : 0L) < 300000) {
                        return;
                    }
                }
                if (this.d.get(a2) != null) {
                    return;
                }
                this.i = true;
                this.d.put(a2, e(str, j, a2, this));
            }
            this.c = a2;
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.OnAreaInfoListener
    public synchronized void onFail(String str, long j, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1023621114")) {
            ipChange.ipc$dispatch("1023621114", new Object[]{this, str, Long.valueOf(j), str2, str3});
        } else {
            this.d.remove(j);
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.OnAreaInfoListener
    public synchronized void onSuccess(String str, long j, long j2, RegionData regionData) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1449065392")) {
            ipChange.ipc$dispatch("1449065392", new Object[]{this, str, Long.valueOf(j), Long.valueOf(j2), regionData});
            return;
        }
        this.d.remove(j2);
        this.e.put(j2, Long.valueOf(System.currentTimeMillis()));
        if (this.g) {
            if (regionData != null && regionData.checkBaseValid()) {
                j(j, j2, regionData);
            }
        }
    }
}
