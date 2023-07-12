package com.taobao.accs;

import android.content.Context;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.OrangeAdapter;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.aranger.core.ipc.provider.ARangerProvider;
import tb.hu0;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AccsIPCProvider extends ARangerProvider {
    @Override // com.taobao.aranger.core.ipc.provider.ARangerProvider, android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        GlobalClientInfo.mContext = context;
        UtilityImpl.debug(context);
        if (OrangeAdapter.isChannelModeEnable()) {
            hu0.k(false);
        }
        return super.onCreate();
    }
}
