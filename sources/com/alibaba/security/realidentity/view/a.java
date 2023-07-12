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
/* loaded from: classes8.dex */
public final class a {
    Dialog a;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0175a {
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
        public c l = new c() { // from class: com.alibaba.security.realidentity.view.a.a.1
            @Override // com.alibaba.security.realidentity.view.a.c
            public final void a(Dialog dialog) {
            }
        };
        public String m = "";
        public b o = new b() { // from class: com.alibaba.security.realidentity.view.a.a.2
            @Override // com.alibaba.security.realidentity.view.a.b
            public final void a(Dialog dialog) {
            }
        };

        public C0175a(Context context) {
            this.a = context;
            int i = R.color.rpsdk_common_text;
            this.e = ContextCompat.getColor(context, i);
            int i2 = R.color.rpsdk_gray_light;
            this.f = ContextCompat.getColor(context, i2);
            this.g = ContextCompat.getColor(context, i);
            this.k = ContextCompat.getColor(context, R.color.rpsdk_identity_primary);
            this.n = ContextCompat.getColor(context, i2);
        }

        private a a() {
            return new a(this);
        }

        private C0175a b(String str) {
            this.c = str;
            return this;
        }

        private C0175a c(String str) {
            this.d = str;
            return this;
        }

        private C0175a a(String str) {
            this.b = str;
            return this;
        }

        private C0175a b() {
            this.h = true;
            this.i = false;
            return this;
        }

        private C0175a a(String str, c cVar) {
            this.j = str;
            this.l = cVar;
            return this;
        }

        private C0175a a(String str, b bVar) {
            this.m = str;
            this.o = bVar;
            return this;
        }

        private C0175a a(int i, int i2, int i3, int i4, int i5) {
            this.e = i;
            this.f = i2;
            this.g = i3;
            this.k = i4;
            this.n = i5;
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

    public a(final C0175a c0175a) {
        Dialog dialog = new Dialog(c0175a.a);
        this.a = dialog;
        dialog.requestWindowFeature(1);
        View inflate = LayoutInflater.from(c0175a.a).inflate(R.layout.rp_alrealidentity_alert_dialog, (ViewGroup) null);
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
        textView.setTextColor(c0175a.e);
        textView2.setTextColor(c0175a.f);
        textView3.setTextColor(c0175a.g);
        button.setTextColor(c0175a.k);
        button2.setTextColor(c0175a.n);
        if (TextUtils.isEmpty(c0175a.b)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(c0175a.b);
        }
        if (TextUtils.isEmpty(c0175a.c)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(c0175a.c);
        }
        if (TextUtils.isEmpty(c0175a.d)) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
            textView3.setText(c0175a.d);
        }
        if (TextUtils.isEmpty(c0175a.j)) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            button.setText(c0175a.j);
            button.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.view.a.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c0175a.l.a(a.this.a);
                }
            });
        }
        if (TextUtils.isEmpty(c0175a.m)) {
            button2.setVisibility(8);
        } else {
            button2.setVisibility(0);
            button2.setText(c0175a.m);
            button2.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.view.a.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c0175a.o.a(a.this.a);
                }
            });
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.security.realidentity.view.a.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c0175a.o.a(a.this.a);
            }
        });
        this.a.setCancelable(c0175a.h);
        this.a.setCanceledOnTouchOutside(c0175a.i);
        this.a.show();
    }

    private void a() {
        Dialog dialog = this.a;
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
