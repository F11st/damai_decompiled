package com.alibaba.pictures.share.common.ui.widget;

import com.alibaba.pictures.share.common.share.ShareException;
import com.taobao.weex.bridge.WXBridgeManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH&¨\u0006\u0013"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu;", "", "", "channels", "Ltb/wt2;", "setChannels", "Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu$MenuCallback;", WXBridgeManager.METHOD_CALLBACK, "setMenuCallback", "", "channel", "doSingleChannelShare", "", "isTwoLines", "separateToTwoLines", "", "startDelay", "setAnimation", "MenuCallback", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public interface IShareMenu {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/widget/IShareMenu$MenuCallback;", "", "", "channel", "Ltb/wt2;", "shareStart", "shareComplete", "Lcom/alibaba/pictures/share/common/share/ShareException;", "shareException", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface MenuCallback {
        void shareComplete(int i);

        void shareException(int i, @Nullable ShareException shareException);

        void shareStart(int i);
    }

    void doSingleChannelShare(int i);

    void separateToTwoLines(boolean z);

    void setAnimation(long j);

    void setChannels(@Nullable String str);

    void setMenuCallback(@Nullable MenuCallback menuCallback);
}
