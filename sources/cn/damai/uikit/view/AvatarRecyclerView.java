package cn.damai.uikit.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.image.IImageLoader;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class AvatarRecyclerView extends RecyclerView implements RecyclerView.ChildDrawingOrderCallback {
    private static transient /* synthetic */ IpChange $ipChange;
    int height;
    private AvatarAdapter mAdapter;
    private AvatarBinder mAvatarBinder;
    private Context mContext;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class AvatarAdapter extends RecyclerView.Adapter<AvatarVh> {
        private static transient /* synthetic */ IpChange $ipChange;
        private final List<AvatarItem> a = new ArrayList();

        public AvatarAdapter() {
        }

        public void a(AvatarItem avatarItem, boolean z) {
            View childAt;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "393578290")) {
                ipChange.ipc$dispatch("393578290", new Object[]{this, avatarItem, Boolean.valueOf(z)});
                return;
            }
            Iterator<AvatarItem> it = this.a.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                if (TextUtils.equals(it.next().getUniKey(), avatarItem.getUniKey())) {
                    it.remove();
                    z2 = true;
                }
            }
            this.a.add(0, avatarItem);
            int childCount = AvatarRecyclerView.this.getChildCount();
            if (z && childCount > 0 && (childAt = AvatarRecyclerView.this.getChildAt(childCount - 1)) != null) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(1000L);
                alphaAnimation.setFillAfter(true);
                childAt.startAnimation(alphaAnimation);
            }
            if (z2) {
                notifyDataSetChanged();
            } else {
                notifyItemInserted(0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: b */
        public void onBindViewHolder(@NonNull AvatarVh avatarVh, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1725033077")) {
                ipChange.ipc$dispatch("-1725033077", new Object[]{this, avatarVh, Integer.valueOf(i)});
            } else {
                AvatarRecyclerView.this.mAvatarBinder.onBindViewHolder(avatarVh, i, this.a.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: c */
        public AvatarVh onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-629911413") ? (AvatarVh) ipChange.ipc$dispatch("-629911413", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new AvatarVh(AvatarRecyclerView.this.mAvatarBinder.onCreateItemView(viewGroup, i));
        }

        public void d(AvatarItem avatarItem) {
            int i;
            IpChange ipChange = $ipChange;
            int i2 = 0;
            if (AndroidInstantRuntime.support(ipChange, "1837032302")) {
                ipChange.ipc$dispatch("1837032302", new Object[]{this, avatarItem});
                return;
            }
            int childCount = AvatarRecyclerView.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = AvatarRecyclerView.this.getChildAt(i3);
                childAt.clearAnimation();
                childAt.setAlpha(1.0f);
            }
            Iterator<AvatarItem> it = this.a.iterator();
            int i4 = -1;
            loop1: while (true) {
                i = -1;
                while (it.hasNext()) {
                    i4++;
                    if (TextUtils.equals(it.next().getUniKey(), avatarItem.getUniKey())) {
                        it.remove();
                        i2++;
                        if (i2 == 1) {
                            i = i4;
                        }
                    }
                }
            }
            if (i2 == 1) {
                if (i >= 0) {
                    notifyItemRemoved(i);
                }
            } else if (i2 > 1) {
                notifyDataSetChanged();
            }
        }

        public void e(List<AvatarItem> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-190420466")) {
                ipChange.ipc$dispatch("-190420466", new Object[]{this, list});
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
            if (AndroidInstantRuntime.support(ipChange, "1420775155")) {
                return ((Integer) ipChange.ipc$dispatch("1420775155", new Object[]{this})).intValue();
            }
            List<AvatarItem> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface AvatarBinder {
        void onBindViewHolder(@NonNull AvatarVh avatarVh, int i, AvatarItem avatarItem);

        View onCreateItemView(@NonNull ViewGroup viewGroup, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface AvatarItem {
        String getAvatarImgUrl();

        int getDefaultImageResRid();

        String getUniKey();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class AvatarVh extends RecyclerView.ViewHolder {
        public AvatarVh(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class a implements AvatarBinder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        int b;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.uikit.view.AvatarRecyclerView$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0090a implements IImageLoader.IImageSuccListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ ImageView a;

            C0090a(a aVar, ImageView imageView) {
                this.a = imageView;
            }

            @Override // cn.damai.uikit.image.IImageLoader.IImageSuccListener
            public void onSuccess(IImageLoader.b bVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "149598042")) {
                    ipChange.ipc$dispatch("149598042", new Object[]{this, bVar});
                } else {
                    this.a.setImageDrawable(bVar.a);
                }
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        public class b implements IImageLoader.IImageFailListener {
            private static transient /* synthetic */ IpChange $ipChange;

            b(a aVar) {
            }

            @Override // cn.damai.uikit.image.IImageLoader.IImageFailListener
            public void onFail(IImageLoader.a aVar) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-830702781")) {
                    ipChange.ipc$dispatch("-830702781", new Object[]{this, aVar});
                }
            }
        }

        public a(Context context) {
            this.a = context;
        }

        public void a(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2050043210")) {
                ipChange.ipc$dispatch("-2050043210", new Object[]{this, Integer.valueOf(i)});
            } else {
                this.b = i;
            }
        }

        @Override // cn.damai.uikit.view.AvatarRecyclerView.AvatarBinder
        public void onBindViewHolder(@NonNull AvatarVh avatarVh, int i, AvatarItem avatarItem) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "419136439")) {
                ipChange.ipc$dispatch("419136439", new Object[]{this, avatarVh, Integer.valueOf(i), avatarItem});
                return;
            }
            if (this.b > 0) {
                avatarVh.itemView.getLayoutParams().width = l62.a(this.a, this.b);
                avatarVh.itemView.getLayoutParams().height = l62.a(this.a, this.b);
            }
            ImageView imageView = (ImageView) avatarVh.itemView.findViewById(R$id.avatar_img);
            int defaultImageResRid = avatarItem.getDefaultImageResRid();
            String avatarImgUrl = avatarItem.getAvatarImgUrl();
            imageView.setImageResource(defaultImageResRid);
            int a = l62.a(this.a, 21.0f);
            if (TextUtils.isEmpty(avatarImgUrl)) {
                return;
            }
            cn.damai.uikit.image.a.a().load(avatarImgUrl, a, a, new C0090a(this, imageView), new b(this));
        }

        @Override // cn.damai.uikit.view.AvatarRecyclerView.AvatarBinder
        public View onCreateItemView(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1466155077") ? (View) ipChange.ipc$dispatch("1466155077", new Object[]{this, viewGroup, Integer.valueOf(i)}) : LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_default_avatar_in_list, viewGroup, false);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class b implements AvatarItem {
        private static transient /* synthetic */ IpChange $ipChange;
        private final String a;

        public b(String str) {
            this.a = str;
        }

        @Override // cn.damai.uikit.view.AvatarRecyclerView.AvatarItem
        public String getAvatarImgUrl() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1895804078") ? (String) ipChange.ipc$dispatch("1895804078", new Object[]{this}) : this.a;
        }

        @Override // cn.damai.uikit.view.AvatarRecyclerView.AvatarItem
        public int getDefaultImageResRid() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1200236989") ? ((Integer) ipChange.ipc$dispatch("-1200236989", new Object[]{this})).intValue() : R$drawable.uikit_user_default_icon;
        }

        @Override // cn.damai.uikit.view.AvatarRecyclerView.AvatarItem
        public String getUniKey() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-146611176") ? (String) ipChange.ipc$dispatch("-146611176", new Object[]{this}) : TextUtils.isEmpty(this.a) ? " " : this.a;
        }
    }

    public AvatarRecyclerView(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1972908497")) {
            ipChange.ipc$dispatch("-1972908497", new Object[]{this, canvas});
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
        return AndroidInstantRuntime.support(ipChange, "578014834") ? ((Integer) ipChange.ipc$dispatch("578014834", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).intValue() : (i - i2) - 1;
    }

    public void setAvatarBinder(AvatarBinder avatarBinder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-634206424")) {
            ipChange.ipc$dispatch("-634206424", new Object[]{this, avatarBinder});
            return;
        }
        if (avatarBinder == null) {
            avatarBinder = new a(this.mContext);
        }
        this.mAvatarBinder = avatarBinder;
    }

    public void setHeight(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1793676362")) {
            ipChange.ipc$dispatch("-1793676362", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.height = i;
        AvatarBinder avatarBinder = this.mAvatarBinder;
        if (avatarBinder == null || !(avatarBinder instanceof a)) {
            return;
        }
        ((a) avatarBinder).a(i);
    }

    public AvatarRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public AvatarAdapter getAdapter() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "247487353") ? (AvatarAdapter) ipChange.ipc$dispatch("247487353", new Object[]{this}) : this.mAdapter;
    }

    public AvatarRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.height = 0;
        this.mContext = context;
        this.mAvatarBinder = new a(context);
        setDrawingCacheEnabled(true);
        setChildDrawingOrderCallback(this);
        setLayoutManager(new LinearLayoutManager(context, 0, false));
        AvatarAdapter avatarAdapter = new AvatarAdapter();
        this.mAdapter = avatarAdapter;
        setAdapter(avatarAdapter);
        addItemDecoration(new RecyclerView.ItemDecoration() { // from class: cn.damai.uikit.view.AvatarRecyclerView.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "305042326")) {
                    ipChange.ipc$dispatch("305042326", new Object[]{this, rect, view, recyclerView, state});
                } else if (recyclerView.getChildAdapterPosition(view) != 0) {
                    rect.left = -l62.a(AvatarRecyclerView.this.mContext, 3.0f);
                } else {
                    rect.left = 0;
                }
            }
        });
    }
}
