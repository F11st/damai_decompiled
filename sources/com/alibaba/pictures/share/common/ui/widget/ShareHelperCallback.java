package com.alibaba.pictures.share.common.ui.widget;

import com.alibaba.pictures.share.common.share.ShareException;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¨\u0006\t"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/widget/ShareHelperCallback;", "", "", "channel", "Ltb/wt2;", "shareComplete", "Lcom/alibaba/pictures/share/common/share/ShareException;", "exception", "shareException", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public interface ShareHelperCallback {
    void shareComplete(int i);

    void shareException(int i, @Nullable ShareException shareException);
}
