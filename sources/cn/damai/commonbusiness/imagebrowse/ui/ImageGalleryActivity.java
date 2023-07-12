package cn.damai.commonbusiness.imagebrowse.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.uikit.view.RoundImageView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.q60;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ImageGalleryActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    RecyclerView recyclerView;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class ImageAdapter extends RecyclerView.Adapter {
        private static transient /* synthetic */ IpChange $ipChange;
        List<String> a;
        Activity b;
        int c;

        /* compiled from: Taobao */
        /* loaded from: classes4.dex */
        class a extends RecyclerView.ViewHolder {
            a(ImageAdapter imageAdapter, View view) {
                super(view);
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes14.dex */
        public class b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ int a;

            b(int i) {
                this.a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1408263710")) {
                    ipChange.ipc$dispatch("1408263710", new Object[]{this, view});
                    return;
                }
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (String str : ImageAdapter.this.a) {
                    PicInfo picInfo = new PicInfo();
                    picInfo.setPicUrl(str);
                    arrayList.add(picInfo);
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("pic_info", arrayList);
                bundle.putInt("position", this.a);
                DMNav.from(ImageGalleryActivity.this.mContext.getApplicationContext()).withExtras(bundle).toUri(NavUri.b("videobrowse"));
            }
        }

        public ImageAdapter(List<String> list, Activity activity, int i) {
            this.a = list;
            this.c = i;
            this.b = activity;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-967293492")) {
                return ((Integer) ipChange.ipc$dispatch("-967293492", new Object[]{this})).intValue();
            }
            List<String> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "460017581")) {
                ipChange.ipc$dispatch("460017581", new Object[]{this, viewHolder, Integer.valueOf(i)});
                return;
            }
            cn.damai.common.image.a.b().loadinto(this.a.get(i), (ImageView) viewHolder.itemView);
            viewHolder.itemView.setOnClickListener(new b(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-457262871")) {
                return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-457262871", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            RoundImageView roundImageView = new RoundImageView(this.b);
            roundImageView.setType(1);
            roundImageView.setBorderRadius(6);
            roundImageView.setImageDrawable(ImageGalleryActivity.this.getResources().getDrawable(R$drawable.uikit_default_image_bg_gradient));
            roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            int i2 = this.c;
            roundImageView.setLayoutParams(new RecyclerView.LayoutParams(i2, (int) (i2 * 0.75d)));
            return new a(this, roundImageView);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class ItemDecoration extends RecyclerView.ItemDecoration {
        private static transient /* synthetic */ IpChange $ipChange;
        private int a;
        private int b;

        public ItemDecoration(ImageGalleryActivity imageGalleryActivity, int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1085456259")) {
                ipChange.ipc$dispatch("1085456259", new Object[]{this, rect, view, recyclerView, state});
                return;
            }
            super.getItemOffsets(rect, view, recyclerView, state);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            rect.left = this.a * (childAdapterPosition % this.b);
            Log.d("hahaxx", " ======= position : " + childAdapterPosition + " == outRect.left  === " + rect.left);
            if (childAdapterPosition >= this.b) {
                rect.top = q60.a(view.getContext(), 12.0f);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1298114409")) {
                ipChange.ipc$dispatch("1298114409", new Object[]{this, view});
            } else {
                ImageGalleryActivity.this.finish();
            }
        }
    }

    private List<String> initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2144504018")) {
            return (List) ipChange.ipc$dispatch("2144504018", new Object[]{this});
        }
        Serializable serializableExtra = getIntent().getSerializableExtra("pic_info");
        if (serializableExtra != null) {
            return (List) serializableExtra;
        }
        return null;
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1983537911")) {
            return ((Integer) ipChange.ipc$dispatch("1983537911", new Object[]{this})).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1076699524")) {
            ipChange.ipc$dispatch("1076699524", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(new a.b().i("repertoire_photo"));
        setContentView(R$layout.activity_image_gallery);
        setImmersionsStyle();
        initTransStatusBar();
        setDarkStatusBarColor();
        this.recyclerView = (RecyclerView) findViewById(R$id.image_gallery_list);
        this.recyclerView.setLayoutManager(new GridLayoutManager((Context) this, 2, 1, false));
        this.recyclerView.addItemDecoration(new ItemDecoration(this, q60.a(this, 6.0f), 2));
        this.recyclerView.setAdapter(new ImageAdapter(initExtraData(), this, (DisplayMetrics.getwidthPixels(getResources().getDisplayMetrics()) - q60.a(this, 54.0f)) / 2));
        findViewById(R$id.brand_back).setOnClickListener(new a());
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-355709653") ? (String) ipChange.ipc$dispatch("-355709653", new Object[]{this}) : "全部剧照";
    }
}
