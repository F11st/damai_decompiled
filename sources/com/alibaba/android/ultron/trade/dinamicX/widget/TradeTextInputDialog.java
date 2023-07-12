package com.alibaba.android.ultron.trade.dinamicX.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.alibaba.android.ultron.trade.R$id;
import com.alibaba.android.ultron.trade.R$layout;
import com.alibaba.android.ultron.trade.dinamicX.constructor.TradeTextInputConstructor;
import tb.h90;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class TradeTextInputDialog extends AlertDialog {
    private EditText a;
    private EditText b;
    private String c;
    private OnClickListener d;
    private OnClickListener e;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnClickListener {
        void onClick(DialogInterface dialogInterface, CharSequence charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.ultron.trade.dinamicX.widget.TradeTextInputDialog$a */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC3253a implements View.OnClickListener {
        View$OnClickListenerC3253a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TradeTextInputDialog.this.dismiss();
            if (TradeTextInputDialog.this.b == null || TradeTextInputDialog.this.d == null) {
                return;
            }
            OnClickListener onClickListener = TradeTextInputDialog.this.d;
            TradeTextInputDialog tradeTextInputDialog = TradeTextInputDialog.this;
            onClickListener.onClick(tradeTextInputDialog, tradeTextInputDialog.b.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.ultron.trade.dinamicX.widget.TradeTextInputDialog$b */
    /* loaded from: classes15.dex */
    public class View$OnClickListenerC3254b implements View.OnClickListener {
        View$OnClickListenerC3254b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TradeTextInputDialog.this.dismiss();
            if (TradeTextInputDialog.this.b == null || TradeTextInputDialog.this.e == null) {
                return;
            }
            Editable text = TradeTextInputDialog.this.b.getText();
            TradeTextInputDialog.this.a.setText(text);
            TradeTextInputDialog.this.e.onClick(TradeTextInputDialog.this, text);
        }
    }

    public TradeTextInputDialog(Context context) {
        super(context);
        this.c = "";
    }

    private void e() {
        EditText editText = this.a;
        if (editText == null || this.b == null) {
            return;
        }
        Object tag = editText.getTag(TradeTextInputConstructor.ID_KEY_BOARD);
        if (tag != null) {
            h90.c(this.b, tag.toString());
        }
        Object tag2 = this.a.getTag(TradeTextInputConstructor.ID_MAX_LENGTH);
        if (tag2 != null) {
            h90.d(this.b, tag2.toString());
        }
        Object tag3 = this.a.getTag(TradeTextInputConstructor.ID_PLACE_HOLDER);
        if (tag3 != null) {
            h90.a(this.b, tag3.toString());
        }
        Object tag4 = this.a.getTag(TradeTextInputConstructor.ID_PLACE_HOLDER_COLOR);
        if (tag4 != null) {
            h90.b(this.b, tag4.toString());
        }
        Object tag5 = this.a.getTag(TradeTextInputConstructor.ID_TV_TEXT);
        if (tag5 != null) {
            String obj = tag5.toString();
            this.c = obj;
            h90.e(this.b, obj);
        }
        Editable text = this.b.getText();
        if (TextUtils.isEmpty(text)) {
            return;
        }
        this.b.setSelection(text.length());
    }

    private void f(Context context) {
        setContentView(R$layout.trade_text_input);
        this.b = (EditText) findViewById(R$id.et_input);
        findViewById(R$id.tv_cancel).setOnClickListener(new View$OnClickListenerC3253a());
        findViewById(R$id.tv_confirm).setOnClickListener(new View$OnClickListenerC3254b());
    }

    private void g() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -2;
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(17170445);
        window.clearFlags(131072);
        window.setSoftInputMode(5);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    public void h(EditText editText) {
        this.a = editText;
        e();
    }

    public void i(OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        f(getContext());
        g();
        e();
    }
}
