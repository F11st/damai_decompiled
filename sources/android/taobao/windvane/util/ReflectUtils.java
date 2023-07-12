package android.taobao.windvane.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Field;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ReflectUtils {
    @Nullable
    public static Object getField(@NonNull Object obj, @NonNull String str) {
        Field field;
        try {
            try {
                field = obj.getClass().getDeclaredField(str);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (Exception unused) {
            field = obj.getClass().getField(str);
        }
        field.setAccessible(true);
        return field.get(obj);
    }
}
