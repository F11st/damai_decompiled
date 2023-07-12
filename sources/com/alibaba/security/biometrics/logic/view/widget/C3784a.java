package com.alibaba.security.biometrics.logic.view.widget;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.skin.RPSkinManager;
import com.alibaba.security.biometrics.skin.model.DialogSkinData;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.logic.view.widget.a */
/* loaded from: classes8.dex */
public final class C3784a {
    private static final String b = "ABAlertDialog";
    public Dialog a;
    private RPSkinManager c = RPSkinManager.getInstance();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.logic.view.widget.a$a */
    /* loaded from: classes8.dex */
    public static class C3785a {
        Context a;
        public String b;
        int c;
        int g;
        int j;
        public boolean d = true;
        public boolean e = false;
        public String f = "";
        public InterfaceC3787c h = new InterfaceC3787c() { // from class: com.alibaba.security.biometrics.logic.view.widget.a.a.1
            @Override // com.alibaba.security.biometrics.logic.view.widget.C3784a.InterfaceC3787c
            public final void a(Dialog dialog) {
            }
        };
        public String i = "";
        public InterfaceC3786b k = new InterfaceC3786b() { // from class: com.alibaba.security.biometrics.logic.view.widget.a.a.2
            @Override // com.alibaba.security.biometrics.logic.view.widget.C3784a.InterfaceC3786b
            public final void a(Dialog dialog) {
            }
        };

        public C3785a(Context context) {
            this.a = context;
            this.c = ContextCompat.getColor(context, R.C3734color.rpsdk_color_333333);
            this.g = ContextCompat.getColor(context, R.C3734color.rpsdk_ab_face_dialog_positive);
            this.j = ContextCompat.getColor(context, R.C3734color.rpsdk_ab_face_dialog_negative);
        }

        private C3784a a() {
            return new C3784a(this);
        }

        private C3785a b() {
            this.d = true;
            this.e = false;
            return this;
        }

        private C3785a a(String str) {
            this.b = str;
            return this;
        }

        private C3785a a(String str, InterfaceC3787c interfaceC3787c) {
            this.f = str;
            this.h = interfaceC3787c;
            return this;
        }

        private C3785a a(String str, InterfaceC3786b interfaceC3786b) {
            this.i = str;
            this.k = interfaceC3786b;
            return this;
        }

        private C3785a a(int i, int i2, int i3) {
            this.c = i;
            this.g = i2;
            this.j = i3;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.logic.view.widget.a$b */
    /* loaded from: classes8.dex */
    public interface InterfaceC3786b {
        void a(Dialog dialog);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.logic.view.widget.a$c */
    /* loaded from: classes8.dex */
    public interface InterfaceC3787c {
        void a(Dialog dialog);
    }

    public C3784a(final C3785a c3785a) {
        Dialog dialog = new Dialog(c3785a.a, R.C3738style.RP_Dialog);
        this.a = dialog;
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(c3785a.a).inflate(R.C3736layout.rp_face_dialog, (ViewGroup) null);
        this.a.setContentView(inflate);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.a.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        this.a.getWindow().setAttributes(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R.id.abfl_dialog_content_text);
        TextView textView2 = (TextView) inflate.findViewById(R.id.abfl_dialog_positive_btn);
        TextView textView3 = (TextView) inflate.findViewById(R.id.abfl_dialog_negative_btn);
        textView.setTextColor(c3785a.c);
        textView2.setTextColor(c3785a.g);
        textView3.setTextColor(c3785a.j);
        if (TextUtils.isEmpty(c3785a.b)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(c3785a.b);
        }
        if (TextUtils.isEmpty(c3785a.f)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(c3785a.f);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.a.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c3785a.h.a(C3784a.this.a);
                }
            });
        }
        if (TextUtils.isEmpty(c3785a.i)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(c3785a.i);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c3785a.k.a(C3784a.this.a);
                }
            });
        }
        DialogSkinData dialogSkinData = (DialogSkinData) this.c.getGlobalSkinData("alertDialog", DialogSkinData.class);
        if (dialogSkinData != null) {
            C3788b.a(textView2, dialogSkinData.getPositiveText());
            C3788b.a(textView3, dialogSkinData.getNegativeText());
            C3788b.a(textView, dialogSkinData.getTitleText());
        }
        this.a.setCancelable(c3785a.d);
        this.a.setCanceledOnTouchOutside(c3785a.e);
    }

    private void b() {
        Dialog dialog = this.a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    private void c() {
        Dialog dialog = this.a;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        this.a.show();
    }

    private DialogSkinData d() {
        return (DialogSkinData) this.c.getGlobalSkinData("alertDialog", DialogSkinData.class);
    }

    public final boolean a() {
        Dialog dialog = this.a;
        return dialog != null && dialog.isShowing();
    }
}
