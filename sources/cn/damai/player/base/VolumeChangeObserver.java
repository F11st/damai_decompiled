package cn.damai.player.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class VolumeChangeObserver {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private OnVolumeChangeListener b;
    private VolumeReceiver c;
    private AudioManager d;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface OnVolumeChangeListener {
        void onVolumeChange(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class VolumeReceiver extends BroadcastReceiver {
        private static transient /* synthetic */ IpChange $ipChange;
        private VolumeChangeObserver a;

        VolumeReceiver(VolumeChangeObserver volumeChangeObserver) {
            this.a = volumeChangeObserver;
        }

        private boolean a(Intent intent) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2072309263") ? ((Boolean) ipChange.ipc$dispatch("-2072309263", new Object[]{this, intent})).booleanValue() : intent.getAction() != null && intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") && intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) == 3;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "307966838")) {
                ipChange.ipc$dispatch("307966838", new Object[]{this, context, intent});
                return;
            }
            VolumeChangeObserver volumeChangeObserver = this.a;
            if (volumeChangeObserver == null || volumeChangeObserver == null || volumeChangeObserver.b == null || !a(intent)) {
                return;
            }
            this.a.b.onVolumeChange(this.a.b());
        }
    }

    public VolumeChangeObserver(Context context) {
        this.a = context;
        this.d = (AudioManager) context.getSystemService("audio");
    }

    public int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-331468226") ? ((Integer) ipChange.ipc$dispatch("-331468226", new Object[]{this})).intValue() : this.d.getStreamVolume(3);
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-363649220")) {
            ipChange.ipc$dispatch("-363649220", new Object[]{this});
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        VolumeReceiver volumeReceiver = new VolumeReceiver(this);
        this.c = volumeReceiver;
        this.a.registerReceiver(volumeReceiver, intentFilter);
    }

    public void d(OnVolumeChangeListener onVolumeChangeListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2073588164")) {
            ipChange.ipc$dispatch("-2073588164", new Object[]{this, onVolumeChangeListener});
        } else {
            this.b = onVolumeChangeListener;
        }
    }

    public void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "67327491")) {
            ipChange.ipc$dispatch("67327491", new Object[]{this});
            return;
        }
        VolumeReceiver volumeReceiver = this.c;
        if (volumeReceiver != null) {
            this.a.unregisterReceiver(volumeReceiver);
        }
        this.b = null;
    }
}
