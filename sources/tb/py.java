package tb;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class py {
    private Map<String, iy> a = new HashMap();
    private Map<String, wy> b = new HashMap();

    public py a() {
        py pyVar = new py();
        for (Map.Entry<String, iy> entry : this.a.entrySet()) {
            pyVar.e(entry.getKey(), entry.getValue().b());
        }
        pyVar.b = this.b;
        return pyVar;
    }

    public wy b(String str) {
        return this.b.get(str);
    }

    public iy c(String str) {
        return this.a.get(str);
    }

    public void d(Map<String, wy> map) {
        if (map == null) {
            return;
        }
        this.b.putAll(map);
    }

    public boolean e(String str, iy iyVar) {
        this.a.put(str, iyVar);
        return true;
    }
}
