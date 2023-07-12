package tb;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class au {
    public Object a;
    public String b;
    public Map<Object, Object> c;

    public boolean a(au auVar) {
        return auVar != null && !TextUtils.isEmpty(this.b) && this.b.equals(auVar.b) && this.a == auVar.a;
    }
}
