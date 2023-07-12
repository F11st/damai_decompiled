package com.alient.onearch.adapter;

import com.alibaba.android.ultron.trade.event.OpenSimplePopupSubscriber;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/alient/onearch/adapter/ComponentTypeMapper;", "", "Lcom/alient/onearch/adapter/ComponentTypeMapper$IComponentTypeTransfer;", "transfer", "Ltb/wt2;", "register", "", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "", "convertComponentTypeToInt", "Lcom/alient/onearch/adapter/ComponentTypeMapper$IComponentTypeTransfer;", "<init>", "()V", "IComponentTypeTransfer", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes12.dex */
public final class ComponentTypeMapper {
    @NotNull
    public static final ComponentTypeMapper INSTANCE = new ComponentTypeMapper();
    @Nullable
    private static IComponentTypeTransfer transfer;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/alient/onearch/adapter/ComponentTypeMapper$IComponentTypeTransfer;", "", "", OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE, "", "transfer", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface IComponentTypeTransfer {
        int transfer(@NotNull String str);
    }

    private ComponentTypeMapper() {
    }

    public final int convertComponentTypeToInt(@NotNull String str) {
        b41.i(str, OpenSimplePopupSubscriber.KEY_COMPONENT_TYPE);
        IComponentTypeTransfer iComponentTypeTransfer = transfer;
        if (iComponentTypeTransfer == null) {
            return -1;
        }
        return iComponentTypeTransfer.transfer(str);
    }

    public final void register(@NotNull IComponentTypeTransfer iComponentTypeTransfer) {
        b41.i(iComponentTypeTransfer, "transfer");
        transfer = iComponentTypeTransfer;
    }
}
