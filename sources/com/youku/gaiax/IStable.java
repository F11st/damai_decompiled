package com.youku.gaiax;

import android.view.View;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.youku.gaiax.GaiaX;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\u001a\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tH&J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u000f\u001a\u00020\u0004H&J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0013H&J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0002H&J\"\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000bH&J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\u0018\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\"\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u000bH&J\u0018\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\u001a\u0010 \u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000bH&J\"\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H&J\u0018\u0010'\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\u0018\u0010(\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\u0018\u0010)\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\u0018\u0010*\u001a\u00020#2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H&J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+H&J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010,\u001a\u00020+H&J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u000bH&J\b\u00101\u001a\u00020\u0004H&¨\u00062"}, d2 = {"Lcom/youku/gaiax/IStable;", "", "", "templatesId", "Ltb/wt2;", "requestRemoteTemplatesWithAsync", "requestRemoteTemplatesWithSync", "templateBiz", "templateId", "", "", "Lcom/alibaba/fastjson/JSONObject;", "getAllRemoteTemplates", "getRemoteTemplate", "launchDB", "launchRemote", "Lcom/youku/gaiax/GaiaX$Params;", "params", "viewId", "Landroid/view/View;", "findViewById", "container", "findParamsByContainer", "key", "getDataBindingRawContentByKey", "rawJson", "getConfigs", "getRawConfigs", "getContainerItemTemplateRawConfigs", "getConfigsWithAssets", "getRawConfigsWithAssets", DXTraceUtil.TYPE_EXPRESSION_STRING, "getValueWithExpression", "parentParams", "containerId", "", "targetPosition", "getItemParamsByPosition", "", "templateExistWithAssets", "templateExistWithMemory", "templateExistWithRemote", "getRemoteTemplateVersion", "Lcom/youku/gaiax/IRemoteTemplateStateListener;", "listener", "addRemoteTemplateStateListener", "removeRemoteTemplateStateListener", "data", "dispatcherNativeMessageEventToJs", "cleanRemoteTemplates", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IStable {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ JSONObject getConfigs$default(IStable iStable, String str, String str2, JSONObject jSONObject, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    jSONObject = new JSONObject();
                }
                return iStable.getConfigs(str, str2, jSONObject);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConfigs");
        }

        public static /* synthetic */ JSONObject getConfigsWithAssets$default(IStable iStable, String str, String str2, JSONObject jSONObject, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    jSONObject = new JSONObject();
                }
                return iStable.getConfigsWithAssets(str, str2, jSONObject);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getConfigsWithAssets");
        }
    }

    void addRemoteTemplateStateListener(@NotNull IRemoteTemplateStateListener iRemoteTemplateStateListener);

    void cleanRemoteTemplates();

    void dispatcherNativeMessageEventToJs(@NotNull JSONObject jSONObject);

    @Nullable
    GaiaX.Params findParamsByContainer(@NotNull View view);

    @Nullable
    View findViewById(@NotNull GaiaX.Params params, @NotNull String str);

    @NotNull
    Map<String, List<JSONObject>> getAllRemoteTemplates();

    @NotNull
    JSONObject getConfigs(@NotNull String str, @NotNull String str2, @NotNull JSONObject jSONObject);

    @NotNull
    JSONObject getConfigsWithAssets(@NotNull String str, @NotNull String str2, @NotNull JSONObject jSONObject);

    @NotNull
    JSONObject getContainerItemTemplateRawConfigs(@NotNull String str, @NotNull String str2);

    @NotNull
    JSONObject getDataBindingRawContentByKey(@NotNull String str, @NotNull String str2, @NotNull String str3);

    @Nullable
    GaiaX.Params getItemParamsByPosition(@NotNull GaiaX.Params params, @NotNull String str, int i);

    @NotNull
    JSONObject getRawConfigs(@NotNull String str, @NotNull String str2);

    @NotNull
    JSONObject getRawConfigsWithAssets(@NotNull String str, @NotNull String str2);

    @NotNull
    JSONObject getRemoteTemplate(@NotNull String str, @NotNull String str2);

    int getRemoteTemplateVersion(@NotNull String str, @NotNull String str2);

    @Nullable
    Object getValueWithExpression(@NotNull String str, @NotNull JSONObject jSONObject);

    void launchDB();

    void launchRemote();

    void removeRemoteTemplateStateListener(@NotNull IRemoteTemplateStateListener iRemoteTemplateStateListener);

    void requestRemoteTemplatesWithAsync(@NotNull String str);

    void requestRemoteTemplatesWithSync(@NotNull String str);

    void requestRemoteTemplatesWithSync(@NotNull String str, @NotNull String str2);

    boolean templateExistWithAssets(@NotNull String str, @NotNull String str2);

    boolean templateExistWithMemory(@NotNull String str, @NotNull String str2);

    boolean templateExistWithRemote(@NotNull String str, @NotNull String str2);
}
