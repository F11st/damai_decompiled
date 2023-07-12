package com.youku.tinywindow;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.taobao.android.nav.Nav;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import com.youku.tinywindow.TinyWindowConfig;
import com.youku.tinywindow.floatwindow.FloatingWindowHelper;
import com.youku.tinywindow.pip.PIPHelper;
import com.youku.tinywindow.utils.TinyLogger;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TinyWindowManager implements TinyWindowHelperListener {
    public static final String ACTION_TINYWINDOW_RECEIVE_ALIXPLAYER_START = "com.youku.phone.player.started";
    public static final int SHOW_TINYWINDOW_FAILED_OTHER = 2;
    public static final int SHOW_TINYWINDOW_FAILED_REFUSE_PERMISSION = 0;
    public static final int SHOW_TINYWINDOW_FAILED_UNSHOW_APPLY_PERMISSION = 1;
    private static final String TAG = "TinyWindowManager";
    public static final String TINYWINDOW_CONTROL_VALUE = "tinywindow_control_value";
    public static final String TINYWINDOW_NOTIFY_MUTE_PLAYER = "com.youku.phone.live.mute.tinywindow";
    public static final String TINYWINDOW_NOTIFY_PAUSE_PLAYER = "com.youku.phone.live.pause.tinywindow";
    public static final String TINYWINDOW_NOTIFY_QUIT = "com.youku.phone.live.force.quit.tinywindow";
    private static volatile TinyWindowManager mTinyWindowManager;
    private TinyWindowConfig mConfig;
    private long mEnterTime;
    private boolean mIsInTinyWindowMode;
    private TinyWindowListener mListener;
    private BroadcastReceiver mReceiver;
    private ITinyWindowHelper mTinyWindowHelper;

    private TinyWindowManager() {
        TinyLogger.log(TAG, "TinyWindowManager init");
        this.mReceiver = new BroadcastReceiver() { // from class: com.youku.tinywindow.TinyWindowManager.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive");
                if (intent == null) {
                    return;
                }
                String action = intent.getAction();
                action.hashCode();
                char c = 65535;
                switch (action.hashCode()) {
                    case -1745456004:
                        if (action.equals(TinyWindowManager.TINYWINDOW_NOTIFY_QUIT)) {
                            c = 0;
                            break;
                        }
                        break;
                    case -407069835:
                        if (action.equals(TinyWindowManager.TINYWINDOW_NOTIFY_MUTE_PLAYER)) {
                            c = 1;
                            break;
                        }
                        break;
                    case 832891480:
                        if (action.equals(TinyWindowManager.TINYWINDOW_NOTIFY_PAUSE_PLAYER)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1752830598:
                        if (action.equals("com.youku.phone.player.started")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive quit");
                        if (TinyWindowManager.this.isInTinyWindowMode()) {
                            TinyWindowManager.this.destroyTinyWindow();
                            return;
                        } else {
                            TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive quit--no tinywindow abort");
                            return;
                        }
                    case 1:
                        boolean booleanExtra = intent.getBooleanExtra(TinyWindowManager.TINYWINDOW_CONTROL_VALUE, true);
                        TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive mute:" + booleanExtra);
                        if (TinyWindowManager.this.isInTinyWindowMode()) {
                            if (TinyWindowManager.this.mConfig != null && TinyWindowManager.this.mTinyWindowHelper != null) {
                                if (TinyWindowManager.this.mConfig.isSurportMute()) {
                                    TinyWindowManager.this.setPlayerMute(booleanExtra);
                                    TinyWindowManager.this.mTinyWindowHelper.updateWithMute(booleanExtra);
                                    TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive mute and excute mute");
                                    return;
                                } else if (TinyWindowManager.this.mConfig.isSurportPause()) {
                                    TinyWindowManager.this.setPlayerPause(booleanExtra);
                                    TinyWindowManager.this.mTinyWindowHelper.updateWithPause(booleanExtra);
                                    TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive mute and excute pause");
                                    return;
                                } else {
                                    TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive mute--unsurport abort");
                                    return;
                                }
                            }
                            TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive mute--no config abort");
                            return;
                        }
                        TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive mute--no tinywindow abort");
                        return;
                    case 2:
                        boolean booleanExtra2 = intent.getBooleanExtra(TinyWindowManager.TINYWINDOW_CONTROL_VALUE, true);
                        TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive pause:" + booleanExtra2);
                        if (TinyWindowManager.this.isInTinyWindowMode()) {
                            if (TinyWindowManager.this.mConfig != null && TinyWindowManager.this.mTinyWindowHelper != null) {
                                if (TinyWindowManager.this.mConfig.isSurportPause()) {
                                    TinyWindowManager.this.setPlayerPause(booleanExtra2);
                                    TinyWindowManager.this.mTinyWindowHelper.updateWithPause(booleanExtra2);
                                    TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive pause and excute pause");
                                    return;
                                }
                                TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive pause--unsurport abort");
                                return;
                            }
                            TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive pause--no config abort");
                            return;
                        }
                        TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive pause--no tinywindow abort");
                        return;
                    case 3:
                        if (intent.getExtras().getBoolean("isMuted")) {
                            return;
                        }
                        if (TinyWindowManager.this.isInTinyWindowMode()) {
                            if (TinyWindowManager.this.mConfig != null && TinyWindowManager.this.mTinyWindowHelper != null) {
                                if (intent.getExtras().getInt("hashCode") == TinyWindowManager.this.mConfig.getLivePlayer().getPlayer().hashCode()) {
                                    return;
                                }
                                if (!TinyWindowUtils.enablePlayerStartDestroy()) {
                                    if (TinyWindowManager.this.mConfig.isSurportMute()) {
                                        TinyWindowManager.this.setPlayerMute(true);
                                        TinyWindowManager.this.mTinyWindowHelper.updateWithMute(true);
                                        TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive alixplayer start and excute mute");
                                        return;
                                    }
                                    TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive alixplayer start--abort");
                                    return;
                                }
                                TinyWindowManager.this.destroyTinyWindow();
                                TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive alixplayer start and destroy");
                                return;
                            }
                            TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive alixplayer start--no config abort");
                            return;
                        }
                        TinyLogger.log(TinyWindowManager.TAG, "TinyWindowManager onReceive alixplayer start--no tinywindow abort");
                        return;
                    default:
                        return;
                }
            }
        };
    }

    private void countTinyWindowTime() {
        long currentTimeMillis = System.currentTimeMillis() - this.mEnterTime;
        TinyWindowConfig tinyWindowConfig = this.mConfig;
        if (tinyWindowConfig != null) {
            if (tinyWindowConfig.getPlayerType() == 1 && this.mConfig.getLivePlayer() != null) {
                PlayVideoInfo playVideoInfo = this.mConfig.getLivePlayer().getPlayVideoInfo();
                if (playVideoInfo != null) {
                    String string = playVideoInfo.getString("tinywindowTimeOfPlay");
                    if (TextUtils.isEmpty(string)) {
                        playVideoInfo.putString("tinywindowTimeOfPlay", String.valueOf(currentTimeMillis));
                        return;
                    }
                    try {
                        playVideoInfo.putString("tinywindowTimeOfPlay", String.valueOf(currentTimeMillis + Long.parseLong(string)));
                        return;
                    } catch (Exception unused) {
                        TinyLogger.log(TAG, "count tinywindowTimeOfPlay error");
                        return;
                    }
                }
                return;
            }
            this.mConfig.getPlayerType();
        }
    }

    private void destroyPlayer() {
        TinyWindowConfig tinyWindowConfig = this.mConfig;
        if (tinyWindowConfig != null) {
            if (tinyWindowConfig.getPlayerType() == 1) {
                this.mConfig.getLivePlayer().stop();
                if (this.mConfig.getActivity() == null || this.mConfig.getActivity().isFinishing() || this.mConfig.getActivity().isDestroyed()) {
                    this.mConfig.getLivePlayer().release();
                }
            } else if (this.mConfig.getPlayerType() == 0) {
                this.mConfig.getVodPlayer().stop();
                if (this.mConfig.getActivity() == null || this.mConfig.getActivity().isFinishing() || this.mConfig.getActivity().isDestroyed()) {
                    this.mConfig.getVodPlayer().release();
                }
            }
        }
    }

    public static TinyWindowManager getInstance() {
        if (mTinyWindowManager == null) {
            synchronized (TinyWindowManager.class) {
                if (mTinyWindowManager == null) {
                    mTinyWindowManager = new TinyWindowManager();
                }
            }
        }
        return mTinyWindowManager;
    }

    public static boolean isSurportTinyWindow(Activity activity, TinyWindowConfig.TINYWINDOW_TYPE tinywindow_type) {
        PackageManager packageManager;
        TinyLogger.log(TAG, "isSurportTinyWindow");
        boolean z = true;
        if (tinywindow_type == TinyWindowConfig.TINYWINDOW_TYPE.SYSTEMPIP) {
            if (Build.VERSION.SDK_INT < 26) {
                TinyLogger.log(TAG, "Android level lower than Android 8.0, do not support PIP");
                z = false;
            }
            if (activity != null && (packageManager = activity.getApplicationContext().getPackageManager()) != null) {
                boolean hasSystemFeature = packageManager.hasSystemFeature("android.software.picture_in_picture");
                if (!hasSystemFeature) {
                    TinyLogger.log(TAG, "PackageManager hasSystemFeature return false, do not support PIP");
                }
                z = hasSystemFeature;
            }
        } else {
            TinyWindowConfig.TINYWINDOW_TYPE tinywindow_type2 = TinyWindowConfig.TINYWINDOW_TYPE.FLOATINGWINDOW;
        }
        return z ? TinyWindowUtils.enableTinyWindow() : z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayerMute(boolean z) {
        TinyWindowConfig tinyWindowConfig = this.mConfig;
        if (tinyWindowConfig != null) {
            if (tinyWindowConfig.getPlayerType() == 1) {
                this.mConfig.getLivePlayer().getPlayer().setMute(z);
            } else if (this.mConfig.getPlayerType() == 0) {
                this.mConfig.getVodPlayer().setMute(z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayerPause(boolean z) {
        TinyWindowConfig tinyWindowConfig = this.mConfig;
        if (tinyWindowConfig != null) {
            if (tinyWindowConfig.getPlayerType() == 1) {
                if (z) {
                    this.mConfig.getLivePlayer().getPlayer().pause();
                } else {
                    this.mConfig.getLivePlayer().getPlayer().start();
                }
            } else if (this.mConfig.getPlayerType() == 0) {
                if (z) {
                    this.mConfig.getVodPlayer().pause();
                } else {
                    this.mConfig.getVodPlayer().start();
                }
            }
        }
    }

    public void closeTinyWindow() {
        TinyLogger.log(TAG, "closeTinyWindow");
        countTinyWindowTime();
        TinyWindowConfig tinyWindowConfig = this.mConfig;
        if (tinyWindowConfig != null && tinyWindowConfig.getActivity() != null) {
            LocalBroadcastManager.getInstance(this.mConfig.getActivity().getApplicationContext()).unregisterReceiver(this.mReceiver);
        }
        ITinyWindowHelper iTinyWindowHelper = this.mTinyWindowHelper;
        if (iTinyWindowHelper != null) {
            iTinyWindowHelper.hideTinyWindow();
            this.mTinyWindowHelper.destroyTinyWindow();
            this.mIsInTinyWindowMode = false;
        }
    }

    public void destroyTinyWindow() {
        TinyLogger.log(TAG, "destroyTinyWindow");
        closeTinyWindow();
        destroyPlayer();
    }

    public TinyWindowConfig getConfig() {
        return this.mConfig;
    }

    public ITinyWindowHelper getTinyWindowHelper() {
        return this.mTinyWindowHelper;
    }

    public boolean isInTinyWindowMode() {
        return this.mIsInTinyWindowMode;
    }

    @Override // com.youku.tinywindow.TinyWindowHelperListener
    public void onHelperWindowClick() {
        TinyWindowConfig tinyWindowConfig = this.mConfig;
        if (tinyWindowConfig == null) {
            return;
        }
        Nav withFlags = Nav.from(tinyWindowConfig.getActivity().getApplicationContext()).withFlags(ConfigReporter.BIT_GETTER_IMP);
        withFlags.toUri(Uri.parse("https://vku.youku.com/live/ilproom?id=" + this.mConfig.getPlayerId()));
        ITinyWindowHelper iTinyWindowHelper = this.mTinyWindowHelper;
        if (iTinyWindowHelper != null) {
            iTinyWindowHelper.hideTinyWindow();
        }
        int i = 1;
        if (this.mConfig.getPlayerType() != 1 || this.mConfig.getLivePlayer().getPlayVideoInfo() == null) {
            return;
        }
        String string = this.mConfig.getLivePlayer().getPlayVideoInfo().getString("tinywindowNumOfKeep");
        if (!TextUtils.isEmpty(string)) {
            try {
                i = 1 + Integer.parseInt(string);
            } catch (Exception unused) {
                i = 0;
            }
        }
        this.mConfig.getLivePlayer().getPlayVideoInfo().putString("tinywindowNumOfKeep", String.valueOf(i));
    }

    @Override // com.youku.tinywindow.TinyWindowHelperListener
    public void onHelperWindowClosed() {
        TinyLogger.log(TAG, "onHelperWindowClosed");
        countTinyWindowTime();
        destroyPlayer();
        this.mIsInTinyWindowMode = false;
    }

    @Override // com.youku.tinywindow.TinyWindowHelperListener
    public void onHelperWindowMutePlayer(boolean z) {
        TinyLogger.log(TAG, "onHelperWindowMutePlayer");
        setPlayerMute(z);
    }

    @Override // com.youku.tinywindow.TinyWindowHelperListener
    public void onHelperWindowPausePlayer(boolean z) {
        TinyLogger.log(TAG, "onHelperWindowPausePlayer");
        setPlayerPause(z);
    }

    @Override // com.youku.tinywindow.TinyWindowHelperListener
    public void onHelperWindowShowFailed(int i) {
        TinyWindowConfig tinyWindowConfig;
        PlayVideoInfo playVideoInfo;
        TinyLogger.log(TAG, "onHelperWindowShowFailed");
        if (i == 0 && (tinyWindowConfig = this.mConfig) != null && tinyWindowConfig.getPlayerType() == 1 && this.mConfig.getLivePlayer() != null && (playVideoInfo = this.mConfig.getLivePlayer().getPlayVideoInfo()) != null) {
            playVideoInfo.putString("tinywindowRefusePermission", "1");
        }
        TinyWindowListener tinyWindowListener = this.mListener;
        if (tinyWindowListener != null) {
            tinyWindowListener.onTinyWindowShowFailed(i);
        }
    }

    @Override // com.youku.tinywindow.TinyWindowHelperListener
    public void onHelperWindowShowSuccess() {
        TinyLogger.log(TAG, "onHelperWindowShowSuccess");
        Log.e("test111", "showtinywindowdone");
        TinyWindowListener tinyWindowListener = this.mListener;
        if (tinyWindowListener != null) {
            tinyWindowListener.onTinyWindowShowSuccess();
        }
        this.mIsInTinyWindowMode = true;
        this.mEnterTime = System.currentTimeMillis();
        new Intent("");
        LocalBroadcastManager.getInstance(this.mConfig.getActivity().getApplicationContext()).sendBroadcast(new Intent("com.youku.phone.detail.force.quit.pip"));
    }

    public void setTinyWindowListener(TinyWindowListener tinyWindowListener) {
        ITinyWindowHelper iTinyWindowHelper;
        if (tinyWindowListener == null || (iTinyWindowHelper = this.mTinyWindowHelper) == null) {
            return;
        }
        this.mListener = tinyWindowListener;
        iTinyWindowHelper.setTinyWindowHelperListener(this);
    }

    public void showTinyWindow() {
        TinyLogger.log(TAG, "showTinyWindow");
        TinyWindowConfig tinyWindowConfig = this.mConfig;
        if (tinyWindowConfig != null && tinyWindowConfig.getActivity() != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(TINYWINDOW_NOTIFY_QUIT);
            intentFilter.addAction(TINYWINDOW_NOTIFY_MUTE_PLAYER);
            intentFilter.addAction(TINYWINDOW_NOTIFY_PAUSE_PLAYER);
            intentFilter.addAction("com.youku.phone.player.started");
            LocalBroadcastManager.getInstance(this.mConfig.getActivity().getApplicationContext()).registerReceiver(this.mReceiver, intentFilter);
        }
        ITinyWindowHelper iTinyWindowHelper = this.mTinyWindowHelper;
        if (iTinyWindowHelper != null) {
            iTinyWindowHelper.enterTinyWindow();
        }
    }

    public void updateConfig(TinyWindowConfig tinyWindowConfig) {
        if (tinyWindowConfig != null) {
            this.mConfig = tinyWindowConfig;
            if (tinyWindowConfig.getType() == TinyWindowConfig.TINYWINDOW_TYPE.FLOATINGWINDOW) {
                this.mTinyWindowHelper = new FloatingWindowHelper(tinyWindowConfig);
                return;
            } else if (this.mConfig.getType() == TinyWindowConfig.TINYWINDOW_TYPE.SYSTEMPIP) {
                this.mTinyWindowHelper = new PIPHelper(tinyWindowConfig);
                return;
            } else {
                return;
            }
        }
        TinyLogger.log(TAG, "updateConfig:config is null");
    }
}
