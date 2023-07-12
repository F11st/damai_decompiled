package com.alibaba.wireless.security.open.securityguardaccsadapter;

import android.content.Context;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.client.GlobalClientInfo;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AccsAdapter {
    private static final boolean DEBUG = false;
    private static final String TAG = "AccsAdapter";
    public static Context gContext;

    public static void registerListner(Context context) {
        if (context != null) {
            gContext = context;
            GlobalClientInfo.getInstance(context).registerListener("securityguard_accs_service", (AccsAbstractDataListener) new AccsListner());
            GlobalClientInfo.getInstance(context).registerListener("security-nash-web", (AccsAbstractDataListener) new AccsListnerBshop(gContext));
        }
    }
}
