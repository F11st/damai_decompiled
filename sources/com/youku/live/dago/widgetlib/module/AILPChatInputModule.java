package com.youku.live.dago.widgetlib.module;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.ui.component.WXComponent;
import com.youku.danmaku.engine.BuildConfig;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.AILPChatInputWithKeyWordDialog;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.DagoInputBoxDialog;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.KeywordChatInputDto;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.OnInputBoxListener;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.adapter.YellInfoBean;
import com.youku.live.dago.widgetlib.ailproom.manager.ChatResourceManager;
import com.youku.live.dago.widgetlib.component.AILPChatListComponent;
import com.youku.live.dago.widgetlib.util.UIUtil;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.widgets.protocol.IEngineInstance;
import com.youku.live.widgets.widgets.weex.WeexHelper;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPChatInputModule extends WXModule {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "AILPChatInputModule";
    private boolean hasYell;
    private AILPChatInputWithKeyWordDialog keyWordDialog;
    private DagoInputBoxDialog mInputBoxDialog;
    private boolean showPanelGif;
    private String yellIconUrl;
    String LIMIT = "limit";
    String HINT = Constants.Name.PLACEHOLDER;
    String RESULT = "result";
    String TEXT = "text";
    String SEND = "send";
    String CANCEL = "cancel";
    String HASYELL = "hasYell";
    String SHOWYELL = "showYell";
    String YELLSOURCE = "yellSource";
    String YELLICON = "yellIcon";
    String SHOW_PANEL_GIF = "showPanelGif";
    String SWITCH_TEXT = "switchText";
    String SWITCH_TYPE = "switchType";
    String EMOJI = "emoji";
    Map<String, Object> mResult = new HashMap();

    private void parseExpressSource(String str) {
        JSONArray parseArray;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2021263615")) {
            ipChange.ipc$dispatch("2021263615", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str) && (parseArray = JSON.parseArray(str)) != null && parseArray.size() > 0) {
            for (int i = 0; i < parseArray.size(); i++) {
                JSONObject jSONObject = (JSONObject) parseArray.get(i);
                YellInfoBean yellInfoBean = new YellInfoBean();
                yellInfoBean.id = jSONObject.getString("id");
                yellInfoBean.url = jSONObject.getString("url");
                yellInfoBean.tag = jSONObject.getString("tag");
                if (jSONObject.containsKey(WXComponent.PROP_FS_WRAP_CONTENT)) {
                    yellInfoBean.w = jSONObject.getInteger(WXComponent.PROP_FS_WRAP_CONTENT).intValue();
                }
                if (jSONObject.containsKey("h")) {
                    yellInfoBean.h = jSONObject.getInteger("h").intValue();
                }
                ChatResourceManager.getInstance().addYellSource(yellInfoBean.tag, yellInfoBean);
            }
        }
    }

    private void refreshYellData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1023853516")) {
            ipChange.ipc$dispatch("1023853516", new Object[]{this});
        }
    }

    @JSMethod(uiThread = false)
    public void addChatListMessage(String str, Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-334264034")) {
            ipChange.ipc$dispatch("-334264034", new Object[]{this, str, map});
            return;
        }
        AILPChatListComponent aILPChatListComponent = (AILPChatListComponent) WXSDKManager.v().G().getWXComponent(this.mWXSDKInstance.getInstanceId(), str);
        if (aILPChatListComponent != null) {
            aILPChatListComponent.insertMessage(map, false);
        }
    }

    @JSMethod
    public void close() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870923717")) {
            ipChange.ipc$dispatch("870923717", new Object[]{this});
            return;
        }
        DagoInputBoxDialog dagoInputBoxDialog = this.mInputBoxDialog;
        if (dagoInputBoxDialog != null) {
            dagoInputBoxDialog.close();
            this.mInputBoxDialog = null;
        }
        AILPChatInputWithKeyWordDialog aILPChatInputWithKeyWordDialog = this.keyWordDialog;
        if (aILPChatInputWithKeyWordDialog != null) {
            aILPChatInputWithKeyWordDialog.close();
            this.keyWordDialog = null;
        }
    }

    @JSMethod
    public void config(Map<String, Object> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-886337158")) {
            ipChange.ipc$dispatch("-886337158", new Object[]{this, map});
            return;
        }
        ChatResourceManager.getInstance().clearYellSource();
        if (map != null) {
            this.hasYell = Boolean.parseBoolean(String.valueOf(map.get(this.HASYELL)));
            this.showPanelGif = Boolean.parseBoolean(String.valueOf(map.get(this.SHOW_PANEL_GIF)));
            if (this.hasYell) {
                this.yellIconUrl = String.valueOf(map.get(this.YELLICON));
                String valueOf = String.valueOf(map.get(this.YELLSOURCE));
                if (TextUtils.isEmpty(valueOf)) {
                    return;
                }
                parseExpressSource(valueOf);
                refreshYellData();
            }
        }
    }

    @JSMethod
    public void open(Map<String, Object> map, final JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "276962502")) {
            ipChange.ipc$dispatch("276962502", new Object[]{this, map, jSCallback});
            return;
        }
        try {
            close();
            DagoInputBoxDialog dagoInputBoxDialog = new DagoInputBoxDialog(this.mWXSDKInstance.getContext(), map);
            this.mInputBoxDialog = dagoInputBoxDialog;
            dagoInputBoxDialog.setOnInputBoxListener(new OnInputBoxListener() { // from class: com.youku.live.dago.widgetlib.module.AILPChatInputModule.1
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.OnInputBoxListener
                public void onChangeExpressionPanel(boolean z) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-458209823")) {
                        ipChange2.ipc$dispatch("-458209823", new Object[]{this, Boolean.valueOf(z)});
                    } else if (z) {
                        try {
                            UIUtil.postDelayed(new Runnable() { // from class: com.youku.live.dago.widgetlib.module.AILPChatInputModule.1.1
                                private static transient /* synthetic */ IpChange $ipChange;

                                @Override // java.lang.Runnable
                                public void run() {
                                    IpChange ipChange3 = $ipChange;
                                    if (AndroidInstantRuntime.support(ipChange3, "-1212591176")) {
                                        ipChange3.ipc$dispatch("-1212591176", new Object[]{this});
                                        return;
                                    }
                                    IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(AILPChatInputModule.this);
                                    if (widgetEngineInstance != null) {
                                        int dip2px = (int) (((UIUtil.dip2px(BuildConfig.VERSION_CODE) * 750.0f) / UIUtil.getScreenWidth(AppContextUtils.getApp())) + UIUtil.dip2px(54));
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("height", Integer.valueOf(dip2px));
                                        widgetEngineInstance.asyncPutData("adrKeyboardHeight", hashMap);
                                        ((ILog) Dsl.getService(ILog.class)).i(AILPChatInputModule.TAG, "adrKeyboardHeight218: " + dip2px);
                                    }
                                }
                            }, 100L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.OnInputBoxListener
                public void onDismiss() {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-327197691")) {
                        ipChange2.ipc$dispatch("-327197691", new Object[]{this});
                    }
                }

                @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.OnInputBoxListener
                public void onSendMessage(String str) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1969236954")) {
                        ipChange2.ipc$dispatch("1969236954", new Object[]{this, str});
                        return;
                    }
                    AILPChatInputModule.this.mResult.clear();
                    AILPChatInputModule aILPChatInputModule = AILPChatInputModule.this;
                    aILPChatInputModule.mResult.put(aILPChatInputModule.RESULT, aILPChatInputModule.SEND);
                    AILPChatInputModule aILPChatInputModule2 = AILPChatInputModule.this;
                    aILPChatInputModule2.mResult.put(aILPChatInputModule2.TEXT, str);
                    if (AILPChatInputModule.this.mInputBoxDialog != null) {
                        AILPChatInputModule aILPChatInputModule3 = AILPChatInputModule.this;
                        aILPChatInputModule3.mResult.put("switchActive", Boolean.valueOf(aILPChatInputModule3.mInputBoxDialog.useBarrage()));
                    }
                    jSCallback.invoke(AILPChatInputModule.this.mResult);
                }
            });
            this.mInputBoxDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.youku.live.dago.widgetlib.module.AILPChatInputModule.2
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1538648132")) {
                        ipChange2.ipc$dispatch("1538648132", new Object[]{this, dialogInterface});
                        return;
                    }
                    if (AILPChatInputModule.this.mInputBoxDialog != null && !AILPChatInputModule.this.mInputBoxDialog.isWeexCallClose()) {
                        AILPChatInputModule.this.mResult.clear();
                        AILPChatInputModule aILPChatInputModule = AILPChatInputModule.this;
                        aILPChatInputModule.mResult.put(aILPChatInputModule.RESULT, aILPChatInputModule.CANCEL);
                        AILPChatInputModule aILPChatInputModule2 = AILPChatInputModule.this;
                        aILPChatInputModule2.mResult.put(aILPChatInputModule2.TEXT, TextUtils.isEmpty(aILPChatInputModule2.mInputBoxDialog.getInputText()) ? "" : AILPChatInputModule.this.mInputBoxDialog.getInputText().toString());
                        AILPChatInputModule aILPChatInputModule3 = AILPChatInputModule.this;
                        aILPChatInputModule3.mResult.put("switchActive", Boolean.valueOf(aILPChatInputModule3.mInputBoxDialog.useBarrage()));
                        jSCallback.invoke(AILPChatInputModule.this.mResult);
                    }
                    AILPChatInputModule.this.mInputBoxDialog = null;
                }
            });
            this.mInputBoxDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.youku.live.dago.widgetlib.module.AILPChatInputModule.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1481964797")) {
                        ipChange2.ipc$dispatch("-1481964797", new Object[]{this, dialogInterface});
                        return;
                    }
                    IEngineInstance widgetEngineInstance = WeexHelper.getWidgetEngineInstance(AILPChatInputModule.this);
                    if (widgetEngineInstance != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("height", 0);
                        widgetEngineInstance.asyncPutData("adrKeyboardHeight", hashMap);
                        ((ILog) Dsl.getService(ILog.class)).i(AILPChatInputModule.TAG, "adrKeyboardHeightDismiss: 0");
                    }
                }
            });
            this.mInputBoxDialog.show();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @JSMethod
    public void secretOpen(Map<String, Object> map, final JSCallback jSCallback) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1179637258")) {
            ipChange.ipc$dispatch("-1179637258", new Object[]{this, map, jSCallback});
            return;
        }
        try {
            close();
            KeywordChatInputDto keywordChatInputDto = (KeywordChatInputDto) JSON.parseObject(JSON.toJSONString(map), KeywordChatInputDto.class);
            int i2 = this.mWXSDKInstance.getContext().getResources().getConfiguration().orientation;
            if (i2 == 2) {
                i = R.style.dago_pgc_fullScreenSecretInputDialog;
            } else {
                i = R.style.dago_pgc_customSecretInputDialog;
            }
            int i3 = i;
            if (keywordChatInputDto == null) {
                return;
            }
            AILPChatInputWithKeyWordDialog aILPChatInputWithKeyWordDialog = new AILPChatInputWithKeyWordDialog(this.mWXSDKInstance.getContext(), i3, i2, keywordChatInputDto, new BaseInputDialog.OnInputCompleteListener() { // from class: com.youku.live.dago.widgetlib.module.AILPChatInputModule.4
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.BaseInputDialog.OnInputCompleteListener
                public void onInputComplete(CharSequence charSequence) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1319966413")) {
                        ipChange2.ipc$dispatch("1319966413", new Object[]{this, charSequence});
                        return;
                    }
                    AILPChatInputModule.this.mResult.clear();
                    AILPChatInputModule aILPChatInputModule = AILPChatInputModule.this;
                    aILPChatInputModule.mResult.put(aILPChatInputModule.RESULT, aILPChatInputModule.SEND);
                    AILPChatInputModule aILPChatInputModule2 = AILPChatInputModule.this;
                    aILPChatInputModule2.mResult.put(aILPChatInputModule2.TEXT, charSequence.toString());
                    jSCallback.invoke(AILPChatInputModule.this.mResult);
                }
            });
            this.keyWordDialog = aILPChatInputWithKeyWordDialog;
            aILPChatInputWithKeyWordDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.youku.live.dago.widgetlib.module.AILPChatInputModule.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "152423905")) {
                        ipChange2.ipc$dispatch("152423905", new Object[]{this, dialogInterface});
                        return;
                    }
                    if (AILPChatInputModule.this.keyWordDialog != null && !AILPChatInputModule.this.keyWordDialog.isWeexCallClose()) {
                        AILPChatInputModule.this.mResult.clear();
                        AILPChatInputModule aILPChatInputModule = AILPChatInputModule.this;
                        aILPChatInputModule.mResult.put(aILPChatInputModule.RESULT, aILPChatInputModule.CANCEL);
                        AILPChatInputModule aILPChatInputModule2 = AILPChatInputModule.this;
                        aILPChatInputModule2.mResult.put(aILPChatInputModule2.TEXT, TextUtils.isEmpty(aILPChatInputModule2.keyWordDialog.getInput()) ? "" : AILPChatInputModule.this.keyWordDialog.getInput().toString());
                        jSCallback.invoke(AILPChatInputModule.this.mResult);
                    }
                    AILPChatInputModule.this.keyWordDialog = null;
                }
            });
            this.keyWordDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
