package com.youku.gaiax.js.support;

import com.alibaba.fastjson.JSONArray;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\b\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0011\b\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0002J \u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u001e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fR\u0019\u0010\u0014\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R%\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXModuleGroup;", "", "", "initModuleGlobalScript", "initModuleScript", "Lcom/youku/gaiax/js/support/GaiaXModule;", "module", "Ltb/wt2;", "addModule", "", "id", "removeModule", "buildModuleScript", "moduleId", "methodId", "Lcom/alibaba/fastjson/JSONArray;", "args", "invokeMethodSync", "invokeMethodAsync", "invokePromiseMethod", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "modules", "Ljava/util/Map;", "getModules", "()Ljava/util/Map;", "<init>", "(Ljava/lang/String;)V", "Companion", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXModuleGroup {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Map<Long, GaiaXModule> modules;
    @NotNull
    private final String name;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXModuleGroup$Companion;", "", "", "moduleName", "Lcom/youku/gaiax/js/support/GaiaXModuleGroup;", "create", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }

        @NotNull
        public final GaiaXModuleGroup create(@NotNull String str) {
            b41.i(str, "moduleName");
            return new GaiaXModuleGroup(str, null);
        }
    }

    private GaiaXModuleGroup(String str) {
        this.name = str;
        this.modules = new LinkedHashMap();
    }

    public /* synthetic */ GaiaXModuleGroup(String str, k50 k50Var) {
        this(str);
    }

    private final String initModuleGlobalScript() {
        return GaiaXScriptBuilder.INSTANCE.buildModuleGlobalDeclareScript(this.name);
    }

    private final String initModuleScript() {
        String buildModuleDeclareScript = GaiaXScriptBuilder.INSTANCE.buildModuleDeclareScript(this.name);
        if (buildModuleDeclareScript != null) {
            return buildModuleDeclareScript;
        }
        throw new IllegalArgumentException("Module name is empty");
    }

    public final void addModule(@NotNull GaiaXModule gaiaXModule) {
        b41.i(gaiaXModule, "module");
        this.modules.put(Long.valueOf(gaiaXModule.getId()), gaiaXModule);
    }

    @NotNull
    public final String buildModuleScript() {
        StringBuilder sb = new StringBuilder();
        String initModuleScript = initModuleScript();
        String initModuleGlobalScript = initModuleGlobalScript();
        sb.append(initModuleScript);
        sb.append(initModuleGlobalScript);
        for (Map.Entry<Long, GaiaXModule> entry : this.modules.entrySet()) {
            sb.append((CharSequence) entry.getValue().buildModuleScript());
        }
        String sb2 = sb.toString();
        b41.h(sb2, "script.toString()");
        return sb2;
    }

    @NotNull
    public final Map<Long, GaiaXModule> getModules() {
        return this.modules;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final void invokeMethodAsync(long j, long j2, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        GaiaXModule gaiaXModule = this.modules.get(Long.valueOf(j));
        if (gaiaXModule == null) {
            return;
        }
        gaiaXModule.invokeMethodAsync(j2, jSONArray);
    }

    @Nullable
    public final Object invokeMethodSync(long j, long j2, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        GaiaXModule gaiaXModule = this.modules.get(Long.valueOf(j));
        if (gaiaXModule == null) {
            return null;
        }
        return gaiaXModule.invokeMethodSync(j2, jSONArray);
    }

    public final void invokePromiseMethod(long j, long j2, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        GaiaXModule gaiaXModule = this.modules.get(Long.valueOf(j));
        if (gaiaXModule == null) {
            return;
        }
        gaiaXModule.invokePromiseMethod(j2, jSONArray);
    }

    public final void removeModule(long j) {
        this.modules.remove(Long.valueOf(j));
    }
}
