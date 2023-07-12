package tb;

import java.math.BigDecimal;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class af0 extends v0 {
    protected boolean a(Object obj, Object obj2) {
        return ((obj instanceof BigDecimal) || (obj2 instanceof BigDecimal)) ? im1.c(obj).compareTo(im1.c(obj2)) == 0 : (im1.a(obj) || im1.a(obj2)) ? im1.d(obj) == im1.d(obj2) : im1.f(obj) == im1.f(obj2);
    }

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        if (list == null || list.size() != 2) {
            return null;
        }
        Object obj = list.get(0);
        Object obj2 = list.get(1);
        if (obj == null && obj2 == null) {
            return Boolean.TRUE;
        }
        if (obj != null && obj2 != null) {
            if (obj.getClass().equals(obj2.getClass())) {
                return Boolean.valueOf(obj.equals(obj2));
            }
            if ((obj instanceof Number) && (obj2 instanceof Number)) {
                return Boolean.valueOf(a(obj, obj2));
            }
            return Boolean.valueOf(obj.equals(obj2));
        }
        return Boolean.FALSE;
    }
}
