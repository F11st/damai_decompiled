package mtopsdk.mtop.cache.handler;

import android.os.Handler;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.ResponseSource;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class EmptyCacheParser implements ICacheParser {
    private static final String TAG = "mtopsdk.EmptyCacheParser";

    @Override // mtopsdk.mtop.cache.handler.ICacheParser
    public void parse(ResponseSource responseSource, Handler handler) {
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[parse]EmptyCacheParser parse called");
        }
    }
}
