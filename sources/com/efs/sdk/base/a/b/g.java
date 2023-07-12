package com.efs.sdk.base.a.b;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.a.b.a;
import java.io.File;
import tb.j43;
import tb.z43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class g implements f {
    @Override // com.efs.sdk.base.a.b.f
    public final boolean a(File file) {
        a unused;
        j43 h = z43.h(file.getName());
        if (h != null) {
            return (Constants.LOG_TYPE_WA.equals(h.a.a) || com.efs.sdk.base.a.e.b.b().e(h.a.a, file.length())) ? false : true;
        }
        unused = a.b.a;
        a.d(file);
        return true;
    }
}
