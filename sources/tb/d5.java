package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d5 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        DinamicLog.h("AndEvaluation");
        if (list != null && list.size() > 1) {
            int size = list.size();
            try {
                boolean b = im1.b(list.get(0).toString());
                for (int i = 1; i < size; i++) {
                    b = b && im1.b(list.get(i).toString());
                }
                return Boolean.valueOf(b);
            } catch (ClassCastException unused) {
                DinamicLog.h("boolean cast error!");
            }
        }
        return null;
    }
}
