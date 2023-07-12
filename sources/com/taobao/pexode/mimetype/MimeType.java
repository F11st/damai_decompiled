package com.taobao.pexode.mimetype;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MimeType {
    private final String a;
    private final String b;
    private final String[] c;
    private final boolean d;
    private final MimeTypeChecker e;
    private final boolean f;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface MimeTypeChecker {
        boolean isMyHeader(byte[] bArr);

        int requestMinHeaderSize();
    }

    public MimeType(String str, String str2, String[] strArr, MimeTypeChecker mimeTypeChecker) {
        this(str, str2, strArr, false, false, mimeTypeChecker);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.f;
    }

    public boolean e(String str) {
        for (String str2 : this.c) {
            if (str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(byte[] bArr) {
        return this.e.isMyHeader(bArr);
    }

    public boolean g(MimeType mimeType) {
        String b;
        return (mimeType == null || (b = b()) == null || !b.equals(mimeType.b())) ? false : true;
    }

    public String toString() {
        return "image/" + b();
    }

    public MimeType(String str, String str2, String[] strArr, boolean z, MimeTypeChecker mimeTypeChecker) {
        this(str, str2, strArr, z, false, mimeTypeChecker);
    }

    public MimeType(String str, String str2, boolean z, String[] strArr, MimeTypeChecker mimeTypeChecker) {
        this(str, str2, strArr, false, z, mimeTypeChecker);
    }

    private MimeType(String str, String str2, String[] strArr, boolean z, boolean z2, MimeTypeChecker mimeTypeChecker) {
        this.a = str;
        this.b = str2;
        this.c = strArr;
        this.d = z;
        this.f = z2;
        this.e = mimeTypeChecker;
    }
}
