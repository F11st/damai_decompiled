package com.youku.live.dago.widgetlib.module;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.youku.arch.v3.core.Constants;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.DagoInputBoxDialog;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.DagoInputBoxUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.IDagoInputBox;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.OnInputBoxListener;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.protocol.IDataHandler;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DagoChatInputModule extends WXModule implements IDataHandler {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String DATA_KEY_LAIFENG_KEYBOARD_SHOW = "DATA_KEY_LAIFENG_KEYBOARD_SHOW";
    private static final String EVENT_KEY_BOARD_CHANGED = "EVENT_KEY_BOARD_CHANGED";
    private static final String TAG = "DagoChatInputModule";
    private JSCallback mCallback;
    private IDagoInputBox mDagoInputBox;
    private Map<String, Object> mResult = new HashMap();
    private DagoInputBoxDialog.OnInputDialogShowListener inputDialogShowListener = new DagoInputBoxDialog.OnInputDialogShowListener() { // from class: com.youku.live.dago.widgetlib.module.DagoChatInputModule.2
        private static transient /* synthetic */ IpChange $ipChange;

        @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.DagoInputBoxDialog.OnInputDialogShowListener
        public void dialogShow(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "25552823")) {
                ipChange.ipc$dispatch("25552823", new Object[]{this, Boolean.valueOf(z)});
            } else if (z) {
                DagoChatInputModule.this.putData(DagoChatInputModule.DATA_KEY_LAIFENG_KEYBOARD_SHOW, Boolean.TRUE);
            } else {
                DagoChatInputModule.this.putData(DagoChatInputModule.DATA_KEY_LAIFENG_KEYBOARD_SHOW, Boolean.FALSE);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void asyncPutDataAdrKeyboardHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372265837")) {
            ipChange.ipc$dispatch("372265837", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("height", Integer.valueOf(i));
            widgetEngineInstance.asyncPutData("adrKeyboardHeight", hashMap);
        }
    }

    private void initWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-164433281")) {
            ipChange.ipc$dispatch("-164433281", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "initWithNothing");
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.addDataHandler(EVENT_KEY_BOARD_CHANGED, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWithNothing() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1800395476")) {
            ipChange.ipc$dispatch("1800395476", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).i(TAG, "releaseWithNothing");
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.removeDataHandler(EVENT_KEY_BOARD_CHANGED, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(JSCallback jSCallback, String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-404061745")) {
            ipChange.ipc$dispatch("-404061745", new Object[]{this, jSCallback, str, str2, Boolean.valueOf(z)});
            return;
        }
        this.mResult.clear();
        this.mResult.put("result", str);
        this.mResult.put("text", str2);
        this.mResult.put("switchActive", Boolean.valueOf(z));
        jSCallback.invoke(this.mResult);
    }

    @JSMethod(uiThread = false)
    public void addChatListMessage(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1862816439")) {
            ipChange.ipc$dispatch("1862816439", new Object[]{this, str, map});
        } else {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "addChatListMessage");
        }
    }

    @JSMethod
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1816754974")) {
            ipChange.ipc$dispatch("1816754974", new Object[]{this});
            return;
        }
        ((ILog) Dsl.getService(ILog.class)).d(TAG, "jiangzInput close JSMethod");
        try {
            IDagoInputBox iDagoInputBox = this.mDagoInputBox;
            if (iDagoInputBox != null) {
                iDagoInputBox.close();
                this.mDagoInputBox = null;
            }
            asyncPutDataAdrKeyboardHeight(0);
            this.mCallback = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @JSMethod
    public void config(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-931136301")) {
            ipChange.ipc$dispatch("-931136301", new Object[]{this, map});
        } else {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, Constants.CONFIG);
        }
    }

    @Override // com.youku.live.widgets.protocol.IDataHandler
    public void onDataChanged(String str, Object obj, Object obj2) {
        IDagoInputBox iDagoInputBox;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2006422061")) {
            ipChange.ipc$dispatch("2006422061", new Object[]{this, str, obj, obj2});
        } else if (EVENT_KEY_BOARD_CHANGED.equals(str) && (obj instanceof Map)) {
            Map map = (Map) obj;
            int intValue = ((Integer) map.get("keyboardHeight")).intValue();
            boolean z = ((Integer) map.get("isShow")).intValue() == 1;
            ((ILog) Dsl.getService(ILog.class)).d("jiangzkb", "isShowKeyboard: " + z + ", keyboardHeight: " + intValue);
            if (!z && (iDagoInputBox = this.mDagoInputBox) != null && !iDagoInputBox.isShowExpressionPanel() && this.mDagoInputBox.canClose()) {
                ((ILog) Dsl.getService(ILog.class)).w("jiangzkb", "键盘收起时隐藏输入框");
                IDagoInputBox iDagoInputBox2 = this.mDagoInputBox;
                if (iDagoInputBox2 != null && this.mCallback != null) {
                    setResult(this.mCallback, "cancel", TextUtils.isEmpty(iDagoInputBox2.getInputText()) ? "" : this.mDagoInputBox.getInputText().toString(), this.mDagoInputBox.useBarrage());
                }
                ((ILog) Dsl.getService(ILog.class)).d(TAG, "jiangzInput close isShowKeyboard is false");
                close();
                return;
            }
            int screenHeight = (int) (UIUtil.getScreenHeight(AppContextUtils.getApp()) * 0.8f);
            ((ILog) Dsl.getService(ILog.class)).i("jiangzkb", "maxValidValue: " + screenHeight);
            if (intValue >= 50 && intValue <= screenHeight) {
                DagoInputBoxUtils.saveKeyboardHeight(intValue);
                IDagoInputBox iDagoInputBox3 = this.mDagoInputBox;
                if (iDagoInputBox3 != null) {
                    iDagoInputBox3.updatePanelContainerHeight(DagoInputBoxUtils.getKeyboardHeight());
                    return;
                }
                return;
            }
            ((ILog) Dsl.getService(ILog.class)).e("jiangzkb", "invalid keyboardHeight: " + intValue);
        }
    }

    @JSMethod
    public void open(Map<String, Object> map, final JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1800257395")) {
            ipChange.ipc$dispatch("-1800257395", new Object[]{this, map, jSCallback});
        } else if (UIUtil.isFastDoubleClick()) {
        } else {
            try {
                this.mCallback = jSCallback;
                initWithNothing();
                DagoInputBoxDialog dagoInputBoxDialog = new DagoInputBoxDialog(this.mWXSDKInstance.getContext(), map);
                this.mDagoInputBox = dagoInputBoxDialog;
                if (dagoInputBoxDialog instanceof DagoInputBoxDialog) {
                    dagoInputBoxDialog.setOnInputDialogShowListener(this.inputDialogShowListener);
                }
                this.mDagoInputBox.setOnInputBoxListener(new OnInputBoxListener() { // from class: com.youku.live.dago.widgetlib.module.DagoChatInputModule.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.OnInputBoxListener
                    public void onChangeExpressionPanel(boolean z) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "1246104104")) {
                            ipChange2.ipc$dispatch("1246104104", new Object[]{this, Boolean.valueOf(z)});
                        } else if (z) {
                            DagoChatInputModule.this.asyncPutDataAdrKeyboardHeight(UIUtil.px2wx(DagoInputBoxUtils.HEIGHT_PANEL_EMOJI + DagoInputBoxUtils.HEIGHT_EDIT_TEXT_DEFAULT + UIUtil.dip2px(6)));
                        }
                    }

                    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.OnInputBoxListener
                    public void onDismiss() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1660390754")) {
                            ipChange2.ipc$dispatch("-1660390754", new Object[]{this});
                            return;
                        }
                        if (DagoChatInputModule.this.mDagoInputBox != null) {
                            String charSequence = TextUtils.isEmpty(DagoChatInputModule.this.mDagoInputBox.getInputText()) ? "" : DagoChatInputModule.this.mDagoInputBox.getInputText().toString();
                            DagoChatInputModule dagoChatInputModule = DagoChatInputModule.this;
                            dagoChatInputModule.setResult(jSCallback, "cancel", charSequence, dagoChatInputModule.mDagoInputBox.useBarrage());
                        }
                        DagoChatInputModule.this.releaseWithNothing();
                    }

                    @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.OnInputBoxListener
                    public void onSendMessage(String str) {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-1007068749")) {
                            ipChange2.ipc$dispatch("-1007068749", new Object[]{this, str});
                        } else if (DagoChatInputModule.this.mDagoInputBox != null) {
                            DagoChatInputModule dagoChatInputModule = DagoChatInputModule.this;
                            dagoChatInputModule.setResult(jSCallback, "send", str, dagoChatInputModule.mDagoInputBox.useBarrage());
                        }
                    }
                });
                ((ILog) Dsl.getService(ILog.class)).d(TAG, "jiangzInput mDagoInputBox show");
                this.mDagoInputBox.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void putData(String str, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1251755651")) {
            ipChange.ipc$dispatch("1251755651", new Object[]{this, str, obj});
            return;
        }
        IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(this);
        if (widgetEngineInstance != null) {
            widgetEngineInstance.putData(str, obj);
        }
    }

    @JSMethod
    public void secretOpen(Map<String, Object> map, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-219014019")) {
            ipChange.ipc$dispatch("-219014019", new Object[]{this, map, jSCallback});
        } else {
            ((ILog) Dsl.getService(ILog.class)).i(TAG, "secretOpen");
        }
    }
}
