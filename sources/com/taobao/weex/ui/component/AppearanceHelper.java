package com.taobao.weex.ui.component;

import android.graphics.Rect;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AppearanceHelper {
    public static final int APPEAR = 0;
    public static final int DISAPPEAR = 1;
    public static final int RESULT_APPEAR = 1;
    public static final int RESULT_DISAPPEAR = -1;
    public static final int RESULT_NO_CHANGE = 0;
    private boolean mAppearStatus;
    private final WXComponent mAwareChild;
    private int mCellPositionInScrollable;
    private Rect mVisibleRect;
    private boolean[] mWatchFlags;

    public AppearanceHelper(WXComponent wXComponent) {
        this(wXComponent, 0);
    }

    public WXComponent getAwareChild() {
        return this.mAwareChild;
    }

    public int getCellPositionINScollable() {
        return this.mCellPositionInScrollable;
    }

    public boolean isAppear() {
        return this.mAppearStatus;
    }

    public boolean isViewVisible(boolean z) {
        View hostView = this.mAwareChild.getHostView();
        if (z && hostView.getVisibility() == 0 && hostView.getMeasuredHeight() == 0) {
            return true;
        }
        return hostView != null && hostView.getLocalVisibleRect(this.mVisibleRect);
    }

    public boolean isWatch() {
        boolean[] zArr = this.mWatchFlags;
        return zArr[0] || zArr[1];
    }

    public int setAppearStatus(boolean z) {
        if (this.mAppearStatus != z) {
            this.mAppearStatus = z;
            return z ? 1 : -1;
        }
        return 0;
    }

    public void setCellPosition(int i) {
        this.mCellPositionInScrollable = i;
    }

    public void setWatchEvent(int i, boolean z) {
        this.mWatchFlags[i] = z;
    }

    public AppearanceHelper(WXComponent wXComponent, int i) {
        this.mAppearStatus = false;
        this.mWatchFlags = new boolean[]{false, false};
        this.mVisibleRect = new Rect();
        this.mAwareChild = wXComponent;
        this.mCellPositionInScrollable = i;
    }

    public boolean isViewVisible(View view) {
        return (view.getVisibility() == 0 && view.getMeasuredHeight() == 0) || view.getLocalVisibleRect(this.mVisibleRect);
    }
}
