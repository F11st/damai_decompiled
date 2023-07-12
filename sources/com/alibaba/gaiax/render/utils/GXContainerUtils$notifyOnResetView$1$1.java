package com.alibaba.gaiax.render.utils;

import android.view.View;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Landroid/view/View;", AdvanceSetting.NETWORK_TYPE, "Ltb/wt2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes6.dex */
final class GXContainerUtils$notifyOnResetView$1$1 extends Lambda implements Function1<View, wt2> {
    public static final GXContainerUtils$notifyOnResetView$1$1 INSTANCE = new GXContainerUtils$notifyOnResetView$1$1();

    GXContainerUtils$notifyOnResetView$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ wt2 invoke(View view) {
        invoke2(view);
        return wt2.INSTANCE;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull View view) {
        b41.i(view, AdvanceSetting.NETWORK_TYPE);
        GXContainerUtils.INSTANCE.i(view);
    }
}
