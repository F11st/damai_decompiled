package cn.damai.common.app.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import cn.damai.common.R$style;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.media.arch.instruments.statistics.ConfigReporter;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class DMProgressDialogV2 extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private DMProgressDialogV2 b;

    public DMProgressDialogV2(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.a = context;
    }

    private void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1922291143")) {
            ipChange.ipc$dispatch("1922291143", new Object[]{this, context});
        } else {
            TextView textView = (TextView) findViewById(R$id.tv_progress_dialog_label);
        }
    }

    public DMProgressDialogV2 a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1078581046")) {
            return (DMProgressDialogV2) ipChange.ipc$dispatch("-1078581046", new Object[]{this});
        }
        DMProgressDialogV2 dMProgressDialogV2 = new DMProgressDialogV2(this.a, R$style.myDialogThemeV2);
        this.b = dMProgressDialogV2;
        dMProgressDialogV2.setContentView(R$layout.customprogressdialog);
        this.b.getWindow().getAttributes().gravity = 17;
        this.b.getWindow().setLayout(-1, -1);
        this.b.b(this.a);
        if (Build.VERSION.SDK_INT >= 23) {
            this.b.getWindow().addFlags(Integer.MIN_VALUE);
            this.b.getWindow().clearFlags(ConfigReporter.BIT_GETTER_IMP);
            this.b.getWindow().getDecorView().setSystemUiVisibility(8192);
            this.b.getWindow().setStatusBarColor(0);
        }
        this.b.c();
        return this.b;
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-56794656")) {
            ipChange.ipc$dispatch("-56794656", new Object[]{this});
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
        if (AndroidInstantRuntime.support(ipChange, "1335584308")) {
            ipChange.ipc$dispatch("1335584308", new Object[]{this, Boolean.valueOf(z)});
        }
    }

    public DMProgressDialogV2(Context context, int i) {
        super(context, i);
        this.a = null;
        this.b = null;
        this.a = context;
    }
}
