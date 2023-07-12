package com.youku.live.dago.widgetlib.ailproom.adapter.upload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.JSCallback;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.UriUtils;
import com.youku.live.dago.widgetlib.ailproom.protocol.AILPUploadPictureProtocol;
import java.io.File;
import java.io.IOException;
import tb.pr0;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class AILPUploadPictureAdapter implements AILPUploadPictureProtocol {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String ACTION_CROP = "com.android.camera.action.CROP";
    private static final int REQUEST_CHOOSE_PHOTO = 4113;
    private static final int REQUEST_CROP_PHOTO = 4114;
    private Context mContext;
    private JSCallback mJSCallback;
    private int mAspectX = 1;
    private int mAspectY = 1;
    private File mPhotoCropFile = null;

    private void choosePhoto() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1920457427")) {
            ipChange.ipc$dispatch("-1920457427", new Object[]{this});
            return;
        }
        Intent intent = new Intent();
        intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setAction("android.intent.action.PICK");
        intent.setType("image/*");
        ((Activity) this.mContext).startActivityForResult(intent, 4113);
    }

    public void cropPhoto(Uri uri) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-316273503")) {
            ipChange.ipc$dispatch("-316273503", new Object[]{this, uri});
            return;
        }
        this.mPhotoCropFile = new File(uri.getPath());
        Intent intent = new Intent(ACTION_CROP);
        intent.setDataAndType(UriUtils.formatImageUri(this.mContext, this.mPhotoCropFile), "image/*");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.putExtra(pr0.MODE_TYPE_CROP, "true");
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 800);
        intent.putExtra("outputY", 800);
        intent.putExtra("return-data", false);
        intent.putExtra("output", Uri.fromFile(this.mPhotoCropFile));
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        ((Activity) this.mContext).startActivityForResult(intent, 4114);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "288801556")) {
            ipChange.ipc$dispatch("288801556", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        if (i2 == -1 && i == 4113 && intent != null) {
            String formatUri = UriUtils.formatUri(this.mContext, intent.getData());
            if (TextUtils.isEmpty(formatUri)) {
                return;
            }
            File file = new File(formatUri);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            cropPhoto(Uri.fromFile(file));
        }
        if (i2 == -1 && i == 4114 && intent != null) {
            this.mJSCallback.invoke(this.mPhotoCropFile.getAbsolutePath());
        }
    }

    @Override // com.youku.live.dago.widgetlib.ailproom.protocol.AILPUploadPictureProtocol
    public void uploadPicture(Context context, int i, int i2, JSCallback jSCallback) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "887644139")) {
            ipChange.ipc$dispatch("887644139", new Object[]{this, context, Integer.valueOf(i), Integer.valueOf(i2), jSCallback});
            return;
        }
        this.mContext = context;
        this.mAspectX = i;
        this.mAspectY = i2;
        this.mJSCallback = jSCallback;
        choosePhoto();
    }
}
