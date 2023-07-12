package tb;

import android.text.TextUtils;
import android.util.Pair;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.SocketClient;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d53 implements com.uploader.implement.a.e {
    private boolean a;
    private h43 b;
    private com.uploader.implement.b.a.f c;
    private long d;
    private final Pair<Boolean, Pair<String, Integer>> e;
    private final int f = hashCode();
    private final i83 g;
    private final String h;
    private final com.uploader.implement.c i;

    public d53(com.uploader.implement.c cVar, h43 h43Var, String str, long j, long j2, boolean z) throws Exception {
        this.i = cVar;
        this.b = h43Var;
        this.a = z;
        Pair<Boolean, Pair<String, Integer>> g = cVar.a.g();
        this.e = g;
        if (g != null) {
            this.h = (String) cVar.a.a().first;
            this.d = cVar.a.i();
            this.g = new i83(h43Var.b, h43Var.j, j, j2, null, b(j, j2, str).getBytes("UTF-8"), j < h43Var.f ? "\r\n\r\n".getBytes() : null, h43Var.k);
            return;
        }
        throw new RuntimeException("currentUploadTarget is null");
    }

    private com.uploader.implement.a.f c(Map<String, String> map, byte[] bArr, int i, int i2) {
        i33 i33Var;
        if (map == null) {
            map = new HashMap<>();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i, i2)));
        map.put("divided_length", Integer.toString(i2));
        while (true) {
            i33Var = null;
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    } else if (!TextUtils.isEmpty(readLine)) {
                        int length = readLine.length();
                        int indexOf = readLine.indexOf(":");
                        if (indexOf > 1) {
                            String substring = readLine.substring(0, indexOf);
                            if (indexOf < length) {
                                map.put(substring.trim(), com.uploader.implement.a.c.b.c(readLine.substring(indexOf + 1, length)));
                            }
                        } else {
                            int indexOf2 = readLine.indexOf(" ");
                            if (indexOf2 > 1) {
                                String substring2 = readLine.substring(0, indexOf2);
                                if (indexOf2 < length) {
                                    String substring3 = readLine.substring(indexOf2 + 1, length);
                                    map.put("response_code", substring2);
                                    map.put("response_msg", substring3);
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    if (com.uploader.implement.a.d(16)) {
                        com.uploader.implement.a.b(16, "FileUploadActionRequest", this.f + " decode response header failed", e);
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        if (map.get("x-arup-process") != null) {
            i33Var = new i33(2, map);
        } else if (map.get("x-arup-offset") != null) {
            i33Var = new i33(3, map);
        } else if (map.get("x-arup-file-status") != null) {
            i33Var = new i33(4, map);
        } else if (map.get("x-arup-error-code") != null) {
            i33Var = new i33(5, map);
        } else {
            if (map.get("x-arup-session-status") != null) {
                i33Var = new i33(6, map);
            }
            return i33Var;
        }
        map.put("divided_length", Integer.toString(i2));
        if (com.uploader.implement.a.d(4)) {
            com.uploader.implement.a.a(4, "FileUploadActionRequest", this.f + " decode actionResponse header:" + map.toString());
        }
        return i33Var;
    }

    @Override // com.uploader.implement.a.e
    public i83 b() {
        return this.g;
    }

    @Override // com.uploader.implement.a.e
    /* renamed from: d */
    public com.uploader.implement.b.a.f a() {
        com.uploader.implement.b.a.f fVar = this.c;
        if (fVar != null) {
            return fVar;
        }
        Object obj = this.e.second;
        com.uploader.implement.b.a.f fVar2 = new com.uploader.implement.b.a.f((String) ((Pair) obj).first, ((Integer) ((Pair) obj).second).intValue(), true, ((Boolean) this.e.first).booleanValue());
        this.c = fVar2;
        return fVar2;
    }

    private final String b(long j, long j2, String str) throws Exception {
        StringBuilder sb;
        int i = 0;
        if (this.a) {
            String str2 = this.i.b.getCurrentElement().b;
            String utdid = this.i.b.getUtdid();
            String appVersion = this.i.b.getAppVersion();
            String valueOf = String.valueOf(this.d + (System.currentTimeMillis() / 1000));
            HashMap hashMap = new HashMap();
            hashMap.put("host", "arup.alibaba.com");
            hashMap.put("content-type", "application/offset+octet-stream");
            hashMap.put("x-arup-version", "2.1");
            hashMap.put("x-arup-device-id", utdid);
            hashMap.put("x-arup-appkey", str2);
            hashMap.put("x-arup-appversion", appVersion);
            hashMap.put("x-arup-file-count", Integer.toString(1));
            String userId = this.i.b.getUserId();
            if (!TextUtils.isEmpty(userId)) {
                hashMap.put("x-arup-userinfo", userId);
            }
            hashMap.put("x-arup-timestamp", valueOf);
            if ("patch".equals(str)) {
                StringBuilder sb2 = new StringBuilder(36);
                sb2.append(this.b.d);
                sb2.append("=");
                sb2.append(j);
                hashMap.put("x-arup-req-offset", sb2.toString());
                sb2.setLength(0);
                sb2.append(this.b.d);
                sb2.append("=");
                sb2.append(String.valueOf(this.b.f));
                hashMap.put("x-arup-req-offset-file-length", sb2.toString());
            }
            StringBuilder sb3 = new StringBuilder(128);
            sb3.append(this.b.e);
            sb3.append("&");
            sb3.append(this.h);
            sb3.append("&");
            sb3.append(str2);
            sb3.append("&");
            sb3.append(appVersion);
            sb3.append("&");
            sb3.append(utdid);
            sb3.append("&");
            sb3.append(valueOf);
            String signature = this.i.b.signature(sb3.toString());
            if (TextUtils.isEmpty(signature)) {
                if (com.uploader.implement.a.d(16)) {
                    com.uploader.implement.a.a(16, "FileUploadActionRequest", this.f + " compute upload sign failed.");
                }
                throw new Exception("compute api sign failed.");
            }
            hashMap.put("x-arup-sign", signature);
            sb = new StringBuilder(128);
            sb.append(str);
            sb.append(" ");
            sb.append("/");
            sb.append("f");
            sb.append("/");
            sb.append(this.b.e);
            sb.append("/");
            sb.append(this.h);
            sb.append(" ");
            sb.append("HTTP/1.1");
            sb.append(SocketClient.NETASCII_EOL);
            for (Map.Entry entry : hashMap.entrySet()) {
                sb.append((String) entry.getKey());
                sb.append(":");
                sb.append(com.uploader.implement.a.c.b.e((String) entry.getValue()));
                sb.append(SocketClient.NETASCII_EOL);
            }
            sb.append(SocketClient.NETASCII_EOL);
        } else {
            sb = null;
        }
        if (j < this.b.f) {
            if (sb == null) {
                sb = new StringBuilder(128);
            }
            sb.append("--");
            sb.append(this.b.d);
            sb.append("--");
            sb.append(SocketClient.NETASCII_EOL);
            Map<String, String> map = this.b.h;
            if (map != null && map.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry<String, String> entry2 : this.b.h.entrySet()) {
                    String key = entry2.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        jSONObject.put(key, entry2.getValue());
                    }
                }
                sb.append("x-arup-meta");
                sb.append(":");
                sb.append(com.uploader.implement.a.c.b.e(jSONObject.toString()));
                sb.append(SocketClient.NETASCII_EOL);
            }
            sb.append("x-arup-file-md5");
            sb.append(":");
            sb.append(com.uploader.implement.a.c.b.e(this.b.g));
            sb.append(SocketClient.NETASCII_EOL);
            sb.append("x-arup-file-name");
            sb.append(":");
            sb.append(com.uploader.implement.a.c.b.e(this.b.c));
            sb.append(SocketClient.NETASCII_EOL);
            sb.append("x-arup-range");
            sb.append(":");
            sb.append(j);
            sb.append(",");
            sb.append(j2);
            sb.append(SocketClient.NETASCII_EOL);
            sb.append("x-arup-file-length");
            sb.append(":");
            sb.append(String.valueOf(this.b.f));
            sb.append("\r\n\r\n");
        }
        if (sb == null) {
            return null;
        }
        if (com.uploader.implement.a.d(2)) {
            String sb4 = sb.toString();
            String str3 = "";
            while (true) {
                int indexOf = sb4.indexOf(SocketClient.NETASCII_EOL, i);
                if (indexOf == -1) {
                    break;
                }
                str3 = str3 + sb4.substring(i, indexOf) + StringUtils.LF;
                i = indexOf + 2;
            }
            com.uploader.implement.a.a(2, "FileUploadActionRequest", this.f + " create upload header:" + str3);
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
        r13 = r13 - r2.available();
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x000b A[SYNTHETIC] */
    @Override // com.uploader.implement.a.e
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.util.Pair<com.uploader.implement.a.f, java.lang.Integer> a(java.util.Map<java.lang.String, java.lang.String> r10, byte[] r11, int r12, int r13) {
        /*
            r9 = this;
            java.lang.String r0 = " divide"
            java.lang.String r1 = "FileUploadActionRequest"
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream
            r2.<init>(r11, r12, r13)
            r3 = 0
        La:
            r4 = 0
        Lb:
            r5 = 8
            r6 = -1
            int r7 = r2.read()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            if (r7 != r6) goto L16
            r13 = -1
            goto L36
        L16:
            r8 = 13
            if (r7 != r8) goto L22
            if (r4 == 0) goto L1f
            r5 = 2
            if (r4 != r5) goto L56
        L1f:
            int r4 = r4 + 1
            goto Lb
        L22:
            r8 = 10
            if (r7 != r8) goto L56
            r7 = 1
            if (r4 == r7) goto L2c
            r7 = 3
            if (r4 != r7) goto L56
        L2c:
            int r4 = r4 + 1
            r7 = 4
            if (r4 != r7) goto Lb
            int r4 = r2.available()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            int r13 = r13 - r4
        L36:
            r2.close()     // Catch: java.io.IOException -> L3a
            goto L9a
        L3a:
            r2 = move-exception
            boolean r4 = com.uploader.implement.a.d(r5)
            if (r4 == 0) goto L9a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r7 = r9.f
            r4.append(r7)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.uploader.implement.a.b(r5, r1, r0, r2)
            goto L9a
        L56:
            if (r4 == 0) goto Lb
            goto La
        L59:
            r10 = move-exception
            goto Lb9
        L5b:
            r13 = move-exception
            r4 = 16
            boolean r7 = com.uploader.implement.a.d(r4)     // Catch: java.lang.Throwable -> L59
            if (r7 == 0) goto L7a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r7.<init>()     // Catch: java.lang.Throwable -> L59
            int r8 = r9.f     // Catch: java.lang.Throwable -> L59
            r7.append(r8)     // Catch: java.lang.Throwable -> L59
            java.lang.String r8 = " divide, exception"
            r7.append(r8)     // Catch: java.lang.Throwable -> L59
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L59
            com.uploader.implement.a.b(r4, r1, r7, r13)     // Catch: java.lang.Throwable -> L59
        L7a:
            r2.close()     // Catch: java.io.IOException -> L7e
            goto L99
        L7e:
            r13 = move-exception
            boolean r2 = com.uploader.implement.a.d(r5)
            if (r2 == 0) goto L99
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r4 = r9.f
            r2.append(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.uploader.implement.a.b(r5, r1, r0, r13)
        L99:
            r13 = -1
        L9a:
            if (r13 <= r6) goto Lae
            com.uploader.implement.a.f r10 = r9.c(r10, r11, r12, r13)
            android.util.Pair r11 = new android.util.Pair
            if (r10 != 0) goto La5
            goto La6
        La5:
            r6 = r13
        La6:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r11.<init>(r10, r12)
            return r11
        Lae:
            android.util.Pair r10 = new android.util.Pair
            r11 = 0
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
            r10.<init>(r11, r12)
            return r10
        Lb9:
            r2.close()     // Catch: java.io.IOException -> Lbd
            goto Ld8
        Lbd:
            r11 = move-exception
            boolean r12 = com.uploader.implement.a.d(r5)
            if (r12 == 0) goto Ld8
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            int r13 = r9.f
            r12.append(r13)
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            com.uploader.implement.a.b(r5, r1, r12, r11)
        Ld8:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.d53.a(java.util.Map, byte[], int, int):android.util.Pair");
    }
}
