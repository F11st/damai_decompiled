package com.youku.live.dago.widgetlib.ailproom.adapter.upload;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.R;
import com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.CropUtil;
import com.youku.live.dago.widgetlib.ailproom.adapter.upload.crop.CropView;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class CropActivity extends Activity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int REQUST_CROP = 4656;
    public static final int RESULT_CROP = 4657;
    private CropView cropView;

    public static void go(Activity activity, Uri uri, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1677943622")) {
            ipChange.ipc$dispatch("-1677943622", new Object[]{activity, uri, Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (activity == null || activity.isFinishing()) {
        } else {
            Intent intent = new Intent(activity, CropActivity.class);
            intent.putExtra("uri", uri);
            intent.putExtra("aspectX", i);
            intent.putExtra("aspectY", i2);
            activity.startActivityForResult(intent, REQUST_CROP);
        }
    }

    public void onCancelClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1268064070")) {
            ipChange.ipc$dispatch("-1268064070", new Object[]{this, view});
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1201773836")) {
            ipChange.ipc$dispatch("1201773836", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R.layout.dago_pgc_ailp_activity_crop);
        this.cropView = (CropView) findViewById(R.id.cropView);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Uri uri = (Uri) extras.getParcelable("uri");
            int i = extras.getInt("aspectX", 1);
            int i2 = extras.getInt("aspectY", 1);
            if (uri != null) {
                this.cropView.of(uri).withAspect(i, i2).initialize(this);
            }
        }
    }

    public void onDoneClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "971239026")) {
            ipChange.ipc$dispatch("971239026", new Object[]{this, view});
            return;
        }
        Bitmap output = this.cropView.getOutput();
        Uri fromFile = Uri.fromFile(new File(getCacheDir(), "cropped"));
        CropUtil.saveOutput(this, fromFile, output);
        Intent intent = new Intent();
        intent.putExtra("cropped", fromFile);
        setResult(RESULT_CROP, intent);
        finish();
    }
}
