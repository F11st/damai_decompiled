package com.youku.live.livesdk.wkit.view.keyboard;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.R;
import com.youku.live.livesdk.wkit.utils.UIUtil;
import com.youku.live.messagechannel.utils.MyLog;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class KeyboardHeightProvider extends PopupWindow {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "KeyboardHeightProvider";
    private Activity activity;
    boolean isVisiableForLast;
    private int keyboardLandscapeHeight;
    private int keyboardPortraitHeight;
    private final MyOnGlobalLayoutListener mOnGlobalLayoutListener;
    private KeyboardHeightObserver observer;
    private View parentView;
    private View popupView;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private static class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private final KeyboardHeightProvider mKeyboardHeightProvider;

        public MyOnGlobalLayoutListener(KeyboardHeightProvider keyboardHeightProvider) {
            this.mKeyboardHeightProvider = keyboardHeightProvider;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.mKeyboardHeightProvider.popupView != null) {
                this.mKeyboardHeightProvider.handleOnGlobalLayout();
            }
        }
    }

    public KeyboardHeightProvider(Activity activity) {
        super(activity);
        this.isVisiableForLast = false;
        this.activity = activity;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.C7960layout.dago_container_popupwindow, (ViewGroup) null, false);
        this.popupView = inflate;
        setContentView(inflate);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.parentView = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        MyOnGlobalLayoutListener myOnGlobalLayoutListener = new MyOnGlobalLayoutListener(this);
        this.mOnGlobalLayoutListener = myOnGlobalLayoutListener;
        this.popupView.getViewTreeObserver().addOnGlobalLayoutListener(myOnGlobalLayoutListener);
    }

    private int getScreenOrientation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-612433833") ? ((Integer) ipChange.ipc$dispatch("-612433833", new Object[]{this})).intValue() : this.activity.getResources().getConfiguration().orientation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnGlobalLayout() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-244686018")) {
            ipChange.ipc$dispatch("-244686018", new Object[]{this});
            return;
        }
        int screenOrientation = getScreenOrientation();
        Point point = new Point();
        if (UIUtil.isAllScreenDevice(this.activity) && Build.VERSION.SDK_INT >= 17) {
            Display.getRealSize(this.activity.getWindowManager().getDefaultDisplay(), point);
            MyLog.v(TAG, "getRealSize->screenSize.y: " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
            if (!UIUtil.navigationGestureEnabled(this.activity) && screenOrientation == 1) {
                point.y = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) - UIUtil.getNavigationBarHeightIfRoom(this.activity);
                MyLog.v(TAG, "getRealSize->NavigationBarHeight: " + UIUtil.getNavigationBarHeightIfRoom(this.activity));
                MyLog.v(TAG, "getRealSize->screenSize.y2: " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
            }
        } else {
            Display.getSize(this.activity.getWindowManager().getDefaultDisplay(), point);
            MyLog.e(TAG, "getSize->screenSize.y: " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        }
        Rect rect = new Rect();
        this.popupView.getWindowVisibleDisplayFrame(rect);
        int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) - rect.bottom;
        MyLog.i(TAG, "keyboardHeight: " + yVar + ", screenSize.y: " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) + ", rect.bottom: " + rect.bottom);
        if (yVar <= 0) {
            notifyKeyboardHeightChanged(0, screenOrientation);
        } else if (screenOrientation == 1) {
            this.keyboardPortraitHeight = yVar;
            notifyKeyboardHeightChanged(yVar, screenOrientation);
        } else {
            this.keyboardLandscapeHeight = yVar;
            notifyKeyboardHeightChanged(yVar, screenOrientation);
        }
    }

    private void notifyKeyboardHeightChanged(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-243329669")) {
            ipChange.ipc$dispatch("-243329669", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        KeyboardHeightObserver keyboardHeightObserver = this.observer;
        if (keyboardHeightObserver != null) {
            keyboardHeightObserver.onKeyboardHeightChanged(i, i2);
        }
    }

    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1549453152")) {
            ipChange.ipc$dispatch("1549453152", new Object[]{this});
            return;
        }
        if (this.observer != null) {
            this.observer = null;
        }
        View view = this.popupView;
        if (view != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        }
        dismiss();
    }

    public void setKeyboardHeightObserver(KeyboardHeightObserver keyboardHeightObserver) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1717830369")) {
            ipChange.ipc$dispatch("-1717830369", new Object[]{this, keyboardHeightObserver});
        } else {
            this.observer = keyboardHeightObserver;
        }
    }

    public void start() {
        View view;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1773424822")) {
            ipChange.ipc$dispatch("1773424822", new Object[]{this});
            return;
        }
        try {
            if (this.activity.isFinishing() || isShowing() || (view = this.parentView) == null || view.getWindowToken() == null) {
                return;
            }
            setBackgroundDrawable(new ColorDrawable(0));
            showAtLocation(this.parentView, 0, 0, 0);
        } catch (WindowManager.BadTokenException unused) {
        }
    }
}
