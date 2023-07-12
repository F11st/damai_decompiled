package com.alibaba.pictures.abtest.provider;

import com.ali.user.open.core.util.ParamsConstants;
import com.alibaba.pictures.abtest.model.ABTestExperiment;
import com.alibaba.pictures.abtest.model.ABTestScenarioResult;
import com.alibaba.pictures.abtest.model.ABTestScenarioResultList;
import com.alibaba.pictures.abtest.request.ABTestExperimentRequest;
import com.alibaba.pictures.abtest.request.ABTestUploadRequest;
import com.alibaba.pictures.ut.DogCat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.gson.Gson;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.C8889a;
import tb.C8985c;
import tb.C9021d;
import tb.b41;
import tb.dc0;
import tb.rb0;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class ABTestProvider {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String ABTestCacheKey = "ABTestExperimentData_";
    private static ABTestScenarioResultList a;
    private static String b;
    private static String c;
    @NotNull
    public static final ABTestProvider INSTANCE = new ABTestProvider();
    private static Set<String> d = new LinkedHashSet();

    private ABTestProvider() {
    }

    private final String b(ABTestExperiment aBTestExperiment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1420511100")) {
            return (String) ipChange.ipc$dispatch("-1420511100", new Object[]{this, aBTestExperiment});
        }
        StringBuilder sb = new StringBuilder();
        if (aBTestExperiment != null) {
            sb.append(aBTestExperiment.scenario);
            sb.append(".");
            Long l = aBTestExperiment.experimentId;
            b41.h(l, "experimentId");
            sb.append(l.longValue());
            sb.append("|");
            ABTestExperiment.Params params = aBTestExperiment.params;
            sb.append(params != null ? params.bucketId : null);
            sb.append(";");
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply {\n…       }\n    }.toString()");
        return sb2;
    }

    public static /* synthetic */ String g(ABTestProvider aBTestProvider, String str, Long l, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return aBTestProvider.f(str, l, str2);
    }

    private final String h() {
        List<ABTestScenarioResult> list;
        List<ABTestExperiment> list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1207865922")) {
            return (String) ipChange.ipc$dispatch("1207865922", new Object[]{this});
        }
        ABTestScenarioResultList c2 = c();
        if (c2 == null || (list = c2.scenarioResultList) == null) {
            return "";
        }
        for (ABTestScenarioResult aBTestScenarioResult : list) {
            if (!(!b41.d(b, aBTestScenarioResult.scenario)) && (list2 = aBTestScenarioResult.experimentList) != null) {
                Iterator<T> it = list2.iterator();
                if (it.hasNext()) {
                    return INSTANCE.b((ABTestExperiment) it.next());
                }
            }
        }
        return "";
    }

    public static /* synthetic */ void k(ABTestProvider aBTestProvider, String str, Long l, String str2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            bool = Boolean.TRUE;
        }
        aBTestProvider.j(str, l, str2, bool);
    }

    public static /* synthetic */ void m(ABTestProvider aBTestProvider, List list, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = Boolean.TRUE;
        }
        aBTestProvider.l(list, bool);
    }

    @Nullable
    public final ABTestScenarioResultList c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1183621581")) {
            return (ABTestScenarioResultList) ipChange.ipc$dispatch("-1183621581", new Object[]{this});
        }
        ABTestScenarioResultList aBTestScenarioResultList = a;
        if (aBTestScenarioResultList != null) {
            return aBTestScenarioResultList;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("ABTestCacheKey: ABTestExperimentData_");
            C9021d.C9022a c9022a = C9021d.Companion;
            String b2 = c9022a.b().b();
            if (b2 == null) {
                b2 = "";
            }
            sb.append(b2);
            C8985c.b(null, sb.toString(), 1, null);
            Gson gson = new Gson();
            C8889a c8889a = C8889a.INSTANCE;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ABTestCacheKey);
            String b3 = c9022a.b().b();
            sb2.append(b3 != null ? b3 : "");
            return (ABTestScenarioResultList) gson.fromJson(c8889a.b(sb2.toString()), (Class<Object>) ABTestScenarioResultList.class);
        } catch (Exception e) {
            C8985c.b(null, "getABAllExperimentData error=" + e, 1, null);
            return a;
        }
    }

    @NotNull
    public final String d() {
        List<ABTestScenarioResult> list;
        List<ABTestExperiment> list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-656097181")) {
            return (String) ipChange.ipc$dispatch("-656097181", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        ABTestScenarioResultList c2 = INSTANCE.c();
        if (c2 != null && (list = c2.scenarioResultList) != null) {
            for (ABTestScenarioResult aBTestScenarioResult : list) {
                if (aBTestScenarioResult != null && (list2 = aBTestScenarioResult.experimentList) != null) {
                    for (ABTestExperiment aBTestExperiment : list2) {
                        sb.append(INSTANCE.b(aBTestExperiment));
                    }
                }
            }
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply {\n…       }\n    }.toString()");
        return sb2;
    }

    @NotNull
    public final String e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2066715869")) {
            return (String) ipChange.ipc$dispatch("2066715869", new Object[]{this});
        }
        StringBuilder sb = new StringBuilder();
        for (String str : d) {
            sb.append(str);
        }
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder().apply {\n…       }\n    }.toString()");
        return sb2;
    }

    @Nullable
    public final String f(@Nullable String str, @Nullable Long l, @Nullable String str2) {
        ABTestExperiment.Params params;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "360756829")) {
            return (String) ipChange.ipc$dispatch("360756829", new Object[]{this, str, l, str2});
        }
        b = str;
        C9021d.C9022a c9022a = C9021d.Companion;
        if (!c9022a.b().a()) {
            m(this, c9022a.b().c(), null, 2, null);
        }
        if (str2 == null || str2.length() == 0) {
            ABTestExperiment i = i(str, l);
            str2 = (i == null || (params = i.params) == null) ? null : params.bucketId;
        }
        c = str2;
        if (!(str2 == null || str2.length() == 0)) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("spm", "app.yingyan.abtest.get");
            linkedHashMap.put(ParamsConstants.Key.PARAM_SCENE_CODE, String.valueOf(str));
            linkedHashMap.put("experimentId", String.valueOf(l));
            linkedHashMap.put("bucketId", String.valueOf(c));
            DogCat.INSTANCE.g().c("Page_All").b("MVPABTestGetBucket").d(linkedHashMap).a();
        }
        String h = h();
        if (h.length() > 0) {
            d.add(h);
        }
        return c;
    }

    @Nullable
    public final ABTestExperiment i(@Nullable String str, @Nullable Long l) {
        ABTestScenarioResultList c2;
        List<ABTestScenarioResult> list;
        List<ABTestExperiment> list2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "468534438")) {
            return (ABTestExperiment) ipChange.ipc$dispatch("468534438", new Object[]{this, str, l});
        }
        if (str != null && l != null && (c2 = c()) != null && (list = c2.scenarioResultList) != null) {
            for (ABTestScenarioResult aBTestScenarioResult : list) {
                if (!(!b41.d(str, aBTestScenarioResult.scenario)) && (list2 = aBTestScenarioResult.experimentList) != null) {
                    for (ABTestExperiment aBTestExperiment : list2) {
                        if (b41.d(l, aBTestExperiment.experimentId)) {
                            return aBTestExperiment;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public final void j(@Nullable String str, @Nullable Long l, @Nullable String str2, @Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1658612360")) {
            ipChange.ipc$dispatch("1658612360", new Object[]{this, str, l, str2, bool});
            return;
        }
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (z) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("spm", "app.yingyan.abtest.touch");
        linkedHashMap.put(ParamsConstants.Key.PARAM_SCENE_CODE, String.valueOf(str));
        linkedHashMap.put("experimentId", String.valueOf(l));
        linkedHashMap.put("bucketId", String.valueOf(str2));
        linkedHashMap.put("needReport", String.valueOf(bool));
        DogCat.INSTANCE.g().c("Page_All").b("MVPABTestTouch").d(linkedHashMap).a();
    }

    public final void l(@Nullable List<String> list, @Nullable Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "241589815")) {
            ipChange.ipc$dispatch("241589815", new Object[]{this, list, bool});
            return;
        }
        ABTestExperimentRequest aBTestExperimentRequest = new ABTestExperimentRequest();
        aBTestExperimentRequest.setScenarios(list);
        aBTestExperimentRequest.setPreload(bool);
        a = null;
        rb0.Companion.b(aBTestExperimentRequest).a().doOnKTSuccess(new Function1<ABTestScenarioResultList, wt2>() { // from class: com.alibaba.pictures.abtest.provider.ABTestProvider$requestABTestExperimentData$1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(ABTestScenarioResultList aBTestScenarioResultList) {
                invoke2(aBTestScenarioResultList);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ABTestScenarioResultList aBTestScenarioResultList) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1380393026")) {
                    ipChange2.ipc$dispatch("-1380393026", new Object[]{this, aBTestScenarioResultList});
                    return;
                }
                b41.i(aBTestScenarioResultList, AdvanceSetting.NETWORK_TYPE);
                C8985c.b(null, "request ABTestExperimentData success", 1, null);
                ABTestProvider aBTestProvider = ABTestProvider.INSTANCE;
                ABTestProvider.a = aBTestScenarioResultList;
                C8889a c8889a = C8889a.INSTANCE;
                StringBuilder sb = new StringBuilder();
                sb.append(ABTestProvider.ABTestCacheKey);
                String b2 = C9021d.Companion.b().b();
                if (b2 == null) {
                    b2 = "";
                }
                sb.append(b2);
                c8889a.c(sb.toString(), aBTestScenarioResultList);
            }
        }).doOnKTSuccessNull(new Function1<dc0<ABTestScenarioResultList>, wt2>() { // from class: com.alibaba.pictures.abtest.provider.ABTestProvider$requestABTestExperimentData$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<ABTestScenarioResultList> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<ABTestScenarioResultList> dc0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-1500524529")) {
                    ipChange2.ipc$dispatch("-1500524529", new Object[]{this, dc0Var});
                    return;
                }
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                C8985c.b(null, "request ABTestExperimentData is null", 1, null);
            }
        }).doOnKTFail(new Function1<dc0<ABTestScenarioResultList>, wt2>() { // from class: com.alibaba.pictures.abtest.provider.ABTestProvider$requestABTestExperimentData$3
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ wt2 invoke(dc0<ABTestScenarioResultList> dc0Var) {
                invoke2(dc0Var);
                return wt2.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull dc0<ABTestScenarioResultList> dc0Var) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "1123929198")) {
                    ipChange2.ipc$dispatch("1123929198", new Object[]{this, dc0Var});
                    return;
                }
                b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                C8985c.b(null, "request ABTestExperimentData fail", 1, null);
            }
        });
    }

    public final void n(@Nullable String str, @Nullable Long l) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "1926320133")) {
            ipChange.ipc$dispatch("1926320133", new Object[]{this, str, l});
            return;
        }
        if (!((str == null || str.length() == 0) ? true : true) && l != null) {
            ABTestExperiment i = i(str, l);
            if (i == null) {
                C8985c.b(null, "request params abUploadInfo is null", 1, null);
                return;
            }
            ABTestUploadRequest aBTestUploadRequest = new ABTestUploadRequest();
            aBTestUploadRequest.setScenario(str);
            aBTestUploadRequest.setAbUploadInfo(new Gson().toJson(i));
            rb0.Companion.b(aBTestUploadRequest).a().doOnKTSuccess(new Function1<ABTestExperiment, wt2>() { // from class: com.alibaba.pictures.abtest.provider.ABTestProvider$startABTestExperiment$1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(ABTestExperiment aBTestExperiment) {
                    invoke2(aBTestExperiment);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable ABTestExperiment aBTestExperiment) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1206188565")) {
                        ipChange2.ipc$dispatch("1206188565", new Object[]{this, aBTestExperiment});
                    } else {
                        C8985c.b(null, "request ABTest Upload success", 1, null);
                    }
                }
            }).doOnKTSuccessNull(new Function1<dc0<ABTestExperiment>, wt2>() { // from class: com.alibaba.pictures.abtest.provider.ABTestProvider$startABTestExperiment$2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(dc0<ABTestExperiment> dc0Var) {
                    invoke2(dc0Var);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull dc0<ABTestExperiment> dc0Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1244374758")) {
                        ipChange2.ipc$dispatch("1244374758", new Object[]{this, dc0Var});
                        return;
                    }
                    b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                    C8985c.b(null, "request ABTest Upload success (null)", 1, null);
                }
            }).doOnKTFail(new Function1<dc0<ABTestExperiment>, wt2>() { // from class: com.alibaba.pictures.abtest.provider.ABTestProvider$startABTestExperiment$3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ wt2 invoke(dc0<ABTestExperiment> dc0Var) {
                    invoke2(dc0Var);
                    return wt2.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull dc0<ABTestExperiment> dc0Var) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-426138811")) {
                        ipChange2.ipc$dispatch("-426138811", new Object[]{this, dc0Var});
                        return;
                    }
                    b41.i(dc0Var, AdvanceSetting.NETWORK_TYPE);
                    C8985c.b(null, "request ABTest Upload fail", 1, null);
                }
            });
            return;
        }
        C8985c.b(null, "request params scenario or experimentId is null", 1, null);
    }
}
