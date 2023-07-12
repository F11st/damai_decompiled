package com.youku.tinywindow.floatwindow;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.ViewGroup;
import com.youku.tinywindow.TinyWindowConfig;
import com.youku.tinywindow.TinyWindowManager;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class FloatingWindowService extends Service implements FloatingWindowCallBack, FloatingWindowClickCallBack {
    private TinyWindowConfig mConfig;
    private FloatingWindowHelper mFloatingWindowHelper;

    private void initWindowData() {
        ViewGroup playerRootContainer = this.mConfig.getPlayerRootContainer();
        ViewGroup playerView = this.mConfig.getPlayerView();
        if (playerRootContainer == null || playerView == null) {
            return;
        }
        playerRootContainer.removeView(playerView);
        FloatWindowManager.createFloatWindow(getApplicationContext(), playerView, this.mConfig.getPlayerViewWidth(), this.mConfig.getPlayerViewHeight(), false, false, this);
        FloatingWindowHelper floatingWindowHelper = this.mFloatingWindowHelper;
        if (floatingWindowHelper != null) {
            floatingWindowHelper.notifyTinyWindowShowSuccess();
        }
    }

    @Override // com.youku.tinywindow.floatwindow.FloatingWindowCallBack
    public void hide() {
        FloatWindowManager.hide();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // com.youku.tinywindow.floatwindow.FloatingWindowClickCallBack
    public void onCloseBtnClick() {
        hide();
        stopSelf();
        FloatingWindowHelper floatingWindowHelper = this.mFloatingWindowHelper;
        if (floatingWindowHelper != null) {
            floatingWindowHelper.notifyCloseTinyWindow();
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (TinyWindowManager.getInstance().getTinyWindowHelper() != null && (TinyWindowManager.getInstance().getTinyWindowHelper() instanceof FloatingWindowHelper)) {
            FloatingWindowHelper floatingWindowHelper = (FloatingWindowHelper) TinyWindowManager.getInstance().getTinyWindowHelper();
            this.mFloatingWindowHelper = floatingWindowHelper;
            floatingWindowHelper.registerFloatingWindowCallBack(this);
            this.mConfig = this.mFloatingWindowHelper.getConfig();
            initWindowData();
            return;
        }
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        FloatWindowManager.removeFloatWindowManager();
    }

    @Override // com.youku.tinywindow.floatwindow.FloatingWindowClickCallBack
    public void onFloatingWindowClick() {
        FloatingWindowHelper floatingWindowHelper = this.mFloatingWindowHelper;
        if (floatingWindowHelper != null) {
            floatingWindowHelper.notifyClickFloatingWindow();
        }
    }

    @Override // com.youku.tinywindow.floatwindow.FloatingWindowClickCallBack
    public void onMuteBtnClick(boolean z) {
        FloatingWindowHelper floatingWindowHelper = this.mFloatingWindowHelper;
        if (floatingWindowHelper != null) {
            floatingWindowHelper.notifyMutePlayer(z);
        }
    }

    @Override // com.youku.tinywindow.floatwindow.FloatingWindowClickCallBack
    public void onPauseBtnClick(boolean z) {
        FloatingWindowHelper floatingWindowHelper = this.mFloatingWindowHelper;
        if (floatingWindowHelper != null) {
            floatingWindowHelper.notifyPausePlayer(z);
        }
    }

    @Override // com.youku.tinywindow.floatwindow.FloatingWindowCallBack
    public void updateMuteState(boolean z) {
        FloatWindowManager.updateMuteState(z);
    }

    @Override // com.youku.tinywindow.floatwindow.FloatingWindowCallBack
    public void updatePauseState(boolean z) {
        FloatWindowManager.updatePauseState(z);
    }
}
