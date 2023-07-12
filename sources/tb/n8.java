package tb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.taobao.pexode.C6827a;
import com.taobao.pexode.Pexode;
import com.taobao.pexode.common.NdkCore;
import com.taobao.pexode.common.NewBitmapFactory;
import com.taobao.pexode.decoder.C6834d;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class n8 implements NewBitmapFactory {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.n8$a */
    /* loaded from: classes11.dex */
    public static class C9463a {
        private static final n8 a = new n8();
    }

    public static n8 a() {
        return C9463a.a;
    }

    @Override // com.taobao.pexode.common.NewBitmapFactory
    public Bitmap newBitmap(int i, int i2, Bitmap.Config config) {
        Bitmap bitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = config;
        C6834d.d(options, true);
        C6827a f = C6827a.f();
        int i3 = he0.FIXED_JPG_LENGTH;
        byte[] a = he0.a(i, i2, f.g(i3));
        if (a != null) {
            bitmap = BitmapFactory.decodeByteArray(a, 0, i3, options);
            C6827a.f().h(a);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            bitmap.setHasAlpha(true);
        }
        return bitmap;
    }

    @Override // com.taobao.pexode.common.NewBitmapFactory
    public Bitmap newBitmapWithPin(int i, int i2, Bitmap.Config config) {
        Bitmap newBitmap = newBitmap(i, i2, config);
        if (newBitmap != null) {
            try {
                NdkCore.nativePinBitmap(newBitmap);
                newBitmap.eraseColor(0);
                return newBitmap;
            } catch (Throwable th) {
                hh0.c(Pexode.TAG, "AshmemBitmapFactory native pin bitmap error=%s", th);
                return null;
            }
        }
        return newBitmap;
    }
}
