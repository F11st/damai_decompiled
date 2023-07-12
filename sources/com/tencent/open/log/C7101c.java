package com.tencent.open.log;

import com.tencent.connect.common.Constants;
import java.io.File;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.log.c */
/* loaded from: classes11.dex */
public class C7101c {
    public static int a = 60;
    public static int b = 60;
    public static String c = "OpenSDK.Client.File.Tracer";
    public static String d;
    public static String e;
    public static long f;
    public static int g;
    public static int h;
    public static int i;
    public static String j;
    public static String k;
    public static String l;
    public static int m;
    public static long n;
    public static String o;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Tencent");
        String str = File.separator;
        sb.append(str);
        sb.append("msflogs");
        sb.append(str);
        sb.append("com");
        sb.append(str);
        sb.append("tencent");
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        d = sb.toString();
        e = ".log";
        f = 8388608L;
        g = 262144;
        h = 1024;
        i = 10000;
        j = "debug.file.blockcount";
        k = "debug.file.keepperiod";
        l = "debug.file.tracelevel";
        m = 24;
        n = 604800000L;
        o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
