package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.init.Launcher_InitPush;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ForeBackManager;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoConstants;
import com.taobao.agoo.TaobaoRegister;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.Config;
import org.android.agoo.control.NotifManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class e22 implements AccsDataListener {
    public static c4 b;
    public Map<String, ICallback> a = new HashMap();

    public e22(Context context) {
        if (b == null) {
            b = new c4(context.getApplicationContext());
        }
    }

    private void a(JSONObject jSONObject, ICallback iCallback) throws JSONException {
        String string = JsonUtility.getString(jSONObject, u4.JSON_PUSH_USER_TOKEN, null);
        if (TextUtils.isEmpty(string)) {
            if (iCallback != null) {
                iCallback.onFailure("", "agoo server error-pushtoken null");
                return;
            }
            return;
        }
        Config.setPushAliasToken(GlobalClientInfo.getContext(), string);
        if (iCallback != null) {
            iCallback.onSuccess();
            b.c(iCallback.extra);
        }
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onAntiBrush(boolean z, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onBind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onConnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onDisconnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onResponse(String str, String str2, int i, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        boolean equals;
        try {
            if (NotifManager.getServiceId(GlobalClientInfo.getContext(), TaobaoConstants.SERVICE_ID_DEVICECMD).equals(str)) {
                ICallback iCallback = this.a.get(str2);
                if (i == 200) {
                    String str3 = new String(bArr, "utf-8");
                    ALog.i("RequestListener", "RequestListener onResponse", Constants.KEY_DATA_ID, str2, "listener", iCallback, Preloader.KEY_JSON, str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    String string = JsonUtility.getString(jSONObject, "resultCode", null);
                    String string2 = JsonUtility.getString(jSONObject, "cmd", null);
                    if (!"success".equals(string)) {
                        if (iCallback != null) {
                            iCallback.onFailure(String.valueOf(string), "agoo server error");
                        }
                        if (equals) {
                            return;
                        }
                        return;
                    } else if ("register".equals(string2)) {
                        String string3 = JsonUtility.getString(jSONObject, "deviceId", null);
                        if (!TextUtils.isEmpty(string3)) {
                            TaobaoRegister.setIsRegisterSuccess(true);
                            ForeBackManager.getManager().reportSaveClickMessage();
                            Config.setDeviceToken(GlobalClientInfo.getContext(), string3);
                            b.e(GlobalClientInfo.getContext().getPackageName());
                            if (iCallback instanceof IRegister) {
                                UtilityImpl.saveUtdid(Config.PREFERENCES, GlobalClientInfo.getContext());
                                ((IRegister) iCallback).onSuccess(string3);
                            }
                        } else if (iCallback != null) {
                            iCallback.onFailure("", "agoo server error deviceid null");
                        }
                        if (NotifManager.getServiceId(GlobalClientInfo.getContext(), TaobaoConstants.SERVICE_ID_DEVICECMD).equals(str)) {
                            this.a.remove(str2);
                            return;
                        }
                        return;
                    } else if (u4.JSON_CMD_SETALIAS.equals(string2)) {
                        a(jSONObject, iCallback);
                        if (NotifManager.getServiceId(GlobalClientInfo.getContext(), TaobaoConstants.SERVICE_ID_DEVICECMD).equals(str)) {
                            this.a.remove(str2);
                            return;
                        }
                        return;
                    } else if (u4.JSON_CMD_REMOVEALIAS.equals(string2)) {
                        Config.setPushAliasToken(GlobalClientInfo.getContext(), null);
                        if (iCallback != null) {
                            iCallback.onSuccess();
                        }
                        b.d();
                        if (NotifManager.getServiceId(GlobalClientInfo.getContext(), TaobaoConstants.SERVICE_ID_DEVICECMD).equals(str)) {
                            this.a.remove(str2);
                            return;
                        }
                        return;
                    } else if ((hj2.JSON_CMD_ENABLEPUSH.equals(string2) || hj2.JSON_CMD_DISABLEPUSH.equals(string2)) && iCallback != null) {
                        iCallback.onSuccess();
                    }
                } else if (iCallback != null) {
                    iCallback.onFailure(String.valueOf(i), "accs channel error");
                }
            }
            if (!NotifManager.getServiceId(GlobalClientInfo.getContext(), TaobaoConstants.SERVICE_ID_DEVICECMD).equals(str)) {
                return;
            }
        } catch (Throwable th) {
            try {
                ALog.e("RequestListener", "onResponse", th, new Object[0]);
                if (!NotifManager.getServiceId(GlobalClientInfo.getContext(), TaobaoConstants.SERVICE_ID_DEVICECMD).equals(str)) {
                    return;
                }
            } finally {
                if (NotifManager.getServiceId(GlobalClientInfo.getContext(), TaobaoConstants.SERVICE_ID_DEVICECMD).equals(str)) {
                    this.a.remove(str2);
                }
            }
        }
        this.a.remove(str2);
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onSendData(String str, String str2, int i, TaoBaseService.ExtraInfo extraInfo) {
        String str3 = NotifManager.tokenReportDataId;
        if (TextUtils.isEmpty(str3) || !str3.equals(str2)) {
            return;
        }
        Launcher_InitPush.manuMonitor.result = i == 200;
        Launcher_InitPush.monitorNow(GlobalClientInfo.getContext());
    }

    @Override // com.taobao.accs.base.AccsDataListener
    public void onUnbind(String str, int i, TaoBaseService.ExtraInfo extraInfo) {
    }
}
