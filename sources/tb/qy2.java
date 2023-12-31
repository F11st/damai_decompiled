package tb;

import android.graphics.Rect;
import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qy2 {
    public static boolean a(View view, float f) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
        int height = globalVisibleRect ? com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect) : 0;
        int width = globalVisibleRect ? com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) : 0;
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        if ((measuredHeight == 0 ? measuredHeight : height / measuredHeight) >= f) {
            return (measuredWidth == 0 ? (float) measuredWidth : ((float) width) / ((float) measuredWidth)) >= f;
        }
        return false;
    }
}
