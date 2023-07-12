package com.alibaba.security.biometrics.component;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import com.alibaba.security.common.d.C3812i;

/* compiled from: Taobao */
@InterfaceC3773f(a = 7)
/* loaded from: classes8.dex */
public class AudioSettingComponent extends AbstractC3768a {
    public boolean d;
    public AudioManager e;
    private SoundBroadCastReceiver f;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class SoundBroadCastReceiver extends BroadcastReceiver {
        public SoundBroadCastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int d = AudioSettingComponent.this.d();
            AudioSettingComponent.this.d = d == 0;
            ((MediaSystemComponent) C3772e.a(MediaSystemComponent.class)).a(AudioSettingComponent.this.d);
        }
    }

    private boolean e() {
        return this.d;
    }

    private void f() {
        try {
            this.e.setRingerMode(2);
        } catch (Throwable unused) {
        }
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean b() {
        if (this.f != null) {
            try {
                C3812i.a(this.c).a(this.f);
            } catch (Throwable unused) {
            }
            this.f = null;
        }
        return super.b();
    }

    public final int d() {
        try {
            AudioManager audioManager = this.e;
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        super.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener);
        this.e = (AudioManager) activity.getSystemService("audio");
        int d = d();
        boolean z = this.b.soundOn;
        this.d = true;
        if (d == 0) {
            this.d = true;
        } else if (z) {
            this.d = false;
        }
        activity.setVolumeControlStream(3);
        return false;
    }

    @Override // com.alibaba.security.biometrics.component.AbstractC3768a, com.alibaba.security.biometrics.component.InterfaceC3771d
    public final boolean a() {
        if (this.f == null) {
            this.f = new SoundBroadCastReceiver();
            C3812i.a(this.c).a(this.f, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
        }
        return super.a();
    }

    private void a(boolean z) {
        this.d = z;
    }

    private void a(Activity activity) {
        int d = d();
        boolean z = this.b.soundOn;
        this.d = true;
        if (d == 0) {
            this.d = true;
        } else if (z) {
            this.d = false;
        }
        activity.setVolumeControlStream(3);
    }
}
