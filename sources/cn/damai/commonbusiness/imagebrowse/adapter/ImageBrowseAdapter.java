package cn.damai.commonbusiness.imagebrowse.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.imagebrowse.bean.PicInfo;
import cn.damai.uikit.view.photoview.PhotoView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.C9826vr;
import tb.cb1;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ImageBrowseAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String d = "ImageBrowseAdapter";
    private Context a;
    private List<PicInfo> b;
    private OnImageLongClickListener c;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public interface OnImageLongClickListener {
        void onLongClick(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.imagebrowse.adapter.ImageBrowseAdapter$a */
    /* loaded from: classes14.dex */
    public class View$OnLongClickListenerC0715a implements View.OnLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        View$OnLongClickListenerC0715a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1295697464")) {
                return ((Boolean) ipChange.ipc$dispatch("1295697464", new Object[]{this, view})).booleanValue();
            }
            if (ImageBrowseAdapter.this.c != null) {
                cb1.b(ImageBrowseAdapter.d, "image long click.");
                ImageBrowseAdapter.this.c.onLongClick(this.a);
            }
            return true;
        }
    }

    public ImageBrowseAdapter(Context context, List<PicInfo> list) {
        this.a = context;
        this.b = list;
    }

    public void c(OnImageLongClickListener onImageLongClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1996340220")) {
            ipChange.ipc$dispatch("-1996340220", new Object[]{this, onImageLongClickListener});
        } else {
            this.c = onImageLongClickListener;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1601181451")) {
            ipChange.ipc$dispatch("-1601181451", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1011300044")) {
            return ((Integer) ipChange.ipc$dispatch("1011300044", new Object[]{this})).intValue();
        }
        List<PicInfo> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-938174327")) {
            return ipChange.ipc$dispatch("-938174327", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.image_browse_item_layout, (ViewGroup) null);
        PhotoView photoView = (PhotoView) inflate.findViewById(R$id.poster);
        photoView.setOnLongClickListener(new View$OnLongClickListenerC0715a(i));
        if (photoView.getTag() instanceof C9826vr) {
            ((C9826vr) photoView.getTag()).cancel();
        }
        DMImageCreator c = C0504a.b().c(this.b.get(i).getPicUrl());
        int i2 = R$drawable.damai_image_defalut;
        photoView.setTag(c.i(i2).c(i2).g(photoView));
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1347822456") ? ((Boolean) ipChange.ipc$dispatch("1347822456", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }
}
