package tb;

import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class bz {
    private Map<String, az> a = new HashMap();

    public az a(String str) {
        az azVar = this.a.get(str);
        return azVar == null ? az.L() : azVar;
    }

    public void b(String str, az azVar) {
        if (str == null) {
            return;
        }
        if (azVar == null) {
            this.a.remove(str);
        } else {
            this.a.put(str, azVar);
        }
    }

    public String toString() {
        return "DXScriptVarObject" + this.a.toString();
    }
}
