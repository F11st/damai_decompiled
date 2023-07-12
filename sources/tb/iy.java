package tb;

import com.taobao.android.dinamicx.eventchain.DXAtomicEventNode;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class iy {
    private String a;
    private Map<String, DXAtomicEventNode> b;

    public iy(String str, int i) {
        this.a = str;
        this.b = new HashMap(i);
    }

    public void a(String str, DXAtomicEventNode dXAtomicEventNode) {
        this.b.put(str, dXAtomicEventNode);
    }

    public iy b() {
        iy iyVar = new iy(this.a, this.b.size());
        for (Map.Entry<String, DXAtomicEventNode> entry : this.b.entrySet()) {
            iyVar.a(entry.getKey(), entry.getValue().h());
        }
        return iyVar;
    }

    public DXAtomicEventNode c(String str) {
        return this.b.get(str);
    }

    public String d() {
        return this.a;
    }
}
