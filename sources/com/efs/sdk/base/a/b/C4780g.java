package com.efs.sdk.base.a.b;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.C4770a;
import com.efs.sdk.base.a.e.HandlerC4790b;
import java.io.File;
import tb.j43;
import tb.z43;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.b.g */
/* loaded from: classes10.dex */
public final class C4780g implements InterfaceC4779f {
    @Override // com.efs.sdk.base.a.b.InterfaceC4779f
    public final boolean a(File file) {
        C4770a unused;
        j43 h = z43.h(file.getName());
        if (h != null) {
            return (Constants.LOG_TYPE_WA.equals(h.a.a) || HandlerC4790b.b().e(h.a.a, file.length())) ? false : true;
        }
        unused = C4770a.C4772b.a;
        C4770a.d(file);
        return true;
    }
}
