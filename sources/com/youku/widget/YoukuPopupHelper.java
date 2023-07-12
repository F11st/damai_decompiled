package com.youku.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* compiled from: Taobao */
@TargetApi(4)
/* loaded from: classes3.dex */
public final class YoukuPopupHelper {
    public static final void fixPopupWindow(final PopupWindow popupWindow) {
        if (Build.VERSION.SDK_INT < 14) {
            try {
                final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
                declaredField.setAccessible(true);
                Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
                declaredField2.setAccessible(true);
                final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = (ViewTreeObserver.OnScrollChangedListener) declaredField2.get(popupWindow);
                declaredField2.set(popupWindow, new ViewTreeObserver.OnScrollChangedListener() { // from class: com.youku.widget.YoukuPopupHelper.2
                    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                    public void onScrollChanged() {
                        try {
                            WeakReference weakReference = (WeakReference) WeakReference.class.cast(declaredField.get(popupWindow));
                            if ((weakReference != null ? weakReference.get() : null) == null) {
                                return;
                            }
                            onScrollChangedListener.onScrollChanged();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }

    public static final int getGravity(View view) {
        return getGravity(view, (view.getRootView().getMeasuredWidth() * 2) / 5);
    }

    public static final int[] getPopupPosition(View view, int i) {
        int[] iArr = new int[2];
        int measuredWidth = view.getRootView().getMeasuredWidth();
        int measuredHeight = view.getRootView().getMeasuredHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        if (3 == (i & 3)) {
            iArr[0] = iArr2[0];
        } else if (5 == (i & 5)) {
            iArr[0] = (measuredWidth - iArr2[0]) - measuredWidth2;
        }
        if (48 == (i & 48)) {
            iArr[1] = iArr2[1] + measuredHeight2;
        } else if (80 == (i & 80)) {
            iArr[1] = measuredHeight - iArr2[1];
        }
        return iArr;
    }

    public static final PopupWindow newPopInstance(Context context) {
        return newPopInstance(context, -2, -2);
    }

    public static final PopupWindow newPopInstance(Context context, int i, int i2) {
        final PopupWindow popupWindow = new PopupWindow(context);
        fixPopupWindow(popupWindow);
        popupWindow.setWidth(i);
        popupWindow.setHeight(i2);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(16973826);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.youku.widget.YoukuPopupHelper.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 4) {
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });
        return popupWindow;
    }

    @TargetApi(14)
    public static final int getGravity(View view, int i) {
        int measuredHeight = view.getRootView().getMeasuredHeight();
        int measuredWidth = ((View) view.getParent()).getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        int left = view.getLeft();
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = (left <= measuredWidth / 2 || i2 + measuredWidth2 <= i) ? 3 : 5;
        int i5 = i3 + measuredHeight2 > measuredHeight / 2 ? i4 | 80 : i4 | 48;
        return Build.VERSION.SDK_INT >= 14 ? i5 | 8388608 : i5;
    }
}
