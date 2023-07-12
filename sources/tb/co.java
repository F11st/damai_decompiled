package tb;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class co {
    public static Activity a(Context context) {
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static ComponentName b(Context context) {
        if (context instanceof zy2) {
            return ((zy2) context).b();
        }
        Activity a = a(context);
        if (a != null) {
            return a.getComponentName();
        }
        return null;
    }
}
