package com.youku.android.liveservice.utils;

import android.content.Context;
import android.text.TextUtils;
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
/* loaded from: classes8.dex */
public class DrmManager {
    public static String R1 = "123456";
    public static final String TAG = "DrmManager";

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

    public static String encodeBase64(String str) {
        return !TextUtils.isEmpty(str) ? Base64.encodeToString(str.getBytes(), 2) : "";
    }

    public static String encryptAesByWsg(Context context, String str, String str2, String str3) {
        try {
            return SecurityGuardManager.getInstance(context).getStaticDataEncryptComp().staticSafeEncrypt(16, str2, str, str3);
        } catch (Exception e) {
            String str4 = TAG;
            Log.d(str4, "encryptRSAByWsg fail:" + e.getMessage());
            e.printStackTrace();
            return "";
        }
    }

    public static String generateEncryptRClient(Context context, String str, String str2) {
        generateR1();
        return encryptAesByWsg(context, R1, str, str2);
    }

    public static void generateR1() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        R1 = sb.toString();
    }

    public static String getR1() {
        return R1;
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
}
