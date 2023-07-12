package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gq2 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        DinamicLog.h("TripleEvaluation");
        if (list != null && list.size() == 3) {
            try {
                if (im1.b(list.get(0).toString())) {
                    return (String) list.get(1);
                }
                return (String) list.get(2);
            } catch (ClassCastException unused) {
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }
}
