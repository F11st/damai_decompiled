package com.android.dingtalk.share.ddsharemodule.message;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.android.dingtalk.share.ddsharemodule.ShareConstant;
import com.android.dingtalk.share.ddsharemodule.message.DDMediaMessage;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SendMessageToDD {

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class Resp extends BaseResp {
        public Resp() {
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseResp
        final boolean checkArgs() {
            return true;
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseResp
        public int getType() {
            return 1;
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseResp
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
        public static final int DDSceneSession = 0;
        private static final String TAG = "SendMessageToDD.Req";
        public DDMediaMessage mMediaMessage;
        private int mScene = 0;

        public Req() {
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public void attachContext(Context context) {
            DDMediaMessage dDMediaMessage = this.mMediaMessage;
            if (dDMediaMessage != null) {
                dDMediaMessage.attachContext(context);
            }
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public final boolean checkArgs() {
            DDMediaMessage dDMediaMessage = this.mMediaMessage;
            if (dDMediaMessage == null) {
                Log.e(TAG, "checkArgs fail ,message is null");
                return false;
            }
            return dDMediaMessage.checkArgs();
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            if (bundle != null) {
                this.mMediaMessage = DDMediaMessage.Builder.fromBundle(bundle);
                this.mScene = bundle.getInt(ShareConstant.EXTRA_SEND_MESSAGE_SCENE);
            }
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public int getSupportVersion() {
            DDMediaMessage dDMediaMessage = this.mMediaMessage;
            if (dDMediaMessage == null) {
                return Integer.MAX_VALUE;
            }
            return dDMediaMessage.getSupportVersion();
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public int getType() {
            return this.mMediaMessage.getType();
        }

        @Override // com.android.dingtalk.share.ddsharemodule.message.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            if (bundle != null) {
                bundle.putAll(DDMediaMessage.Builder.toBundle(this.mMediaMessage));
                bundle.putInt(ShareConstant.EXTRA_SEND_MESSAGE_SCENE, this.mScene);
            }
        }

        public Req(Bundle bundle) {
            fromBundle(bundle);
        }
    }
}
