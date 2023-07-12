package cn.damai.launcher.utils;

import android.text.TextUtils;
import com.alibaba.pictures.dolores.monitor.IMtopMonitor;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.b23;
import tb.bo2;
import tb.dc0;
import tb.m61;
import tb.uh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DoloresMonitorDelegate implements IMtopMonitor {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<String> a;

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void commitRequestError(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "861299532")) {
            ipChange.ipc$dispatch("861299532", new Object[]{this, str, str2, str3, str4});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "commitRequestError";
        }
        b23.c(str, "mtop", str4, TextUtils.isEmpty(str2) ? "-" : "DOLORES_REQUEST_ERROR", str3);
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopJsonEmpty(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1421921281")) {
            ipChange.ipc$dispatch("-1421921281", new Object[]{this, str, obj});
        } else if (uh2.b(this.a) == 0 || !this.a.contains(str)) {
            b23.c(str, "mtop", m61.e(obj), "DOLORES_DATA_EMPTY", "data为空");
        }
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopJsonFailure(String str, String str2, Object obj, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-700601994")) {
            ipChange.ipc$dispatch("-700601994", new Object[]{this, str, str2, obj, str3});
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("┋");
        stringBuffer.append(m61.e(obj));
        stringBuffer.append("┋apiVersion=");
        stringBuffer.append(str2);
        stringBuffer.append("┋traceId=");
        stringBuffer.append(str3);
        stringBuffer.append("┋");
        b23.c(str, "mtop", stringBuffer.toString(), "DOLORES_JSON_PARSE", "parse Json失败");
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopLoginCancel(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1793794031")) {
            ipChange.ipc$dispatch("1793794031", new Object[]{this, str, str2});
        }
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public <BizResponse> void mtopRequestAndResponse(String str, dc0<BizResponse> dc0Var, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-707209469")) {
            ipChange.ipc$dispatch("-707209469", new Object[]{this, str, dc0Var, str2});
        }
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopRequestTime(String str, String str2, bo2 bo2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1091459843")) {
            ipChange.ipc$dispatch("1091459843", new Object[]{this, str, str2, bo2Var});
        }
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopResponseError(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2064086189")) {
            ipChange.ipc$dispatch("-2064086189", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("┋");
        stringBuffer.append(m61.e(str5));
        stringBuffer.append("┋apiVersion=");
        stringBuffer.append(str2);
        stringBuffer.append("┋traceId=");
        stringBuffer.append(str6);
        stringBuffer.append("┋");
        b23.c(str, "mtop", stringBuffer.toString(), str3, str4);
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopResponseFailure(String str, String str2, String str3, String str4, String str5, String str6) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138679023")) {
            ipChange.ipc$dispatch("-138679023", new Object[]{this, str, str2, str3, str4, str5, str6});
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("┋");
        stringBuffer.append(m61.e(str5));
        stringBuffer.append("┋apiVersion=");
        stringBuffer.append(str2);
        stringBuffer.append("┋traceId=");
        stringBuffer.append(str6);
        stringBuffer.append("┋");
        b23.c(str, "mtop", stringBuffer.toString(), str3, str4);
    }

    @Override // com.alibaba.pictures.dolores.monitor.IMtopMonitor
    public void mtopResponseSuccess(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1978876134")) {
            ipChange.ipc$dispatch("-1978876134", new Object[]{this, str, str2, str3});
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("┋");
        stringBuffer.append("apiVersion=");
        stringBuffer.append(str2);
        stringBuffer.append("┋traceId=");
        stringBuffer.append(str3);
        stringBuffer.append("┋");
        b23.f(str, "mtop", "2000", "-", stringBuffer.toString());
    }
}
