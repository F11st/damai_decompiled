package com.youku.gaiax.impl.register;

import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.GXTemplateEngine;
import com.alibaba.gaiax.render.view.container.GXContainer;
import com.youku.gaiax.api.data.RasterizeRule;
import com.youku.gaiax.api.proxy.IProxyFeatures;
import com.youku.gaiax.common.utils.ScreenUtils;
import com.youku.gaiax.impl.GaiaXKey;
import com.youku.gaiax.impl.GaiaXProxy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.fs0;
import tb.os0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0012"}, d2 = {"Lcom/youku/gaiax/impl/register/GXExtensionScroll;", "Lcom/alibaba/gaiax/GXRegisterCenter$GXIExtensionScroll;", "Ltb/os0;", "gxTemplateContext", "Lcom/alibaba/gaiax/render/view/container/GXContainer;", "container", "Lcom/alibaba/fastjson/JSONObject;", "extend", "Ltb/wt2;", "scrollIndex", "", "propertyName", "Ltb/fs0;", "scrollConfig", "", "convert", "<init>", "()V", "GaiaX-Android"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class GXExtensionScroll implements GXRegisterCenter.GXIExtensionScroll {
    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionScroll
    @Nullable
    public Object convert(@NotNull String str, @NotNull os0 os0Var, @NotNull fs0 fs0Var) {
        String string;
        RasterizeRule.Result rasterizeRule;
        b41.i(str, "propertyName");
        b41.i(os0Var, "gxTemplateContext");
        b41.i(fs0Var, "scrollConfig");
        if (!b41.d(str, "view-port-width") || (string = fs0Var.a().getString(GaiaXKey.GAIAX_SCROLL_RESPONSIVE_RULE)) == null) {
            return null;
        }
        RasterizeRule.Config config = new RasterizeRule.Config();
        config.setScreenWidth(ScreenUtils.INSTANCE.getScreenWidthPx(os0Var.e()));
        config.setMeasureSizeWidth(os0Var.n().b());
        config.setMeasureSizeHeight(os0Var.n().a());
        config.setContext(os0Var.e());
        config.setEdgeLeft(fs0Var.d().left);
        config.setEdgeRight(fs0Var.d().right);
        config.setEdgeTop(fs0Var.d().top);
        config.setEdgeBottom(fs0Var.d().bottom);
        config.setLineSpacing(fs0Var.h());
        config.setRuleName(string);
        IProxyFeatures features = GaiaXProxy.Companion.getInstance().getFeatures();
        if (features == null || (rasterizeRule = features.getRasterizeRule(config)) == null) {
            return null;
        }
        return rasterizeRule.getWidth();
    }

    @Override // com.alibaba.gaiax.GXRegisterCenter.GXIExtensionScroll
    public void scrollIndex(@NotNull os0 os0Var, @NotNull GXContainer gXContainer, @Nullable JSONObject jSONObject) {
        RecyclerView.LayoutManager layoutManager;
        b41.i(os0Var, "gxTemplateContext");
        b41.i(gXContainer, "container");
        GXTemplateEngine.h p = os0Var.p();
        if (p == null) {
            return;
        }
        int d = p.d();
        if (d <= 0) {
            if ((jSONObject == null ? false : jSONObject.getBooleanValue("holding-offset")) || (layoutManager = gXContainer.getLayoutManager()) == null) {
                return;
            }
            layoutManager.scrollToPosition(0);
            return;
        }
        RecyclerView.LayoutManager layoutManager2 = gXContainer.getLayoutManager();
        if (layoutManager2 == null) {
            return;
        }
        layoutManager2.scrollToPosition(d);
    }
}
