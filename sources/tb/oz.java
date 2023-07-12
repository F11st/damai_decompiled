package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import java.util.Arrays;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class oz extends wy {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        public boolean a;
        public int b = 0;
    }

    @Override // tb.wy
    public Object b(@Nullable hy hyVar, DXRuntimeContext dXRuntimeContext) {
        et etVar;
        boolean z;
        Object evalWithArgs;
        Object obj = null;
        try {
            IDXDataParser iDXDataParser = this.b != 0 ? dXRuntimeContext.getParserMap().get(this.b) : null;
            if (iDXDataParser == null) {
                e.a aVar = new e.a("ASTNode", "ASTNode_METHOD_NODE", 100001);
                aVar.e = "exprId:" + this.b;
                dXRuntimeContext.getDxError().c.add(aVar);
                return null;
            }
            if (iDXDataParser instanceof et) {
                etVar = (et) iDXDataParser;
                z = true;
            } else {
                etVar = null;
                z = false;
            }
            List<wy> list = this.a;
            int size = list != null ? list.size() : 0;
            a aVar2 = new a();
            Object[] objArr = new Object[size];
            int i = 0;
            while (i < size) {
                objArr[i] = this.a.get(i).b(hyVar, dXRuntimeContext);
                if (z) {
                    xy.a().doBeforeEvaluateMethodWithDataOarserAndArgsAndContext(this, etVar, Arrays.copyOfRange(objArr, 0, i + 1), dXRuntimeContext);
                    obj = etVar.a(objArr, dXRuntimeContext, aVar2, i);
                    xy.a().doAfterEvaluateMethodWithResult(this, obj, dXRuntimeContext);
                    if (aVar2.a) {
                        break;
                    }
                    int i2 = aVar2.b;
                    if (i2 > 0) {
                        i += i2;
                        aVar2.b = 0;
                    }
                }
                i++;
            }
            if (z) {
                return obj;
            }
            xy.a().doBeforeEvaluateMethodWithDataOarserAndArgsAndContext(this, etVar, objArr, dXRuntimeContext);
            if (iDXDataParser instanceof xv) {
                evalWithArgs = ((xv) iDXDataParser).e(hyVar, objArr, dXRuntimeContext);
            } else {
                evalWithArgs = iDXDataParser.evalWithArgs(objArr, dXRuntimeContext);
            }
            Object obj2 = evalWithArgs;
            xy.a().doAfterEvaluateMethodWithResult(this, obj2, dXRuntimeContext);
            return obj2;
        } catch (Throwable th) {
            e.a aVar3 = new e.a("ASTNode", "ASTNode_METHOD_NODE", com.taobao.android.dinamicx.e.DX_ERROR_CODE_METHOD_NODE_EXECUTE_EXCEPTION);
            aVar3.e = ry.a(th);
            dXRuntimeContext.getDxError().c.add(aVar3);
            ry.b(th);
            return null;
        }
    }
}
