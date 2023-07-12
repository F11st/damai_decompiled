package tb;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class oh2 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        if (list != null) {
            if (list.size() == 3) {
                Object obj = list.get(0);
                int e = im1.e(list.get(1));
                int e2 = im1.e(list.get(2));
                String valueOf = String.valueOf(obj);
                if (e2 < 0 || e + 1 > valueOf.length()) {
                    return "";
                }
                int i = e >= 0 ? e : 0;
                int i2 = e2 + i;
                return i2 + (-1) < obj.toString().length() ? ((String) obj).substring(i, i2) : i2 > obj.toString().length() ? valueOf.substring(i) : null;
            } else if (list.size() == 2) {
                Object obj2 = list.get(0);
                int e3 = im1.e(list.get(1));
                String valueOf2 = String.valueOf(obj2);
                if (e3 + 1 > valueOf2.length()) {
                    return "";
                }
                return valueOf2.substring(e3 >= 0 ? e3 : 0);
            } else {
                return null;
            }
        }
        return null;
    }
}
