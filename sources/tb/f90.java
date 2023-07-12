package tb;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.taobao.android.dinamic.log.DinamicLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f90 {
    public static void a(View view, Canvas canvas) {
        int i;
        float[] fArr;
        if (canvas == null || canvas.getWidth() <= 0 || (i = Build.VERSION.SDK_INT) < 16 || (fArr = (float[]) view.getTag(a90.LAYOUT_RADII)) == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        if (i >= 11 && canvas.isHardwareAccelerated() && i < 18) {
            view.setLayerType(1, null);
        }
        Path path = new Path();
        path.addRoundRect(new RectF(0.0f, 0.0f, width, height), fArr, Path.Direction.CW);
        canvas.clipPath(path);
    }

    public static Pair<String, String> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf(jn1.BRACKET_START_STR);
        int indexOf2 = str.indexOf(jn1.BRACKET_END_STR);
        if (indexOf >= 0 && indexOf2 >= 0) {
            String trim = str.trim();
            String substring = trim.substring(0, indexOf);
            String substring2 = trim.substring(indexOf + 1, indexOf2);
            if (TextUtils.isEmpty(substring)) {
                return null;
            }
            return new Pair<>(substring, substring2);
        }
        if (com.taobao.android.dinamic.b.e()) {
            DinamicLog.e(com.taobao.android.dinamic.b.TAG, String.format("事件属性:%s语法出错,没有包含\"（）\"", str));
        }
        return null;
    }

    public static x80 c(View view) {
        if (view == null) {
            return new x80();
        }
        Object tag = view.getTag(a90.PROPERTY_KEY);
        return tag == null ? new x80() : (x80) tag;
    }
}
