package cn.damai.launcher.splash;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.damai.common.image.a;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.launcher.splash.api.ItemInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class GridAdapter extends BaseAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    Activity activity;
    ArrayList<ItemInfo> itemInfos;
    View.OnClickListener onClickListener;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public class CardHolder implements Serializable {
        private static transient /* synthetic */ IpChange $ipChange;
        ImageView bg;
        View check;
        String id;
        int index;
        ImageView mask;
        TextView name;
        ViewGroup viewGroup;

        public CardHolder(View view, int i) {
            this.viewGroup = (ViewGroup) view;
            this.index = i;
            this.name = (TextView) view.findViewById(R$id.image_item_tv);
            this.mask = (ImageView) view.findViewById(R$id.image_item_bg_mask);
            this.bg = (ImageView) view.findViewById(R$id.image_item_bg);
            this.check = view.findViewById(R$id.guide_img_check);
        }

        public int getIndex() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1914712927") ? ((Integer) ipChange.ipc$dispatch("1914712927", new Object[]{this})).intValue() : this.index;
        }

        public boolean isChecked() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1703008521") ? ((Boolean) ipChange.ipc$dispatch("1703008521", new Object[]{this})).booleanValue() : this.check.getVisibility() == 0;
        }
    }

    public GridAdapter(Activity activity, View.OnClickListener onClickListener, ArrayList<ItemInfo> arrayList) {
        this.activity = activity;
        this.onClickListener = onClickListener;
        this.itemInfos = arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1072868612")) {
            return ((Integer) ipChange.ipc$dispatch("1072868612", new Object[]{this})).intValue();
        }
        ArrayList<ItemInfo> arrayList = this.itemInfos;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1275202309") ? ((Long) ipChange.ipc$dispatch("-1275202309", new Object[]{this, Integer.valueOf(i)})).longValue() : i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-708220299")) {
            return (View) ipChange.ipc$dispatch("-708220299", new Object[]{this, Integer.valueOf(i), view, viewGroup});
        }
        View inflate = LayoutInflater.from(this.activity).inflate(R$layout.guide_grid_item, (ViewGroup) view, false);
        CardHolder cardHolder = new CardHolder(inflate, i);
        cardHolder.name.setText(getItem(i).name);
        cardHolder.id = getItem(i).id;
        a b = a.b();
        String str = getItem(i).picUrl;
        ImageView imageView = cardHolder.bg;
        int i2 = R$drawable.uikit_default_image_bg_gradient;
        b.loadinto(str, imageView, i2, i2);
        a.b().loadinto(getItem(i).selectedUrl, cardHolder.mask, i2, i2);
        inflate.setTag(cardHolder);
        inflate.setOnClickListener(this.onClickListener);
        HashMap hashMap = new HashMap();
        hashMap.put("item", Integer.valueOf(i));
        GuidePageUTHelper.getInstance().g(inflate, "step_one", "item", hashMap);
        return inflate;
    }

    @Override // android.widget.Adapter
    public ItemInfo getItem(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-681202413")) {
            return (ItemInfo) ipChange.ipc$dispatch("-681202413", new Object[]{this, Integer.valueOf(i)});
        }
        ArrayList<ItemInfo> arrayList = this.itemInfos;
        if (arrayList != null) {
            return arrayList.get(i);
        }
        return null;
    }
}
