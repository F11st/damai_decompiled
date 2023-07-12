package com.taobao.weex.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.taobao.weex.ui.flat.widget.Widget;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class BaseFrameLayout extends FrameLayout {
    private List<Widget> mWidgets;

    public BaseFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            dispatchDrawInterval(canvas);
        } catch (Throwable th) {
            WXLogUtils.e(WXLogUtils.getStackTrace(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispatchDrawInterval(Canvas canvas) {
        if (this.mWidgets != null) {
            canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            for (Widget widget : this.mWidgets) {
                widget.draw(canvas);
            }
            canvas.restore();
            return;
        }
        WXViewUtils.clipCanvasWithinBorderBox(this, canvas);
        super.dispatchDraw(canvas);
    }

    public void mountFlatGUI(List<Widget> list) {
        this.mWidgets = list;
        if (list != null) {
            setWillNotDraw(true);
        }
        invalidate();
    }

    public void unmountFlatGUI() {
        this.mWidgets = null;
        setWillNotDraw(false);
        invalidate();
    }

    @Override // android.view.View
    protected boolean verifyDrawable(@NonNull Drawable drawable) {
        return this.mWidgets != null || super.verifyDrawable(drawable);
    }
}
