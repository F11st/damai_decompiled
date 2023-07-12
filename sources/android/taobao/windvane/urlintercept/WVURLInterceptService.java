package android.taobao.windvane.urlintercept;

import android.taobao.windvane.urlintercept.WVURLInterceptData;
import java.net.URLDecoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVURLInterceptService {
    private static Set<WVURLInterceptData.RuleData> urlRules = Collections.synchronizedSet(new HashSet());
    private static Map<String, Pattern> rulePat = Collections.synchronizedMap(new HashMap());
    private static WVURLIntercepterInterface mIntercepter = null;
    private static WVURLIntercepterHandler mHandler = null;
    private static WVABTestUrlHandler mABTestHandler = null;

    public static WVABTestUrlHandler getWVABTestHandler() {
        return mABTestHandler;
    }

    public static WVURLIntercepterHandler getWVURLInterceptHandler() {
        return mHandler;
    }

    public static Map<String, Pattern> getWVURLInterceptRulePats() {
        return rulePat;
    }

    public static WVURLIntercepterInterface getWVURLIntercepter() {
        return mIntercepter;
    }

    public static Set<WVURLInterceptData.RuleData> getWVURLinterceptRules() {
        return urlRules;
    }

    public static void registerWVABTestURLHandler(WVABTestUrlHandler wVABTestUrlHandler) {
        mABTestHandler = wVABTestUrlHandler;
    }

    public static void registerWVURLInterceptHandler(WVURLIntercepterHandler wVURLIntercepterHandler) {
        mHandler = wVURLIntercepterHandler;
    }

    public static void registerWVURLInterceptRulePats(Map<String, Pattern> map) {
        rulePat = map;
    }

    public static void registerWVURLIntercepter(WVURLIntercepterInterface wVURLIntercepterInterface) {
        mIntercepter = wVURLIntercepterInterface;
    }

    public static void registerWVURLinterceptRules(Set<WVURLInterceptData.RuleData> set) {
        Iterator<WVURLInterceptData.RuleData> it = set.iterator();
        while (it != null && it.hasNext()) {
            WVURLInterceptData.RuleData next = it.next();
            if (next.needdecode) {
                try {
                    next.pattern = URLDecoder.decode(next.pattern, "utf-8");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        urlRules = set;
    }

    public static void resetRulesAndPat() {
        urlRules.clear();
        rulePat.clear();
    }
}
