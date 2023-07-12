package com.alibaba.pictures.bricks.orderconfirm.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import com.alibaba.pictures.R$color;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.orderconfirm.view.BricksTextInputDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class BricksTextInputDialog extends AlertDialog {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private EditText a;
    @Nullable
    private OnClickListener b;
    @Nullable
    private OnClickListener c;
    @Nullable
    private String d;
    @Nullable
    private String e;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnClickListener {
        void onClick(@Nullable DialogInterface dialogInterface, @Nullable CharSequence charSequence);
    }

    public BricksTextInputDialog(@Nullable Context context) {
        super(context);
    }

    private final void c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "836237313")) {
            ipChange.ipc$dispatch("836237313", new Object[]{this, context});
            return;
        }
        setContentView(R$layout.bricks_text_input_dialog);
        this.a = (EditText) findViewById(R$id.et_input);
        findViewById(R$id.tv_cancel).setOnClickListener(new View.OnClickListener() { // from class: tb.od
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BricksTextInputDialog.d(BricksTextInputDialog.this, view);
            }
        });
        findViewById(R$id.tv_confirm).setOnClickListener(new View.OnClickListener() { // from class: tb.pd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BricksTextInputDialog.e(BricksTextInputDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(BricksTextInputDialog bricksTextInputDialog, View view) {
        OnClickListener onClickListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1002399112")) {
            ipChange.ipc$dispatch("1002399112", new Object[]{bricksTextInputDialog, view});
            return;
        }
        b41.i(bricksTextInputDialog, "this$0");
        bricksTextInputDialog.dismiss();
        EditText editText = bricksTextInputDialog.a;
        if (editText == null || (onClickListener = bricksTextInputDialog.b) == null) {
            return;
        }
        b41.f(editText);
        onClickListener.onClick(bricksTextInputDialog, editText.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(BricksTextInputDialog bricksTextInputDialog, View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "988148967")) {
            ipChange.ipc$dispatch("988148967", new Object[]{bricksTextInputDialog, view});
            return;
        }
        b41.i(bricksTextInputDialog, "this$0");
        bricksTextInputDialog.dismiss();
        EditText editText = bricksTextInputDialog.a;
        if (editText == null || bricksTextInputDialog.c == null) {
            return;
        }
        b41.f(editText);
        Editable text = editText.getText();
        OnClickListener onClickListener = bricksTextInputDialog.c;
        if (onClickListener != null) {
            onClickListener.onClick(bricksTextInputDialog, text);
        }
    }

    private final void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1898327551")) {
            ipChange.ipc$dispatch("1898327551", new Object[]{this});
            return;
        }
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
        }
        if (attributes != null) {
            attributes.width = -1;
        }
        if (attributes != null) {
            attributes.height = -2;
        }
        if (attributes != null) {
            attributes.x = 0;
        }
        if (attributes != null) {
            attributes.y = 0;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setAttributes(attributes);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawableResource(R$color.transparent);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.clearFlags(131072);
        }
        Window window5 = getWindow();
        if (window5 != null) {
            window5.setSoftInputMode(5);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-906703551")) {
            ipChange.ipc$dispatch("-906703551", new Object[]{this});
        } else {
            super.dismiss();
        }
    }

    @NotNull
    public final BricksTextInputDialog g(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "701552141")) {
            return (BricksTextInputDialog) ipChange.ipc$dispatch("701552141", new Object[]{this, str, str2});
        }
        this.d = str;
        this.e = str2;
        return this;
    }

    @NotNull
    public final BricksTextInputDialog h(@Nullable OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649956167")) {
            return (BricksTextInputDialog) ipChange.ipc$dispatch("-1649956167", new Object[]{this, onClickListener});
        }
        this.c = onClickListener;
        return this;
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1926901118")) {
            ipChange.ipc$dispatch("-1926901118", new Object[]{this});
            return;
        }
        super.show();
        Context context = getContext();
        b41.h(context, WPKFactory.INIT_KEY_CONTEXT);
        c(context);
        f();
        EditText editText = this.a;
        if (editText != null) {
            editText.setText(this.d);
        }
        EditText editText2 = this.a;
        if (editText2 != null) {
            editText2.setHint(this.e);
        }
        EditText editText3 = this.a;
        if (editText3 != null) {
            String str = this.d;
            editText3.setSelection(str != null ? str.length() : 0);
        }
        EditText editText4 = this.a;
        if (editText4 != null) {
            editText4.requestFocus();
        }
    }
}
