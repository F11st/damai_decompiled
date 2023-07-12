package mtopsdk.network;

import mtopsdk.network.domain.Response;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface NetworkCallback {
    void onCancel(Call call);

    void onFailure(Call call, Exception exc);

    void onResponse(Call call, Response response);
}
