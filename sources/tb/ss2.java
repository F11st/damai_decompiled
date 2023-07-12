package tb;

import com.alibaba.pictures.ut.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class ss2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String AB_TRACK_INFO = "ABTrackInfo";
    @NotNull
    public static final String SPM_CURRENT_PAGE_KEY = "spm-cnt";
    @NotNull
    public static final String SPM_GLOBAL_PAGE_NAME = "Page_ALL";
    @NotNull
    public static final String SPM_GLOBAL_PAGE_SPM = "10575321";
    @NotNull
    public static final String SPM_PRE_PAGE_KEY = "spm";
    @NotNull
    public static final String UT_CONST_SPM = "spm";
    @NotNull
    public static final String UT_CONST_SQM = "sqm";
    private static int a = R$id.movie_spm_value;
    private static int b = R$id.movie_spm_page_apm_b;

    public static final int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1632550649") ? ((Integer) ipChange.ipc$dispatch("1632550649", new Object[0])).intValue() : a;
    }

    public static final int b() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-764368883") ? ((Integer) ipChange.ipc$dispatch("-764368883", new Object[0])).intValue() : b;
    }
}
