package tb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.c$a;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class e43 extends b53 {
    @Override // com.heytap.mcssdk.d.d
    public BaseMode a(Context context, int i, Intent intent) {
        if (4103 == i || 4098 == i || 4108 == i) {
            BaseMode b = b(intent, i);
            a33.a(context, c$a.b, (DataMessage) b);
            return b;
        }
        return null;
    }

    public BaseMode b(Intent intent, int i) {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(f43.f(intent.getStringExtra("messageID")));
            dataMessage.setTaskID(f43.f(intent.getStringExtra(TLogEventConst.PARAM_TASK_ID)));
            dataMessage.setGlobalId(f43.f(intent.getStringExtra("globalID")));
            dataMessage.setAppPackage(f43.f(intent.getStringExtra("appPackage")));
            dataMessage.setTitle(f43.f(intent.getStringExtra("title")));
            dataMessage.setContent(f43.f(intent.getStringExtra("content")));
            dataMessage.setDescription(f43.f(intent.getStringExtra(SocialConstants.PARAM_COMMENT)));
            String f = f43.f(intent.getStringExtra("notifyID"));
            int i2 = 0;
            dataMessage.setNotifyID(TextUtils.isEmpty(f) ? 0 : Integer.parseInt(f));
            dataMessage.setMiniProgramPkg(f43.f(intent.getStringExtra("miniProgramPkg")));
            dataMessage.setMessageType(i);
            dataMessage.setEventId(f43.f(intent.getStringExtra("eventId")));
            dataMessage.setStatisticsExtra(f43.f(intent.getStringExtra("statistics_extra")));
            String f2 = f43.f(intent.getStringExtra("data_extra"));
            dataMessage.setDataExtra(f2);
            String c = c(f2);
            if (!TextUtils.isEmpty(c)) {
                i2 = Integer.parseInt(c);
            }
            dataMessage.setMsgCommand(i2);
            dataMessage.setBalanceTime(f43.f(intent.getStringExtra("balanceTime")));
            dataMessage.setStartDate(f43.f(intent.getStringExtra("startDate")));
            dataMessage.setEndDate(f43.f(intent.getStringExtra("endDate")));
            dataMessage.setTimeRanges(f43.f(intent.getStringExtra("timeRanges")));
            dataMessage.setRule(f43.f(intent.getStringExtra("rule")));
            dataMessage.setForcedDelivery(f43.f(intent.getStringExtra("forcedDelivery")));
            dataMessage.setDistinctContent(f43.f(intent.getStringExtra("distinctBycontent")));
            dataMessage.setAppId(f43.f(intent.getStringExtra("appID")));
            return dataMessage;
        } catch (Exception e) {
            z53.a("OnHandleIntent--" + e.getMessage());
            return null;
        }
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("msg_command");
        } catch (JSONException e) {
            z53.a(e.getMessage());
            return "";
        }
    }
}
