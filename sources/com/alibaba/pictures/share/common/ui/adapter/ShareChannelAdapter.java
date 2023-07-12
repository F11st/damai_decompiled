package com.alibaba.pictures.share.common.ui.adapter;

import android.content.Context;
import com.alibaba.pictures.share.R$drawable;
import com.alibaba.pictures.share.R$string;
import com.alibaba.pictures.share.ShareManager;
import com.alibaba.pictures.share.common.share.ShareChannel;
import com.alipay.share.sdk.openapi.APAPIFactory;
import com.alipay.share.sdk.openapi.IAPApi;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.text.C8590b;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;
import tb.ob2;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B!\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002R\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/alibaba/pictures/share/common/ui/adapter/ShareChannelAdapter;", "Ljava/util/ArrayList;", "Ltb/ob2;", "Lkotlin/collections/ArrayList;", "", "singleChannel", "Ltb/wt2;", "initChannelItems", "Lcom/alibaba/pictures/share/common/share/ShareChannel;", "channel", "channelIcon", "addChannel", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "", "isLand", "Z", "()Z", "", "channelTypes", "<init>", "(Landroid/content/Context;Ljava/lang/String;Z)V", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class ShareChannelAdapter extends ArrayList<ob2> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final Context context;
    private final boolean isLand;

    public ShareChannelAdapter(@NotNull Context context, @NotNull String str, boolean z) {
        int a;
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        b41.i(str, "channelTypes");
        this.context = context;
        this.isLand = z;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            String valueOf = String.valueOf(str.charAt(i));
            a = C8590b.a(16);
            initChannelItems(Integer.parseInt(valueOf, a));
        }
    }

    private final void addChannel(ShareChannel shareChannel, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1816269627")) {
            ipChange.ipc$dispatch("-1816269627", new Object[]{this, shareChannel, Integer.valueOf(i)});
        } else {
            add(new ob2(shareChannel.value, i, shareChannel.channelName));
        }
    }

    private final void initChannelItems(int i) {
        boolean J;
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-212861840")) {
            ipChange.ipc$dispatch("-212861840", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ShareChannel shareChannel = ShareChannel.WEIXIN;
        if (i == shareChannel.value || i == ShareChannel.ALL.value) {
            addChannel(shareChannel, R$drawable.share_weixin);
        }
        ShareChannel shareChannel2 = ShareChannel.WEIXIN_FRIEND;
        if (i == shareChannel2.value || i == ShareChannel.ALL.value) {
            addChannel(shareChannel2, R$drawable.share_weixin_timeline);
        }
        ShareChannel shareChannel3 = ShareChannel.WEIBO;
        if (i == shareChannel3.value || i == ShareChannel.ALL.value) {
            addChannel(shareChannel3, R$drawable.share_weibo);
        }
        ShareChannel shareChannel4 = ShareChannel.ALIPAY;
        if (i == shareChannel4.value || i == ShareChannel.ALL.value) {
            IAPApi createZFBApi = APAPIFactory.createZFBApi(this.context, ShareManager.INSTANCE.b().a());
            b41.h(createZFBApi, "api");
            if (createZFBApi.isZFBAppInstalled() && createZFBApi.getZFBVersionCode() >= 101) {
                String string = this.context.getResources().getString(R$string.share_name_alipay);
                b41.h(string, "context.getResources().g…string.share_name_alipay)");
                shareChannel4.channelName = string;
                addChannel(shareChannel4, R$drawable.share_alipay);
            } else {
                addChannel(shareChannel4, R$drawable.share_alipay);
            }
        }
        ShareChannel shareChannel5 = ShareChannel.ALIPAY_TIMELINE;
        if (i == shareChannel5.value || i == ShareChannel.ALL.value) {
            IAPApi createZFBApi2 = APAPIFactory.createZFBApi(this.context, ShareManager.INSTANCE.b().a());
            b41.h(createZFBApi2, "api");
            if (!(createZFBApi2.isZFBAppInstalled() && createZFBApi2.getZFBVersionCode() >= 101)) {
                if ((!createZFBApi2.isZFBAppInstalled() || createZFBApi2.getZFBVersionCode() < 84) ? false : false) {
                    addChannel(shareChannel5, R$drawable.share_alipay_timeline);
                }
            }
        }
        ShareChannel shareChannel6 = ShareChannel.QQ;
        if (i == shareChannel6.value || i == ShareChannel.ALL.value) {
            addChannel(shareChannel6, R$drawable.share_qq);
        }
        ShareChannel shareChannel7 = ShareChannel.QZONE;
        if (i == shareChannel7.value || i == ShareChannel.ALL.value) {
            addChannel(shareChannel7, R$drawable.share_qzone);
        }
        ShareChannel shareChannel8 = ShareChannel.COPYLINK;
        if (i == shareChannel8.value || i == ShareChannel.ALL.value) {
            if (this.isLand) {
                addChannel(shareChannel8, R$drawable.share_copy_link_land);
            } else {
                addChannel(shareChannel8, R$drawable.share_copy_link);
            }
        }
        ShareChannel shareChannel9 = ShareChannel.ORIGNALURL;
        if (i == shareChannel9.value || i == ShareChannel.ALL.value) {
            if (this.isLand) {
                addChannel(shareChannel9, R$drawable.share_orignal_url_land);
            } else {
                addChannel(shareChannel9, R$drawable.share_orignal_url);
            }
        }
        ShareChannel shareChannel10 = ShareChannel.SAVELOCAL;
        if (i == shareChannel10.value || i == ShareChannel.ALL.value) {
            if (this.isLand) {
                addChannel(shareChannel10, R$drawable.share_save_local_land);
            } else {
                addChannel(shareChannel10, R$drawable.share_save_local);
            }
        }
        ShareChannel shareChannel11 = ShareChannel.NO_INTERESTED;
        if (i == shareChannel11.value || i == ShareChannel.ALL.value) {
            addChannel(shareChannel11, R$drawable.share_no_interest);
        }
        J = CollectionsKt___CollectionsKt.J(this, shareChannel5);
        if (!J) {
            ShareChannel shareChannel12 = ShareChannel.DD;
            if (i == shareChannel12.value || i == ShareChannel.ALL.value) {
                addChannel(shareChannel12, R$drawable.share_dingding);
            }
        }
        ShareChannel shareChannel13 = ShareChannel.REPORT;
        if (i == shareChannel13.value || i == ShareChannel.ALL.value) {
            if (this.isLand) {
                addChannel(shareChannel13, R$drawable.share_report_land);
            } else {
                addChannel(shareChannel13, R$drawable.share_report);
            }
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1834748959")) {
            return ((Boolean) ipChange.ipc$dispatch("-1834748959", new Object[]{this, obj})).booleanValue();
        }
        if (obj instanceof ob2) {
            return contains((ob2) obj);
        }
        return false;
    }

    @NotNull
    public final Context getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-637504545") ? (Context) ipChange.ipc$dispatch("-637504545", new Object[]{this}) : this.context;
    }

    public /* bridge */ int getSize() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-451223322") ? ((Integer) ipChange.ipc$dispatch("-451223322", new Object[]{this})).intValue() : super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-38415504")) {
            return ((Integer) ipChange.ipc$dispatch("-38415504", new Object[]{this, obj})).intValue();
        }
        if (obj instanceof ob2) {
            return indexOf((ob2) obj);
        }
        return -1;
    }

    public final boolean isLand() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1025011409") ? ((Boolean) ipChange.ipc$dispatch("-1025011409", new Object[]{this})).booleanValue() : this.isLand;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1741993306")) {
            return ((Integer) ipChange.ipc$dispatch("-1741993306", new Object[]{this, obj})).intValue();
        }
        if (obj instanceof ob2) {
            return lastIndexOf((ob2) obj);
        }
        return -1;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ ob2 remove(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-592720298") ? (ob2) ipChange.ipc$dispatch("-592720298", new Object[]{this, Integer.valueOf(i)}) : removeAt(i);
    }

    public /* bridge */ ob2 removeAt(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-635974935") ? (ob2) ipChange.ipc$dispatch("-635974935", new Object[]{this, Integer.valueOf(i)}) : (ob2) super.remove(i);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "250331794") ? ((Integer) ipChange.ipc$dispatch("250331794", new Object[]{this})).intValue() : getSize();
    }

    public /* bridge */ boolean contains(ob2 ob2Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-387185086") ? ((Boolean) ipChange.ipc$dispatch("-387185086", new Object[]{this, ob2Var})).booleanValue() : super.contains((Object) ob2Var);
    }

    public /* bridge */ int indexOf(ob2 ob2Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2137092753") ? ((Integer) ipChange.ipc$dispatch("2137092753", new Object[]{this, ob2Var})).intValue() : super.indexOf((Object) ob2Var);
    }

    public /* bridge */ int lastIndexOf(ob2 ob2Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "38355099") ? ((Integer) ipChange.ipc$dispatch("38355099", new Object[]{this, ob2Var})).intValue() : super.lastIndexOf((Object) ob2Var);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1304492380")) {
            return ((Boolean) ipChange.ipc$dispatch("1304492380", new Object[]{this, obj})).booleanValue();
        }
        if (obj instanceof ob2) {
            return remove((ob2) obj);
        }
        return false;
    }

    public /* bridge */ boolean remove(ob2 ob2Var) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-575395993") ? ((Boolean) ipChange.ipc$dispatch("-575395993", new Object[]{this, ob2Var})).booleanValue() : super.remove((Object) ob2Var);
    }

    public /* synthetic */ ShareChannelAdapter(Context context, String str, boolean z, int i, k50 k50Var) {
        this(context, str, (i & 4) != 0 ? false : z);
    }
}
