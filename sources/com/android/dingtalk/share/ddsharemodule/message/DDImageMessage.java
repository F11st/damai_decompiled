package com.android.dingtalk.share.ddsharemodule.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DDImageMessage extends BaseMediaObject {
    private static final int MAX_IMAGE_DATA_LENGTH = 10485760;
    private static final int MAX_IMAGE_THUMB_DATA_LENGTH = 32768;
    private static final int MAX_IMAGE_URL_LENGTH = 10240;
    private static final String TAG = "DDImageMessage";
    public byte[] mImageData;
    public String mImagePath;
    public Uri mImageUri;
    public String mImageUrl;

    public DDImageMessage() {
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void attachContext(Context context) {
        Uri uri;
        if (context == null || (uri = this.mImageUri) == null) {
            return;
        }
        try {
            context.grantUriPermission(ShareConstant.DD_APP_PACKAGE, uri, 1);
            context.grantUriPermission(ShareConstant.ALI_DD_APP_PACKAGE, this.mImageUri, 1);
        } catch (Throwable th) {
            Log.e(TAG, "attachContext: ", th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0062  */
    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkArgs() {
        /*
            r7 = this;
            byte[] r0 = r7.mImageData
            java.lang.String r1 = "DDImageMessage"
            r2 = 0
            if (r0 == 0) goto La
            int r0 = r0.length
            if (r0 != 0) goto L22
        La:
            java.lang.String r0 = r7.mImagePath
            if (r0 == 0) goto L14
            int r0 = r0.length()
            if (r0 != 0) goto L22
        L14:
            java.lang.String r0 = r7.mImageUrl
            if (r0 == 0) goto L1e
            int r0 = r0.length()
            if (r0 != 0) goto L22
        L1e:
            android.net.Uri r0 = r7.mImageUri
            if (r0 == 0) goto L7a
        L22:
            byte[] r0 = r7.mImageData
            r3 = 10485760(0xa00000, float:1.469368E-38)
            if (r0 == 0) goto L31
            int r0 = r0.length
            if (r0 <= r3) goto L31
            java.lang.String r0 = "checkArgs fail, content is too large"
            android.util.Log.e(r1, r0)
            return r2
        L31:
            java.lang.String r0 = r7.mImagePath
            r4 = 10240(0x2800, float:1.4349E-41)
            if (r0 == 0) goto L43
            int r0 = r0.length()
            if (r0 <= r4) goto L43
            java.lang.String r0 = "checkArgs fail, path is invalid"
            android.util.Log.e(r1, r0)
            return r2
        L43:
            java.lang.String r0 = r7.mImagePath
            if (r0 == 0) goto L68
            int r5 = r0.length()
            if (r5 == 0) goto L5f
            java.io.File r5 = new java.io.File
            r5.<init>(r0)
            boolean r0 = r5.exists()
            if (r0 != 0) goto L59
            goto L5f
        L59:
            long r5 = r5.length()
            int r0 = (int) r5
            goto L60
        L5f:
            r0 = 0
        L60:
            if (r0 <= r3) goto L68
            java.lang.String r0 = "checkArgs fail, image content is too large"
            android.util.Log.e(r1, r0)
            return r2
        L68:
            java.lang.String r0 = r7.mImageUrl
            if (r0 == 0) goto L78
            int r0 = r0.length()
            if (r0 <= r4) goto L78
            java.lang.String r0 = "checkArgs fail, url is invalid"
            android.util.Log.e(r1, r0)
            return r2
        L78:
            r0 = 1
            return r0
        L7a:
            java.lang.String r0 = "checkArgs fail, all arguments are null"
            android.util.Log.e(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.dingtalk.share.ddsharemodule.message.DDImageMessage.checkArgs():boolean");
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int getSupportVersion() {
        return ShareConstant.DINGDING_SDK_SHARE_VERSION_V1;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putByteArray(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_DATA, this.mImageData);
        bundle.putString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_PATH, this.mImagePath);
        bundle.putString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URL, this.mImageUrl);
        bundle.putParcelable(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URI, this.mImageUri);
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public int type() {
        return 3;
    }

    @Override // com.android.dingtalk.share.ddsharemodule.message.BaseMediaObject, com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mImageData = bundle.getByteArray(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_DATA);
        this.mImagePath = bundle.getString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_PATH);
        this.mImageUrl = bundle.getString(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URL);
        this.mImageUri = (Uri) bundle.getParcelable(ShareConstant.EXTRA_IMAGE_OBJECT_IMAGE_URI);
    }

    public DDImageMessage(byte[] bArr) {
        this.mImageData = bArr;
    }

    public DDImageMessage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream);
            this.mImageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
