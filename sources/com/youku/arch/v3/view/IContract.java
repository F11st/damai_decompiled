package com.youku.arch.v3.view;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.uc.webview.export.extension.UCCore;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.core.ItemValue;
import com.youku.css.constraint.CssConst;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, d2 = {"Lcom/youku/arch/v3/view/IContract;", "", ExifInterface.TAG_MODEL, "Presenter", CssConst.CssScenes.VIEW, "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface IContract {

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/youku/arch/v3/view/IContract$Model;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "DATA", "", "item", "Ltb/wt2;", "parseModel", "(Lcom/youku/arch/v3/IItem;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface Model<DATA extends IItem<ItemValue>> {
        void parseModel(@NotNull DATA data);
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u000e\b\u0001\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0006J!\u0010\n\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH&J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0011H&J\b\u0010\u0015\u001a\u00020\u0011H&J\b\u0010\u0016\u001a\u00020\u0011H&¨\u0006\u0017"}, d2 = {"Lcom/youku/arch/v3/view/IContract$Presenter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "DATA", "Lcom/youku/arch/v3/view/IContract$Model;", "MODEL", "", "item", "", "mClassName", "createModel", "(Lcom/youku/arch/v3/IItem;Ljava/lang/String;)Lcom/youku/arch/v3/view/IContract$Model;", "type", "", "params", "", "onMessage", "Ltb/wt2;", UCCore.LEGACY_EVENT_INIT, "(Lcom/youku/arch/v3/IItem;)V", "saveState", "onCreate", "onDestroy", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface Presenter<DATA extends IItem<ItemValue>, MODEL extends Model<DATA>> {
        @NotNull
        MODEL createModel(@NotNull DATA data, @Nullable String str);

        void init(@NotNull DATA data);

        void onCreate();

        void onDestroy();

        boolean onMessage(@NotNull String str, @Nullable Map<String, ? extends Object> map);

        void saveState();
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JM\u0010\u000b\u001a\u00020\n\"\u000e\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00020\u00030\u0002\"\u000e\b\u0001\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0014\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00072\u0006\u0010\t\u001a\u00028\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\rH&J(\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\rH&R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/youku/arch/v3/view/IContract$View;", "", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "DATA", "Lcom/youku/arch/v3/view/IContract$Model;", "MODEL", "Lcom/youku/arch/v3/view/IContract$Presenter;", "PRESENTER", "presenter", "Ltb/wt2;", "bindPresenter", "(Lcom/youku/arch/v3/view/IContract$Presenter;)V", "", BQCCameraParam.FOCUS_AREA_RADIUS, "", "alpha", "setRadiusCorner", "elevation", "setElevation", "left", "top", "right", "bottom", "setPadding", "Landroid/view/View;", "getRenderView", "()Landroid/view/View;", "renderView", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public interface View {
        <DATA extends IItem<ItemValue>, MODEL extends Model<DATA>, PRESENTER extends Presenter<DATA, MODEL>> void bindPresenter(@NotNull PRESENTER presenter);

        @Nullable
        android.view.View getRenderView();

        void setElevation(int i);

        void setPadding(int i, int i2, int i3, int i4);

        void setRadiusCorner(int i, float f);
    }
}
