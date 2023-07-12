package com.alibaba.security.realidentity.view;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.security.biometrics.R;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.view.a */
/* loaded from: classes8.dex */
public final class C3927a {
    Dialog a;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.view.a$a */
    /* loaded from: classes8.dex */
    public static class C3928a {
        Context a;
        public String b;
        public String c;
        public String d;
        int e;
        int f;
        int g;
        int k;
        int n;
        public boolean h = true;
        public boolean i = false;
        public String j = "";
        public InterfaceC3930c l = new InterfaceC3930c() { // from class: com.alibaba.security.realidentity.view.a.a.1
            @Override // com.alibaba.security.realidentity.view.C3927a.InterfaceC3930c
            public final void a(Dialog dialog) {
            }
        };
        public String m = "";
        public InterfaceC3929b o = new InterfaceC3929b() { // from class: com.alibaba.security.realidentity.view.a.a.2
            @Override // com.alibaba.security.realidentity.view.C3927a.InterfaceC3929b
            public final void a(Dialog dialog) {
            }
        };

        public C3928a(Context context) {
            this.a = context;
            int i = R.C3734color.rpsdk_common_text;
            this.e = ContextCompat.getColor(context, i);
            int i2 = R.C3734color.rpsdk_gray_light;
            this.f = ContextCompat.getColor(context, i2);
            this.g = ContextCompat.getColor(context, i);
            this.k = ContextCompat.getColor(context, R.C3734color.rpsdk_identity_primary);
            this.n = ContextCompat.getColor(context, i2);
        }

        private C3927a a() {
            return new C3927a(this);
        }

        private C3928a b(String str) {
            this.c = str;
            return this;
        }

        private C3928a c(String str) {
            this.d = str;
            return this;
        }

        private C3928a a(String str) {
            this.b = str;
            return this;
        }

        private C3928a b() {
            this.h = true;
            this.i = false;
            return this;
        }

        private C3928a a(String str, InterfaceC3930c interfaceC3930c) {
            this.j = str;
            this.l = interfaceC3930c;
            return this;
        }

        private C3928a a(String str, InterfaceC3929b interfaceC3929b) {
            this.m = str;
            this.o = interfaceC3929b;
            return this;
        }

        private C3928a a(int i, int i2, int i3, int i4, int i5) {
            this.e = i;
            this.f = i2;
            this.g = i3;
            this.k = i4;
            this.n = i5;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.view.a$b */
    /* loaded from: classes8.dex */
    public interface InterfaceC3929b {
        void a(Dialog dialog);
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.view.a$c */
    /* loaded from: classes8.dex */
    public interface InterfaceC3930c {
        void a(Dialog dialog);
    }

    public C3927a(final C3928a c3928a) {
        Dialog dialog = new Dialog(c3928a.a);
        this.a = dialog;
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(c3928a.a).inflate(R.C3736layout.rp_alrealidentity_alert_dialog, (ViewGroup) null);
        this.a.setContentView(inflate);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(this.a.getWindow().getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        this.a.getWindow().setAttributes(layoutParams);
        TextView textView = (TextView) inflate.findViewById(R.id.rp_dialog_title_text);
        TextView textView2 = (TextView) inflate.findViewById(R.id.rp_dialog_subtitle_text);
        TextView textView3 = (TextView) inflate.findViewById(R.id.rp_dialog_content_text);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.rp_dialog_close_btn);
        Button button = (Button) inflate.findViewById(R.id.rp_dialog_positive_btn);
        Button button2 = (Button) inflate.findViewById(R.id.rp_dialog_negative_btn);
        textView.setTextColor(c3928a.e);
        textView2.setTextColor(c3928a.f);
        textView3.setTextColor(c3928a.g);
        button.setTextColor(c3928a.k);
        button2.setTextColor(c3928a.n);
        if (TextUtils.isEmpty(c3928a.b)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(c3928a.b);
        }
        if (TextUtils.isEmpty(c3928a.c)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(c3928a.c);
        }
        if (TextUtils.isEmpty(c3928a.d)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(c3928a.d);
        }
        if (TextUtils.isEmpty(c3928a.j)) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setText(c3928a.j);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.view.a.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c3928a.l.a(C3927a.this.a);
                }
            });
        }
        if (TextUtils.isEmpty(c3928a.m)) {
            button2.setVisibility(8);
        } else {
            button2.setVisibility(0);
            button2.setText(c3928a.m);
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.view.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c3928a.o.a(C3927a.this.a);
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.view.a.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c3928a.o.a(C3927a.this.a);
            }
        });
        this.a.setCancelable(c3928a.h);
        this.a.setCanceledOnTouchOutside(c3928a.i);
        this.a.show();
    }

    private void a() {
        Dialog dialog = this.a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
