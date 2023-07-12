package com.youku.live.livesdk.wkit.utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.LiveActivity;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PipBroadcastReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String FLAG_INST_TAG = "instTag";
    public static String MINI_APP_INSIDE_EXIT = "MiniAppInsideExit";
    public static String MINI_APP_ONPAUSE_FINISHING = "MiniAppOnPauseFinishing";
    public static String PIP_LIVE_EXIT_H5_FROM_LIVE_BROADCAST = "com.youku.phone.exit.h5.from.live";
    public static String PIP_LIVE_PLAYER_BROADCAST = "com.youku.phone.force.quit.pip";
    public static String PIP_LIVE_PLAYER_FULLSCREEN_BROADCAST = "com.youku.phone.player.fullscreen";
    public static String PIP_LIVE_PLAYER_LIVEROOM_BROADCAST = "com.youku.phone.force.quit.pip.liveroom";
    private static final String PIP_TAG = "PlayerInstance";
    public static String SINGLETON_LIVE_ROOM_BROADCAST = "com.youku.phone.singleton.liveroom";
    public static final String SOURCE_KEY = "yk_source_from";
    public static final String SOURCE_VALUE = "yklive";
    private String instTag;
    private Activity mActivity;
    private String mPlayer = null;

    public PipBroadcastReceiver(Activity activity) {
        this.mActivity = null;
        this.mActivity = activity;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2146899829")) {
            ipChange.ipc$dispatch("-2146899829", new Object[]{this, context, intent});
        } else if (intent != null) {
            if (!PIP_LIVE_PLAYER_FULLSCREEN_BROADCAST.equalsIgnoreCase(intent.getAction()) && !PIP_LIVE_PLAYER_LIVEROOM_BROADCAST.equalsIgnoreCase(intent.getAction())) {
                if (PIP_LIVE_EXIT_H5_FROM_LIVE_BROADCAST.equalsIgnoreCase(intent.getAction())) {
                    Activity activity2 = this.mActivity;
                    if (activity2 != null && (activity2 instanceof LiveActivity) && ((LiveActivity) activity2).isInPipMode()) {
                        Log.d(PIP_TAG, "pip live PipBroadcastReceiver recreate context：" + context + " " + this.mActivity.getIntent().getAction() + " " + this.mActivity.getIntent().getData());
                        Intent intent2 = new Intent();
                        intent2.setAction(this.mActivity.getIntent().getAction());
                        intent2.setData(this.mActivity.getIntent().getData());
                        intent2.setPackage(this.mActivity.getPackageName());
                        intent2.setFlags(276824064);
                        context.startActivity(intent2);
                        return;
                    }
                    return;
                } else if (MINI_APP_INSIDE_EXIT.equalsIgnoreCase(intent.getAction())) {
                    Activity activity3 = this.mActivity;
                    if (activity3 != null && (activity3 instanceof LiveActivity) && ((LiveActivity) activity3).isInPipMode()) {
                        Log.d(PIP_TAG, "pip live PipBroadcastReceiver recreate context：" + context + " " + this.mActivity.getIntent().getAction() + " " + this.mActivity.getIntent().getData());
                        if (((LiveActivity) this.mActivity).getIsFromNav() && intent.getExtras() != null && !TextUtils.isEmpty(intent.getExtras().getString(SOURCE_KEY)) && SOURCE_VALUE.equals(intent.getExtras().getString(SOURCE_KEY))) {
                            Intent intent3 = new Intent();
                            intent3.setAction(this.mActivity.getIntent().getAction());
                            intent3.setData(this.mActivity.getIntent().getData());
                            intent3.setPackage(this.mActivity.getPackageName());
                            intent3.setFlags(276824064);
                            context.startActivity(intent3);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (MINI_APP_ONPAUSE_FINISHING.equals(intent.getAction())) {
                    Activity activity4 = this.mActivity;
                    if (activity4 != null && (activity4 instanceof LiveActivity) && ((LiveActivity) activity4).isInPipMode()) {
                        Log.d(PIP_TAG, "pip live PipBroadcastReceiver recreate context：" + context + " " + this.mActivity.getIntent().getAction() + " " + this.mActivity.getIntent().getData());
                        if (((LiveActivity) this.mActivity).getIsFromNav()) {
                            Intent intent4 = new Intent();
                            intent4.setAction(this.mActivity.getIntent().getAction());
                            intent4.setData(this.mActivity.getIntent().getData());
                            intent4.setPackage(this.mActivity.getPackageName());
                            intent4.setFlags(276824064);
                            context.startActivity(intent4);
                            return;
                        }
                        return;
                    }
                    return;
                } else if (SINGLETON_LIVE_ROOM_BROADCAST.equalsIgnoreCase(intent.getAction()) && (activity = this.mActivity) != null && (activity instanceof LiveActivity)) {
                    String stringExtra = intent.getStringExtra("instTag");
                    if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(this.instTag) || this.instTag.equalsIgnoreCase(stringExtra)) {
                        return;
                    }
                    ((LiveActivity) this.mActivity).finishByUser(false);
                    return;
                } else {
                    return;
                }
            }
            Log.d(PIP_TAG, "pip live PipBroadcastReceiver 获得 intent.getAction() " + intent.getAction());
            Activity activity5 = this.mActivity;
            if (activity5 != null && (activity5 instanceof LiveActivity) && ((LiveActivity) activity5).isInPipMode()) {
                Log.d(PIP_TAG, "pip live PipBroadcastReceiver finish  ");
                ((LiveActivity) this.mActivity).finishByUser(false);
                this.mActivity = null;
            }
        }
    }

    public void setInstTag(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1325253468")) {
            ipChange.ipc$dispatch("-1325253468", new Object[]{this, str});
        } else {
            this.instTag = str;
        }
    }

    public void unRegister() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1707155088")) {
            ipChange.ipc$dispatch("-1707155088", new Object[]{this});
        } else {
            this.mActivity = null;
        }
    }
}
