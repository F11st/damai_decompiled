package tb;

import android.text.TextUtils;
import cn.damai.tetris.component.drama.bean.FilterMainBean;
import cn.damai.tetris.component.drama.bean.FilterTagBean;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.core.ut.TrackProxy;
import cn.damai.tetris.core.ut.TrackType;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class jj0 {
    private static transient /* synthetic */ IpChange $ipChange;
    private String a;
    private String b;

    public jj0(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static jj0 a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1720546012") ? (jj0) ipChange.ipc$dispatch("-1720546012", new Object[0]) : new jj0("drama", "selectbtn");
    }

    private void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1508013560")) {
            ipChange.ipc$dispatch("1508013560", new Object[]{this, str, str2});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "drama";
        }
        this.a = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = "selectbtn";
        }
        this.b = str2;
    }

    public void c(ISection iSection) {
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1065362077")) {
            ipChange.ipc$dispatch("1065362077", new Object[]{this, iSection});
        } else if (iSection == null || (trackInfo = iSection.getTrackInfo()) == null) {
        } else {
            b(trackInfo.trackB, trackInfo.trackC);
        }
    }

    public void d(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "749708399")) {
            ipChange.ipc$dispatch("749708399", new Object[]{this, str});
            return;
        }
        HashMap<String, String> f = d23.f();
        d23.b(f, str);
        TrackProxy.a().userTrack(TrackType.click, null, this.a, this.b, "timerange", f, false);
    }

    public void e(FilterMainBean filterMainBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-905775864")) {
            ipChange.ipc$dispatch("-905775864", new Object[]{this, filterMainBean, Integer.valueOf(i)});
        } else if (filterMainBean == null) {
        } else {
            HashMap<String, String> f = d23.f();
            d23.b(f, filterMainBean.name);
            TrackProxy.ITrack a = TrackProxy.a();
            TrackType trackType = TrackType.click;
            String str = this.a;
            String str2 = this.b;
            a.userTrack(trackType, null, str, str2, "sorttype_" + i, f, false);
        }
    }

    public void f(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1208823396")) {
            ipChange.ipc$dispatch("1208823396", new Object[]{this, Integer.valueOf(i), str});
            return;
        }
        HashMap<String, String> f = d23.f();
        d23.b(f, str);
        TrackProxy.ITrack a = TrackProxy.a();
        TrackType trackType = TrackType.click;
        String str2 = this.a;
        String str3 = this.b;
        a.userTrack(trackType, null, str2, str3, "timerange_" + i, f, false);
    }

    public void g(FilterTagBean filterTagBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "892336223")) {
            ipChange.ipc$dispatch("892336223", new Object[]{this, filterTagBean, Integer.valueOf(i)});
        } else if (filterTagBean == null) {
        } else {
            HashMap<String, String> f = d23.f();
            d23.b(f, filterTagBean.name);
            TrackProxy.ITrack a = TrackProxy.a();
            TrackType trackType = TrackType.click;
            String str = this.a;
            String str2 = this.b;
            a.userTrack(trackType, null, str, str2, "type_" + i, f, false);
        }
    }
}
