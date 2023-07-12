package com.alient.onearch.adapter.component.empty;

import androidx.exifinterface.media.ExifInterface;
import com.youku.arch.v3.view.IContract;
import com.youku.css.constraint.CssConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/alient/onearch/adapter/component/empty/GenericEmptyContract;", "Lcom/youku/arch/v3/view/IContract;", "<init>", "()V", ExifInterface.TAG_MODEL, "Presenter", CssConst.CssScenes.VIEW, "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class GenericEmptyContract implements IContract {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/alient/onearch/adapter/component/empty/GenericEmptyContract$Model;", "", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface Model {
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/alient/onearch/adapter/component/empty/GenericEmptyContract$Presenter;", "", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface Presenter {
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H&¨\u0006\n"}, d2 = {"Lcom/alient/onearch/adapter/component/empty/GenericEmptyContract$View;", "", "", "imageUrl", "Ltb/wt2;", "renderImage", "mainDesc", "renderMainDesc", "subDesc", "renderSubDesc", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface View {
        void renderImage(@NotNull String str);

        void renderMainDesc(@NotNull String str);

        void renderSubDesc(@NotNull String str);
    }
}
