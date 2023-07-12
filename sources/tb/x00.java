package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class x00 extends cz {
    public static final long DX_PARSER_ROOTDATA = 6173462809577930310L;

    @Override // tb.cz
    protected Object a(DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext == null || dXRuntimeContext.getRootView() == null) {
            return null;
        }
        return dXRuntimeContext.getRootView().getData();
    }

    @Override // com.taobao.android.dinamicx.expression.parser.a, com.taobao.android.dinamicx.expression.expr_v2.IDXFunction
    public String getDxFunctionName() {
        return "rootData";
    }
}
