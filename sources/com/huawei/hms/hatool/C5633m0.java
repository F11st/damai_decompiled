package com.huawei.hms.hatool;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.m0 */
/* loaded from: classes10.dex */
public class C5633m0 implements InterfaceRunnableC5635n0 {
    public String a;
    public String b;

    public C5633m0(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        C5645r0.a(this.a, this.b);
    }
}
