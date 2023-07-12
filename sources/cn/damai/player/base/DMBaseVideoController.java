package cn.damai.player.base;

import android.content.Context;
import android.media.AudioManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import cn.damai.player.base.VolumeChangeObserver;
import cn.damai.player.listener.OnPlayerUTReportListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.PrintStream;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public abstract class DMBaseVideoController extends FrameLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private boolean autoReport;
    int currentVolume;
    protected FragmentActivity mContext;
    protected IVideoPlayer mPlayer;
    protected OnPlayerUTReportListener mUTReportListener;
    VolumeChangeObserver observer;
    private String spmB;
    private String spmC;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class a implements VolumeChangeObserver.OnVolumeChangeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.player.base.VolumeChangeObserver.OnVolumeChangeListener
        public void onVolumeChange(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2093920712")) {
                ipChange.ipc$dispatch("-2093920712", new Object[]{this, Integer.valueOf(i)});
                return;
            }
            PrintStream printStream = System.out;
            printStream.println("currVolume:" + i);
            DMBaseVideoController.this.openVoice(1);
        }
    }

    public DMBaseVideoController(Context context) {
        super(context);
        this.autoReport = false;
        this.mContext = (FragmentActivity) context;
    }

    public void assembleLayers() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-882052365")) {
            ipChange.ipc$dispatch("-882052365", new Object[]{this});
        }
    }

    public void changeVideoData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1707294446")) {
            ipChange.ipc$dispatch("1707294446", new Object[]{this});
        }
    }

    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1452775479")) {
            ipChange.ipc$dispatch("-1452775479", new Object[]{this});
            return;
        }
        VolumeChangeObserver volumeChangeObserver = this.observer;
        if (volumeChangeObserver != null) {
            try {
                volumeChangeObserver.e();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void enableAutoVoice(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1257523291")) {
            ipChange.ipc$dispatch("-1257523291", new Object[]{this, context});
            return;
        }
        this.currentVolume = ((AudioManager) context.getSystemService("audio")).getStreamVolume(3);
        VolumeChangeObserver volumeChangeObserver = new VolumeChangeObserver(context);
        this.observer = volumeChangeObserver;
        volumeChangeObserver.d(new a());
        this.observer.c();
    }

    public String getSpmB() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "50046469") ? (String) ipChange.ipc$dispatch("50046469", new Object[]{this}) : this.spmB;
    }

    public String getSpmC() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "261397382") ? (String) ipChange.ipc$dispatch("261397382", new Object[]{this}) : this.spmC;
    }

    public OnPlayerUTReportListener getUTReportListener() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "790228200") ? (OnPlayerUTReportListener) ipChange.ipc$dispatch("790228200", new Object[]{this}) : this.mUTReportListener;
    }

    public boolean isAutoReport() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-800712194") ? ((Boolean) ipChange.ipc$dispatch("-800712194", new Object[]{this})).booleanValue() : this.autoReport;
    }

    public abstract void onPlayScreenModeChanged(int i);

    public abstract void onPlayStateChanged(int i, Object obj);

    public void openVoice(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-992587288")) {
            ipChange.ipc$dispatch("-992587288", new Object[]{this, Integer.valueOf(i)});
        }
    }

    public void refresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1060273480")) {
            ipChange.ipc$dispatch("1060273480", new Object[]{this});
        }
    }

    public void setAutoReport(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-370409738")) {
            ipChange.ipc$dispatch("-370409738", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.autoReport = z;
        }
    }

    public void setPlayer(IVideoPlayer iVideoPlayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "526151779")) {
            ipChange.ipc$dispatch("526151779", new Object[]{this, iVideoPlayer});
        } else {
            this.mPlayer = iVideoPlayer;
        }
    }

    public void setSpmData(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1482898947")) {
            ipChange.ipc$dispatch("1482898947", new Object[]{this, str, str2});
            return;
        }
        this.spmB = str;
        this.spmC = str2;
    }

    public void stop() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-218460059")) {
            ipChange.ipc$dispatch("-218460059", new Object[]{this});
        }
    }
}
