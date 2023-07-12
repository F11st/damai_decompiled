package com.alipay.sdk.m.u;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.m.h.C4197a;
import com.alipay.sdk.m.h.C4200d;
import com.alipay.sdk.m.h.C4202f;
import com.alipay.sdk.m.j.C4211a;
import com.alipay.sdk.m.j.C4212b;
import com.alipay.sdk.m.j.EnumC4213c;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.l.C4230a;
import com.alipay.sdk.m.l.C4231b;
import com.alipay.sdk.m.m.C4245a;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.s.C4295b;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mtopsdk.common.util.SymbolExpUtil;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import tb.C9796v;
import tb.gn1;
import tb.jg1;
import tb.jn1;
import tb.qb1;
import tb.r10;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.u.n */
/* loaded from: classes10.dex */
public class C4318n {
    public static final String a = "com.alipay.android.app";
    public static final String b = "com.eg.android.AlipayGphone";
    public static final String c = "com.eg.android.AlipayGphoneRC";
    public static final int d = 99;
    public static final int f = 125;
    public static final int g = 460;
    public static final String[] e = {"10.1.5.1013151", "10.1.5.1013148"};
    public static final char[] h = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F, 'G', 'H', qb1.LEVEL_I, 'J', 'K', qb1.LEVEL_L, 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', qb1.LEVEL_V, qb1.LEVEL_W, 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', r10.DIR};

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.u.n$a */
    /* loaded from: classes10.dex */
    public static class RunnableC4319a implements Runnable {
        public final /* synthetic */ Activity a;

        public RunnableC4319a(Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.finish();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.u.n$b */
    /* loaded from: classes10.dex */
    public static class RunnableC4320b implements Runnable {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ ConditionVariable b;

        public RunnableC4320b(Runnable runnable, ConditionVariable conditionVariable) {
            this.a = runnable;
            this.b = conditionVariable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } finally {
                this.b.open();
            }
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            int indexOf = str3.indexOf(str) + str.length();
            if (indexOf <= str.length()) {
                return "";
            }
            int indexOf2 = TextUtils.isEmpty(str2) ? 0 : str3.indexOf(str2, indexOf);
            if (indexOf2 < 1) {
                return str3.substring(indexOf);
            }
            return str3.substring(indexOf, indexOf2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b() {
        if (EnvUtils.isSandBox()) {
            return c;
        }
        try {
            return C4211a.d.get(0).a;
        } catch (Throwable unused) {
            return "com.eg.android.AlipayGphone";
        }
    }

    public static String b(Context context) {
        return "-1;-1";
    }

    public static String c(String str) {
        return (EnvUtils.isSandBox() && TextUtils.equals(str, c)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    public static int d(String str) {
        for (int i = 0; i < 64; i++) {
            if (str.equals(String.valueOf(h[i]))) {
                return i;
            }
        }
        return 0;
    }

    public static String e(C4293a c4293a, String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            C4218a.a(c4293a, C4226b.l, C4226b.B, e2);
            return "";
        }
    }

    public static String f() {
        return "Android " + Build.VERSION.getRELEASE();
    }

    public static String g(Context context) {
        String f2 = f();
        String e2 = e();
        String c2 = c(context);
        String f3 = f(context);
        return " (" + f2 + ";" + e2 + ";" + c2 + ";;" + f3 + jn1.BRACKET_END_STR + "(sdk android)";
    }

    public static JSONObject h(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static String i(String str) {
        try {
            Uri parse = Uri.parse(str);
            return String.format("%s%s", parse.getAuthority(), parse.getPath());
        } catch (Throwable th) {
            C4302e.a(th);
            return "-";
        }
    }

    public static String c(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String f(Context context) {
        DisplayMetrics d2 = d(context);
        return com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(d2) + jn1.MUL + com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(d2);
    }

    public static Map<String, String> b(String str) {
        String[] split;
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=", 1);
            if (-1 != indexOf) {
                hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
            }
        }
        return hashMap;
    }

    public static String d() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
            if (matcher.matches() && matcher.groupCount() >= 4) {
                return matcher.group(1) + StringUtils.LF + matcher.group(2) + " " + matcher.group(3) + StringUtils.LF + matcher.group(4);
            }
            return "Unavailable";
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static String e() {
        String d2 = d();
        int indexOf = d2.indexOf("-");
        if (indexOf != -1) {
            d2 = d2.substring(0, indexOf);
        }
        int indexOf2 = d2.indexOf(StringUtils.LF);
        if (indexOf2 != -1) {
            d2 = d2.substring(0, indexOf2);
        }
        return "Linux " + d2;
    }

    public static boolean h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean h() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.u.n$c */
    /* loaded from: classes10.dex */
    public static final class C4321c {
        public final PackageInfo a;
        public final int b;
        public final String c;

        public C4321c(PackageInfo packageInfo, int i, String str) {
            this.a = packageInfo;
            this.b = i;
            this.c = str;
        }

        public boolean a(C4293a c4293a) {
            Signature[] signatureArr = this.a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String a = C4318n.a(c4293a, signature.toByteArray());
                if (a != null && !TextUtils.equals(a, this.c)) {
                    C4218a.b(c4293a, C4226b.l, C4226b.D, String.format("Got %s, expected %s", a, this.c));
                    return true;
                }
            }
            return false;
        }

        public boolean a() {
            return this.a.versionCode < this.b;
        }
    }

    public static String c(C4293a c4293a, String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(null, str);
        } catch (Exception e2) {
            C4218a.b(c4293a, C4226b.l, "rflex", e2.getClass().getSimpleName());
            return null;
        }
    }

    public static boolean i() {
        try {
            String[] split = C4245a.D().g().split(SymbolExpUtil.SYMBOL_VERTICALBAR);
            String model = Build.getMODEL();
            if (TextUtils.isEmpty(model)) {
                return false;
            }
            for (String str : split) {
                if (TextUtils.equals(model, str) || TextUtils.equals(str, "all")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            C4302e.a(th);
            return false;
        }
    }

    public static String a(C4293a c4293a, byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e2) {
            C4218a.a(c4293a, "auth", C4226b.x, e2);
            return null;
        }
    }

    public static boolean f(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static String e(Context context) {
        String b2 = C4317m.b(context);
        return b2.substring(0, b2.indexOf(jg1.SCHEME_SLASH));
    }

    public static String g(String str) {
        return a(str, true);
    }

    public static Map<String, String> b(C4293a c4293a, String str) {
        String[] split;
        HashMap hashMap = new HashMap(4);
        int indexOf = str.indexOf(63);
        if (indexOf != -1 && indexOf < str.length() - 1) {
            for (String str2 : str.substring(indexOf + 1).split("&")) {
                int indexOf2 = str2.indexOf(61, 1);
                if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                    hashMap.put(str2.substring(0, indexOf2), e(c4293a, str2.substring(indexOf2 + 1)));
                }
            }
        }
        return hashMap;
    }

    public static int c() {
        try {
            String lowerCase = Build.getBRAND().toLowerCase();
            String lowerCase2 = Build.getMANUFACTURER().toLowerCase();
            if (a("huawei", lowerCase, lowerCase2)) {
                return 1;
            }
            if (a("oppo", lowerCase, lowerCase2)) {
                return 2;
            }
            if (a("vivo", lowerCase, lowerCase2)) {
                return 4;
            }
            if (a("lenovo", lowerCase, lowerCase2)) {
                return 8;
            }
            if (a("xiaomi", lowerCase, lowerCase2)) {
                return 16;
            }
            return a("oneplus", lowerCase, lowerCase2) ? 32 : 0;
        } catch (Exception unused) {
            return 61440;
        }
    }

    public static int g() {
        try {
            return Process.myUid();
        } catch (Throwable th) {
            C4302e.a(th);
            return -200;
        }
    }

    public static int e(String str) {
        try {
            String j = C4245a.D().j();
            if (TextUtils.isEmpty(j)) {
                return 0;
            }
            return (b(j, "").contains(str) ? 2 : 0) | 1;
        } catch (Throwable unused) {
            return 61440;
        }
    }

    public static DisplayMetrics d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getApplicationContext().getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return displayMetrics;
    }

    public static C4321c a(C4293a c4293a, Context context, List<C4245a.C4247b> list) {
        C4321c a2;
        if (list == null) {
            return null;
        }
        for (C4245a.C4247b c4247b : list) {
            if (c4247b != null && (a2 = a(c4293a, context, c4247b.a, c4247b.b, c4247b.c)) != null && !a2.a(c4293a) && !a2.a()) {
                return a2;
            }
        }
        return null;
    }

    public static boolean d(C4293a c4293a, String str) {
        try {
            int e2 = e(str);
            C4218a.a(c4293a, C4226b.l, "bindExt", "" + e2);
            return C4245a.D().o() && (e2 & 2) == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static C4321c a(C4293a c4293a, Context context, String str, int i, String str2) {
        PackageInfo packageInfo;
        if (EnvUtils.isSandBox() && "com.eg.android.AlipayGphone".equals(str)) {
            str = c;
        }
        try {
            packageInfo = a(context, str);
        } catch (Throwable th) {
            C4218a.b(c4293a, "auth", C4226b.v, th.getMessage());
            packageInfo = null;
        }
        if (a(c4293a, packageInfo)) {
            return a(packageInfo, i, str2);
        }
        return null;
    }

    public static String b(C4293a c4293a, Context context) {
        return a(c4293a, context, context.getPackageName());
    }

    public static int b(int i) {
        return i / 100000;
    }

    public static boolean a(C4293a c4293a, PackageInfo packageInfo) {
        String str = "";
        boolean z = false;
        if (packageInfo == null) {
            str = "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = "info.signatures.length <= 0";
            } else {
                z = true;
            }
        }
        if (!z) {
            C4218a.b(c4293a, "auth", C4226b.w, str);
        }
        return z;
    }

    public static String b(String str, String str2) {
        String string = Settings.Secure.getString(((Application) C4295b.d().b()).getContentResolver(), str);
        return string != null ? string : str2;
    }

    public static boolean b(C4293a c4293a) {
        if (c4293a == null || TextUtils.isEmpty(c4293a.g)) {
            return false;
        }
        return c4293a.g.toLowerCase().contains("auth");
    }

    public static PackageInfo a(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static C4321c a(PackageInfo packageInfo, int i, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new C4321c(packageInfo, i, str);
    }

    public static long a(String str) {
        return a(str, 6);
    }

    public static long a(String str, int i) {
        int i2;
        int pow = (int) Math.pow(2.0d, i);
        int length = str.length();
        long j = 0;
        int i3 = length;
        for (int i4 = 0; i4 < length; i4++) {
            j += Integer.parseInt(String.valueOf(d(str.substring(i4, i2)))) * ((long) Math.pow(pow, i3 - 1));
            i3--;
        }
        return j;
    }

    public static int a() {
        String c2 = C4295b.d().c();
        if (TextUtils.isEmpty(c2)) {
            return -1;
        }
        String replaceAll = c2.replaceAll("=", "");
        if (replaceAll.length() >= 5) {
            replaceAll = replaceAll.substring(0, 5);
        }
        int a2 = (int) (a(replaceAll) % 10000);
        return a2 < 0 ? a2 * (-1) : a2;
    }

    public static boolean a(C4293a c4293a, Context context, List<C4245a.C4247b> list, boolean z) {
        try {
            for (C4245a.C4247b c4247b : list) {
                if (c4247b != null) {
                    String str = c4247b.a;
                    if (EnvUtils.isSandBox() && "com.eg.android.AlipayGphone".equals(str)) {
                        str = c;
                    }
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                        if (packageInfo != null) {
                            if (z) {
                                C4218a.a(c4293a, C4226b.l, C4226b.X, packageInfo.packageName + "|" + packageInfo.versionName);
                                return true;
                            }
                            return true;
                        }
                        continue;
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, C4226b.h0, th);
            return false;
        }
    }

    public static boolean a(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            String[] strArr = e;
            if (!TextUtils.equals(str, strArr[0])) {
                if (!TextUtils.equals(str, strArr[1])) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(int i) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (nextInt == 1) {
                sb.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (nextInt == 2) {
                sb.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb.toString();
    }

    public static boolean a(C4293a c4293a, String str, Activity activity) {
        int parseInt;
        String substring;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (!str.toLowerCase().startsWith(C4230a.m.toLowerCase()) && !str.toLowerCase().startsWith(C4230a.n.toLowerCase())) {
            if (!TextUtils.equals(str, C4230a.p) && !TextUtils.equals(str, a("http", C4230a.r))) {
                if (str.startsWith(C4230a.o)) {
                    try {
                        String substring2 = str.substring(str.indexOf(C4230a.o) + 24);
                        parseInt = Integer.parseInt(substring2.substring(substring2.lastIndexOf(C4230a.s) + 10));
                    } catch (Exception unused) {
                        C4212b.a(C4212b.e());
                    }
                    if (parseInt != EnumC4213c.SUCCEEDED.b() && parseInt != EnumC4213c.PAY_WAITTING.b()) {
                        EnumC4213c b2 = EnumC4213c.b(EnumC4213c.FAILED.b());
                        C4212b.a(C4212b.a(b2.b(), b2.a(), ""));
                        activity.runOnUiThread(new RunnableC4319a(activity));
                        return true;
                    }
                    if (C4230a.w) {
                        StringBuilder sb = new StringBuilder();
                        String decode = URLDecoder.decode(str);
                        String decode2 = URLDecoder.decode(decode);
                        String str2 = decode2.substring(decode2.indexOf(C4230a.o) + 24, decode2.lastIndexOf(C4230a.s)).split(C4230a.u)[0];
                        int indexOf = decode.indexOf(C4230a.u) + 12;
                        sb.append(str2);
                        sb.append(C4230a.u);
                        sb.append(decode.substring(indexOf, decode.indexOf("&", indexOf)));
                        sb.append(decode.substring(decode.indexOf("&", indexOf)));
                        substring = sb.toString();
                    } else {
                        String decode3 = URLDecoder.decode(str);
                        substring = decode3.substring(decode3.indexOf(C4230a.o) + 24, decode3.lastIndexOf(C4230a.s));
                    }
                    EnumC4213c b3 = EnumC4213c.b(parseInt);
                    C4212b.a(C4212b.a(b3.b(), b3.a(), substring));
                    activity.runOnUiThread(new RunnableC4319a(activity));
                    return true;
                }
                return false;
            }
            C4212b.a(C4212b.a());
            activity.finish();
            return true;
        }
        try {
            C4321c a2 = a(c4293a, activity, C4211a.d);
            if (a2 != null && !a2.a() && !a2.a(c4293a)) {
                if (str.startsWith("intent://platformapi/startapp")) {
                    str = str.replaceFirst("intent://platformapi/startapp\\?", C4230a.m);
                }
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        } catch (Throwable unused2) {
        }
        return true;
    }

    public static String a(C4293a c4293a, Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, C4226b.v, th);
            return "";
        }
    }

    public static String a(String str, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            if (z && digest.length > 16) {
                byte[] bArr = new byte[16];
                System.arraycopy(digest, 0, bArr, 0, 16);
                return a(bArr);
            }
            return a(digest);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(Character.forDigit((b2 & 240) >> 4, 16));
            sb.append(Character.forDigit(b2 & 15, 16));
        }
        return sb.toString();
    }

    public static ActivityInfo a(Context context) {
        ActivityInfo[] activityInfoArr;
        try {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                    if (TextUtils.equals(activityInfo.name, activity.getClass().getName())) {
                        return activityInfo;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            C4302e.a(th);
            return null;
        }
    }

    public static String a(C4293a c4293a) {
        return c(c4293a, "ro.build.fingerprint");
    }

    public static <T> T a(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static boolean a(C4293a c4293a, String str) {
        try {
            String host = new URL(str).getHost();
            if (host.endsWith(C4230a.A)) {
                return true;
            }
            return host.endsWith(C4230a.B);
        } catch (Throwable th) {
            C4218a.a(c4293a, C4226b.l, "ckUrlErr", th);
            return false;
        }
    }

    public static JSONObject a(Intent intent) {
        Bundle extras;
        JSONObject jSONObject = new JSONObject();
        if (intent != null && (extras = intent.getExtras()) != null) {
            for (String str : extras.keySet()) {
                try {
                    jSONObject.put(str, String.valueOf(extras.get(str)));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, jSONObject.optString(next));
            } catch (Throwable th) {
                C4302e.a(th);
            }
        }
        return hashMap;
    }

    public static boolean a(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return obj == null;
        }
        for (Object obj2 : objArr) {
            if ((obj == null && obj2 == null) || (obj != null && obj.equals(obj2))) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(long j, Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        ConditionVariable conditionVariable = new ConditionVariable();
        Thread thread = new Thread(new RunnableC4320b(runnable, conditionVariable));
        if (!TextUtils.isEmpty(str)) {
            thread.setName(str);
        }
        thread.start();
        boolean z = true;
        try {
            if (j <= 0) {
                conditionVariable.block();
            } else {
                z = conditionVariable.block(j);
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static String a(String str, String str2) {
        return str + str2;
    }

    public static String a(C4293a c4293a, Context context) {
        try {
            String a2 = C4314j.a(c4293a, context, "alipay_cashier_ap_fi", "");
            if (TextUtils.isEmpty(a2)) {
                try {
                    C4314j.b(c4293a, context, "alipay_cashier_ap_fi", C4197a.a("FU", System.currentTimeMillis(), new C4200d(), (short) 0, new C4202f()).a());
                    String a3 = C4314j.a(c4293a, context, "alipay_cashier_ap_fi", "");
                    if (TextUtils.isEmpty(a3)) {
                        C4218a.b(c4293a, C4226b.l, "e_regen_empty", "");
                        return "";
                    }
                    return a3;
                } catch (Exception e2) {
                    C4218a.b(c4293a, C4226b.l, "e_gen", e2.getClass().getSimpleName());
                    return "";
                }
            }
            return a2;
        } catch (Exception e3) {
            C4218a.a(c4293a, C4226b.l, "e_gen_err", e3);
            return "";
        }
    }

    public static void a(String str, String str2, Context context, C4293a c4293a) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || b(c4293a) || !C4245a.D().v()) {
            return;
        }
        try {
            Intent intent = new Intent(C4231b.l);
            intent.putExtra("bizType", str);
            intent.putExtra("exName", str2);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            C4218a.a(c4293a, C4226b.l, "AppNotify", str + "|" + str2);
        } catch (Exception unused) {
        }
    }
}
