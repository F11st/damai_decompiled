package com.youku.live.dsl.log;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.kk2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class IRemoteLogImp implements IRemoteLog {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.youku.live.dsl.log.ILog
    public void d(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "426547802")) {
            ipChange.ipc$dispatch("426547802", new Object[]{this, str, str2});
        } else {
            kk2.a().b(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1888127801")) {
            ipChange.ipc$dispatch("1888127801", new Object[]{this, str, str2});
        } else {
            kk2.a().d(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void e(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-834087332")) {
            ipChange.ipc$dispatch("-834087332", new Object[]{this, str, str2, th});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-855486795")) {
            ipChange.ipc$dispatch("-855486795", new Object[]{this, str, str2});
        } else {
            kk2.a().f(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void i(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1205905312")) {
            ipChange.ipc$dispatch("-1205905312", new Object[]{this, str, str2, th});
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void v(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "965184008")) {
            ipChange.ipc$dispatch("965184008", new Object[]{this, str, str2});
        } else {
            kk2.a().h(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void w(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1868203289")) {
            ipChange.ipc$dispatch("-1868203289", new Object[]{this, str, str2});
        } else {
            kk2.a().j(str, str2);
        }
    }

    @Override // com.youku.live.dsl.log.ILog
    public void w(String str, String str2, Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-359784594")) {
            ipChange.ipc$dispatch("-359784594", new Object[]{this, str, str2, th});
        }
    }
}
