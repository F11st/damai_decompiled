package com.youku.arch.v3.style;

import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\t"}, d2 = {"Lcom/youku/arch/v3/style/StyleFactory;", "", "Lcom/alibaba/fastjson/JSONObject;", "styleJSONObject", "Lcom/youku/arch/v3/style/Style;", "parent", "create", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class StyleFactory {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final StyleFactory INSTANCE = new StyleFactory();

    private StyleFactory() {
    }

    @NotNull
    public final Style create(@NotNull JSONObject jSONObject, @Nullable Style style) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1158950253")) {
            return (Style) ipChange.ipc$dispatch("-1158950253", new Object[]{this, jSONObject, style});
        }
        b41.i(jSONObject, "styleJSONObject");
        return new Style(jSONObject.getInnerMap(), style);
    }

    @NotNull
    public final Style create(@NotNull JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-229065218")) {
            return (Style) ipChange.ipc$dispatch("-229065218", new Object[]{this, jSONObject});
        }
        b41.i(jSONObject, "styleJSONObject");
        return new Style(jSONObject.getInnerMap(), null);
    }
}
