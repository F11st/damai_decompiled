package com.taobao.android.dinamicx.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import java.util.ArrayList;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXNativePageIndicator extends LinearLayout {
    private final int IMAGE_VIEW_TYPE;
    private int currentIndex;
    private int itemMargin;
    private int itemRoundDiameter;
    private int itemSelectedBorderColor;
    private int itemSelectedBorderWidth;
    private int itemUnSelectedBorderColor;
    private int itemUnSelectedBorderWidth;
    final a recycledPool;
    private GradientDrawable selectedDrawable;
    private GradientDrawable unselectedDrawable;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class a {
        private SparseArray<ArrayList<View>> a = new SparseArray<>();
        private SparseIntArray b = new SparseIntArray();

        private ArrayList<View> b(int i) {
            ArrayList<View> arrayList = this.a.get(i);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.a.put(i, arrayList);
                if (this.b.indexOfKey(i) < 0) {
                    this.b.put(i, 10);
                }
            }
            return arrayList;
        }

        public View a(int i) {
            ArrayList<View> arrayList = this.a.get(i);
            if (arrayList == null || arrayList.isEmpty()) {
                return null;
            }
            int size = arrayList.size() - 1;
            View view = arrayList.get(size);
            arrayList.remove(size);
            return view;
        }

        public void c(int i, View view) {
            ArrayList<View> b = b(i);
            if (this.b.get(i) <= b.size()) {
                return;
            }
            b.add(view);
        }
    }

    public DXNativePageIndicator(Context context) {
        super(context);
        this.currentIndex = -1;
        this.recycledPool = new a();
        this.IMAGE_VIEW_TYPE = 1;
        init();
    }

    private void init() {
        setOrientation(0);
        setGravity(17);
    }

    private void recycleView(int i) {
        if (i >= super.getChildCount()) {
            return;
        }
        View childAt = super.getChildAt(i);
        super.removeViewAt(i);
        this.recycledPool.c(1, childAt);
    }

    public void addChildViews(int i, int i2) {
        if (i < 0) {
            i = 0;
        }
        if (getChildCount() > i) {
            for (int childCount = getChildCount() - 1; childCount >= i; childCount--) {
                recycleView(childCount);
            }
        }
        int i3 = 0;
        while (i3 < i) {
            ImageView imageView = i3 < getChildCount() ? (ImageView) getChildAt(i3) : null;
            if (imageView == null) {
                imageView = (ImageView) this.recycledPool.a(1);
                if (imageView == null) {
                    imageView = new ImageView(getContext());
                }
                addView(imageView);
            }
            if (i3 == i2) {
                imageView.setImageDrawable(this.selectedDrawable);
                this.currentIndex = i2;
            } else {
                imageView.setImageDrawable(this.unselectedDrawable);
            }
            int i4 = this.itemRoundDiameter;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i4, i4);
            if (i3 != i - 1) {
                layoutParams.rightMargin = this.itemMargin;
            } else {
                layoutParams.rightMargin = 0;
            }
            imageView.setLayoutParams(layoutParams);
            i3++;
        }
    }

    public int getCurrentIndex() {
        return this.currentIndex;
    }

    public int getItemMargin() {
        return this.itemMargin;
    }

    public int getItemRoundDiameter() {
        return this.itemRoundDiameter;
    }

    public int getItemSelectedBorderColor() {
        return this.itemSelectedBorderColor;
    }

    public int getItemSelectedBorderWidth() {
        return this.itemSelectedBorderWidth;
    }

    public int getItemUnSelectedBorderColor() {
        return this.itemUnSelectedBorderColor;
    }

    public int getItemUnSelectedBorderWidth() {
        return this.itemUnSelectedBorderWidth;
    }

    public GradientDrawable getSelectedDrawable() {
        return this.selectedDrawable;
    }

    public GradientDrawable getUnselectedDrawable() {
        return this.unselectedDrawable;
    }

    public void setItemMargin(int i) {
        this.itemMargin = i;
    }

    public void setItemNormal(int i) {
        if (i >= getChildCount()) {
            return;
        }
        ImageView imageView = (ImageView) getChildAt(i);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleY", 0.5f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleX", 0.5f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(50L);
        animatorSet.start();
    }

    public void setItemRoundDiameter(int i) {
        this.itemRoundDiameter = i;
    }

    public void setItemSelectedBorderColor(int i) {
        this.itemSelectedBorderColor = i;
    }

    public void setItemSelectedBorderWidth(int i) {
        this.itemSelectedBorderWidth = i;
    }

    public void setItemSmall(int i) {
        if (i >= getChildCount()) {
            return;
        }
        ImageView imageView = (ImageView) getChildAt(i);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "scaleY", 1.0f, 0.5f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, "scaleX", 1.0f, 0.5f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(50L);
        animatorSet.start();
    }

    public void setItemUnSelectedBorderColor(int i) {
        this.itemUnSelectedBorderColor = i;
    }

    public void setItemUnSelectedBorderWidth(int i) {
        this.itemUnSelectedBorderWidth = i;
    }

    public void setSelectedDrawable(int i) {
        GradientDrawable gradientDrawable = this.selectedDrawable;
        if (gradientDrawable == null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(i);
            int i2 = this.itemRoundDiameter;
            gradientDrawable2.setSize(i2, i2);
            gradientDrawable2.setCornerRadius(this.itemRoundDiameter / 2);
            gradientDrawable2.setStroke(this.itemSelectedBorderWidth, this.itemSelectedBorderColor);
            this.selectedDrawable = gradientDrawable2;
            return;
        }
        gradientDrawable.setColor(i);
    }

    public void setSelectedView(int i) {
        if (this.currentIndex != i && i < getChildCount()) {
            int i2 = this.currentIndex;
            if (i2 != -1) {
                ((ImageView) getChildAt(i2)).setImageDrawable(this.unselectedDrawable);
            }
            ImageView imageView = (ImageView) getChildAt(i);
            if (imageView != null) {
                imageView.setImageDrawable(this.selectedDrawable);
            } else {
                e eVar = new e(r10.DB_NAME);
                e.a aVar = new e.a("Render", "Render_Fltten_Crash", e.DXERROR_RENDER_PAGE_INDICATOR_CRASH_ERROR);
                aVar.e = "this.getChildCount(): " + getChildCount() + " index: " + i + " currentIndex: " + this.currentIndex;
                eVar.c.add(aVar);
                DXAppMonitor.n(eVar);
            }
            this.currentIndex = i;
        }
    }

    public void setUnselectedDrawable(int i) {
        GradientDrawable gradientDrawable = this.unselectedDrawable;
        if (gradientDrawable == null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(1);
            gradientDrawable2.setColor(i);
            int i2 = this.itemRoundDiameter;
            gradientDrawable2.setSize(i2, i2);
            gradientDrawable2.setCornerRadius(this.itemRoundDiameter / 2);
            gradientDrawable2.setStroke(this.itemUnSelectedBorderWidth, this.itemUnSelectedBorderColor);
            this.unselectedDrawable = gradientDrawable2;
            return;
        }
        gradientDrawable.setColor(i);
    }

    public DXNativePageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentIndex = -1;
        this.recycledPool = new a();
        this.IMAGE_VIEW_TYPE = 1;
        init();
    }

    public DXNativePageIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.currentIndex = -1;
        this.recycledPool = new a();
        this.IMAGE_VIEW_TYPE = 1;
        init();
    }
}
