package cn.damai.commonbusiness.photoselect.imageselected.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.PagerAdapter;
import cn.damai.common.image.C0504a;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask2;
import cn.damai.commonbusiness.photoselect.photoview.PhotoView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.C9826vr;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ImagePagerAdapter extends PagerAdapter {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<PhotoView> b = new ArrayList(4);
    List<Image> c;
    private OnItemClickListener d;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface OnItemClickListener {
        void onItemClick(int i, Image image);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.adapter.ImagePagerAdapter$a */
    /* loaded from: classes4.dex */
    public class C0758a implements ImageTask2.Listener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PhotoView a;

        C0758a(ImagePagerAdapter imagePagerAdapter, PhotoView photoView) {
            this.a = photoView;
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask2.Listener
        public void onSuccess(ImageView imageView, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1945647236")) {
                ipChange.ipc$dispatch("-1945647236", new Object[]{this, imageView, bitmap});
            } else if (bitmap != null) {
                this.a.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.adapter.ImagePagerAdapter$b */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0759b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;
        final /* synthetic */ Image b;

        View$OnClickListenerC0759b(int i, Image image) {
            this.a = i;
            this.b = image;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "877464288")) {
                ipChange.ipc$dispatch("877464288", new Object[]{this, view});
            } else if (ImagePagerAdapter.this.d != null) {
                ImagePagerAdapter.this.d.onItemClick(this.a, this.b);
            }
        }
    }

    public ImagePagerAdapter(Context context, List<Image> list) {
        this.a = context;
        b();
        this.c = list;
        int e = wh2.e(list);
        for (int i = 0; i < e; i++) {
            Image image = this.c.get(i);
            if (image == null || TextUtils.isEmpty(image.getPath())) {
                this.c.remove(i);
            }
        }
    }

    private void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "738753298")) {
            ipChange.ipc$dispatch("738753298", new Object[]{this});
            return;
        }
        for (int i = 0; i < 4; i++) {
            PhotoView photoView = new PhotoView(this.a);
            photoView.setAdjustViewBounds(true);
            this.b.add(photoView);
        }
    }

    public void c(OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-391287330")) {
            ipChange.ipc$dispatch("-391287330", new Object[]{this, onItemClickListener});
        } else {
            this.d = onItemClickListener;
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1929960636")) {
            ipChange.ipc$dispatch("-1929960636", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
        } else if (obj instanceof PhotoView) {
            PhotoView photoView = (PhotoView) obj;
            photoView.setImageDrawable(null);
            this.b.add(photoView);
            viewGroup.removeView(photoView);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-174845093")) {
            return ((Integer) ipChange.ipc$dispatch("-174845093", new Object[]{this})).intValue();
        }
        List<Image> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "793054982")) {
            return ((Integer) ipChange.ipc$dispatch("793054982", new Object[]{this, obj})).intValue();
        }
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1221527514")) {
            return ipChange.ipc$dispatch("1221527514", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        PhotoView remove = this.b.remove(0);
        Image image = this.c.get(i);
        viewGroup.addView(remove);
        if (image.isNetImage()) {
            if (remove.getTag() instanceof C9826vr) {
                ((C9826vr) remove.getTag()).cancel();
            }
            remove.setTag(C0504a.b().h(this.a).c(image.getPath()).g(remove));
        } else {
            if (remove.getTag() instanceof ImageTask2) {
                ((ImageTask2) remove.getTag()).cancel(true);
            }
            ImageTask2 imageTask2 = new ImageTask2(this.a, false, remove, new C0758a(this, remove));
            imageTask2.execute(image.getPath());
            remove.setTag(imageTask2);
        }
        remove.setOnClickListener(new View$OnClickListenerC0759b(i, image));
        return remove;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1710824631") ? ((Boolean) ipChange.ipc$dispatch("-1710824631", new Object[]{this, view, obj})).booleanValue() : view == obj;
    }
}
