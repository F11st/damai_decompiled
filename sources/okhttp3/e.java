package okhttp3;

import com.alibaba.wireless.security.SecExceptionCode;
import com.youku.uplayer.AliMediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class e {
    final String a;
    static final Comparator<String> b = new Comparator() { // from class: tb.pi
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int f;
            f = okhttp3.e.f((String) obj, (String) obj2);
            return f;
        }
    };
    private static final Map<String, e> c = new LinkedHashMap();
    public static final e TLS_RSA_WITH_NULL_MD5 = d("SSL_RSA_WITH_NULL_MD5", 1);
    public static final e TLS_RSA_WITH_NULL_SHA = d("SSL_RSA_WITH_NULL_SHA", 2);
    public static final e TLS_RSA_EXPORT_WITH_RC4_40_MD5 = d("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final e TLS_RSA_WITH_RC4_128_MD5 = d("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final e TLS_RSA_WITH_RC4_128_SHA = d("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final e TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = d("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final e TLS_RSA_WITH_DES_CBC_SHA = d("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final e TLS_RSA_WITH_3DES_EDE_CBC_SHA = d("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final e TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = d("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final e TLS_DHE_DSS_WITH_DES_CBC_SHA = d("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final e TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = d("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final e TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = d("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final e TLS_DHE_RSA_WITH_DES_CBC_SHA = d("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final e TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = d("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final e TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = d("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final e TLS_DH_anon_WITH_RC4_128_MD5 = d("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final e TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = d("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final e TLS_DH_anon_WITH_DES_CBC_SHA = d("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final e TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = d("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final e TLS_KRB5_WITH_DES_CBC_SHA = d("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final e TLS_KRB5_WITH_3DES_EDE_CBC_SHA = d("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final e TLS_KRB5_WITH_RC4_128_SHA = d("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final e TLS_KRB5_WITH_DES_CBC_MD5 = d("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final e TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = d("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final e TLS_KRB5_WITH_RC4_128_MD5 = d("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final e TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final e TLS_KRB5_EXPORT_WITH_RC4_40_SHA = d("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final e TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = d("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final e TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = d("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final e TLS_RSA_WITH_AES_128_CBC_SHA = d("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final e TLS_DHE_DSS_WITH_AES_128_CBC_SHA = d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final e TLS_DHE_RSA_WITH_AES_128_CBC_SHA = d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final e TLS_DH_anon_WITH_AES_128_CBC_SHA = d("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final e TLS_RSA_WITH_AES_256_CBC_SHA = d("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final e TLS_DHE_DSS_WITH_AES_256_CBC_SHA = d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final e TLS_DHE_RSA_WITH_AES_256_CBC_SHA = d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final e TLS_DH_anon_WITH_AES_256_CBC_SHA = d("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final e TLS_RSA_WITH_NULL_SHA256 = d("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final e TLS_RSA_WITH_AES_128_CBC_SHA256 = d("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final e TLS_RSA_WITH_AES_256_CBC_SHA256 = d("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final e TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = d("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final e TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = d("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final e TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = d("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final e TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = d("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final e TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = d("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
    public static final e TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = d("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final e TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = d("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final e TLS_DH_anon_WITH_AES_128_CBC_SHA256 = d("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final e TLS_DH_anon_WITH_AES_256_CBC_SHA256 = d("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final e TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = d("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    public static final e TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = d("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final e TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = d("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final e TLS_PSK_WITH_RC4_128_SHA = d("TLS_PSK_WITH_RC4_128_SHA", SecExceptionCode.SEC_ERROR_INIT_PLUGIN_CLASS_ERROR);
    public static final e TLS_PSK_WITH_3DES_EDE_CBC_SHA = d("TLS_PSK_WITH_3DES_EDE_CBC_SHA", SecExceptionCode.SEC_ERROR_INIT_CLAZZ_NULL_ERROR);
    public static final e TLS_PSK_WITH_AES_128_CBC_SHA = d("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final e TLS_PSK_WITH_AES_256_CBC_SHA = d("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final e TLS_RSA_WITH_SEED_CBC_SHA = d("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final e TLS_RSA_WITH_AES_128_GCM_SHA256 = d("TLS_RSA_WITH_AES_128_GCM_SHA256", AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_HD2_UP_GEAR_NEED_BUFFER);
    public static final e TLS_RSA_WITH_AES_256_GCM_SHA384 = d("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final e TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = d("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_DISALBE_ADAPT_SPEED);
    public static final e TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = d("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", AliMediaPlayer.UPLAYER_PROPERTY_TYPE_PATTAYA_ADAPT_SPEED_MAX_SAFE_BUFFER_FACTOR);
    public static final e TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = d("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final e TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = d("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final e TLS_DH_anon_WITH_AES_128_GCM_SHA256 = d("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final e TLS_DH_anon_WITH_AES_256_GCM_SHA384 = d("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final e TLS_EMPTY_RENEGOTIATION_INFO_SCSV = d("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    public static final e TLS_FALLBACK_SCSV = d("TLS_FALLBACK_SCSV", 22016);
    public static final e TLS_ECDH_ECDSA_WITH_NULL_SHA = d("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final e TLS_ECDH_ECDSA_WITH_RC4_128_SHA = d("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final e TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = d("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final e TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final e TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final e TLS_ECDHE_ECDSA_WITH_NULL_SHA = d("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final e TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = d("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final e TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = d("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final e TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final e TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final e TLS_ECDH_RSA_WITH_NULL_SHA = d("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final e TLS_ECDH_RSA_WITH_RC4_128_SHA = d("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final e TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = d("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final e TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final e TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final e TLS_ECDHE_RSA_WITH_NULL_SHA = d("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final e TLS_ECDHE_RSA_WITH_RC4_128_SHA = d("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final e TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = d("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final e TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final e TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final e TLS_ECDH_anon_WITH_NULL_SHA = d("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final e TLS_ECDH_anon_WITH_RC4_128_SHA = d("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final e TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = d("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final e TLS_ECDH_anon_WITH_AES_128_CBC_SHA = d("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final e TLS_ECDH_anon_WITH_AES_256_CBC_SHA = d("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final e TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = d("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final e TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = d("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final e TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = d("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final e TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = d("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final e TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = d("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final e TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = d("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final e TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = d("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final e TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = d("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final e TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = d("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final e TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = d("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final e TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = d("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final e TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = d("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final e TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = d("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final e TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = d("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final e TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = d("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final e TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = d("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final e TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = d("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final e TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = d("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final e TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = d("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final e TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = d("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final e TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = d("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
    public static final e TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = d("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    public static final e TLS_AES_128_GCM_SHA256 = d("TLS_AES_128_GCM_SHA256", 4865);
    public static final e TLS_AES_256_GCM_SHA384 = d("TLS_AES_256_GCM_SHA384", 4866);
    public static final e TLS_CHACHA20_POLY1305_SHA256 = d("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final e TLS_AES_128_CCM_SHA256 = d("TLS_AES_128_CCM_SHA256", 4868);
    public static final e TLS_AES_128_CCM_8_SHA256 = d("TLS_AES_128_CCM_8_SHA256", 4869);

    private e(String str) {
        Objects.requireNonNull(str);
        this.a = str;
    }

    public static synchronized e b(String str) {
        e eVar;
        synchronized (e.class) {
            Map<String, e> map = c;
            eVar = map.get(str);
            if (eVar == null) {
                eVar = map.get(g(str));
                if (eVar == null) {
                    eVar = new e(str);
                }
                map.put(str, eVar);
            }
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<e> c(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(b(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static e d(String str, int i) {
        e eVar = new e(str);
        c.put(str, eVar);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int f(String str, String str2) {
        int min = Math.min(str.length(), str2.length());
        for (int i = 4; i < min; i++) {
            char charAt = str.charAt(i);
            char charAt2 = str2.charAt(i);
            if (charAt != charAt2) {
                return charAt < charAt2 ? -1 : 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }

    private static String g(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        } else if (str.startsWith("SSL_")) {
            return "TLS_" + str.substring(4);
        } else {
            return str;
        }
    }

    public String e() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }
}
