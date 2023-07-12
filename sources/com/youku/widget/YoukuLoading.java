package com.youku.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.airbnb.lottie.C2821a;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.baseproject.ui.R$id;
import com.baseproject.ui.R$layout;
import com.baseproject.ui.R$style;
import com.youku.utils.YoukuUIUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class YoukuLoading {
    private static LoadingDialog mLoadingDialog;
    private static LottieDrawable mLottieDrawable;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class LoadingDialog extends Dialog {
        private Loading loading;

        public LoadingDialog(Context context) {
            super(context, R$style.LoadingDialog);
        }

        @Override // android.app.Dialog, android.content.DialogInterface
        public void dismiss() {
            try {
                super.dismiss();
            } catch (Exception unused) {
            }
            this.loading.stopAnimation();
        }

        @Override // android.app.Dialog
        protected void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(R$layout.loading);
            this.loading = (Loading) findViewById(R$id.newLoading);
            getWindow().addFlags(32);
        }

        @Override // android.app.Dialog
        public void show() {
            super.show();
            this.loading.startAnimation();
        }
    }

    private static boolean canDismissed(Context context, ImageView imageView) {
        LottieDrawable lottieDrawable = mLottieDrawable;
        return (lottieDrawable == null || !lottieDrawable.isAnimating() || context == null || imageView == null) ? false : true;
    }

    public static void dismiss() {
        LoadingDialog loadingDialog = mLoadingDialog;
        if (loadingDialog != null && loadingDialog.isShowing() && mLoadingDialog.getWindow() != null) {
            mLoadingDialog.dismiss();
        }
        mLoadingDialog = null;
    }

    private static void ensureLottieDrawable(Context context) {
        if (mLottieDrawable == null) {
            final LottieDrawable lottieDrawable = new LottieDrawable() { // from class: com.youku.widget.YoukuLoading.1
                @Override // com.airbnb.lottie.LottieDrawable, android.graphics.drawable.Drawable
                public int getIntrinsicHeight() {
                    return super.getIntrinsicHeight();
                }
            };
            try {
                C2821a.C2823b.a(context, "loading_sphere.json", new OnCompositionLoadedListener() { // from class: com.youku.widget.YoukuLoading.2
                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public void onCompositionLoaded(@Nullable C2821a c2821a) {
                        LottieDrawable.this.setComposition(c2821a);
                    }
                });
                lottieDrawable.loop(true);
            } catch (Exception unused) {
            }
            mLottieDrawable = lottieDrawable;
        }
    }

    public static boolean isRunning(Context context, ImageView imageView) {
        LottieDrawable lottieDrawable = mLottieDrawable;
        return (lottieDrawable != null && lottieDrawable.isAnimating()) || context == null || imageView == null;
    }

    public static boolean isShowing() {
        LoadingDialog loadingDialog = mLoadingDialog;
        return loadingDialog != null && loadingDialog.isShowing();
    }

    public static void remove() {
        dismiss();
    }

    public static void show(Context context) {
        if (isShowing() || context == null) {
            return;
        }
        if (!(context instanceof Activity) || YoukuUIUtil.isActivityContextValid((Activity) context)) {
            LoadingDialog loadingDialog = new LoadingDialog(context);
            mLoadingDialog = loadingDialog;
            loadingDialog.setCanceledOnTouchOutside(false);
            mLoadingDialog.show();
        }
    }

    public static void dismiss(Context context, ImageView imageView) {
        ensureLottieDrawable(context);
        if (canDismissed(context, imageView)) {
            mLottieDrawable.pauseAnimation();
        }
    }

    public static void show(Context context, ImageView imageView) {
        ensureLottieDrawable(context);
        if (isRunning(context, imageView)) {
            return;
        }
        imageView.setImageDrawable(mLottieDrawable);
        mLottieDrawable.playAnimation();
    }
}
