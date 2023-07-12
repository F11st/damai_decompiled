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
/* loaded from: classes8.dex */
public final class a {
    private static final String b = "ABAlertDialog";
    public Dialog a;
    private RPSkinManager c = RPSkinManager.getInstance();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.logic.view.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0163a {
        Context a;
        public String b;
        int c;
        int g;
        int j;
        public boolean d = true;
        public boolean e = false;
        public String f = "";
        public c h = new c() { // from class: com.alibaba.security.biometrics.logic.view.widget.a.a.1
            @Override // com.alibaba.security.biometrics.logic.view.widget.a.c
            public final void a(Dialog dialog) {
            }
        };
        public String i = "";
        public b k = new b() { // from class: com.alibaba.security.biometrics.logic.view.widget.a.a.2
            @Override // com.alibaba.security.biometrics.logic.view.widget.a.b
            public final void a(Dialog dialog) {
            }
        };

        public C0163a(Context context) {
            this.a = context;
            this.c = ContextCompat.getColor(context, R.color.rpsdk_color_333333);
            this.g = ContextCompat.getColor(context, R.color.rpsdk_ab_face_dialog_positive);
            this.j = ContextCompat.getColor(context, R.color.rpsdk_ab_face_dialog_negative);
        }

        private a a() {
            return new a(this);
        }

        private C0163a b() {
            this.d = true;
            this.e = false;
            return this;
        }

        private C0163a a(String str) {
            this.b = str;
            return this;
        }

        private C0163a a(String str, c cVar) {
            this.f = str;
            this.h = cVar;
            return this;
        }

        private C0163a a(String str, b bVar) {
            this.i = str;
            this.k = bVar;
            return this;
        }

        private C0163a a(int i, int i2, int i3) {
            this.c = i;
            this.g = i2;
            this.j = i3;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface b {
        void a(Dialog dialog);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface c {
        void a(Dialog dialog);
    }

    public a(final C0163a c0163a) {
        Dialog dialog = new Dialog(c0163a.a, R.style.RP_Dialog);
        this.a = dialog;
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(c0163a.a).inflate(R.layout.rp_face_dialog, (ViewGroup) null);
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
        textView.setTextColor(c0163a.c);
        textView2.setTextColor(c0163a.g);
        textView3.setTextColor(c0163a.j);
        if (TextUtils.isEmpty(c0163a.b)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(c0163a.b);
        }
        if (TextUtils.isEmpty(c0163a.f)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(c0163a.f);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.a.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c0163a.h.a(a.this.a);
                }
            });
        }
        if (TextUtils.isEmpty(c0163a.i)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(c0163a.i);
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.biometrics.logic.view.widget.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c0163a.k.a(a.this.a);
                }
            });
        }
        DialogSkinData dialogSkinData = (DialogSkinData) this.c.getGlobalSkinData("alertDialog", DialogSkinData.class);
        if (dialogSkinData != null) {
            com.alibaba.security.biometrics.logic.view.widget.b.a(textView2, dialogSkinData.getPositiveText());
            com.alibaba.security.biometrics.logic.view.widget.b.a(textView3, dialogSkinData.getNegativeText());
            com.alibaba.security.biometrics.logic.view.widget.b.a(textView, dialogSkinData.getTitleText());
        }
        this.a.setCancelable(c0163a.d);
        this.a.setCanceledOnTouchOutside(c0163a.e);
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
