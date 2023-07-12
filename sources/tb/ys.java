package tb;

import android.util.Log;
import cn.damai.player.DMVideoPlayer;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.EmptyStackException;
import java.util.Stack;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class ys {
    private static transient /* synthetic */ IpChange $ipChange;
    private static ys d;
    private xs a;
    private Stack<DMVideoPlayer> b = new Stack<>();
    private DMVideoPlayer c;

    private ys() {
    }

    public static ys d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1764480663")) {
            return (ys) ipChange.ipc$dispatch("-1764480663", new Object[0]);
        }
        if (d == null) {
            synchronized (ys.class) {
                d = new ys();
            }
        }
        return d;
    }

    public void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1053301631")) {
            ipChange.ipc$dispatch("1053301631", new Object[]{this});
        } else if (b() != null) {
            b().autoPlay();
        }
    }

    public DMVideoPlayer b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1458457297")) {
            return (DMVideoPlayer) ipChange.ipc$dispatch("-1458457297", new Object[]{this});
        }
        try {
            DMVideoPlayer dMVideoPlayer = this.c;
            return dMVideoPlayer == null ? this.b.peek() : dMVideoPlayer;
        } catch (EmptyStackException unused) {
            return null;
        }
    }

    public xs c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1599329234") ? (xs) ipChange.ipc$dispatch("1599329234", new Object[]{this}) : this.a;
    }

    public boolean e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-919136689")) {
            return ((Boolean) ipChange.ipc$dispatch("-919136689", new Object[]{this})).booleanValue();
        }
        Log.d(DMVideoPlayer.TAG, "manager backpress");
        if (b() == null || !b().isFullScreen()) {
            return false;
        }
        return b().exitFullScreen();
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1258309746")) {
            ipChange.ipc$dispatch("1258309746", new Object[]{this});
        } else if (b() != null) {
            Log.d(DMVideoPlayer.TAG, "manager pause");
            b().pause(false);
        }
    }

    public void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2018143570")) {
            ipChange.ipc$dispatch("-2018143570", new Object[]{this});
        } else if (b() != null) {
            Log.d(DMVideoPlayer.TAG, "manager play");
            b().play();
        }
    }

    public void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "160501462")) {
            ipChange.ipc$dispatch("160501462", new Object[]{this});
            return;
        }
        try {
            this.c = null;
            this.b.pop();
        } catch (EmptyStackException unused) {
            System.out.println("empty stack");
        }
    }

    public void i(DMVideoPlayer dMVideoPlayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1727321754")) {
            ipChange.ipc$dispatch("1727321754", new Object[]{this, dMVideoPlayer});
        } else {
            this.b.push(dMVideoPlayer);
        }
    }

    public void j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1180969888")) {
            ipChange.ipc$dispatch("-1180969888", new Object[]{this});
        } else if (b() != null) {
            Log.d(DMVideoPlayer.TAG, "manager releasePlayer");
            b().release();
            h();
        }
    }

    public void k(DMVideoPlayer dMVideoPlayer) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1613047049")) {
            ipChange.ipc$dispatch("-1613047049", new Object[]{this, dMVideoPlayer});
        } else {
            this.c = dMVideoPlayer;
        }
    }

    public void l(xs xsVar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-941939608")) {
            ipChange.ipc$dispatch("-941939608", new Object[]{this, xsVar});
        } else {
            this.a = xsVar;
        }
    }

    public void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1301414534")) {
            ipChange.ipc$dispatch("1301414534", new Object[]{this});
        } else if (b() != null) {
            Log.d(DMVideoPlayer.TAG, "manager start");
            b().start();
        }
    }

    public void n() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "886061856")) {
            ipChange.ipc$dispatch("886061856", new Object[]{this});
        } else if (b() != null) {
            Log.d(DMVideoPlayer.TAG, "manager stop");
            b().stop();
        }
    }
}
