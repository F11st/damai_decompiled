package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.RomInfoCollecter;
import com.taobao.accs.utl.UtilityImpl;
import java.io.UnsupportedEncodingException;
import org.android.agoo.common.Config;
import org.json.JSONException;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MessageV2 extends Message {
    private static final String KEY_AAID = "aaid";
    private static final String KEY_COMMONID = "commonDeviceId";
    private static final String KEY_FLOATENABLE = "floatingEnable";
    private static final String KEY_NOTIFYENABLE = "notifyEnable";
    private static final String KEY_REGID = "regId";
    private static final String KEY_ROMINFO = "romInfo";
    private static final String KEY_TOKEN = "deviceToken";
    private static final String KEY_UMID = "umidToken";
    private static final String KEY_UTDID = "utdid";
    private static final String KEY_VERSION = "version";
    private static final String TAG = "BindAppMessageV2";
    String aaid;
    String commonDeviceId;
    String deviceToken;
    String floatingEnable;
    String notifyEnable;
    String regId;
    String romInfo;
    String umidToken;
    String version = "2";

    public static MessageV2 buildBindApp(String str, String str2, Context context, Intent intent) {
        Message buildBindApp = Message.buildBindApp(str, str2, context, intent);
        if (buildBindApp instanceof MessageV2) {
            MessageV2 messageV2 = (MessageV2) buildBindApp;
            messageV2.deviceToken = Config.getDeviceToken(context);
            String str3 = "true".equals(AdapterUtilityImpl.isNotificationEnabled(context)) ? "1" : "0";
            messageV2.notifyEnable = str3;
            UtilityImpl.saveNotificationState(context, Constants.SP_CHANNEL_FILE_NAME, str3);
            messageV2.romInfo = RomInfoCollecter.getCollecter().collect();
            messageV2.umidToken = getUmidToken(context);
            messageV2.regId = OrangeAdapter.getRegId(context);
            messageV2.floatingEnable = "true".equals(String.valueOf(AdapterUtilityImpl.checkFloatPermission(context))) ? "1" : "0";
            return messageV2;
        }
        return null;
    }

    private static String getUmidToken(Context context) {
        int i = AccsClientConfig.mEnv;
        int i2 = 2;
        if (i == 1) {
            i2 = 1;
        } else if (i != 2) {
            i2 = 0;
        }
        try {
            return SecurityGuardManager.getInstance(context).getUMIDComp().getSecurityToken(i2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.taobao.accs.data.Message
    void buildData() throws JSONException, UnsupportedEncodingException {
        Integer num = this.command;
        if (num == null || num.intValue() == 100 || this.command.intValue() == 102) {
            return;
        }
        Context context = GlobalClientInfo.getContext();
        String regId = OrangeAdapter.getRegId(context);
        if (TextUtils.isEmpty(regId)) {
            this.regId = null;
            this.version = "1";
            ALog.e(TAG, "regid null, degrade to V1", new Object[0]);
        } else {
            ALog.i(TAG, "set again", "regId", this.regId, "id", regId);
            this.regId = regId;
        }
        switch (this.command.intValue()) {
            case 1:
                this.data = buidJsonObject().put("version", this.version).put("deviceToken", this.deviceToken).put(KEY_NOTIFYENABLE, this.notifyEnable).put(KEY_ROMINFO, this.romInfo).put(KEY_FLOATENABLE, this.floatingEnable).put("umidToken", this.umidToken).put("aaid", this.aaid).put(KEY_COMMONID, this.commonDeviceId).put("regId", this.regId).put("utdid", UtilityImpl.getDeviceId(context)).build().toString().getBytes("utf-8");
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                this.data = buidJsonObject().put("regId", this.regId).put("utdid", UtilityImpl.getDeviceId(context)).build().toString().getBytes("utf-8");
                return;
            default:
                return;
        }
    }
}
