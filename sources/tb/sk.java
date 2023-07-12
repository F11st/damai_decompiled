package tb;

import android.content.res.ColorStateList;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.livesdk.wkit.component.common.utils.SystemBarTintManager;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class sk {
    private static transient /* synthetic */ IpChange $ipChange;

    public static ColorStateList a(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "590353370")) {
            return (ColorStateList) ipChange.ipc$dispatch("590353370", new Object[]{Integer.valueOf(i)});
        }
        int i2 = i - (-805306368);
        return new ColorStateList(new int[][]{new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842912, 16842919}, new int[]{-16842912, 16842919}, new int[]{16842912}, new int[]{-16842912}}, new int[]{i - (-520093696), 268435456, i2, 536870912, i2, 536870912});
    }

    public static ColorStateList b(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "148688343")) {
            return (ColorStateList) ipChange.ipc$dispatch("148688343", new Object[]{Integer.valueOf(i)});
        }
        int[][] iArr = {new int[]{-16842910, 16842912}, new int[]{-16842910}, new int[]{16842919, -16842912}, new int[]{16842919, 16842912}, new int[]{16842912}, new int[]{-16842912}};
        int i2 = i - SystemBarTintManager.DEFAULT_TINT_COLOR;
        return new ColorStateList(iArr, new int[]{i - (-1442840576), -4539718, i2, i2, i | (-16777216), -1118482});
    }
}
