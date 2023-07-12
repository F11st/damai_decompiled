package tb;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.Random;

/* compiled from: Taobao */
@TargetApi(9)
/* loaded from: classes11.dex */
public class a63 {
    private static String a = "";

    private static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis();
        String l = Long.toString(currentTimeMillis);
        stringBuffer.append(l.substring(l.length() - 5));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(Build.getMODEL().replaceAll(" ", ""));
        while (stringBuffer2.length() < 6) {
            stringBuffer2.append(YKUpsConvert.CHAR_ZERO);
        }
        stringBuffer.append(stringBuffer2.substring(0, 6));
        Random random = new Random(currentTimeMillis);
        long j = 0;
        while (j < 4096) {
            j = random.nextLong();
        }
        stringBuffer.append(Long.toHexString(j).substring(0, 4));
        return stringBuffer.toString();
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(a) || "unknow".equals(a)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("imei", 0);
            String string = sharedPreferences.getString("imei", null);
            if (string == null || string.length() == 0) {
                try {
                    String deviceId = TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone"));
                    if (deviceId == null || deviceId.length() == 0) {
                        deviceId = a();
                    }
                    string = deviceId.replaceAll(" ", "").trim();
                    while (string.length() < 15) {
                        string = "0" + string;
                    }
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("imei", string);
                    if (Build.VERSION.SDK_INT >= 9) {
                        edit.apply();
                    } else {
                        edit.commit();
                    }
                } catch (Throwable th) {
                    Log.d(uj2.TAG, th.toString());
                }
            }
            String trim = (string != null ? string : "unknow").trim();
            a = trim;
            return trim;
        }
        return a;
    }
}
