package cn.damai.seat.loader.request;

import androidx.annotation.NonNull;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataQuYu;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeat3DVrInfo;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionSeatExtInfo;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopBBCAreaInfoRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.orange.OConstant;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tb.cb2;
import tb.cr;
import tb.h82;
import tb.i82;
import tb.j82;
import tb.kn1;
import tb.q82;
import tb.r92;
import tb.u92;
import tb.xr;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class Seat3DVrImageDowngradeRequest extends AbstractC0818a<SeatBox, j82.C9302a> {
    private static transient /* synthetic */ IpChange $ipChange;
    private j82.C9302a b;
    private List<WeakReference<C1673b>> c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.loader.request.Seat3DVrImageDowngradeRequest$a */
    /* loaded from: classes7.dex */
    public class C1672a implements RequestListener<SeatBox, i82> {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RequestListener a;

        C1672a(RequestListener requestListener) {
            this.a = requestListener;
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
        /* renamed from: a */
        public void onSuccess(kn1<i82> kn1Var, SeatBox seatBox) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-968143879")) {
                ipChange.ipc$dispatch("-968143879", new Object[]{this, kn1Var, seatBox});
            } else if (seatBox == null) {
                this.a.onFail(((AbstractC0818a) Seat3DVrImageDowngradeRequest.this).a, OConstant.CODE_POINT_EXP_LOAD_CACHE, "VR 图降级失败， ");
            } else {
                xr.c("seat_vr_data_bind", seatBox);
                r92.f("----------------- VR 降级，静态数据请求成功！");
                this.a.onSuccess(((AbstractC0818a) Seat3DVrImageDowngradeRequest.this).a, seatBox);
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
        public void onFail(kn1<i82> kn1Var, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1473348208")) {
                ipChange.ipc$dispatch("-1473348208", new Object[]{this, kn1Var, str, str2});
                return;
            }
            this.a.onFail(((AbstractC0818a) Seat3DVrImageDowngradeRequest.this).a, str, str2);
            r92.f("-----------------降级请求： Seat VRInfo Loader fail code" + str + " msg" + str2);
        }
    }

    public Seat3DVrImageDowngradeRequest(kn1<j82.C9302a> kn1Var) {
        super(kn1Var);
        this.c = new ArrayList();
        if (kn1Var != null) {
            this.b = kn1Var.a();
        }
    }

    private void k(final RequestListener<SeatBox, j82.C9302a> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-642485482")) {
            ipChange.ipc$dispatch("-642485482", new Object[]{this, requestListener});
            return;
        }
        j82.C9302a c9302a = this.b;
        if (c9302a == null) {
            r92.f("------------------ VR 降级，降级参数错误");
            requestListener.onFail(this.a, OConstant.CODE_POINT_EXP_BIND_SERVICE, "VR 降级，降级参数错误");
            return;
        }
        this.c.add(new WeakReference<>(new C1673b(new MtopBBCAreaInfoRequest(c9302a.b(), String.valueOf(this.b.c()), null, this.b.a(), cr.c()).request(new DMMtopResultRequestListener<RegionDataNew>(RegionDataNew.class) { // from class: cn.damai.seat.loader.request.Seat3DVrImageDowngradeRequest.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onFail(String str, String str2) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "301271759")) {
                    ipChange2.ipc$dispatch("301271759", new Object[]{this, str, str2});
                    return;
                }
                r92.f("------------------ VR 图降级数据请求失败：BBC—AREA-INFO");
                requestListener.onFail(((AbstractC0818a) Seat3DVrImageDowngradeRequest.this).a, OConstant.CODE_POINT_EXP_BIND_SERVICE, str2);
            }

            @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
            public void onSuccess(RegionDataNew regionDataNew) {
                RegionDataQuYu regionDataQuYu;
                RegionSeatExtInfo regionSeatExtInfo;
                RegionSeat3DVrInfo regionSeat3DVrInfo;
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1184472209")) {
                    ipChange2.ipc$dispatch("1184472209", new Object[]{this, regionDataNew});
                } else if (regionDataNew == null || (regionDataQuYu = regionDataNew.seatQuYu) == null || (regionSeatExtInfo = regionDataQuYu.seatExtInfo) == null || (regionSeat3DVrInfo = regionSeatExtInfo.seat3dvrInfo) == null) {
                    requestListener.onFail(((AbstractC0818a) Seat3DVrImageDowngradeRequest.this).a, OConstant.CODE_POINT_EXP_BIND_SERVICE, "seat3dVrImg downgrade data is null");
                    r92.f("------------------ VR 图降级数据为空：BBC—AREA-INFO");
                } else {
                    Seat3DVrImageDowngradeRequest.this.l(regionSeat3DVrInfo, requestListener);
                    u92.b().c(regionDataNew.seatQuYu.seatExtInfo.seat3dvrInfo.imgDecrypt);
                }
            }
        }))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(RegionSeat3DVrInfo regionSeat3DVrInfo, RequestListener<SeatBox, j82.C9302a> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1487361966")) {
            ipChange.ipc$dispatch("-1487361966", new Object[]{this, regionSeat3DVrInfo, requestListener});
            return;
        }
        r92.f("------------------ VR 图降级：请求静态数据:" + regionSeat3DVrInfo.seat3dvrEncodeUri);
        q82 g = q82.g(regionSeat3DVrInfo, true, this.b.c());
        this.c.add(new WeakReference<>(new C1673b(g)));
        h82.r().h(g, new C1672a(requestListener));
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a
    protected void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "574689731")) {
            ipChange.ipc$dispatch("574689731", new Object[]{this});
        } else if (!cb2.d(this.c)) {
            for (WeakReference<C1673b> weakReference : this.c) {
                C1673b c1673b = weakReference.get();
                if (c1673b != null) {
                    c1673b.a();
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a
    public void d(@NonNull RequestListener<SeatBox, j82.C9302a> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "985634577")) {
            ipChange.ipc$dispatch("985634577", new Object[]{this, requestListener});
            return;
        }
        r92.f("------------------ VR 降级请求流程。。。。");
        k(requestListener);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.loader.request.Seat3DVrImageDowngradeRequest$b */
    /* loaded from: classes16.dex */
    public static class C1673b {
        private static transient /* synthetic */ IpChange $ipChange;
        MtopBusiness a;
        q82 b;

        public C1673b(MtopBusiness mtopBusiness) {
            this.a = mtopBusiness;
        }

        public void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1736052245")) {
                ipChange.ipc$dispatch("-1736052245", new Object[]{this});
                return;
            }
            try {
                MtopBusiness mtopBusiness = this.a;
                if (mtopBusiness != null && !mtopBusiness.isTaskCanceled()) {
                    this.a.cancelRequest();
                }
                if (this.b != null) {
                    h82.r().b(this.b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public C1673b(q82 q82Var) {
            this.b = q82Var;
        }
    }
}
