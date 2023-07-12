package com.alibaba.security.realidentity.a;

import android.content.Context;
import com.alibaba.security.realidentity.business.bucket.BucketParams;
import com.alibaba.security.realidentity.http.AbsHttpInvoker;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface d {
    c a(Context context);

    AbsHttpInvoker a();

    Class<? extends com.alibaba.security.realidentity.jsbridge.a>[] b();

    Class<? extends BucketParams>[] c();

    b d();
}
