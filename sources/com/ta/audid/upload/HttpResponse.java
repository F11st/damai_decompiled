package com.ta.audid.upload;

import android.text.TextUtils;
import com.ta.audid.utils.MD5Utils;
import com.ta.audid.utils.UtdidLogger;
import com.ta.utdid2.android.utils.Base64;
import com.tencent.open.SocialOperation;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class HttpResponse {
    public int httpResponseCode = -1;
    public long timestamp = 0;
    public String signature = "";
    public byte[] data = null;
    public long rt = 0;

    public static boolean checkSignature(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                UtdidLogger.sd("", "result", str, SocialOperation.GAME_SIGNATURE, str2);
                if (str2.equals(Base64.encodeToString(MD5Utils.getHmacMd5Hex(str).getBytes(), 2))) {
                    UtdidLogger.d("", "signature is ok");
                    return true;
                }
                UtdidLogger.d("", "signature is error");
            }
        } catch (Exception e) {
            UtdidLogger.d("", e);
        }
        return false;
    }
}
