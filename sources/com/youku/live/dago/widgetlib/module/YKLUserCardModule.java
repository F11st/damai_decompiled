package com.youku.live.dago.widgetlib.module;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.youku.live.dago.widgetlib.component.DagoUserCardDialog;
import com.youku.live.livesdk.model.mtop.data.LiveFullInfoData;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class YKLUserCardModule extends WXModule implements Destroyable, IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DAGO_LIVE_START_OR_STOP_PROP = "dagoLiveStartOrStopProp";
    private static final String TAG = "YKLUserCardModule";
    private DagoUserCardDialog mDialog;
    private IEngineInstance mEngineInstance;
    private String mScreenId = "";
    private String mAnchorId = "";

    private void closeDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2056923118")) {
            ipChange.ipc$dispatch("2056923118", new Object[]{this});
            return;
        }
        DagoUserCardDialog dagoUserCardDialog = this.mDialog;
        if (dagoUserCardDialog != null) {
            dagoUserCardDialog.dismiss();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0044, code lost:
        if (((java.lang.Boolean) r1).booleanValue() == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void showUserCardDialog(android.content.Context r6, boolean r7, java.lang.String r8, boolean r9, java.lang.String r10, com.taobao.weex.bridge.JSCallback r11) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.dago.widgetlib.module.YKLUserCardModule.$ipChange
            java.lang.String r1 = "627726332"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L2e
            r2 = 7
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r4] = r5
            r2[r3] = r6
            r6 = 2
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            r2[r6] = r7
            r6 = 3
            r2[r6] = r8
            r6 = 4
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r9)
            r2[r6] = r7
            r6 = 5
            r2[r6] = r10
            r6 = 6
            r2[r6] = r11
            r0.ipc$dispatch(r1, r2)
            return
        L2e:
            com.youku.live.widgets.protocol.IEngineInstance r0 = com.youku.live.widgets.widgets.weex.WeexHelper.getWidgetEngineInstance(r5)
            if (r0 == 0) goto L47
            java.lang.String r1 = "dagoLiveStartOrStopProp"
            java.lang.Object r1 = r0.getData(r1)
            boolean r2 = r1 instanceof java.lang.Boolean
            if (r2 == 0) goto L47
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L47
            goto L48
        L47:
            r3 = 0
        L48:
            java.lang.String r1 = ""
            if (r0 == 0) goto L61
            com.youku.live.widgets.protocol.IProps r0 = r0.getOptions()
            if (r0 == 0) goto L61
            java.lang.String r2 = "pagename"
            java.lang.String r2 = r0.getString(r2, r1)
            java.lang.String r4 = "spm-cnt"
            java.lang.String r1 = r0.getString(r4, r1)
            r0 = r1
            r1 = r2
            goto L62
        L61:
            r0 = r1
        L62:
            com.youku.live.dago.widgetlib.component.DagoUserCardDialog r2 = new com.youku.live.dago.widgetlib.component.DagoUserCardDialog
            r2.<init>(r6, r3)
            r5.mDialog = r2
            r2.setActor(r7)
            com.youku.live.dago.widgetlib.component.DagoUserCardDialog r6 = r5.mDialog
            r6.setShowChatEntrance(r9)
            com.youku.live.dago.widgetlib.component.DagoUserCardDialog r6 = r5.mDialog
            r6.setUTPageName(r1)
            com.youku.live.dago.widgetlib.component.DagoUserCardDialog r6 = r5.mDialog
            java.lang.String r7 = r5.mAnchorId
            r6.setUTAnchorId(r7)
            com.youku.live.dago.widgetlib.component.DagoUserCardDialog r6 = r5.mDialog
            java.lang.String r7 = r5.mScreenId
            r6.setUTScreenId(r7)
            com.youku.live.dago.widgetlib.component.DagoUserCardDialog r6 = r5.mDialog
            r6.setUTSpmCnt(r0)
            com.youku.live.dago.widgetlib.component.DagoUserCardDialog r6 = r5.mDialog
            r6.setRoomId(r8)
            com.youku.live.dago.widgetlib.component.DagoUserCardDialog r6 = r5.mDialog
            r6.setTargetUserId(r10)
            com.youku.live.dago.widgetlib.component.DagoUserCardDialog r6 = r5.mDialog
            r6.setJSCallback(r11)
            com.youku.live.dago.widgetlib.component.DagoUserCardDialog r6 = r5.mDialog
            r6.showDialog()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.dago.widgetlib.module.YKLUserCardModule.showUserCardDialog(android.content.Context, boolean, java.lang.String, boolean, java.lang.String, com.taobao.weex.bridge.JSCallback):void");
    }

    @JSMethod
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1376295146")) {
            ipChange.ipc$dispatch("-1376295146", new Object[]{this});
            return;
        }
        closeDialog();
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler("mtop.youku.live.com.livefullinfo", this);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-490042476")) {
            ipChange.ipc$dispatch("-490042476", new Object[]{this});
        } else if (this.mDialog != null) {
            this.mDialog = null;
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "167009317")) {
            ipChange.ipc$dispatch("167009317", new Object[]{this, str, obj, obj2});
        } else if ("mtop.youku.live.com.livefullinfo".equals(str) && (obj instanceof LiveFullInfoData)) {
            LiveFullInfoData liveFullInfoData = (LiveFullInfoData) obj;
            this.mAnchorId = liveFullInfoData.anchorYtid + "";
            this.mScreenId = liveFullInfoData.screenId + "";
        }
    }

    @JSMethod
    public void open(Map<String, String> map, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1904434283")) {
            ipChange.ipc$dispatch("-1904434283", new Object[]{this, map, jSCallback});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            this.mEngineInstance = widgetEngineInstance;
            widgetEngineInstance.addDataHandler("mtop.youku.live.com.livefullinfo", this);
            String str = map.get("userId");
            String str2 = map.get("isAnchor");
            String str3 = map.get("showChatEntrance");
            showUserCardDialog(this.mEngineInstance.getContext(), TextUtils.isEmpty(str2) ? false : "true".equals(str2), map.get("roomId"), TextUtils.isEmpty(str3) ? true : "true".equals(str3), str, jSCallback);
        }
    }
}
