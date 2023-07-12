package com.alibaba.poplayer.layermanager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.alibaba.poplayer.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import tb.dt1;
import tb.fw2;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AugmentedLayer extends AbsoluteLayout {
    public static final String TAG = AugmentedLayer.class.getSimpleName();
    private final Set<Canvas> mOperateRecords;
    private SandoContainer mSandoContainer;
    private final int[] mTmpLocation;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.layermanager.view.AugmentedLayer$b */
    /* loaded from: classes8.dex */
    public static class C3667b {
        private final WeakReference<View> a;

        private C3667b(View view) {
            this.a = new WeakReference<>(view);
        }
    }

    public AugmentedLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mOperateRecords = new HashSet();
        this.mTmpLocation = new int[2];
    }

    private void bindTargetView(View view, Canvas canvas) {
        view.getLocationOnScreen(this.mTmpLocation);
        canvas.setTag(R$id.poplayer_augmentedview_record_tag_id, new C3667b(view));
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        dt1.b("AugmentedLayer: myLocation[0] = " + iArr[0] + " myLocation[1] = " + iArr[1], new Object[0]);
        int width = view.getWidth();
        int height = view.getHeight();
        int[] iArr2 = this.mTmpLocation;
        addView(canvas, new AbsoluteLayout.LayoutParams(width, height, iArr2[0] - iArr[0], iArr2[1] - iArr[1]));
    }

    private boolean isNeedUpdateLayoutParams(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        return (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) ? false : true;
    }

    public void augmentTargetView(View view, Canvas canvas) {
        if (canvas == null || this.mOperateRecords.contains(canvas)) {
            return;
        }
        bindTargetView(view, canvas);
        this.mOperateRecords.add(canvas);
        this.mSandoContainer.startPreDrawListenerIfNeed();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mSandoContainer.getMirrorLayer().hitMirrorView(motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (R$id.poplayer_view == view.getId()) {
            super.removeView(view);
            return;
        }
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).setLayoutTransition(null);
        }
        super.removeView(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSandoContainer(SandoContainer sandoContainer) {
        this.mSandoContainer = sandoContainer;
    }

    public void unaugmentTarget(Canvas canvas) {
        if (this.mOperateRecords.contains(canvas)) {
            this.mOperateRecords.remove(canvas);
            removeView(canvas);
        }
    }

    public void updateAugmentedViews() {
        int[] iArr;
        int childCount = getChildCount();
        ArrayList<Canvas> arrayList = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof Canvas) {
                Canvas canvas = (Canvas) childAt;
                View view = (View) fw2.c(((C3667b) canvas.getTag(R$id.poplayer_augmentedview_record_tag_id)).a);
                if (!((view != null && view.getVisibility() == 0 && fw2.g(view) && fw2.f(view)) ? false : true)) {
                    view.getLocationOnScreen(this.mTmpLocation);
                    int x = (int) canvas.getX();
                    int y = (int) canvas.getY();
                    int width = canvas.getWidth();
                    int height = canvas.getHeight();
                    int[] iArr2 = this.mTmpLocation;
                    if (isNeedUpdateLayoutParams(x, y, width, height, iArr2[0], iArr2[1], view.getWidth(), view.getHeight())) {
                        getLocationOnScreen(new int[2]);
                        canvas.setX(this.mTmpLocation[0] - iArr[0]);
                        canvas.setY(this.mTmpLocation[1] - iArr[1]);
                        canvas.setRight(canvas.getLeft() + view.getWidth());
                        canvas.setBottom(canvas.getTop() + view.getHeight());
                    }
                } else if (view == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(canvas);
                } else {
                    canvas.setX(-10000.0f);
                    canvas.setY(-10000.0f);
                }
            }
        }
        if (arrayList == null) {
            return;
        }
        for (Canvas canvas2 : arrayList) {
            unaugmentTarget(canvas2);
        }
    }

    public AugmentedLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOperateRecords = new HashSet();
        this.mTmpLocation = new int[2];
    }

    public AugmentedLayer(Context context) {
        super(context);
        this.mOperateRecords = new HashSet();
        this.mTmpLocation = new int[2];
    }
}
