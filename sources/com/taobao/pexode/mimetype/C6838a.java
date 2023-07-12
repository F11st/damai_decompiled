package com.taobao.pexode.mimetype;

import com.taobao.pexode.mimetype.MimeType;
import java.util.ArrayList;
import java.util.List;
import tb.sf1;

/* compiled from: Taobao */
/* renamed from: com.taobao.pexode.mimetype.a */
/* loaded from: classes11.dex */
public class C6838a {
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
    /* renamed from: com.taobao.pexode.mimetype.a$a */
    /* loaded from: classes11.dex */
    static class C6839a implements MimeType.MimeTypeChecker {
        C6839a() {
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
    /* renamed from: com.taobao.pexode.mimetype.a$b */
    /* loaded from: classes11.dex */
    static class C6840b implements MimeType.MimeTypeChecker {
        C6840b() {
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
    /* renamed from: com.taobao.pexode.mimetype.a$c */
    /* loaded from: classes11.dex */
    static class C6841c implements MimeType.MimeTypeChecker {
        C6841c() {
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
    /* renamed from: com.taobao.pexode.mimetype.a$d */
    /* loaded from: classes11.dex */
    static class C6842d implements MimeType.MimeTypeChecker {
        C6842d() {
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
    /* renamed from: com.taobao.pexode.mimetype.a$e */
    /* loaded from: classes11.dex */
    static class C6843e implements MimeType.MimeTypeChecker {
        C6843e() {
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
    /* renamed from: com.taobao.pexode.mimetype.a$f */
    /* loaded from: classes11.dex */
    static class C6844f implements MimeType.MimeTypeChecker {
        C6844f() {
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
    /* renamed from: com.taobao.pexode.mimetype.a$g */
    /* loaded from: classes11.dex */
    static class C6845g implements MimeType.MimeTypeChecker {
        C6845g() {
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
    /* renamed from: com.taobao.pexode.mimetype.a$h */
    /* loaded from: classes11.dex */
    static class C6846h implements MimeType.MimeTypeChecker {
        C6846h() {
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
        MimeType mimeType = new MimeType("JPEG", "JPEG", new String[]{"jpg", "jpeg"}, new C6839a());
        JPEG = mimeType;
        MimeType mimeType2 = new MimeType("WEBP", "WEBP", new String[]{"webp"}, new C6840b());
        WEBP = mimeType2;
        WEBP_A = new MimeType("WEBP", "WEBP_A", new String[]{"webp"}, true, (MimeType.MimeTypeChecker) new C6841c());
        MimeType mimeType3 = new MimeType("PNG", "PNG", new String[]{"png"}, new C6842d());
        PNG = mimeType3;
        PNG_A = new MimeType("PNG", "PNG_A", new String[]{"png"}, true, (MimeType.MimeTypeChecker) new C6843e());
        MimeType mimeType4 = new MimeType("GIF", "GIF", true, new String[]{"gif"}, (MimeType.MimeTypeChecker) new C6844f());
        GIF = mimeType4;
        MimeType mimeType5 = new MimeType("BMP", "BMP", new String[]{"bmp"}, new C6845g());
        BMP = mimeType5;
        HEIF = new MimeType("HEIF", "HEIF", new String[]{"heic"}, new C6846h());
        ArrayList arrayList = new ArrayList();
        ALL_EXTENSION_TYPES = arrayList;
        arrayList.add(mimeType);
        arrayList.add(mimeType2);
        arrayList.add(mimeType3);
        arrayList.add(mimeType4);
        arrayList.add(mimeType5);
    }
}
