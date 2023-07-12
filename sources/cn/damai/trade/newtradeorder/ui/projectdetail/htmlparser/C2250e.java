package cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: Taobao */
/* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.e */
/* loaded from: classes16.dex */
public class C2250e {
    private static transient /* synthetic */ IpChange $ipChange;
    private static LruCache<String, Bitmap> a = new C2251a(((int) Runtime.getRuntime().maxMemory()) / 6);

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.htmlparser.e$a */
    /* loaded from: classes16.dex */
    public class C2251a extends LruCache<String, Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;

        C2251a(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1028607314") ? ((Integer) ipChange.ipc$dispatch("1028607314", new Object[]{this, str, bitmap})).intValue() : bitmap.getByteCount();
        }
    }

    public OutputStream a(String str) throws IOException {
        throw null;
    }

    public void b(String str, Bitmap bitmap) {
        throw null;
    }
}
