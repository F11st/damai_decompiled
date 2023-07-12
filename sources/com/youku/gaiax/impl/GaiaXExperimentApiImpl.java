package com.youku.gaiax.impl;

import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.data.Constants;
import com.youku.gaiax.IExperiment;
import com.youku.gaiax.impl.register.GXExtensionTemplateAssetsSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateInfoSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateRealTimeSource;
import com.youku.gaiax.impl.register.GXExtensionTemplateRemoteSource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u001a\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH\u0016J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/youku/gaiax/impl/GaiaXExperimentApiImpl;", "Lcom/youku/gaiax/IExperiment;", "", "templateBiz", "templateId", "Lcom/alibaba/fastjson/JSONObject;", Constants.TEMPLATE, "Ltb/wt2;", "addTemplateToRealTime", "clearRealTime", "", "", "getAllRemoteTemplatesInMemory", "getRemoteTemplateFromDB", "getAllMemoryTemplates", "getMemoryTemplate", "getAllAssetsTemplates", "getAssetsTemplate", "data", "onSendStudioMsg", "Lcom/youku/gaiax/IExperiment$IStudioSocket;", "studioSocket", "setGaiaXStudioSocket", "Lcom/youku/gaiax/IExperiment$IStudioSocket;", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GaiaXExperimentApiImpl implements IExperiment {
    @Nullable
    private IExperiment.IStudioSocket studioSocket;

    @Override // com.youku.gaiax.IExperiment
    public void addTemplateToRealTime(@NotNull String str, @NotNull String str2, @NotNull JSONObject jSONObject) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        b41.i(jSONObject, Constants.TEMPLATE);
        GXExtensionTemplateRealTimeSource.Companion.getInstance().add(str, str2, jSONObject);
    }

    @Override // com.youku.gaiax.IExperiment
    public void clearRealTime() {
        GXExtensionTemplateRealTimeSource.Companion.getInstance().clear();
    }

    @Override // com.youku.gaiax.IExperiment
    @NotNull
    public Map<String, List<JSONObject>> getAllAssetsTemplates() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(GXExtensionTemplateAssetsSource.Companion.assetsInstance().getAllTemplate());
        return linkedHashMap;
    }

    @Override // com.youku.gaiax.IExperiment
    @NotNull
    public Map<String, List<JSONObject>> getAllMemoryTemplates() {
        return GXExtensionTemplateInfoSource.Companion.getInstance().getAllTemplate();
    }

    @Override // com.youku.gaiax.IExperiment
    @NotNull
    public Map<String, List<JSONObject>> getAllRemoteTemplatesInMemory() {
        return GXExtensionTemplateRemoteSource.Companion.remoteInstance().getAllRemoteTemplatesInMemory();
    }

    @Override // com.youku.gaiax.IExperiment
    @NotNull
    public JSONObject getAssetsTemplate(@NotNull String str, @NotNull String str2) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        JSONObject template = GXExtensionTemplateAssetsSource.Companion.assetsInstance().getTemplate(str, str2);
        return template.isEmpty() ^ true ? template : new JSONObject();
    }

    @Override // com.youku.gaiax.IExperiment
    @NotNull
    public JSONObject getMemoryTemplate(@NotNull String str, @NotNull String str2) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        return GXExtensionTemplateInfoSource.Companion.getInstance().getTemplate(str, str2);
    }

    @Override // com.youku.gaiax.IExperiment
    @NotNull
    public JSONObject getRemoteTemplateFromDB(@NotNull String str, @NotNull String str2) {
        b41.i(str, "templateBiz");
        b41.i(str2, "templateId");
        return GXExtensionTemplateRemoteSource.Companion.remoteInstance().getRemoteTemplateFromDB(str, str2);
    }

    @Override // com.youku.gaiax.IExperiment
    public void onSendStudioMsg(@NotNull JSONObject jSONObject) {
        b41.i(jSONObject, "data");
        IExperiment.IStudioSocket iStudioSocket = this.studioSocket;
        if (iStudioSocket == null) {
            return;
        }
        iStudioSocket.sendMsg(jSONObject);
    }

    @Override // com.youku.gaiax.IExperiment
    public void setGaiaXStudioSocket(@NotNull IExperiment.IStudioSocket iStudioSocket) {
        b41.i(iStudioSocket, "studioSocket");
        this.studioSocket = iStudioSocket;
    }
}
