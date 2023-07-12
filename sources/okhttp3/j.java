package okhttp3;

import com.alimm.xadsdk.request.builder.IRequestConst;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSink;
import tb.xd1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class j extends p {
    private static final xd1 c = xd1.c(IRequestConst.CONTENT_TYPE_POST);
    private final List<String> a;
    private final List<String> b;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class a {
        private final List<String> a;
        private final List<String> b;
        @Nullable
        private final Charset c;

        public a() {
            this(null);
        }

        public a a(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.a.add(m.c(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            this.b.add(m.c(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.c));
            return this;
        }

        public j b() {
            return new j(this.a, this.b);
        }

        public a(@Nullable Charset charset) {
            this.a = new ArrayList();
            this.b = new ArrayList();
            this.c = charset;
        }
    }

    j(List<String> list, List<String> list2) {
        this.a = okhttp3.internal.a.t(list);
        this.b = okhttp3.internal.a.t(list2);
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

    @Override // okhttp3.p
    public long a() {
        return i(null, true);
    }

    @Override // okhttp3.p
    public xd1 b() {
        return c;
    }

    @Override // okhttp3.p
    public void h(BufferedSink bufferedSink) throws IOException {
        i(bufferedSink, false);
    }
}
