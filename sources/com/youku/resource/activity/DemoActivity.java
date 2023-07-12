package com.youku.resource.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.ultron.net.api.UltronAdjustOrder;
import com.youku.resource.R;
import com.youku.resource.utils.YKCornerShadowUtils;
import com.youku.resource.widget.PortImageLayout;
import com.youku.resource.widget.YKCardErrorView;
import com.youku.resource.widget.YKImageLayout;
import com.youku.resource.widget.YKImageView;
import com.youku.resource.widget.YKPageErrorView;
import java.util.ArrayList;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class DemoActivity extends FragmentActivity {
    private ArrayList<DemoInfo> demoInfos;
    private int dp3;
    private DemoAdapter mAdapter;
    private RecyclerView mRecyclerview;
    private int mScreenWidth;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class DemoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private Context context;
        private ArrayList<DemoInfo> demoInfos = new ArrayList<>();
        private int width;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public class ErrorViewHolder extends RecyclerView.ViewHolder {
            public View view;

            public ErrorViewHolder(View view) {
                super(view);
                this.view = view;
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public class ImageViewHolder extends RecyclerView.ViewHolder {
            private YKImageView poster_image;

            public ImageViewHolder(View view) {
                super(view);
                this.poster_image = (YKImageView) view.findViewById(R.id.resource_item_three_program_image);
                YKCornerShadowUtils.addCornerShadow((PortImageLayout) view.findViewById(R.id.soku_item_b_three_program_image_layout));
                this.poster_image.getLayoutParams().width = DemoAdapter.this.width;
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public class LayoutViewHolder extends RecyclerView.ViewHolder {
            private YKImageLayout layout;
            private YKImageView poster_image;

            public LayoutViewHolder(View view) {
                super(view);
                this.layout = (YKImageLayout) view;
                YKImageView yKImageView = (YKImageView) view.findViewById(R.id.resource_image);
                this.poster_image = yKImageView;
                yKImageView.getLayoutParams().width = DemoAdapter.this.width;
            }
        }

        public DemoAdapter(Context context) {
            this.context = context;
            this.width = ((DemoActivity.this.mScreenWidth - (DemoActivity.this.dp3 * 2)) - ((DemoActivity.this.dp3 * 3) * 2)) / 3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<DemoInfo> arrayList = this.demoInfos;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            ArrayList<DemoInfo> arrayList;
            if (getItemCount() <= i || (arrayList = this.demoInfos) == null || arrayList.get(i) == null) {
                return 0;
            }
            return this.demoInfos.get(i).viewtype;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            DemoInfo demoInfo = this.demoInfos.get(i);
            if (viewHolder instanceof ImageViewHolder) {
                ImageViewHolder imageViewHolder = (ImageViewHolder) viewHolder;
                imageViewHolder.poster_image.hideAll();
                imageViewHolder.poster_image.setImageUrl(demoInfo.vthumburl);
                if (i <= 5) {
                    imageViewHolder.poster_image.setRank(i);
                }
                imageViewHolder.poster_image.setTopRight(demoInfo.top_right_text, demoInfo.top_right_type);
                imageViewHolder.poster_image.setBottomLeftText(demoInfo.bottom_left_text);
                imageViewHolder.poster_image.setBottomRightText(demoInfo.bottom_right_text);
                imageViewHolder.poster_image.setReputation(demoInfo.reputation);
            } else if (viewHolder instanceof LayoutViewHolder) {
                LayoutViewHolder layoutViewHolder = (LayoutViewHolder) viewHolder;
                layoutViewHolder.layout.hideAll();
                layoutViewHolder.layout.setTopRightImageUrl("https://ykimg.alicdn.com/product/image/2018-10-16/%E7%9B%B4%E6%92%AD.apng");
                layoutViewHolder.layout.getYKImageView().setImageUrl(demoInfo.vthumburl);
                if (i <= 5) {
                    layoutViewHolder.layout.setRank(i);
                }
                layoutViewHolder.layout.setTopRight(demoInfo.top_right_text, demoInfo.top_right_type);
                layoutViewHolder.layout.setBottomLeftText(demoInfo.bottom_left_text);
                layoutViewHolder.layout.setBottomRightText(demoInfo.bottom_right_text);
                layoutViewHolder.layout.setReputation(demoInfo.reputation);
            } else {
                View view = ((ErrorViewHolder) viewHolder).view;
                if (view instanceof YKPageErrorView) {
                    ((YKPageErrorView) view).setErrorText("尝试一下其他筛选项，会有其他发现哟", i % 6);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new ImageViewHolder(View.inflate(this.context, R.C8074layout.resource_item_three_program_view, null));
            }
            if (i == 1) {
                return new LayoutViewHolder(new YKImageLayout(this.context));
            }
            if (i == 2) {
                return new ErrorViewHolder(new YKPageErrorView(this.context));
            }
            return new ErrorViewHolder(new YKCardErrorView(this.context));
        }

        public void setDemoInfos(ArrayList<DemoInfo> arrayList) {
            if (arrayList != null) {
                this.demoInfos.clear();
                this.demoInfos.addAll(arrayList);
            }
            notifyDataSetChanged();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class DemoInfo {
        public String vthumburl;
        public int viewtype = 0;
        public String top_right_text = "";
        public int top_right_type = 0;
        public String bottom_left_text = "";
        public String bottom_right_text = "";
        public String reputation = "";

        public DemoInfo() {
        }
    }

    private void addItem(int i) {
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.vthumburl = "http://r1.ykimg.com/051600005BD9689DADBA6B517B017398";
        demoInfo.viewtype = i;
        this.demoInfos.add(demoInfo);
    }

    public static int getWidth(Context context) {
        return ((WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getWidth();
    }

    private void initAdapter() {
        this.demoInfos = new ArrayList<>();
        addItem(2);
        addItem(2);
        addItem(2);
        addItem(2);
        addItem(2);
        addItem(2);
        DemoInfo demoInfo = new DemoInfo();
        demoInfo.top_right_text = "属性角标";
        demoInfo.top_right_type = 2;
        demoInfo.bottom_left_text = "测试子标题";
        demoInfo.bottom_right_text = "30集全";
        this.demoInfos.add(demoInfo);
        DemoInfo demoInfo2 = new DemoInfo();
        demoInfo2.vthumburl = "http://r1.ykimg.com/051600005B991CA0859B5E4D0B07E6E4";
        demoInfo2.top_right_text = "活动";
        demoInfo2.top_right_type = 1;
        demoInfo2.bottom_left_text = "测试子标题";
        demoInfo2.bottom_right_text = "30集全";
        this.demoInfos.add(demoInfo2);
        DemoInfo demoInfo3 = new DemoInfo();
        demoInfo3.vthumburl = "http://r1.ykimg.com/051600005A25FB76ADBDD3E3B1027584";
        demoInfo3.top_right_text = "VIP";
        demoInfo3.top_right_type = 3;
        demoInfo3.reputation = UltronAdjustOrder.VERSION;
        this.demoInfos.add(demoInfo3);
        DemoInfo demoInfo4 = new DemoInfo();
        demoInfo4.vthumburl = "http://r1.ykimg.com/051600005BDA94A8859B5D063C05CF16";
        demoInfo4.top_right_text = "独播";
        demoInfo4.top_right_type = 2;
        this.demoInfos.add(demoInfo4);
        DemoInfo demoInfo5 = new DemoInfo();
        demoInfo5.vthumburl = "http://r1.ykimg.com/0516000059488937ADBA1F9712028679";
        demoInfo5.top_right_text = "广告";
        demoInfo5.top_right_type = 4;
        this.demoInfos.add(demoInfo5);
        DemoInfo demoInfo6 = new DemoInfo();
        demoInfo6.vthumburl = "http://r1.ykimg.com/051600005BE2DB30ADA7B214C405C7E5";
        demoInfo6.viewtype = 1;
        this.demoInfos.add(demoInfo6);
        DemoInfo demoInfo7 = new DemoInfo();
        demoInfo7.vthumburl = "http://r1.ykimg.com/051600005BD9689DADBA6B517B017398";
        this.demoInfos.add(demoInfo7);
        DemoInfo demoInfo8 = new DemoInfo();
        demoInfo8.vthumburl = "http://r1.ykimg.com/051600005B991CA0859B5E4D0B07E6E4";
        demoInfo8.top_right_text = "活动";
        demoInfo8.top_right_type = 1;
        demoInfo8.bottom_left_text = "测试子标题";
        demoInfo8.bottom_right_text = "30集全";
        this.demoInfos.add(demoInfo8);
        DemoInfo demoInfo9 = new DemoInfo();
        demoInfo9.vthumburl = "http://r1.ykimg.com/051600005A25FB76ADBDD3E3B1027584";
        demoInfo9.bottom_left_text = "测试子标题";
        demoInfo9.top_right_text = "VIP";
        demoInfo9.top_right_type = 3;
        demoInfo9.reputation = "9.8";
        this.demoInfos.add(demoInfo9);
        DemoInfo demoInfo10 = new DemoInfo();
        demoInfo10.vthumburl = "http://r1.ykimg.com/051600005BDA94A8859B5D063C05CF16";
        demoInfo10.top_right_text = "独播";
        demoInfo10.top_right_type = 2;
        this.demoInfos.add(demoInfo10);
        DemoInfo demoInfo11 = new DemoInfo();
        demoInfo11.vthumburl = "http://r1.ykimg.com/0516000059488937ADBA1F9712028679";
        demoInfo11.top_right_text = "广告";
        demoInfo11.top_right_type = 4;
        this.demoInfos.add(demoInfo11);
        DemoInfo demoInfo12 = new DemoInfo();
        demoInfo12.vthumburl = "http://r1.ykimg.com/051600005BE2DB30ADA7B214C405C7E5";
        demoInfo12.viewtype = 1;
        this.demoInfos.add(demoInfo12);
        addItem(0);
        addItem(0);
        addItem(0);
        addItem(0);
        addItem(0);
        addItem(0);
        addItem(0);
        DemoAdapter demoAdapter = new DemoAdapter(this);
        this.mAdapter = demoAdapter;
        demoAdapter.setDemoInfos(this.demoInfos);
        this.mRecyclerview.setAdapter(this.mAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getActionBar().hide();
        super.onCreate(null);
        setTitle("");
        setContentView(R.C8074layout.activity_resource_demo);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.resource_recyclerview);
        this.mRecyclerview = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager((Context) this, 3, 1, false));
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.resource_size_3);
        this.dp3 = dimensionPixelSize;
        this.mRecyclerview.setPadding(dimensionPixelSize * 3, 0, 0, 0);
        RecyclerView recyclerView2 = this.mRecyclerview;
        int i = this.dp3;
        recyclerView2.addItemDecoration(new SpaceItemDecoration(0, i, 0, i));
        this.mScreenWidth = getWidth(this);
        initAdapter();
        findViewById(R.id.custom_title).setOnClickListener(new View.OnClickListener() { // from class: com.youku.resource.activity.DemoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DemoActivity.this.startActivity(new Intent(DemoActivity.this, DemoActivity.class));
            }
        });
        findViewById(R.id.custom_back).setOnClickListener(new View.OnClickListener() { // from class: com.youku.resource.activity.DemoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DemoActivity.this.finish();
            }
        });
        findViewById(R.id.custom_right).setOnClickListener(new View.OnClickListener() { // from class: com.youku.resource.activity.DemoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DemoActivity.this.startActivity(new Intent(DemoActivity.this, PerformanceActivity.class));
            }
        });
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        private int bottom;
        private int left;
        private int right;
        private int top;

        public SpaceItemDecoration(int i) {
            this.right = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.right = this.right;
            rect.top = this.top;
            rect.bottom = this.bottom;
            rect.left = this.left;
        }

        public SpaceItemDecoration(int i, int i2, int i3, int i4) {
            this.left = i;
            this.right = i2;
            this.top = i3;
            this.bottom = i4;
        }
    }
}
