package cn.damai.mine.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$style;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class SelectDialog extends Dialog {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnDialogClickListener a;
    private TextView b;
    private TextView c;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnDialogClickListener {
        void onDismiss();

        void onFirstSel();

        void onSecondSel();
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.view.SelectDialog$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1474a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1474a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1941265016")) {
                ipChange.ipc$dispatch("-1941265016", new Object[]{this, view});
                return;
            }
            SelectDialog.this.a.onDismiss();
            SelectDialog.this.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.view.SelectDialog$b */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1475b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1475b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "170025353")) {
                ipChange.ipc$dispatch("170025353", new Object[]{this, view});
                return;
            }
            SelectDialog.this.a.onFirstSel();
            SelectDialog.this.dismiss();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.view.SelectDialog$c */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC1476c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC1476c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2013651574")) {
                ipChange.ipc$dispatch("-2013651574", new Object[]{this, view});
                return;
            }
            SelectDialog.this.a.onSecondSel();
            SelectDialog.this.dismiss();
        }
    }

    public SelectDialog(Context context) {
        super(context);
        b(context);
    }

    private void b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1345598765")) {
            ipChange.ipc$dispatch("-1345598765", new Object[]{this, context});
            return;
        }
        Activity activity = (Activity) context;
        View inflate = LayoutInflater.from(context).inflate(R$layout.layout_select_dialog, (ViewGroup) null);
        setContentView(inflate);
        this.b = (TextView) findViewById(R$id.tv_first);
        this.c = (TextView) findViewById(R$id.tv_second);
        c(inflate);
    }

    private void c(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "481088575")) {
            ipChange.ipc$dispatch("481088575", new Object[]{this, view});
            return;
        }
        view.findViewById(R$id.tv_cancel).setOnClickListener(new View$OnClickListenerC1474a());
        this.b.setOnClickListener(new View$OnClickListenerC1475b());
        this.c.setOnClickListener(new View$OnClickListenerC1476c());
    }

    private void d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1270535263")) {
            ipChange.ipc$dispatch("1270535263", new Object[]{this});
            return;
        }
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 80;
        attributes.width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        attributes.windowAnimations = R$style.dialog_animation;
        getWindow().setAttributes(attributes);
        setCanceledOnTouchOutside(true);
    }

    public void e(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1913799936")) {
            ipChange.ipc$dispatch("1913799936", new Object[]{this, str, str2});
            return;
        }
        this.b.setText(str);
        this.c.setText(str2);
    }

    public void f(OnDialogClickListener onDialogClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1656165972")) {
            ipChange.ipc$dispatch("-1656165972", new Object[]{this, onDialogClickListener});
        } else {
            this.a = onDialogClickListener;
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "418014085")) {
            ipChange.ipc$dispatch("418014085", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        d();
    }

    public SelectDialog(Context context, int i) {
        super(context, i);
        b(context);
    }
}
