package com.tencent.open.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.WindowManager;
import com.taobao.weex.common.Constants;
import java.util.Locale;
import tb.C9796v;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.b.d */
/* loaded from: classes11.dex */
public class C7083d {
    private static String a;
    private static String b;

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            if (context == null) {
                return "";
            }
            a = "";
            WindowManager windowManager = (WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW);
            if (windowManager != null) {
                int width = windowManager.getDefaultDisplay().getWidth();
                int height = windowManager.getDefaultDisplay().getHeight();
                a = width + Constants.Name.X + height;
            }
            return a;
        }
        return a;
    }

    public static String a() {
        return Locale.getDefault().getLanguage();
    }
}
