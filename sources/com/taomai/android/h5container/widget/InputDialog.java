package com.taomai.android.h5container.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taomai.android.h5container.R$id;
import com.taomai.android.h5container.R$layout;
import com.taomai.android.h5container.R$style;
import tb.ea0;
import tb.fb1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class InputDialog extends BaseDialog {
    private final LayoutInflater a;
    private View b;
    private Button c;
    private Button d;
    private EditText e;
    private TextView f;
    private TextView g;
    private final String h;
    private final String i;
    private OnClickPositiveListener j;
    private OnClickNegativeListener k;
    private final String l;
    private final String m;
    private final boolean n;
    private String o;
    private String p;
    private String q;
    private DialogBottomButtonGroupView r;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnClickNegativeListener {
        void onClick();
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnClickPositiveListener {
        void onClick(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputDialog.this.cancel();
            if (InputDialog.this.k != null) {
                InputDialog.this.k.onClick();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InputDialog.this.dismiss();
            if (InputDialog.this.j != null) {
                if (InputDialog.this.e.getText() != null) {
                    InputDialog.this.j.onClick(InputDialog.this.e.getText().toString());
                } else {
                    InputDialog.this.j.onClick(null);
                }
            }
        }
    }

    public InputDialog(Context context, String str, String str2, String str3, String str4, boolean z) {
        super(context, R$style.h5_noTitleTransBgDialogStyle);
        this.h = str;
        this.i = str2;
        this.l = str3;
        this.m = str4;
        this.n = z;
        this.a = LayoutInflater.from(context);
    }

    private void f() {
        if (TextUtils.isEmpty(this.m) && TextUtils.isEmpty(this.l)) {
            this.r.setVisibility(8);
            return;
        }
        this.r.setVisibility(0);
        this.r.setNegativeButton(this.m, new a());
        this.r.setPositiveButton(this.l, new b());
        this.r.setButtonLayout(1);
        this.r.renderView();
    }

    public EditText e() {
        return this.e;
    }

    public InputDialog g(String str) {
        this.q = str;
        return this;
    }

    public InputDialog h(OnClickNegativeListener onClickNegativeListener) {
        this.k = onClickNegativeListener;
        return this;
    }

    public InputDialog i(String str) {
        this.p = str;
        return this;
    }

    public InputDialog j(OnClickPositiveListener onClickPositiveListener) {
        this.j = onClickPositiveListener;
        return this;
    }

    public InputDialog k(String str) {
        this.o = str;
        return this;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = this.a.inflate(R$layout.h5_input_dialog, (ViewGroup) null);
        this.b = inflate;
        DialogBottomButtonGroupView dialogBottomButtonGroupView = (DialogBottomButtonGroupView) inflate.findViewById(R$id.buttomButtonView);
        this.r = dialogBottomButtonGroupView;
        this.d = dialogBottomButtonGroupView.getPositiveBtn();
        this.c = this.r.getNegativeBtn();
        this.f = (TextView) inflate.findViewById(R$id.title);
        this.g = (TextView) inflate.findViewById(R$id.message);
        this.e = (EditText) inflate.findViewById(R$id.inputContent);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R$id.dialog_bg);
        if (!TextUtils.isEmpty(this.o)) {
            try {
                this.d.setTextColor(Color.parseColor(this.o));
            } catch (Exception e) {
                fb1.b("InputDialog", "positiveTextColor设置失败：" + this.o + "，" + e.getLocalizedMessage());
            }
        }
        if (!TextUtils.isEmpty(this.p)) {
            try {
                this.c.setTextColor(Color.parseColor(this.p));
            } catch (Exception e2) {
                fb1.b("InputDialog", "negativeTextColor设置失败：" + this.p + "，" + e2.getLocalizedMessage());
            }
        }
        if (TextUtils.isEmpty(this.i)) {
            this.g.setVisibility(8);
        } else {
            this.g.setText(this.i);
            this.g.setVisibility(0);
        }
        if (TextUtils.isEmpty(this.h)) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            this.f.setText(this.h);
        }
        if (!TextUtils.isEmpty(this.q)) {
            this.e.setHint(this.q);
        }
        setCanceledOnTouchOutside(this.n);
        f();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        setContentView(this.b);
        if (isShowing()) {
            a(ea0.a(40.0f));
        }
    }
}
