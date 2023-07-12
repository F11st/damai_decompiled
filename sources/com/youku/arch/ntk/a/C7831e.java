package com.youku.arch.ntk.a;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.ntk.a.e */
/* loaded from: classes2.dex */
public class C7831e {
    private static transient /* synthetic */ IpChange $ipChange;
    @JSONField(name = "timestamp")
    public long a;
    @JSONField(name = "totalCnt")
    public int b;
    @JSONField(name = "poorQualityCnt")
    public int c;
    @JSONField(name = "poorBwCnt")
    public int d;
    @JSONField(name = "totalCnt_mb")
    public int e;
    @JSONField(name = "poorQualityCnt_mb")
    public int f;
    @JSONField(name = "poorBwCnt_mb")
    public int g;

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253656559")) {
            return (String) ipChange.ipc$dispatch("1253656559", new Object[]{this});
        }
        return this.a + "|" + this.b + "|" + this.c + "|" + this.d + "|" + this.e + "|" + this.f + "|" + this.g + "|";
    }
}
