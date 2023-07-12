package tb;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.alibaba.analytics.core.sync.UploadQueueMgr;
import com.alibaba.security.realidentity.jsbridge.AbstractC3893a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.io.IOException;
import java.util.Objects;
import kotlin.jvm.JvmName;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@JvmName(name = "MediaUtil")
/* loaded from: classes8.dex */
public final class yd1 {
    private static transient /* synthetic */ IpChange $ipChange;

    @Nullable
    public static final Bitmap a(@Nullable Context context, @Nullable String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2018828943") ? (Bitmap) ipChange.ipc$dispatch("-2018828943", new Object[]{context, str}) : b(context, str, null);
    }

    @Nullable
    public static final Bitmap b(@Nullable Context context, @Nullable String str, @Nullable BitmapFactory.Options options) {
        IpChange ipChange = $ipChange;
        boolean z = false;
        if (AndroidInstantRuntime.support(ipChange, "-2061683761")) {
            return (Bitmap) ipChange.ipc$dispatch("-2061683761", new Object[]{context, str, options});
        }
        if (context != null) {
            if (!((str == null || str.length() == 0) ? true : true)) {
                if (!e(context, str)) {
                    return BitmapFactory.decodeFile(str, options);
                }
                Uri parse = Uri.parse(str);
                if (!b41.d("content", parse != null ? parse.getScheme() : null)) {
                    parse = d(context, str);
                }
                if (parse == null) {
                    return null;
                }
                try {
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(parse, UploadQueueMgr.MSGTYPE_REALTIME);
                    if (openFileDescriptor != null) {
                        Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
                        openFileDescriptor.close();
                        return decodeFileDescriptor;
                    }
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @NotNull
    public static final String c(@Nullable Context context, @Nullable String str) {
        ContentResolver contentResolver;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1993018808")) {
            return (String) ipChange.ipc$dispatch("1993018808", new Object[]{context, str});
        }
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            Cursor query = (context == null || (contentResolver = context.getContentResolver()) == null) ? null : contentResolver.query(parse, null, null, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    b41.h(string, "cur.getString(index)");
                    str2 = string;
                }
                query.close();
            }
        }
        return str2;
    }

    @Nullable
    public static final Uri d(@NotNull Context context, @NotNull String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-424085128")) {
            return (Uri) ipChange.ipc$dispatch("-424085128", new Object[]{context, str});
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, AbstractC3893a.V);
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        int i = query.getInt(query.getColumnIndex("_id"));
        Uri parse = Uri.parse("content://media/external/images/media");
        Uri withAppendedPath = Uri.withAppendedPath(parse, "" + i);
        query.close();
        return withAppendedPath;
    }

    public static final boolean e(@Nullable Context context, @Nullable String str) {
        int f0;
        boolean K;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-416523413")) {
            return ((Boolean) ipChange.ipc$dispatch("-416523413", new Object[]{context, str})).booleanValue();
        }
        if (context != null) {
            if (!(str == null || str.length() == 0) && Build.VERSION.SDK_INT >= 29) {
                f0 = StringsKt__StringsKt.f0(str, "/", 0, false, 6, null);
                Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
                String substring = str.substring(0, f0);
                b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String packageName = context.getPackageName();
                b41.h(packageName, "context.packageName");
                K = StringsKt__StringsKt.K(substring, packageName, false, 2, null);
                if (!K) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
