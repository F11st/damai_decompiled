package com.alient.gaiax.container.util;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.v;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/alient/gaiax/container/util/DisplayUtil;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "getDisplayWidthInPx", "<init>", "()V", "gaiax-container_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class DisplayUtil {
    @NotNull
    public static final DisplayUtil INSTANCE = new DisplayUtil();

    private DisplayUtil() {
    }

    public final int getDisplayWidthInPx(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            Object systemService = context.getSystemService(v.ATTACH_MODE_WINDOW);
            if (systemService != null) {
                Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                if (Build.VERSION.SDK_INT < 17) {
                    Point point = new Point();
                    com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
                    return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
                }
                Point point2 = new Point();
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point2);
                return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
