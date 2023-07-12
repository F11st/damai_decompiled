package cn.damai.baseview;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CustomDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnDialogClickListener a;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface OnDialogClickListener {
        void onAlbum();

        void onDismiss();

        void onPhoto();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1571460406")) {
                ipChange.ipc$dispatch("-1571460406", new Object[]{this, view});
                return;
            }
            CustomDialog.this.a.onDismiss();
            CustomDialog.this.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "539829963")) {
                ipChange.ipc$dispatch("539829963", new Object[]{this, view});
                return;
            }
            CustomDialog.this.a.onAlbum();
            CustomDialog.this.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1643846964")) {
                ipChange.ipc$dispatch("-1643846964", new Object[]{this, view});
                return;
            }
            CustomDialog.this.a.onPhoto();
            CustomDialog.this.dismiss();
        }
    }

    public CustomDialog(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1800666833")) {
            ipChange.ipc$dispatch("1800666833", new Object[]{this, context});
            return;
        }
        Activity activity = (Activity) context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.custom_dialog, (ViewGroup) null);
        setContentView(inflate);
        c(inflate);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "385351869")) {
            ipChange.ipc$dispatch("385351869", new Object[]{this, view});
            return;
        }
        view.findViewById(R$id.tv_cancel).setOnClickListener(new a());
        view.findViewById(R$id.tv_first).setOnClickListener(new b());
        view.findViewById(R$id.tv_second).setOnClickListener(new c());
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2134555869")) {
            ipChange.ipc$dispatch("2134555869", new Object[]{this});
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        attributes.windowAnimations = R$style.dialog_animation;
        getWindow().setAttributes(attributes);
        setCanceledOnTouchOutside(true);
    }

    public void e(OnDialogClickListener onDialogClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-769568064")) {
            ipChange.ipc$dispatch("-769568064", new Object[]{this, onDialogClickListener});
        } else {
            this.a = onDialogClickListener;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1538321923")) {
            ipChange.ipc$dispatch("1538321923", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        d();
    }

    public CustomDialog(Context context, int i) {
        super(context, i);
        b(context);
    }
}
