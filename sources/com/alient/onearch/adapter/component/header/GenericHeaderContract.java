package com.alient.onearch.adapter.component.header;

import androidx.exifinterface.media.ExifInterface;
import com.alient.onearch.adapter.style.StyleConstant;
import com.alient.oneservice.nav.Action;
import com.youku.arch.v3.view.IContract;
import com.youku.css.constraint.CssConst;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/alient/onearch/adapter/component/header/GenericHeaderContract;", "Lcom/youku/arch/v3/view/IContract;", "<init>", "()V", ExifInterface.TAG_MODEL, "Presenter", CssConst.CssScenes.VIEW, "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes10.dex */
public final class GenericHeaderContract implements IContract {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/alient/onearch/adapter/component/header/GenericHeaderContract$Model;", "", "", "getHeaderHeight", "()Ljava/lang/Integer;", StyleConstant.HEADER_HEIGHT, "getHeaderCorner", StyleConstant.HEADER_CORNER, "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface Model {
        @Nullable
        Integer getHeaderCorner();

        @Nullable
        Integer getHeaderHeight();
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/alient/onearch/adapter/component/header/GenericHeaderContract$Presenter;", "", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface Presenter {
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H&J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H&J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\tH&J\u001c\u0010\u0014\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u001c\u0010\u0015\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0016\u001a\u00020\u0005H&J\b\u0010\u0017\u001a\u00020\u0005H&J\b\u0010\u0018\u001a\u00020\u0005H&J\b\u0010\u0019\u001a\u00020\u0005H&¨\u0006\u001a"}, d2 = {"Lcom/alient/onearch/adapter/component/header/GenericHeaderContract$View;", "", "", "startColor", "endColor", "Ltb/wt2;", "renderBackground", "height", "renderHeight", "", "title", "renderTitle", "color", "renderTitleTextColor", "renderTitleRightTextColor", "url", "renderTitleRightImage", "text", "Lcom/alient/oneservice/nav/Action;", "action", "renderBtnOne", "renderBtnTwo", "hideBtnOne", "hideBtnTwo", "showRightArrow", "hideRightArrow", "onearch-adapter_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes12.dex */
    public interface View {
        void hideBtnOne();

        void hideBtnTwo();

        void hideRightArrow();

        void renderBackground(int i, int i2);

        void renderBtnOne(@Nullable String str, @Nullable Action action);

        void renderBtnTwo(@Nullable String str, @Nullable Action action);

        void renderHeight(int i);

        void renderTitle(@Nullable String str);

        void renderTitleRightImage(@Nullable String str);

        void renderTitleRightTextColor(int i);

        void renderTitleTextColor(int i);

        void showRightArrow();
    }
}
