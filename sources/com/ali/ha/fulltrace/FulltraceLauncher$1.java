package com.ali.ha.fulltrace;

import android.app.Application;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.ali.ha.fulltrace.upload.UploadManager;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsKeys;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.weex.devtools.debug.WXDebugConstants;
import com.youku.live.livesdk.preloader.Preloader;
import java.util.HashMap;
import tb.ih0;
import tb.lb1;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
final class FulltraceLauncher$1 implements Runnable {
    final /* synthetic */ Application val$application;

    FulltraceLauncher$1(Application application) {
        this.val$application = application;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("appVersion", ih0.e);
        hashMap.put(Constants.KEY_APP_BUILD, ih0.d);
        hashMap.put(ALBiometricsKeys.KEY_APP_ID, ih0.b);
        hashMap.put("appKey", ih0.c);
        hashMap.put("channel", ih0.f);
        hashMap.put("utdid", ih0.g);
        hashMap.put("userId", ih0.l);
        hashMap.put("userNick", ih0.m);
        hashMap.put("ttid", ih0.q);
        hashMap.put("apmVersion", ih0.a);
        hashMap.put(Preloader.KEY_SESSION, ih0.o);
        hashMap.put(com.taobao.aranger.constant.Constants.PARAM_PROCESS_NAME, ih0.p);
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("brand", ih0.h);
        hashMap2.put(WXDebugConstants.ENV_DEVICE_MODEL, ih0.i);
        hashMap2.put(TbAuthConstants.CLIENT_IP, ih0.n);
        hashMap2.put("os", ih0.j);
        hashMap2.put("osVersion", ih0.k);
        lb1.e(false);
        DumpManager.c().f(this.val$application, hashMap, hashMap2);
        UploadManager.f().i(this.val$application);
    }
}
