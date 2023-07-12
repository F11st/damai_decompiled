package com.youku.live.dago.liveplayback.widget.plugins.horizontalfull;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MultiDevTipsView extends PopupWindow implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SP_LIVE_TIP = "alix_live_tip";
    private Activity mActivity;
    private View mBtnClose;
    private TextView mText;
    private View mParentView = null;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mCloseRunnable = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.MultiDevTipsView.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-382299123")) {
                ipChange.ipc$dispatch("-382299123", new Object[]{this});
            } else {
                MultiDevTipsView.this.close();
            }
        }
    };

    public MultiDevTipsView(Activity activity) {
        initUi(activity);
    }

    private boolean canShow(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "916515700") ? ((Boolean) ipChange.ipc$dispatch("916515700", new Object[]{this, context})).booleanValue() : !context.getSharedPreferences("alix_live_tip", 0).getBoolean("is_multi_tip_closed", false);
    }

    private boolean checkWindowTokenAvailable() {
        Window window;
        View decorView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-548773279")) {
            return ((Boolean) ipChange.ipc$dispatch("-548773279", new Object[]{this})).booleanValue();
        }
        Activity activity = this.mActivity;
        return (activity == null || !canShow(activity) || (window = this.mActivity.getWindow()) == null || (decorView = window.getDecorView()) == null || decorView.getWindowToken() == null) ? false : true;
    }

    private static int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1759271615") ? ((Integer) ipChange.ipc$dispatch("-1759271615", new Object[]{context, Float.valueOf(f)})).intValue() : (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    private void initUi(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1831228973")) {
            ipChange.ipc$dispatch("-1831228973", new Object[]{this, activity});
            return;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dago_multi_dev_tips, (ViewGroup) null);
        this.mText = (TextView) inflate.findViewById(R.id.iv_multi_tip);
        View findViewById = inflate.findViewById(R.id.iv_multi_close);
        this.mBtnClose = findViewById;
        findViewById.setOnClickListener(this);
        inflate.measure(0, 0);
        setContentView(inflate);
        setWidth(inflate.getMeasuredWidth());
        setHeight(inflate.getMeasuredHeight());
        setFocusable(false);
        setTouchable(true);
        setOutsideTouchable(true);
        this.mActivity = activity;
    }

    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1693878163")) {
            ipChange.ipc$dispatch("-1693878163", new Object[]{this});
            return;
        }
        dismiss();
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.getSharedPreferences("alix_live_tip", 0).edit().putBoolean("is_multi_tip_closed", true).apply();
        }
        this.mParentView = null;
        this.mActivity = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1912748682")) {
            ipChange.ipc$dispatch("-1912748682", new Object[]{this, view});
        } else if (view == this.mBtnClose) {
            close();
        }
    }

    public void show(View view, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-848221260")) {
            ipChange.ipc$dispatch("-848221260", new Object[]{this, view, str});
            return;
        }
        this.mHandler.removeCallbacks(this.mCloseRunnable);
        this.mParentView = view;
        if (checkWindowTokenAvailable()) {
            showAsDropDown(this.mParentView, -(getWidth() - dip2px(this.mActivity.getApplicationContext(), 30.0f)), this.mText.getPaddingTop());
            this.mHandler.postDelayed(this.mCloseRunnable, 3000L);
        }
    }
}
