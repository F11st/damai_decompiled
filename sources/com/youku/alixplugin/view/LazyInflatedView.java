package com.youku.alixplugin.view;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.youku.alixplugin.AlixPlayerContext;
import com.youku.alixplugin.ViewPlaceholder;
import com.youku.alixplugin.layer.ILMLayerManager;
import com.youku.alixplugin.layer.LMLayerDataSourceException;
import com.youku.kubus.NoProguard;

/* compiled from: Taobao */
@NoProguard
/* loaded from: classes7.dex */
public abstract class LazyInflatedView {
    public static String TAG = "LazyInflatedView";
    protected boolean isInflated;
    private boolean mAttached;
    protected Context mContext;
    protected View mInflatedView;
    protected String mLayerId;
    protected ILMLayerManager<ViewGroup> mLayerManager;
    protected int mLayoutResourceId;
    protected OnInflateListener mOnInflateListener;
    protected ViewPlaceholder mViewPlaceholder;

    @Deprecated
    public LazyInflatedView(AlixPlayerContext alixPlayerContext, ILMLayerManager<ViewGroup> iLMLayerManager, String str, int i, ViewPlaceholder viewPlaceholder) {
        this(alixPlayerContext.getContext(), iLMLayerManager, str, i, viewPlaceholder);
    }

    public void attach() {
        if (this.mAttached) {
            return;
        }
        try {
            if (this.mLayerManager.getLayerById(this.mLayerId, this.mContext) == null) {
                String str = TAG;
                Log.e(str, "attatch cannot find layer  mLayerId =  " + this.mLayerId);
                return;
            }
            ViewGroup uIContainer = this.mLayerManager.getLayerById(this.mLayerId, this.mContext).getUIContainer();
            if (uIContainer != null) {
                View view = this.mInflatedView;
                if (view != null) {
                    uIContainer.addView(view);
                    this.mAttached = true;
                    return;
                }
                ViewPlaceholder viewPlaceholder = this.mViewPlaceholder;
                if (viewPlaceholder != null) {
                    if (viewPlaceholder.getParent() == null) {
                        uIContainer.addView(this.mViewPlaceholder);
                    }
                    this.mAttached = true;
                }
            }
        } catch (LMLayerDataSourceException e) {
            String str2 = TAG;
            Log.e(str2, "LazyInflatedView attach Exception: " + e);
        }
    }

    public void disableReplayClick(final View view, long j) {
        if (view.isClickable()) {
            view.setClickable(false);
            view.postDelayed(new Runnable() { // from class: com.youku.alixplugin.view.LazyInflatedView.1
                @Override // java.lang.Runnable
                public void run() {
                    View view2 = view;
                    if (view2 != null) {
                        view2.setClickable(true);
                    }
                }
            }, j);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public View getInflatedView() {
        return this.mInflatedView;
    }

    public ViewGroup getParent() {
        if (getView() != null) {
            return (ViewGroup) getView().getParent();
        }
        return null;
    }

    public View getView() {
        if (this.isInflated) {
            return this.mInflatedView;
        }
        return this.mViewPlaceholder;
    }

    public void hide() {
        if (this.isInflated && this.mInflatedView.getVisibility() != 8) {
            this.mInflatedView.setVisibility(8);
        }
    }

    public void inflate() {
        if (this.isInflated) {
            return;
        }
        ViewPlaceholder viewPlaceholder = this.mViewPlaceholder;
        if (viewPlaceholder != null) {
            this.mInflatedView = viewPlaceholder.inflate();
        }
        this.isInflated = true;
        onInflate(this.mInflatedView);
        OnInflateListener onInflateListener = this.mOnInflateListener;
        if (onInflateListener != null) {
            onInflateListener.onInflate();
        }
    }

    public boolean isInflated() {
        return this.isInflated;
    }

    public boolean isShow() {
        return this.isInflated && this.mInflatedView.getVisibility() == 0;
    }

    public ViewPlaceholder onCreateView(Context context) {
        ViewPlaceholder viewPlaceholder = this.mViewPlaceholder;
        if (viewPlaceholder != null) {
            int i = this.mLayoutResourceId;
            if (i > 0) {
                viewPlaceholder.setLayoutResourceId(i);
            }
            return this.mViewPlaceholder;
        } else if (this.mLayoutResourceId > 0) {
            return new ViewPlaceholder(context, this.mLayoutResourceId);
        } else {
            return null;
        }
    }

    protected abstract void onInflate(View view);

    public void setEnabled(View view, boolean z) {
        if (!isInflated() || view.isEnabled() == z) {
            return;
        }
        view.setEnabled(z);
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
        this.mOnInflateListener = onInflateListener;
    }

    public void setSelected(View view, boolean z) {
        if (!isInflated() || view.isSelected() == z) {
            return;
        }
        view.setSelected(z);
    }

    public void setText(TextView textView, String str) {
        if (!isInflated() || textView.getText() == str) {
            return;
        }
        textView.setText(str);
    }

    public void setVisibility(View view, int i) {
        if (!isInflated() || view.getVisibility() == i) {
            return;
        }
        view.setVisibility(i);
    }

    public void show() {
        if (!this.isInflated) {
            inflate();
        }
        if (this.mInflatedView.getVisibility() != 0) {
            this.mInflatedView.setVisibility(0);
        }
    }

    @Deprecated
    public LazyInflatedView(AlixPlayerContext alixPlayerContext, ILMLayerManager<ViewGroup> iLMLayerManager, String str, int i) {
        this(alixPlayerContext, iLMLayerManager, str, i, (ViewPlaceholder) null);
    }

    @Deprecated
    public LazyInflatedView(AlixPlayerContext alixPlayerContext, ILMLayerManager<ViewGroup> iLMLayerManager, String str) {
        this(alixPlayerContext, iLMLayerManager, str, 0, (ViewPlaceholder) null);
    }

    public LazyInflatedView(Context context, ILMLayerManager<ViewGroup> iLMLayerManager, String str, int i) {
        this(context, iLMLayerManager, str, i, (ViewPlaceholder) null);
    }

    public LazyInflatedView(Context context, ILMLayerManager<ViewGroup> iLMLayerManager, String str, int i, ViewPlaceholder viewPlaceholder) {
        this.mLayoutResourceId = -1;
        this.mContext = context;
        this.mLayerManager = iLMLayerManager;
        this.mLayerId = str;
        this.mLayoutResourceId = i;
        this.mViewPlaceholder = viewPlaceholder;
        ViewPlaceholder onCreateView = onCreateView(context);
        this.mViewPlaceholder = onCreateView;
        if (onCreateView != null) {
            onCreateView.setVisibility(8);
        }
        attach();
    }
}
