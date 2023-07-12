package cn.damai.commonbusiness.photoselect.imageselected.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Size;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import tb.t60;
import tb.xe;

/* compiled from: Taobao */
@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class ImageTask extends AsyncTask<String, Void, Bitmap> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Listener a;
    private Context b;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface Listener {
        void onSuccess(Bitmap bitmap);
    }

    public ImageTask(Context context, Listener listener) {
        this.a = listener;
        this.b = context;
    }

    public static String a(Context context, Uri uri, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1977965340")) {
            return (String) ipChange.ipc$dispatch("1977965340", new Object[]{context, uri, str});
        }
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            String str2 = context.getExternalCacheDir().toString() + File.separator + str;
            if (openInputStream != null && str2 != null) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                BufferedInputStream bufferedInputStream = new BufferedInputStream(openInputStream);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                byte[] bArr = new byte[1024];
                for (int read = bufferedInputStream.read(bArr); read > 0; read = bufferedInputStream.read(bArr)) {
                    bufferedOutputStream.write(bArr, 0, read);
                    bufferedOutputStream.flush();
                }
                bufferedOutputStream.close();
                fileOutputStream.close();
            }
            return str2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Bitmap c(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "898403079")) {
            return (Bitmap) ipChange.ipc$dispatch("898403079", new Object[]{context, str});
        }
        try {
            return MediaUtils.c().e(str, 1, DisplayMetrics.getwidthPixels(t60.b(context)) / MediaUtils.e, DisplayMetrics.getwidthPixels(t60.b(context)) / MediaUtils.e);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public Bitmap doInBackground(String... strArr) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "646165983")) {
            return (Bitmap) ipChange.ipc$dispatch("646165983", new Object[]{this, strArr});
        }
        Bitmap c = c(this.b, strArr[0]);
        if (c != null) {
            xe.a.put(strArr[0], c);
            return c;
        }
        Bitmap bitmap = null;
        try {
            bitmap = this.b.getContentResolver().loadThumbnail(Uri.parse(strArr[0]), new Size(DisplayMetrics.getwidthPixels(t60.b(this.b)) / MediaUtils.e, DisplayMetrics.getwidthPixels(t60.b(this.b)) / MediaUtils.e), null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bitmap != null) {
            xe.a.put(strArr[0], bitmap);
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: d */
    public void onPostExecute(Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-968929866")) {
            ipChange.ipc$dispatch("-968929866", new Object[]{this, bitmap});
        } else {
            this.a.onSuccess(bitmap);
        }
    }
}
