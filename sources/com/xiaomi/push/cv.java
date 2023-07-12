package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.services.district.DistrictSearchQuery;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.ui.module.WXModalUIModule;
import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import com.xiaomi.push.service.C7718a;
import com.xiaomi.push.service.module.PushChannelRegion;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cv {
    protected static Context a;

    /* renamed from: a  reason: collision with other field name */
    private static InterfaceC7623a f178a;

    /* renamed from: a  reason: collision with other field name */
    private static cv f179a;
    private static String c;
    private static String d;

    /* renamed from: a  reason: collision with other field name */
    private long f181a;

    /* renamed from: a  reason: collision with other field name */
    private cu f182a;

    /* renamed from: a  reason: collision with other field name */
    protected InterfaceC7624b f183a;

    /* renamed from: a  reason: collision with other field name */
    private String f184a;

    /* renamed from: a  reason: collision with other field name */
    protected final Map<String, cs> f185a;

    /* renamed from: b  reason: collision with other field name */
    private final long f186b;

    /* renamed from: b  reason: collision with other field name */
    private String f187b;

    /* renamed from: c  reason: collision with other field name */
    private long f188c;
    protected static final Map<String, cr> b = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    protected static boolean f180a = false;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.cv$a */
    /* loaded from: classes11.dex */
    public interface InterfaceC7623a {
        cv a(Context context, cu cuVar, InterfaceC7624b interfaceC7624b, String str);
    }

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.cv$b */
    /* loaded from: classes11.dex */
    public interface InterfaceC7624b {
        String a(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public cv(Context context, cu cuVar, InterfaceC7624b interfaceC7624b, String str) {
        this(context, cuVar, interfaceC7624b, str, null, null);
    }

    protected cv(Context context, cu cuVar, InterfaceC7624b interfaceC7624b, String str, String str2, String str3) {
        this.f185a = new HashMap();
        this.f184a = "0";
        this.f181a = 0L;
        this.f186b = 15L;
        this.f188c = 0L;
        this.f187b = "isp_prov_city_country_ip";
        this.f183a = interfaceC7624b;
        this.f182a = cuVar == null ? new cw(this) : cuVar;
        this.f184a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? f() : str3;
    }

    public static synchronized cv a() {
        cv cvVar;
        synchronized (cv.class) {
            cvVar = f179a;
            if (cvVar == null) {
                throw new IllegalStateException("the host manager is not initialized yet.");
            }
        }
        return cvVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public static String m750a() {
        NetworkInfo activeNetworkInfo;
        Context context = a;
        if (context == null) {
            return "unknown";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager)) == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI-UNKNOWN";
            }
            return activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    static String a(String str) {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes("UTF-8");
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                int i2 = b2 & 240;
                if (i2 != 240) {
                    bytes[i] = (byte) (((b2 & 15) ^ ((byte) (((b2 >> 4) + length) & 15))) | i2);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    private ArrayList<cr> a(ArrayList<String> arrayList) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m759d();
        synchronized (this.f185a) {
            m755a();
            for (String str : this.f185a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        Map<String, cr> map = b;
        synchronized (map) {
            for (Object obj : map.values().toArray()) {
                cr crVar = (cr) obj;
                if (!crVar.b()) {
                    b.remove(crVar.f175b);
                }
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cr> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            String str2 = bj.e(a) ? "wifi" : "wap";
            String a2 = a(arrayList, str2, this.f184a, true);
            if (!TextUtils.isEmpty(a2)) {
                JSONObject jSONObject3 = new JSONObject(a2);
                AbstractC7535b.b(a2);
                if (WXModalUIModule.OK.equalsIgnoreCase(jSONObject3.getString(ExifInterface.LATITUDE_SOUTH))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString(DistrictSearchQuery.KEYWORDS_PROVINCE);
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString(IRequestConst.ISP);
                    String string4 = jSONObject4.getString(TbAuthConstants.IP);
                    String string5 = jSONObject4.getString(DistrictSearchQuery.KEYWORDS_COUNTRY);
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    AbstractC7535b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str3 = arrayList.get(i2);
                        JSONArray optJSONArray = jSONObject5.optJSONArray(str3);
                        if (optJSONArray == null) {
                            AbstractC7535b.m586a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            cr crVar2 = new cr(str3);
                            int i3 = 0;
                            while (i3 < optJSONArray.length()) {
                                String string6 = optJSONArray.getString(i3);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    crVar2.a(new da(string6, optJSONArray.length() - i3));
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i2, crVar2);
                            crVar2.g = string5;
                            crVar2.c = string;
                            crVar2.e = string3;
                            crVar2.f = string4;
                            crVar2.d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                crVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                crVar2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has(RemoteMessageConst.TTL)) {
                                crVar2.a(jSONObject4.getInt(RemoteMessageConst.TTL) * 1000);
                            }
                            m754a(crVar2.a());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject optJSONObject = jSONObject4.optJSONObject("reserved");
                    if (optJSONObject != null) {
                        long j = jSONObject4.has("reserved-ttl") ? jSONObject4.getInt("reserved-ttl") * 1000 : 604800000L;
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            JSONArray optJSONArray2 = optJSONObject.optJSONArray(next);
                            if (optJSONArray2 == null) {
                                AbstractC7535b.m586a("no bucket found for " + next);
                            } else {
                                cr crVar3 = new cr(next);
                                crVar3.a(j);
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    String string7 = optJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        crVar3.a(new da(string7, optJSONArray2.length() - i4));
                                    }
                                }
                                Map<String, cr> map2 = b;
                                synchronized (map2) {
                                    if (this.f182a.a(next)) {
                                        map2.put(next, crVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            AbstractC7535b.m586a("failed to get bucket " + e.getMessage());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            cr crVar4 = arrayList2.get(i5);
            if (crVar4 != null) {
                a(arrayList.get(i5), crVar4);
            }
        }
        m758c();
        return arrayList2;
    }

    public static synchronized void a(Context context, cu cuVar, InterfaceC7624b interfaceC7624b, String str, String str2, String str3) {
        synchronized (cv.class) {
            Context applicationContext = context.getApplicationContext();
            a = applicationContext;
            if (applicationContext == null) {
                a = context;
            }
            if (f179a == null) {
                InterfaceC7623a interfaceC7623a = f178a;
                if (interfaceC7623a == null) {
                    f179a = new cv(context, cuVar, interfaceC7624b, str, str2, str3);
                } else {
                    f179a = interfaceC7623a.a(context, cuVar, interfaceC7624b, str);
                }
            }
        }
    }

    public static synchronized void a(InterfaceC7623a interfaceC7623a) {
        synchronized (cv.class) {
            f178a = interfaceC7623a;
            f179a = null;
        }
    }

    public static void a(String str, String str2) {
        Map<String, cr> map = b;
        cr crVar = map.get(str);
        synchronized (map) {
            if (crVar == null) {
                cr crVar2 = new cr(str);
                crVar2.a(604800000L);
                crVar2.m743a(str2);
                map.put(str, crVar2);
            } else {
                crVar.m743a(str2);
            }
        }
    }

    private String f() {
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public cr m751a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty");
        }
        return a(new URL(str).getHost(), true);
    }

    public cr a(String str, boolean z) {
        cr e;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        if (this.f182a.a(str)) {
            cr c2 = c(str);
            return (c2 == null || !c2.b()) ? (z && bj.b(a) && (e = e(str)) != null) ? e : new cx(this, str, c2) : c2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<bi> arrayList3 = new ArrayList();
        arrayList3.add(new bg("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new bg("conpt", a(bj.m693a(a))));
        }
        if (z) {
            arrayList3.add(new bg("reserved", "1"));
        }
        arrayList3.add(new bg("uuid", str2));
        arrayList3.add(new bg("list", bp.a(arrayList, ",")));
        arrayList3.add(new bg("countrycode", C7718a.a(a).b()));
        String b2 = b();
        cr c2 = c(b2);
        String format = String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", b2);
        if (c2 == null) {
            arrayList2.add(format);
            Map<String, cr> map = b;
            synchronized (map) {
                cr crVar = map.get(b2);
                if (crVar != null) {
                    Iterator<String> it = crVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=4.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = c2.a(format);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e = null;
        while (it2.hasNext()) {
            Uri.Builder buildUpon = Uri.parse(it2.next()).buildUpon();
            for (bi biVar : arrayList3) {
                buildUpon.appendQueryParameter(biVar.a(), biVar.b());
            }
            try {
                InterfaceC7624b interfaceC7624b = this.f183a;
                return interfaceC7624b == null ? bj.a(a, new URL(buildUpon.toString())) : interfaceC7624b.a(buildUpon.toString());
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e == null) {
            return null;
        }
        AbstractC7535b.m586a("network exception: " + e.getMessage());
        throw e;
    }

    /* renamed from: a  reason: collision with other method in class */
    protected JSONObject m752a() {
        JSONObject jSONObject;
        synchronized (this.f185a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            for (cs csVar : this.f185a.values()) {
                jSONArray.put(csVar.m747a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (cr crVar : b.values()) {
                jSONArray2.put(crVar.m742a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m753a() {
        synchronized (this.f185a) {
            this.f185a.clear();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m754a(String str) {
        this.f187b = str;
    }

    public void a(String str, cr crVar) {
        if (TextUtils.isEmpty(str) || crVar == null) {
            throw new IllegalArgumentException("the argument is invalid " + str + AVFSCacheConstants.COMMA_SEP + crVar);
        } else if (this.f182a.a(str)) {
            synchronized (this.f185a) {
                m755a();
                if (this.f185a.containsKey(str)) {
                    this.f185a.get(str).a(crVar);
                } else {
                    cs csVar = new cs(str);
                    csVar.a(crVar);
                    this.f185a.put(str, csVar);
                }
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    protected boolean m755a() {
        synchronized (this.f185a) {
            if (f180a) {
                return true;
            }
            f180a = true;
            this.f185a.clear();
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                return false;
            }
            m757b(d2);
            AbstractC7535b.b("loading the new hosts succeed");
            return true;
        }
    }

    public cr b(String str) {
        return a(str, true);
    }

    protected String b() {
        String a2 = C7718a.a(a).a();
        return (TextUtils.isEmpty(a2) || PushChannelRegion.China.name().equals(a2)) ? "resolver.msg.xiaomi.net" : "resolver.msg.global.xiaomi.net";
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m756b() {
        ArrayList<String> arrayList;
        synchronized (this.f185a) {
            m755a();
            arrayList = new ArrayList<>(this.f185a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                cs csVar = this.f185a.get(arrayList.get(size));
                if (csVar != null && csVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<cr> a2 = a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (a2.get(i) != null) {
                a(arrayList.get(i), a2.get(i));
            }
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    protected void m757b(String str) {
        synchronized (this.f185a) {
            this.f185a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") != 2) {
                throw new JSONException("Bad version");
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    cs a2 = new cs().a(optJSONArray.getJSONObject(i));
                    this.f185a.put(a2.m745a(), a2);
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("reserved");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                    String optString = jSONObject2.optString("host");
                    if (!TextUtils.isEmpty(optString)) {
                        try {
                            cr a3 = new cr(optString).a(jSONObject2);
                            b.put(a3.f175b, a3);
                            AbstractC7535b.m586a("load local reserved host for " + a3.f175b);
                        } catch (JSONException unused) {
                            AbstractC7535b.m586a("parse reserved host fail.");
                        }
                    }
                }
            }
        }
    }

    protected cr c(String str) {
        cs csVar;
        cr a2;
        synchronized (this.f185a) {
            m755a();
            csVar = this.f185a.get(str);
        }
        if (csVar == null || (a2 = csVar.a()) == null) {
            return null;
        }
        return a2;
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f185a) {
            for (Map.Entry<String, cs> entry : this.f185a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append(StringUtils.LF);
            }
        }
        return sb.toString();
    }

    /* renamed from: c  reason: collision with other method in class */
    public void m758c() {
        synchronized (this.f185a) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(a.openFileOutput(e(), 0)));
                String jSONObject = m752a().toString();
                if (!TextUtils.isEmpty(jSONObject)) {
                    bufferedWriter.write(jSONObject);
                }
                bufferedWriter.close();
            } catch (Exception e) {
                AbstractC7535b.m586a("persist bucket failure: " + e.getMessage());
            }
        }
    }

    public cr d(String str) {
        cr crVar;
        Map<String, cr> map = b;
        synchronized (map) {
            crVar = map.get(str);
        }
        return crVar;
    }

    protected String d() {
        BufferedReader bufferedReader;
        File file;
        try {
            file = new File(a.getFilesDir(), e());
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        if (!file.isFile()) {
            C7594ab.a((Closeable) null);
            return null;
        }
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                AbstractC7535b.m586a("load host exception " + th.getMessage());
                return null;
            } finally {
                C7594ab.a(bufferedReader);
            }
        }
    }

    /* renamed from: d  reason: collision with other method in class */
    public void m759d() {
        String next;
        synchronized (this.f185a) {
            for (cs csVar : this.f185a.values()) {
                csVar.a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it = this.f185a.keySet().iterator();
                    while (it.hasNext()) {
                        next = it.next();
                        if (this.f185a.get(next).m746a().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f185a.remove(next);
            }
        }
    }

    protected cr e(String str) {
        if (System.currentTimeMillis() - this.f188c > this.f181a * 60 * 1000) {
            this.f188c = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(str);
            cr crVar = a(arrayList).get(0);
            if (crVar != null) {
                this.f181a = 0L;
                return crVar;
            }
            long j = this.f181a;
            if (j < 15) {
                this.f181a = j + 1;
                return null;
            }
            return null;
        }
        return null;
    }

    protected String e() {
        if ("com.xiaomi.xmsf".equals(c)) {
            return c;
        }
        return c + ":pushservice";
    }
}
