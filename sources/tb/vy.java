package tb;

import android.text.TextUtils;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.IDXEventHandler;
import com.taobao.android.dinamicx.expression.expr_v2.DXBuiltinProvider;
import com.taobao.android.dinamicx.expression.expr_v2.DXExprDxMethodProxy;
import com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy;
import com.taobao.android.dinamicx.expression.expr_v2.IDXFunction;
import com.taobao.android.dinamicx.expression.parser.IDXDataParser;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.script.IDXJSEngine;
import com.taobao.android.dinamicx.template.DXJSCacheManager;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class vy implements DXBuiltinProvider, DXExprDxMethodProxy, DXJSMethodProxy {
    public static final int CALL_DATA_PARSER = 1;
    public static final int CALL_EVENT = 0;
    private HashMap<String, IDXFunction> a;
    private IDXJSEngine b;

    public vy(HashMap<String, IDXFunction> hashMap, IDXJSEngine iDXJSEngine) {
        this.a = hashMap;
        this.b = iDXJSEngine;
    }

    private DXRuntimeContext a(DXWidgetNode dXWidgetNode) {
        DXWidgetNode queryRootWidgetNode;
        if (dXWidgetNode == null || (queryRootWidgetNode = dXWidgetNode.queryRootWidgetNode()) == null) {
            return null;
        }
        if ((queryRootWidgetNode instanceof DXTemplateWidgetNode) && ((DXTemplateWidgetNode) queryRootWidgetNode).get__StorageType() == 1) {
            return a(queryRootWidgetNode.getParentWidget());
        }
        return queryRootWidgetNode.getDXRuntimeContext();
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.DXExprDxMethodProxy
    public az call(DXRuntimeContext dXRuntimeContext, hy hyVar, long j, int i, int i2, az[] azVarArr) {
        Object evalWithArgs;
        Object[] objArr;
        int i3 = 0;
        Object[] objArr2 = null;
        if (i == 0) {
            IDXEventHandler eventHandlerWithId = dXRuntimeContext.getEventHandlerWithId(j);
            if (eventHandlerWithId == null) {
                DXAppMonitor.p(dXRuntimeContext, "DX_SCRIPT", "DX_SCRIPT_ERROR", com.taobao.android.dinamicx.e.DXSCRIPT_EVENT_NOTFOUND_2, "事件: " + j + "找不到");
                return null;
            }
            if (i2 < 0 || azVarArr == null || azVarArr.length != i2) {
                objArr = null;
            } else {
                objArr = new Object[i2];
                while (i3 < i2) {
                    objArr[i3] = azVarArr[i3].s();
                    i3++;
                }
            }
            if (hyVar != null && hyVar.c()) {
                eventHandlerWithId.prepareBindEventWithArgs(objArr, dXRuntimeContext.getWidgetNode().getDXRuntimeContext());
            } else {
                eventHandlerWithId.handleEvent(hyVar, objArr, dXRuntimeContext.getWidgetNode().getDXRuntimeContext());
            }
            return null;
        } else if (i == 1) {
            IDXDataParser iDXDataParser = dXRuntimeContext.getParserMap().get(j);
            if (iDXDataParser == null) {
                DXAppMonitor.p(dXRuntimeContext, "DX_SCRIPT", "DX_SCRIPT_ERROR", com.taobao.android.dinamicx.e.DXSCRIPT_DATAPARSER_NOTFOUND_2, "表达式: " + j + "找不到");
                return null;
            }
            if (i2 >= 0) {
                objArr2 = new Object[i2];
                while (i3 < i2) {
                    objArr2[i3] = azVarArr[i3].s();
                    i3++;
                }
            }
            if (iDXDataParser instanceof xv) {
                evalWithArgs = ((xv) iDXDataParser).e(hyVar, objArr2, dXRuntimeContext);
            } else {
                evalWithArgs = iDXDataParser.evalWithArgs(objArr2, dXRuntimeContext);
            }
            return az.d(evalWithArgs);
        } else {
            DXAppMonitor.p(dXRuntimeContext, "DX_SCRIPT", "DX_SCRIPT_ERROR", com.taobao.android.dinamicx.e.DXSCRIPT_CALLBACK_ERROR, "调用为不认识的type：  " + i);
            return null;
        }
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.DXBuiltinProvider
    public az getFunction(DXRuntimeContext dXRuntimeContext, String str) {
        HashMap<String, IDXFunction> hashMap;
        IDXFunction iDXFunction;
        if (TextUtils.isEmpty(str) || (hashMap = this.a) == null || hashMap.size() == 0 || (iDXFunction = this.a.get(str)) == null) {
            return null;
        }
        return az.I(iDXFunction);
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy
    public boolean isValid() {
        return this.b != null;
    }

    @Override // com.taobao.android.dinamicx.expression.expr_v2.DXJSMethodProxy
    public void call(DXRuntimeContext dXRuntimeContext, hy hyVar, String str, String str2, int i, az[] azVarArr) {
        DXJSCacheManager.DXLoadJSBytesTask dXLoadJSBytesTask;
        if (this.b == null) {
            nz.g(nz.TAG, "call js 失败 idxjsEngine == null");
        } else if (hyVar == null || !hyVar.c()) {
            if (dXRuntimeContext == null) {
                nz.g(nz.TAG, "call js 失败 runtimeContext == null");
            } else if (dXRuntimeContext.getWidgetNode() == null) {
                nz.g(nz.TAG, "call js 失败 runtimeContext widgetNode == null");
            } else {
                DXRuntimeContext a = a(dXRuntimeContext.getWidgetNode());
                if (a == null) {
                    nz.g(nz.TAG, "call js 失败 rootRuntimeContext == null");
                    return;
                }
                if (a.getInstanceId() <= 0) {
                    if (dXRuntimeContext.getDxTemplateItem() == null) {
                        nz.g(nz.TAG, "call js 失败 runtimeContext.getDxTemplateItem() == null");
                        return;
                    }
                    byte[] b = DXJSCacheManager.c().b(dXRuntimeContext.getDxTemplateItem().getIdentifier());
                    if (b == null) {
                        if (dXRuntimeContext.getWidgetNode().isChildWidgetNode()) {
                            dXLoadJSBytesTask = new DXJSCacheManager.DXLoadJSBytesTask(dXRuntimeContext, false);
                        } else {
                            dXLoadJSBytesTask = new DXJSCacheManager.DXLoadJSBytesTask(dXRuntimeContext, true);
                        }
                        dXLoadJSBytesTask.run();
                        nz.s("主线程加载 " + dXRuntimeContext.getDxTemplateItem().getIdentifier() + " 的js文件");
                        byte[] jsBytes = dXLoadJSBytesTask.getJsBytes();
                        if (jsBytes != null) {
                            DXJSCacheManager.c().e(dXRuntimeContext.getDxTemplateItem().getIdentifier(), dXLoadJSBytesTask.getJsBytes());
                        }
                        b = jsBytes;
                    }
                    a.setInstanceId(this.b.decode(dXRuntimeContext, b));
                }
                nz.a("开始调用js的函数  module: " + str + "  method:  " + str2);
                this.b.run(a.getInstanceId(), dXRuntimeContext, str, str2, i, azVarArr);
            }
        }
    }
}
