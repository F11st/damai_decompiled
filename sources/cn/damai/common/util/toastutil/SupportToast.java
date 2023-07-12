package cn.damai.common.util.toastutil;

import android.app.Application;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class SupportToast extends BaseToast {
    private static transient /* synthetic */ IpChange $ipChange;
    private final HandlerC0540c mToastHelper;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SupportToast(Application application) {
        super(application);
        this.mToastHelper = new HandlerC0540c(this, application);
    }

    @Override // android.widget.Toast
    public void cancel() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "883465989")) {
            ipChange.ipc$dispatch("883465989", new Object[]{this});
        } else {
            this.mToastHelper.a();
        }
    }

    @Override // android.widget.Toast
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2103413282")) {
            ipChange.ipc$dispatch("2103413282", new Object[]{this});
        } else {
            this.mToastHelper.b();
        }
    }
}
