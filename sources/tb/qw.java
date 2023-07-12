package tb;

import android.os.Build;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qw extends com.taobao.android.dinamicx.expression.parser.a {
    private boolean a() {
        return Build.VERSION.SDK_INT >= 17 && DinamicXEngine.i().getResources().getConfiguration().getLayoutDirection() == 1;
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.parser.IDXDataParser
    public Object evalWithArgs(Object[] objArr, DXRuntimeContext dXRuntimeContext) {
        return Boolean.valueOf(a());
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "isRTL";
    }
}
