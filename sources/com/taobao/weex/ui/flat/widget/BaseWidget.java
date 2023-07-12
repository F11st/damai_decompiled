package com.taobao.weex.ui.flat.widget;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.taobao.weex.ui.flat.FlatGUIContext;
import com.taobao.weex.ui.view.border.BorderDrawable;
import com.taobao.weex.utils.WXViewUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes11.dex */
public abstract class BaseWidget implements Widget {
    private BorderDrawable backgroundBorder;
    private int bottomOffset;
    @NonNull
    private final FlatGUIContext context;
    private int leftOffset;
    private int rightOffset;
    private int topOffset;
    private Rect borderBox = new Rect();
    private Point offsetOfContainer = new Point();

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseWidget(@NonNull FlatGUIContext flatGUIContext) {
        this.context = flatGUIContext;
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public final void draw(@NonNull Canvas canvas) {
        canvas.save();
        WXViewUtils.clipCanvasWithinBorderBox(this, canvas);
        Rect rect = this.borderBox;
        canvas.translate(rect.left, rect.top);
        BorderDrawable borderDrawable = this.backgroundBorder;
        if (borderDrawable != null) {
            borderDrawable.draw(canvas);
        }
        canvas.clipRect(this.leftOffset, this.topOffset, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(this.borderBox) - this.rightOffset, com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(this.borderBox) - this.bottomOffset);
        canvas.translate(this.leftOffset, this.topOffset);
        onDraw(canvas);
        canvas.restore();
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    @Nullable
    public final BorderDrawable getBackgroundAndBorder() {
        return this.backgroundBorder;
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    @NonNull
    public final Rect getBorderBox() {
        return this.borderBox;
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    @NonNull
    public final Point getLocInFlatContainer() {
        return this.offsetOfContainer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invalidate() {
        View widgetContainerView;
        Rect rect = new Rect(this.borderBox);
        Point point = this.offsetOfContainer;
        rect.offset(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        FlatGUIContext flatGUIContext = this.context;
        if (flatGUIContext == null || (widgetContainerView = flatGUIContext.getWidgetContainerView(this)) == null) {
            return;
        }
        widgetContainerView.invalidate(rect);
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void setBackgroundAndBorder(@NonNull BorderDrawable borderDrawable) {
        this.backgroundBorder = borderDrawable;
        Rect rect = new Rect(this.borderBox);
        Rect rect2 = this.borderBox;
        rect.offset(-rect2.left, -rect2.top);
        borderDrawable.setBounds(rect);
        setCallback(borderDrawable);
        invalidate();
    }

    protected void setCallback(@NonNull Drawable drawable) {
        View widgetContainerView;
        FlatGUIContext flatGUIContext = this.context;
        if (flatGUIContext == null || (widgetContainerView = flatGUIContext.getWidgetContainerView(this)) == null) {
            return;
        }
        drawable.setCallback(widgetContainerView);
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void setContentBox(int i, int i2, int i3, int i4) {
        this.leftOffset = i;
        this.topOffset = i2;
        this.rightOffset = i3;
        this.bottomOffset = i4;
        invalidate();
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void setLayout(int i, int i2, int i3, int i4, int i5, int i6, Point point) {
        this.offsetOfContainer = point;
        this.borderBox.set(i3, i5, i + i3, i2 + i5);
        BorderDrawable borderDrawable = this.backgroundBorder;
        if (borderDrawable != null) {
            setBackgroundAndBorder(borderDrawable);
        }
        invalidate();
    }
}
