package cn.damai.h5container;

import android.content.Context;
import android.content.Intent;
import cn.damai.h5container.UniH5ContainerSwitcher;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.orange.OConfigListener;
import com.taobao.orange.OrangeConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public final class UniH5ContainerSwitcher {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    private static final String BLACKLIST_DEFAULT = "(m.(wapa.)?taopiaopiao.com/tickets/vip/pages/center/index.html)";
    @NotNull
    private static final String CONFIG_WINDVANE_COMMON_RULE = "blackList";
    @NotNull
    private static final String CONFIG_WINDVANE_SWITCH = "open";
    @NotNull
    private static final Lazy<UniH5ContainerSwitcher> Instance$delegate;
    @NotNull
    private static final String ORANGE_GROUP = "movie_windvane";
    @Nullable
    private String blackList;
    private boolean openSwitch = true;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static String XIAOMI = "https://ai.alimebot.taobao.com";

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public static final class Companion {
        private static transient /* synthetic */ IpChange $ipChange;

        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final UniH5ContainerSwitcher getInstance() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "691316085") ? (UniH5ContainerSwitcher) ipChange.ipc$dispatch("691316085", new Object[]{this}) : (UniH5ContainerSwitcher) UniH5ContainerSwitcher.Instance$delegate.getValue();
        }
    }

    static {
        Lazy<UniH5ContainerSwitcher> a;
        a = b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<UniH5ContainerSwitcher>() { // from class: cn.damai.h5container.UniH5ContainerSwitcher$Companion$Instance$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final UniH5ContainerSwitcher invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "880312055") ? (UniH5ContainerSwitcher) ipChange.ipc$dispatch("880312055", new Object[]{this}) : new UniH5ContainerSwitcher();
            }
        });
        Instance$delegate = a;
    }

    @NotNull
    public static final UniH5ContainerSwitcher getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-572095235") ? (UniH5ContainerSwitcher) ipChange.ipc$dispatch("-572095235", new Object[0]) : Companion.getInstance();
    }

    private final boolean notInBlackList(String str) {
        String str2;
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1464665057")) {
            return ((Boolean) ipChange.ipc$dispatch("1464665057", new Object[]{this, str})).booleanValue();
        }
        if (((str == null || str.length() == 0) ? true : true) || (str2 = this.blackList) == null) {
            return true;
        }
        try {
            return true ^ Pattern.compile(str2, 2).matcher(str).find();
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerOrangeConfig$lambda-0  reason: not valid java name */
    public static final void m40registerOrangeConfig$lambda0(UniH5ContainerSwitcher uniH5ContainerSwitcher, String str, Map map) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "595342060")) {
            ipChange.ipc$dispatch("595342060", new Object[]{uniH5ContainerSwitcher, str, map});
            return;
        }
        b41.i(uniH5ContainerSwitcher, "this$0");
        if (b41.d(str, ORANGE_GROUP)) {
            uniH5ContainerSwitcher.openSwitch = b41.d(OrangeConfig.getInstance().getConfig(str, "open", "true"), "true");
            uniH5ContainerSwitcher.blackList = OrangeConfig.getInstance().getConfig(str, CONFIG_WINDVANE_COMMON_RULE, null);
            String config = OrangeConfig.getInstance().getConfig(ORANGE_GROUP, "xiaomi", null);
            if (config != null && config.length() != 0) {
                z = false;
            }
            if (z) {
                return;
            }
            b41.h(config, "xiaomi");
            XIAOMI = config;
        }
    }

    public final void registerOrangeConfig() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1075107003")) {
            ipChange.ipc$dispatch("-1075107003", new Object[]{this});
        } else {
            OrangeConfig.getInstance().registerListener(new String[]{ORANGE_GROUP}, new OConfigListener() { // from class: tb.tt2
                @Override // com.taobao.orange.OConfigListener
                public final void onConfigUpdate(String str, Map map) {
                    UniH5ContainerSwitcher.m40registerOrangeConfig$lambda0(UniH5ContainerSwitcher.this, str, map);
                }
            }, true);
        }
    }

    public final boolean shouldInterceptUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-423873690") ? ((Boolean) ipChange.ipc$dispatch("-423873690", new Object[]{this, str})).booleanValue() : this.openSwitch && notInBlackList(str);
    }

    public final void startUniH5Activity(@NotNull Context context, @NotNull Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1152130537")) {
            ipChange.ipc$dispatch("-1152130537", new Object[]{this, context, intent});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(intent, CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
    }
}
