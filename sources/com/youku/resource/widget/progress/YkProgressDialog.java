package com.youku.resource.widget.progress;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import com.youku.resource.R;
import com.youku.resource.widget.progress.IYkProgessProvider;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YkProgressDialog extends Dialog {
    private boolean mAutoDismiss;
    private IYkProgessProvider.ProgressListener mInnerListener;
    private DownloadProgressBar mProgressBar;
    private IYkProgessProvider mYkProgressListener;

    public YkProgressDialog(@NonNull Context context) {
        super(context);
        this.mAutoDismiss = false;
        this.mInnerListener = new IYkProgessProvider.ProgressListener() { // from class: com.youku.resource.widget.progress.YkProgressDialog.1
            @Override // com.youku.resource.widget.progress.IYkProgessProvider.ProgressListener
            public void onComplete() {
                if (YkProgressDialog.this.mProgressBar != null) {
                    YkProgressDialog.this.mProgressBar.setProgress(100);
                }
                if (YkProgressDialog.this.mAutoDismiss) {
                    YkProgressDialog.this.dismiss();
                }
            }

            @Override // com.youku.resource.widget.progress.IYkProgessProvider.ProgressListener
            public void onFailed(String str) {
                YkProgressDialog.this.dismiss();
            }

            @Override // com.youku.resource.widget.progress.IYkProgessProvider.ProgressListener
            public void updateProgress(int i) {
                if (YkProgressDialog.this.mProgressBar != null) {
                    YkProgressDialog.this.mProgressBar.setProgress(i);
                }
            }
        };
    }

    public static YkProgressDialog create(Context context, boolean z, IYkProgessProvider iYkProgessProvider) {
        return new YkProgressDialog(context, iYkProgessProvider, z);
    }

    private void initContentView() {
        setContentView(R.C8074layout.ykdialog_download_progress);
        this.mProgressBar = (DownloadProgressBar) findViewById(R.id.downloadProgressBar);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(17);
        window.setWindowAnimations(R.C8077style.yk_CenterDialog);
        window.setDimAmount(0.3f);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initContentView();
    }

    public void start() {
        IYkProgessProvider iYkProgessProvider = this.mYkProgressListener;
        if (iYkProgessProvider != null) {
            iYkProgessProvider.start(this.mInnerListener);
        }
    }

    public YkProgressDialog(@NonNull Context context, IYkProgessProvider iYkProgessProvider, boolean z) {
        super(context);
        this.mAutoDismiss = false;
        this.mInnerListener = new IYkProgessProvider.ProgressListener() { // from class: com.youku.resource.widget.progress.YkProgressDialog.1
            @Override // com.youku.resource.widget.progress.IYkProgessProvider.ProgressListener
            public void onComplete() {
                if (YkProgressDialog.this.mProgressBar != null) {
                    YkProgressDialog.this.mProgressBar.setProgress(100);
                }
                if (YkProgressDialog.this.mAutoDismiss) {
                    YkProgressDialog.this.dismiss();
                }
            }

            @Override // com.youku.resource.widget.progress.IYkProgessProvider.ProgressListener
            public void onFailed(String str) {
                YkProgressDialog.this.dismiss();
            }

            @Override // com.youku.resource.widget.progress.IYkProgessProvider.ProgressListener
            public void updateProgress(int i) {
                if (YkProgressDialog.this.mProgressBar != null) {
                    YkProgressDialog.this.mProgressBar.setProgress(i);
                }
            }
        };
        this.mYkProgressListener = iYkProgessProvider;
        this.mAutoDismiss = z;
        start();
    }
}
