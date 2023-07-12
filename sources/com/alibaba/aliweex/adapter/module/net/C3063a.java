package com.alibaba.aliweex.adapter.module.net;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* renamed from: com.alibaba.aliweex.adapter.module.net.a */
/* loaded from: classes15.dex */
public class C3063a {
    @Nullable
    public static IWXConnection a(@NonNull Context context) {
        if (context == null) {
            return null;
        }
        return new DefaultWXConnection(context);
    }
}
