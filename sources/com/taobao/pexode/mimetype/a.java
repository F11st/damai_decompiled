package com.taobao.pexode.mimetype;

import com.taobao.pexode.mimetype.MimeType;
import java.util.ArrayList;
import java.util.List;
import tb.sf1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a {
    public static final List<MimeType> ALL_EXTENSION_TYPES;
    public static final MimeType BMP;
    public static final MimeType GIF;
    public static final MimeType HEIF;
    public static final MimeType JPEG;
    public static final MimeType PNG;
    public static final MimeType PNG_A;
    public static final MimeType WEBP;
    public static final MimeType WEBP_A;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.pexode.mimetype.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class C0321a implements MimeType.MimeTypeChecker {
        C0321a() {
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            return sf1.f(bArr);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class b implements MimeType.MimeTypeChecker {
        b() {
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            return sf1.k(bArr);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 21;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class c implements MimeType.MimeTypeChecker {
        c() {
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            return sf1.i(bArr);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 21;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class d implements MimeType.MimeTypeChecker {
        d() {
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            return sf1.h(bArr);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 41;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class e implements MimeType.MimeTypeChecker {
        e() {
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            return sf1.g(bArr);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 41;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class f implements MimeType.MimeTypeChecker {
        f() {
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            return sf1.d(bArr);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 6;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class g implements MimeType.MimeTypeChecker {
        g() {
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            return sf1.c(bArr);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 2;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class h implements MimeType.MimeTypeChecker {
        h() {
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            return sf1.e(bArr);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 4;
        }
    }

    static {
        MimeType mimeType = new MimeType("JPEG", "JPEG", new String[]{"jpg", "jpeg"}, new C0321a());
        JPEG = mimeType;
        MimeType mimeType2 = new MimeType("WEBP", "WEBP", new String[]{"webp"}, new b());
        WEBP = mimeType2;
        WEBP_A = new MimeType("WEBP", "WEBP_A", new String[]{"webp"}, true, (MimeType.MimeTypeChecker) new c());
        MimeType mimeType3 = new MimeType("PNG", "PNG", new String[]{"png"}, new d());
        PNG = mimeType3;
        PNG_A = new MimeType("PNG", "PNG_A", new String[]{"png"}, true, (MimeType.MimeTypeChecker) new e());
        MimeType mimeType4 = new MimeType("GIF", "GIF", true, new String[]{"gif"}, (MimeType.MimeTypeChecker) new f());
        GIF = mimeType4;
        MimeType mimeType5 = new MimeType("BMP", "BMP", new String[]{"bmp"}, new g());
        BMP = mimeType5;
        HEIF = new MimeType("HEIF", "HEIF", new String[]{"heic"}, new h());
        ArrayList arrayList = new ArrayList();
        ALL_EXTENSION_TYPES = arrayList;
        arrayList.add(mimeType);
        arrayList.add(mimeType2);
        arrayList.add(mimeType3);
        arrayList.add(mimeType4);
        arrayList.add(mimeType5);
    }
}
