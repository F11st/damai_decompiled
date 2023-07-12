package com.alient.onearch.adapter.util;

import android.content.Context;
import android.util.TypedValue;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/alient/onearch/adapter/util/DisplayUtil;", "", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "", "dpValue", "dp2px", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class DisplayUtil {
    @NotNull
    public static final DisplayUtil INSTANCE = new DisplayUtil();

    private DisplayUtil() {
    }

    public final float dp2px(@NotNull Context context, float f) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        try {
            return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }
}
