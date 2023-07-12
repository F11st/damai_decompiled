package com.alient.onearch.adapter.pom;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/alient/onearch/adapter/pom/StickyHeaderTabValue;", "Ljava/io/Serializable;", "", "barType", "Ljava/lang/String;", "getBarType", "()Ljava/lang/String;", "setBarType", "(Ljava/lang/String;)V", "text", "getText", "setText", "tip", "getTip", "setTip", "iconUrl", "getIconUrl", "setIconUrl", "", "iconType", "I", "getIconType", "()I", "setIconType", "(I)V", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "getComponentType", "setComponentType", "", "bubbles", "Ljava/util/List;", "getBubbles", "()Ljava/util/List;", "setBubbles", "(Ljava/util/List;)V", "<init>", "()V", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class StickyHeaderTabValue implements Serializable {
    @Nullable
    private String barType;
    @Nullable
    private List<String> bubbles;
    private int componentType;
    private int iconType;
    @Nullable
    private String iconUrl;
    @Nullable
    private String text;
    @Nullable
    private String tip;

    @Nullable
    public final String getBarType() {
        return this.barType;
    }

    @Nullable
    public final List<String> getBubbles() {
        return this.bubbles;
    }

    public final int getComponentType() {
        return this.componentType;
    }

    public final int getIconType() {
        return this.iconType;
    }

    @Nullable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getTip() {
        return this.tip;
    }

    public final void setBarType(@Nullable String str) {
        this.barType = str;
    }

    public final void setBubbles(@Nullable List<String> list) {
        this.bubbles = list;
    }

    public final void setComponentType(int i) {
        this.componentType = i;
    }

    public final void setIconType(int i) {
        this.iconType = i;
    }

    public final void setIconUrl(@Nullable String str) {
        this.iconUrl = str;
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    public final void setTip(@Nullable String str) {
        this.tip = str;
    }
}
