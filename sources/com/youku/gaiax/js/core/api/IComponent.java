package com.youku.gaiax.js.core.api;

import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0002H&J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&¨\u0006\u0011"}, d2 = {"Lcom/youku/gaiax/js/core/api/IComponent;", "", "Ltb/wt2;", "initComponent", "onReady", "onReuse", "onShow", "onHide", "onDestroy", "destroyComponent", "", "type", "Lcom/alibaba/fastjson/JSONObject;", "data", "onEvent", "onNativeEvent", "onLoadMore", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IComponent {
    void destroyComponent();

    void initComponent();

    void onDestroy();

    void onEvent(@NotNull String str, @NotNull JSONObject jSONObject);

    void onHide();

    void onLoadMore(@NotNull JSONObject jSONObject);

    void onNativeEvent(@NotNull JSONObject jSONObject);

    void onReady();

    void onReuse();

    void onShow();
}
