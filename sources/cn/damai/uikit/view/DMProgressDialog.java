package cn.damai.uikit.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class DMProgressDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private DMProgressDialog b;

    public DMProgressDialog(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.a = context;
    }

    private void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1736567473")) {
            ipChange.ipc$dispatch("1736567473", new Object[]{this, context});
        } else {
            TextView textView = (TextView) findViewById(R$id.tv_progress_dialog_label);
        }
    }

    public DMProgressDialog a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164103500")) {
            return (DMProgressDialog) ipChange.ipc$dispatch("-164103500", new Object[]{this});
        }
        DMProgressDialog dMProgressDialog = new DMProgressDialog(this.a, R$style.myDialogTheme);
        this.b = dMProgressDialog;
        dMProgressDialog.setContentView(R$layout.customprogressdialog);
        this.b.getWindow().getAttributes().gravity = 17;
        this.b.b(this.a);
        this.b.c();
        return this.b;
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1523144246")) {
            ipChange.ipc$dispatch("1523144246", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-761553654")) {
            ipChange.ipc$dispatch("-761553654", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    public DMProgressDialog(Context context, int i) {
        super(context, i);
        this.a = null;
        this.b = null;
        this.a = context;
    }
}
