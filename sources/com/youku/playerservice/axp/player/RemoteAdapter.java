package com.youku.playerservice.axp.player;

import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.media.arch.instruments.utils.RemoteLogger;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class RemoteAdapter implements RemoteLogger.IRemoteAdapter {
    private static RemoteLogger.IRemoteAdapter remoteAdapter = new RemoteAdapter();

    private RemoteAdapter() {
    }

    public static RemoteLogger.IRemoteAdapter getInstance() {
        return remoteAdapter;
    }

    @Override // com.youku.media.arch.instruments.utils.RemoteLogger.IRemoteAdapter
    public void log(String str, String str2) {
        AdapterForTLog.loge(str, str2);
    }
}
