package tb;

import android.text.TextUtils;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class qs1 extends v0 {
    public static final String PARSER_TAG = "platform";

    @Override // com.taobao.android.dinamic.expression.parser.DinamicDataParser
    public Object evalWithArgs(List list, v80 v80Var) {
        if (list != null && list.size() >= 1) {
            String valueOf = String.valueOf(list.get(0));
            if (TextUtils.isEmpty(valueOf)) {
                return Boolean.FALSE;
            }
            if ("Android".equalsIgnoreCase(valueOf)) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }
}
