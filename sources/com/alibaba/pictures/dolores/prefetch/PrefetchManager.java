package com.alibaba.pictures.dolores.prefetch;

import android.os.Bundle;
import com.alibaba.pictures.dolores.config.IGlobalConfig;
import com.alibaba.pictures.dolores.prefetch.page.PrefetchPageMo;
import com.alibaba.pictures.dolores.request.DoloresRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import org.android.spdy.spduLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.bc0;
import tb.k50;
import tb.rb0;
import tb.sb0;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class PrefetchManager {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    @NotNull
    public static final String TAG = "MtopPrefetch";
    @NotNull
    private static final Lazy c;
    private final Lazy a;
    @Nullable
    private String b;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private static transient /* synthetic */ IpChange $ipChange;

        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    static {
        Lazy a2;
        a2 = b.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<PrefetchManager>() { // from class: com.alibaba.pictures.dolores.prefetch.PrefetchManager$Companion$instance$2
            private static transient /* synthetic */ IpChange $ipChange;

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PrefetchManager invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-2076621659") ? (PrefetchManager) ipChange.ipc$dispatch("-2076621659", new Object[]{this}) : new PrefetchManager();
            }
        });
        c = a2;
    }

    public PrefetchManager() {
        Lazy b;
        b = b.b(new Function0<HashMap<String, PrefetchPageMo>>() { // from class: com.alibaba.pictures.dolores.prefetch.PrefetchManager$pageList$2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, PrefetchPageMo> invoke() {
                IpChange ipChange = $ipChange;
                return AndroidInstantRuntime.support(ipChange, "-1299922613") ? (HashMap) ipChange.ipc$dispatch("-1299922613", new Object[]{this}) : new HashMap<>();
            }
        });
        this.a = b;
    }

    private final HashMap<String, PrefetchPageMo> b() {
        IpChange ipChange = $ipChange;
        return (HashMap) (AndroidInstantRuntime.support(ipChange, "1354709305") ? ipChange.ipc$dispatch("1354709305", new Object[]{this}) : this.a.getValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(String str, Bundle bundle) {
        rb0 a2;
        boolean K;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-546039429")) {
            ipChange.ipc$dispatch("-546039429", new Object[]{this, str, bundle});
            return;
        }
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = this.b;
        if (str2 == null) {
            IGlobalConfig a3 = sb0.Companion.a();
            str2 = a3 != null ? a3.getGlobalConfig(IGlobalConfig.Key.PREFETCH_BLACK_LIST, null) : null;
        }
        if (str2 != null) {
            K = StringsKt__StringsKt.K(str2, str, false, 2, null);
            if (K) {
                spduLog.Logd(TAG, "数据预加载页面在黑名单中，放弃预加载" + str);
                return;
            }
        }
        PrefetchPageMo prefetchPageMo = b().get(str);
        if (prefetchPageMo == null) {
            spduLog.Logd(TAG, "数据预加载未配置页面" + str);
            return;
        }
        ArrayList<PrefetchRequestBuilder<?>> requestList = prefetchPageMo.getRequestList();
        if (requestList != null) {
            Iterator<T> it = requestList.iterator();
            while (it.hasNext()) {
                PrefetchRequestBuilder prefetchRequestBuilder = (PrefetchRequestBuilder) it.next();
                if (prefetchRequestBuilder instanceof PrefetchRequestAction) {
                    Function2<Bundle, PrefetchPageMo, wt2> requestAction = ((PrefetchRequestAction) prefetchRequestBuilder).getRequestAction();
                    if (requestAction != null) {
                        requestAction.invoke(bundle, prefetchPageMo);
                    }
                } else {
                    DoloresRequest build = prefetchRequestBuilder.build(bundle);
                    spduLog.Logd(TAG, "数据预加载开始加载" + str + " request:" + build);
                    if (build != null && (a2 = bc0.a(build)) != null) {
                        rb0.e(a2, prefetchPageMo.getExpireTime(), null, 2, null);
                    }
                }
            }
        }
    }
}
