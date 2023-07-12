package com.taobao.weex.devtools.inspector.elements.android;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.taobao.weex.devtools.common.LogUtil;
import com.taobao.weex.devtools.common.Util;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class ViewHighlighter {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static final class NoopHighlighter extends ViewHighlighter {
        private NoopHighlighter() {
        }

        @Override // com.taobao.weex.devtools.inspector.elements.android.ViewHighlighter
        public void clearHighlight() {
        }

        @Override // com.taobao.weex.devtools.inspector.elements.android.ViewHighlighter
        public void setHighlightedView(View view, int i) {
        }
    }

    /* compiled from: Taobao */
    @TargetApi(18)
    /* loaded from: classes11.dex */
    private static final class OverlayHighlighter extends ViewHighlighter {
        private View mHighlightedView;
        private final ViewHighlightOverlays mHighlightOverlays = ViewHighlightOverlays.newInstance();
        private AtomicReference<View> mViewToHighlight = new AtomicReference<>();
        private AtomicInteger mContentColor = new AtomicInteger();
        private final Runnable mHighlightViewOnUiThreadRunnable = new Runnable() { // from class: com.taobao.weex.devtools.inspector.elements.android.ViewHighlighter.OverlayHighlighter.1
            @Override // java.lang.Runnable
            public void run() {
                OverlayHighlighter.this.highlightViewOnUiThread();
            }
        };
        private final Handler mHandler = new Handler(Looper.getMainLooper());

        /* JADX INFO: Access modifiers changed from: private */
        public void highlightViewOnUiThread() {
            View andSet = this.mViewToHighlight.getAndSet(null);
            View view = this.mHighlightedView;
            if (andSet == view) {
                return;
            }
            if (view != null) {
                this.mHighlightOverlays.removeHighlight(view);
            }
            if (andSet != null) {
                this.mHighlightOverlays.highlightView(andSet, this.mContentColor.get());
            }
            this.mHighlightedView = andSet;
        }

        private void setHighlightedViewImpl(@Nullable View view, int i) {
            this.mHandler.removeCallbacks(this.mHighlightViewOnUiThreadRunnable);
            this.mViewToHighlight.set(view);
            this.mContentColor.set(i);
            this.mHandler.postDelayed(this.mHighlightViewOnUiThreadRunnable, 100L);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.android.ViewHighlighter
        public void clearHighlight() {
            setHighlightedViewImpl(null, 0);
        }

        @Override // com.taobao.weex.devtools.inspector.elements.android.ViewHighlighter
        public void setHighlightedView(View view, int i) {
            setHighlightedViewImpl((View) Util.throwIfNull(view), i);
        }
    }

    protected ViewHighlighter() {
    }

    public static ViewHighlighter newInstance() {
        if (Build.VERSION.SDK_INT >= 18) {
            return new OverlayHighlighter();
        }
        LogUtil.w("Running on pre-JBMR2: View highlighting is not supported");
        return new NoopHighlighter();
    }

    public abstract void clearHighlight();

    public abstract void setHighlightedView(View view, int i);
}
