package com.ali.user.open.core.webview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ali.user.open.core.R;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AUProgressDialog extends ProgressDialog {
    private boolean mIndeterminate;
    private CharSequence mMessage;
    private TextView mMessageView;
    private ProgressBar mProgress;
    private boolean mProgressVisiable;

    public AUProgressDialog(Context context) {
        super(context);
    }

    private void setMessageAndView() {
        this.mMessageView.setText(this.mMessage);
        CharSequence charSequence = this.mMessage;
        if (charSequence == null || "".equals(charSequence)) {
            this.mMessageView.setVisibility(8);
        }
        this.mProgress.setVisibility(this.mProgressVisiable ? 0 : 8);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.member_sdk_progress_dialog);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawableResource(17170445);
        }
        this.mProgress = (ProgressBar) findViewById(16908301);
        this.mMessageView = (TextView) findViewById(R.id.aliuser_toast_message);
        setMessageAndView();
        setIndeterminate(this.mIndeterminate);
    }

    @Override // android.app.ProgressDialog
    public void setIndeterminate(boolean z) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setIndeterminate(z);
        } else {
            this.mIndeterminate = z;
        }
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
    }

    public void setProgressVisiable(boolean z) {
        this.mProgressVisiable = z;
    }

    public AUProgressDialog(Context context, int i) {
        super(context, i);
    }
}
