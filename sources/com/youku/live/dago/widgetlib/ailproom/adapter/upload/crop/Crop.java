package com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Crop {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUEST_CROP = 6709;
    public static final int REQUEST_PICK = 9162;
    public static final int RESULT_ERROR = 404;
    private Intent cropIntent;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public interface Extra {
        public static final String ASPECT_X = "aspect_x";
        public static final String ASPECT_Y = "aspect_y";
        public static final String ERROR = "error";
        public static final String OUTPUT_X = "output_x";
        public static final String OUTPUT_Y = "output_y";
    }

    private Crop(Uri uri, Uri uri2) {
        Intent intent = new Intent();
        this.cropIntent = intent;
        intent.setData(uri);
        this.cropIntent.putExtra("output", uri2);
    }

    public static int getAspectX(Bundle bundle) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "937309108") ? ((Integer) ipChange.ipc$dispatch("937309108", new Object[]{bundle})).intValue() : bundle.getInt("aspect_x");
    }

    public static int getAspectY(Bundle bundle) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2112893707") ? ((Integer) ipChange.ipc$dispatch("-2112893707", new Object[]{bundle})).intValue() : bundle.getInt("aspect_y");
    }

    public static Throwable getError(Intent intent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "620424525") ? (Throwable) ipChange.ipc$dispatch("620424525", new Object[]{intent}) : (Throwable) intent.getSerializableExtra("error");
    }

    public static int getOutputX(Bundle bundle) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1595997973") ? ((Integer) ipChange.ipc$dispatch("-1595997973", new Object[]{bundle})).intValue() : bundle.getInt(Extra.OUTPUT_X);
    }

    public static int getOutputY(Bundle bundle) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-351233492") ? ((Integer) ipChange.ipc$dispatch("-351233492", new Object[]{bundle})).intValue() : bundle.getInt(Extra.OUTPUT_Y);
    }

    public static Uri getSaveUri(Intent intent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1134579480") ? (Uri) ipChange.ipc$dispatch("1134579480", new Object[]{intent}) : (Uri) intent.getParcelableExtra("output");
    }

    public static Uri getSourceUri(Intent intent) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "558373302") ? (Uri) ipChange.ipc$dispatch("558373302", new Object[]{intent}) : intent.getData();
    }

    public static Crop of(Uri uri, Uri uri2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2003324329") ? (Crop) ipChange.ipc$dispatch("-2003324329", new Object[]{uri, uri2}) : new Crop(uri, uri2);
    }

    public Crop asSquare() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1734313505")) {
            return (Crop) ipChange.ipc$dispatch("-1734313505", new Object[]{this});
        }
        this.cropIntent.putExtra("aspect_x", 1);
        this.cropIntent.putExtra("aspect_y", 1);
        return this;
    }

    public Intent getIntent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "126114008") ? (Intent) ipChange.ipc$dispatch("126114008", new Object[]{this}) : this.cropIntent;
    }

    public Crop withAspect(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1116898640")) {
            return (Crop) ipChange.ipc$dispatch("1116898640", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.cropIntent.putExtra("aspect_x", i);
        this.cropIntent.putExtra("aspect_y", i2);
        return this;
    }

    public Crop withOutputSize(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1590353338")) {
            return (Crop) ipChange.ipc$dispatch("-1590353338", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        this.cropIntent.putExtra(Extra.OUTPUT_X, i);
        this.cropIntent.putExtra(Extra.OUTPUT_Y, i2);
        return this;
    }
}
