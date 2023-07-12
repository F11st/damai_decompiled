package tb;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class s20 {
    public static void a(List list) {
        if (list == null) {
            return;
        }
        try {
            Iterator it = list.iterator();
            if (it == null) {
                return;
            }
            while (it.hasNext()) {
                Object next = it.next();
                if ((next instanceof WeakReference) && ((WeakReference) next).get() == null) {
                    it.remove();
                }
            }
        } catch (Exception e) {
            ry.b(e);
        }
    }
}
