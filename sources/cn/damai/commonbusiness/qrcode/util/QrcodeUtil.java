package cn.damai.commonbusiness.qrcode.util;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import cn.damai.common.askpermission.OnGrantListener;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.zxing.WriterException;
import java.util.Hashtable;
import tb.df0;
import tb.dy1;
import tb.fa;
import tb.ir1;
import tb.me0;
import tb.mr1;
import tb.nc;
import tb.ne;
import tb.pe0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class QrcodeUtil {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_CODE_SCAN_GALLERY = 1000;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface OnQRcodeCreateListener {
        void onFailure();

        void onSuccess(Bitmap bitmap);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.qrcode.util.QrcodeUtil$a */
    /* loaded from: classes4.dex */
    public class C0789a implements OnGrantListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Activity a;

        C0789a(Activity activity) {
            this.a = activity;
        }

        @Override // cn.damai.common.askpermission.OnGrantListener
        public void onGranted() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1361147833")) {
                ipChange.ipc$dispatch("-1361147833", new Object[]{this});
                return;
            }
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            intent.setType("image/*");
            this.a.startActivityForResult(intent, 1000);
        }
    }

    public static Bitmap a(int i, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "592886025") ? (Bitmap) ipChange.ipc$dispatch("592886025", new Object[]{Integer.valueOf(i), str}) : e(str, i);
    }

    public static Bitmap b(int i, String str, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1166019393") ? (Bitmap) ipChange.ipc$dispatch("1166019393", new Object[]{Integer.valueOf(i), str, bitmap}) : e(str, i);
    }

    public static void c(int i, String str, OnQRcodeCreateListener onQRcodeCreateListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2099543910")) {
            ipChange.ipc$dispatch("-2099543910", new Object[]{Integer.valueOf(i), str, onQRcodeCreateListener});
            return;
        }
        Bitmap e = e(str, i);
        if (e != null) {
            if (onQRcodeCreateListener != null) {
                onQRcodeCreateListener.onSuccess(e);
            }
        } else if (onQRcodeCreateListener != null) {
            onQRcodeCreateListener.onFailure();
        }
    }

    private static nc d(String str, fa faVar, int i, int i2, Hashtable hashtable) throws WriterException {
        df0 df0Var;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1272319068")) {
            return (nc) ipChange.ipc$dispatch("1272319068", new Object[]{str, faVar, Integer.valueOf(i), Integer.valueOf(i2), hashtable});
        }
        if (str != null && str.length() != 0) {
            if (faVar != fa.QR_CODE) {
                throw new IllegalArgumentException("Can only encode QR_CODE, but got " + faVar);
            } else if (i >= 0 && i2 >= 0) {
                df0 df0Var2 = df0.L;
                if (hashtable != null && (df0Var = (df0) hashtable.get(me0.ERROR_CORRECTION)) != null) {
                    df0Var2 = df0Var;
                }
                dy1 dy1Var = new dy1();
                pe0.l(str, df0Var2, hashtable, dy1Var);
                return h(dy1Var, i, i2);
            } else {
                throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
            }
        }
        throw new IllegalArgumentException("Found empty contents");
    }

    private static Bitmap e(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "715089434")) {
            return (Bitmap) ipChange.ipc$dispatch("715089434", new Object[]{str, Integer.valueOf(i)});
        }
        try {
            Hashtable hashtable = new Hashtable();
            hashtable.put(me0.CHARACTER_SET, "utf-8");
            nc d = d(str, fa.QR_CODE, i, i, hashtable);
            int c = d.c();
            int b = d.b();
            int[] iArr = new int[c * b];
            for (int i2 = 0; i2 < b; i2++) {
                for (int i3 = 0; i3 < c; i3++) {
                    if (d.a(i3, i2)) {
                        iArr[(i2 * c) + i3] = -16777216;
                    } else {
                        iArr[(i2 * c) + i3] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(c, b, Bitmap.Config.ARGB_4444);
            createBitmap.setPixels(iArr, 0, c, 0, 0, c, b);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String f(Activity activity, Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-241062308")) {
            return (String) ipChange.ipc$dispatch("-241062308", new Object[]{activity, uri});
        }
        Cursor query = activity.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query == null) {
            return uri.getPath();
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("_data"));
        query.close();
        return string;
    }

    public static void g(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1503026282")) {
            ipChange.ipc$dispatch("-1503026282", new Object[]{activity});
        } else {
            ir1.b(activity, false, mr1.STORAGE, "用于选取图片进行二维码识别", new C0789a(activity));
        }
    }

    private static nc h(dy1 dy1Var, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-582362533")) {
            return (nc) ipChange.ipc$dispatch("-582362533", new Object[]{dy1Var, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        ne c = dy1Var.c();
        int e = c.e();
        int d = c.d();
        int max = Math.max(i, e);
        int max2 = Math.max(i2, d);
        int min = Math.min(max / e, max2 / d);
        int i3 = (max - (e * min)) / 2;
        int i4 = (max2 - (d * min)) / 2;
        nc ncVar = new nc(max, max2);
        int i5 = 0;
        while (i5 < d) {
            int i6 = i3;
            int i7 = 0;
            while (i7 < e) {
                if (c.b(i7, i5) == 1) {
                    ncVar.d(i6, i4, min, min);
                }
                i7++;
                i6 += min;
            }
            i5++;
            i4 += min;
        }
        return ncVar;
    }
}
