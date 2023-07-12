package tb;

import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.IDXEventHandler;
import com.taobao.android.dinamicx.e;
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
                com.taobao.android.dinamicx.e eVar = new com.taobao.android.dinamicx.e(dXRuntimeContext.getBizType());
                e.a aVar = new e.a("ASTNode", "ASTNode_EventHandler", com.taobao.android.dinamicx.e.DX_ERROR_CODE_AST_EVENT_EXECUTE_EXCEPTION);
                eVar.b = dXRuntimeContext.getDxTemplateItem();
                if (hyVar != null) {
                    aVar.e = "eventId: " + hyVar.b() + " isPrepareBind: " + hyVar.c() + "  stack： " + ry.a(e);
                }
                eVar.c.add(aVar);
                DXAppMonitor.n(eVar);
            }
            if (dXRuntimeContext.getWidgetNode() != null) {
                IDXEventHandler eventHandlerWithId = dXRuntimeContext.getEventHandlerWithId(this.b);
                if (eventHandlerWithId == null) {
                    if (hyVar != null && !hyVar.c()) {
                        com.taobao.android.dinamicx.e eVar2 = new com.taobao.android.dinamicx.e(dXRuntimeContext.getBizType());
                        if (dXRuntimeContext.getDxTemplateItem() != null) {
                            eVar2.b = dXRuntimeContext.getDxTemplateItem();
                        }
                        e.a aVar2 = new e.a("ASTNode", "ASTNode_EventHandler", com.taobao.android.dinamicx.e.DX_ERROR_CODE_AST_EVENT_HANDLER_NOT_FOUND);
                        aVar2.e = "找不到用户注册的eventHandle  hashcode 为: " + this.b;
                        eVar2.c.add(aVar2);
                        DXAppMonitor.n(eVar2);
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
