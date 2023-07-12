package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXChannelOpenEvent {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Req extends BaseReq {
        private static final String Key_EventId = "_wxapi_finder_open_event_eventId";
        private static final String Key_ExtInfo = "_wxapi_finder_open_event_extInfo";
        private static final String Key_Username = "_wxapi_finder_open_event_username";
        private static final int LENGTH_LIMIT = 1024;
        private static final String TAG = "MicroMsg.SDK.WXChannelOpenEvent.Req";
        public String eventId;
        public String extInfo;
        public String username;

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public boolean checkArgs() {
            String str;
            if (b.b(this.username)) {
                str = "username is null";
            } else if (this.username.length() > 1024) {
                str = "username exceeds the limit";
            } else if (b.b(this.eventId)) {
                str = "eventId is null";
            } else if (this.eventId.length() <= 1024) {
                return true;
            } else {
                str = "eventId exceeds the limit";
            }
            Log.e(TAG, str);
            return false;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.username = bundle.getString(Key_Username);
            this.eventId = bundle.getString(Key_EventId);
            this.extInfo = bundle.getString(Key_ExtInfo);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public int getType() {
            return 41;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseReq
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(Key_Username, this.username);
            bundle.putString(Key_EventId, this.eventId);
            bundle.putString(Key_ExtInfo, this.extInfo);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class Resp extends BaseResp {
        private static final String Key_ExtMsg = "_wxapi_finder_open_event_extMsg";
        public String extMsg;

        public Resp() {
        }

        public Resp(Bundle bundle) {
            fromBundle(bundle);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public boolean checkArgs() {
            return true;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void fromBundle(Bundle bundle) {
            super.fromBundle(bundle);
            this.extMsg = bundle.getString(Key_ExtMsg);
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public int getType() {
            return 41;
        }

        @Override // com.tencent.mm.opensdk.modelbase.BaseResp
        public void toBundle(Bundle bundle) {
            super.toBundle(bundle);
            bundle.putString(Key_ExtMsg, this.extMsg);
        }
    }
}
