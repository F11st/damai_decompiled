package com.ta.utdid2.device;

import com.ta.audid.Variables;
import com.ta.audid.upload.UtdidKeyFile;
import com.ta.audid.utils.FileUtils;
import com.ta.audid.utils.UtdidLogger;
import com.taobao.weex.common.Constants;
import java.lang.reflect.Method;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class EcdidUtils {
    EcdidUtils() {
    }

    private static Object invokeStaticMethod(Class cls, String str, Object[] objArr, Class... clsArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Object invokeStaticMethodByClassName(String str, String str2, Object[] objArr, Class... clsArr) {
        try {
            return invokeStaticMethod(Class.forName(str), str2, objArr, clsArr);
        } catch (ClassNotFoundException e) {
            UtdidLogger.se("", e, new Object[0]);
            return null;
        }
    }

    private static Object play(int i, int i2, int i3, Object obj) {
        Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), obj};
        Class cls = Integer.TYPE;
        return invokeStaticMethodByClassName("com.alibaba.one.android.sdk.OneMain", Constants.Value.PLAY, objArr, cls, cls, cls, Object.class);
    }

    private static String readEcdidUtdidFile() {
        String ecdidUtdidPath = UtdidKeyFile.getEcdidUtdidPath();
        UtdidLogger.sd("", "readEcdidUtdidFile path", ecdidUtdidPath);
        String readFile = FileUtils.readFile(ecdidUtdidPath);
        UtdidLogger.d("", "readEcdidUtdidFile", readFile);
        return readFile;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readUtdidFromEcdid() {
        String readEcdidUtdidFile = readEcdidUtdidFile();
        if (UTUtdid.isValidUtdid(readEcdidUtdidFile)) {
            return readEcdidUtdidFile;
        }
        sendMessage1();
        return readEcdidUtdidFile();
    }

    private static String sendMessage(int i) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Throwable th) {
            UtdidLogger.se("", th, new Object[0]);
        }
        if (i == 0) {
            str = (String) play(0, 2, 72634, Variables.getInstance().getContext());
        } else if (i != 1) {
            if (i == 2) {
                str = (String) play(0, 2, 4636617, null);
            }
            str = "";
            UtdidLogger.d("", "sendMessage", Integer.valueOf(i), "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return str;
        } else {
            str = (String) play(0, 2, 61501799, 130502);
        }
        UtdidLogger.d("", "sendMessage", Integer.valueOf(i), "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return str;
    }

    static void sendMessage1() {
        sendMessage(0);
        sendMessage(1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sendMessage2() {
        sendMessage(0);
        sendMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeEcdidUtdidFile(String str) {
        String ecdidUtdidPath = UtdidKeyFile.getEcdidUtdidPath();
        UtdidLogger.d("", "writeEcdidUtdidFile", str);
        UtdidLogger.sd("", "writeEcdidUtdidFile path", ecdidUtdidPath);
        FileUtils.saveFile(ecdidUtdidPath, str);
        sendMessage2();
    }
}
