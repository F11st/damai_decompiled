package tb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youku.arch.v3.data.Constants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class fw2 {
    public static int a(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Map<String, String> b(String str) {
        try {
            JSONObject parseObject = JSON.parseObject(str);
            HashMap hashMap = new HashMap();
            for (String str2 : parseObject.keySet()) {
                hashMap.put(str2, parseObject.getString(str2));
            }
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T c(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static int d(Resources resources) {
        int identifier = resources.getIdentifier("status_bar_height", Constants.DIMEN, "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static ViewGroup e(Activity activity) {
        View findViewById = activity.findViewById(16908290);
        while (true) {
            ViewGroup viewGroup = (ViewGroup) findViewById;
            ViewParent parent = viewGroup.getParent();
            if (!(parent instanceof View)) {
                return viewGroup;
            }
            findViewById = parent;
        }
    }

    public static boolean f(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            if (iArr[0] == 0 && iArr[1] == 0 && !view.isAttachedToWindow()) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(View view) {
        do {
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return false;
            }
            view = (View) parent;
        } while (16908290 != view.getId());
        return true;
    }
}
