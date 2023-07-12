package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.reflect.ParameterizedType;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ok2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static <T> T a(Object obj, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1058074004")) {
            return (T) ipChange.ipc$dispatch("1058074004", new Object[]{obj, Integer.valueOf(i)});
        }
        try {
            return (T) ((Class) ((ParameterizedType) obj.getClass().getGenericSuperclass()).getActualTypeArguments()[i]).newInstance();
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}
