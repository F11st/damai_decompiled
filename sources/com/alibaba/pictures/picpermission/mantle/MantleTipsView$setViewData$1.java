package com.alibaba.pictures.picpermission.mantle;

import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
/* loaded from: classes7.dex */
public final /* synthetic */ class MantleTipsView$setViewData$1 extends MutablePropertyReference0Impl {
    private static transient /* synthetic */ IpChange $ipChange;

    MantleTipsView$setViewData$1(MantleTipsView mantleTipsView) {
        super(mantleTipsView, MantleTipsView.class, "tvTitle", "getTvTitle()Landroid/widget/TextView;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2125052874") ? ipChange.ipc$dispatch("2125052874", new Object[]{this}) : MantleTipsView.h((MantleTipsView) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-478637896")) {
            ipChange.ipc$dispatch("-478637896", new Object[]{this, obj});
        } else {
            ((MantleTipsView) this.receiver).b = (TextView) obj;
        }
    }
}
