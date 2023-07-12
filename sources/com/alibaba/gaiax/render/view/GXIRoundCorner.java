package com.alibaba.gaiax.render.view;

import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.weex.common.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u000b"}, d2 = {"Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", "", "", BQCCameraParam.FOCUS_AREA_RADIUS, "Ltb/wt2;", "setRoundCornerRadius", "", "borderColor", "", Constants.Name.BORDER_WIDTH, "setRoundCornerBorder", "GaiaX"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes6.dex */
public interface GXIRoundCorner {
    void setRoundCornerBorder(int i, float f, @NotNull float[] fArr);

    void setRoundCornerRadius(@NotNull float[] fArr);
}
