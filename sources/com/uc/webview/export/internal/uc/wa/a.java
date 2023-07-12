package com.uc.webview.export.internal.uc.wa;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.TrafficStats;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.uc.webview.export.Build;
import com.uc.webview.export.cyclone.UCCyclone;
import com.uc.webview.export.cyclone.UCLogger;
import com.uc.webview.export.extension.SettingKeys;
import com.uc.webview.export.extension.UCCore;
import com.uc.webview.export.internal.SDKFactory;
import com.uc.webview.export.internal.interfaces.IGlobalSettings;
import com.uc.webview.export.internal.interfaces.IWaStat;
import com.uc.webview.export.internal.utility.Log;
import com.uc.webview.export.internal.utility.ReflectionUtil;
import com.uc.webview.export.internal.utility.i;
import com.uc.webview.export.internal.utility.n;
import com.uc.webview.export.internal.utility.p;
import com.xiaomi.mipush.sdk.Constants;
import io.flutter.wpkbridge.U4WPKAdapter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import mtopsdk.network.util.Constants;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a {
    public static boolean a = true;
    public static boolean b = false;
    public static int c = 0;
    public static int e = 20480;
    public static int f = 5242880;
    public static int g = 20480 + 1024;
    private static a j;
    public List<b> d;
    private Context k;
    private Map<String, C0351a> m;
    private com.uc.webview.export.internal.utility.f l = null;
    private SimpleDateFormat n = new SimpleDateFormat("yyyyMMdd");
    public SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Object i = new Object();
    private int o = 0;
    private String p = null;
    private Random q = null;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b {
        String a;
        Map<String, String> b;

        public b(String str, Map<String, String> map) {
            this.a = str;
            this.b = map;
        }

        public final String toString() {
            return "Key: " + this.a + " Data: " + this.b.toString();
        }
    }

    private a() {
    }

    public static boolean c() {
        return com.uc.webview.export.internal.cd.a.c(UCCore.EVENT_STAT).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void f() {
        if (c()) {
            try {
                if (!b(this.k)) {
                    Log.d("SDKWaStat", "saveData interrupted by sampling");
                    return;
                }
                if (b) {
                    Log.d("SDKWaStat", "saveData");
                }
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                synchronized (this.i) {
                    if (SDKFactory.b() && !b(this.m)) {
                        hashMap.putAll(this.m);
                        this.m.clear();
                    }
                    if (!a(this.d)) {
                        arrayList.addAll(this.d);
                        this.d.clear();
                    }
                }
                a(hashMap, arrayList);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        String str = this.k.getApplicationContext().getApplicationInfo().dataDir + "/ucwa";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdir();
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h() {
        String str = (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION);
        if (com.uc.webview.export.internal.utility.c.a(str) || str.equals("0")) {
            return "wa_upload_new.wa";
        }
        return "wa_upload_new.wa_" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String i() {
        String str = (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION);
        if (com.uc.webview.export.internal.utility.c.a(str) || str.equals("0")) {
            return "1";
        }
        return "1_" + str;
    }

    private Object[] j() {
        BufferedReader bufferedReader;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        BufferedReader bufferedReader2;
        FileInputStream fileInputStream3;
        String str;
        String str2;
        String str3;
        int i;
        String str4 = "@0";
        File file = new File(g(), h());
        String str5 = "SDKWaStat";
        if (b) {
            Log.d("SDKWaStat", "getPVFromFile:" + file + " exists:" + file.exists());
        }
        if (!file.exists()) {
            return null;
        }
        file.length();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream), 1024);
                char c2 = 0;
                int i2 = 0;
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (b) {
                            Log.d(str5, readLine);
                        }
                        if (!com.uc.webview.export.internal.utility.c.a(readLine)) {
                            if (readLine.length() + i2 > e) {
                                if (b) {
                                    Log.d(str5, "upload data size(" + (i2 + readLine.length()) + ") more then " + e);
                                }
                            } else {
                                i2 += readLine.length();
                                String trim = readLine.trim();
                                if (!trim.startsWith(str4)) {
                                    if (trim.startsWith("@1")) {
                                    }
                                    str = str4;
                                    str2 = str5;
                                    str4 = str;
                                    str5 = str2;
                                    c2 = 0;
                                }
                                int indexOf = trim.indexOf("@k@");
                                int indexOf2 = trim.indexOf("@d@");
                                if (indexOf >= 0 && indexOf2 >= 0) {
                                    String substring = trim.substring(indexOf + 3, indexOf2);
                                    String[] split = trim.substring(indexOf2 + 3).split("`");
                                    if (trim.startsWith(str4)) {
                                        String[] split2 = substring.split(Constants.WAVE_SEPARATOR);
                                        if (split2.length == 2 && split2[c2].length() == 8 && split2[1].length() <= 2) {
                                            C0351a c0351a = (C0351a) hashMap.get(substring);
                                            if (c0351a == null) {
                                                if (hashMap.size() == 8) {
                                                    if (arrayList.size() == 10) {
                                                        break;
                                                    }
                                                } else {
                                                    c0351a = new C0351a(this, (byte) 0);
                                                    hashMap.put(substring, c0351a);
                                                }
                                            }
                                            int length = split.length;
                                            int i3 = 0;
                                            while (i3 < length) {
                                                String[] split3 = split[i3].split("=");
                                                String str6 = str4;
                                                if (split3.length != 2 || split3[1].length() <= 2) {
                                                    str3 = str5;
                                                    i = length;
                                                } else {
                                                    String substring2 = split3[1].substring(2);
                                                    str3 = str5;
                                                    if (split3[1].startsWith("#0")) {
                                                        i = length;
                                                        Integer num = c0351a.a.get(split3[0]);
                                                        if (num == null) {
                                                            c0351a.a.put(split3[0], Integer.valueOf(Integer.parseInt(substring2)));
                                                        } else {
                                                            c0351a.a.put(split3[0], Integer.valueOf(Integer.parseInt(substring2) + num.intValue()));
                                                        }
                                                    } else {
                                                        i = length;
                                                        if (split3[1].startsWith("#1")) {
                                                            c0351a.b.put(split3[0], substring2);
                                                        }
                                                    }
                                                }
                                                i3++;
                                                length = i;
                                                str4 = str6;
                                                str5 = str3;
                                            }
                                            str = str4;
                                            str2 = str5;
                                            c0351a.b.put("core_t", split2[1]);
                                        }
                                    } else {
                                        str = str4;
                                        str2 = str5;
                                        if (arrayList.size() != 10) {
                                            HashMap hashMap2 = new HashMap(split.length);
                                            for (String str7 : split) {
                                                String[] split4 = str7.split("=");
                                                if (split4.length == 2) {
                                                    hashMap2.put(split4[0], split4[1].substring(2));
                                                }
                                            }
                                            hashMap2.put("ev_ac", substring);
                                            arrayList.add(new b(substring, hashMap2));
                                        }
                                    }
                                    str4 = str;
                                    str5 = str2;
                                    c2 = 0;
                                }
                                str = str4;
                                str2 = str5;
                                str4 = str;
                                str5 = str2;
                                c2 = 0;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream3 = fileInputStream;
                        try {
                            e.printStackTrace();
                            UCCyclone.close(bufferedReader2);
                            UCCyclone.close(fileInputStream);
                            UCCyclone.close(fileInputStream3);
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            fileInputStream2 = fileInputStream3;
                            UCCyclone.close(bufferedReader);
                            UCCyclone.close(fileInputStream);
                            UCCyclone.close(fileInputStream2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        fileInputStream2 = fileInputStream;
                        UCCyclone.close(bufferedReader);
                        UCCyclone.close(fileInputStream);
                        UCCyclone.close(fileInputStream2);
                        throw th;
                    }
                }
                if (hashMap.size() <= 0 && arrayList.size() <= 0) {
                    UCCyclone.close(bufferedReader2);
                    UCCyclone.close(fileInputStream);
                    UCCyclone.close(fileInputStream);
                    return null;
                }
                Object[] objArr = {hashMap, arrayList};
                UCCyclone.close(bufferedReader2);
                UCCyclone.close(fileInputStream);
                UCCyclone.close(fileInputStream);
                return objArr;
            } catch (Exception e3) {
                e = e3;
                fileInputStream3 = fileInputStream;
                bufferedReader2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream2 = fileInputStream;
                bufferedReader = null;
            }
        } catch (Exception e4) {
            e = e4;
            bufferedReader2 = null;
            fileInputStream3 = null;
            fileInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            fileInputStream = null;
            fileInputStream2 = null;
        }
    }

    /* JADX WARN: Type inference failed for: r2v41, types: [boolean, int] */
    private List<String[]> k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new String[]{"lt", "ev"});
        arrayList.add(new String[]{IRequestConst.CT, "corepv"});
        arrayList.add(new String[]{"pkg", this.k.getPackageName()});
        String[] strArr = new String[2];
        strArr[0] = "sdk_pm";
        String model = Build.getMODEL();
        strArr[1] = com.uc.webview.export.internal.utility.c.a(model) ? "unknown" : model.trim().replaceAll("[`|=]", "");
        arrayList.add(strArr);
        String[] strArr2 = new String[2];
        strArr2[0] = "sdk_f";
        StringBuilder sb = new StringBuilder();
        sb.append((SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED)).booleanValue() || com.uc.webview.export.internal.update.a.b(this.k) == null) ? "0" : "1");
        sb.append(SDKFactory.c((Long) 1L).booleanValue() ? "1" : "0");
        sb.append(i.a().b(UCCore.OPTION_MULTI_CORE_TYPE) ? "1" : "0");
        sb.append(SDKFactory.c((Long) 2L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 4L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 8L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 16L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 32L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 64L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 128L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 256L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 512L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 1024L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 2048L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c((Long) 4096L).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_PLAY_FROM_URI)).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE)).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID)).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH)).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_PREPARE_FROM_URI)).booleanValue() ? "1" : "0");
        sb.append(SDKFactory.c(Long.valueOf((long) PlaybackStateCompat.ACTION_SET_REPEAT_MODE)).booleanValue() ? "1" : "0");
        strArr2[1] = sb.toString();
        arrayList.add(strArr2);
        String[] strArr3 = new String[2];
        strArr3[0] = "sdk_bd";
        String brand = Build.getBRAND();
        strArr3[1] = com.uc.webview.export.internal.utility.c.a(brand) ? "unknown" : brand.trim().replaceAll("[`|=]", "");
        arrayList.add(strArr3);
        arrayList.add(new String[]{"sdk_osv", Build.VERSION.getRELEASE()});
        arrayList.add(new String[]{"sdk_prd", com.uc.webview.export.Build.SDK_PRD});
        arrayList.add(new String[]{"sdk_pfid", com.uc.webview.export.Build.SDK_PROFILE_ID});
        arrayList.add(new String[]{"sdk_cos", p.e()});
        arrayList.add(new String[]{"pro_sf", (String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION)});
        arrayList.add(new String[]{"uuid", a(this.k.getSharedPreferences("UC_WA_STAT", 4))});
        String str = (String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_TIMING);
        if (!com.uc.webview.export.internal.utility.c.a(str)) {
            arrayList.add(new String[]{"ab_sn", str});
        }
        String str2 = (String) UCCore.getGlobalOption(UCCore.ADAPTER_BUILD_VERSOPM);
        if (!com.uc.webview.export.internal.utility.c.a(str2)) {
            arrayList.add(new String[]{"ab_ve", str2});
        }
        if (!com.uc.webview.export.internal.utility.c.a(com.uc.webview.export.Build.CORE_VERSION)) {
            arrayList.add(new String[]{"sdk_sdk_cv", com.uc.webview.export.Build.CORE_VERSION.trim()});
        }
        if (!com.uc.webview.export.internal.utility.c.a(com.uc.webview.export.Build.UCM_VERSION)) {
            arrayList.add(new String[]{"sdk_ucm_cv", com.uc.webview.export.Build.UCM_VERSION.trim()});
        }
        Long l = (Long) UCCore.getGlobalOption(UCCore.STARTUP_ELAPSE_BEETWEEN_UC_INIT_AND_APP);
        if (l != null) {
            arrayList.add(new String[]{"st_el", Long.toString(l.longValue())});
        }
        String[] strArr4 = new String[2];
        strArr4[0] = IWaStat.VIDEO_AC;
        strArr4[1] = SDKFactory.c((Long) 1048576L).booleanValue() ? "1" : "0";
        arrayList.add(strArr4);
        String a2 = p.b.a(this.k);
        if (!com.uc.webview.export.internal.utility.c.a(a2)) {
            arrayList.add(new String[]{IWaStat.UTDID_KEY, a2});
        } else {
            arrayList.add(new String[]{IWaStat.UTDID_KEY, "null"});
        }
        arrayList.add(new String[]{"data_dir", this.k.getApplicationInfo().dataDir});
        File file = (File) ReflectionUtil.invokeNoThrow(this.k, "getSharedPrefsFile", new Class[]{String.class}, new Object[]{"UC_WA_STAT"});
        if (file != null) {
            arrayList.add(new String[]{"sp_dir", file.getAbsolutePath()});
        }
        arrayList.add(new String[]{"thrct", Integer.toString(n.b())});
        Integer num = (Integer) UCCore.getGlobalOption(UCCore.OPTION_APP_STARTUP_OPPORTUNITY);
        if (num != null) {
            arrayList.add(new String[]{"ini_op", Integer.toString(num.intValue())});
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(p.f() ? "thick" : "thin");
        String str3 = (String) i.a().a(UCCore.OPTION_BUSINESS_INIT_TYPE);
        if (!p.a(str3)) {
            sb2.append('_');
            sb2.append(str3);
        }
        Boolean bool = (Boolean) i.a().a("gk_dec_exist");
        if (bool != null) {
            sb2.append('_');
            sb2.append(bool.booleanValue() ? "dec_exist" : "dec_not");
        }
        Boolean bool2 = (Boolean) i.a().a("gk_upd_exist");
        if (bool2 != null) {
            sb2.append('_');
            sb2.append(bool2.booleanValue() ? "upd_exist" : "upd_not");
        }
        Boolean bool3 = (Boolean) i.a().a("gk_quick_path");
        if (bool3 != null) {
            sb2.append('_');
            sb2.append(bool3.booleanValue() ? "qpath" : "qpath_not");
        }
        Boolean bool4 = (Boolean) i.a().a("gk_quick_init");
        if (bool4 != null) {
            sb2.append('_');
            sb2.append(bool4.booleanValue() ? "quick" : "quick_not");
        }
        if (b) {
            Log.i("SDKWaStat", "getSetupType:" + sb2.toString());
        }
        String sb3 = sb2.toString();
        if (!p.a(sb3)) {
            arrayList.add(new String[]{"setup_tp", sb3});
        }
        ?? b2 = i.a().b("gk_init_pre");
        int i = b2;
        if (i.a().b("gk_preload_io")) {
            i = b2 + 2;
        }
        int i2 = i;
        if (i.a().b("gk_preload_so")) {
            i2 = i + 4;
        }
        int i3 = i2;
        if (i.a().b("gk_preload_cl")) {
            i3 = i2 + 8;
        }
        if (b) {
            Log.i("SDKWaStat", "getInitPreprocesses:" + i3);
        }
        String num2 = Integer.toString(i3);
        if (!p.a(num2)) {
            arrayList.add(new String[]{"ini_pre", num2});
        }
        arrayList.add(new String[]{"spr", String.valueOf(this.o)});
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        Object[] j2 = j();
        if (j2 == null) {
            return null;
        }
        Map map = (Map) j2[0];
        List<b> list = (List) j2[1];
        try {
            JSONObject jSONObject = new JSONObject();
            for (String[] strArr : k()) {
                jSONObject.put(strArr[0], strArr[1]);
            }
            for (Map.Entry<String, Integer> entry : SDKFactory.p.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().intValue());
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry2 : map.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                for (Map.Entry<String, Integer> entry3 : ((C0351a) entry2.getValue()).a.entrySet()) {
                    jSONObject2.put(entry3.getKey(), String.valueOf(entry3.getValue()));
                }
                for (Map.Entry<String, String> entry4 : ((C0351a) entry2.getValue()).b.entrySet()) {
                    jSONObject2.put(entry4.getKey(), entry4.getValue());
                }
                jSONArray.put(jSONObject2);
            }
            for (b bVar : list) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry<String, String> entry5 : bVar.b.entrySet()) {
                    jSONObject3.put(entry5.getKey(), entry5.getValue());
                }
                jSONArray.put(jSONObject3);
            }
            jSONObject.put("items", jSONArray);
            jSONObject.put("stat_size", String.valueOf(jSONObject.toString().length()));
            return jSONObject.toString();
        } catch (Exception e2) {
            Log.e("SDKWaStat", "getJsonUploadData", e2);
            return null;
        }
    }

    private static String c(Map<String, String> map) {
        String str = map.get(U4WPKAdapter.KEY_TM);
        if (str == null || str.length() <= 10) {
            return null;
        }
        return str.substring(0, 10);
    }

    public final com.uc.webview.export.internal.utility.f b() {
        if (this.l == null) {
            this.l = new com.uc.webview.export.internal.utility.f("U4SDKWaStat");
        }
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.uc.webview.export.internal.uc.wa.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C0351a {
        Map<String, Integer> a;
        Map<String, String> b;

        private C0351a() {
            this.a = new HashMap();
            this.b = new HashMap();
        }

        public final String toString() {
            return "Int Data: " + this.a.toString() + " String Data: " + this.b.toString();
        }

        /* synthetic */ C0351a(a aVar, byte b) {
            this();
        }
    }

    public static a a() {
        Context context;
        if (j == null && (context = SDKFactory.e) != null) {
            a(context);
        }
        return j;
    }

    private static boolean b(Map map) {
        return map == null || map.size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(a aVar) {
        if (c()) {
            aVar.b().a(new e(aVar));
        }
    }

    private static String b(Map<String, C0351a> map, List<b> list) {
        String[] strArr = {HiAnalyticsConstant.KeyAndValue.NUMBER_01, "10", "20"};
        String str = null;
        for (int i = 0; i < 3; i++) {
            String str2 = strArr[i];
            for (Map.Entry<String, C0351a> entry : map.entrySet()) {
                String c2 = c(entry.getValue().b);
                if (c2 != null && c2.endsWith(str2) && (str == null || c2.compareTo(str) > 0)) {
                    str = c2;
                }
            }
            for (b bVar : list) {
                String c3 = c(bVar.b);
                if (c3 != null && c3.endsWith(str2) && (str == null || c3.compareTo(str) > 0)) {
                    str = c3;
                }
            }
            if (str != null) {
                break;
            }
        }
        return str;
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (c()) {
                if (j == null) {
                    j = new a();
                }
                j.k = context.getApplicationContext();
            }
        }
    }

    public final void a(String str) {
        if (c()) {
            a(str, 0, 0, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(String str, byte[] bArr) {
        InputStream inputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        String str2;
        try {
            if (!SDKFactory.f && Boolean.parseBoolean(UCCore.getParam(UCCore.CD_ENABLE_TRAFFIC_STAT)) && Build.VERSION.SDK_INT >= 14) {
                TrafficStats.setThreadStatsTag(40962);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(p.c());
            httpURLConnection.setReadTimeout(p.d());
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestProperty("Content-Type", IRequestConst.CONTENT_TYPE_POST);
            httpURLConnection.setRequestProperty(Constants.Protocol.CONTENT_LENGTH, String.valueOf(bArr.length));
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            outputStream = null;
        }
        if (httpURLConnection.getResponseCode() != 200) {
            if (b) {
                Log.e("SDKWaStat", "response == null", new Throwable());
            }
            UCCyclone.close(outputStream);
            UCCyclone.close((Closeable) null);
            UCCyclone.close((Closeable) null);
            return false;
        }
        InputStream inputStream2 = httpURLConnection.getInputStream();
        try {
            byte[] bArr2 = new byte[1024];
            byteArrayOutputStream = new ByteArrayOutputStream(inputStream2.available());
            while (true) {
                try {
                    int read = inputStream2.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr2, 0, read);
                } catch (Throwable th4) {
                    th = th4;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    Throwable th5 = th;
                    inputStream = inputStream2;
                    th = th5;
                    try {
                        if (b) {
                            Log.e("SDKWaStat", "", th);
                        }
                        return false;
                    } finally {
                        UCCyclone.close(outputStream);
                        UCCyclone.close(inputStream);
                        UCCyclone.close(byteArrayOutputStream2);
                    }
                }
            }
            str2 = new String(byteArrayOutputStream.toByteArray());
            if (b) {
                Log.i("SDKWaStat", "response:" + str2);
            }
        } catch (Throwable th6) {
            th = th6;
        }
        if (str2.contains("retcode=0")) {
            UCCyclone.close(outputStream);
            UCCyclone.close(inputStream2);
            UCCyclone.close(byteArrayOutputStream);
            return true;
        }
        UCCyclone.close(outputStream);
        UCCyclone.close(inputStream2);
        UCCyclone.close(byteArrayOutputStream);
        return false;
    }

    public static void a(Pair<String, HashMap<String, String>> pair) {
        UCLogger create = UCLogger.create("d", "SDKWaStat");
        if (create != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ev_ac=");
            sb.append((String) pair.first);
            for (Map.Entry entry : ((HashMap) pair.second).entrySet()) {
                sb.append("`");
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
            }
            create.print(sb.toString(), new Throwable[0]);
        }
    }

    public final void a(String str, int i, int i2, int i3, String str2) {
        Integer num;
        Date date = new Date(System.currentTimeMillis());
        int e2 = SDKFactory.b() ? SDKFactory.e() : 0;
        if (e2 != 2 && e2 != 0) {
            e2 = (e2 * 10) + SDKFactory.h;
        }
        String str3 = this.n.format(date) + com.xiaomi.mipush.sdk.Constants.WAVE_SEPARATOR + e2;
        synchronized (this.i) {
            if (this.m == null) {
                this.m = new HashMap();
            }
            C0351a c0351a = this.m.get(str3);
            if (c0351a == null) {
                c0351a = new C0351a(this, (byte) 0);
                a(c0351a.b);
                this.m.put(str3, c0351a);
            }
            c0351a.b.put(U4WPKAdapter.KEY_TM, this.h.format(date));
            if (i == 0) {
                Integer num2 = c0351a.a.get(str);
                if (num2 == null) {
                    c0351a.a.put(str, Integer.valueOf(i3));
                } else {
                    c0351a.a.put(str, Integer.valueOf(i3 + num2.intValue()));
                }
            } else if (i != 1) {
                if (i == 2 && ((num = c0351a.a.get(str)) == null || Integer.MAX_VALUE - num.intValue() >= i3)) {
                    if (num == null) {
                        c0351a.a.put(str, Integer.valueOf(i3));
                        c0351a.a.put(str + "_sc", 1);
                    } else {
                        c0351a.a.put(str, Integer.valueOf(i3 + num.intValue()));
                        Map<String, Integer> map = c0351a.a;
                        c0351a.a.put(str + "_sc", Integer.valueOf(map.get(str + "_sc").intValue() + 1));
                    }
                }
            } else if (i2 == 1) {
                c0351a.b.put(str, str2);
            } else {
                String str4 = c0351a.b.get(str);
                if (com.uc.webview.export.internal.utility.c.a(str4)) {
                    c0351a.b.put(str, str2);
                } else {
                    c0351a.b.put(str, str4 + "|" + str2);
                }
            }
        }
    }

    public final void a(boolean z) {
        if (!c() || com.uc.webview.export.internal.utility.c.a((String) UCCore.getGlobalOption(UCCore.PROCESS_PRIVATE_DATA_DIR_SUFFIX_OPTION))) {
            return;
        }
        try {
            b().a(new com.uc.webview.export.internal.uc.wa.b(this));
            if (z) {
                Thread.sleep(20L);
            }
        } catch (Exception e2) {
            Log.e("SDKWaStat", "saveData", e2);
        }
    }

    private static boolean a(List list) {
        return list == null || list.size() == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
        if (r8 != 4) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.uc.wa.a.b(android.content.Context):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ba, code lost:
        if (com.uc.webview.export.internal.uc.wa.a.b == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bc, code lost:
        com.uc.webview.export.internal.utility.Log.d("SDKWaStat", "write merge data, size(" + r14 + ") more then " + com.uc.webview.export.internal.uc.wa.a.e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0162, code lost:
        com.uc.webview.export.internal.utility.Log.d("SDKWaStat", "write un merge data, size(" + r0 + ") more then " + com.uc.webview.export.internal.uc.wa.a.e);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.util.Map<java.lang.String, com.uc.webview.export.internal.uc.wa.a.C0351a> r18, java.util.List<com.uc.webview.export.internal.uc.wa.a.b> r19) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.webview.export.internal.uc.wa.a.a(java.util.Map, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(String str) {
        IGlobalSettings f2 = SDKFactory.f();
        if (f2 != null) {
            f2.setStringValue(SettingKeys.SDKUUID, str);
        }
    }

    private static <T> int a(BufferedWriter bufferedWriter, Map<String, T> map, int i) throws Exception {
        int i2 = 0;
        if (!b(map)) {
            for (Map.Entry<String, T> entry : map.entrySet()) {
                bufferedWriter.write(entry.getKey());
                bufferedWriter.write("=");
                bufferedWriter.write(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + i);
                bufferedWriter.write(entry.getValue() + "`");
                StringBuilder sb = new StringBuilder(com.youku.live.livesdk.wkit.component.Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                sb.append(i);
                int length = entry.getKey().length() + 1 + sb.toString().length();
                i2 += length + (entry.getValue() + "`").length();
            }
        }
        return i2;
    }

    public static void a(Map<String, String> map) {
        map.put("sdk_sn", com.uc.webview.export.Build.TIME);
        map.put("ver", Build.Version.NAME);
    }

    private static void a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append("`");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("2", "");
        if (com.uc.webview.export.internal.utility.c.a(string)) {
            String uuid = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = this.k.getSharedPreferences("UC_WA_STAT", 4).edit();
            edit.putString("2", uuid);
            edit.commit();
            return uuid;
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(long j2, long j3) {
        if (j3 == 0) {
            return true;
        }
        int i = c;
        if (i <= 0) {
            i = 25200000;
        }
        if (!(j2 - j3 >= ((long) i))) {
            if (b) {
                Log.d("SDKWaStat", "时间间隔小于7小时,不上传");
            }
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j2);
        int i2 = calendar.get(11);
        return !(i2 == 0 || i2 == 11 || i2 == 12 || i2 == 23);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ byte[] a(a aVar, String[] strArr) {
        Object[] j2 = aVar.j();
        if (j2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("lt=uc");
        Map map = (Map) j2[0];
        List list = (List) j2[1];
        List<String[]> k = aVar.k();
        strArr[0] = b(map, list);
        Iterator it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            if (sb.length() >= e) {
                if (b) {
                    Log.d("SDKWaStat", "getUploadData MergeData size(" + sb.length() + ") more then " + e);
                }
            } else {
                sb.append(StringUtils.LF);
                for (String[] strArr2 : k) {
                    a(sb, strArr2[0], strArr2[1]);
                }
                for (Map.Entry<String, Integer> entry2 : ((C0351a) entry.getValue()).a.entrySet()) {
                    a(sb, entry2.getKey(), String.valueOf(entry2.getValue()));
                }
                for (Map.Entry<String, String> entry3 : ((C0351a) entry.getValue()).b.entrySet()) {
                    a(sb, entry3.getKey(), entry3.getValue());
                }
                for (Map.Entry<String, Integer> entry4 : SDKFactory.p.entrySet()) {
                    a(sb, entry4.getKey(), String.valueOf(entry4.getValue().intValue()));
                }
            }
        }
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            b bVar = (b) it2.next();
            if (sb.length() >= e) {
                if (b) {
                    Log.d("SDKWaStat", "getUploadData UnMergeData size(" + sb.length() + ") more then " + e);
                }
            } else {
                sb.append(StringUtils.LF);
                for (String[] strArr3 : k) {
                    a(sb, strArr3[0], strArr3[1]);
                }
                for (Map.Entry<String, String> entry5 : bVar.b.entrySet()) {
                    a(sb, entry5.getKey(), entry5.getValue());
                }
            }
        }
        if (b) {
            Log.i("SDKWaStat", "getUploadData:\n" + sb.toString());
        }
        sb.append(StringUtils.LF);
        a(sb, "stat_size", String.valueOf(sb.toString().getBytes().length));
        return sb.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(String str, boolean z) {
        boolean b2 = i.a().b(UCCore.OPTION_SDK_INTERNATIONAL_ENV);
        String str2 = b2 ? "4ee01a39f0c1" : "27120f2b4115";
        String valueOf = String.valueOf(System.currentTimeMillis());
        String a2 = f.a(str2 + str + valueOf + "AppChk#2014");
        StringBuilder sb = new StringBuilder(b2 ? "https://gjapplog.ucweb.com/collect?uc_param_str=&chk=" : "https://applog.uc.cn/collect?uc_param_str=&chk=");
        sb.append(a2.substring(a2.length() - 8, a2.length()));
        sb.append("&vno=");
        sb.append(valueOf);
        sb.append("&uuid=");
        sb.append(str);
        sb.append("&app=");
        sb.append(str2);
        if (f.a()) {
            sb.append("&zip=gzip");
        }
        if (z) {
            sb.append("&enc=aes");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, long j2, String str) {
        SharedPreferences.Editor edit = aVar.k.getSharedPreferences("UC_WA_STAT", 4).edit();
        edit.putLong(i(), j2);
        if (str != null) {
            edit.putString("4", str);
        }
        edit.commit();
    }
}
