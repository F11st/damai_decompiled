package com.taobao.weex.ui.view.listview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXRecyclerView extends RecyclerView implements WXGestureObservable {
    public static final int TYPE_GRID_LAYOUT = 2;
    public static final int TYPE_LINEAR_LAYOUT = 1;
    public static final int TYPE_STAGGERED_GRID_LAYOUT = 3;
    private boolean hasTouch;
    private WXGesture mGesture;
    private boolean scrollable;

    public WXRecyclerView(Context context) {
        super(context);
        this.scrollable = true;
        this.hasTouch = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.hasTouch = true;
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        WXGesture wXGesture = this.mGesture;
        return wXGesture != null ? dispatchTouchEvent | wXGesture.onTouch(this, motionEvent) : dispatchTouchEvent;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.mGesture;
    }

    public void initView(Context context, int i, int i2) {
        initView(context, i, 1, 32.0f, i2);
    }

    public boolean isScrollable() {
        return this.scrollable;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.scrollable) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(@Nullable WXGesture wXGesture) {
        this.mGesture = wXGesture;
    }

    public void scrollTo(boolean z, int i, final int i2, final int i3) {
        if (!z) {
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(i, -i2);
                return;
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(i, -i2);
                return;
            } else {
                return;
            }
        }
        smoothScrollToPosition(i);
        if (i2 != 0) {
            setOnSmoothScrollEndListener(new ExtendedLinearLayoutManager.OnSmoothScrollEndListener() { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.1
                @Override // com.taobao.weex.ui.view.listview.ExtendedLinearLayoutManager.OnSmoothScrollEndListener
                public void onStop() {
                    WXRecyclerView.this.post(WXThread.secure(new Runnable() { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (i3 == 1) {
                                WXRecyclerView.this.smoothScrollBy(0, i2);
                            } else {
                                WXRecyclerView.this.smoothScrollBy(i2, 0);
                            }
                        }
                    }));
                }
            });
        }
    }

    public void setOnSmoothScrollEndListener(final ExtendedLinearLayoutManager.OnSmoothScrollEndListener onSmoothScrollEndListener) {
        addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.taobao.weex.ui.view.listview.WXRecyclerView.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    recyclerView.removeOnScrollListener(this);
                    ExtendedLinearLayoutManager.OnSmoothScrollEndListener onSmoothScrollEndListener2 = onSmoothScrollEndListener;
                    if (onSmoothScrollEndListener2 != null) {
                        onSmoothScrollEndListener2.onStop();
                    }
                }
            }
        });
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    @TargetApi(16)
    public void initView(Context context, int i, int i2, float f, int i3) {
        if (i == 2) {
            setLayoutManager(new GridLayoutManager(context, i2, i3, false));
        } else if (i == 3) {
            setLayoutManager(new ExtendedStaggeredGridLayoutManager(i2, i3));
        } else if (i == 1) {
            setLayoutManager(new ExtendedLinearLayoutManager(context, i3, false));
        }
    }
}
