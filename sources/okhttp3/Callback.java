package okhttp3;

import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, q qVar) throws IOException;
}
