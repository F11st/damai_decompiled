package tb;

import android.content.Context;
import android.os.Looper;
import android.util.TypedValue;
import java.io.File;
import java.io.FileFilter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class h42 {

    /* compiled from: Taobao */
    /* renamed from: tb.h42$a */
    /* loaded from: classes11.dex */
    static class C9200a implements FileFilter {
        C9200a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (name.startsWith("cpu")) {
                for (int i = 3; i < name.length(); i++) {
                    if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }

    static {
        new C9200a();
    }

    public static String a(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public static boolean c(Context context, int i) {
        CharSequence charSequence;
        TypedValue typedValue = new TypedValue();
        try {
            context.getResources().getValue(i, typedValue, true);
        } catch (Exception e) {
            hh0.c("TCommon", "get resources type value error=%s", e);
        }
        int i2 = typedValue.type;
        if ((i2 == 1 || i2 == 3) && (charSequence = typedValue.string) != null) {
            String charSequence2 = charSequence.toString();
            return charSequence2.endsWith(".png") || charSequence2.endsWith(".jpg") || charSequence2.endsWith(".webp");
        }
        return false;
    }
}
