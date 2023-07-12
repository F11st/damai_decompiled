package cn.damai.seat.loader.request;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
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
/* loaded from: classes7.dex */
public class a extends cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a<ImageData, j82> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<WeakReference<C0068a>> b;
    private boolean c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.seat.loader.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C0068a {
        private static transient /* synthetic */ IpChange $ipChange;
        MtopBusiness a;
        Future b;
        q82 c;

        public C0068a(Future future) {
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
    /* loaded from: classes7.dex */
    public final class b implements OnDownLoadListener<Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;
        private RequestListener<ImageData, j82> a;
        private String b;
        private j82 c;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.seat.loader.request.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0069a implements RequestListener<SeatBox, j82.a> {
            private static transient /* synthetic */ IpChange $ipChange;

            /* compiled from: Taobao */
            /* renamed from: cn.damai.seat.loader.request.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0070a implements DMImageCreator.DMImageFailListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C0070a() {
                }

                @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
                public void onFail(DMImageCreator.d dVar) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-473511905")) {
                        ipChange.ipc$dispatch("-473511905", new Object[]{this, dVar});
                        return;
                    }
                    b bVar = b.this;
                    int i = dVar.a;
                    bVar.onFail(i, "降级图片加载失败：" + dVar.toString());
                }
            }

            /* compiled from: Taobao */
            /* renamed from: cn.damai.seat.loader.request.a$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class C0071b implements DMImageCreator.DMImageSuccListener {
                private static transient /* synthetic */ IpChange $ipChange;

                C0071b() {
                }

                @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
                public void onSuccess(DMImageCreator.e eVar) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "-845814156")) {
                        ipChange.ipc$dispatch("-845814156", new Object[]{this, eVar});
                    } else if (eVar != null && eVar.b != null) {
                        r92.f("------------------ VR 图降级成功！");
                        b.this.onSuccess(eVar.b);
                    } else {
                        b.this.onFail(-1, "降级图片错误");
                    }
                }
            }

            C0069a() {
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            /* renamed from: a */
            public void onSuccess(kn1<j82.a> kn1Var, SeatBox seatBox) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1786937405")) {
                    ipChange.ipc$dispatch("-1786937405", new Object[]{this, kn1Var, seatBox});
                    return;
                }
                String str = null;
                if (seatBox == null) {
                    b.this.onFail(-1, "VR降级，数据错误：SeatBox");
                    return;
                }
                List<StaticSeat3DVrInfo> list = seatBox.seat3DVrInfoMap.get(b.this.c.b());
                if (list != null && !list.isEmpty()) {
                    Iterator<StaticSeat3DVrInfo> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        StaticSeat3DVrInfo next = it.next();
                        if (next.getSid().longValue() == b.this.c.d()) {
                            str = next.getImg();
                            break;
                        }
                    }
                    r92.f("------------------ VR 图降级 图片地址：" + str);
                    DMImageCreator c = cn.damai.common.image.a.b().c(str);
                    int i = R$drawable.bg_border_corner_6_solid_f5f5f5;
                    c.i(i).c(i).n(new C0071b()).e(new C0070a()).f();
                    return;
                }
                b.this.onFail(-1, "VR降级，数据错误：StaticSeat3DVrInfo");
            }

            @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener
            public void onFail(kn1<j82.a> kn1Var, String str, String str2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1622741158")) {
                    ipChange.ipc$dispatch("-1622741158", new Object[]{this, kn1Var, str, str2});
                    return;
                }
                b.this.onFail(-1, str2);
                r92.f("----------------- VR 图降级请求失败， code：" + str + " msg：" + str2);
            }
        }

        b(String str, RequestListener<ImageData, j82> requestListener, j82 j82Var) {
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
                j82.a a = this.c.a();
                l82.r().h(m82.g(true, a.c(), a.b(), this.c.c()), new C0069a());
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
                if (!a.this.c) {
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
                this.a.onSuccess(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) a.this).a, new ImageData(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) a.this).a.d(), bitmap));
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
                requestListener.onFail(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) a.this).a, str, "场馆图加载失败");
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
                requestListener.onFail(((cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a) a.this).a, ImageData.CODE_NET_LIMIT, "场馆图加载失败");
            }
        }
    }

    public a(kn1<j82> kn1Var) {
        super(kn1Var);
        j82 j82Var;
        this.b = new ArrayList();
        kn1<E> kn1Var2 = this.a;
        if (kn1Var2 == 0 || (j82Var = (j82) kn1Var2.a()) == null) {
            return;
        }
        this.c = j82Var.f();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    protected void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2139928642")) {
            ipChange.ipc$dispatch("-2139928642", new Object[]{this});
        } else if (!cb2.d(this.b)) {
            for (WeakReference<C0068a> weakReference : this.b) {
                C0068a c0068a = weakReference.get();
                if (c0068a != null) {
                    c0068a.a();
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void d(@NonNull RequestListener<ImageData, j82> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1450199564")) {
            ipChange.ipc$dispatch("1450199564", new Object[]{this, requestListener});
            return;
        }
        String d = this.a.d();
        r92.f("------------------ VR 图片开始下载");
        this.b.add(new WeakReference<>(new C0068a(NetApi.a(mu0.a(), d, new b(d, requestListener, (j82) this.a.a())))));
    }
}
