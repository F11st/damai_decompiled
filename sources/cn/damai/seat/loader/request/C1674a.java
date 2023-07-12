package cn.damai.seat.loader.request;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a;
import cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.NetApi;
import cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener;
import cn.damai.seat.R$drawable;
import cn.damai.seatdecoder.seat_vr.bean.StaticSeat3DVrInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import tb.cb2;
import tb.h82;
import tb.j82;
import tb.kn1;
import tb.l82;
import tb.m82;
import tb.mu0;
import tb.q82;
import tb.r92;
import tb.u92;

/* compiled from: Taobao */
/* renamed from: cn.damai.seat.loader.request.a */
/* loaded from: classes7.dex */
public class C1674a extends AbstractC0818a<ImageData, j82> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<WeakReference<C1675a>> b;
    private boolean c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.loader.request.a$a */
    /* loaded from: classes16.dex */
    public static class C1675a {
        private static transient /* synthetic */ IpChange $ipChange;
        MtopBusiness a;
        Future b;
        q82 c;

        public C1675a(Future future) {
            this.b = future;
        }

        public void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "855807270")) {
                ipChange.ipc$dispatch("855807270", new Object[]{this});
                return;
            }
            try {
                MtopBusiness mtopBusiness = this.a;
                if (mtopBusiness != null && !mtopBusiness.isTaskCanceled()) {
                    this.a.cancelRequest();
                }
                Future future = this.b;
                if (future != null && !future.isCancelled()) {
                    this.b.cancel(true);
                }
                if (this.c != null) {
                    h82.r().b(this.c);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.loader.request.a$b */
    /* loaded from: classes7.dex */
    public final class C1676b implements OnDownLoadListener<Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;
        private RequestListener<ImageData, j82> a;
        private String b;
        private j82 c;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.seat.loader.request.a$b$a */
        /* loaded from: classes7.dex */
        public class C1677a implements RequestListener<SeatBox, j82.C9302a> {
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.seat.loader.request.a$b$a$a */
            /* loaded from: classes7.dex */
            public class C1678a implements DMImageCreator.DMImageFailListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C1678a() {
                }

                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public void onFail(DMImageCreator.C0501d c0501d) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-473511905")) {
                        ipChange.ipc$dispatch("-473511905", new Object[]{this, c0501d});
                        return;
                    }
                    C1676b c1676b = C1676b.this;
                    int i = c0501d.a;
                    c1676b.onFail(i, "降级图片加载失败：" + c0501d.toString());
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.seat.loader.request.a$b$a$b */
            /* loaded from: classes7.dex */
            public class C1679b implements DMImageCreator.DMImageSuccListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C1679b() {
                }

                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public void onSuccess(DMImageCreator.C0502e c0502e) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-845814156")) {
                        ipChange.ipc$dispatch("-845814156", new Object[]{this, c0502e});
                    } else if (c0502e != null && c0502e.b != null) {
                        r92.f("------------------ VR 图降级成功！");
                        C1676b.this.onSuccess(c0502e.b);
                    } else {
                        C1676b.this.onFail(-1, "降级图片错误");
                    }
                }
            }

            C1677a() {
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            /* renamed from: a */
            public void onSuccess(kn1<j82.C9302a> kn1Var, SeatBox seatBox) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1786937405")) {
                    ipChange.ipc$dispatch("-1786937405", new Object[]{this, kn1Var, seatBox});
                    return;
                }
                String str = null;
                if (seatBox == null) {
                    C1676b.this.onFail(-1, "VR降级，数据错误：SeatBox");
                    return;
                }
                List<StaticSeat3DVrInfo> list = seatBox.seat3DVrInfoMap.get(C1676b.this.c.b());
                if (list != null && !list.isEmpty()) {
                    Iterator<StaticSeat3DVrInfo> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        StaticSeat3DVrInfo next = it.next();
                        if (next.getSid().longValue() == C1676b.this.c.d()) {
                            str = next.getImg();
                            break;
                        }
                    }
                    r92.f("------------------ VR 图降级 图片地址：" + str);
                    DMImageCreator c = C0504a.b().c(str);
                    int i = R$drawable.bg_border_corner_6_solid_f5f5f5;
                    c.i(i).c(i).n(new C1679b()).e(new C1678a()).f();
                    return;
                }
                C1676b.this.onFail(-1, "VR降级，数据错误：StaticSeat3DVrInfo");
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            public void onFail(kn1<j82.C9302a> kn1Var, String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1622741158")) {
                    ipChange.ipc$dispatch("-1622741158", new Object[]{this, kn1Var, str, str2});
                    return;
                }
                C1676b.this.onFail(-1, str2);
                r92.f("----------------- VR 图降级请求失败， code：" + str + " msg：" + str2);
            }
        }

        C1676b(String str, RequestListener<ImageData, j82> requestListener, j82 j82Var) {
            this.a = requestListener;
            this.b = str;
            this.c = j82Var;
        }

        private void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1189893890")) {
                ipChange.ipc$dispatch("-1189893890", new Object[]{this});
                return;
            }
            j82 j82Var = this.c;
            if (j82Var != null && j82Var.a() != null) {
                j82.C9302a a = this.c.a();
                l82.r().h(m82.g(true, a.c(), a.b(), this.c.c()), new C1677a());
                return;
            }
            r92.f("------------------ VR 降级，请求参数错误");
            onFail(-1, "VR 降级，请求参数错误");
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        /* renamed from: b */
        public Bitmap callSubThread(byte[] bArr) throws Exception {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-675420895")) {
                return (Bitmap) ipChange.ipc$dispatch("-675420895", new Object[]{this, bArr});
            }
            if (bArr != null && bArr.length != 0) {
                r92.f("------------------ VR 图片下载成功");
                if (!C1674a.this.c) {
                    return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
                long currentTimeMillis = System.currentTimeMillis();
                Bitmap a = u92.b().a(bArr, this.c.e(), this.b);
                if (a != null) {
                    r92.f("------------------ vr image decrypt success: cost = " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    return a;
                }
                r92.f("------------------ VR 图片解密失败，请求降级数据");
                c();
                return null;
            }
            throw new RuntimeException("seat 3dvr image data empty");
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        /* renamed from: d */
        public void onSuccess(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-336685014")) {
                ipChange.ipc$dispatch("-336685014", new Object[]{this, bitmap});
            } else if (bitmap == null || this.a == null) {
            } else {
                this.a.onSuccess(((AbstractC0818a) C1674a.this).a, new ImageData(((AbstractC0818a) C1674a.this).a.d(), bitmap));
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        public void onFail(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1912975608")) {
                ipChange.ipc$dispatch("-1912975608", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            RequestListener<ImageData, j82> requestListener = this.a;
            if (requestListener != null) {
                requestListener.onFail(((AbstractC0818a) C1674a.this).a, str, "场馆图加载失败");
            }
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        public void onLimit() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "997895244")) {
                ipChange.ipc$dispatch("997895244", new Object[]{this});
                return;
            }
            RequestListener<ImageData, j82> requestListener = this.a;
            if (requestListener != null) {
                requestListener.onFail(((AbstractC0818a) C1674a.this).a, ImageData.CODE_NET_LIMIT, "场馆图加载失败");
            }
        }
    }

    public C1674a(kn1<j82> kn1Var) {
        super(kn1Var);
        j82 j82Var;
        this.b = new ArrayList();
        kn1<E> kn1Var2 = this.a;
        if (kn1Var2 == 0 || (j82Var = (j82) kn1Var2.a()) == null) {
            return;
        }
        this.c = j82Var.f();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a
    protected void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139928642")) {
            ipChange.ipc$dispatch("-2139928642", new Object[]{this});
        } else if (!cb2.d(this.b)) {
            for (WeakReference<C1675a> weakReference : this.b) {
                C1675a c1675a = weakReference.get();
                if (c1675a != null) {
                    c1675a.a();
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a
    public void d(@NonNull RequestListener<ImageData, j82> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450199564")) {
            ipChange.ipc$dispatch("1450199564", new Object[]{this, requestListener});
            return;
        }
        String d = this.a.d();
        r92.f("------------------ VR 图片开始下载");
        this.b.add(new WeakReference<>(new C1675a(NetApi.a(mu0.a(), d, new C1676b(d, requestListener, (j82) this.a.a())))));
    }
}
