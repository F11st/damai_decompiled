package tb;

import com.taobao.android.dinamic.log.DinamicLog;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class kl1 extends v0 {
    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        DinamicLog.h("NotEvaluation");
        if (list != null) {
            if (list.size() == 1) {
                return Boolean.valueOf(!im1.b(list.get(0).toString()));
            }
            if (list.size() == 0) {
                return Boolean.TRUE;
            }
            return null;
        }
        return null;
    }
}
