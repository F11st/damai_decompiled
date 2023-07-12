package com.youku.live.dago.liveplayback.widget.plugins.dlna;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tmalltv.tv.lib.ali_tvsharelib.all.utils.StrUtil;
import com.youku.live.dago.liveplayback.R;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DlnaDevTipsView extends PopupWindow {
    private static transient /* synthetic */ IpChange $ipChange;
    private MyHandler dlnaHander;
    private Activity mCaller;
    private ImageView mKidTipView;
    private TextView mText;
    private View mDlnaView = null;
    private int TIP_SHOW = 0;
    private int TIP_HIDE = 1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static class MyHandler extends Handler {
        private DlnaDevTipsView mThis;

        public MyHandler(DlnaDevTipsView dlnaDevTipsView) {
            this.mThis = dlnaDevTipsView;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == this.mThis.TIP_SHOW) {
                this.mThis.showDeviceGuide();
            } else if (message.what == this.mThis.TIP_HIDE) {
                this.mThis.hide();
            }
        }
    }

    public DlnaDevTipsView(Context context, boolean z) {
        initUi(context, z);
    }

    private boolean checkWindowTokenAvailable() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2069493951")) {
            return ((Boolean) ipChange.ipc$dispatch("-2069493951", new Object[]{this})).booleanValue();
        }
        Activity activity = this.mCaller;
        if (activity == null) {
            str = "no Activity";
        } else {
            Window window = activity.getWindow();
            if (window == null) {
                str = "no window";
            } else {
                View decorView = window.getDecorView();
                if (decorView == null) {
                    str = "no decor view";
                } else {
                    str = decorView.getWindowToken() == null ? "get window token failed" : null;
                }
            }
        }
        return !StrUtil.isValidStr(str);
    }

    private void initUi(Context context, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199805229")) {
            ipChange.ipc$dispatch("199805229", new Object[]{this, context, Boolean.valueOf(z)});
            return;
        }
        View inflate = LayoutInflater.from(context).inflate(R.C7935layout.dago_dlna_dev_tips, (ViewGroup) null);
        this.mText = (TextView) inflate.findViewById(R.id.dlna_dev_highlight);
        this.mKidTipView = (ImageView) inflate.findViewById(R.id.dlna_kid_tips);
        if (z) {
            this.mText.setVisibility(8);
            this.mKidTipView.setVisibility(0);
        } else {
            this.mText.setVisibility(0);
            this.mKidTipView.setVisibility(8);
        }
        inflate.measure(0, 0);
        setContentView(inflate);
        setWidth(inflate.getMeasuredWidth());
        setHeight(inflate.getMeasuredHeight());
        setFocusable(false);
        setTouchable(true);
        setOutsideTouchable(true);
        this.dlnaHander = new MyHandler(this);
        this.mCaller = (Activity) context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeviceGuide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "950751900")) {
            ipChange.ipc$dispatch("950751900", new Object[]{this});
            return;
        }
        int i = -(getWidth() - this.mText.getPaddingRight());
        if (checkWindowTokenAvailable()) {
            showAsDropDown(this.mDlnaView, i, this.mText.getPaddingTop());
            this.dlnaHander.sendEmptyMessageDelayed(this.TIP_HIDE, 3000L);
        }
    }

    public void hide() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330975267")) {
            ipChange.ipc$dispatch("1330975267", new Object[]{this});
            return;
        }
        if (checkWindowTokenAvailable() && isShowing()) {
            dismiss();
        }
        this.mDlnaView = null;
        this.mCaller = null;
    }

    public void hideTips() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "584377547")) {
            ipChange.ipc$dispatch("584377547", new Object[]{this});
            return;
        }
        if (checkWindowTokenAvailable() && isShowing()) {
            dismiss();
        }
        this.dlnaHander.removeMessages(this.TIP_HIDE);
        this.mDlnaView = null;
        this.mCaller = null;
    }

    public void show(View view, View view2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-988173496")) {
            ipChange.ipc$dispatch("-988173496", new Object[]{this, view, view2});
            return;
        }
        this.mDlnaView = view2;
        this.dlnaHander.sendEmptyMessageDelayed(this.TIP_SHOW, 3000L);
    }
}
