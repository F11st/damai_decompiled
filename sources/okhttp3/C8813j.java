package okhttp3;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.C8753a;
import okio.Buffer;
import okio.BufferedSink;
import tb.xd1;

/* compiled from: Taobao */
/* renamed from: okhttp3.j */
/* loaded from: classes2.dex */
public final class C8813j extends AbstractC8825p {
    private static final xd1 c = xd1.c(IRequestConst.CONTENT_TYPE_POST);
    private final List<String> a;
    private final List<String> b;

    /* compiled from: Taobao */
    /* renamed from: okhttp3.j$a */
    /* loaded from: classes2.dex */
    public static final class C8814a {
        private final List<String> a;
        private final List<String> b;
        @Nullable
        private final Charset c;

        public C8814a() {
            this(null);
        }

        public C8814a a(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.a.add(C8818m.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            this.b.add(C8818m.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            return this;
        }

        public C8813j b() {
            return new C8813j(this.a, this.b);
        }

        public C8814a(@Nullable Charset charset) {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = charset;
        }
    }

    C8813j(List<String> list, List<String> list2) {
        this.a = C8753a.t(list);
        this.b = C8753a.t(list2);
    }

    private long i(@Nullable BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        if (z) {
            buffer = new Buffer();
        } else {
            buffer = bufferedSink.buffer();
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.a.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.b.get(i));
        }
        if (z) {
            long size2 = buffer.size();
            buffer.clear();
            return size2;
        }
        return 0L;
    }

    @Override // okhttp3.AbstractC8825p
    public long a() {
        return i(null, true);
    }

    @Override // okhttp3.AbstractC8825p
    public xd1 b() {
        return c;
    }

    @Override // okhttp3.AbstractC8825p
    public void h(BufferedSink bufferedSink) throws IOException {
        i(bufferedSink, false);
    }
}
