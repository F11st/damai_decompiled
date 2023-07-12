package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.C9826vr;
import tb.jh1;
import tb.kn1;
import tb.l11;

/* compiled from: Taobao */
/* renamed from: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.b */
/* loaded from: classes.dex */
public class C0819b extends AbstractC0818a<ImageData, l11> {
    private static transient /* synthetic */ IpChange $ipChange;
    private C9826vr b;
    private jh1 c;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.b$a */
    /* loaded from: classes.dex */
    public class C0820a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RequestListener a;

        C0820a(RequestListener requestListener) {
            this.a = requestListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1364967833")) {
                ipChange.ipc$dispatch("1364967833", new Object[]{this, c0501d});
                return;
            }
            String str = "ImageLoader_download_fail";
            if (c0501d != null) {
                str = "ImageLoader_download_failresultCode=" + c0501d.a;
            }
            this.a.onFail(C0819b.this.a, str, "场馆图加载失败");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.b$b */
    /* loaded from: classes.dex */
    public class C0821b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ RequestListener b;

        C0821b(String str, RequestListener requestListener) {
            this.a = str;
            this.b = requestListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-511419282")) {
                ipChange.ipc$dispatch("-511419282", new Object[]{this, c0502e});
            } else if (c0502e != null && c0502e.a != null) {
                try {
                    C0819b.this.c.c(jh1.TYPE_JPG_DOWNLOAD, 0L);
                    this.b.onSuccess(C0819b.this.a, new ImageData(this.a, ((BitmapDrawable) c0502e.a).getBitmap()));
                } catch (Exception e) {
                    e.printStackTrace();
                    this.b.onFail(C0819b.this.a, e.getMessage(), "场馆图加载失败");
                }
            } else {
                this.b.onFail(C0819b.this.a, "ImageLoader_getDrawable_failed", "场馆图加载失败");
            }
        }
    }

    public C0819b(kn1<l11> kn1Var) {
        super(kn1Var);
        this.c = new jh1();
    }

    private String f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "79804509")) {
            return (String) ipChange.ipc$dispatch("79804509", new Object[]{this, str});
        }
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("x-oss-process", "image/quality,q_50").build().toString();
        } catch (Exception unused) {
            return str;
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a
    protected void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-774818427")) {
            ipChange.ipc$dispatch("-774818427", new Object[]{this});
            return;
        }
        C9826vr c9826vr = this.b;
        if (c9826vr != null) {
            c9826vr.cancel();
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a
    public void d(@NonNull RequestListener<ImageData, l11> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374275795")) {
            ipChange.ipc$dispatch("1374275795", new Object[]{this, requestListener});
            return;
        }
        this.c.i();
        String d = this.a.d();
        this.b = C0504a.b().c(f(d)).n(new C0821b(d, requestListener)).e(new C0820a(requestListener)).f();
    }
}
