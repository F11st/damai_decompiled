package tb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import com.alibaba.pictures.moimage.IImageUrlFixer;
import com.alibaba.pictures.moimage.ImgResExtraInfo;
import com.alibaba.pictures.moimage.ImgResQuality;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class jg1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final String ANDROID_RESOURCE_SCHEME = "pictures.android.resource";
    @NotNull
    public static final String FOREWARD_SLASH = "/";
    @NotNull
    public static final jg1 INSTANCE = new jg1();
    @NotNull
    public static final String PRELOAD_IMG = "preload_img";
    @NotNull
    public static final String SCHEME_FILE_Q = "file_q";
    @NotNull
    public static final String SCHEME_SLASH = "://";

    private jg1() {
    }

    public static /* synthetic */ Bitmap d(jg1 jg1Var, Drawable drawable, Integer num, Integer num2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = -1;
        }
        if ((i & 4) != 0) {
            num2 = -1;
        }
        return jg1Var.c(drawable, num, num2);
    }

    @Nullable
    public final String a(@Nullable String str) {
        IImageUrlFixer e;
        String addPrefixIfNeeded;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1152396641") ? (String) ipChange.ipc$dispatch("-1152396641", new Object[]{this, str}) : (str == null || (e = mg1.INSTANCE.e()) == null || (addPrefixIfNeeded = e.addPrefixIfNeeded(str)) == null) ? str : addPrefixIfNeeded;
    }

    @Nullable
    public final String b(@Nullable String str, @Nullable Integer num, @Nullable Integer num2, @Nullable ImgResQuality imgResQuality, @Nullable ImgResExtraInfo imgResExtraInfo) {
        String addPrefixIfNeeded;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1106587865")) {
            return (String) ipChange.ipc$dispatch("1106587865", new Object[]{this, str, num, num2, imgResQuality, imgResExtraInfo});
        }
        if (str == null) {
            return null;
        }
        if ((num2 == null || num2.intValue() <= 0 || num == null || num.intValue() <= 0) && imgResQuality == null) {
            IImageUrlFixer e = mg1.INSTANCE.e();
            if (e == null || (addPrefixIfNeeded = e.addPrefixIfNeeded(str)) == null) {
                return str;
            }
        } else {
            IImageUrlFixer e2 = mg1.INSTANCE.e();
            if (e2 == null) {
                return str;
            }
            addPrefixIfNeeded = e2.autoFix(str, num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1, imgResQuality, imgResExtraInfo);
            if (addPrefixIfNeeded == null) {
                return str;
            }
        }
        return addPrefixIfNeeded;
    }

    @Nullable
    public final Bitmap c(@Nullable Drawable drawable, @Nullable Integer num, @Nullable Integer num2) {
        int intrinsicWidth;
        int intrinsicHeight;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1219606980")) {
            return (Bitmap) ipChange.ipc$dispatch("-1219606980", new Object[]{this, drawable, num, num2});
        }
        if (drawable == null) {
            return null;
        }
        if (num == null || num.intValue() <= 0 || num2 == null || num.intValue() <= 0) {
            intrinsicWidth = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        if (intrinsicWidth == 0 || intrinsicHeight == 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        canvas.setBitmap(null);
        return createBitmap;
    }

    @NotNull
    public final Bitmap.Config e(@Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1830194908")) {
            return (Bitmap.Config) ipChange.ipc$dispatch("1830194908", new Object[]{this, bitmap});
        }
        if ((bitmap != null ? bitmap.getConfig() : null) != null) {
            Bitmap.Config config = bitmap.getConfig();
            b41.h(config, "bitmap.config");
            return config;
        }
        return Bitmap.Config.ARGB_8888;
    }

    public final boolean f(@Nullable Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "519357452")) {
            return ((Boolean) ipChange.ipc$dispatch("519357452", new Object[]{this, uri})).booleanValue();
        }
        return b41.d(uri != null ? uri.getScheme() : null, ANDROID_RESOURCE_SCHEME);
    }

    public final boolean g(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "448029628")) {
            return ((Boolean) ipChange.ipc$dispatch("448029628", new Object[]{this, str})).booleanValue();
        }
        if (str == null) {
            return false;
        }
        Uri parse = Uri.parse(str);
        b41.h(parse, "oriUri");
        return parse.getScheme() != null && (b41.d(parse.getScheme(), "http") ^ true) && (b41.d(parse.getScheme(), "https") ^ true);
    }

    public final boolean h(@NotNull Context context, int i) {
        CharSequence charSequence;
        boolean p;
        boolean p2;
        boolean p3;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1557417414")) {
            return ((Boolean) ipChange.ipc$dispatch("-1557417414", new Object[]{this, context, Integer.valueOf(i)})).booleanValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        TypedValue typedValue = new TypedValue();
        try {
            context.getResources().getValue(i, typedValue, true);
        } catch (Exception e) {
            lg1 lg1Var = lg1.INSTANCE;
            lg1Var.d("MoImageHelper", "isPictureResource:get resources type value error=" + e);
        }
        int i2 = typedValue.type;
        if ((i2 == 1 || i2 == 3) && (charSequence = typedValue.string) != null) {
            String obj = charSequence.toString();
            p = C8604o.p(obj, ".png", false, 2, null);
            if (p) {
                return true;
            }
            p2 = C8604o.p(obj, ".jpg", false, 2, null);
            if (p2) {
                return true;
            }
            p3 = C8604o.p(obj, ".webp", false, 2, null);
            if (p3) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final Integer i(@Nullable Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1565688570")) {
            return (Integer) ipChange.ipc$dispatch("1565688570", new Object[]{this, uri});
        }
        if (!b41.d(uri != null ? uri.getScheme() : null, ANDROID_RESOURCE_SCHEME) || uri.getPath() == null) {
            return null;
        }
        try {
            String path = uri.getPath();
            b41.f(path);
            b41.h(path, "uri.path!!");
            if (path != null) {
                String substring = path.substring(1);
                b41.h(substring, "(this as java.lang.String).substring(startIndex)");
                return Integer.valueOf(substring);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception unused) {
            lg1.INSTANCE.c("MoImageHelper:resolveIdFromMoUri:本地资源图片仅限设置ID");
            return null;
        }
    }

    @Nullable
    public final Uri j(@Nullable Context context, @Nullable Integer num) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1562944413")) {
            return (Uri) ipChange.ipc$dispatch("1562944413", new Object[]{this, context, num});
        }
        if (context == null) {
            context = mg1.INSTANCE.c();
        }
        if (context == null) {
            lg1.INSTANCE.c("resourceIdToMoUri-tContext--(context?:MoImageManager.application)==null");
            return null;
        } else if (num == null) {
            return null;
        } else {
            return Uri.parse("pictures.android.resource://" + context.getPackageName() + "/" + num);
        }
    }
}
