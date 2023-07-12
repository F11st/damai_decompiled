package cn.damai.user.repertoite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.uikit.view.photoview.PhotoView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.C9826vr;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class RepertoireDetailsGalleryAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<String> b;

    public RepertoireDetailsGalleryAdapter(Context context, List<String> list) {
        this.a = context;
        this.b = list;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-776415409")) {
            ipChange.ipc$dispatch("-776415409", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1568854694")) {
            return ((Integer) ipChange.ipc$dispatch("1568854694", new Object[]{this})).intValue();
        }
        List<String> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1840917521")) {
            return ipChange.ipc$dispatch("-1840917521", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.image_browse_item_layout, (ViewGroup) null);
        PhotoView photoView = (PhotoView) inflate.findViewById(R$id.poster);
        if (photoView.getTag() instanceof C9826vr) {
            ((C9826vr) photoView.getTag()).cancel();
        }
        DMImageCreator c = C0504a.b().c(this.b.get(i));
        int i2 = R$drawable.uikit_default_image_bg_grey;
        photoView.setTag(c.i(i2).c(i2).g(photoView));
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-980876834") ? ((Boolean) ipChange.ipc$dispatch("-980876834", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }
}
