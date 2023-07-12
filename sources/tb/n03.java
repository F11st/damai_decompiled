package tb;

import android.text.TextUtils;
import cn.damai.wantsee.StartConfig;
import cn.damai.wantsee.WantSeeOrangeConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class n03 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final n03 INSTANCE = new n03();
    @Nullable
    private static WantSeeOrangeConfig a;

    private n03() {
    }

    private final WantSeeOrangeConfig a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "414054609")) {
            return (WantSeeOrangeConfig) ipChange.ipc$dispatch("414054609", new Object[]{this});
        }
        WantSeeOrangeConfig wantSeeOrangeConfig = a;
        if (wantSeeOrangeConfig != null) {
            b41.g(wantSeeOrangeConfig, "null cannot be cast to non-null type cn.damai.wantsee.WantSeeOrangeConfig");
            return wantSeeOrangeConfig;
        }
        WantSeeOrangeConfig wantSeeOrangeConfig2 = null;
        try {
            String b = z20.b();
            if (!TextUtils.isEmpty(b)) {
                StartConfig startConfig = (StartConfig) m61.a(b, StartConfig.class);
                if ((startConfig != null ? startConfig.wantSeeOrangeConfig : null) != null) {
                    wantSeeOrangeConfig2 = startConfig.wantSeeOrangeConfig;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (wantSeeOrangeConfig2 == null) {
            wantSeeOrangeConfig2 = new WantSeeOrangeConfig();
        }
        a = wantSeeOrangeConfig2;
        return wantSeeOrangeConfig2;
    }

    public final boolean b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1234903651") ? ((Boolean) ipChange.ipc$dispatch("-1234903651", new Object[]{this})).booleanValue() : a().isEvaluateListWantSeeOpen;
    }

    public final boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1171307479") ? ((Boolean) ipChange.ipc$dispatch("1171307479", new Object[]{this})).booleanValue() : a().isProjectWantSeeOpen;
    }
}
