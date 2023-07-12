package com.youku.gaiax.impl.register;

import androidx.recyclerview.widget.DiffUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.render.view.container.GXContainerViewAdapter;
import com.youku.gaiax.module.render.view.GaiaXDefaultDiffCallBack;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.os0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionContainerDataUpdate;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionContainerDataUpdate;", "Ltb/os0;", "gxTemplateContext", "Lcom/alibaba/gaiax/render/view/container/GXContainerViewAdapter;", "gxContainerViewAdapter", "Lcom/alibaba/fastjson/JSONArray;", "old", "new", "Ltb/wt2;", "update", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionContainerDataUpdate implements GXRegisterCenter.GXIExtensionContainerDataUpdate {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionContainerDataUpdate
    public void update(@NotNull os0 os0Var, @NotNull GXContainerViewAdapter gXContainerViewAdapter, @NotNull JSONArray jSONArray, @NotNull JSONArray jSONArray2) {
        b41.i(os0Var, "gxTemplateContext");
        b41.i(gXContainerViewAdapter, "gxContainerViewAdapter");
        b41.i(jSONArray, "old");
        b41.i(jSONArray2, "new");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new GaiaXDefaultDiffCallBack(jSONArray, jSONArray2), true);
        b41.h(calculateDiff, "calculateDiff(diffCallBack, true)");
        calculateDiff.dispatchUpdatesTo(gXContainerViewAdapter);
    }
}
