package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataNew;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionDataQuYu;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.commonbusiness.seatbiz.seat.qilin.request.MtopBBCAreaInfoRequest;
import cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.NetApi;
import cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener;
import cn.damai.commonbusiness.seatbiz.view.model.BaseSVG;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.real.svg.decrypt.SvgDecrypt;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import tb.cb2;
import tb.cr;
import tb.i52;
import tb.j52;
import tb.jh1;
import tb.kn1;
import tb.l11;
import tb.mu0;
import tb.r92;
import tb.u01;
import tb.v92;
import tb.w92;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class SVGRequest extends AbstractC0818a<ImageData, l11> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<WeakReference<C0816a>> b;
    private jh1 c;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public final class DownLoadListener implements OnDownLoadListener<BaseSVG> {
        private static transient /* synthetic */ IpChange $ipChange;
        private RequestListener<ImageData, l11> a;
        private j52 b;
        private String c;

        DownLoadListener(String str, RequestListener<ImageData, l11> requestListener, j52 j52Var) {
            this.a = requestListener;
            this.b = j52Var;
            this.c = str;
        }

        private void c() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1024692492")) {
                ipChange.ipc$dispatch("-1024692492", new Object[]{this});
                return;
            }
            j52 j52Var = this.b;
            if (j52Var == null) {
                return;
            }
            SVGRequest.this.b.add(new WeakReference(new C0816a(new MtopBBCAreaInfoRequest(j52Var.g, j52Var.h, j52Var.d, cr.c()).request(new DMMtopResultRequestListener<RegionDataNew>(RegionDataNew.class) { // from class: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.SVGRequest.DownLoadListener.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-494349680")) {
                        ipChange2.ipc$dispatch("-494349680", new Object[]{this, str, str2});
                    } else {
                        DownLoadListener.this.a.onFail(SVGRequest.this.a, str, str2);
                    }
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopResultRequestListener
                public void onSuccess(RegionDataNew regionDataNew) {
                    RegionDataQuYu regionDataQuYu;
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1524272018")) {
                        ipChange2.ipc$dispatch("1524272018", new Object[]{this, regionDataNew});
                    } else if (regionDataNew == null || (regionDataQuYu = regionDataNew.seatQuYu) == null || TextUtils.isEmpty(regionDataQuYu.seatSvgImg)) {
                        DownLoadListener.this.a.onFail(SVGRequest.this.a, "", "seatSvgImg_url_null");
                    } else {
                        String str = regionDataNew.seatQuYu.seatSvgImg;
                        Application a = mu0.a();
                        DownLoadListener downLoadListener = DownLoadListener.this;
                        SVGRequest.this.b.add(new WeakReference(new C0816a(NetApi.a(a, str, new DownLoadListener(str, downLoadListener.a, null)))));
                    }
                }
            }))));
        }

        private void e(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1566514176")) {
                ipChange.ipc$dispatch("-1566514176", new Object[]{this, str, str2});
                return;
            }
            u01.C9751a a = u01.a(this.b.h);
            if (a != null) {
                String str3 = a.c ? v92.SEAT_SVG_PAY_FIRST_PREFIX : v92.SEAT_SVG_NORMAL_PREFIX;
                w92.d(str2, a.a + "", a.b + "", str3 + str);
            }
        }

        @NonNull
        private C0817b f(@NonNull String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-484537193")) {
                return (C0817b) ipChange.ipc$dispatch("-484537193", new Object[]{this, str});
            }
            C0817b c0817b = new C0817b();
            c0817b.a = false;
            if (this.b.b()) {
                try {
                    j52 j52Var = this.b;
                    String a = SvgDecrypt.a(j52Var.b, j52Var.f);
                    if (SvgDecrypt.d(a, this.b.c)) {
                        String b = SvgDecrypt.b(str, a);
                        if (SvgDecrypt.d(b, this.b.e)) {
                            c0817b.a = true;
                            c0817b.b = b;
                        } else {
                            c0817b.c = v92.SEAT_SVG_DECRYPT_MD5_DIFF_MSG;
                        }
                    } else {
                        c0817b.c = v92.SEAT_SVG_DECRYPT_KEY_MD5_DIFF_MSG;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    c0817b.a = false;
                    c0817b.c = e.getMessage();
                }
            } else {
                c0817b.c = this.b.a();
            }
            return c0817b;
        }

        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        /* renamed from: b */
        public BaseSVG callSubThread(byte[] bArr) throws Exception {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1723309313")) {
                return (BaseSVG) ipChange.ipc$dispatch("-1723309313", new Object[]{this, bArr});
            }
            String str = new String(bArr, "UTF-8");
            if (!TextUtils.isEmpty(str)) {
                SVGRequest.this.c.c(jh1.TYPE_SVG_DOWNLOAD, bArr.length);
                j52 j52Var = this.b;
                if (j52Var != null && j52Var.c()) {
                    C0817b f = f(str);
                    if (f.a) {
                        str = f.b;
                    } else {
                        e(f.c, this.c);
                        c();
                        str = null;
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                jh1 jh1Var = new jh1();
                jh1Var.i();
                long currentTimeMillis = System.currentTimeMillis();
                BaseSVG d = i52.d(str);
                jh1Var.c(jh1.TYPE_SVG_PARSE, str.getBytes().length);
                r92.f("SVG解析耗时" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                if (d == null || d.getDrawable() == null) {
                    throw new RuntimeException(ImageData.CODE_SVG_BUILD_FAIL);
                }
                return d;
            }
            throw new RuntimeException(ImageData.CODE_SVG_NONE_CONTENT);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        /* renamed from: d */
        public void onSuccess(BaseSVG baseSVG) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "724557500")) {
                ipChange.ipc$dispatch("724557500", new Object[]{this, baseSVG});
            } else if (baseSVG != null) {
                this.a.onSuccess(SVGRequest.this.a, new ImageData(SVGRequest.this.a.d(), baseSVG));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        public void onFail(int i, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1351717250")) {
                ipChange.ipc$dispatch("-1351717250", new Object[]{this, Integer.valueOf(i), str});
                return;
            }
            RequestListener<ImageData, l11> requestListener = this.a;
            Object obj = SVGRequest.this.a;
            requestListener.onFail(obj, i + "", str);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.support.download.OnDownLoadListener
        public void onLimit() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1986059586")) {
                ipChange.ipc$dispatch("1986059586", new Object[]{this});
            } else {
                this.a.onFail(SVGRequest.this.a, ImageData.CODE_NET_LIMIT, "场馆图加载失败");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.SVGRequest$b */
    /* loaded from: classes.dex */
    public static class C0817b {
        public boolean a;
        public String b;
        public String c;
    }

    public SVGRequest(kn1<l11> kn1Var) {
        super(kn1Var);
        this.b = new ArrayList();
        this.c = new jh1();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a
    protected void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-524108024")) {
            ipChange.ipc$dispatch("-524108024", new Object[]{this});
        } else if (!cb2.d(this.b)) {
            for (WeakReference<C0816a> weakReference : this.b) {
                C0816a c0816a = weakReference.get();
                if (c0816a != null) {
                    c0816a.a();
                }
            }
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a
    public void d(@NonNull RequestListener<ImageData, l11> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "294750038")) {
            ipChange.ipc$dispatch("294750038", new Object[]{this, requestListener});
            return;
        }
        this.c.i();
        String d = this.a.d();
        l11 l11Var = (l11) this.a.a();
        this.b.add(new WeakReference<>(new C0816a(NetApi.a(mu0.a(), d, new DownLoadListener(d, requestListener, l11Var.b() ? null : l11Var.a())))));
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.SVGRequest$a */
    /* loaded from: classes.dex */
    public static class C0816a {
        private static transient /* synthetic */ IpChange $ipChange;
        MtopBusiness a;
        Future b;

        public C0816a(MtopBusiness mtopBusiness) {
            this.a = mtopBusiness;
        }

        public void a() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1118739984")) {
                ipChange.ipc$dispatch("-1118739984", new Object[]{this});
                return;
            }
            try {
                MtopBusiness mtopBusiness = this.a;
                if (mtopBusiness != null && !mtopBusiness.isTaskCanceled()) {
                    this.a.cancelRequest();
                }
                Future future = this.b;
                if (future == null || future.isCancelled()) {
                    return;
                }
                this.b.cancel(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public C0816a(Future future) {
            this.b = future;
        }
    }
}
