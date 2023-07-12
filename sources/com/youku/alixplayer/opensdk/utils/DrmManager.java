package com.youku.alixplayer.opensdk.utils;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.youku.upsplayer.util.YKUpsConvert;
import java.security.MessageDigest;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DrmManager {
    public static final String TAG = "DrmManager";
    public static String latestKeyIndex = "";

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class Result {
        public String R1;
        public String encryptR;
        public String keyIndex;
    }

    public static String decryptAes(String str, String str2) {
        byte[] bArr;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            bArr = cipher.doFinal(Base64.decode(replaceBlank(str), 0));
        } catch (Exception unused) {
            bArr = null;
        }
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        return new String(bArr).trim();
    }

    private static String encryptAesByWsg(Context context, String str, String str2, String str3) {
        try {
            return SecurityGuardManager.getInstance(context).getStaticDataEncryptComp().staticSafeEncrypt(16, str2, str, str3);
        } catch (Exception e) {
            Log.d("DrmManager", "encryptRSAByWsg fail:" + e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

    public static String generateEncryptRClient(Context context, String str, String str2, String str3) {
        return encryptAesByWsg(context, str, str2, str3);
    }

    public static String generateR1() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String md5(String str) {
        char[] cArr = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr2[i] = cArr[(b >>> 4) & 15];
                i = i2 + 1;
                cArr2[i2] = cArr[b & 15];
            }
            return new String(cArr2).substring(8, 24);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String replaceBlank(String str) {
        return str != null ? Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("") : "";
    }

    public static Result generateEncryptRClient(Context context, String str, String str2) {
        String generateR1 = generateR1();
        String encryptAesByWsg = encryptAesByWsg(context, generateR1, str, str2);
        Result result = new Result();
        result.encryptR = encryptAesByWsg;
        result.R1 = generateR1;
        result.keyIndex = str;
        return result;
    }
}
