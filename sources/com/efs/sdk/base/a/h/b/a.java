package com.efs.sdk.base.a.h.b;

import androidx.annotation.Nullable;
import java.io.File;
import java.util.Map;
import tb.f01;
import tb.gn1;
import tb.l01;
import tb.w63;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class a implements com.efs.sdk.base.a.h.a.c<l01> {
    String a;
    Map<String, String> b;
    public byte[] c;
    public File d;
    public String e;
    public Map<String, String> f;
    public boolean g = false;

    @Override // com.efs.sdk.base.a.h.a.c
    @Nullable
    public final /* synthetic */ l01 a() {
        String str = this.e;
        str.hashCode();
        if (str.equals(gn1.TYPE_OPEN_URL_METHOD_GET)) {
            return f01.c().b().get(this.a, this.b);
        }
        if (str.equals(gn1.TYPE_OPEN_URL_METHOD_POST)) {
            byte[] bArr = this.c;
            return (bArr == null || bArr.length <= 0) ? f01.c().b().post(this.a, this.b, this.d) : this.g ? f01.c().b().postAsFile(this.a, this.b, this.c) : f01.c().b().post(this.a, this.b, this.c);
        }
        w63.c("efs.util.http", "request not support method '" + this.e + "'", null);
        return null;
    }
}
