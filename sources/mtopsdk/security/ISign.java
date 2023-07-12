package mtopsdk.security;

import androidx.annotation.NonNull;
import java.util.HashMap;
import mtopsdk.mtop.global.MtopConfig;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface ISign {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SignCtx {
        public String authCode;
        public int index;

        public SignCtx(int i, String str) {
            this.index = i;
            this.authCode = str;
        }
    }

    String getAppKey(SignCtx signCtx);

    String getAvmpSign(String str, String str2, int i);

    String getCommonHmacSha1Sign(String str, String str2);

    String getMiniWua(HashMap<String, String> hashMap, HashMap<String, String> hashMap2);

    String getMtopApiSign(HashMap<String, String> hashMap, String str, String str2);

    String getSecBodyDataEx(String str, String str2, String str3, HashMap<String, String> hashMap, int i);

    String getSign(HashMap<String, String> hashMap, String str);

    HashMap<String, String> getUnifiedSign(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str, String str2, boolean z);

    String getWua(HashMap<String, String> hashMap, String str);

    void init(@NonNull MtopConfig mtopConfig);
}
