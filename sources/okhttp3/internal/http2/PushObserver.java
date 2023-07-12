package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = new C8788a();

    /* compiled from: Taobao */
    /* renamed from: okhttp3.internal.http2.PushObserver$a */
    /* loaded from: classes2.dex */
    class C8788a implements PushObserver {
        C8788a() {
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
            bufferedSource.skip(i2);
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean onHeaders(int i, List<C8789a> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public boolean onRequest(int i, List<C8789a> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.PushObserver
        public void onReset(int i, ErrorCode errorCode) {
        }
    }

    boolean onData(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException;

    boolean onHeaders(int i, List<C8789a> list, boolean z);

    boolean onRequest(int i, List<C8789a> list);

    void onReset(int i, ErrorCode errorCode);
}
