package com.youku.live.dago.liveplayback.widget.plugins.horizontalfull;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class PickTipsView extends PopupWindow implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SP_LIVE_TIP = "alix_live_tip";
    private Activity mActivity;
    private TextView mText;
    private View mParentView = null;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Runnable mCloseRunnable = new Runnable() { // from class: com.youku.live.dago.liveplayback.widget.plugins.horizontalfull.PickTipsView.1
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // java.lang.Runnable
        public void run() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "888085096")) {
                ipChange.ipc$dispatch("888085096", new Object[]{this});
            } else {
                PickTipsView.this.close();
            }
        }
    };

    public PickTipsView(Activity activity) {
        initUi(activity);
    }

    private boolean canShow(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1544700985") ? ((Boolean) ipChange.ipc$dispatch("1544700985", new Object[]{this, context})).booleanValue() : !context.getSharedPreferences("alix_live_tip", 0).getBoolean("is_pick_tip_closed", false);
    }

    private boolean checkWindowTokenAvailable() {
        Window window;
        View decorView;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1444729540")) {
            return ((Boolean) ipChange.ipc$dispatch("-1444729540", new Object[]{this})).booleanValue();
        }
        Activity activity = this.mActivity;
        return (activity == null || !canShow(activity) || (window = this.mActivity.getWindow()) == null || (decorView = window.getDecorView()) == null || decorView.getWindowToken() == null) ? false : true;
    }

    private static int dip2px(Context context, float f) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1131086330") ? ((Integer) ipChange.ipc$dispatch("-1131086330", new Object[]{context, Float.valueOf(f)})).intValue() : (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    private void initUi(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42455784")) {
            ipChange.ipc$dispatch("-42455784", new Object[]{this, activity});
            return;
        }
        View inflate = LayoutInflater.from(activity).inflate(R.layout.dago_pick_tips, (ViewGroup) null);
        this.mText = (TextView) inflate.findViewById(R.id.iv_multi_tip);
        inflate.measure(0, 0);
        setContentView(inflate);
        setWidth(inflate.getMeasuredWidth());
        setHeight(inflate.getMeasuredHeight());
        setFocusable(false);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(R.style.dago_popup_anim);
        this.mActivity = activity;
    }

    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-423493944")) {
            ipChange.ipc$dispatch("-423493944", new Object[]{this});
            return;
        }
        Activity activity = this.mActivity;
        if (activity != null) {
            if (!activity.isFinishing()) {
                dismiss();
            }
            this.mActivity.getSharedPreferences("alix_live_tip", 0).edit().putBoolean("is_pick_tip_closed", true).apply();
            this.mActivity = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "377378299")) {
            ipChange.ipc$dispatch("377378299", new Object[]{this, view});
        }
    }

    public void setText(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "582214011")) {
            ipChange.ipc$dispatch("582214011", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.mText.setText(str);
        }
    }

    public void show(View view, int i, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372563842")) {
            ipChange.ipc$dispatch("-1372563842", new Object[]{this, view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        this.mHandler.removeCallbacks(this.mCloseRunnable);
        if (checkWindowTokenAvailable()) {
            showAtLocation(view, i, i2, i3);
            this.mHandler.postDelayed(this.mCloseRunnable, DanmakuFactory.DEFAULT_DANMAKU_DURATION_V);
        }
    }
}
