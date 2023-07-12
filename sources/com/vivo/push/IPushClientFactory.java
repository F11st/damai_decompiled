package com.vivo.push;

import android.content.Intent;
import com.vivo.push.d.AbstractC7480z;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IPushClientFactory {
    AbstractC7480z createReceiveTask(AbstractC7496o abstractC7496o);

    AbstractC7496o createReceiverCommand(Intent intent);

    AbstractRunnableC7491l createTask(AbstractC7496o abstractC7496o);
}
