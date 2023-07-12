package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.IDXEventHandler;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qy extends wy {
    @Override // tb.wy
    public Object b(@Nullable hy hyVar, DXRuntimeContext dXRuntimeContext) {
        if (dXRuntimeContext != null) {
            try {
            } catch (Exception e) {
                if (DinamicXEngine.x()) {
                    e.printStackTrace();
                }
                C6368e c6368e = new C6368e(dXRuntimeContext.getBizType());
                C6368e.C6369a c6369a = new C6368e.C6369a("ASTNode", "ASTNode_EventHandler", C6368e.DX_ERROR_CODE_AST_EVENT_EXECUTE_EXCEPTION);
                c6368e.b = dXRuntimeContext.getDxTemplateItem();
                if (hyVar != null) {
                    c6369a.e = "eventId: " + hyVar.b() + " isPrepareBind: " + hyVar.c() + "  stack： " + ry.a(e);
                }
                c6368e.c.add(c6369a);
                DXAppMonitor.n(c6368e);
            }
            if (dXRuntimeContext.getWidgetNode() != null) {
                IDXEventHandler eventHandlerWithId = dXRuntimeContext.getEventHandlerWithId(this.b);
                if (eventHandlerWithId == null) {
                    if (hyVar != null && !hyVar.c()) {
                        C6368e c6368e2 = new C6368e(dXRuntimeContext.getBizType());
                        if (dXRuntimeContext.getDxTemplateItem() != null) {
                            c6368e2.b = dXRuntimeContext.getDxTemplateItem();
                        }
                        C6368e.C6369a c6369a2 = new C6368e.C6369a("ASTNode", "ASTNode_EventHandler", C6368e.DX_ERROR_CODE_AST_EVENT_HANDLER_NOT_FOUND);
                        c6369a2.e = "找不到用户注册的eventHandle  hashcode 为: " + this.b;
                        c6368e2.c.add(c6369a2);
                        DXAppMonitor.n(c6368e2);
                    }
                    return null;
                }
                List<wy> list = this.a;
                int size = list != null ? list.size() : 0;
                Object[] objArr = new Object[size];
                for (int i = 0; i < size; i++) {
                    objArr[i] = this.a.get(i).b(hyVar, dXRuntimeContext);
                }
                if (hyVar != null && hyVar.c()) {
                    eventHandlerWithId.prepareBindEventWithArgs(objArr, dXRuntimeContext.getWidgetNode().getDXRuntimeContext());
                } else {
                    eventHandlerWithId.handleEvent(hyVar, objArr, dXRuntimeContext.getWidgetNode().getDXRuntimeContext());
                }
                if (dXRuntimeContext.isOpenNewFastReturnLogic()) {
                    return new Object();
                }
            }
        }
        return null;
    }
}
