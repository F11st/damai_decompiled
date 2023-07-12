package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.ImageData;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.jh1;
import tb.kn1;
import tb.l11;
import tb.vr;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class b extends cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a<ImageData, l11> {
    private static transient /* synthetic */ IpChange $ipChange;
    private vr b;
    private jh1 c;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RequestListener a;

        a(RequestListener requestListener) {
            this.a = requestListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1364967833")) {
                ipChange.ipc$dispatch("1364967833", new Object[]{this, dVar});
                return;
            }
            String str = "ImageLoader_download_fail";
            if (dVar != null) {
                str = "ImageLoader_download_failresultCode=" + dVar.a;
            }
            this.a.onFail(b.this.a, str, "场馆图加载失败");
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0038b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ RequestListener b;

        C0038b(String str, RequestListener requestListener) {
            this.a = str;
            this.b = requestListener;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-511419282")) {
                ipChange.ipc$dispatch("-511419282", new Object[]{this, eVar});
            } else if (eVar != null && eVar.a != null) {
                try {
                    b.this.c.c(jh1.TYPE_JPG_DOWNLOAD, 0L);
                    this.b.onSuccess(b.this.a, new ImageData(this.a, ((BitmapDrawable) eVar.a).getBitmap()));
                } catch (Exception e) {
                    e.printStackTrace();
                    this.b.onFail(b.this.a, e.getMessage(), "场馆图加载失败");
                }
            } else {
                this.b.onFail(b.this.a, "ImageLoader_getDrawable_failed", "场馆图加载失败");
            }
        }
    }

    public b(kn1<l11> kn1Var) {
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

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    protected void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-774818427")) {
            ipChange.ipc$dispatch("-774818427", new Object[]{this});
            return;
        }
        vr vrVar = this.b;
        if (vrVar != null) {
            vrVar.cancel();
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void d(@NonNull RequestListener<ImageData, l11> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1374275795")) {
            ipChange.ipc$dispatch("1374275795", new Object[]{this, requestListener});
            return;
        }
        this.c.i();
        String d = this.a.d();
        this.b = cn.damai.common.image.a.b().c(f(d)).n(new C0038b(d, requestListener)).e(new a(requestListener)).f();
    }
}
