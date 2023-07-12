package com.alibaba.pictures.moimage;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class MoImageExtensionsKt {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(@NotNull MoImageView moImageView, @Nullable Integer num, @Nullable String str) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-93189851")) {
            ipChange.ipc$dispatch("-93189851", new Object[]{moImageView, num, str});
            return;
        }
        b41.i(moImageView, "$this$loadFitWidthView");
        if (num == null || num.intValue() <= 0) {
            return;
        }
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        MoImageDownloader.g(MoImageDownloader.Companion.a(), str, null, null, 6, null).c(new MoImageExtensionsKt$loadFitWidthView$1(moImageView, num));
    }
}
