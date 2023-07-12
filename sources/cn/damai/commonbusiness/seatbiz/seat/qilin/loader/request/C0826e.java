package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.C6703a;
import com.taobao.downloader.request.DownloadListener;
import com.youku.android.utils.OPRUtils;
import java.io.File;
import java.util.ArrayList;
import tb.a92;
import tb.e92;
import tb.jh1;
import tb.jq1;
import tb.kn1;
import tb.mu0;
import tb.p23;
import tb.qc0;
import tb.r23;
import tb.r92;
import tb.sc0;

/* compiled from: Taobao */
/* renamed from: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.e */
/* loaded from: classes.dex */
public class C0826e extends AbstractC0818a<SeatBox, e92> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final sc0 b;
    private int c;
    private jh1 d;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.e$a */
    /* loaded from: classes.dex */
    public class C0827a extends C6703a {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ RequestListener a;

        C0827a(RequestListener requestListener) {
            this.a = requestListener;
        }

        @Override // com.taobao.downloader.request.C6703a, com.taobao.downloader.request.DownloadListener
        public void onDownloadError(String str, int i, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "510943777")) {
                ipChange.ipc$dispatch("510943777", new Object[]{this, str, Integer.valueOf(i), str2});
                return;
            }
            RequestListener requestListener = this.a;
            Object obj = C0826e.this.a;
            requestListener.onFail(obj, i + "", str2);
        }

        @Override // com.taobao.downloader.request.C6703a, com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "468270209")) {
                ipChange.ipc$dispatch("468270209", new Object[]{this, str, str2});
                return;
            }
            try {
                C0826e.this.d.c(jh1.TYPE_SEAT_ZIP_DOWNLOAD, 0L);
                long currentTimeMillis = System.currentTimeMillis();
                jh1 jh1Var = new jh1(true);
                SeatBox seatBox = new SeatBox();
                seatBox.seatNewMap = new ArrayMap<>(256);
                a92.a("damai" + File.separator + "1111");
                r23.a(str2, a92.c);
                File[] listFiles = new File(a92.c).listFiles();
                e92 e92Var = (e92) C0826e.this.a.a();
                if (listFiles != null) {
                    for (int i = 0; i < listFiles.length; i++) {
                        String[] split = listFiles[i].getPath().split("\\/");
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(new p23(e92Var.d).d(a92.c(listFiles[i]), e92Var.c, split[split.length - 1]).seatNewList);
                        seatBox.seatNewMap.put(listFiles[i].getName(), arrayList);
                    }
                }
                seatBox.collectSeatDataInner();
                jh1Var.c(jh1.TYPE_SEAT_ZIP_PARSE, 0L);
                r92.f("TB解析座位耗时" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                this.a.onSuccess(C0826e.this.a, seatBox);
            } catch (Exception e) {
                e.printStackTrace();
                this.a.onFail(C0826e.this.a, OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM, e.getMessage());
            }
        }

        @Override // com.taobao.downloader.request.C6703a, com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2124386245")) {
                ipChange.ipc$dispatch("-2124386245", new Object[]{this, Integer.valueOf(i), jq1Var, networkLimitCallback});
            } else {
                this.a.onFail(C0826e.this.a, "onNetLimit", "");
            }
        }
    }

    static {
        sc0.e(mu0.a());
    }

    public C0826e(kn1<e92> kn1Var) {
        super(kn1Var);
        this.d = new jh1();
        this.b = sc0.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a
    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112171956")) {
            ipChange.ipc$dispatch("112171956", new Object[]{this});
        } else {
            this.b.a(this.c);
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.AbstractC0818a
    public void d(@NonNull RequestListener<SeatBox, e92> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "570529794")) {
            ipChange.ipc$dispatch("570529794", new Object[]{this, requestListener});
            return;
        }
        this.d.i();
        String d = this.a.d();
        r92.f("Load seat url = " + d);
        qc0 qc0Var = new qc0(d);
        a92.d(a92.a(a92.b));
        qc0Var.b.f = a92.a(a92.b).getAbsolutePath();
        qc0Var.a.get(0).d = "1111.zip";
        qc0Var.b.m = false;
        this.c = this.b.b(qc0Var, new C0827a(requestListener));
    }
}
