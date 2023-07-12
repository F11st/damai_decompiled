package com.alibaba.pictures.share.common.share;

import cn.damai.uikit.view.BottomActionDialog;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0019\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/alibaba/pictures/share/common/share/ShareChannel;", "", "", "getHexValueString", "", "value", "I", "channelName", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "Companion", "a", "NONE", "WEIXIN", "WEIXIN_FRIEND", "ALIPAY", "DD", "WEIBO", Constants.SOURCE_QQ, "QZONE", "ALIPAY_TIMELINE", "ALL", "SAVELOCAL", "NO_INTERESTED", "COPYLINK", "ORIGNALURL", "REPORT", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public enum ShareChannel {
    NONE(0, ""),
    WEIXIN(1, "微信好友"),
    WEIXIN_FRIEND(2, "朋友圈"),
    ALIPAY(3, "支付宝好友"),
    DD(4, "钉钉"),
    WEIBO(5, "微博"),
    QQ(6, Constants.SOURCE_QQ),
    QZONE(7, "QQ空间"),
    ALIPAY_TIMELINE(8, "生活圈"),
    ALL(10, ""),
    SAVELOCAL(11, "保存到手机"),
    NO_INTERESTED(12, "不感兴趣"),
    COPYLINK(13, "复制链接"),
    ORIGNALURL(14, "查看原链接"),
    REPORT(15, BottomActionDialog.REPORT);
    
    @NotNull
    public static final C3631a Companion = new C3631a(null);
    @JvmField
    @NotNull
    public String channelName;
    @JvmField
    public final int value;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.share.common.share.ShareChannel$a */
    /* loaded from: classes8.dex */
    public static final class C3631a {
        private static transient /* synthetic */ IpChange $ipChange;

        private C3631a() {
        }

        public /* synthetic */ C3631a(k50 k50Var) {
            this();
        }
    }

    ShareChannel(int i, String str) {
        this.value = i;
        this.channelName = str;
    }

    @NotNull
    public String getHexValueString() {
        String hexString = Integer.toHexString(this.value);
        b41.h(hexString, "Integer.toHexString(value)");
        return hexString;
    }
}
