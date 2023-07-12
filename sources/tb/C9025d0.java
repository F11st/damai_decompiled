package tb;

import com.taobao.pexode.mimetype.MimeType;

/* compiled from: Taobao */
/* renamed from: tb.d0 */
/* loaded from: classes11.dex */
public class C9025d0 {
    public static final MimeType APNG = new MimeType("PNG", "apng", true, new String[]{"png"}, (MimeType.MimeTypeChecker) new C9026a());

    /* compiled from: Taobao */
    /* renamed from: tb.d0$a */
    /* loaded from: classes11.dex */
    static class C9026a implements MimeType.MimeTypeChecker {
        C9026a() {
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public boolean isMyHeader(byte[] bArr) {
            return bArr != null && bArr.length >= 41 && sf1.m(bArr, 0, sf1.PNG_HEADER) && sf1.b(bArr);
        }

        @Override // com.taobao.pexode.mimetype.MimeType.MimeTypeChecker
        public int requestMinHeaderSize() {
            return 41;
        }
    }
}
