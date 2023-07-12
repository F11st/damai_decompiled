package com.google.vr.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.google.vr.cardboard.annotations.UsedByNative;

/* compiled from: Taobao */
@UsedByNative
/* loaded from: classes10.dex */
public class DeviceInfo {
    private final long a;
    private final Context b;
    private final BroadcastReceiver c = new BroadcastReceiver() { // from class: com.google.vr.audio.DeviceInfo.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                int intExtra = intent.getIntExtra("state", -1);
                if (intExtra == 0) {
                    DeviceInfo deviceInfo = DeviceInfo.this;
                    deviceInfo.nativeUpdateHeadphoneStateChange(deviceInfo.a, 2);
                } else if (intExtra != 1) {
                    DeviceInfo deviceInfo2 = DeviceInfo.this;
                    deviceInfo2.nativeUpdateHeadphoneStateChange(deviceInfo2.a, 0);
                } else {
                    DeviceInfo deviceInfo3 = DeviceInfo.this;
                    deviceInfo3.nativeUpdateHeadphoneStateChange(deviceInfo3.a, 1);
                }
            }
        }
    };

    private DeviceInfo(long j, Context context) {
        this.a = j;
        this.b = context;
    }

    @UsedByNative
    private static DeviceInfo createDeviceInfo(long j, Context context) {
        return new DeviceInfo(j, context);
    }

    @UsedByNative
    private int getSystemBufferSize() {
        return Integer.parseInt(((AudioManager) this.b.getSystemService("audio")).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER"));
    }

    @UsedByNative
    private int getSystemSampleRate() {
        return Integer.parseInt(((AudioManager) this.b.getSystemService("audio")).getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
    }

    @UsedByNative
    private boolean isBluetoothAudioDevicePluggedIn() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) this.b.getSystemService("audio")).getDevices(2)) {
            if (audioDeviceInfo.getType() == 8) {
                return true;
            }
        }
        return false;
    }

    @UsedByNative
    private boolean isHeadphonePluggedIn() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) this.b.getSystemService("audio")).getDevices(2)) {
            if (audioDeviceInfo.getType() == 4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeUpdateHeadphoneStateChange(long j, int i);

    @UsedByNative
    private void registerHandlers() {
        this.b.registerReceiver(this.c, new IntentFilter("android.intent.action.HEADSET_PLUG"));
    }

    @UsedByNative
    private void unregisterHandlers() {
        this.b.unregisterReceiver(this.c);
    }
}
