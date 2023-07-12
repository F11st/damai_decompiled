package com.taobao.weex.devtools.common.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PointF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.taobao.weex.devtools.common.Predicate;
import com.taobao.weex.devtools.common.Util;
import javax.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ViewUtil {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ViewCompat {
        private static final ViewCompat sInstance;

        /* compiled from: Taobao */
        @TargetApi(11)
        /* loaded from: classes11.dex */
        private static class ViewCompatHoneycomb extends ViewCompat {
            private ViewCompatHoneycomb() {
            }

            @Override // com.taobao.weex.devtools.common.android.ViewUtil.ViewCompat
            public float getAlpha(View view) {
                return view.getAlpha();
            }
        }

        static {
            if (Build.VERSION.SDK_INT >= 11) {
                sInstance = new ViewCompatHoneycomb();
            } else {
                sInstance = new ViewCompat();
            }
        }

        protected ViewCompat() {
        }

        public static ViewCompat getInstance() {
            return sInstance;
        }

        public float getAlpha(View view) {
            return 1.0f;
        }
    }

    private ViewUtil() {
    }

    @Nullable
    public static View hitTest(View view, float f, float f2) {
        return hitTest(view, f, f2, null);
    }

    private static View hitTestImpl(View view, float f, float f2, @Nullable Predicate<View> predicate, boolean z) {
        View hitTestImpl;
        if (isHittable(view) && pointInView(view, f, f2)) {
            if (predicate == null || predicate.apply(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (viewGroup.getChildCount() > 0) {
                        PointF pointF = new PointF();
                        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                            View childAt = viewGroup.getChildAt(childCount);
                            if (isTransformedPointInView(viewGroup, childAt, f, f2, pointF) && (hitTestImpl = hitTestImpl(childAt, pointF.x, pointF.y, predicate, z)) != null) {
                                return hitTestImpl;
                            }
                        }
                    }
                    if (z) {
                        return viewGroup;
                    }
                    return null;
                }
                return view;
            }
            return null;
        }
        return null;
    }

    private static boolean isHittable(View view) {
        return view.getVisibility() == 0 && ViewCompat.getInstance().getAlpha(view) > 0.001f;
    }

    public static boolean isTransformedPointInView(ViewGroup viewGroup, View view, float f, float f2, @Nullable PointF pointF) {
        Util.throwIfNull(viewGroup);
        Util.throwIfNull(view);
        float scrollX = (f + viewGroup.getScrollX()) - view.getLeft();
        float scrollY = (f2 + viewGroup.getScrollY()) - view.getTop();
        boolean pointInView = pointInView(view, scrollX, scrollY);
        if (pointInView && pointF != null) {
            pointF.set(scrollX, scrollY);
        }
        return pointInView;
    }

    public static boolean pointInView(View view, float f, float f2) {
        return f >= 0.0f && f < ((float) (view.getRight() - view.getLeft())) && f2 >= 0.0f && f2 < ((float) (view.getBottom() - view.getTop()));
    }

    @Nullable
    public static Activity tryGetActivity(View view) {
        if (view == null) {
            return null;
        }
        Activity tryGetActivity = tryGetActivity(view.getContext());
        if (tryGetActivity != null) {
            return tryGetActivity;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return tryGetActivity((View) parent);
        }
        return null;
    }

    @Nullable
    public static View hitTest(View view, float f, float f2, @Nullable Predicate<View> predicate) {
        View hitTestImpl = hitTestImpl(view, f, f2, predicate, false);
        return hitTestImpl == null ? hitTestImpl(view, f, f2, predicate, true) : hitTestImpl;
    }

    @Nullable
    private static Activity tryGetActivity(Context context) {
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }
}
