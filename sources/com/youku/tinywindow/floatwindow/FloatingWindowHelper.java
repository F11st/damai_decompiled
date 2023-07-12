package com.youku.tinywindow.floatwindow;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import com.youku.tinywindow.ITinyWindowHelper;
import com.youku.tinywindow.TinyWindowConfig;
import com.youku.tinywindow.TinyWindowHelperListener;
import com.youku.tinywindow.floatwindow.permission.FloatingWindowPermissionManager;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FloatingWindowHelper implements ITinyWindowHelper {
    private Activity mActivity;
    private FloatingWindowCallBack mCallBack;
    private TinyWindowConfig mConfig;
    private TinyWindowHelperListener mListener;

    public FloatingWindowHelper(TinyWindowConfig tinyWindowConfig) {
        this.mConfig = tinyWindowConfig;
        if (tinyWindowConfig.getActivity() != null) {
            this.mActivity = tinyWindowConfig.getActivity();
        }
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void destroyTinyWindow() {
        if (this.mActivity != null) {
            this.mActivity.stopService(new Intent(this.mActivity, FloatingWindowService.class));
        }
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void enterTinyWindow() {
        if (this.mActivity == null) {
            TinyWindowHelperListener tinyWindowHelperListener = this.mListener;
            if (tinyWindowHelperListener != null) {
                tinyWindowHelperListener.onHelperWindowShowFailed(2);
            }
        } else if (FloatingWindowPermissionManager.getInstance().applyFloatingWindowPermission(this.mConfig.getActivity()) || Build.VERSION.SDK_INT < 24) {
            this.mActivity.startService(new Intent(this.mActivity, FloatingWindowService.class));
        }
    }

    public TinyWindowConfig getConfig() {
        return this.mConfig;
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void hideTinyWindow() {
        FloatingWindowCallBack floatingWindowCallBack = this.mCallBack;
        if (floatingWindowCallBack != null) {
            floatingWindowCallBack.hide();
        }
    }

    public void notifyClickFloatingWindow() {
        TinyWindowHelperListener tinyWindowHelperListener = this.mListener;
        if (tinyWindowHelperListener != null) {
            tinyWindowHelperListener.onHelperWindowClick();
        }
    }

    public void notifyCloseTinyWindow() {
        TinyWindowHelperListener tinyWindowHelperListener = this.mListener;
        if (tinyWindowHelperListener != null) {
            tinyWindowHelperListener.onHelperWindowClosed();
        }
    }

    public void notifyMutePlayer(boolean z) {
        TinyWindowHelperListener tinyWindowHelperListener = this.mListener;
        if (tinyWindowHelperListener != null) {
            tinyWindowHelperListener.onHelperWindowMutePlayer(z);
        }
    }

    public void notifyPausePlayer(boolean z) {
        TinyWindowHelperListener tinyWindowHelperListener = this.mListener;
        if (tinyWindowHelperListener != null) {
            tinyWindowHelperListener.onHelperWindowPausePlayer(z);
        }
    }

    public void notifyShowTinyWindowFailed(int i) {
        TinyWindowHelperListener tinyWindowHelperListener = this.mListener;
        if (tinyWindowHelperListener != null) {
            tinyWindowHelperListener.onHelperWindowShowFailed(i);
        }
    }

    public void notifyTinyWindowShowSuccess() {
        TinyWindowHelperListener tinyWindowHelperListener = this.mListener;
        if (tinyWindowHelperListener != null) {
            tinyWindowHelperListener.onHelperWindowShowSuccess();
        }
    }

    public void registerFloatingWindowCallBack(FloatingWindowCallBack floatingWindowCallBack) {
        this.mCallBack = floatingWindowCallBack;
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void setTinyWindowHelperListener(TinyWindowHelperListener tinyWindowHelperListener) {
        if (tinyWindowHelperListener != null) {
            this.mListener = tinyWindowHelperListener;
        }
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void updateWithMute(boolean z) {
        FloatingWindowCallBack floatingWindowCallBack = this.mCallBack;
        if (floatingWindowCallBack != null) {
            floatingWindowCallBack.updateMuteState(z);
        }
    }

    @Override // com.youku.tinywindow.ITinyWindowHelper
    public void updateWithPause(boolean z) {
        FloatingWindowCallBack floatingWindowCallBack = this.mCallBack;
        if (floatingWindowCallBack != null) {
            floatingWindowCallBack.updatePauseState(z);
        }
    }
}
