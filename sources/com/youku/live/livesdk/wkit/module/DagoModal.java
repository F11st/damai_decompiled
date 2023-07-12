package com.youku.live.livesdk.wkit.module;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.livesdk.wkit.widget.ModalWidget;
import com.youku.live.widgets.model.template.WidgetAttributesModel;
import com.youku.live.widgets.model.template.WidgetModel;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DagoModal extends WXModule implements Destroyable, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_H5 = "h5";
    public static final String TYPE_NATIVE = "native";
    public static final String TYPE_WEEX = "weex";
    private JSCallback mCloseCallback;
    private String mLayerId;

    @JSMethod
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1689158472")) {
            ipChange.ipc$dispatch("-1689158472", new Object[]{this});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.closeDialog(null);
        }
    }

    @JSMethod
    public void closeWithId(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1710486463")) {
            ipChange.ipc$dispatch("-1710486463", new Object[]{this, str});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.closeDialog(str);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-503988042")) {
            ipChange.ipc$dispatch("-503988042", new Object[]{this});
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        JSCallback jSCallback;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1669766585")) {
            ipChange.ipc$dispatch("-1669766585", new Object[]{this, str, obj, obj2});
        } else if (ModalWidget.MODAL_CLOSE.equals(str) && (obj instanceof String) && (jSCallback = this.mCloseCallback) != null) {
            jSCallback.invoke(obj);
        }
    }

    @JSMethod
    public void open(Map<String, String> map, JSCallback jSCallback, JSCallback jSCallback2, JSCallback jSCallback3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1149794035")) {
            ipChange.ipc$dispatch("1149794035", new Object[]{this, map, jSCallback, jSCallback2, jSCallback3});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.addDataHandler(ModalWidget.MODAL_CLOSE, this);
        }
        this.mCloseCallback = jSCallback3;
        WidgetModel widgetModel = new WidgetModel();
        widgetModel.name = ModalWidget.WIDGET_NAME;
        widgetModel.atts = new WidgetAttributesModel();
        WidgetAttributesModel.OrientationModel orientationModel = new WidgetAttributesModel.OrientationModel();
        WidgetAttributesModel.MarginModel marginModel = new WidgetAttributesModel.MarginModel();
        orientationModel.margin = marginModel;
        marginModel.l = 0;
        orientationModel.margin.t = 0;
        orientationModel.margin.r = 0;
        orientationModel.margin.b = 0;
        widgetModel.atts.landscape = orientationModel;
        WidgetAttributesModel.OrientationModel orientationModel2 = new WidgetAttributesModel.OrientationModel();
        WidgetAttributesModel.MarginModel marginModel2 = new WidgetAttributesModel.MarginModel();
        orientationModel2.margin = marginModel2;
        marginModel2.l = 0;
        orientationModel2.margin.t = 0;
        orientationModel2.margin.r = 0;
        orientationModel2.margin.b = 0;
        WidgetAttributesModel widgetAttributesModel = widgetModel.atts;
        widgetAttributesModel.portrait = orientationModel2;
        if (map == null) {
            map = new HashMap<>();
        }
        widgetAttributesModel.extra = map;
        HashMap hashMap = new HashMap();
        String showDialog = widgetEngineInstance != null ? widgetEngineInstance.showDialog(widgetModel) : null;
        if (showDialog == null) {
            if (jSCallback2 != null) {
                jSCallback2.invoke(hashMap);
                return;
            }
            return;
        }
        this.mLayerId = showDialog;
        if (jSCallback != null) {
            hashMap.put("layerId", showDialog);
            jSCallback.invoke(hashMap);
        }
    }
}
