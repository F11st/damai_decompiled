package mtopsdk.network.impl;

import android.content.Context;
import mtopsdk.network.Call;
import mtopsdk.network.domain.Request;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ANetworkCallFactory implements Call.Factory {
    private Context mContext;

    public ANetworkCallFactory(Context context) {
        this.mContext = context;
    }

    @Override // mtopsdk.network.Call.Factory
    public Call newCall(Request request) {
        return new ANetworkCallImpl(request, this.mContext);
    }
}
