package cn.damai.ultron.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import cn.damai.common.R$layout;
import cn.damai.common.R$style;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DmUltronProgressDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private DmUltronProgressDialog b;

    public DmUltronProgressDialog(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.a = context;
    }

    public DmUltronProgressDialog a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-604394668")) {
            return (DmUltronProgressDialog) ipChange.ipc$dispatch("-604394668", new Object[]{this});
        }
        DmUltronProgressDialog dmUltronProgressDialog = new DmUltronProgressDialog(this.a, R$style.myDialogTheme);
        this.b = dmUltronProgressDialog;
        dmUltronProgressDialog.setContentView(R$layout.customprogressdialog);
        this.b.getWindow().getAttributes().gravity = 17;
        this.b.b();
        this.b.setCanceledOnTouchOutside(false);
        return this.b;
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-116031738")) {
            ipChange.ipc$dispatch("-116031738", new Object[]{this});
            return;
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "243323354")) {
            ipChange.ipc$dispatch("243323354", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    public DmUltronProgressDialog(Context context, int i) {
        super(context, i);
        this.a = null;
        this.b = null;
    }
}
