package com.youku.arch.v3.util;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.ty1;
import tb.wt2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 =2\u00020\u0001:\u0001=B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b<\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R.\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00060)8\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/Ri\u00106\u001aI\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(3\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010\u001f¢\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0006008\u0016@\u0016X\u0096.¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/youku/arch/v3/util/ArchMontior;", "", "", "id", "", "time", "Ltb/wt2;", "setRenderTime", "setBindTime", "uploadComponentsMonitor", "pageName", "Ljava/lang/String;", "getPageName", "()Ljava/lang/String;", "apiName", "getApiName", "setApiName", "(Ljava/lang/String;)V", "requestTime", "J", "getRequestTime", "()J", "setRequestTime", "(J)V", "parseTime", "getParseTime", "setParseTime", "nodeTime", "getNodeTime", "setNodeTime", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/youku/arch/v3/util/Data;", "componentRenderTime", "Ljava/util/concurrent/ConcurrentHashMap;", "getComponentRenderTime", "()Ljava/util/concurrent/ConcurrentHashMap;", "setComponentRenderTime", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "componentBindTime", "getComponentBindTime", "setComponentBindTime", "Lkotlin/Function0;", "uploadPageMonitor", "Lkotlin/jvm/functions/Function0;", "getUploadPageMonitor", "()Lkotlin/jvm/functions/Function0;", "setUploadPageMonitor", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "key", "render", "bind", "uploadComponentMonitor", "Lkotlin/jvm/functions/Function3;", "getUploadComponentMonitor", "()Lkotlin/jvm/functions/Function3;", "setUploadComponentMonitor", "(Lkotlin/jvm/functions/Function3;)V", "<init>", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class ArchMontior {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TAG = "OneArch.ArchMontior";
    @Nullable
    private String apiName;
    @NotNull
    private ConcurrentHashMap<String, Data> componentBindTime;
    @NotNull
    private ConcurrentHashMap<String, Data> componentRenderTime;
    private long nodeTime;
    @NotNull
    private final String pageName;
    private long parseTime;
    private long requestTime;
    public Function3<? super String, ? super Data, ? super Data, wt2> uploadComponentMonitor;
    public Function0<wt2> uploadPageMonitor;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/youku/arch/v3/util/ArchMontior$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public ArchMontior(@NotNull String str) {
        b41.i(str, "pageName");
        this.pageName = str;
        this.componentRenderTime = new ConcurrentHashMap<>();
        this.componentBindTime = new ConcurrentHashMap<>();
    }

    @Nullable
    public final String getApiName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2031861196") ? (String) ipChange.ipc$dispatch("2031861196", new Object[]{this}) : this.apiName;
    }

    @NotNull
    public final ConcurrentHashMap<String, Data> getComponentBindTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1123328108") ? (ConcurrentHashMap) ipChange.ipc$dispatch("-1123328108", new Object[]{this}) : this.componentBindTime;
    }

    @NotNull
    public final ConcurrentHashMap<String, Data> getComponentRenderTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "653674221") ? (ConcurrentHashMap) ipChange.ipc$dispatch("653674221", new Object[]{this}) : this.componentRenderTime;
    }

    public final long getNodeTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "357706198") ? ((Long) ipChange.ipc$dispatch("357706198", new Object[]{this})).longValue() : this.nodeTime;
    }

    @NotNull
    public final String getPageName() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1286503095") ? (String) ipChange.ipc$dispatch("-1286503095", new Object[]{this}) : this.pageName;
    }

    public final long getParseTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2141126131") ? ((Long) ipChange.ipc$dispatch("-2141126131", new Object[]{this})).longValue() : this.parseTime;
    }

    public final long getRequestTime() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-683853391") ? ((Long) ipChange.ipc$dispatch("-683853391", new Object[]{this})).longValue() : this.requestTime;
    }

    @NotNull
    public Function3<String, Data, Data, wt2> getUploadComponentMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-177194105")) {
            return (Function3) ipChange.ipc$dispatch("-177194105", new Object[]{this});
        }
        Function3 function3 = this.uploadComponentMonitor;
        if (function3 != null) {
            return function3;
        }
        b41.A("uploadComponentMonitor");
        return null;
    }

    @NotNull
    public Function0<wt2> getUploadPageMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1253780114")) {
            return (Function0) ipChange.ipc$dispatch("-1253780114", new Object[]{this});
        }
        Function0<wt2> function0 = this.uploadPageMonitor;
        if (function0 != null) {
            return function0;
        }
        b41.A("uploadPageMonitor");
        return null;
    }

    public final void setApiName(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1241901354")) {
            ipChange.ipc$dispatch("1241901354", new Object[]{this, str});
        } else {
            this.apiName = str;
        }
    }

    public final void setBindTime(@NotNull String str, long j) {
        long e;
        long b;
        Integer valueOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931029089")) {
            ipChange.ipc$dispatch("-931029089", new Object[]{this, str, Long.valueOf(j)});
            return;
        }
        b41.i(str, "id");
        if (Integer.parseInt(str) > 32768) {
            str = String.valueOf(Integer.parseInt(str) >> 16);
        }
        Data data = this.componentBindTime.get(str);
        if (data == null) {
            valueOf = null;
        } else {
            e = ty1.e(data.getMinTime(), j);
            data.setMinTime(e);
            b = ty1.b(data.getMaxTime(), j);
            data.setMaxTime(b);
            data.setAverageTime(((data.getAverageTime() * data.getCount()) + j) / (data.getCount() + 1));
            int count = data.getCount();
            data.setCount(count + 1);
            valueOf = Integer.valueOf(count);
        }
        if (valueOf == null) {
            Data data2 = new Data();
            data2.setMinTime(j);
            data2.setMaxTime(j);
            data2.setAverageTime(j);
            data2.setCount(1);
            getComponentBindTime().put(str, data2);
        }
    }

    public final void setComponentBindTime(@NotNull ConcurrentHashMap<String, Data> concurrentHashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948765970")) {
            ipChange.ipc$dispatch("-1948765970", new Object[]{this, concurrentHashMap});
            return;
        }
        b41.i(concurrentHashMap, "<set-?>");
        this.componentBindTime = concurrentHashMap;
    }

    public final void setComponentRenderTime(@NotNull ConcurrentHashMap<String, Data> concurrentHashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1719033419")) {
            ipChange.ipc$dispatch("-1719033419", new Object[]{this, concurrentHashMap});
            return;
        }
        b41.i(concurrentHashMap, "<set-?>");
        this.componentRenderTime = concurrentHashMap;
    }

    public final void setNodeTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885226450")) {
            ipChange.ipc$dispatch("-885226450", new Object[]{this, Long.valueOf(j)});
        } else {
            this.nodeTime = j;
        }
    }

    public final void setParseTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "513154623")) {
            ipChange.ipc$dispatch("513154623", new Object[]{this, Long.valueOf(j)});
        } else {
            this.parseTime = j;
        }
    }

    public final void setRenderTime(@NotNull String str, long j) {
        Integer valueOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1322902600")) {
            ipChange.ipc$dispatch("-1322902600", new Object[]{this, str, Long.valueOf(j)});
            return;
        }
        b41.i(str, "id");
        if (Integer.parseInt(str) > 32768) {
            str = String.valueOf(Integer.parseInt(str) >> 16);
        }
        Data data = this.componentRenderTime.get(str);
        if (data == null) {
            valueOf = null;
        } else {
            data.setMinTime(Math.min(data.getMinTime(), j));
            data.setMaxTime(Math.max(data.getMaxTime(), j));
            data.setAverageTime(((data.getAverageTime() * data.getCount()) + j) / (data.getCount() + 1));
            int count = data.getCount();
            data.setCount(count + 1);
            valueOf = Integer.valueOf(count);
        }
        if (valueOf == null) {
            Data data2 = new Data();
            data2.setMinTime(j);
            data2.setMaxTime(j);
            data2.setAverageTime(j);
            data2.setCount(1);
            getComponentRenderTime().put(str, data2);
        }
    }

    public final void setRequestTime(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1195445787")) {
            ipChange.ipc$dispatch("1195445787", new Object[]{this, Long.valueOf(j)});
        } else {
            this.requestTime = j;
        }
    }

    public void setUploadComponentMonitor(@NotNull Function3<? super String, ? super Data, ? super Data, wt2> function3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1238417493")) {
            ipChange.ipc$dispatch("-1238417493", new Object[]{this, function3});
            return;
        }
        b41.i(function3, "<set-?>");
        this.uploadComponentMonitor = function3;
    }

    public void setUploadPageMonitor(@NotNull Function0<wt2> function0) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1733097630")) {
            ipChange.ipc$dispatch("-1733097630", new Object[]{this, function0});
            return;
        }
        b41.i(function0, "<set-?>");
        this.uploadPageMonitor = function0;
    }

    public final void uploadComponentsMonitor() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "925607460")) {
            ipChange.ipc$dispatch("925607460", new Object[]{this});
            return;
        }
        LogUtil.d(TAG, " uploadComponentsMonitor");
        if (ArchMontiorManager.Companion.needStat(this.pageName)) {
            for (Map.Entry<String, Data> entry : this.componentRenderTime.entrySet()) {
                getUploadComponentMonitor().invoke(entry.getKey(), entry.getValue(), this.componentBindTime.get(entry.getKey()));
            }
            this.componentRenderTime.clear();
            this.componentBindTime.clear();
        }
    }
}
