package cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request;

import androidx.annotation.NonNull;
import cn.damai.commonbusiness.seatbiz.seat.qilin.bean.SeatBox;
import cn.damai.commonbusiness.seatbiz.seat.qilin.loader.listener.RequestListener;
import cn.damai.seatdecoder.seat_vr.bean.Seat3DVrDataDecodeReulst;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.downloader.request.DownloadListener;
import com.youku.android.utils.OPRUtils;
import java.io.File;
import tb.a92;
import tb.cr;
import tb.i82;
import tb.jq1;
import tb.kn1;
import tb.mu0;
import tb.qc0;
import tb.r92;
import tb.sc0;
import tb.w92;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class c extends cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a<SeatBox, i82> {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String d = "damai-vr" + File.separator + "data";
    private final sc0 b;
    private int c;

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
            if (AndroidInstantRuntime.support(ipChange, "2021025453")) {
                ipChange.ipc$dispatch("2021025453", new Object[]{this, str, Integer.valueOf(i), str2});
                return;
            }
            RequestListener requestListener = this.a;
            Object obj = c.this.a;
            requestListener.onFail(obj, i + "", str2);
        }

        @Override // com.taobao.downloader.request.a, com.taobao.downloader.request.DownloadListener
        public void onDownloadFinish(String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1978351885")) {
                ipChange.ipc$dispatch("1978351885", new Object[]{this, str, str2});
                return;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                i82 i82Var = (i82) c.this.a.a();
                Seat3DVrDataDecodeReulst b = cr.b(i82Var.a(), str2);
                if (b != null && b.getResultCode() == 1) {
                    if (cr.g(b.getResult(), i82Var.b())) {
                        r92.f("VR PB 数据解析成功 ！！");
                        SeatBox seatBox = new SeatBox();
                        seatBox.seat3DVrInfoMap = b.getResult();
                        this.a.onSuccess(c.this.a, seatBox);
                    } else {
                        r92.f("VR PB 数据校验失败");
                        w92.f(str, String.valueOf(b.getResultCode()), b.getMessage(), "-1", "-1");
                    }
                    r92.f("TB解析座位VR数据耗时" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                    return;
                }
                r92.f("VR PB 数据解析失败，降级去加载ZIP数据： " + b.getResultCode());
            } catch (Exception e) {
                e.printStackTrace();
                this.a.onFail(c.this.a, OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM, e.getMessage());
            }
        }

        @Override // com.taobao.downloader.request.a, com.taobao.downloader.request.DownloadListener
        public void onNetworkLimit(int i, jq1 jq1Var, DownloadListener.NetworkLimitCallback networkLimitCallback) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-992623825")) {
                ipChange.ipc$dispatch("-992623825", new Object[]{this, Integer.valueOf(i), jq1Var, networkLimitCallback});
            } else {
                this.a.onFail(c.this.a, "onNetLimit", "");
            }
        }
    }

    static {
        sc0.e(mu0.a());
    }

    public c(kn1<i82> kn1Var) {
        super(kn1Var);
        StringBuilder sb = new StringBuilder();
        sb.append(a92.b());
        String str = File.separator;
        sb.append(str);
        sb.append(d);
        sb.append(str);
        this.b = sc0.c();
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    protected void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1707853480")) {
            ipChange.ipc$dispatch("1707853480", new Object[]{this});
        } else {
            this.b.a(this.c);
        }
    }

    @Override // cn.damai.commonbusiness.seatbiz.seat.qilin.loader.request.a
    public void d(@NonNull RequestListener<SeatBox, i82> requestListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1885073142")) {
            ipChange.ipc$dispatch("1885073142", new Object[]{this, requestListener});
            return;
        }
        String d2 = this.a.d();
        r92.f("Load seat vr url = " + d2);
        qc0 qc0Var = new qc0(d2);
        a92.d(a92.a("damai-vr"));
        qc0Var.b.f = a92.a("damai-vr").getAbsolutePath();
        qc0Var.a.get(0).d = "seat_vr.zip";
        qc0Var.b.m = false;
        this.c = this.b.b(qc0Var, new a(requestListener));
    }
}
