package com.alibaba.poplayer.layermanager.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tb.dt1;
import tb.fw2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MirrorLayer extends View {
    private final Rect mHitRect;
    private final int[] mLocation;
    private boolean mNeedUpdateCache;
    private final Paint mPaint;
    private boolean mRealTime;
    private SandoContainer mSandoContainer;
    private final List<b> mSourceViewInfos;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class b {
        private static final int[] f = new int[2];
        private final WeakReference<View> a;
        private int b;
        private int c;
        private int d;
        float e;

        static /* synthetic */ int c(b bVar) {
            int i = bVar.d;
            bVar.d = i + 1;
            return i;
        }

        static /* synthetic */ int d(b bVar) {
            int i = bVar.d;
            bVar.d = i - 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f() {
            View view = (View) fw2.c(this.a);
            boolean z = true;
            if (view == null) {
                return true;
            }
            int[] iArr = f;
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            if (i == this.b && i2 == this.c) {
                z = false;
            }
            this.b = i;
            this.c = i2;
            return z;
        }

        private b(View view) {
            this.b = Integer.MAX_VALUE;
            this.c = Integer.MAX_VALUE;
            this.d = 1;
            this.e = 1.0f;
            this.a = new WeakReference<>(view);
        }
    }

    public MirrorLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSourceViewInfos = new ArrayList();
        this.mLocation = new int[2];
        this.mPaint = new Paint();
        this.mNeedUpdateCache = true;
        this.mHitRect = new Rect();
    }

    private b findSourceViewInfoByView(View view) {
        for (b bVar : this.mSourceViewInfos) {
            if (view == fw2.c(bVar.a)) {
                return bVar;
            }
        }
        return null;
    }

    private boolean isSourceViewsDirty() {
        for (b bVar : this.mSourceViewInfos) {
            View view = (View) fw2.c(bVar.a);
            if (view != null && view.getVisibility() == 0) {
                if (view.getAlpha() != bVar.e) {
                    return true;
                }
                if (view.isDirty() && bVar.f()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void addMirrorView(boolean z, View... viewArr) {
        for (View view : viewArr) {
            b findSourceViewInfoByView = findSourceViewInfoByView(view);
            if (findSourceViewInfoByView == null) {
                this.mSourceViewInfos.add(new b(view));
                this.mSandoContainer.startPreDrawListenerIfNeed();
            } else {
                b.c(findSourceViewInfoByView);
            }
        }
        this.mRealTime = z | this.mRealTime;
        invalidate();
    }

    @Override // android.view.View
    public Bitmap getDrawingCache() {
        if (!this.mNeedUpdateCache) {
            return super.getDrawingCache();
        }
        destroyDrawingCache();
        buildDrawingCache();
        this.mNeedUpdateCache = false;
        return super.getDrawingCache();
    }

    public boolean hitMirrorView(float f, float f2) {
        if (getVisibility() == 0 && !this.mSourceViewInfos.isEmpty()) {
            for (b bVar : this.mSourceViewInfos) {
                ((View) fw2.c(bVar.a)).getHitRect(this.mHitRect);
                if (this.mHitRect.contains((int) f, (int) f2)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDraw(android.graphics.Canvas canvas) {
        try {
            canvas.drawColor(1);
            int size = this.mSourceViewInfos.size();
            for (int i = 0; i < size; i++) {
                b bVar = this.mSourceViewInfos.get(i);
                View view = (View) fw2.c(bVar.a);
                if (view == null) {
                    this.mSourceViewInfos.remove(bVar);
                } else {
                    view.destroyDrawingCache();
                    view.buildDrawingCache();
                    Bitmap drawingCache = view.getDrawingCache();
                    view.getLocationOnScreen(this.mLocation);
                    float alpha = view.getAlpha();
                    bVar.e = alpha;
                    this.mPaint.setAlpha((int) (alpha * 255.0f));
                    int[] iArr = new int[2];
                    getLocationOnScreen(iArr);
                    int[] iArr2 = this.mLocation;
                    canvas.drawBitmap(drawingCache, iArr2[0] - iArr[0], iArr2[1] - iArr[1], this.mPaint);
                    this.mNeedUpdateCache = true;
                }
            }
        } catch (Throwable th) {
            dt1.c("MirrorLayer.onDraw.error", th);
        }
    }

    public void removeMirrorView(View... viewArr) {
        for (View view : viewArr) {
            b findSourceViewInfoByView = findSourceViewInfoByView(view);
            if (findSourceViewInfoByView != null) {
                b.d(findSourceViewInfoByView);
                if (findSourceViewInfoByView.d <= 0) {
                    this.mSourceViewInfos.remove(findSourceViewInfoByView);
                }
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSandoContainer(SandoContainer sandoContainer) {
        this.mSandoContainer = sandoContainer;
    }

    public int size() {
        return this.mSourceViewInfos.size();
    }

    public void updateMirrorViewsIfNeed() {
        if (isSourceViewsDirty() || this.mRealTime) {
            invalidate();
        }
    }

    public MirrorLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSourceViewInfos = new ArrayList();
        this.mLocation = new int[2];
        this.mPaint = new Paint();
        this.mNeedUpdateCache = true;
        this.mHitRect = new Rect();
    }

    public MirrorLayer(Context context) {
        super(context);
        this.mSourceViewInfos = new ArrayList();
        this.mLocation = new int[2];
        this.mPaint = new Paint();
        this.mNeedUpdateCache = true;
        this.mHitRect = new Rect();
    }
}
