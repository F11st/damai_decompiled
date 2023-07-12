package cn.damai.h5container.h5url;

import cn.damai.common.AppConfig;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class VipUrlGetter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String VIP_BUY_ONLINE = "https://m.damai.cn/damai/activity/vip/join.html";
    public static final String VIP_BUY_PRE = "https://market.wapa.damai.cn/damai/activity/vip/join.html";
    public static final String VIP_BUY_TEST = "https://market.wapa.taobao.com/app/damai/h5-activity/pages/vip/join.html";
    public static final String VIP_CENTER_ONLINE = "https://m.damai.cn/damai/activity/vip/index.html";
    public static final String VIP_CENTER_PRE = "https://market.wapa.damai.cn/damai/activity/vip/index.html";
    public static final String VIP_CENTER_TEST = "https://market.wapa.taobao.com/app/damai/h5-activity/pages/vip/index.html";

    /* compiled from: Taobao */
    /* renamed from: cn.damai.h5container.h5url.VipUrlGetter$1  reason: invalid class name */
    /* loaded from: classes14.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$cn$damai$common$AppConfig$EnvMode;

        static {
            int[] iArr = new int[AppConfig.EnvMode.values().length];
            $SwitchMap$cn$damai$common$AppConfig$EnvMode = iArr;
            try {
                iArr[AppConfig.EnvMode.prepare.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$cn$damai$common$AppConfig$EnvMode[AppConfig.EnvMode.test.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private VipUrlGetter() {
    }

    public static String vipBuyUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390253593")) {
            return (String) ipChange.ipc$dispatch("390253593", new Object[0]);
        }
        if (AppConfig.v()) {
            int i = AnonymousClass1.$SwitchMap$cn$damai$common$AppConfig$EnvMode[AppConfig.h().ordinal()];
            return i != 1 ? i != 2 ? VIP_BUY_ONLINE : VIP_BUY_TEST : VIP_BUY_PRE;
        }
        return VIP_BUY_ONLINE;
    }

    public static String vipCenterUrl() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2002998208")) {
            return (String) ipChange.ipc$dispatch("2002998208", new Object[0]);
        }
        if (AppConfig.v()) {
            int i = AnonymousClass1.$SwitchMap$cn$damai$common$AppConfig$EnvMode[AppConfig.h().ordinal()];
            return i != 1 ? i != 2 ? VIP_CENTER_ONLINE : VIP_CENTER_TEST : VIP_CENTER_PRE;
        }
        return VIP_CENTER_ONLINE;
    }
}
