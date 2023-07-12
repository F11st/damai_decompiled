package com.alient.onearch.adapter.widget;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.rz0;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B=\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\u0004HÆ\u0003JH\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u0006R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u001b\u0010\u0018R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018R\u0019\u0010\u000e\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/alient/onearch/adapter/widget/RichTitle;", "", "", "component1", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "text", "iconType", "iconUrl", "bubble", "bubbleBgResId", rz0.ARG_COPY, "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;I)Lcom/alient/onearch/adapter/widget/RichTitle;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getIconType", "getIconUrl", "getBubble", "I", "getBubbleBgResId", "()I", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class RichTitle {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int ICON_TYPE_IMAGE = 0;
    public static final int ICON_TYPE_LOTTIE = 1;
    @Nullable
    private final String bubble;
    private final int bubbleBgResId;
    @Nullable
    private final Integer iconType;
    @Nullable
    private final String iconUrl;
    @NotNull
    private final String text;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/alient/onearch/adapter/widget/RichTitle$Companion;", "", "", "ICON_TYPE_IMAGE", "I", "ICON_TYPE_LOTTIE", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k50 k50Var) {
            this();
        }
    }

    public RichTitle(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, int i) {
        b41.i(str, "text");
        this.text = str;
        this.iconType = num;
        this.iconUrl = str2;
        this.bubble = str3;
        this.bubbleBgResId = i;
    }

    public static /* synthetic */ RichTitle copy$default(RichTitle richTitle, String str, Integer num, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = richTitle.text;
        }
        if ((i2 & 2) != 0) {
            num = richTitle.iconType;
        }
        Integer num2 = num;
        if ((i2 & 4) != 0) {
            str2 = richTitle.iconUrl;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            str3 = richTitle.bubble;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            i = richTitle.bubbleBgResId;
        }
        return richTitle.copy(str, num2, str4, str5, i);
    }

    @NotNull
    public final String component1() {
        return this.text;
    }

    @Nullable
    public final Integer component2() {
        return this.iconType;
    }

    @Nullable
    public final String component3() {
        return this.iconUrl;
    }

    @Nullable
    public final String component4() {
        return this.bubble;
    }

    public final int component5() {
        return this.bubbleBgResId;
    }

    @NotNull
    public final RichTitle copy(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, int i) {
        b41.i(str, "text");
        return new RichTitle(str, num, str2, str3, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RichTitle) {
            RichTitle richTitle = (RichTitle) obj;
            return b41.d(this.text, richTitle.text) && b41.d(this.iconType, richTitle.iconType) && b41.d(this.iconUrl, richTitle.iconUrl) && b41.d(this.bubble, richTitle.bubble) && this.bubbleBgResId == richTitle.bubbleBgResId;
        }
        return false;
    }

    @Nullable
    public final String getBubble() {
        return this.bubble;
    }

    public final int getBubbleBgResId() {
        return this.bubbleBgResId;
    }

    @Nullable
    public final Integer getIconType() {
        return this.iconType;
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        Integer num = this.iconType;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.iconUrl;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.bubble;
        return ((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.bubbleBgResId;
    }

    @NotNull
    public String toString() {
        return "RichTitle(text=" + this.text + ", iconType=" + this.iconType + ", iconUrl=" + ((Object) this.iconUrl) + ", bubble=" + ((Object) this.bubble) + ", bubbleBgResId=" + this.bubbleBgResId + ')';
    }

    public /* synthetic */ RichTitle(String str, Integer num, String str2, String str3, int i, int i2, k50 k50Var) {
        this(str, (i2 & 2) != 0 ? 0 : num, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? 0 : i);
    }
}
