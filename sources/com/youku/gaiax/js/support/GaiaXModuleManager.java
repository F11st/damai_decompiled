package com.youku.gaiax.js.support;

import com.alibaba.fastjson.JSONArray;
import com.youku.gaiax.js.api.GaiaXBaseModule;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\"\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R%\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00110\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0016R$\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR*\u0010\u001d\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0016¨\u0006 "}, d2 = {"Lcom/youku/gaiax/js/support/GaiaXModuleManager;", "Lcom/youku/gaiax/js/support/IModuleManager;", "", "moduleId", "methodId", "Lcom/alibaba/fastjson/JSONArray;", "args", "", "invokeMethodSync", "Ltb/wt2;", "invokeMethodAsync", "invokePromiseMethod", "Ljava/lang/Class;", "Lcom/youku/gaiax/js/api/GaiaXBaseModule;", "moduleClazz", "registerModule", "unregisterModule", "", "buildModulesScript", "", "Lcom/youku/gaiax/js/support/GaiaXModuleGroup;", "moduleGroup", "Ljava/util/Map;", "getModuleGroup", "()Ljava/util/Map;", "moduleGroupKey", "", "clazzs", "Ljava/util/List;", "clazzIds", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXModuleManager implements IModuleManager {
    @NotNull
    private final Map<String, GaiaXModuleGroup> moduleGroup = new LinkedHashMap();
    @NotNull
    private final Map<Long, String> moduleGroupKey = new LinkedHashMap();
    @NotNull
    private List<Class<? extends GaiaXBaseModule>> clazzs = new ArrayList();
    @NotNull
    private final Map<Class<? extends GaiaXBaseModule>, Long> clazzIds = new LinkedHashMap();

    @Override // com.youku.gaiax.js.support.IModuleManager
    @NotNull
    public String buildModulesScript() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, GaiaXModuleGroup> entry : this.moduleGroup.entrySet()) {
            sb.append(entry.getValue().buildModuleScript());
        }
        String sb2 = sb.toString();
        b41.h(sb2, "script.toString()");
        return sb2;
    }

    @NotNull
    public final Map<String, GaiaXModuleGroup> getModuleGroup() {
        return this.moduleGroup;
    }

    @Override // com.youku.gaiax.js.support.IModuleManager
    public void invokeMethodAsync(long j, long j2, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        GaiaXModuleGroup gaiaXModuleGroup = this.moduleGroup.get(this.moduleGroupKey.get(Long.valueOf(j)));
        if (gaiaXModuleGroup == null) {
            return;
        }
        gaiaXModuleGroup.invokeMethodAsync(j, j2, jSONArray);
    }

    @Override // com.youku.gaiax.js.support.IModuleManager
    @Nullable
    public Object invokeMethodSync(long j, long j2, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        GaiaXModuleGroup gaiaXModuleGroup = this.moduleGroup.get(this.moduleGroupKey.get(Long.valueOf(j)));
        if (gaiaXModuleGroup == null) {
            return null;
        }
        return gaiaXModuleGroup.invokeMethodSync(j, j2, jSONArray);
    }

    @Override // com.youku.gaiax.js.support.IModuleManager
    public void invokePromiseMethod(long j, long j2, @NotNull JSONArray jSONArray) {
        b41.i(jSONArray, "args");
        GaiaXModuleGroup gaiaXModuleGroup = this.moduleGroup.get(this.moduleGroupKey.get(Long.valueOf(j)));
        if (gaiaXModuleGroup == null) {
            return;
        }
        gaiaXModuleGroup.invokePromiseMethod(j, j2, jSONArray);
    }

    @Override // com.youku.gaiax.js.support.IModuleManager
    public void registerModule(@NotNull Class<? extends GaiaXBaseModule> cls) {
        b41.i(cls, "moduleClazz");
        if (this.clazzs.contains(cls)) {
            return;
        }
        this.clazzs.add(cls);
        GaiaXBaseModule newInstance = cls.newInstance();
        b41.h(newInstance, "moduleClazz.newInstance()");
        GaiaXModule gaiaXModule = new GaiaXModule(newInstance);
        if (getModuleGroup().get(gaiaXModule.getName()) == null) {
            getModuleGroup().put(gaiaXModule.getName(), GaiaXModuleGroup.Companion.create(gaiaXModule.getName()));
        }
        this.clazzIds.put(cls, Long.valueOf(gaiaXModule.getId()));
        this.moduleGroupKey.put(Long.valueOf(gaiaXModule.getId()), gaiaXModule.getName());
        GaiaXModuleGroup gaiaXModuleGroup = this.moduleGroup.get(gaiaXModule.getName());
        if (gaiaXModuleGroup == null) {
            return;
        }
        gaiaXModuleGroup.addModule(gaiaXModule);
    }

    @Override // com.youku.gaiax.js.support.IModuleManager
    public void unregisterModule(@NotNull Class<? extends GaiaXBaseModule> cls) {
        GaiaXModuleGroup gaiaXModuleGroup;
        b41.i(cls, "moduleClazz");
        if (this.clazzs.contains(cls)) {
            this.clazzs.remove(cls);
            Long remove = this.clazzIds.remove(cls);
            if (remove == null) {
                return;
            }
            long longValue = remove.longValue();
            String remove2 = this.moduleGroupKey.remove(Long.valueOf(longValue));
            if (remove2 == null || (gaiaXModuleGroup = getModuleGroup().get(remove2)) == null) {
                return;
            }
            gaiaXModuleGroup.removeModule(longValue);
        }
    }
}
