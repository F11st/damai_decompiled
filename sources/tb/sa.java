package tb;

import android.text.TextUtils;
import cn.damai.tetris.core.TrackInfo;
import cn.damai.tetris.v2.structure.section.ISection;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public abstract class sa {
    private static transient /* synthetic */ IpChange $ipChange;

    public void a(ISection iSection, String str, String str2) {
        String str3;
        TrackInfo trackInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-732486055")) {
            ipChange.ipc$dispatch("-732486055", new Object[]{this, iSection, str, str2});
            return;
        }
        String str4 = null;
        if (iSection == null || (trackInfo = iSection.getTrackInfo()) == null) {
            str3 = null;
        } else {
            str4 = trackInfo.trackB;
            str3 = trackInfo.trackC;
        }
        TextUtils.isEmpty(str4);
        TextUtils.isEmpty(str3);
    }
}
