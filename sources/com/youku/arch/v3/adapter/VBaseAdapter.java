package com.youku.arch.v3.adapter;

import android.content.Context;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.AbstractC3289a;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.IItem;
import com.youku.arch.v3.adapter.VBaseHolder;
import com.youku.arch.v3.core.IContext;
import com.youku.arch.v3.core.ItemValue;
import com.youku.arch.v3.data.Constants;
import com.youku.arch.v3.event.ViewHolderEvent;
import com.youku.arch.v3.view.render.GenericRenderConfig;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0017\b&\u0018\u0000*\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0001*\u0014\b\u0001\u0010\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u00042\b\u0012\u0004\u0012\u00028\u00010\u0007:\u0002[\\B\u000f\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\bZ\u00104J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\f\u001a\u00020\nJ\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000e\u001a\u00020\bJ\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010J \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013J!\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0016J8\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0018\u001a\u00020\b2\u001c\u0010\u001a\u001a\u0018\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0019J$\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0018\u001a\u00020\b2\b\b\u0001\u0010\u001c\u001a\u00020\bJ(\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0018\u001a\u00020\b2\f\u0010\u001e\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019J\u001c\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010!\u001a\u0004\u0018\u00010 J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020$2\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0004\b'\u0010&J\u0017\u0010(\u001a\u00020$2\u0006\u0010#\u001a\u00028\u0001H\u0016¢\u0006\u0004\b(\u0010&J&\u0010+\u001a\u00020$2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00132\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013J\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010,\u001a\u00020\bR\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u00105R\u0016\u00106\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b6\u00107R\"\u0010\u000e\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u00109\u001a\u0004\b:\u0010;\"\u0004\b\u000f\u0010<R\"\u0010=\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u00107\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010\f\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\f\u0010B\u001a\u0004\bC\u0010D\"\u0004\b\r\u0010ER\"\u0010G\u001a\u00020F8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010M\u001a\u0004\bN\u0010O\"\u0004\b\"\u0010PR0\u0010Q\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR(\u0010,\u001a\u00020\b8\u0004@\u0004X\u0084\u000e¢\u0006\u0018\n\u0004\b,\u00107\u0012\u0004\bX\u0010Y\u001a\u0004\bW\u0010?\"\u0004\b-\u0010A¨\u0006]"}, d2 = {"Lcom/youku/arch/v3/adapter/VBaseAdapter;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "DATA", "Lcom/youku/arch/v3/adapter/VBaseHolder;", "Lcom/youku/arch/v3/view/render/GenericRenderConfig;", "VH", "Lcom/alibaba/android/vlayout/DelegateAdapter$Adapter;", "", "getItemCount", "Lcom/alibaba/android/vlayout/a;", "onCreateLayoutHelper", "layoutHelper", "setLayoutHelper", "renderCount", "setRenderCount", "", "data", "setData", "", "addData", "(Lcom/youku/arch/v3/IItem;)Lcom/youku/arch/v3/adapter/VBaseAdapter;", "position", "getItemViewType", "viewType", "Ljava/lang/Class;", "viewHolderClass", "setHolderClass", "layoutRes", "setLayoutResId", "clazz", "setPreRender", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "viewTypeSupport", "setViewTypeSupport", "holder", "Ltb/wt2;", "onViewRecycled", "(Lcom/youku/arch/v3/adapter/VBaseHolder;)V", ViewHolderEvent.ON_VIEW_ATTACHED_TO_WINDOW, ViewHolderEvent.ON_VIEW_DETACHED_FROM_WINDOW, "oldData", "newData", "notifyLocalDataSetChanged", "level", "setLevel", "Landroid/content/Context;", WPKFactory.INIT_KEY_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "Ljava/util/List;", "dataCount", "I", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "getRenderCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "renderStart", "getRenderStart", "()I", "setRenderStart", "(I)V", "Lcom/alibaba/android/vlayout/a;", "getLayoutHelper", "()Lcom/alibaba/android/vlayout/a;", "(Lcom/alibaba/android/vlayout/a;)V", "Lcom/youku/arch/v3/core/IContext;", Constants.PAGE_CONTEXT, "Lcom/youku/arch/v3/core/IContext;", "getPageContext", "()Lcom/youku/arch/v3/core/IContext;", "setPageContext", "(Lcom/youku/arch/v3/core/IContext;)V", "Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "getViewTypeSupport", "()Lcom/youku/arch/v3/adapter/ViewTypeSupport;", "(Lcom/youku/arch/v3/adapter/ViewTypeSupport;)V", "innerAdapter", "Lcom/youku/arch/v3/adapter/VBaseAdapter;", "getInnerAdapter", "()Lcom/youku/arch/v3/adapter/VBaseAdapter;", "setInnerAdapter", "(Lcom/youku/arch/v3/adapter/VBaseAdapter;)V", "getLevel", "getLevel$annotations", "()V", "<init>", "DiffCallBack", "Level", "konearch_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class VBaseAdapter<DATA extends IItem<ItemValue>, VH extends VBaseHolder<DATA, GenericRenderConfig>> extends DelegateAdapter.Adapter<VH> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private Context context;
    @JvmField
    @Nullable
    public List<DATA> data;
    @JvmField
    public int dataCount;
    @Nullable
    private VBaseAdapter<DATA, VH> innerAdapter;
    public AbstractC3289a layoutHelper;
    private int level;
    public IContext pageContext;
    @NotNull
    private AtomicInteger renderCount;
    private int renderStart;
    @Nullable
    private ViewTypeSupport viewTypeSupport;

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0000\u0018\u0000*\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0004B'\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/youku/arch/v3/adapter/VBaseAdapter$DiffCallBack;", "Lcom/youku/arch/v3/IItem;", "Lcom/youku/arch/v3/core/ItemValue;", "T", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "", "getOldListSize", "getNewListSize", "oldItemPosition", "newItemPosition", "", "areItemsTheSame", "areContentsTheSame", "", "oldData", "Ljava/util/List;", "newData", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "konearch_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class DiffCallBack<T extends IItem<ItemValue>> extends DiffUtil.Callback {
        private static transient /* synthetic */ IpChange $ipChange;
        @Nullable
        private final List<T> newData;
        @Nullable
        private final List<T> oldData;

        /* JADX WARN: Multi-variable type inference failed */
        public DiffCallBack(@Nullable List<? extends T> list, @Nullable List<? extends T> list2) {
            this.oldData = list;
            this.newData = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1975986383")) {
                return ((Boolean) ipChange.ipc$dispatch("-1975986383", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
            }
            List<T> list = this.oldData;
            T t = list == null ? null : list.get(i);
            List<T> list2 = this.newData;
            T t2 = list2 != null ? list2.get(i2) : null;
            if (t == null || t2 == null) {
                return false;
            }
            return b41.d(t.getProperty(), t2.getProperty());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1042687475")) {
                return ((Boolean) ipChange.ipc$dispatch("-1042687475", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
            }
            List<T> list = this.oldData;
            T t = list == null ? null : list.get(i);
            List<T> list2 = this.newData;
            T t2 = list2 != null ? list2.get(i2) : null;
            if (t == null || t2 == null) {
                return false;
            }
            return b41.d(t.getClass().getSimpleName(), t2.getClass().getSimpleName());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1172957376")) {
                return ((Integer) ipChange.ipc$dispatch("-1172957376", new Object[]{this})).intValue();
            }
            List<T> list = this.newData;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1889941415")) {
                return ((Integer) ipChange.ipc$dispatch("-1889941415", new Object[]{this})).intValue();
            }
            List<T> list = this.oldData;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/youku/arch/v3/adapter/VBaseAdapter$Level;", "", "Companion", "konearch_release"}, k = 1, mv = {1, 5, 1})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Level {
        public static final int COMPONENT = 2;
        @NotNull
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int ITEM = 3;
        public static final int MODULE = 1;
        public static final int NONE = 0;

        /* compiled from: Taobao */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/youku/arch/v3/adapter/VBaseAdapter$Level$Companion;", "", "", "NONE", "I", "MODULE", "COMPONENT", "ITEM", "<init>", "()V", "konearch_release"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int COMPONENT = 2;
            public static final int ITEM = 3;
            public static final int MODULE = 1;
            public static final int NONE = 0;

            private Companion() {
            }
        }
    }

    public VBaseAdapter(@NotNull Context context) {
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.context = context;
        this.renderCount = new AtomicInteger(0);
        this.level = 2;
    }

    protected static /* synthetic */ void getLevel$annotations() {
    }

    @NotNull
    public final VBaseAdapter<DATA, VH> addData(@NotNull List<? extends DATA> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "652020298")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("652020298", new Object[]{this, list});
        }
        b41.i(list, "data");
        List<DATA> list2 = this.data;
        if (list2 != null) {
            list2.addAll(list);
            this.dataCount += list.size();
        }
        return this;
    }

    @NotNull
    public final Context getContext() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "771181609") ? (Context) ipChange.ipc$dispatch("771181609", new Object[]{this}) : this.context;
    }

    @Nullable
    public final VBaseAdapter<DATA, VH> getInnerAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1704524033") ? (VBaseAdapter) ipChange.ipc$dispatch("-1704524033", new Object[]{this}) : this.innerAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "399437367") ? ((Integer) ipChange.ipc$dispatch("399437367", new Object[]{this})).intValue() : this.dataCount;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-540281506")) {
            return ((Integer) ipChange.ipc$dispatch("-540281506", new Object[]{this, Integer.valueOf(i)})).intValue();
        }
        List<DATA> list = this.data;
        if (list != null) {
            b41.f(list);
            if (list.size() > i) {
                List<DATA> list2 = this.data;
                b41.f(list2);
                return list2.get(i).getType();
            }
            return 0;
        }
        return 0;
    }

    @NotNull
    public final AbstractC3289a getLayoutHelper() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-835253301")) {
            return (AbstractC3289a) ipChange.ipc$dispatch("-835253301", new Object[]{this});
        }
        AbstractC3289a abstractC3289a = this.layoutHelper;
        if (abstractC3289a != null) {
            return abstractC3289a;
        }
        b41.A("layoutHelper");
        return null;
    }

    protected final int getLevel() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1460876527") ? ((Integer) ipChange.ipc$dispatch("1460876527", new Object[]{this})).intValue() : this.level;
    }

    @NotNull
    public final IContext getPageContext() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1926559016")) {
            return (IContext) ipChange.ipc$dispatch("1926559016", new Object[]{this});
        }
        IContext iContext = this.pageContext;
        if (iContext != null) {
            return iContext;
        }
        b41.A(Constants.PAGE_CONTEXT);
        return null;
    }

    @NotNull
    public final AtomicInteger getRenderCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1110543055") ? (AtomicInteger) ipChange.ipc$dispatch("-1110543055", new Object[]{this}) : this.renderCount;
    }

    public final int getRenderStart() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-470576441") ? ((Integer) ipChange.ipc$dispatch("-470576441", new Object[]{this})).intValue() : this.renderStart;
    }

    @Nullable
    public final ViewTypeSupport getViewTypeSupport() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-122533090") ? (ViewTypeSupport) ipChange.ipc$dispatch("-122533090", new Object[]{this}) : this.viewTypeSupport;
    }

    public final void notifyLocalDataSetChanged(@Nullable List<? extends DATA> list, @Nullable List<? extends DATA> list2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522608220")) {
            ipChange.ipc$dispatch("-1522608220", new Object[]{this, list, list2});
            return;
        }
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffCallBack(list, list2), true);
        b41.h(calculateDiff, "calculateDiff(callBack, true)");
        calculateDiff.dispatchUpdatesTo(this);
    }

    @Override // com.alibaba.android.vlayout.DelegateAdapter.Adapter
    @NotNull
    public AbstractC3289a onCreateLayoutHelper() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "923096614") ? (AbstractC3289a) ipChange.ipc$dispatch("923096614", new Object[]{this}) : getLayoutHelper();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        onViewAttachedToWindow((VBaseAdapter<DATA, VH>) ((VBaseHolder) viewHolder));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        onViewDetachedFromWindow((VBaseAdapter<DATA, VH>) ((VBaseHolder) viewHolder));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        onViewRecycled((VBaseAdapter<DATA, VH>) ((VBaseHolder) viewHolder));
    }

    public final void setContext(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2113889237")) {
            ipChange.ipc$dispatch("-2113889237", new Object[]{this, context});
            return;
        }
        b41.i(context, "<set-?>");
        this.context = context;
    }

    @NotNull
    public final VBaseAdapter<DATA, VH> setData(@Nullable List<DATA> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1437385291")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1437385291", new Object[]{this, list});
        }
        this.data = list;
        this.dataCount = list != null ? list.size() : 0;
        return this;
    }

    @NotNull
    public final VBaseAdapter<DATA, VH> setHolderClass(int i, @Nullable Class<? extends VBaseHolder<DATA, GenericRenderConfig>> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1099126518")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("1099126518", new Object[]{this, Integer.valueOf(i), cls});
        }
        if (cls != null) {
            ViewTypeSupport viewTypeSupport = this.viewTypeSupport;
            if (viewTypeSupport != null) {
                ViewTypeConfig viewTypeConfig = viewTypeSupport == null ? null : viewTypeSupport.getViewTypeConfig(i);
                if (viewTypeConfig != null) {
                    viewTypeConfig.setViewHolderClass(cls);
                }
                return this;
            }
            throw new RuntimeException(b41.r("viewTypeSupport is null! viewType is ", Integer.valueOf(i)));
        }
        throw new RuntimeException(b41.r("viewHolderClass is null! viewType is ", Integer.valueOf(i)));
    }

    public final void setInnerAdapter(@Nullable VBaseAdapter<DATA, VH> vBaseAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1047395425")) {
            ipChange.ipc$dispatch("-1047395425", new Object[]{this, vBaseAdapter});
        } else {
            this.innerAdapter = vBaseAdapter;
        }
    }

    /* renamed from: setLayoutHelper  reason: collision with other method in class */
    public final void m1250setLayoutHelper(@NotNull AbstractC3289a abstractC3289a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522718067")) {
            ipChange.ipc$dispatch("-1522718067", new Object[]{this, abstractC3289a});
            return;
        }
        b41.i(abstractC3289a, "<set-?>");
        this.layoutHelper = abstractC3289a;
    }

    @NotNull
    public final VBaseAdapter<DATA, VH> setLayoutResId(int i, @LayoutRes int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1829163883")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1829163883", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        if (i2 != 0) {
            ViewTypeSupport viewTypeSupport = this.viewTypeSupport;
            ViewTypeConfig viewTypeConfig = viewTypeSupport == null ? null : viewTypeSupport.getViewTypeConfig(i);
            if (viewTypeConfig != null) {
                viewTypeConfig.setLayoutResId(Integer.valueOf(i2));
            }
            return this;
        }
        throw new RuntimeException(b41.r("layoutRes is null viewType is ", Integer.valueOf(i)));
    }

    /* renamed from: setLevel  reason: collision with other method in class */
    protected final void m1251setLevel(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-408445445")) {
            ipChange.ipc$dispatch("-408445445", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.level = i;
        }
    }

    public final void setPageContext(@NotNull IContext iContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1294177068")) {
            ipChange.ipc$dispatch("1294177068", new Object[]{this, iContext});
            return;
        }
        b41.i(iContext, "<set-?>");
        this.pageContext = iContext;
    }

    @NotNull
    public final VBaseAdapter<DATA, VH> setPreRender(int i, @Nullable Class<?> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1396834653")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1396834653", new Object[]{this, Integer.valueOf(i), cls});
        }
        if (cls != null) {
            ViewTypeSupport viewTypeSupport = this.viewTypeSupport;
            if (viewTypeSupport != null) {
                ViewTypeConfig viewTypeConfig = viewTypeSupport == null ? null : viewTypeSupport.getViewTypeConfig(i);
                if (viewTypeConfig != null) {
                    viewTypeConfig.setPreRenderClass(cls);
                }
                return this;
            }
            throw new RuntimeException(b41.r("setPreRender viewTypeSupport is null ! viewType is ", Integer.valueOf(i)));
        }
        throw new RuntimeException(b41.r("setPreRender clazz is null,please check your params ! viewType is ", Integer.valueOf(i)));
    }

    public final void setRenderCount(@NotNull AtomicInteger atomicInteger) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1404100729")) {
            ipChange.ipc$dispatch("-1404100729", new Object[]{this, atomicInteger});
            return;
        }
        b41.i(atomicInteger, "<set-?>");
        this.renderCount = atomicInteger;
    }

    public final void setRenderStart(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-782904285")) {
            ipChange.ipc$dispatch("-782904285", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.renderStart = i;
        }
    }

    /* renamed from: setViewTypeSupport  reason: collision with other method in class */
    public final void m1252setViewTypeSupport(@Nullable ViewTypeSupport viewTypeSupport) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1848722498")) {
            ipChange.ipc$dispatch("1848722498", new Object[]{this, viewTypeSupport});
        } else {
            this.viewTypeSupport = viewTypeSupport;
        }
    }

    public void onViewAttachedToWindow(@NotNull VH vh) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-183312444")) {
            ipChange.ipc$dispatch("-183312444", new Object[]{this, vh});
            return;
        }
        b41.i(vh, "holder");
        super.onViewAttachedToWindow((VBaseAdapter<DATA, VH>) vh);
        vh.onViewAttachedToWindow();
    }

    public void onViewDetachedFromWindow(@NotNull VH vh) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-179283711")) {
            ipChange.ipc$dispatch("-179283711", new Object[]{this, vh});
            return;
        }
        b41.i(vh, "holder");
        super.onViewDetachedFromWindow((VBaseAdapter<DATA, VH>) vh);
        vh.onViewDetachedFromWindow();
    }

    public void onViewRecycled(@NotNull VH vh) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "831088742")) {
            ipChange.ipc$dispatch("831088742", new Object[]{this, vh});
            return;
        }
        b41.i(vh, "holder");
        vh.onRecycled();
        super.onViewRecycled((VBaseAdapter<DATA, VH>) vh);
    }

    @NotNull
    public final VBaseAdapter<DATA, VH> setLayoutHelper(@NotNull AbstractC3289a abstractC3289a) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-498367549")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-498367549", new Object[]{this, abstractC3289a});
        }
        b41.i(abstractC3289a, "layoutHelper");
        m1250setLayoutHelper(abstractC3289a);
        return this;
    }

    @NotNull
    public final VBaseAdapter<DATA, VH> setLevel(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-21811051")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-21811051", new Object[]{this, Integer.valueOf(i)});
        }
        this.level = i;
        return this;
    }

    @NotNull
    public final VBaseAdapter<DATA, VH> setRenderCount(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-980875616")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-980875616", new Object[]{this, Integer.valueOf(i)});
        }
        List<DATA> list = this.data;
        if (list != null && i > list.size()) {
            i = list.size();
        }
        this.renderCount.set(i);
        return this;
    }

    @NotNull
    public final VBaseAdapter<DATA, VH> setViewTypeSupport(@Nullable ViewTypeSupport viewTypeSupport) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "864589934")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("864589934", new Object[]{this, viewTypeSupport});
        }
        this.viewTypeSupport = viewTypeSupport;
        return this;
    }

    @NotNull
    public final VBaseAdapter<DATA, VH> addData(@NotNull DATA data) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1722280333")) {
            return (VBaseAdapter) ipChange.ipc$dispatch("-1722280333", new Object[]{this, data});
        }
        b41.i(data, "data");
        List<DATA> list = this.data;
        if (list != null) {
            list.add(data);
            this.dataCount++;
        }
        return this;
    }
}
