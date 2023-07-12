package com.youku.resource.widget;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.os.Build;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.view.Window;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.youku.resource.R;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YKCommonDialog extends Dialog implements YKDialog {
    private YKTextView confirmView;
    private ViewStub customizedViewStub;
    private YKTextView editHintView;
    private EditText editView;
    private YKTextView messageView;
    private YKTextView negativeView;
    private YKTextView positiveView;
    private YKTextView titleView;

    public YKCommonDialog(@NonNull Context context, String str) {
        super(context);
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1384727862:
                if (str.equals(YKDialog.STYLE_DIALOG_A11)) {
                    c = 0;
                    break;
                }
                break;
            case 1340804679:
                if (str.equals(YKDialog.STYLE_DIALOG_A1)) {
                    c = 1;
                    break;
                }
                break;
            case 1340804680:
                if (str.equals(YKDialog.STYLE_DIALOG_A2)) {
                    c = 2;
                    break;
                }
                break;
            case 1340804681:
                if (str.equals(YKDialog.STYLE_DIALOG_A3)) {
                    c = 3;
                    break;
                }
                break;
            case 1340804683:
                if (str.equals(YKDialog.STYLE_DIALOG_A5)) {
                    c = 4;
                    break;
                }
                break;
            case 1340804685:
                if (str.equals(YKDialog.STYLE_DIALOG_A7)) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setContentView(R.C8074layout.resource_ykdialog_a11);
                break;
            case 1:
                setContentView(R.C8074layout.resource_ykdialog_a1);
                break;
            case 2:
                setContentView(R.C8074layout.resource_ykdialog_a2);
                break;
            case 3:
                setContentView(R.C8074layout.resource_ykdialog_a3);
                break;
            case 4:
                setContentView(R.C8074layout.resource_ykdialog_a5);
                break;
            case 5:
                setContentView(R.C8074layout.resource_ykdialog_a7);
                break;
        }
        if (getWindow() != null) {
            Window window = getWindow();
            int i = R.id.yk_dialog_root;
            if (window.findViewById(i) != null) {
                initView(str);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setBackgroundDrawableResource(17170445);
                    final int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.radius_large);
                    if (dimensionPixelOffset > 0) {
                        getWindow().findViewById(i).setClipToOutline(true);
                    } else {
                        getWindow().findViewById(i).setClipToOutline(false);
                    }
                    getWindow().findViewById(i).setOutlineProvider(new ViewOutlineProvider() { // from class: com.youku.resource.widget.YKCommonDialog.1
                        @Override // android.view.ViewOutlineProvider
                        @TargetApi(21)
                        public void getOutline(View view, Outline outline) {
                            outline.setAlpha(0.0f);
                            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), dimensionPixelOffset);
                        }
                    });
                }
            }
        }
    }

    private void initView(String str) {
        YKTextView yKTextView;
        this.titleView = (YKTextView) getWindow().findViewById(R.id.yk_dialog_title);
        this.messageView = (YKTextView) getWindow().findViewById(R.id.yk_dialog_message);
        if ((str.equals(YKDialog.STYLE_DIALOG_A2) || str.equals(YKDialog.STYLE_DIALOG_A11)) && (yKTextView = this.messageView) != null) {
            yKTextView.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
        this.positiveView = (YKTextView) getWindow().findViewById(R.id.yk_dialog_yes);
        this.negativeView = (YKTextView) getWindow().findViewById(R.id.yk_dialog_no);
        this.confirmView = (YKTextView) getWindow().findViewById(R.id.yk_dialog_confirm);
        this.editView = (EditText) getWindow().findViewById(R.id.yk_dialog_edit);
        this.editHintView = (YKTextView) getWindow().findViewById(R.id.yk_dialog_edit_hint);
        this.customizedViewStub = (ViewStub) getWindow().findViewById(R.id.yk_dialog_customized_view);
    }

    public YKTextView getConfirmView() {
        return this.confirmView;
    }

    public ViewStub getCustomizedViewStub() {
        return this.customizedViewStub;
    }

    public YKTextView getEditHintView() {
        return this.editHintView;
    }

    public EditText getEditView() {
        return this.editView;
    }

    public YKTextView getMessageView() {
        return this.messageView;
    }

    public YKTextView getNegativeView() {
        return this.negativeView;
    }

    public YKTextView getPositiveView() {
        return this.positiveView;
    }

    public YKTextView getTitleView() {
        return this.titleView;
    }
}
