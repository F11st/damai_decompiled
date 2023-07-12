package tb;

import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class pj0 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        Object[] objArr;
        if (list != null && list.size() == 2) {
            Object obj = list.get(0);
            Object obj2 = list.get(1);
            try {
                if (obj instanceof List) {
                    objArr = ((List) obj).toArray();
                } else {
                    objArr = (Object[]) obj;
                }
                for (int i = 0; i < objArr.length; i++) {
                    if (objArr[i].equals(obj2)) {
                        return objArr[i];
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
