package cn.damai.user.crop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Crop {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_CROP = 6709;
    public static final int REQUEST_PICK = 9162;
    public static final int RESULT_ERROR = 404;
    private Intent a;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    interface Extra {
        public static final String ASPECT_X = "aspect_x";
        public static final String ASPECT_Y = "aspect_y";
        public static final String AS_PNG = "as_png";
        public static final String ERROR = "error";
        public static final String MAX_X = "max_x";
        public static final String MAX_Y = "max_y";
    }

    private Crop(Uri uri, Uri uri2) {
        Intent intent = new Intent();
        this.a = intent;
        intent.setData(uri);
        this.a.putExtra("output", uri2);
    }

    public static Crop b(Uri uri, Uri uri2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-972532329") ? (Crop) ipChange.ipc$dispatch("-972532329", new Object[]{uri, uri2}) : new Crop(uri, uri2);
    }

    public Intent a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-744034624")) {
            return (Intent) ipChange.ipc$dispatch("-744034624", new Object[]{this, context});
        }
        this.a.setClass(context, CropImageActivity.class);
        return this.a;
    }

    public void c(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1233581623")) {
            ipChange.ipc$dispatch("1233581623", new Object[]{this, activity});
        } else {
            d(activity, 6709);
        }
    }

    public void d(Activity activity, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-413645908")) {
            ipChange.ipc$dispatch("-413645908", new Object[]{this, activity, Integer.valueOf(i)});
        } else {
            activity.startActivityForResult(a(activity), i);
        }
    }

    public Crop e(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2019825776")) {
            return (Crop) ipChange.ipc$dispatch("-2019825776", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.a.putExtra("aspect_x", i);
        this.a.putExtra("aspect_y", i2);
        return this;
    }
}
