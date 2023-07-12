package tb;

import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class zs {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int MODE_FULL_SCREEN = 15;
    public static final int MODE_NORMAL = 14;
    public static final int PLAYER_COMPLETION = 7;
    public static final int PLAYER_ERROR = 8;
    public static final int PLAYER_GET_VIDEO_INFO_FAILED = 9;
    public static final int PLAYER_GET_VIDEO_INFO_SUCCESS = 10;
    public static final int PLAYER_IDLE = 0;
    public static final int PLAYER_LOADING_END = 13;
    public static final int PLAYER_LOADING_START = 12;
    public static final int PLAYER_PAUSE = 4;
    public static final int PLAYER_PLAYING = 5;
    public static final int PLAYER_POSITION_CHANGE = 6;
    public static final int PLAYER_PREPARED = 3;
    public static final int PLAYER_PREPARING = 2;
    public static final int PLAYER_RELEASE = 16;
    public static final int PLAYER_REQUEST = 1;
    public static final int PLAYER_SO_LOAD_ERROR = 17;
    public static final int PLAYER_SO_RELOAD = 18;
    public static final int PLAYER_SO_RELOAD_FAILED = 20;
    public static final int PLAYER_SO_RELOAD_SUCCESS = 19;
    public static final int PLAYER_USER_PAUSE = 11;
    private int a;
    private int b;

    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1169848019") ? ((Integer) ipChange.ipc$dispatch("-1169848019", new Object[]{this})).intValue() : this.b;
    }

    public boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2110133223") ? ((Boolean) ipChange.ipc$dispatch("2110133223", new Object[]{this})).booleanValue() : this.a == 15;
    }

    public boolean c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-72875526")) {
            return ((Boolean) ipChange.ipc$dispatch("-72875526", new Object[]{this})).booleanValue();
        }
        int i = this.b;
        return i == 4 || i == 11;
    }

    public boolean d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "993483522") ? ((Boolean) ipChange.ipc$dispatch("993483522", new Object[]{this})).booleanValue() : this.b == 5;
    }

    public void e(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1015184978")) {
            ipChange.ipc$dispatch("1015184978", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a = i;
        }
    }

    public void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1131389163")) {
            ipChange.ipc$dispatch("-1131389163", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        Log.d("PlayerStatus", "kubus://player 设置播放状态 " + i);
        this.b = i;
    }
}
