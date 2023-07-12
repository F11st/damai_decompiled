package com.youku.live.dago.widgetlib.ailproom.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPLivePenetrateFrameLayout extends FrameLayout implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static int DEFAULT_PENETRATE_ALPHA = 100;
    private View backView;
    private int height;
    private boolean mBitmapCacheUpdated;
    private Context mContext;
    private int mPenetrateAlpha;
    private int width;

    public AILPLivePenetrateFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPenetrateAlpha = DEFAULT_PENETRATE_ALPHA;
        initialize(context, false);
    }

    private void initialize(Context context, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-973049373")) {
            ipChange.ipc$dispatch("-973049373", new Object[]{this, context, Boolean.valueOf(z)});
            return;
        }
        setLayoutTransition(null);
        if (z) {
            this.width = (int) context.getResources().getDimension(R.dimen.dago_pgc_live_weex_back_width);
            this.height = (int) context.getResources().getDimension(R.dimen.dago_pgc_live_weex_back_height);
            addBackView(context);
            this.mContext = context;
        }
    }

    private void updateBitmapCacheIfNeed() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1778751974")) {
            ipChange.ipc$dispatch("1778751974", new Object[]{this});
        } else if (this.mBitmapCacheUpdated) {
            destroyDrawingCache();
            buildDrawingCache();
            this.mBitmapCacheUpdated = false;
        }
    }

    public void addBackView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-354837358")) {
            ipChange.ipc$dispatch("-354837358", new Object[]{this, context});
            return;
        }
        if (this.backView == null) {
            this.backView = FrameLayout.inflate(context, R.layout.dago_pgc_live_weex_layer_back, null);
        }
        removeView(this.backView);
        addView(this.backView);
        this.backView.findViewById(R.id.live_weex_back_img).setOnClickListener(this);
        if (this.width == 0 || this.height == 0) {
            this.width = (int) context.getResources().getDimension(R.dimen.dago_pgc_live_weex_back_width);
            this.height = (int) context.getResources().getDimension(R.dimen.dago_pgc_live_weex_back_height);
        }
        if (isScreenOrientationPortrait(context)) {
            ((FrameLayout.LayoutParams) this.backView.getLayoutParams()).topMargin = this.height / 3;
        }
        this.backView.getLayoutParams().height = this.height;
        this.backView.getLayoutParams().width = this.width;
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505625033")) {
            ipChange.ipc$dispatch("1505625033", new Object[]{this});
        } else {
            removeAllViews();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-179957380")) {
            ipChange.ipc$dispatch("-179957380", new Object[]{this, canvas});
            return;
        }
        try {
            super.dispatchDraw(canvas);
            this.mBitmapCacheUpdated = true;
        } catch (Throwable unused) {
        }
    }

    final int getPenetrateAlpha() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "383686186") ? ((Integer) ipChange.ipc$dispatch("383686186", new Object[]{this})).intValue() : this.mPenetrateAlpha;
    }

    public void hideClose() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1770614547")) {
            ipChange.ipc$dispatch("-1770614547", new Object[]{this});
            return;
        }
        View view = this.backView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public boolean isScreenOrientationPortrait(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1012425698") ? ((Boolean) ipChange.ipc$dispatch("-1012425698", new Object[]{this, context})).booleanValue() : (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || context.getResources().getConfiguration().orientation != 1) ? false : true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1172065256")) {
            ipChange.ipc$dispatch("-1172065256", new Object[]{this, view});
        } else if (view.getId() == R.id.live_weex_back_img) {
            ViewParent parent = getParent();
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof AILPLiveWVWebView) {
                    AILPLiveWVWebView aILPLiveWVWebView = (AILPLiveWVWebView) childAt;
                    aILPLiveWVWebView.removeAllViews();
                    aILPLiveWVWebView.destroy();
                }
            }
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
                destroy();
            }
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        View view;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "991672582")) {
            ipChange.ipc$dispatch("991672582", new Object[]{this, configuration});
            return;
        }
        super.onConfigurationChanged(configuration);
        int i = configuration.orientation;
        if ((i == 1 || i == 2) && (view = this.backView) != null && view.isShown()) {
            addBackView(this.mContext);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-881137154")) {
            return ((Boolean) ipChange.ipc$dispatch("-881137154", new Object[]{this, motionEvent})).booleanValue();
        }
        try {
            i = this.mPenetrateAlpha;
        } catch (Throwable unused) {
        }
        if (255 == i) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (x >= 0 && y >= 0) {
            if (motionEvent.getAction() == 0) {
                updateBitmapCacheIfNeed();
            }
            Bitmap drawingCache = getDrawingCache();
            if (x <= drawingCache.getWidth() && y <= drawingCache.getHeight()) {
                return 255 - Color.alpha(drawingCache.getPixel(x, y)) > this.mPenetrateAlpha;
            }
        }
        return true;
    }

    public final void setPenetrateAlpha(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1545610680")) {
            ipChange.ipc$dispatch("1545610680", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        if (i > 255) {
            i = 255;
        } else if (i < 0) {
            i = 0;
        }
        this.mPenetrateAlpha = i;
    }

    public AILPLivePenetrateFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPenetrateAlpha = DEFAULT_PENETRATE_ALPHA;
        initialize(context, false);
    }

    public AILPLivePenetrateFrameLayout(Context context) {
        super(context);
        this.mPenetrateAlpha = DEFAULT_PENETRATE_ALPHA;
        initialize(context, false);
    }

    public AILPLivePenetrateFrameLayout(Context context, boolean z) {
        super(context);
        this.mPenetrateAlpha = DEFAULT_PENETRATE_ALPHA;
        initialize(context, z);
    }
}
