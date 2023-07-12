package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$drawable;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alient.oneservice.image.ImageLoaderProviderProxy;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.s60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class AvatarRecyclerView extends RecyclerView implements RecyclerView.ChildDrawingOrderCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    int height;
    private AvatarAdapter mAdapter;
    private AvatarBinder mAvatarBinder;
    private Context mContext;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class AvatarAdapter extends RecyclerView.Adapter<AvatarVh> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final List<AvatarItem> a = new ArrayList();

        public AvatarAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull AvatarVh avatarVh, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1876986789")) {
                ipChange.ipc$dispatch("-1876986789", new Object[]{this, avatarVh, Integer.valueOf(i)});
            } else {
                AvatarRecyclerView.this.mAvatarBinder.onBindViewHolder(avatarVh, i, this.a.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: b */
        public AvatarVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "19212411") ? (AvatarVh) ipChange.ipc$dispatch("19212411", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new AvatarVh(AvatarRecyclerView.this.mAvatarBinder.onCreateItemView(viewGroup, i));
        }

        public void c(List<AvatarItem> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1296526822")) {
                ipChange.ipc$dispatch("-1296526822", new Object[]{this, list});
                return;
            }
            this.a.clear();
            if (list != null && list.size() > 0) {
                this.a.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1052387841")) {
                return ((Integer) ipChange.ipc$dispatch("-1052387841", new Object[]{this})).intValue();
            }
            List<AvatarItem> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface AvatarBinder {
        void onBindViewHolder(@NonNull AvatarVh avatarVh, int i, AvatarItem avatarItem);

        View onCreateItemView(@NonNull ViewGroup viewGroup, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface AvatarItem {
        String getAvatarImgUrl();

        int getDefaultImageResRid();

        String getUniKey();
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class AvatarVh extends RecyclerView.ViewHolder {
        public AvatarVh(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.AvatarRecyclerView$a */
    /* loaded from: classes7.dex */
    public static class C3564a implements AvatarBinder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        int b;

        public C3564a(Context context) {
            this.a = context;
        }

        public void a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "645067714")) {
                ipChange.ipc$dispatch("645067714", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.b = i;
            }
        }

        @Override // com.alibaba.pictures.bricks.view.AvatarRecyclerView.AvatarBinder
        public void onBindViewHolder(@NonNull AvatarVh avatarVh, int i, AvatarItem avatarItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "252317775")) {
                ipChange.ipc$dispatch("252317775", new Object[]{this, avatarVh, Integer.valueOf(i), avatarItem});
                return;
            }
            if (this.b > 0) {
                ViewGroup.LayoutParams layoutParams = avatarVh.itemView.getLayoutParams();
                s60 s60Var = s60.INSTANCE;
                layoutParams.width = s60Var.b(this.a, this.b);
                avatarVh.itemView.getLayoutParams().height = s60Var.b(this.a, this.b);
            }
            ImageView imageView = (ImageView) avatarVh.itemView.findViewById(R$id.avatar_img);
            int defaultImageResRid = avatarItem.getDefaultImageResRid();
            String avatarImgUrl = avatarItem.getAvatarImgUrl();
            imageView.setImageResource(defaultImageResRid);
            s60.INSTANCE.b(this.a, 21);
            if (TextUtils.isEmpty(avatarImgUrl)) {
                return;
            }
            ImageLoaderProviderProxy.loadinto(avatarImgUrl, imageView);
        }

        @Override // com.alibaba.pictures.bricks.view.AvatarRecyclerView.AvatarBinder
        public View onCreateItemView(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1436387513") ? (View) ipChange.ipc$dispatch("1436387513", new Object[]{this, viewGroup, Integer.valueOf(i)}) : LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_item_default_avatar_in_list, viewGroup, false);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.view.AvatarRecyclerView$b */
    /* loaded from: classes7.dex */
    public static class C3565b implements AvatarItem {
        private static transient /* synthetic */ IpChange $ipChange;
        private final String a;

        public C3565b(String str) {
            this.a = str;
        }

        @Override // com.alibaba.pictures.bricks.view.AvatarRecyclerView.AvatarItem
        public String getAvatarImgUrl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1502294086") ? (String) ipChange.ipc$dispatch("-1502294086", new Object[]{this}) : this.a;
        }

        @Override // com.alibaba.pictures.bricks.view.AvatarRecyclerView.AvatarItem
        public int getDefaultImageResRid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "2069373623") ? ((Integer) ipChange.ipc$dispatch("2069373623", new Object[]{this})).intValue() : R$drawable.bricks_uikit_user_default_icon;
        }

        @Override // com.alibaba.pictures.bricks.view.AvatarRecyclerView.AvatarItem
        public String getUniKey() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "669138980") ? (String) ipChange.ipc$dispatch("669138980", new Object[]{this}) : TextUtils.isEmpty(this.a) ? " " : this.a;
        }
    }

    public AvatarRecyclerView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1902467165")) {
            ipChange.ipc$dispatch("-1902467165", new Object[]{this, canvas});
            return;
        }
        try {
            super.dispatchDraw(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ChildDrawingOrderCallback
    public int onGetChildDrawingOrder(int i, int i2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1797740418") ? ((Integer) ipChange.ipc$dispatch("-1797740418", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue() : (i - i2) - 1;
    }

    public void setAvatarBinder(AvatarBinder avatarBinder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "904161648")) {
            ipChange.ipc$dispatch("904161648", new Object[]{this, avatarBinder});
            return;
        }
        if (avatarBinder == null) {
            avatarBinder = new C3564a(this.mContext);
        }
        this.mAvatarBinder = avatarBinder;
    }

    public void setHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-472593726")) {
            ipChange.ipc$dispatch("-472593726", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.height = i;
        AvatarBinder avatarBinder = this.mAvatarBinder;
        if (avatarBinder == null || !(avatarBinder instanceof C3564a)) {
            return;
        }
        ((C3564a) avatarBinder).a(i);
    }

    public AvatarRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public AvatarAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-780151005") ? (AvatarAdapter) ipChange.ipc$dispatch("-780151005", new Object[]{this}) : this.mAdapter;
    }

    public AvatarRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = 0;
        this.mContext = context;
        this.mAvatarBinder = new C3564a(context);
        setDrawingCacheEnabled(true);
        setChildDrawingOrderCallback(this);
        setLayoutManager(new LinearLayoutManager(context, 0, false));
        AvatarAdapter avatarAdapter = new AvatarAdapter();
        this.mAdapter = avatarAdapter;
        setAdapter(avatarAdapter);
        addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.alibaba.pictures.bricks.view.AvatarRecyclerView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "16629922")) {
                    ipChange.ipc$dispatch("16629922", new Object[]{this, rect, view, recyclerView, state});
                } else if (recyclerView.getChildAdapterPosition(view) != 0) {
                    rect.left = -s60.INSTANCE.b(AvatarRecyclerView.this.mContext, 3);
                } else {
                    rect.left = 0;
                }
            }
        });
    }
}
