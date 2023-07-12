package com.taobao.weex.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.taobao.weex.common.WXThread;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXScroller;
import com.taobao.weex.ui.view.gesture.WXGesture;
import com.taobao.weex.ui.view.gesture.WXGestureObservable;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXReflectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXScrollView extends ScrollView implements Handler.Callback, NestedScrollingChild, IWXScroller, WXGestureObservable {
    private NestedScrollingChildHelper childHelper;
    private int[] consumed;
    private int mCheckTime;
    private View mCurrentStickyView;
    private boolean mHasNotDoneActionDown;
    private int mInitialPosition;
    private boolean mRedirectTouchToStickyView;
    private Rect mScrollRect;
    private List<WXScrollViewListener> mScrollViewListeners;
    int mScrollX;
    int mScrollY;
    @SuppressLint({"HandlerLeak"})
    private Handler mScrollerTask;
    private int mStickyOffset;
    private int[] mStickyP;
    private WXScroller mWAScroller;
    private int[] offsetInWindow;
    private float ox;
    private float oy;
    private boolean scrollable;
    private int[] stickyScrollerP;
    private int[] stickyViewP;
    private WXGesture wxGesture;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface WXScrollViewListener {
        void onScroll(WXScrollView wXScrollView, int i, int i2);

        void onScrollChanged(WXScrollView wXScrollView, int i, int i2, int i3, int i4);

        void onScrollStopped(WXScrollView wXScrollView, int i, int i2);

        void onScrollToBottom(WXScrollView wXScrollView, int i, int i2);
    }

    public WXScrollView(Context context) {
        super(context);
        this.consumed = new int[2];
        this.offsetInWindow = new int[2];
        this.mHasNotDoneActionDown = true;
        this.mCheckTime = 100;
        this.mStickyP = new int[2];
        this.stickyScrollerP = new int[2];
        this.stickyViewP = new int[2];
        this.scrollable = true;
        this.mScrollViewListeners = new ArrayList();
        init();
        try {
            WXReflectionUtils.setValue(this, "mMinimumVelocity", 5);
        } catch (Exception e) {
            WXLogUtils.e("[WXScrollView] WXScrollView: ", e);
        }
    }

    private void init() {
        setWillNotDraw(false);
        startScrollerTask();
        setOverScrollMode(2);
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        this.childHelper = nestedScrollingChildHelper;
        nestedScrollingChildHelper.setNestedScrollingEnabled(true);
    }

    private View procSticky(Map<String, Map<String, WXComponent>> map) {
        Map<String, WXComponent> map2;
        if (map == null || (map2 = map.get(this.mWAScroller.getRef())) == null) {
            return null;
        }
        for (Map.Entry<String, WXComponent> entry : map2.entrySet()) {
            WXComponent value = entry.getValue();
            getLocationOnScreen(this.stickyScrollerP);
            value.getHostView().getLocationOnScreen(this.stickyViewP);
            int height = (value.getParent() == null || value.getParent().getRealView() == null) ? 0 : value.getParent().getRealView().getHeight();
            int height2 = value.getHostView().getHeight();
            int[] iArr = this.stickyScrollerP;
            int i = iArr[1];
            int i2 = (-height) + iArr[1] + height2;
            int[] iArr2 = this.stickyViewP;
            if (iArr2[1] <= i && iArr2[1] >= i2 - height2) {
                this.mStickyOffset = iArr2[1] - i2;
                value.setStickyOffset(iArr2[1] - iArr[1]);
                return value.getHostView();
            }
            value.setStickyOffset(0);
        }
        return null;
    }

    private void showStickyView() {
        WXScroller wXScroller = this.mWAScroller;
        if (wXScroller == null) {
            return;
        }
        View procSticky = procSticky(wXScroller.getStickMap());
        if (procSticky != null) {
            this.mCurrentStickyView = procSticky;
        } else {
            this.mCurrentStickyView = null;
        }
    }

    public void addScrollViewListener(WXScrollViewListener wXScrollViewListener) {
        if (this.mScrollViewListeners.contains(wXScrollViewListener)) {
            return;
        }
        this.mScrollViewListeners.add(wXScrollViewListener);
    }

    @Override // com.taobao.weex.ui.view.IWXScroller
    public void destroy() {
        Handler handler = this.mScrollerTask;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mCurrentStickyView != null) {
            canvas.save();
            this.mCurrentStickyView.getLocationOnScreen(this.mStickyP);
            int i = this.mStickyOffset;
            if (i > 0) {
                i = 0;
            }
            canvas.translate(this.mStickyP[0], getScrollY() + i);
            canvas.clipRect(0, i, this.mCurrentStickyView.getWidth(), this.mCurrentStickyView.getHeight());
            this.mCurrentStickyView.draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.childHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.childHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.childHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.childHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.mRedirectTouchToStickyView = true;
        }
        if (this.mRedirectTouchToStickyView) {
            boolean z = false;
            boolean z2 = this.mCurrentStickyView != null;
            this.mRedirectTouchToStickyView = z2;
            if (z2) {
                if (motionEvent.getY() <= this.mCurrentStickyView.getHeight() && motionEvent.getX() >= this.mCurrentStickyView.getLeft() && motionEvent.getX() <= this.mCurrentStickyView.getRight()) {
                    z = true;
                }
                this.mRedirectTouchToStickyView = z;
            }
        }
        if (this.mRedirectTouchToStickyView) {
            if (this.mScrollRect == null) {
                Rect rect = new Rect();
                this.mScrollRect = rect;
                getGlobalVisibleRect(rect);
            }
            this.mCurrentStickyView.getLocationOnScreen(this.stickyViewP);
            motionEvent.offsetLocation(0.0f, this.stickyViewP[1] - this.mScrollRect.top);
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        WXGesture wXGesture = this.wxGesture;
        return wXGesture != null ? dispatchTouchEvent | wXGesture.onTouch(this, motionEvent) : dispatchTouchEvent;
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i);
        Handler handler = this.mScrollerTask;
        if (handler != null) {
            handler.removeMessages(0);
        }
        startScrollerTask();
    }

    public Rect getContentFrame() {
        return new Rect(0, 0, computeHorizontalScrollRange(), computeVerticalScrollRange());
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public WXGesture getGestureListener() {
        return this.wxGesture;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return true;
        }
        Handler handler = this.mScrollerTask;
        if (handler != null) {
            handler.removeMessages(0);
        }
        if (this.mInitialPosition - getScrollY() == 0) {
            onScrollStopped(this, getScrollX(), getScrollY());
            return true;
        }
        onScroll(this, getScrollX(), getScrollY());
        this.mInitialPosition = getScrollY();
        Handler handler2 = this.mScrollerTask;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(0, this.mCheckTime);
            return true;
        }
        return true;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.childHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.childHelper.isNestedScrollingEnabled();
    }

    public boolean isScrollable() {
        return this.scrollable;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    protected void onScroll(WXScrollView wXScrollView, int i, int i2) {
        List<WXScrollViewListener> list = this.mScrollViewListeners;
        int size = list == null ? 0 : list.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mScrollViewListeners.get(i3).onScroll(this, i, i2);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        this.mScrollX = getScrollX();
        int scrollY = getScrollY();
        this.mScrollY = scrollY;
        onScroll(this, this.mScrollX, scrollY);
        View childAt = getChildAt(getChildCount() - 1);
        if (childAt == null) {
            return;
        }
        int bottom = childAt.getBottom();
        int height = getHeight();
        int i5 = this.mScrollY;
        if (bottom - (height + i5) == 0) {
            onScrollToBottom(this.mScrollX, i5);
        }
        List<WXScrollViewListener> list = this.mScrollViewListeners;
        int size = list == null ? 0 : list.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.mScrollViewListeners.get(i6).onScrollChanged(this, i, i2, i3, i4);
        }
        showStickyView();
    }

    protected void onScrollStopped(WXScrollView wXScrollView, int i, int i2) {
        List<WXScrollViewListener> list = this.mScrollViewListeners;
        int size = list == null ? 0 : list.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mScrollViewListeners.get(i3).onScrollStopped(this, i, i2);
        }
    }

    protected void onScrollToBottom(int i, int i2) {
        List<WXScrollViewListener> list = this.mScrollViewListeners;
        int size = list == null ? 0 : list.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mScrollViewListeners.get(i3).onScrollToBottom(this, i, i2);
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.scrollable) {
            if (this.mRedirectTouchToStickyView) {
                if (this.mScrollRect == null) {
                    Rect rect = new Rect();
                    this.mScrollRect = rect;
                    getGlobalVisibleRect(rect);
                }
                this.mCurrentStickyView.getLocationOnScreen(this.stickyViewP);
                motionEvent.offsetLocation(0.0f, -(this.stickyViewP[1] - this.mScrollRect.top));
            }
            if (motionEvent.getAction() == 0) {
                this.mHasNotDoneActionDown = false;
            }
            if (this.mHasNotDoneActionDown) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(0);
                this.mHasNotDoneActionDown = false;
                obtain.recycle();
            }
            if (motionEvent.getAction() == 0) {
                this.ox = motionEvent.getX();
                this.oy = motionEvent.getY();
                startNestedScroll(3);
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.mHasNotDoneActionDown = true;
                stopNestedScroll();
            }
            if (motionEvent.getAction() == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (dispatchNestedPreScroll((int) (this.ox - x), (int) (this.oy - y), this.consumed, this.offsetInWindow)) {
                    int[] iArr = this.consumed;
                    motionEvent.setLocation(x + iArr[0], y + iArr[1]);
                }
                this.ox = motionEvent.getX();
                this.oy = motionEvent.getY();
            }
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // com.taobao.weex.ui.view.gesture.WXGestureObservable
    public void registerGestureListener(WXGesture wXGesture) {
        this.wxGesture = wXGesture;
    }

    public void removeScrollViewListener(WXScrollViewListener wXScrollViewListener) {
        this.mScrollViewListeners.remove(wXScrollViewListener);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.childHelper.setNestedScrollingEnabled(z);
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    public void setWAScroller(WXScroller wXScroller) {
        this.mWAScroller = wXScroller;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.childHelper.startNestedScroll(i);
    }

    public void startScrollerTask() {
        if (this.mScrollerTask == null) {
            this.mScrollerTask = new Handler(WXThread.secure(this));
        }
        this.mInitialPosition = getScrollY();
        this.mScrollerTask.sendEmptyMessageDelayed(0, this.mCheckTime);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.childHelper.stopNestedScroll();
    }

    public WXScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.consumed = new int[2];
        this.offsetInWindow = new int[2];
        this.mHasNotDoneActionDown = true;
        this.mCheckTime = 100;
        this.mStickyP = new int[2];
        this.stickyScrollerP = new int[2];
        this.stickyViewP = new int[2];
        this.scrollable = true;
        init();
    }

    public WXScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.consumed = new int[2];
        this.offsetInWindow = new int[2];
        this.mHasNotDoneActionDown = true;
        this.mCheckTime = 100;
        this.mStickyP = new int[2];
        this.stickyScrollerP = new int[2];
        this.stickyViewP = new int[2];
        this.scrollable = true;
        setOverScrollMode(2);
    }
}
