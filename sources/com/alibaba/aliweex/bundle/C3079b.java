package com.alibaba.aliweex.bundle;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.alibaba.aliweex.bundle.WeexPageContract;

/* compiled from: Taobao */
/* renamed from: com.alibaba.aliweex.bundle.b */
/* loaded from: classes5.dex */
public class C3079b implements WeexPageContract.IProgressBar {
    private ProgressBar a;

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IProgressBar
    public View createProgressBar(Context context) {
        ProgressBar progressBar = new ProgressBar(context);
        this.a = progressBar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        progressBar.setLayoutParams(layoutParams);
        return progressBar;
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IProgressBar
    public void destroy() {
    }

    @Override // com.alibaba.aliweex.bundle.WeexPageContract.IProgressBar
    public void showProgressBar(boolean z) {
        ProgressBar progressBar = this.a;
        if (progressBar != null) {
            progressBar.setVisibility(z ? 0 : 8);
        }
    }
}
