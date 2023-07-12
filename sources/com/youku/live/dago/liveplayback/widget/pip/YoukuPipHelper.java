package com.youku.live.dago.liveplayback.widget.pip;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.util.Rational;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.alixplayer.opensdk.IPlayerContainer;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.live.dago.liveplayback.R;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: Taobao */
@RequiresApi(api = 26)
/* loaded from: classes2.dex */
public class YoukuPipHelper {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String ACTION_MEDIA_CONTROL = "media_control";
    public static final String ACTION_OTHER_STARTED = "com.youku.phone.player.started";
    private static final String ACTION_PIP_ENTER = "com.youku.phone.pip.enter";
    private static final String ACTION_PIP_QUIT = "com.youku.phone.pip.quit";
    public static final int CONTROL_TYPE_MUTE = 2;
    public static final String EXTRA_CONTROL_TYPE = "control_type";
    private static final String PIP_KEY = "key_enable_pip";
    private static final String PIP_NAMESPACE = "youku_pip_config";
    public static final int REQUEST_MUTE = 2;
    private static final String TAG = "YoukuPipHelper";
    private static YoukuPipHelper mInstance = new YoukuPipHelper();
    private WeakReference<Activity> mActivityWk;
    private Context mApplicationContext;
    private IPlayerContainer mPlayerContainer;
    private BroadcastReceiver mReceiver;
    private State mState;
    private boolean mIsInPictureInPictureMode = false;
    private final PictureInPictureParams.Builder mPictureInPictureParamsBuilder = new PictureInPictureParams.Builder();
    private BroadcastReceiver mPiPBroadcastReceiver = new BroadcastReceiver() { // from class: com.youku.live.dago.liveplayback.widget.pip.YoukuPipHelper.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1845683284")) {
                ipChange.ipc$dispatch("1845683284", new Object[]{this, context, intent});
            } else if (intent == null) {
            } else {
                if (!YoukuPipHelper.this.isInPictureInPictureMode() && YoukuPipHelper.this.mState != State.LOADING) {
                    TLogUtil.playLog("非小窗状态，不响应外界广播");
                } else if ("com.youku.phone.player.started".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("hashCode", 0);
                    boolean booleanExtra = intent.getBooleanExtra("isMuted", false);
                    if (YoukuPipHelper.this.mPlayerContainer == null || YoukuPipHelper.this.mPlayerContainer.getPlayer().hashCode() == intExtra || booleanExtra || YoukuPipHelper.this.mPlayerContainer.getPlayer().isMuted()) {
                        return;
                    }
                    YoukuPipHelper.this.mPlayerContainer.getPlayer().setMute(true);
                    YoukuPipHelper.this.updateActions();
                }
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public enum State {
        LOADING,
        FINISH
    }

    private YoukuPipHelper() {
    }

    public static synchronized YoukuPipHelper getInstance() {
        synchronized (YoukuPipHelper.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1044471909")) {
                return (YoukuPipHelper) ipChange.ipc$dispatch("-1044471909", new Object[0]);
            }
            return mInstance;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateActions() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1806251311")) {
            ipChange.ipc$dispatch("1806251311", new Object[]{this});
            return;
        }
        IPlayerContainer iPlayerContainer = this.mPlayerContainer;
        if (iPlayerContainer != null) {
            updatePictureInPictureActions(iPlayerContainer.getPlayer().isMuted() ? R.C7933drawable.btn_pip_voice_off : R.C7933drawable.btn_pip_voice_on, "静音", 2, 2);
        }
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1537643031")) {
            ipChange.ipc$dispatch("-1537643031", new Object[]{this});
            return;
        }
        if (this.mPlayerContainer != null) {
            this.mPlayerContainer = null;
        }
        this.mIsInPictureInPictureMode = false;
        try {
            LocalBroadcastManager.getInstance(this.mApplicationContext).unregisterReceiver(this.mPiPBroadcastReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BroadcastReceiver broadcastReceiver = this.mReceiver;
        if (broadcastReceiver != null) {
            try {
                this.mApplicationContext.unregisterReceiver(broadcastReceiver);
                this.mReceiver = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.mActivityWk.clear();
        this.mActivityWk = null;
        this.mState = State.FINISH;
    }

    public int enterPipMode(Rational rational) {
        boolean z;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-857050124")) {
            return ((Integer) ipChange.ipc$dispatch("-857050124", new Object[]{this, rational})).intValue();
        }
        Log.d(TAG, "enterPipMode");
        if (!isSupportPip()) {
            Log.d(TAG, "do not support pip, just return");
            return -1;
        }
        if (rational != null) {
            try {
                int floatValue = (int) (rational.floatValue() * 1000.0f);
                if (floatValue > 2390 || floatValue < 418) {
                    Log.d(TAG, "enter pid params error, aspect ratio : " + rational.floatValue());
                    return -1;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mPictureInPictureParamsBuilder.setAspectRatio(rational).build();
            WeakReference<Activity> weakReference = this.mActivityWk;
            if (weakReference != null && weakReference.get() != null) {
                this.mState = State.LOADING;
                try {
                    z = this.mActivityWk.get().enterPictureInPictureMode(this.mPictureInPictureParamsBuilder.build());
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    z = false;
                }
                updateActions();
                if (z) {
                    return 0;
                }
            }
        }
        return -1;
    }

    public State getState() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1825906778") ? (State) ipChange.ipc$dispatch("1825906778", new Object[]{this}) : this.mState;
    }

    public boolean isInPictureInPictureMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1267589598") ? ((Boolean) ipChange.ipc$dispatch("1267589598", new Object[]{this})).booleanValue() : this.mIsInPictureInPictureMode;
    }

    public boolean isSupportPip() {
        boolean hasSystemFeature;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-1913460167")) {
            return ((Boolean) ipChange.ipc$dispatch("-1913460167", new Object[]{this})).booleanValue();
        }
        if (Build.VERSION.SDK_INT < 26) {
            Log.e(TAG, "Android level lower than Android 8.0, do not support PIP");
            return false;
        }
        Context context = this.mApplicationContext;
        if (context != null) {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            if (packageManager != null && !(hasSystemFeature = packageManager.hasSystemFeature("android.software.picture_in_picture"))) {
                Log.e(TAG, "PackageManager hasSystemFeature return false, do not support PIP");
                return hasSystemFeature;
            }
            String config = ConfigFetcher.getInstance().getConfig(PIP_NAMESPACE, PIP_KEY, "1");
            Log.d(TAG, "key_enable_pip value: " + config);
            z = (TextUtils.isEmpty(config) || !config.equals("1")) ? false : false;
            Log.d(TAG, "isSupportPip: " + z);
            return z;
        }
        return false;
    }

    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-138125208")) {
            ipChange.ipc$dispatch("-138125208", new Object[]{this, Boolean.valueOf(z), configuration});
            return;
        }
        Log.d(TAG, "onPictureInPictureModeChanged： " + z);
        this.mIsInPictureInPictureMode = z;
        this.mState = State.FINISH;
        if (this.mApplicationContext == null || this.mPlayerContainer == null) {
            return;
        }
        if (z) {
            LocalBroadcastManager.getInstance(this.mApplicationContext).sendBroadcast(new Intent(ACTION_PIP_ENTER));
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.youku.live.dago.liveplayback.widget.pip.YoukuPipHelper.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "541289555")) {
                        ipChange2.ipc$dispatch("541289555", new Object[]{this, context, intent});
                        return;
                    }
                    Log.d(YoukuPipHelper.TAG, "onReceive");
                    if (intent != null && YoukuPipHelper.ACTION_MEDIA_CONTROL.equals(intent.getAction()) && intent.getIntExtra(YoukuPipHelper.EXTRA_CONTROL_TYPE, 0) == 2) {
                        Log.d(YoukuPipHelper.TAG, "CONTROL_TYPE_MUTE");
                        if (YoukuPipHelper.this.mPlayerContainer != null) {
                            if (YoukuPipHelper.this.mPlayerContainer.getPlayer().isMuted()) {
                                YoukuPipHelper.this.mPlayerContainer.getPlayer().setMute(false);
                            } else {
                                YoukuPipHelper.this.mPlayerContainer.getPlayer().setMute(true);
                            }
                            YoukuPipHelper.this.updateActions();
                        }
                    }
                }
            };
            this.mReceiver = broadcastReceiver;
            this.mApplicationContext.registerReceiver(broadcastReceiver, new IntentFilter(ACTION_MEDIA_CONTROL));
            return;
        }
        LocalBroadcastManager.getInstance(this.mApplicationContext).sendBroadcast(new Intent(ACTION_PIP_QUIT));
        try {
            this.mApplicationContext.unregisterReceiver(this.mReceiver);
            this.mReceiver = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.mPlayerContainer.getPlayer().isMuted()) {
            this.mPlayerContainer.getPlayer().setMute(false);
        }
    }

    public void setPipContext(IPlayerContainer iPlayerContainer, Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-491769132")) {
            ipChange.ipc$dispatch("-491769132", new Object[]{this, iPlayerContainer, activity});
            return;
        }
        this.mPlayerContainer = iPlayerContainer;
        this.mActivityWk = new WeakReference<>(activity);
        Context applicationContext = activity.getApplicationContext();
        this.mApplicationContext = applicationContext;
        LocalBroadcastManager.getInstance(applicationContext).registerReceiver(this.mPiPBroadcastReceiver, new IntentFilter("com.youku.phone.player.started"));
    }

    public void updatePictureInPictureActions(@DrawableRes int i, String str, int i2, int i3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1256920285")) {
            ipChange.ipc$dispatch("-1256920285", new Object[]{this, Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3)});
            return;
        }
        Log.d(TAG, "updatePictureInPictureActions");
        if (Build.VERSION.SDK_INT >= 26) {
            ArrayList arrayList = new ArrayList();
            WeakReference<Activity> weakReference = this.mActivityWk;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            arrayList.add(new RemoteAction(Icon.createWithResource(this.mApplicationContext, i), str, str, PendingIntent.getBroadcast(this.mApplicationContext, i3, new Intent(ACTION_MEDIA_CONTROL).putExtra(EXTRA_CONTROL_TYPE, i2), 0)));
            this.mPictureInPictureParamsBuilder.setActions(arrayList);
            this.mActivityWk.get().setPictureInPictureParams(this.mPictureInPictureParamsBuilder.build());
        }
    }
}
