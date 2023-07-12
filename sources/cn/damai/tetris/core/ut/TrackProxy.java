package cn.damai.tetris.core.ut;

import android.view.View;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes16.dex */
public class TrackProxy {
    private static transient /* synthetic */ IpChange $ipChange;
    static ITrack a;

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface ITrack {
        void userTrack(TrackType trackType, View view, String str, String str2, String str3, Map<String, String> map, boolean z);
    }

    public static ITrack a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1907184167") ? (ITrack) ipChange.ipc$dispatch("1907184167", new Object[0]) : a;
    }

    public static void b(ITrack iTrack) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-52563715")) {
            ipChange.ipc$dispatch("-52563715", new Object[]{iTrack});
        } else {
            a = iTrack;
        }
    }

    public static void c(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-136694762")) {
            ipChange.ipc$dispatch("-136694762", new Object[]{str, str2, map});
        } else {
            a().userTrack(TrackType.warning, null, null, str, str2, map, false);
        }
    }
}
