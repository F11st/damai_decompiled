package com.youku.alixplayer.opensdk.utils;

import android.content.Context;
import com.ut.device.UTDevice;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class SessionUnitil {
    public static Map<String, String> http_session = new HashMap();
    private static boolean isSessionCreated;
    public static String playEvent_session;

    public static int creatRandom() {
        return (int) (Math.random() * 10.0d);
    }

    public static String creatSession(Context context) {
        isSessionCreated = true;
        return md5(getTime() + creatRandom() + UTDevice.getUtdid(context));
    }

    public static String getPlayVVBeginSession(Context context) {
        if (!isSessionCreated) {
            playEvent_session = creatSession(context);
        }
        isSessionCreated = false;
        return playEvent_session;
    }

    public static String getTextEncoder(String str) {
        if (str == null || "".equals(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static String getTime() {
        String substring = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()).replace("-", "").replace("-", "").replace(":", "").replace(":", "").replace(" ", "").substring(2);
        return substring + "000";
    }

    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            Logger.e("Util.md5()", e);
            return "";
        }
    }
}
