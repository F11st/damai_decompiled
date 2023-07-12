package com.taobao.weex.ui.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.ui.ComponentCreator;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.view.BaseFrameLayout;
import com.taobao.weex.ui.view.WXCircleIndicator;
import com.taobao.weex.ui.view.WXCirclePageAdapter;
import com.taobao.weex.ui.view.WXCircleViewPager;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXSliderNeighbor extends WXSlider {
    public static final String CURRENT_ITEM_SCALE = "currentItemScale";
    private static final float DEFAULT_CURRENT_ITEM_SCALE = 0.9f;
    private static final float DEFAULT_NEIGHBOR_ALPHA = 0.6f;
    private static final float DEFAULT_NEIGHBOR_SCALE = 0.8f;
    private static final int DEFAULT_NEIGHBOR_SPACE = 25;
    public static final String NEIGHBOR_ALPHA = "neighborAlpha";
    public static final String NEIGHBOR_SCALE = "neighborScale";
    public static final String NEIGHBOR_SPACE = "neighborSpace";
    private ZoomTransformer mCachedTransformer;
    private float mCurrentItemScale;
    private float mNeighborAlpha;
    private float mNeighborScale;
    private float mNeighborSpace;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Creator implements ComponentCreator {
        @Override // com.taobao.weex.ui.ComponentCreator
        public WXComponent createInstance(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            return new WXSliderNeighbor(wXSDKInstance, wXVContainer, basicComponentData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class ZoomTransformer implements ViewPager.PageTransformer {
        ZoomTransformer() {
        }

        @Override // androidx.viewpager.widget.ViewPager.PageTransformer
        public void transformPage(View view, float f) {
            View childAt;
            int pagePosition = WXSliderNeighbor.this.mAdapter.getPagePosition(view);
            int currentItem = WXSliderNeighbor.this.mViewPager.getCurrentItem();
            int realCount = WXSliderNeighbor.this.mAdapter.getRealCount();
            boolean z = (currentItem == 0 || currentItem == realCount + (-1) || Math.abs(pagePosition - currentItem) <= 1) ? false : true;
            if (currentItem == 0 && pagePosition < realCount - 1 && pagePosition > 1) {
                z = true;
            }
            int i = realCount - 1;
            if (currentItem == i && pagePosition < realCount - 2 && pagePosition > 0) {
                z = true;
            }
            if (z || (childAt = ((ViewGroup) view).getChildAt(0)) == null) {
                return;
            }
            if (f <= (-realCount) + 1) {
                f += realCount;
            }
            if (f >= i) {
                f -= realCount;
            }
            if (f < -1.0f || f > 1.0f) {
                return;
            }
            float abs = Math.abs(Math.abs(f) - 1.0f);
            float f2 = WXSliderNeighbor.this.mNeighborScale + ((WXSliderNeighbor.this.mCurrentItemScale - WXSliderNeighbor.this.mNeighborScale) * abs);
            float f3 = ((1.0f - WXSliderNeighbor.this.mNeighborAlpha) * abs) + WXSliderNeighbor.this.mNeighborAlpha;
            float calculateTranslation = WXSliderNeighbor.this.calculateTranslation(view);
            int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i2 > 0) {
                float f4 = -(f * calculateTranslation);
                childAt.setTranslationX(f4);
                view.setTranslationX(f4);
            } else if (i2 == 0) {
                view.setTranslationX(0.0f);
                childAt.setTranslationX(0.0f);
                WXSliderNeighbor wXSliderNeighbor = WXSliderNeighbor.this;
                wXSliderNeighbor.updateAdapterScaleAndAlpha(wXSliderNeighbor.mNeighborAlpha, WXSliderNeighbor.this.mNeighborScale);
            } else if (realCount == 2 && Math.abs(f) == 1.0f) {
                return;
            } else {
                float f5 = (-f) * calculateTranslation;
                childAt.setTranslationX(f5);
                view.setTranslationX(f5);
            }
            childAt.setScaleX(f2);
            childAt.setScaleY(f2);
            childAt.setAlpha(f3);
        }
    }

    public WXSliderNeighbor(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.mNeighborScale = 0.8f;
        this.mNeighborAlpha = 0.6f;
        this.mNeighborSpace = 25.0f;
        this.mCurrentItemScale = 0.9f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateTranslation(@NonNull View view) {
        if (view instanceof ViewGroup) {
            View childAt = ((ViewGroup) view).getChildAt(0);
            return ((view.getMeasuredWidth() - (childAt.getMeasuredWidth() * this.mNeighborScale)) / 4.0f) + ((((view.getMeasuredWidth() - (childAt.getMeasuredWidth() * this.mCurrentItemScale)) / 2.0f) - WXViewUtils.getRealPxByWidth(this.mNeighborSpace, getInstance().getInstanceViewPortWidth())) / 2.0f);
        }
        return 0.0f;
    }

    private void moveLeft(View view, float f, float f2, float f3) {
        updateScaleAndAlpha(((ViewGroup) view).getChildAt(0), f2, f3);
        view.setTranslationX(f);
        ((ViewGroup) view).getChildAt(0).setTranslationX(f);
    }

    private void moveRight(View view, float f, float f2, float f3) {
        moveLeft(view, -f, f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAdapterScaleAndAlpha(final float f, final float f2) {
        List<View> views = this.mAdapter.getViews();
        int currentItem = this.mViewPager.getCurrentItem();
        if (views.size() > 0) {
            final View view = views.get(currentItem);
            updateScaleAndAlpha(((ViewGroup) view).getChildAt(0), 1.0f, this.mCurrentItemScale);
            if (views.size() < 2) {
                return;
            }
            view.postDelayed(WXThread.secure(new Runnable() { // from class: com.taobao.weex.ui.component.WXSliderNeighbor.2
                @Override // java.lang.Runnable
                public void run() {
                    WXSliderNeighbor.this.updateNeighbor(view, f, f2);
                }
            }), 17L);
            int size = currentItem == 0 ? views.size() - 1 : currentItem - 1;
            int i = currentItem == views.size() + (-1) ? 0 : currentItem + 1;
            for (int i2 = 0; i2 < this.mAdapter.getRealCount(); i2++) {
                if (i2 != size && i2 != currentItem && i2 != i) {
                    ((ViewGroup) views.get(i2)).getChildAt(0).setAlpha(0.0f);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNeighbor(View view, float f, float f2) {
        List<View> views = this.mAdapter.getViews();
        int currentItem = this.mViewPager.getCurrentItem();
        float calculateTranslation = calculateTranslation(view);
        View view2 = views.get(currentItem == 0 ? views.size() - 1 : currentItem - 1);
        View view3 = views.get(currentItem == views.size() - 1 ? 0 : currentItem + 1);
        if (views.size() != 2) {
            moveLeft(view2, calculateTranslation, f, f2);
            moveRight(view3, calculateTranslation, f, f2);
        } else if (currentItem == 0) {
            moveRight(view3, calculateTranslation, f, f2);
        } else if (currentItem == 1) {
            moveLeft(view2, calculateTranslation, f, f2);
        }
    }

    private void updateScaleAndAlpha(View view, float f, float f2) {
        if (view == null) {
            return;
        }
        if (f >= 0.0f && view.getAlpha() != f) {
            view.setAlpha(f);
        }
        if (f2 < 0.0f || view.getScaleX() == f2) {
            return;
        }
        view.setScaleX(f2);
        view.setScaleY(f2);
    }

    @Override // com.taobao.weex.ui.component.WXSlider, com.taobao.weex.ui.component.WXVContainer
    public void addSubView(View view, final int i) {
        if (view == null || this.mAdapter == null || (view instanceof WXCircleIndicator)) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        view.setLayoutParams(layoutParams);
        frameLayout.addView(view);
        super.addSubView(frameLayout, i);
        updateAdapterScaleAndAlpha(this.mNeighborAlpha, this.mNeighborScale);
        this.mViewPager.postDelayed(WXThread.secure(new Runnable() { // from class: com.taobao.weex.ui.component.WXSliderNeighbor.1
            @Override // java.lang.Runnable
            public void run() {
                WXSliderNeighbor wXSliderNeighbor;
                try {
                    try {
                        if (WXSliderNeighbor.this.mViewPager.getRealCount() > 0 && i > 2) {
                            WXSliderNeighbor.this.mViewPager.beginFakeDrag();
                            WXSliderNeighbor.this.mViewPager.fakeDragBy(1.0f);
                        }
                        wXSliderNeighbor = WXSliderNeighbor.this;
                    } catch (IndexOutOfBoundsException unused) {
                        wXSliderNeighbor = WXSliderNeighbor.this;
                    } catch (Throwable th) {
                        try {
                            WXSliderNeighbor.this.mViewPager.endFakeDrag();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                    wXSliderNeighbor.mViewPager.endFakeDrag();
                } catch (Exception unused3) {
                }
            }
        }), 50L);
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void bindData(WXComponent wXComponent) {
        super.bindData(wXComponent);
    }

    ZoomTransformer createTransformer() {
        if (this.mCachedTransformer == null) {
            this.mCachedTransformer = new ZoomTransformer();
        }
        return this.mCachedTransformer;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.ui.component.WXSliderNeighbor.CURRENT_ITEM_SCALE)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setCurrentItemScale(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto Lb
            float r2 = java.lang.Float.parseFloat(r2)     // Catch: java.lang.NumberFormatException -> Lb
            goto Le
        Lb:
            r2 = 1063675494(0x3f666666, float:0.9)
        Le:
            float r0 = r1.mCurrentItemScale
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L1b
            r1.mCurrentItemScale = r2
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.updateAdapterScaleAndAlpha(r2, r2)
        L1b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.ui.component.WXSliderNeighbor.setCurrentItemScale(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.ui.component.WXSliderNeighbor.NEIGHBOR_ALPHA)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setNeighborAlpha(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto Lb
            float r2 = java.lang.Float.parseFloat(r2)     // Catch: java.lang.NumberFormatException -> Lb
            goto Le
        Lb:
            r2 = 1058642330(0x3f19999a, float:0.6)
        Le:
            float r0 = r1.mNeighborAlpha
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L1b
            r1.mNeighborAlpha = r2
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.updateAdapterScaleAndAlpha(r2, r0)
        L1b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.ui.component.WXSliderNeighbor.setNeighborAlpha(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.ui.component.WXSliderNeighbor.NEIGHBOR_SCALE)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setNeighborScale(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto Lb
            float r2 = java.lang.Float.parseFloat(r2)     // Catch: java.lang.NumberFormatException -> Lb
            goto Le
        Lb:
            r2 = 1061997773(0x3f4ccccd, float:0.8)
        Le:
            float r0 = r1.mNeighborScale
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L1b
            r1.mNeighborScale = r2
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1.updateAdapterScaleAndAlpha(r0, r2)
        L1b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.ui.component.WXSliderNeighbor.setNeighborScale(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @com.taobao.weex.ui.component.WXComponentProp(name = com.taobao.weex.ui.component.WXSliderNeighbor.NEIGHBOR_SPACE)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setNeighborSpace(java.lang.String r2) {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto Lb
            float r2 = java.lang.Float.parseFloat(r2)     // Catch: java.lang.NumberFormatException -> Lb
            goto Ld
        Lb:
            r2 = 1103626240(0x41c80000, float:25.0)
        Ld:
            float r0 = r1.mNeighborSpace
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L15
            r1.mNeighborSpace = r2
        L15:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.ui.component.WXSliderNeighbor.setNeighborSpace(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXSlider, com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1763701364:
                if (str.equals(NEIGHBOR_ALPHA)) {
                    c = 0;
                    break;
                }
                break;
            case -1747360392:
                if (str.equals(NEIGHBOR_SCALE)) {
                    c = 1;
                    break;
                }
                break;
            case -1746973388:
                if (str.equals(NEIGHBOR_SPACE)) {
                    c = 2;
                    break;
                }
                break;
            case -1013904258:
                if (str.equals(CURRENT_ITEM_SCALE)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                String string = WXUtils.getString(obj, null);
                if (string != null) {
                    setNeighborAlpha(string);
                }
                return true;
            case 1:
                String string2 = WXUtils.getString(obj, null);
                if (string2 != null) {
                    setNeighborScale(string2);
                }
                return true;
            case 2:
                String string3 = WXUtils.getString(obj, null);
                if (string3 != null) {
                    setNeighborSpace(string3);
                }
                return true;
            case 3:
                String string4 = WXUtils.getString(obj, null);
                if (string4 != null) {
                    setCurrentItemScale(string4);
                }
                return true;
            default:
                return super.setProperty(str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXSlider, com.taobao.weex.ui.component.WXComponent
    public BaseFrameLayout initComponentHostView(@NonNull Context context) {
        BaseFrameLayout baseFrameLayout = new BaseFrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        WXCircleViewPager wXCircleViewPager = new WXCircleViewPager(getContext());
        this.mViewPager = wXCircleViewPager;
        wXCircleViewPager.setLayoutParams(layoutParams);
        WXCirclePageAdapter wXCirclePageAdapter = new WXCirclePageAdapter();
        this.mAdapter = wXCirclePageAdapter;
        this.mViewPager.setAdapter(wXCirclePageAdapter);
        baseFrameLayout.addView(this.mViewPager);
        this.mViewPager.addOnPageChangeListener(this.mPageChangeListener);
        this.mViewPager.setOverScrollMode(2);
        registerActivityStateListener();
        this.mViewPager.setPageTransformer(false, createTransformer());
        return baseFrameLayout;
    }
}
