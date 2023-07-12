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
public final /* synthetic */ class MantleTipsView$setViewData$3 extends MutablePropertyReference0Impl {
    private static transient /* synthetic */ IpChange $ipChange;

    MantleTipsView$setViewData$3(MantleTipsView mantleTipsView) {
        super(mantleTipsView, MantleTipsView.class, "tvDescribe", "getTvDescribe()Landroid/widget/TextView;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-246686388") ? ipChange.ipc$dispatch("-246686388", new Object[]{this}) : MantleTipsView.f((MantleTipsView) this.receiver);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(@Nullable Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-988110986")) {
            ipChange.ipc$dispatch("-988110986", new Object[]{this, obj});
        } else {
            ((MantleTipsView) this.receiver).d = (TextView) obj;
        }
    }
}
