package cn.damai.commonbusiness.photoselect.imageselected.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.w11;
import tb.xe;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class ImageTask2 extends AsyncTask<String, Void, Bitmap> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Listener a;
    private ImageView b;
    private boolean c;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface Listener {
        void onSuccess(ImageView imageView, Bitmap bitmap);
    }

    public ImageTask2(Context context, boolean z, ImageView imageView, Listener listener) {
        this.a = listener;
        this.c = z;
        this.b = imageView;
    }

    private static Bitmap b(boolean z, String str) {
        Bitmap d;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "345638207")) {
            return (Bitmap) ipChange.ipc$dispatch("345638207", new Object[]{Boolean.valueOf(z), str});
        }
        Bitmap bitmap = null;
        try {
            if (z) {
                d = w11.d(str, 400, 400);
            } else {
                d = w11.d(str, 800, 1300);
            }
            bitmap = d;
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1998701619")) {
            return (Bitmap) ipChange.ipc$dispatch("1998701619", new Object[]{this, strArr});
        }
        Bitmap b = b(this.c, strArr[0]);
        if (b != null) {
            xe.a.put(strArr[0], b);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1077815326")) {
            ipChange.ipc$dispatch("-1077815326", new Object[]{this, bitmap});
            return;
        }
        super.onPostExecute(bitmap);
        this.a.onSuccess(this.b, bitmap);
    }
}
