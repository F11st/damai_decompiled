package com.youku.gaiax;

import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.data.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0001\u0017J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\u0007H&J\u001a\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH&J\u001a\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH&J\u001a\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH&J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0005H&¨\u0006\u0018"}, d2 = {"Lcom/youku/gaiax/IExperiment;", "", "", "templateBiz", "templateId", "Lcom/alibaba/fastjson/JSONObject;", Constants.TEMPLATE, "Ltb/wt2;", "addTemplateToRealTime", "clearRealTime", "", "", "getAllAssetsTemplates", "getAllRemoteTemplatesInMemory", "getAllMemoryTemplates", "getAssetsTemplate", "getMemoryTemplate", "getRemoteTemplateFromDB", "Lcom/youku/gaiax/IExperiment$IStudioSocket;", "studioSocket", "setGaiaXStudioSocket", "data", "onSendStudioMsg", "IStudioSocket", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IExperiment {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/youku/gaiax/IExperiment$IStudioSocket;", "", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/wt2;", "sendMsg", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface IStudioSocket {
        void sendMsg(@NotNull JSONObject jSONObject);
    }

    void addTemplateToRealTime(@NotNull String str, @NotNull String str2, @NotNull JSONObject jSONObject);

    void clearRealTime();

    @NotNull
    Map<String, List<JSONObject>> getAllAssetsTemplates();

    @NotNull
    Map<String, List<JSONObject>> getAllMemoryTemplates();

    @NotNull
    Map<String, List<JSONObject>> getAllRemoteTemplatesInMemory();

    @NotNull
    JSONObject getAssetsTemplate(@NotNull String str, @NotNull String str2);

    @NotNull
    JSONObject getMemoryTemplate(@NotNull String str, @NotNull String str2);

    @NotNull
    JSONObject getRemoteTemplateFromDB(@NotNull String str, @NotNull String str2);

    void onSendStudioMsg(@NotNull JSONObject jSONObject);

    void setGaiaXStudioSocket(@NotNull IStudioSocket iStudioSocket);
}
