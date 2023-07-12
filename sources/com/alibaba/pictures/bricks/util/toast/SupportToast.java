package com.alibaba.pictures.bricks.util.toast;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.xo2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class SupportToast extends BaseToast {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final xo2 mToastHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SupportToast(@NotNull Application application) {
        super(application);
        b41.i(application, "application");
        this.mToastHelper = new xo2(this, application);
    }

    @Override // android.widget.Toast
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "814859948")) {
            ipChange.ipc$dispatch("814859948", new Object[]{this});
        } else {
            this.mToastHelper.c();
        }
    }

    @Override // android.widget.Toast
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686583689")) {
            ipChange.ipc$dispatch("686583689", new Object[]{this});
        } else {
            this.mToastHelper.d();
        }
    }
}
