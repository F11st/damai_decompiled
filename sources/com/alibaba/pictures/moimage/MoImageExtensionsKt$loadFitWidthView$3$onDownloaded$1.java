package com.alibaba.pictures.moimage;

import android.graphics.Bitmap;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import tb.ig1;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ltb/wt2;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final class MoImageExtensionsKt$loadFitWidthView$3$onDownloaded$1 implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange;
    final /* synthetic */ Bitmap $source;
    final /* synthetic */ ig1 this$0;

    MoImageExtensionsKt$loadFitWidthView$3$onDownloaded$1(ig1 ig1Var, Bitmap bitmap) {
        this.$source = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1760019233")) {
            ipChange.ipc$dispatch("-1760019233", new Object[]{this});
        } else if (this.$source.getWidth() > 0 && this.$source.getHeight() > 0) {
            throw null;
        }
    }
}
