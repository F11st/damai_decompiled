package com.taobao.weex.ui.view.border;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class BottomLeftCorner extends BorderCorner {
    @Override // com.taobao.weex.ui.view.border.BorderCorner
    protected void prepareOval() {
        if (hasInnerCorner()) {
            setOvalLeft(getPostBorderWidth() / 2.0f);
            setOvalTop(getBorderBox().height() - ((getOuterCornerRadius() * 2.0f) - (getPreBorderWidth() / 2.0f)));
            setOvalRight((getOuterCornerRadius() * 2.0f) - (getPostBorderWidth() / 2.0f));
            setOvalBottom(getBorderBox().height() - (getPreBorderWidth() / 2.0f));
            return;
        }
        setOvalLeft(getOuterCornerRadius() / 2.0f);
        setOvalTop(getBorderBox().height() - (getOuterCornerRadius() * 1.5f));
        setOvalRight(getOuterCornerRadius() * 1.5f);
        setOvalBottom(getBorderBox().height() - (getOuterCornerRadius() / 2.0f));
    }

    @Override // com.taobao.weex.ui.view.border.BorderCorner
    protected void prepareRoundCorner() {
        if (hasOuterCorner()) {
            setRoundCornerStartX(getOuterCornerRadius());
            setRoundCornerStartY(getBorderBox().height() - (getPreBorderWidth() / 2.0f));
            setRoundCornerEndX(getPostBorderWidth() / 2.0f);
            setRoundCornerEndY(getBorderBox().height() - getOuterCornerRadius());
            return;
        }
        float postBorderWidth = getPostBorderWidth() / 2.0f;
        float height = getBorderBox().height() - (getPreBorderWidth() / 2.0f);
        setRoundCornerStartX(postBorderWidth);
        setRoundCornerStartY(height);
        setRoundCornerEndX(postBorderWidth);
        setRoundCornerEndY(height);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(float f, float f2, float f3, @NonNull RectF rectF) {
        set(f, f2, f3, rectF, 135.0f);
    }
}
