package com.alibaba.pictures.share.common.share;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class ShareService {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\t"}, d2 = {"Lcom/alibaba/pictures/share/common/share/ShareService$ShareActionListener;", "", "Lcom/alibaba/pictures/share/common/share/ShareChannel;", "shareChannel", "Ltb/wt2;", "onComplete", "Lcom/alibaba/pictures/share/common/share/ShareException;", "exception", "onException", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface ShareActionListener {
        void onComplete(@Nullable ShareChannel shareChannel);

        void onException(@Nullable ShareChannel shareChannel, @Nullable ShareException shareException);
    }

    @Nullable
    public abstract ShareActionListener a();

    public abstract void b(@Nullable Context context, @Nullable ShareContent shareContent, @Nullable ShareChannel shareChannel, @Nullable String str);
}
