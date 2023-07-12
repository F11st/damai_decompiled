package cn.damai.common.app.widget;

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
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DMProgressDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private DMProgressDialog b;
    private TextView c;

    public DMProgressDialog(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.a = context;
    }

    private void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-486668117")) {
            ipChange.ipc$dispatch("-486668117", new Object[]{this, context});
        } else {
            this.c = (TextView) findViewById(R$id.tv_progress_dialog_label);
        }
    }

    public DMProgressDialog a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1187774838")) {
            return (DMProgressDialog) ipChange.ipc$dispatch("-1187774838", new Object[]{this});
        }
        DMProgressDialog dMProgressDialog = new DMProgressDialog(this.a, R$style.myDialogTheme);
        this.b = dMProgressDialog;
        dMProgressDialog.setContentView(R$layout.customprogressdialog);
        this.b.getWindow().getAttributes().gravity = 17;
        this.b.b(this.a);
        this.b.d();
        return this.b;
    }

    public void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "826156039")) {
            ipChange.ipc$dispatch("826156039", new Object[]{this, str});
        } else if (wh2.j(str)) {
            this.c.setVisibility(8);
        } else {
            this.c.setText(str);
            this.c.setVisibility(0);
        }
    }

    public void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-640138372")) {
            ipChange.ipc$dispatch("-640138372", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "-911978288")) {
            ipChange.ipc$dispatch("-911978288", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    public DMProgressDialog(Context context, int i) {
        super(context, i);
        this.a = null;
        this.b = null;
        this.a = context;
    }
}
