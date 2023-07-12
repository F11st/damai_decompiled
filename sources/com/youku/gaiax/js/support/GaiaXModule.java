package com.youku.gaiax.js.support;

import com.alibaba.fastjson.JSONArray;
import com.youku.gaiax.js.api.IGaiaXModule;
import com.youku.gaiax.js.api.annotation.GaiaXAsyncMethod;
import com.youku.gaiax.js.api.annotation.GaiaXPromiseMethod;
import com.youku.gaiax.js.api.annotation.GaiaXSyncMethod;
import com.youku.gaiax.js.support.GaiaXMethodInfo;
import com.youku.gaiax.js.utils.IdGenerator;
import com.youku.gaiax.js.utils.Log;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00101\u001a\u00020\u001e¢\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\f\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u000f\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\n\u0010\u0017\u001a\u00060\u0006j\u0002`\u0007R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u00020\u001e8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R%\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020$0#8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010&R\"\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020$0#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010&R\u0013\u0010-\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u00100\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00064"}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXModule;", "", "Ltb/wt2;", "initPromiseMethods", "initAsyncMethods", "initSyncMethods", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "buildScript", "", "initPromiseMethodsScript", "initAsyncMethodsScript", "initSyncMethodsScript", "initMethods$GaiaX_Android_JS", "()V", "initMethods", "", "methodId", "Lcom/alibaba/fastjson/JSONArray;", "args", "invokeMethodSync", "invokeMethodAsync", "invokePromiseMethod", "buildModuleScript", "", "isInit", "Z", "Lcom/youku/gaiax/js/support/GaiaXModuleInfo;", "moduleInfo", "Lcom/youku/gaiax/js/support/GaiaXModuleInfo;", "Lcom/youku/gaiax/js/api/IGaiaXModule;", "module", "Lcom/youku/gaiax/js/api/IGaiaXModule;", "getModule$GaiaX_Android_JS", "()Lcom/youku/gaiax/js/api/IGaiaXModule;", "", "Lcom/youku/gaiax/js/support/GaiaXMethodInfo;", "syncMethods", "Ljava/util/Map;", "getSyncMethods", "()Ljava/util/Map;", "asyncMethods", "promiseMethods", "getId", "()J", "id", "getName", "()Ljava/lang/String;", "name", "nativeModule", "<init>", "(Lcom/youku/gaiax/js/api/IGaiaXModule;)V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXModule {
    @NotNull
    private final Map<Long, GaiaXMethodInfo> asyncMethods;
    private boolean isInit;
    @NotNull
    private final IGaiaXModule module;
    @NotNull
    private final GaiaXModuleInfo moduleInfo;
    @NotNull
    private final Map<Long, GaiaXMethodInfo> promiseMethods;
    @NotNull
    private final Map<Long, GaiaXMethodInfo> syncMethods;

    public GaiaXModule(@NotNull IGaiaXModule iGaiaXModule) {
        b41.i(iGaiaXModule, "nativeModule");
        String name = iGaiaXModule.getName();
        long id = iGaiaXModule.getId();
        String simpleName = iGaiaXModule.getClass().getSimpleName();
        b41.h(simpleName, "nativeModule.javaClass.simpleName");
        this.moduleInfo = new GaiaXModuleInfo(name, id, simpleName);
        this.module = iGaiaXModule;
        this.syncMethods = new LinkedHashMap();
        this.asyncMethods = new LinkedHashMap();
        this.promiseMethods = new LinkedHashMap();
    }

    private final StringBuilder buildScript() {
        String initSyncMethodsScript = initSyncMethodsScript();
        String initAsyncMethodsScript = initAsyncMethodsScript();
        String initPromiseMethodsScript = initPromiseMethodsScript();
        StringBuilder sb = new StringBuilder();
        sb.append(initSyncMethodsScript);
        sb.append(initAsyncMethodsScript);
        sb.append(initPromiseMethodsScript);
        return sb;
    }

    private final void initAsyncMethods() {
        Method[] declaredMethods = this.module.getClass().getDeclaredMethods();
        b41.h(declaredMethods, "targetMethods");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            if (((GaiaXAsyncMethod) method.getAnnotation(GaiaXAsyncMethod.class)) != null) {
                long genLongId = IdGenerator.INSTANCE.genLongId();
                b41.h(method, "targetMethod");
                this.asyncMethods.put(Long.valueOf(genLongId), new GaiaXMethodInfo.GaiaXAsyncMethodInfo(genLongId, method));
            }
        }
    }

    private final String initAsyncMethodsScript() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Long, GaiaXMethodInfo> entry : this.asyncMethods.entrySet()) {
            sb.append(GaiaXScriptBuilder.INSTANCE.buildAsyncMethodDeclareScript(this.moduleInfo.getName(), entry.getValue().getName(), this.moduleInfo.getId(), entry.getValue().getId()));
        }
        String sb2 = sb.toString();
        b41.h(sb2, "script.toString()");
        return sb2;
    }

    private final void initPromiseMethods() {
        Method[] declaredMethods = this.module.getClass().getDeclaredMethods();
        b41.h(declaredMethods, "targetMethods");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            if (((GaiaXPromiseMethod) method.getAnnotation(GaiaXPromiseMethod.class)) != null) {
                long genLongId = IdGenerator.INSTANCE.genLongId();
                b41.h(method, "targetMethod");
                this.promiseMethods.put(Long.valueOf(genLongId), new GaiaXMethodInfo.GaiaXPromiseMethodInfo(genLongId, method));
            }
        }
    }

    private final String initPromiseMethodsScript() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Long, GaiaXMethodInfo> entry : this.promiseMethods.entrySet()) {
            sb.append(GaiaXScriptBuilder.INSTANCE.buildPromiseMethodDeclareScript(this.moduleInfo.getName(), entry.getValue().getName(), this.moduleInfo.getId(), entry.getValue().getId()));
        }
        String sb2 = sb.toString();
        b41.h(sb2, "script.toString()");
        return sb2;
    }

    private final void initSyncMethods() {
        Method[] declaredMethods = this.module.getClass().getDeclaredMethods();
        b41.h(declaredMethods, "targetMethods");
        int length = declaredMethods.length;
        int i = 0;
        while (i < length) {
            Method method = declaredMethods[i];
            i++;
            if (((GaiaXSyncMethod) method.getAnnotation(GaiaXSyncMethod.class)) != null) {
                long genLongId = IdGenerator.INSTANCE.genLongId();
                b41.h(method, "targetMethod");
                this.syncMethods.put(Long.valueOf(genLongId), new GaiaXMethodInfo.GaiaXSyncMethodInfo(genLongId, method));
            }
        }
    }

    private final String initSyncMethodsScript() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Long, GaiaXMethodInfo> entry : this.syncMethods.entrySet()) {
            sb.append(GaiaXScriptBuilder.INSTANCE.buildSyncMethodDeclareScript(this.moduleInfo.getName(), entry.getValue().getName(), this.moduleInfo.getId(), entry.getValue().getId()));
        }
        String sb2 = sb.toString();
        b41.h(sb2, "script.toString()");
        return sb2;
    }

    @NotNull
    public final StringBuilder buildModuleScript() {
        initMethods$GaiaX_Android_JS();
        return buildScript();
    }

    public final long getId() {
        return this.module.getId();
    }

    @NotNull
    public final IGaiaXModule getModule$GaiaX_Android_JS() {
        return this.module;
    }

    @NotNull
    public final String getName() {
        return this.module.getName();
    }

    @NotNull
    public final Map<Long, GaiaXMethodInfo> getSyncMethods() {
        return this.syncMethods;
    }

    public final void initMethods$GaiaX_Android_JS() {
        if (this.isInit) {
            return;
        }
        this.isInit = true;
        initSyncMethods();
        initAsyncMethods();
        initPromiseMethods();
    }

    public final void invokeMethodAsync(long j, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        try {
            GaiaXMethodInfo gaiaXMethodInfo = this.asyncMethods.get(Long.valueOf(j));
            if (gaiaXMethodInfo == null) {
                return;
            }
            gaiaXMethodInfo.invoke(this.module, jSONArray);
        } catch (Exception e) {
            Log log = Log.INSTANCE;
            if (log.isLog()) {
                log.d(b41.r("invokeMethodAsync() called with: exception message = ", e.getMessage()));
            }
            e.printStackTrace();
        }
    }

    @Nullable
    public final Object invokeMethodSync(long j, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        try {
            GaiaXMethodInfo gaiaXMethodInfo = this.syncMethods.get(Long.valueOf(j));
            if (gaiaXMethodInfo == null) {
                return null;
            }
            return gaiaXMethodInfo.invoke(this.module, jSONArray);
        } catch (Exception e) {
            Log log = Log.INSTANCE;
            if (log.isLog()) {
                log.d(b41.r("invokeMethodSync() called with: exception message = ", e.getMessage()));
            }
            e.printStackTrace();
            return null;
        }
    }

    public final void invokePromiseMethod(long j, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        try {
            GaiaXMethodInfo gaiaXMethodInfo = this.promiseMethods.get(Long.valueOf(j));
            if (gaiaXMethodInfo == null) {
                return;
            }
            gaiaXMethodInfo.invoke(this.module, jSONArray);
        } catch (Exception e) {
            Log log = Log.INSTANCE;
            if (log.isLog()) {
                log.d(b41.r("invokePromiseMethod() called with: exception message = ", e.getMessage()));
            }
            e.printStackTrace();
        }
    }
}
