package com.alibaba.gaiax.render.view.basic;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.os0;
import tb.pq0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0016¨\u0006\u0014"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXIImageView;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "Lcom/alibaba/fastjson/JSONObject;", "data", "Ltb/wt2;", "onBindData", "Ltb/os0;", "gxTemplateContext", "Ltb/pq0;", "gxCss", "setImageStyle", "", BQCCameraParam.FOCUS_AREA_RADIUS, "setRoundCornerRadius", "", "borderColor", "", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public interface GXIImageView extends GXIRoundCorner, GXIViewBindData {

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static final class a {
        public static void a(@NotNull GXIImageView gXIImageView) {
            b41.i(gXIImageView, "this");
            GXIViewBindData.a.a(gXIImageView);
        }
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    void onBindData(@Nullable JSONObject jSONObject);

    void setImageStyle(@NotNull os0 os0Var, @NotNull pq0 pq0Var);

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    void setRoundCornerBorder(int i, float f, @NotNull float[] fArr);

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    void setRoundCornerRadius(@NotNull float[] fArr);
}
