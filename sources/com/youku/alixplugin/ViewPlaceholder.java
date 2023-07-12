package com.youku.alixplugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.youku.kubus.NoProguard;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes7.dex */
public class ViewPlaceholder extends View {
    private static final String MODULE = "view_place_holder_cache";
    private static final String TAG = "ViewPlaceholder";
    final int VISIBILITY_MASK;
    private AsyncInflateListener mAsyncInflateListener;
    private View mAsyncPreLoadView;
    private boolean mDebug;
    private boolean mEnableMonitor;
    private RelayWeakReference<View> mInflatedViewRef;
    private boolean mIsAsync;
    private int mLayoutResourceId;
    private Object mPaddingPreTask;
    private int mVisibleFlag;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface AsyncInflateListener {
        void onAsyncInflateFinish();
    }

    public ViewPlaceholder(Context context, int i) {
        super(context);
        this.VISIBILITY_MASK = 12;
        this.mVisibleFlag = -1;
        this.mLayoutResourceId = i;
        setVisibility(8);
        setWillNotDraw(true);
    }

    private String getSafeResourceName(int i) {
        try {
            return getResources().getResourceEntryName(i);
        } catch (Exception unused) {
            return null;
        }
    }

    private void monitorCacheFail(String str) {
        try {
            AppMonitor.Alarm.commitFail(MODULE, str, "-1", "-1");
        } catch (Throwable unused) {
        }
    }

    private void monitorCacheState(boolean z, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z) {
            monitorCacheSuccess(str);
        } else {
            monitorCacheFail(str);
        }
    }

    private void monitorCacheSuccess(String str) {
        try {
            AppMonitor.Alarm.commitSuccess(MODULE, str);
        } catch (Throwable unused) {
        }
    }

    public void asyncPreInflate() {
        asyncPreInflate(true);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getLayoutResourceId() {
        return this.mLayoutResourceId;
    }

    public View inflate() {
        View view;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater from = LayoutInflater.from(getContext());
            if (this.mLayoutResourceId != 0) {
                view = this.mAsyncPreLoadView;
                boolean z = view != null;
                if (this.mDebug) {
                    Log.w(TAG, "inflate cache = " + z + ",layout name = " + getSafeResourceName(this.mLayoutResourceId));
                }
                if (this.mEnableMonitor) {
                    monitorCacheState(z, getSafeResourceName(this.mLayoutResourceId));
                }
                if (view == null) {
                    view = from.inflate(this.mLayoutResourceId, viewGroup, false);
                }
            } else {
                RelayWeakReference<View> relayWeakReference = this.mInflatedViewRef;
                if (relayWeakReference != null) {
                    view = relayWeakReference.get();
                } else {
                    throw new IllegalStateException("ViewStub must have a id or refview");
                }
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            viewGroup.addView(view, indexOfChild);
            int i = this.mVisibleFlag;
            if (i != -1) {
                if ((i & 12) == 4) {
                    view.setVisibility(4);
                } else if ((i & 12) == 8) {
                    view.setVisibility(8);
                } else if ((i & 12) == 0) {
                    view.setVisibility(0);
                }
            }
            return view;
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setAsyncInflateListener(AsyncInflateListener asyncInflateListener) {
        this.mAsyncInflateListener = asyncInflateListener;
    }

    public void setDebug(boolean z) {
        this.mDebug = z;
    }

    public void setLayoutResourceId(int i) {
        this.mLayoutResourceId = i;
        if (this.mPaddingPreTask != null) {
            asyncPreInflate(this.mEnableMonitor);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.mVisibleFlag = i;
        if (i == 0 || i == 4) {
            inflate();
        }
    }

    public void asyncPreInflate(boolean z) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            Log.w(TAG, "asyncPreInflate: 请主线程调用");
            return;
        }
        this.mEnableMonitor = z;
        if (this.mIsAsync) {
            return;
        }
        if (this.mLayoutResourceId <= 0) {
            this.mPaddingPreTask = new Object();
            return;
        }
        ViewGroup viewGroup = null;
        this.mPaddingPreTask = null;
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup == null) {
            return;
        }
        this.mIsAsync = true;
    }

    public ViewPlaceholder(Context context, RelayWeakReference<View> relayWeakReference) {
        super(context);
        this.VISIBILITY_MASK = 12;
        this.mVisibleFlag = -1;
        this.mInflatedViewRef = relayWeakReference;
        setVisibility(8);
        setWillNotDraw(true);
    }
}
