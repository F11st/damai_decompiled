package com.alibaba.pictures.accs;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import java.nio.charset.Charset;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/alibaba/pictures/accs/MoiveAccsService;", "Lcom/taobao/accs/base/TaoBaseService;", "<init>", "()V", "accs_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class MoiveAccsService extends TaoBaseService {
    private static transient /* synthetic */ IpChange $ipChange;
    private final String a = "ACCS." + MoiveAccsService.class.getSimpleName();

    @Override // com.taobao.accs.base.TaoBaseService, com.taobao.accs.base.AccsDataListener
    public void onAntiBrush(boolean z, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "585875240")) {
            ipChange.ipc$dispatch("585875240", new Object[]{this, Boolean.valueOf(z), extraInfo});
            return;
        }
        String str = this.a;
        ALog.d(str, "anti brush result:" + z, new Object[0]);
        IAccsServiceDelegate d = PushAgent.INSTANCE.d();
        if (d != null) {
            d.onAntiBrush(z, extraInfo);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(@Nullable String str, int i, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "152061986")) {
            ipChange.ipc$dispatch("152061986", new Object[]{this, str, Integer.valueOf(i), extraInfo});
            return;
        }
        String str2 = this.a;
        ALog.d(str2, "onBind:serviceId=" + str + " errcode=" + i, new Object[0]);
        IAccsServiceDelegate d = PushAgent.INSTANCE.d();
        if (d != null) {
            d.onBind(str, i, extraInfo);
        }
    }

    @Override // com.taobao.accs.base.TaoBaseService, com.taobao.accs.base.AccsDataListener
    public void onConnected(@Nullable TaoBaseService.ConnectInfo connectInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1046140029")) {
            ipChange.ipc$dispatch("1046140029", new Object[]{this, connectInfo});
            return;
        }
        String str = this.a;
        StringBuilder sb = new StringBuilder();
        sb.append(connectInfo != null ? connectInfo.host : null);
        sb.append(" isInapp:");
        sb.append(connectInfo != null ? Boolean.valueOf(connectInfo.isInapp) : null);
        sb.append(" isCenterHost:");
        sb.append(connectInfo != null ? Boolean.valueOf(connectInfo.isCenterHost) : null);
        ALog.d(str, sb.toString(), new Object[0]);
        IAccsServiceDelegate d = PushAgent.INSTANCE.d();
        if (d != null) {
            d.onConnected(connectInfo);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable byte[] bArr, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        String str4;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863997489")) {
            ipChange.ipc$dispatch("-1863997489", new Object[]{this, str, str2, str3, bArr, extraInfo});
            return;
        }
        String str5 = this.a;
        ALog.d(str5, "onData serviceId=" + str + ",userId=" + str2 + ",dataId=" + str3 + ",msg=" + bArr, new Object[0]);
        if (bArr == null) {
            ALog.w(this.a, "onData msg==null return", new Object[0]);
            return;
        }
        try {
            Charset defaultCharset = Charset.defaultCharset();
            b41.h(defaultCharset, "Charset.defaultCharset()");
            String str6 = new String(bArr, defaultCharset);
            IAccsServiceDelegate d = PushAgent.INSTANCE.d();
            if (d != null) {
                str4 = ",msg=";
                try {
                    d.onDataReceive(str, str2, str3, str6, extraInfo);
                } catch (Exception e) {
                    e = e;
                    String str7 = this.a;
                    ALog.e(str7, "onData serviceId=" + str + ",userId=" + str2 + ",dataId=" + str3 + str4 + bArr + ',' + e.getMessage(), new Object[0]);
                }
            }
        } catch (Exception e2) {
            e = e2;
            str4 = ",msg=";
        }
    }

    @Override // com.taobao.accs.base.TaoBaseService, com.taobao.accs.base.AccsDataListener
    public void onDisconnected(@Nullable TaoBaseService.ConnectInfo connectInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1517099019")) {
            ipChange.ipc$dispatch("1517099019", new Object[]{this, connectInfo});
            return;
        }
        if (connectInfo != null) {
            String str = this.a;
            ALog.d(str, connectInfo.host + " isInapp:" + connectInfo.isInapp + " isCenterHost:" + connectInfo.isCenterHost + "errorCode:" + connectInfo.errorCode + " detail:" + connectInfo.errordetail, new Object[0]);
        }
        IAccsServiceDelegate d = PushAgent.INSTANCE.d();
        if (d != null) {
            d.onDisconnected(connectInfo);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(@Nullable String str, @Nullable String str2, int i, @Nullable byte[] bArr, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743794175")) {
            ipChange.ipc$dispatch("-743794175", new Object[]{this, str, str2, Integer.valueOf(i), bArr, extraInfo});
            return;
        }
        IAccsServiceDelegate d = PushAgent.INSTANCE.d();
        if (d != null) {
            d.onResponse(str, str2, Integer.valueOf(i), bArr, extraInfo);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(@Nullable String str, @Nullable String str2, int i, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1586838217")) {
            ipChange.ipc$dispatch("-1586838217", new Object[]{this, str, str2, Integer.valueOf(i), extraInfo});
            return;
        }
        String str3 = this.a;
        ALog.d(str3, "Service " + str + " onSendData:" + i + " dataId:" + str2, new Object[0]);
        IAccsServiceDelegate d = PushAgent.INSTANCE.d();
        if (d != null) {
            d.onUnbind(str, i, extraInfo);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(@Nullable String str, int i, @Nullable TaoBaseService.ExtraInfo extraInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1980283177")) {
            ipChange.ipc$dispatch("1980283177", new Object[]{this, str, Integer.valueOf(i), extraInfo});
            return;
        }
        String str2 = this.a;
        ALog.d(str2, "Service " + str + " onUnbind, errcode:" + i, new Object[0]);
        IAccsServiceDelegate d = PushAgent.INSTANCE.d();
        if (d != null) {
            d.onUnbind(str, i, extraInfo);
        }
    }
}
