package com.taobao.tao.remotebusiness.handler;

import android.os.Handler;
import android.os.Looper;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.common.MtopEvent;
import mtopsdk.mtop.common.MtopListener;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class HandlerMgr extends Handler {
    public static final int ON_CACHED = 4;
    public static final int ON_DATA_RECEIVED = 1;
    public static final int ON_FINISHED = 3;
    public static final int ON_HEADER = 2;
    private static final String TAG = "mtopsdk.HandlerMgr";
    private static volatile Handler mHandler;

    private HandlerMgr(Looper looper) {
        super(looper);
    }

    public static HandlerParam getHandlerMsg(MtopListener mtopListener, MtopEvent mtopEvent, MtopBusiness mtopBusiness) {
        return new HandlerParam(mtopListener, mtopEvent, mtopBusiness);
    }

    public static Handler instance() {
        if (mHandler == null) {
            synchronized (HandlerMgr.class) {
                if (mHandler == null) {
                    mHandler = new HandlerMgr(Looper.getMainLooper());
                }
            }
        }
        return mHandler;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00bf -> B:97:0x003c). Please submit an issue!!! */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleMessage(android.os.Message r17) {
        /*
            Method dump skipped, instructions count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.tao.remotebusiness.handler.HandlerMgr.handleMessage(android.os.Message):void");
    }
}
