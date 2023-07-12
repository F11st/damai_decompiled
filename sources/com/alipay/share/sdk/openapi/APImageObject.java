package com.alipay.share.sdk.openapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.alipay.share.sdk.Constant;
import com.alipay.share.sdk.openapi.APMediaMessage;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class APImageObject implements APMediaMessage.IMediaObject {
    public byte[] imageData;
    public String imagePath;
    public String imageUrl;

    public APImageObject() {
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0061  */
    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkArgs() {
        /*
            r7 = this;
            byte[] r0 = r7.imageData
            java.lang.String r1 = "APSDK.ZFBImageObject"
            r2 = 0
            if (r0 == 0) goto La
            int r0 = r0.length
            if (r0 != 0) goto L1f
        La:
            java.lang.String r0 = r7.imagePath
            if (r0 == 0) goto L14
            int r0 = r0.length()
            if (r0 != 0) goto L1f
        L14:
            java.lang.String r0 = r7.imageUrl
            if (r0 == 0) goto L79
            int r0 = r0.length()
            if (r0 != 0) goto L1f
            goto L79
        L1f:
            byte[] r0 = r7.imageData
            r3 = 10485760(0xa00000, float:1.469368E-38)
            if (r0 == 0) goto L2e
            int r0 = r0.length
            if (r0 <= r3) goto L2e
            java.lang.String r0 = "checkArgs fail, content is too large"
            android.util.Log.e(r1, r0)
            return r2
        L2e:
            java.lang.String r0 = r7.imagePath
            r4 = 10240(0x2800, float:1.4349E-41)
            if (r0 == 0) goto L40
            int r0 = r0.length()
            if (r0 <= r4) goto L40
            java.lang.String r0 = "checkArgs fail, path is invalid"
            android.util.Log.e(r1, r0)
            return r2
        L40:
            java.lang.String r0 = r7.imagePath
            if (r0 == 0) goto L67
            if (r0 == 0) goto L5e
            int r5 = r0.length()
            if (r5 == 0) goto L5e
            java.io.File r5 = new java.io.File
            r5.<init>(r0)
            boolean r0 = r5.exists()
            if (r0 != 0) goto L58
            goto L5e
        L58:
            long r5 = r5.length()
            int r0 = (int) r5
            goto L5f
        L5e:
            r0 = 0
        L5f:
            if (r0 <= r3) goto L67
            java.lang.String r0 = "checkArgs fail, image content is too large"
            android.util.Log.e(r1, r0)
            return r2
        L67:
            java.lang.String r0 = r7.imageUrl
            if (r0 == 0) goto L77
            int r0 = r0.length()
            if (r0 <= r4) goto L77
            java.lang.String r0 = "checkArgs fail, url is invalid"
            android.util.Log.e(r1, r0)
            return r2
        L77:
            r0 = 1
            return r0
        L79:
            java.lang.String r0 = "checkArgs fail, all arguments are null"
            android.util.Log.e(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.share.sdk.openapi.APImageObject.checkArgs():boolean");
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray(Constant.EXTRA_IMAGE_OBJECT_IMAGE_DATA, this.imageData);
        bundle.putString(Constant.EXTRA_IMAGE_OBJECT_IMAGE_PATH, this.imagePath);
        bundle.putString(Constant.EXTRA_IMAGE_OBJECT_IMAGE_URL, this.imageUrl);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public int type() {
        return 14;
    }

    @Override // com.alipay.share.sdk.openapi.APMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray(Constant.EXTRA_IMAGE_OBJECT_IMAGE_DATA);
        this.imagePath = bundle.getString(Constant.EXTRA_IMAGE_OBJECT_IMAGE_PATH);
        this.imageUrl = bundle.getString(Constant.EXTRA_IMAGE_OBJECT_IMAGE_URL);
    }

    public APImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    public APImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception unused) {
        }
    }
}
