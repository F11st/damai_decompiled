package tb;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.LruCache;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class xe {
    public static LruCache<String, Bitmap> a;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a extends LruCache<String, Bitmap> {
        private static transient /* synthetic */ IpChange $ipChange;

        a(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-784553130") ? ((Integer) ipChange.ipc$dispatch("-784553130", new Object[]{this, str, bitmap})).intValue() : bitmap.getByteCount();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 12) {
            a = new a(((int) Runtime.getRuntime().maxMemory()) / 6);
        }
    }
}
