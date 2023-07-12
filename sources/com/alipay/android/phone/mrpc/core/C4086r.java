package com.alipay.android.phone.mrpc.core;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.r */
/* loaded from: classes12.dex */
public final class C4086r {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
