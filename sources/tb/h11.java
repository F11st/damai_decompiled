package tb;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import com.airbnb.lottie.ImageAssetDelegate;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class h11 {
    private static final Object e = new Object();
    private final Context a;
    private final String b;
    @Nullable
    private ImageAssetDelegate c;
    private final Map<String, jc1> d;

    public h11(Drawable.Callback callback, String str, ImageAssetDelegate imageAssetDelegate, Map<String, jc1> map) {
        if (!TextUtils.isEmpty(str) && str.charAt(str.length() - 1) != '/') {
            this.b = str + r10.DIR;
        } else {
            this.b = str;
        }
        if (!(callback instanceof View)) {
            kb1.c("LottieDrawable must be inside of a view for images to work.");
            this.d = new HashMap();
            this.a = null;
            return;
        }
        this.a = ((View) callback).getContext();
        this.d = map;
        d(imageAssetDelegate);
    }

    private Bitmap c(String str, @Nullable Bitmap bitmap) {
        synchronized (e) {
            this.d.get(str).f(bitmap);
        }
        return bitmap;
    }

    @Nullable
    public Bitmap a(String str) {
        jc1 jc1Var = this.d.get(str);
        if (jc1Var == null) {
            return null;
        }
        Bitmap a = jc1Var.a();
        if (a != null) {
            return a;
        }
        ImageAssetDelegate imageAssetDelegate = this.c;
        if (imageAssetDelegate != null) {
            Bitmap fetchBitmap = imageAssetDelegate.fetchBitmap(jc1Var);
            if (fetchBitmap != null) {
                c(str, fetchBitmap);
            }
            return fetchBitmap;
        }
        String b = jc1Var.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (b.startsWith("data:") && b.indexOf("base64,") > 0) {
            try {
                byte[] decode = Base64.decode(b.substring(b.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e2) {
                kb1.d("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (!TextUtils.isEmpty(this.b)) {
                AssetManager assets = this.a.getAssets();
                try {
                    return c(str, aw2.l(BitmapFactory.decodeStream(assets.open(this.b + b), null, options), jc1Var.e(), jc1Var.c()));
                } catch (IllegalArgumentException e3) {
                    kb1.d("Unable to decode image.", e3);
                    return null;
                }
            }
            throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
        } catch (IOException e4) {
            kb1.d("Unable to open asset.", e4);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.a == null) || this.a.equals(context);
    }

    public void d(@Nullable ImageAssetDelegate imageAssetDelegate) {
        this.c = imageAssetDelegate;
    }

    @Nullable
    public Bitmap e(String str, @Nullable Bitmap bitmap) {
        if (bitmap == null) {
            jc1 jc1Var = this.d.get(str);
            Bitmap a = jc1Var.a();
            jc1Var.f(null);
            return a;
        }
        Bitmap a2 = this.d.get(str).a();
        c(str, bitmap);
        return a2;
    }
}
