package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.HashMap;
import java.util.Map;
import tb.uy;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class b10 extends wy {
    @Override // tb.wy
    public Object b(@Nullable hy hyVar, DXRuntimeContext dXRuntimeContext) {
        if (hyVar != null) {
            try {
                if (hyVar.c()) {
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                ry.b(th);
                DXAppMonitor.p(dXRuntimeContext, "DX_SCRIPT", "DX_SCRIPT_ERROR", C6368e.DXSCRIPT_SCRIPT_NODE_ERROR, ry.a(th));
                return null;
            }
        }
        uy c = dXRuntimeContext.getEngineContext() == null ? null : dXRuntimeContext.getEngineContext().c();
        if (c == null) {
            return null;
        }
        String identifier = dXRuntimeContext.getDxTemplateItem() == null ? null : dXRuntimeContext.getDxTemplateItem().getIdentifier();
        if (!c.a(identifier)) {
            DXWidgetNode widgetNode = dXRuntimeContext.getWidgetNode();
            if (widgetNode == null) {
                nz.h(identifier + " 执行表达式失败: thisNode == null");
                return null;
            }
            DXWidgetNode queryRootWidgetNode = widgetNode.queryRootWidgetNode();
            if (queryRootWidgetNode == null) {
                nz.h(identifier + " 执行表达式失败: rootNode == null)");
                return null;
            }
            byte[] dxExprBytes = queryRootWidgetNode.getDxExprBytes();
            if (dxExprBytes == null) {
                return null;
            }
            c.b(identifier, dxExprBytes, 0);
        }
        HashMap hashMap = new HashMap();
        if (hyVar != null && hyVar.a() != null) {
            hashMap.putAll(hyVar.a());
        }
        Map<String, az> env = dXRuntimeContext.getEnv();
        if (env != null) {
            hashMap.putAll(env);
        }
        try {
            uy.C9793a f = c.f(dXRuntimeContext, hyVar, identifier, (int) this.b, dXRuntimeContext.getData(), null, null, hashMap, dXRuntimeContext.getEngineContext().d(), dXRuntimeContext.getEngineContext().d(), dXRuntimeContext.getEngineContext().d());
            if (f.a) {
                return az.P(f.c);
            }
            nz.h(identifier + " 模板中执行表达式失败: " + f.b);
            return null;
        } catch (Throwable th2) {
            th = th2;
            ry.b(th);
            DXAppMonitor.p(dXRuntimeContext, "DX_SCRIPT", "DX_SCRIPT_ERROR", C6368e.DXSCRIPT_SCRIPT_NODE_ERROR, ry.a(th));
            return null;
        }
    }
}
