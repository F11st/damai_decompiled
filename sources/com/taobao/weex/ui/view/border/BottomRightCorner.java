package com.taobao.weex.ui.view.border;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class BottomRightCorner extends BorderCorner {
    @Override // com.taobao.weex.ui.view.border.BorderCorner
    protected void prepareOval() {
        if (hasInnerCorner()) {
            setOvalLeft(getBorderBox().width() - ((getOuterCornerRadius() * 2.0f) - (getPreBorderWidth() / 2.0f)));
            setOvalTop(getBorderBox().height() - ((getOuterCornerRadius() * 2.0f) - (getPostBorderWidth() / 2.0f)));
            setOvalRight(getBorderBox().width() - (getPreBorderWidth() / 2.0f));
            setOvalBottom(getBorderBox().height() - (getPostBorderWidth() / 2.0f));
            return;
        }
        setOvalLeft(getBorderBox().width() - (getOuterCornerRadius() * 1.5f));
        setOvalTop(getBorderBox().height() - (getOuterCornerRadius() * 1.5f));
        setOvalRight(getBorderBox().width() - (getOuterCornerRadius() / 2.0f));
        setOvalBottom(getBorderBox().height() - (getOuterCornerRadius() / 2.0f));
    }

    @Override // com.taobao.weex.ui.view.border.BorderCorner
    protected void prepareRoundCorner() {
        if (hasOuterCorner()) {
            setRoundCornerStartX(getBorderBox().width() - (getPreBorderWidth() / 2.0f));
            setRoundCornerStartY(getBorderBox().height() - getOuterCornerRadius());
            setRoundCornerEndX(getBorderBox().width() - getOuterCornerRadius());
            setRoundCornerEndY(getBorderBox().height() - (getPostBorderWidth() / 2.0f));
            return;
        }
        float width = getBorderBox().width() - (getPreBorderWidth() / 2.0f);
        float height = getBorderBox().height() - (getPostBorderWidth() / 2.0f);
        setRoundCornerStartX(width);
        setRoundCornerStartY(height);
        setRoundCornerEndX(width);
        setRoundCornerEndY(height);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(float f, float f2, float f3, @NonNull RectF rectF) {
        set(f, f2, f3, rectF, 45.0f);
    }
}
