package tb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.dynamicx.DynamicXInit;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class dr {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean a;

    /* compiled from: Taobao */
    /* renamed from: tb.dr$a */
    /* loaded from: classes4.dex */
    public static class AsyncTaskC9057a extends AsyncTask<Void, Void, Drawable> {
        private static transient /* synthetic */ IpChange $ipChange;
        private String a;
        private WeakReference<ImageView> b;
        private Context c;
        private DynamicXInit.ImgStateRecord d;

        public AsyncTaskC9057a(ImageView imageView, String str, DynamicXInit.ImgStateRecord imgStateRecord) {
            this.b = new WeakReference<>(imageView);
            this.a = str;
            this.c = imageView.getContext().getApplicationContext();
            this.d = imgStateRecord;
        }

        private int b(Context context, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "566331407")) {
                return ((Integer) ipChange.ipc$dispatch("566331407", new Object[]{this, context, str})).intValue();
            }
            if (context == null || TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
            } catch (Exception e) {
                Log.e("DMDefaultimageUtil", "getDrawableId exception", e);
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Drawable doInBackground(Void... voidArr) {
            Drawable drawable;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "221916517")) {
                return (Drawable) ipChange.ipc$dispatch("221916517", new Object[]{this, voidArr});
            }
            int b = b(this.c, this.a);
            if (b == 0) {
                return null;
            }
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    drawable = this.c.getDrawable(b);
                } else {
                    drawable = this.c.getResources().getDrawable(b);
                }
                return drawable;
            } catch (Exception e) {
                Log.e("DMDefaultimageUtil", "Get layout parser exception", e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c */
        public void onPostExecute(Drawable drawable) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1359932685")) {
                ipChange.ipc$dispatch("-1359932685", new Object[]{this, drawable});
                return;
            }
            ImageView imageView = this.b.get();
            if (imageView != null && this.a.equals((String) imageView.getTag(a90.TAG_CURRENT_IMAGE_NAME))) {
                DynamicXInit.ImgStateRecord imgStateRecord = this.d;
                if (imgStateRecord == null || imgStateRecord.isShouldUseDefault) {
                    imageView.setImageDrawable(drawable);
                    imageView.setTag(a90.TAG_IMAGE_NAME, this.a);
                }
            }
        }
    }

    private static boolean a(ImageView imageView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2122774366")) {
            return ((Boolean) ipChange.ipc$dispatch("2122774366", new Object[]{imageView, str})).booleanValue();
        }
        if ("uikit_default_image_bg_gradient".equals(str)) {
            imageView.setImageResource(R$drawable.uikit_default_image_bg_gradient);
        } else if ("uikit_default_image_bg_trans_white".equals(str)) {
            imageView.setImageResource(R$drawable.uikit_default_image_bg_trans_white);
        } else if ("uikit_default_image_bg_grey".equals(str)) {
            imageView.setImageResource(R$drawable.uikit_default_image_bg_grey);
        } else if ("uikit_user_default_icon".equals(str)) {
            imageView.setImageResource(R$drawable.uikit_user_default_icon);
        } else if (!"uikit_user_default_icon_trans_white".equals(str)) {
            return false;
        } else {
            imageView.setImageResource(R$drawable.uikit_user_default_icon_trans_white);
        }
        return true;
    }

    public static void b(ImageView imageView, String str, DynamicXInit.ImgStateRecord imgStateRecord) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "297472895")) {
            ipChange.ipc$dispatch("297472895", new Object[]{imageView, str, imgStateRecord});
        } else if (a(imageView, str)) {
        } else {
            imageView.setTag(a90.TAG_CURRENT_IMAGE_NAME, str);
            if (str == null) {
                imageView.setImageDrawable(null);
                imageView.setTag(a90.TAG_IMAGE_NAME, null);
            } else if (imageView.getDrawable() == null || !str.equals((String) imageView.getTag(a90.TAG_IMAGE_NAME))) {
                y00.q(new AsyncTaskC9057a(imageView, str, imgStateRecord), new Void[0]);
            }
        }
    }
}
