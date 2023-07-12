package com.alipay.share.sdk.openapi;

import android.os.Bundle;
import android.util.Log;
import com.alipay.share.sdk.Constant;
import com.alipay.share.sdk.openapi.APMediaMessage;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SendMessageToZFB {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class Resp extends BaseResp {
        public Resp() {
        }

        @Override // com.alipay.share.sdk.openapi.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.alipay.share.sdk.openapi.BaseResp
        public int getType() {
            return 1;
        }

        @Override // com.alipay.share.sdk.openapi.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class Req extends BaseReq {
        public static final int ZFBSceneSession = 0;
        public static final int ZFBSceneTimeLine = 1;
        public APMediaMessage message;
        public int scene = 0;

        public Req() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.alipay.share.sdk.openapi.BaseReq
        public final boolean a() {
            APMediaMessage aPMediaMessage = this.message;
            if (aPMediaMessage == null) {
                Log.e("APSDK.SendToZFB.Req", "checkArgs fail ,message is null");
                return false;
            }
            return aPMediaMessage.a();
        }

        @Override // com.alipay.share.sdk.openapi.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.message = APMediaMessage.Builder.fromBundle(bundle);
            this.scene = bundle.getInt(Constant.EXTRA_SEND_MESSAGE_SCENE);
        }

        @Override // com.alipay.share.sdk.openapi.BaseReq
        public int getType() {
            return 1;
        }

        @Override // com.alipay.share.sdk.openapi.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putAll(APMediaMessage.Builder.toBundle(this.message));
            bundle.putInt(Constant.EXTRA_SEND_MESSAGE_SCENE, this.scene);
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }
    }
}
