package tb;

import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.IExprRecorderProtocol;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xy implements IExprRecorderProtocol {
    private static volatile IExprRecorderProtocol a;
    private static volatile IExprRecorderProtocol b;
    private static boolean c;

    public static IExprRecorderProtocol a() {
        if (!c && DinamicXEngine.x() && b == null) {
            synchronized (xy.class) {
                if (b == null) {
                    try {
                        b = (IExprRecorderProtocol) Class.forName("com.taobao.android.dinamicx.devtools.modules.DXDevToolsExprRecorder").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                    } catch (Exception unused) {
                    } catch (Throwable th) {
                        c = true;
                        throw th;
                    }
                    c = true;
                }
            }
        }
        return b == null ? b() : b;
    }

    public static IExprRecorderProtocol b() {
        if (a == null) {
            synchronized (xy.class) {
                if (a == null) {
                    a = new xy();
                }
            }
        }
        return a;
    }

    @Override // com.taobao.android.dinamicx.IExprRecorderProtocol
    public void doAfterEvaluateMethodWithResult(wy wyVar, Object obj, DXRuntimeContext dXRuntimeContext) {
    }

    @Override // com.taobao.android.dinamicx.IExprRecorderProtocol
    public void doAfterExecuteASTWithEventAndContext(wy wyVar, Object obj, DXRuntimeContext dXRuntimeContext) {
    }

    @Override // com.taobao.android.dinamicx.IExprRecorderProtocol
    public void doBeforeEvaluateMethodWithDataOarserAndArgsAndContext(wy wyVar, IDXDataParser iDXDataParser, Object[] objArr, DXRuntimeContext dXRuntimeContext) {
    }

    @Override // com.taobao.android.dinamicx.IExprRecorderProtocol
    public void doBeforeExecuteASTWithEventAndContext(wy wyVar, Object obj, DXRuntimeContext dXRuntimeContext) {
    }
}
