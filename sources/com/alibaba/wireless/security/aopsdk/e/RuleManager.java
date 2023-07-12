package com.alibaba.wireless.security.aopsdk.e;

import com.alibaba.wireless.security.aopsdk.e.f.ExecutionConfig;
import com.alibaba.wireless.security.aopsdk.e.f.ProxyConfig;
import com.alibaba.wireless.security.aopsdk.e.f.RuleConfig;
import com.alibaba.wireless.security.aopsdk.e.f.StrategyConfig;
import com.alibaba.wireless.security.aopsdk.e.f.TopLevelConfig;
import com.alibaba.wireless.security.aopsdk.i.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* renamed from: com.alibaba.wireless.security.aopsdk.e.d */
/* loaded from: classes.dex */
public class RuleManager implements Observer {
    private static RuleManager c = null;
    private static final String d = "AOP-RULE";
    public Map<String, List<C3978b>> a = new HashMap();
    private TopLevelConfig b;

    /* compiled from: RuleManager.java */
    /* renamed from: com.alibaba.wireless.security.aopsdk.e.d$a */
    /* loaded from: classes.dex */
    public class C3977a {
        public int a;
        public RuleConfig b;

        public C3977a(int i, RuleConfig ruleConfig) {
            ExecutionConfig executionConfig;
            this.a = i;
            this.b = ruleConfig;
            if (RuleManager.this.b != null && (executionConfig = RuleManager.this.b.f) != null) {
                if (ruleConfig.g == -1) {
                    ruleConfig.g = executionConfig.g;
                }
                if (ruleConfig.f == -1) {
                    ruleConfig.f = executionConfig.f;
                }
                if (ruleConfig.i == -1) {
                    ruleConfig.i = executionConfig.i;
                }
                if (ruleConfig.h == -1) {
                    ruleConfig.h = executionConfig.h;
                }
            }
        }
    }

    /* compiled from: RuleManager.java */
    /* renamed from: com.alibaba.wireless.security.aopsdk.e.d$b */
    /* loaded from: classes.dex */
    public static class C3978b {
        public int a;
        public List<C3977a> b;

        public C3978b(int i, List<C3977a> list) {
            this.a = i;
            this.b = list;
        }
    }

    private RuleManager() {
    }

    public Map<String, List<C3978b>> b() {
        return this.a;
    }

    public TopLevelConfig c() {
        return this.b;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        TopLevelConfig topLevelConfig = (TopLevelConfig) obj;
        this.b = topLevelConfig;
        LogUtils.b(d, "top level config updated");
        if (topLevelConfig.g != null) {
            HashMap hashMap = new HashMap();
            for (ProxyConfig proxyConfig : topLevelConfig.g) {
                String str = proxyConfig.d;
                ArrayList arrayList = new ArrayList();
                for (StrategyConfig strategyConfig : proxyConfig.e) {
                    arrayList.add(new C3978b(strategyConfig.d, a(strategyConfig)));
                }
                hashMap.put(str, arrayList);
            }
            this.a = hashMap;
            LogUtils.b(d, "Strategy map updated with " + this.a.size() + " proxies");
            return;
        }
        this.a = new HashMap();
        LogUtils.b(d, "startegy map update to empty");
    }

    public static synchronized RuleManager a() {
        RuleManager ruleManager;
        synchronized (RuleManager.class) {
            if (c == null) {
                c = new RuleManager();
            }
            ruleManager = c;
        }
        return ruleManager;
    }

    private List<C3977a> a(StrategyConfig strategyConfig) {
        ArrayList arrayList = new ArrayList();
        for (RuleConfig ruleConfig : strategyConfig.e) {
            arrayList.add(new C3977a(ruleConfig.m, ruleConfig));
        }
        return arrayList;
    }

    public List<C3978b> a(String str) {
        return this.a.get(str);
    }
}
