package tb;

import android.graphics.Color;
import android.util.Log;
import com.taobao.android.dinamicx.DXDarkModeCenter;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.expression.parser.AbstractC6375a;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ev extends AbstractC6375a {
    public static final long DX_PARSER_COLORMAP = 1756245084560162885L;

    private int a(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            Log.e("ParserLinearGradient", str + "parse Color failed. color miss");
            return -12303292;
        }
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        if (objArr != null && objArr.length >= 2 && objArr.length % 2 != 1 && DXDarkModeCenter.d()) {
            HashMap hashMap = new HashMap(5);
            for (int i = 0; i < objArr.length / 2; i++) {
                int i2 = i * 2;
                if (objArr[i2] instanceof String) {
                    int i3 = i2 + 1;
                    if (objArr[i3] instanceof String) {
                        hashMap.put((String) objArr[i2], Integer.valueOf(a((String) objArr[i3])));
                    }
                }
                return null;
            }
            if (hashMap.size() > 0) {
                return hashMap;
            }
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.AbstractC6375a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "colorMap";
    }
}
