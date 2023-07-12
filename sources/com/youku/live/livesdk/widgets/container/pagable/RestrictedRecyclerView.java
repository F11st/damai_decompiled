package com.youku.live.livesdk.widgets.container.pagable;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RestrictedRecyclerView extends RecyclerView {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final long DEFAULT_SCROLL_DELAYED = 500;
    private static final String LOG_TAG = "PagableRecyclerView";
    private Runnable mEnableScrollRunnable;
    private boolean mEnableScrolling;
    private Handler mHandler;
    private float mInitedScrollX;
    private float mInitedScrollY;
    private RecyclerView.OnScrollListener mInnerScrollListener;
    private long mScrollDelayed;
    private boolean mSliding;
    private float mTouchDownX;
    private float mTouchDownY;

    public RestrictedRecyclerView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View findChildViewUnder;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-285945571")) {
            return ((Boolean) ipChange.ipc$dispatch("-285945571", new Object[]{this, motionEvent})).booleanValue();
        }
        if (!this.mEnableScrolling && (findChildViewUnder = findChildViewUnder(motionEvent.getX(), motionEvent.getY())) != null) {
            return findChildViewUnder.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void enableScrolling(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-511469291")) {
            ipChange.ipc$dispatch("-511469291", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.mEnableScrolling = z;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-782097268")) {
            return ((Boolean) ipChange.ipc$dispatch("-782097268", new Object[]{this, motionEvent})).booleanValue();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mTouchDownX = motionEvent.getX();
            this.mTouchDownY = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2 && (Math.abs(motionEvent.getX() - this.mTouchDownX) > Math.abs(motionEvent.getY() - this.mTouchDownY) || this.mSliding)) {
                this.mSliding = true;
                return false;
            }
        } else {
            this.mSliding = false;
        }
        return this.mEnableScrolling && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "846039832") ? ((Boolean) ipChange.ipc$dispatch("846039832", new Object[]{this, motionEvent})).booleanValue() : this.mEnableScrolling && super.onTouchEvent(motionEvent);
    }

    public RestrictedRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RestrictedRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTouchDownX = 0.0f;
        this.mTouchDownY = 0.0f;
        this.mSliding = false;
        this.mInitedScrollX = 0.0f;
        this.mInitedScrollY = 0.0f;
        this.mEnableScrolling = false;
        this.mScrollDelayed = 500L;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mEnableScrollRunnable = new Runnable() { // from class: com.youku.live.livesdk.widgets.container.pagable.RestrictedRecyclerView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // java.lang.Runnable
            public void run() {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1885122617")) {
                    ipChange.ipc$dispatch("1885122617", new Object[]{this});
                } else {
                    RestrictedRecyclerView.this.enableScrolling(true);
                }
            }
        };
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: com.youku.live.livesdk.widgets.container.pagable.RestrictedRecyclerView.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1570839396")) {
                    ipChange.ipc$dispatch("1570839396", new Object[]{this, recyclerView, Integer.valueOf(i2)});
                } else if (i2 == 0) {
                    RestrictedRecyclerView.this.mInitedScrollX = 0.0f;
                    RestrictedRecyclerView.this.mInitedScrollY = 0.0f;
                    RestrictedRecyclerView.this.mHandler.postDelayed(RestrictedRecyclerView.this.mEnableScrollRunnable, RestrictedRecyclerView.this.mScrollDelayed);
                } else if (i2 == 2) {
                    RestrictedRecyclerView.this.enableScrolling(false);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "948747323")) {
                    ipChange.ipc$dispatch("948747323", new Object[]{this, recyclerView, Integer.valueOf(i2), Integer.valueOf(i3)});
                    return;
                }
                RestrictedRecyclerView.this.mInitedScrollX += i2;
                RestrictedRecyclerView.this.mInitedScrollY += i3;
            }
        };
        this.mInnerScrollListener = onScrollListener;
        addOnScrollListener(onScrollListener);
        this.mScrollDelayed = 500L;
    }
}
