package tb;

import android.util.SparseArray;
import com.alibaba.poplayerconsole.lib.StandOutWindow;
import com.alibaba.poplayerconsole.lib.Window;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class s13 {
    public Map<Class<? extends StandOutWindow>, SparseArray<Window>> a = new HashMap();

    public Window a(int i, Class<? extends StandOutWindow> cls) {
        SparseArray<Window> sparseArray = this.a.get(cls);
        if (sparseArray == null) {
            return null;
        }
        return sparseArray.get(i);
    }

    public Set<Integer> b(Class<? extends StandOutWindow> cls) {
        SparseArray<Window> sparseArray = this.a.get(cls);
        if (sparseArray == null) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < sparseArray.size(); i++) {
            hashSet.add(Integer.valueOf(sparseArray.keyAt(i)));
        }
        return hashSet;
    }

    public int c(Class<? extends StandOutWindow> cls) {
        SparseArray<Window> sparseArray = this.a.get(cls);
        if (sparseArray == null) {
            return 0;
        }
        return sparseArray.size();
    }

    public boolean d(int i, Class<? extends StandOutWindow> cls) {
        return a(i, cls) != null;
    }

    public void e(int i, Class<? extends StandOutWindow> cls, Window window) {
        SparseArray<Window> sparseArray = this.a.get(cls);
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.a.put(cls, sparseArray);
        }
        sparseArray.put(i, window);
    }

    public void f(int i, Class<? extends StandOutWindow> cls) {
        SparseArray<Window> sparseArray = this.a.get(cls);
        if (sparseArray != null) {
            sparseArray.remove(i);
            if (sparseArray.size() == 0) {
                this.a.remove(cls);
            }
        }
    }

    public int g() {
        return this.a.size();
    }
}
