package com.taobao.weex.ui.view.border;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class TopLeftCorner extends BorderCorner {
    @Override // com.taobao.weex.ui.view.border.BorderCorner
    protected void prepareOval() {
        if (hasInnerCorner()) {
            setOvalLeft(getPreBorderWidth() / 2.0f);
            setOvalTop(getPostBorderWidth() / 2.0f);
            setOvalRight((getOuterCornerRadius() * 2.0f) - (getPreBorderWidth() / 2.0f));
            setOvalBottom((getOuterCornerRadius() * 2.0f) - (getPostBorderWidth() / 2.0f));
            return;
        }
        setOvalLeft(getOuterCornerRadius() / 2.0f);
        setOvalTop(getOuterCornerRadius() / 2.0f);
        setOvalRight(getOuterCornerRadius() * 1.5f);
        setOvalBottom(getOuterCornerRadius() * 1.5f);
    }

    @Override // com.taobao.weex.ui.view.border.BorderCorner
    protected void prepareRoundCorner() {
        if (hasOuterCorner()) {
            setRoundCornerStartX(getPreBorderWidth() / 2.0f);
            setRoundCornerStartY(getOuterCornerRadius());
            setRoundCornerEndX(getOuterCornerRadius());
            setRoundCornerEndY(getPostBorderWidth() / 2.0f);
            return;
        }
        float preBorderWidth = getPreBorderWidth() / 2.0f;
        float postBorderWidth = getPostBorderWidth() / 2.0f;
        setRoundCornerStartX(preBorderWidth);
        setRoundCornerStartY(postBorderWidth);
        setRoundCornerEndX(preBorderWidth);
        setRoundCornerEndY(postBorderWidth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(float f, float f2, float f3, @NonNull RectF rectF) {
        set(f, f2, f3, rectF, 225.0f);
    }
}
