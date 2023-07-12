package com.taobao.weex.ui.flat.widget;

import android.graphics.Canvas;
import android.graphics.Point;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.taobao.weex.ui.flat.FlatGUIContext;
import com.taobao.weex.ui.view.border.BorderDrawable;
import java.util.LinkedList;
import java.util.List;

/* compiled from: Taobao */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes11.dex */
public class WidgetGroup extends BaseWidget {
    private List<Widget> mChildren;

    public WidgetGroup(@NonNull FlatGUIContext flatGUIContext) {
        super(flatGUIContext);
        this.mChildren = new LinkedList();
    }

    public List<Widget> getChildren() {
        return this.mChildren;
    }

    @Override // com.taobao.weex.ui.flat.widget.Widget
    public void onDraw(@NonNull Canvas canvas) {
        for (Widget widget : this.mChildren) {
            widget.draw(canvas);
        }
    }

    public void replaceAll(@NonNull List<Widget> list) {
        this.mChildren = list;
        invalidate();
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setBackgroundAndBorder(@NonNull BorderDrawable borderDrawable) {
        super.setBackgroundAndBorder(borderDrawable);
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setContentBox(int i, int i2, int i3, int i4) {
        super.setContentBox(i, i2, i3, i4);
    }

    @Override // com.taobao.weex.ui.flat.widget.BaseWidget, com.taobao.weex.ui.flat.widget.Widget
    public /* bridge */ /* synthetic */ void setLayout(int i, int i2, int i3, int i4, int i5, int i6, Point point) {
        super.setLayout(i, i2, i3, i4, i5, i6, point);
    }
}
