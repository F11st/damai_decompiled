package com.scwang.smartrefresh.header.internal.pathview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect;
import tb.br1;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class PathsView extends View {
    protected br1 mPathsDrawable;

    public PathsView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.mPathsDrawable.draw(canvas);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getTag() instanceof String) {
            parserPaths(getTag().toString());
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mPathsDrawable.setBounds(getPaddingLeft(), getPaddingTop(), Math.max((i3 - i) - getPaddingRight(), getPaddingLeft()), Math.max((i4 - i2) - getPaddingTop(), getPaddingTop()));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        br1 br1Var = this.mPathsDrawable;
        super.setMeasuredDimension(View.resolveSize(Rect.width(br1Var.getBounds()) + getPaddingLeft() + getPaddingRight(), i), View.resolveSize(Rect.height(br1Var.getBounds()) + getPaddingTop() + getPaddingBottom(), i2));
    }

    public void parserColors(int... iArr) {
        this.mPathsDrawable.e(iArr);
    }

    public void parserPaths(String... strArr) {
        this.mPathsDrawable.f(strArr);
    }

    public PathsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPathsDrawable = new br1();
        this.mPathsDrawable = new br1();
    }
}
