package com.alibaba.pictures.bricks.component.home.welfare;

import android.view.View;
import com.alient.gaiax.container.render.GenericGaiaxPresenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.event.EventHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class WelfareGaiaxPresenter extends GenericGaiaxPresenter {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WelfareGaiaxPresenter(@NotNull String str, @NotNull String str2, @Nullable View view, @NotNull EventHandler eventHandler, @Nullable String str3) {
        super(str, str2, view, eventHandler, str3);
        b41.i(str, "mClassName");
        b41.i(str2, "vClassName");
        b41.i(eventHandler, "eventHandler");
    }

    private final boolean isLargeScreenMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "603599016") ? ((Boolean) ipChange.ipc$dispatch("603599016", new Object[]{this})).booleanValue() : (getCurrentResponsiveLayoutState() == 0 || 1000 == getCurrentResponsiveLayoutState()) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0127, code lost:
        if (r0 > 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x012a, code lost:
        if (r0 > 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x012d, code lost:
        r0 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012e, code lost:
        if (r0 != 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0130, code lost:
        r0 = super.measureWidth(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0135, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    @Override // com.alient.gaiax.container.render.GenericGaiaxPresenter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int measureWidth(@org.jetbrains.annotations.NotNull com.youku.arch.v3.IItem<com.youku.arch.v3.core.ItemValue> r12) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.pictures.bricks.component.home.welfare.WelfareGaiaxPresenter.measureWidth(com.youku.arch.v3.IItem):int");
    }
}
