package com.alibaba.pictures.share.common.ui;

import android.content.Context;
import com.alibaba.pictures.share.common.share.ShareContent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u000fB\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/MovieShowShareDialog;", "Lcom/alibaba/pictures/share/common/ui/BaseShareDialogFragment;", "", "shareChannel", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "getShareContentInfo", "Lcom/alibaba/pictures/share/common/ui/MovieShowShareDialog$IShareAction;", "iShareAction", "Lcom/alibaba/pictures/share/common/ui/MovieShowShareDialog$IShareAction;", "getIShareAction", "()Lcom/alibaba/pictures/share/common/ui/MovieShowShareDialog$IShareAction;", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "<init>", "(Landroid/content/Context;Lcom/alibaba/pictures/share/common/ui/MovieShowShareDialog$IShareAction;)V", "IShareAction", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public class MovieShowShareDialog extends BaseShareDialogFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private final IShareAction iShareAction;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/MovieShowShareDialog$IShareAction;", "", "", "shareChannel", "Lcom/alibaba/pictures/share/common/share/ShareContent;", "getShareInfo", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public interface IShareAction {
        @NotNull
        ShareContent getShareInfo(int i);
    }

    public MovieShowShareDialog(@NotNull Context context, @Nullable IShareAction iShareAction) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.iShareAction = iShareAction;
    }

    @Nullable
    public final IShareAction getIShareAction() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-399226402") ? (IShareAction) ipChange.ipc$dispatch("-399226402", new Object[]{this}) : this.iShareAction;
    }

    @Override // com.alibaba.pictures.share.common.ui.BaseShareDialogFragment
    @Nullable
    public ShareContent getShareContentInfo(int i) {
        ShareContent shareInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "466472786")) {
            return (ShareContent) ipChange.ipc$dispatch("466472786", new Object[]{this, Integer.valueOf(i)});
        }
        IShareAction iShareAction = this.iShareAction;
        return (iShareAction == null || (shareInfo = iShareAction.getShareInfo(i)) == null) ? this.shareContent : shareInfo;
    }

    public /* synthetic */ MovieShowShareDialog(Context context, IShareAction iShareAction, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : iShareAction);
    }
}
