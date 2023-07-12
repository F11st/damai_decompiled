package me.ele.altriax.launcher.biz.strategy;

import androidx.annotation.NonNull;
import java.util.HashMap;
import me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchContext;
import me.ele.altriax.launcher.biz.strategy.intent.AltriaXLaunchManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class Discriminator {
    private static AltriaXLaunchContext altriaXLaunchContext;
    private static String dagStrategy;
    public static boolean externalLink;
    public static String externalLinkUrl;
    public static boolean isExternalLinkH5;
    public static boolean isExternalLinkHome;
    public static String realUrl;
    public static String realUrlHost;
    private static HashMap<Strategy, String> strategyDagMap = new HashMap<>();

    public static String identify() {
        return Strategy.DAG_ALTRIAXB_LINK_DAMAI_NOMAL_APP;
    }

    public static void installStrategy(@NonNull Strategy strategy, @NonNull String str) {
        strategyDagMap.put(strategy, str);
    }

    private static AltriaXLaunchContext prepareAltriaXLaunchContext() {
        if (altriaXLaunchContext == null) {
            altriaXLaunchContext = AltriaXLaunchManager.resolveStartupContext();
        }
        return altriaXLaunchContext;
    }
}
