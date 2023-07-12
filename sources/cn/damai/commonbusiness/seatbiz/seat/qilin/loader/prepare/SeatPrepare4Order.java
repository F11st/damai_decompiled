package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.seatbiz.orderdetail.bean.OrderDetailPriceInfo;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.TbParams;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.orderlist.OrderFirstPayInfoResult;
import cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopBBCAreaInfoRequest;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.OrderFirstPayInfoRequest;
import cn.damai.commonbusiness.seatbiz.sku.qilin.elapsed.bean.SkuPerform;
import cn.damai.commonbusiness.seatbiz.utils.RequestHolder;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.cr;
import tb.fb;
import tb.fr1;
import tb.hv0;
import tb.i12;
import tb.k92;
import tb.l92;
import tb.p11;
import tb.r11;
import tb.r92;
import tb.u01;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SeatPrepare4Order {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private final RequestHolder b = new RequestHolder();
    private i12 c = new i12();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnLoadListener {
        void onLoadStateChanged(boolean z);

        void onSeatActivityOpen(long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnPrepareListener {
        void onFail(String str, String str2);

        void onSuccess(RegionData regionData);

        void onSuccess(List<OrderDetailPriceInfo> list);

        void preloadVenueImage();

        void tryOpenSeatActivity();
    }

    public SeatPrepare4Order(Activity activity, int i) {
        this.a = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972332896")) {
            return ((Boolean) ipChange.ipc$dispatch("-1972332896", new Object[]{this})).booleanValue();
        }
        Activity activity = this.a;
        return (activity == null || activity.isFinishing()) ? false : true;
    }

    private void e(long j, final OnPrepareListener onPrepareListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1141210262")) {
            ipChange.ipc$dispatch("1141210262", new Object[]{this, Long.valueOf(j), onPrepareListener});
            return;
        }
        OrderFirstPayInfoRequest orderFirstPayInfoRequest = new OrderFirstPayInfoRequest();
        orderFirstPayInfoRequest.orderId = j;
        this.b.a(orderFirstPayInfoRequest.request(new DMMtopRequestListener<OrderFirstPayInfoResult>(OrderFirstPayInfoResult.class) { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1612920944")) {
                    ipChange2.ipc$dispatch("1612920944", new Object[]{this, str, str2});
                } else {
                    onPrepareListener.onFail(str, str2);
                }
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
            public void onSuccess(OrderFirstPayInfoResult orderFirstPayInfoResult) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-456644689")) {
                    ipChange2.ipc$dispatch("-456644689", new Object[]{this, orderFirstPayInfoResult});
                } else if (orderFirstPayInfoResult != null) {
                    onPrepareListener.onSuccess(orderFirstPayInfoResult.priceInfoList);
                } else {
                    onPrepareListener.onFail("", "麦麦开小差了，请稍后重试哦");
                }
            }
        }));
    }

    private void f(long j, long j2, String str, final OnPrepareListener onPrepareListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-608181942")) {
            ipChange.ipc$dispatch("-608181942", new Object[]{this, Long.valueOf(j), Long.valueOf(j2), str, onPrepareListener});
            return;
        }
        u01.d(j + "", j2);
        long a2 = fr1.a(j2);
        this.b.a(new MtopBBCAreaInfoRequest(str, a2, (String) null, cr.c()).request(new MtopRegionDataListener(j, str, j2, a2, this.c) { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener
            public void onBizFail(String str2, String str3) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1201733036")) {
                    ipChange2.ipc$dispatch("-1201733036", new Object[]{this, str2, str3});
                } else {
                    onPrepareListener.onFail(str2, str3);
                }
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.listener.net.MtopRegionDataListener
            public void onRegionData(@NonNull RegionData regionData) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "914391404")) {
                    ipChange2.ipc$dispatch("914391404", new Object[]{this, regionData});
                } else {
                    onPrepareListener.onSuccess(regionData);
                }
            }
        }));
    }

    private long i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1773225262")) {
            return ((Long) ipChange.ipc$dispatch("-1773225262", new Object[]{this, str})).longValue();
        }
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "572136763")) {
            ipChange.ipc$dispatch("572136763", new Object[]{this});
        } else {
            this.b.c();
        }
    }

    public void g(String str, String str2, String str3, String str4, String str5, String str6, OnLoadListener onLoadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-230042999")) {
            ipChange.ipc$dispatch("-230042999", new Object[]{this, str, str2, str3, str4, str5, str6, onLoadListener});
        } else {
            h(str, str2, str3, str4, str5, str6, null, onLoadListener);
        }
    }

    public void h(String str, String str2, String str3, String str4, String str5, String str6, List<OrderDetailPriceInfo> list, OnLoadListener onLoadListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "169247226")) {
            ipChange.ipc$dispatch("169247226", new Object[]{this, str, str2, str3, str4, str5, str6, list, onLoadListener});
            return;
        }
        long i = i(str3);
        long i2 = i(str4);
        long i3 = i(str5);
        a aVar = new a(str, str2, i, i2, i3, str6, onLoadListener);
        aVar.onLoadStateChanged(true);
        if (!cb2.d(list)) {
            aVar.h = list;
            aVar.k = 1;
        } else {
            e(i, aVar);
        }
        f(i2, i3, str6, aVar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public final class a implements OnLoadListener, OnPrepareListener {
        private static transient /* synthetic */ IpChange $ipChange = null;
        public static final int TOTAL_API_COUNT = 2;
        private String a;
        private String b;
        private long c;
        private long d;
        private long e;
        private String f;
        private long g;
        private List<OrderDetailPriceInfo> h;
        private RegionData i;
        private OnLoadListener j;
        private int k = 0;

        a(String str, String str2, long j, long j2, long j3, String str3, OnLoadListener onLoadListener) {
            this.a = str;
            this.b = str2;
            this.c = j;
            this.d = j2;
            this.e = j3;
            this.f = str3;
            this.g = fr1.a(j3);
            this.j = onLoadListener;
        }

        private void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1328967323")) {
                ipChange.ipc$dispatch("1328967323", new Object[]{this});
            } else if (this.k >= 2) {
                onLoadStateChanged(false);
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnPrepareListener
        public void onFail(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-470806039")) {
                ipChange.ipc$dispatch("-470806039", new Object[]{this, str, str2});
                return;
            }
            r92.f("code=" + str + " msg=" + str2);
            this.k = this.k + 1;
            c();
            if (!SeatPrepare4Order.this.d() || TextUtils.isEmpty(str2)) {
                return;
            }
            ToastUtil.a().e(SeatPrepare4Order.this.a, str2);
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnLoadListener
        public void onLoadStateChanged(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "341795690")) {
                ipChange.ipc$dispatch("341795690", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            OnLoadListener onLoadListener = this.j;
            if (onLoadListener != null) {
                onLoadListener.onLoadStateChanged(z);
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnLoadListener
        public void onSeatActivityOpen(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1522394255")) {
                ipChange.ipc$dispatch("1522394255", new Object[]{this, Long.valueOf(j)});
                return;
            }
            OnLoadListener onLoadListener = this.j;
            if (onLoadListener != null) {
                onLoadListener.onSeatActivityOpen(j);
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnPrepareListener
        public void onSuccess(RegionData regionData) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2072721723")) {
                ipChange.ipc$dispatch("-2072721723", new Object[]{this, regionData});
                return;
            }
            r92.f("先付 areaInfo success");
            this.i = regionData;
            this.k++;
            c();
            preloadVenueImage();
            tryOpenSeatActivity();
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnPrepareListener
        public void preloadVenueImage() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "11356547")) {
                ipChange.ipc$dispatch("11356547", new Object[]{this});
                return;
            }
            p11.t().r(null, r11.f(this.i, false, this.g));
            l92 g = l92.g(this.d, this.e, this.i, false, this.g);
            if (g != null) {
                k92.r().h(g, null);
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnPrepareListener
        public void tryOpenSeatActivity() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1724427743")) {
                ipChange.ipc$dispatch("1724427743", new Object[]{this});
            } else if (!SeatPrepare4Order.this.d() || this.i == null || cb2.d(this.h)) {
            } else {
                onSeatActivityOpen(this.c);
                SkuPerform skuPerform = new SkuPerform();
                skuPerform.performId = this.e;
                skuPerform.itemTitle = this.a;
                skuPerform.performName = this.b;
                fr1.d().c(this.d).e(skuPerform);
                this.i.performanceMaxSum = hv0.a(this.h);
                this.i.ri.cityId = r92.h(this.f, 0L);
                this.i.ri.performanceId = fr1.a(this.e);
                String str = this.f;
                String str2 = this.h.get(0).projectId;
                long j = this.d;
                long j2 = this.e;
                fb.c(SeatPrepare4Order.this.a, new TbParams(str, str2, j, j2, this.c + "", this.h), 2000);
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.prepare.SeatPrepare4Order.OnPrepareListener
        public void onSuccess(List<OrderDetailPriceInfo> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1953431813")) {
                ipChange.ipc$dispatch("1953431813", new Object[]{this, list});
                return;
            }
            r92.f("先付 priceInfo success");
            this.h = list;
            this.k++;
            c();
            tryOpenSeatActivity();
        }
    }
}
