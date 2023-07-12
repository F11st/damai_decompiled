package tb;

import android.app.Activity;
import com.alibaba.ut.page.VirtualPageObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class bq1 {
    public static Stack<VirtualPageObject> a = new Stack<>();

    public static void a(VirtualPageObject virtualPageObject) {
        if (virtualPageObject != null) {
            a.remove(virtualPageObject);
        }
    }

    public static List<VirtualPageObject> b(Activity activity) {
        ArrayList arrayList = new ArrayList();
        Iterator<VirtualPageObject> it = a.iterator();
        while (it.hasNext()) {
            VirtualPageObject next = it.next();
            if (next.b == activity.hashCode()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }
}
