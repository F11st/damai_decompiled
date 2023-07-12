package com.taobao.weex.ui.view.border;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.taobao.weex.dom.CSSShorthand;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class BorderEdge {
    private float mBorderWidth;
    private CSSShorthand.EDGE mEdge;
    @NonNull
    private BorderCorner mPostCorner;
    @NonNull
    private BorderCorner mPreCorner;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawEdge(@NonNull Canvas canvas, @NonNull Paint paint) {
        paint.setStrokeWidth(this.mBorderWidth);
        BorderCorner borderCorner = this.mPreCorner;
        borderCorner.drawRoundedCorner(canvas, paint, borderCorner.getAngleBisectorDegree());
        paint.setStrokeWidth(this.mBorderWidth);
        canvas.drawLine(this.mPreCorner.getRoundCornerEndX(), this.mPreCorner.getRoundCornerEndY(), this.mPostCorner.getRoundCornerStartX(), this.mPostCorner.getRoundCornerStartY(), paint);
        BorderCorner borderCorner2 = this.mPostCorner;
        borderCorner2.drawRoundedCorner(canvas, paint, borderCorner2.getAngleBisectorDegree() - 45.0f);
    }

    public float getBorderWidth() {
        return this.mBorderWidth;
    }

    public CSSShorthand.EDGE getEdge() {
        return this.mEdge;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BorderEdge set(@NonNull BorderCorner borderCorner, @NonNull BorderCorner borderCorner2, float f, CSSShorthand.EDGE edge) {
        this.mPreCorner = borderCorner;
        this.mPostCorner = borderCorner2;
        this.mBorderWidth = f;
        this.mEdge = edge;
        return this;
    }
}
