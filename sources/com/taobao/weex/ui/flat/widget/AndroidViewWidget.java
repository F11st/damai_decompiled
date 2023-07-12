package com.taobao.weex.ui.flat.widget;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.ui.flat.FlatGUIContext;
import com.taobao.weex.ui.view.border.BorderDrawable;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes11.dex */
public class AndroidViewWidget extends BaseWidget implements Destroyable {
    @Nullable
    private View mView;

    public AndroidViewWidget(@NonNull FlatGUIContext flatGUIContext) {
        super(flatGUIContext);
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        if (this.mView != null) {
            this.mView = null;
        }
    }

    @Nullable
    public View getView() {
        return this.mView;
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget
    public void invalidate() {
        super.invalidate();
        View view = this.mView;
        if (view != null) {
            view.invalidate();
        }
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void onDraw(@NonNull Canvas canvas) {
        View view = this.mView;
        if (view != null) {
            view.draw(canvas);
        }
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setBackgroundAndBorder(@NonNull BorderDrawable borderDrawable) {
        super.setBackgroundAndBorder(borderDrawable);
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public void setContentBox(int i, int i2, int i3, int i4) {
        View view = this.mView;
        if (view != null) {
            view.setPadding(i, i2, i3, i4);
            invalidate();
        }
    }

    public void setContentView(@Nullable View view) {
        this.mView = view;
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setLayout(int i, int i2, int i3, int i4, int i5, int i6, Point point) {
        super.setLayout(i, i2, i3, i4, i5, i6, point);
    }
}
