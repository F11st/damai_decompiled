package com.alipay.share.sdk.openapi;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import com.alipay.share.sdk.Constant;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class APMediaMessage {
    public String description;
    public IMediaObject mediaObject;
    public int sdkVer;
    public byte[] thumbData;
    public String thumbUrl;
    public String title;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class Builder {
        public static APMediaMessage fromBundle(Bundle bundle) {
            APMediaMessage aPMediaMessage = new APMediaMessage();
            aPMediaMessage.sdkVer = bundle.getInt(Constant.EXTRA_AP_OBJECT_SDK_VERSION);
            aPMediaMessage.title = bundle.getString(Constant.EXTRA_AP_OBJECT_TITLE);
            aPMediaMessage.description = bundle.getString(Constant.EXTRA_AP_OBJECT_DESCRIPTION);
            aPMediaMessage.thumbData = bundle.getByteArray(Constant.EXTRA_AP_OBJECT_THUMB_DATA);
            aPMediaMessage.thumbUrl = bundle.getString(Constant.EXTRA_AP_OBJECT_THUMB_URL);
            String string = bundle.getString(Constant.EXTRA_AP_OBJECT_IDENTIFIER);
            if (string != null && string.length() > 0) {
                try {
                    IMediaObject iMediaObject = (IMediaObject) Class.forName(string).newInstance();
                    aPMediaMessage.mediaObject = iMediaObject;
                    iMediaObject.unserialize(bundle);
                    return aPMediaMessage;
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("APSDK.ZFBMediaMessage", "get media object from bundle failed: unknown ident " + string);
                }
            }
            return aPMediaMessage;
        }

        public static Bundle toBundle(APMediaMessage aPMediaMessage) {
            Bundle bundle = new Bundle();
            bundle.putInt(Constant.EXTRA_AP_OBJECT_SDK_VERSION, aPMediaMessage.sdkVer);
            bundle.putString(Constant.EXTRA_AP_OBJECT_TITLE, aPMediaMessage.title);
            bundle.putString(Constant.EXTRA_AP_OBJECT_DESCRIPTION, aPMediaMessage.description);
            bundle.putByteArray(Constant.EXTRA_AP_OBJECT_THUMB_DATA, aPMediaMessage.thumbData);
            bundle.putString(Constant.EXTRA_AP_OBJECT_THUMB_URL, aPMediaMessage.thumbUrl);
            IMediaObject iMediaObject = aPMediaMessage.mediaObject;
            if (iMediaObject != null) {
                bundle.putString(Constant.EXTRA_AP_OBJECT_IDENTIFIER, iMediaObject.getClass().getSimpleName());
                aPMediaMessage.mediaObject.serialize(bundle);
            }
            return bundle;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface IMediaObject {
        public static final int TYPE_FUND = 122;
        public static final int TYPE_IMAGE = 14;
        public static final int TYPE_STOCK = 120;
        public static final int TYPE_TAOBAO_GOODS = 1010;
        public static final int TYPE_TEXT = 11;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 1001;

        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public APMediaMessage() {
        this(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        byte[] bArr = this.thumbData;
        if (bArr != null && bArr.length > 32768) {
            Log.e("APSDK.ZFBMediaMessage", "checkArgs fail, thumbData is invalid");
            return false;
        }
        String str = this.title;
        if (str != null && str.length() > 512) {
            Log.e("APSDK.ZFBMediaMessage", "checkArgs fail, title is invalid");
            return false;
        }
        String str2 = this.description;
        if (str2 != null && str2.length() > 1024) {
            Log.e("APSDK.ZFBMediaMessage", "checkArgs fail, description is invalid");
            return false;
        }
        IMediaObject iMediaObject = this.mediaObject;
        if (iMediaObject == null) {
            Log.e("APSDK.ZFBMediaMessage", "checkArgs fail, mediaObject is null");
            return false;
        }
        return iMediaObject.checkArgs();
    }

    public final int getType() {
        IMediaObject iMediaObject = this.mediaObject;
        if (iMediaObject == null) {
            return 0;
        }
        return iMediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception unused) {
            Log.e("APSDK.ZFBMediaMessage", "put thumb failed");
        }
    }

    public APMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }
}
