package com.alibaba.pictures.share.common.share;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.pictures.share.ShareManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 F2\u00020\u0001:\u0002GHB\u0007¢\u0006\u0004\bD\u0010EJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\t\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R.\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R&\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00020 j\b\u0012\u0004\u0012\u00020\u0002`!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010\u000f\u001a\u0004\b,\u0010\u0011\"\u0004\b-\u0010\u0013R$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0015\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0015\u001a\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019R$\u0010;\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0015\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019R$\u0010>\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u0015\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u0019R\"\u0010A\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010\u000f\u001a\u0004\bB\u0010\u0011\"\u0004\bC\u0010\u0013¨\u0006I"}, d2 = {"Lcom/alibaba/pictures/share/common/share/ShareContent;", "Ljava/io/Serializable;", "", "toString", "url", "Ltb/wt2;", "addImage", "Landroid/graphics/Bitmap;", "bitmap", "getDefaultImage", "getImage", "", "getImgUrls", "", "shareType", "I", "getShareType", "()I", "setShareType", "(I)V", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "content", "getContent", "setContent", "value", "getUrl", "setUrl", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "imgUrls", "Ljava/util/ArrayList;", "", "extraInfo", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "setExtraInfo", "(Ljava/util/Map;)V", "typeIconId", "getTypeIconId", "setTypeIconId", "Lcom/alibaba/pictures/share/common/share/ShareContent$ShareContentKind;", "kind", "Lcom/alibaba/pictures/share/common/share/ShareContent$ShareContentKind;", "getKind", "()Lcom/alibaba/pictures/share/common/share/ShareContent$ShareContentKind;", "setKind", "(Lcom/alibaba/pictures/share/common/share/ShareContent$ShareContentKind;)V", "url4UT", "getUrl4UT", "setUrl4UT", "miniUrl", "getMiniUrl", "setMiniUrl", "shareMode", "getShareMode", "setShareMode", "from", "getFrom", "setFrom", "imageMaxSizeKb", "getImageMaxSizeKb", "setImageMaxSizeKb", "<init>", "()V", "Companion", "a", "ShareContentKind", "share_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes8.dex */
public final class ShareContent implements Serializable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C3632a Companion = new C3632a(null);
    public static final int SHARE_TYPE_IMG = 1;
    public static final int SHARE_TYPE_TEXT = 0;
    public static final int SHARE_TYPE_VIDEO = 3;
    public static final int SHARE_TYPE_WEB = 2;
    public static final int SHARE_TYPE_WEXIN_MINI_APP = 4;
    private static final long serialVersionUID = 1;
    @Nullable
    private String content;
    @Nullable
    private Map<String, String> extraInfo;
    @Nullable
    private String from;
    @Nullable
    private ShareContentKind kind;
    @Nullable
    private String miniUrl;
    @Nullable
    private String shareMode;
    @Nullable
    private String title;
    private int typeIconId;
    @Nullable
    private String url;
    @Nullable
    private String url4UT;
    private int shareType = 2;
    private ArrayList<String> imgUrls = new ArrayList<>();
    private int imageMaxSizeKb = 1000;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/alibaba/pictures/share/common/share/ShareContent$ShareContentKind;", "Ljava/io/Serializable;", "", "value", "Ljava/lang/Integer;", "", "name", "Ljava/lang/String;", "<init>", "()V", "share_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes8.dex */
    public static final class ShareContentKind implements Serializable {
        @JvmField
        @Nullable
        public String name;
        @JvmField
        @Nullable
        public Integer value;
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.share.common.share.ShareContent$a */
    /* loaded from: classes8.dex */
    public static final class C3632a {
        private C3632a() {
        }

        public /* synthetic */ C3632a(k50 k50Var) {
            this();
        }
    }

    public final void addImage(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-206573238")) {
            ipChange.ipc$dispatch("-206573238", new Object[]{this, str});
        } else {
            addImage(str, null);
        }
    }

    @Nullable
    public final String getContent() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "838924009") ? (String) ipChange.ipc$dispatch("838924009", new Object[]{this}) : this.content;
    }

    @Nullable
    public final Bitmap getDefaultImage() {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1166614302")) {
            return (Bitmap) ipChange.ipc$dispatch("1166614302", new Object[]{this});
        }
        ArrayList<String> arrayList = this.imgUrls;
        if (arrayList != null && !arrayList.isEmpty()) {
            z = false;
        }
        if (z) {
            return getImage(ShareManager.INSTANCE.b().h());
        }
        String str = this.imgUrls.get(0);
        b41.h(str, "imgUrls[0]");
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return getImage(str2);
    }

    @Nullable
    public final Map<String, String> getExtraInfo() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-468774905") ? (Map) ipChange.ipc$dispatch("-468774905", new Object[]{this}) : this.extraInfo;
    }

    @Nullable
    public final String getFrom() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1333992592") ? (String) ipChange.ipc$dispatch("-1333992592", new Object[]{this}) : this.from;
    }

    @Nullable
    public final Bitmap getImage(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "570040733")) {
            return (Bitmap) ipChange.ipc$dispatch("570040733", new Object[]{this, str});
        }
        ShareManager.IBitmapManager l = ShareManager.INSTANCE.b().l();
        if (l != null) {
            return l.getBitmap(str);
        }
        return null;
    }

    public final int getImageMaxSizeKb() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1491238028") ? ((Integer) ipChange.ipc$dispatch("1491238028", new Object[]{this})).intValue() : this.imageMaxSizeKb;
    }

    @NotNull
    public final List<String> getImgUrls() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1827873310") ? (List) ipChange.ipc$dispatch("1827873310", new Object[]{this}) : this.imgUrls;
    }

    @Nullable
    public final ShareContentKind getKind() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "772628554") ? (ShareContentKind) ipChange.ipc$dispatch("772628554", new Object[]{this}) : this.kind;
    }

    @Nullable
    public final String getMiniUrl() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1573375352") ? (String) ipChange.ipc$dispatch("-1573375352", new Object[]{this}) : this.miniUrl;
    }

    @Nullable
    public final String getShareMode() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "352130258") ? (String) ipChange.ipc$dispatch("352130258", new Object[]{this}) : this.shareMode;
    }

    public final int getShareType() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1499798666") ? ((Integer) ipChange.ipc$dispatch("1499798666", new Object[]{this})).intValue() : this.shareType;
    }

    @Nullable
    public final String getTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "272417928") ? (String) ipChange.ipc$dispatch("272417928", new Object[]{this}) : this.title;
    }

    public final int getTypeIconId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1595365695") ? ((Integer) ipChange.ipc$dispatch("1595365695", new Object[]{this})).intValue() : this.typeIconId;
    }

    @Nullable
    public final String getUrl() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-265106593")) {
            return (String) ipChange.ipc$dispatch("-265106593", new Object[]{this});
        }
        String str2 = this.url;
        if (str2 != null) {
            if ((str2.length() > 0) && (str = this.url) != null) {
                C8604o.z(str, "&amp;", "&", false, 4, null);
            }
        }
        return this.url;
    }

    @Nullable
    public final String getUrl4UT() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1416452598") ? (String) ipChange.ipc$dispatch("-1416452598", new Object[]{this}) : this.url4UT;
    }

    public final void setContent(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1379413075")) {
            ipChange.ipc$dispatch("-1379413075", new Object[]{this, str});
        } else {
            this.content = str;
        }
    }

    public final void setExtraInfo(@Nullable Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649630361")) {
            ipChange.ipc$dispatch("-1649630361", new Object[]{this, map});
        } else {
            this.extraInfo = map;
        }
    }

    public final void setFrom(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1303145838")) {
            ipChange.ipc$dispatch("1303145838", new Object[]{this, str});
        } else {
            this.from = str;
        }
    }

    public final void setImageMaxSizeKb(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1519979414")) {
            ipChange.ipc$dispatch("1519979414", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.imageMaxSizeKb = i;
        }
    }

    public final void setKind(@Nullable ShareContentKind shareContentKind) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1691457382")) {
            ipChange.ipc$dispatch("-1691457382", new Object[]{this, shareContentKind});
        } else {
            this.kind = shareContentKind;
        }
    }

    public final void setMiniUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1148718062")) {
            ipChange.ipc$dispatch("1148718062", new Object[]{this, str});
        } else {
            this.miniUrl = str;
        }
    }

    public final void setShareMode(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "360898532")) {
            ipChange.ipc$dispatch("360898532", new Object[]{this, str});
        } else {
            this.shareMode = str;
        }
    }

    public final void setShareType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1712672704")) {
            ipChange.ipc$dispatch("1712672704", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.shareType = i;
        }
    }

    public final void setTitle(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1948578578")) {
            ipChange.ipc$dispatch("-1948578578", new Object[]{this, str});
        } else {
            this.title = str;
        }
    }

    public final void setTypeIconId(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1271573315")) {
            ipChange.ipc$dispatch("1271573315", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.typeIconId = i;
        }
    }

    public final void setUrl(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1790178295")) {
            ipChange.ipc$dispatch("1790178295", new Object[]{this, str});
            return;
        }
        this.url = str;
        this.url4UT = str;
    }

    public final void setUrl4UT(@Nullable String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1939517716")) {
            ipChange.ipc$dispatch("1939517716", new Object[]{this, str});
        } else {
            this.url4UT = str;
        }
    }

    @NotNull
    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1556839086")) {
            return (String) ipChange.ipc$dispatch("-1556839086", new Object[]{this});
        }
        return "content=" + this.content + ",url=" + getUrl() + ",title=" + this.title;
    }

    public final void addImage(@Nullable String str, @Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-258650076")) {
            ipChange.ipc$dispatch("-258650076", new Object[]{this, str, bitmap});
        } else if (str != null) {
            this.imgUrls.add(str);
            ShareManager.IBitmapManager l = ShareManager.INSTANCE.b().l();
            if (l != null) {
                l.saveBitmap(str, bitmap);
            }
        }
    }

    public final void addImage(@Nullable Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "530571950")) {
            ipChange.ipc$dispatch("530571950", new Object[]{this, bitmap});
            return;
        }
        ShareManager shareManager = ShareManager.INSTANCE;
        ShareManager.IBitmapManager l = shareManager.b().l();
        if (l != null) {
            l.saveBitmap(shareManager.b().h(), bitmap);
        }
    }
}
