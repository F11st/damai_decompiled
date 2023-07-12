package com.alipay.android.phone.mrpc.core;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;

/* compiled from: Taobao */
/* renamed from: com.alipay.android.phone.mrpc.core.o */
/* loaded from: classes10.dex */
public final class C4083o extends AbstractC4088t {
    public String b;
    public byte[] c;
    public boolean g;
    public ArrayList<Header> e = new ArrayList<>();
    public Map<String, String> f = new HashMap();
    public String d = IRequestConst.CONTENT_TYPE_POST;

    public C4083o(String str) {
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(String str, String str2) {
        if (this.f == null) {
            this.f = new HashMap();
        }
        this.f.put(str, str2);
    }

    public final void a(Header header) {
        this.e.add(header);
    }

    public final void a(boolean z) {
        this.g = z;
    }

    public final void a(byte[] bArr) {
        this.c = bArr;
    }

    public final String b(String str) {
        Map<String, String> map = this.f;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final byte[] b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final ArrayList<Header> d() {
        return this.e;
    }

    public final boolean e() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C4083o.class == obj.getClass()) {
            C4083o c4083o = (C4083o) obj;
            byte[] bArr = this.c;
            if (bArr == null) {
                if (c4083o.c != null) {
                    return false;
                }
            } else if (!bArr.equals(c4083o.c)) {
                return false;
            }
            String str = this.b;
            String str2 = c4083o.b;
            if (str == null) {
                if (str2 != null) {
                    return false;
                }
            } else if (!str.equals(str2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        Map<String, String> map = this.f;
        int hashCode = ((map == null || !map.containsKey("id")) ? 1 : this.f.get("id").hashCode() + 31) * 31;
        String str = this.b;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return String.format("Url : %s,HttpHeader: %s", this.b, this.e);
    }
}
