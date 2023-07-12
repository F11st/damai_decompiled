package tb;

import com.taobao.update.apk.ApkUpdateContext;
import com.taobao.update.framework.Processor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class k6 {
    private static Map<Class<? extends Processor>, Class<? extends Processor>> a = new HashMap();
    private static Map<Class<? extends Processor>, Processor> b = new HashMap();

    public static Processor<ApkUpdateContext> getProcessor(Class<? extends Processor> cls) {
        try {
            Processor<ApkUpdateContext> processor = b.get(cls);
            if (processor != null) {
                return processor;
            }
            Class<? extends Processor> cls2 = a.get(cls);
            if (cls2 != null) {
                cls = cls2;
            }
            Processor<ApkUpdateContext> newInstance = cls.newInstance();
            b.put(cls, newInstance);
            return newInstance;
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static void registerSpecialProcessor(Class<? extends Processor> cls, Class<? extends Processor> cls2) {
        a.put(cls, cls2);
    }
}
