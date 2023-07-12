package cn.damai.commonbusiness.photoselect.imageselected.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$string;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask;
import cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask2;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.cb1;
import tb.wh2;
import tb.xe;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ImageAdapter extends RecyclerView.Adapter<e> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private ArrayList<Image> b;
    private LayoutInflater c;
    private ArrayList<Image> d = new ArrayList<>();
    private OnImageSelectListener e;
    private OnItemClickListener f;
    private int g;
    private boolean h;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface OnImageSelectListener {
        void OnImageSelect(Image image, boolean z, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface OnItemClickListener {
        void OnItemClick(Image image, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class a implements ImageTask.Listener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ e a;

        a(ImageAdapter imageAdapter, e eVar) {
            this.a = eVar;
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask.Listener
        public void onSuccess(Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1016697569")) {
                ipChange.ipc$dispatch("1016697569", new Object[]{this, bitmap});
            } else if (bitmap != null) {
                this.a.a.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class b implements ImageTask2.Listener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ e a;

        b(ImageAdapter imageAdapter, e eVar) {
            this.a = eVar;
        }

        @Override // cn.damai.commonbusiness.photoselect.imageselected.utils.ImageTask2.Listener
        public void onSuccess(ImageView imageView, Bitmap bitmap) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2046885480")) {
                ipChange.ipc$dispatch("2046885480", new Object[]{this, imageView, bitmap});
            } else if (bitmap != null) {
                this.a.a.setImageBitmap(bitmap);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Image a;
        final /* synthetic */ e b;
        final /* synthetic */ int c;

        c(Image image, e eVar, int i) {
            this.a = image;
            this.b = eVar;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "451001548")) {
                ipChange.ipc$dispatch("451001548", new Object[]{this, view});
            } else if (ImageAdapter.this.d.contains(this.a)) {
                ImageAdapter.this.x(this.a);
                ImageAdapter.this.t(this.b, false, this.c, false, this.a);
            } else if (ImageAdapter.this.h) {
                if (ImageAdapter.this.d.size() > 0) {
                    String string = ImageAdapter.this.a.getResources().getString(R$string.damai_add_image_count, String.valueOf(ImageAdapter.this.g));
                    DMDialog dMDialog = new DMDialog(ImageAdapter.this.a);
                    dMDialog.v(string);
                    dMDialog.l(R$string.damai_know, null);
                    dMDialog.show();
                    return;
                }
                ImageAdapter.this.j();
                ImageAdapter.this.r(this.a);
                ImageAdapter.this.t(this.b, true, this.c, false, this.a);
            } else if (ImageAdapter.this.g > 0 && ImageAdapter.this.d.size() >= ImageAdapter.this.g) {
                if (ImageAdapter.this.g == ImageAdapter.this.d.size()) {
                    DMDialog dMDialog2 = new DMDialog(ImageAdapter.this.a);
                    dMDialog2.v(ImageAdapter.this.a.getResources().getString(R$string.damai_add_image_count, String.valueOf(ImageAdapter.this.g)));
                    dMDialog2.l(R$string.damai_know, null);
                    dMDialog2.show();
                }
            } else {
                ImageAdapter.this.r(this.a);
                ImageAdapter.this.t(this.b, true, this.c, false, this.a);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ Image a;
        final /* synthetic */ e b;

        d(Image image, e eVar) {
            this.a = image;
            this.b = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1732675379")) {
                ipChange.ipc$dispatch("-1732675379", new Object[]{this, view});
            } else if (ImageAdapter.this.f != null) {
                if ("2".equals(this.a.getType()) && this.a.isImageLimit(ImageAdapter.this.a)) {
                    return;
                }
                ImageAdapter.this.f.OnItemClick(this.a, this.b.getAdapterPosition());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public static class e extends RecyclerView.ViewHolder {
        ImageView a;
        TextView b;
        TextView c;
        TextView d;
        ImageView e;

        public e(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R$id.iv_image);
            this.d = (TextView) view.findViewById(R$id.iv_select);
            this.c = (TextView) view.findViewById(R$id.tv_time);
            this.b = (TextView) view.findViewById(R$id.tv_size);
            this.e = (ImageView) view.findViewById(R$id.iv_masking);
        }
    }

    public ImageAdapter(Activity activity, int i, boolean z) {
        this.a = activity;
        this.c = LayoutInflater.from(activity);
        this.g = i;
        this.h = z;
    }

    private boolean i(Image image) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2142162337")) {
            return ((Boolean) ipChange.ipc$dispatch("2142162337", new Object[]{this, image})).booleanValue();
        }
        if (this.d.contains(image)) {
            return true;
        }
        Iterator<Image> it = this.d.iterator();
        while (it.hasNext()) {
            Image next = it.next();
            if (next.getPath().equals(image.getPath())) {
                image.setShowNum(next.getShowNum());
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int indexOf;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "401090018")) {
            ipChange.ipc$dispatch("401090018", new Object[]{this});
        } else if (this.b != null && this.d.size() == 1 && (indexOf = this.b.indexOf(this.d.get(0))) != -1) {
            for (int i = 0; i < this.d.size(); i++) {
                this.d.get(i).setShowNum(0);
            }
            this.d.clear();
            notifyItemChanged(indexOf);
        }
    }

    private boolean m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-320430313")) {
            return ((Boolean) ipChange.ipc$dispatch("-320430313", new Object[]{this})).booleanValue();
        }
        if (this.h && this.d.size() == 1) {
            return true;
        }
        return this.g > 0 && this.d.size() == this.g;
    }

    private void s(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "725108532")) {
            ipChange.ipc$dispatch("725108532", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        ArrayList<Image> arrayList = this.d;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.d.size(); i2++) {
            if (this.d.get(i2).getShowNum() > i) {
                this.d.get(i2).setShowNum(this.d.get(i2).getShowNum() - 1);
                int indexOf = this.b.indexOf(this.d.get(i2));
                if (indexOf != -1) {
                    notifyItemChanged(indexOf, "default");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(e eVar, boolean z, int i, boolean z2, Image image) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2371255")) {
            ipChange.ipc$dispatch("2371255", new Object[]{this, eVar, Boolean.valueOf(z), Integer.valueOf(i), Boolean.valueOf(z2), image});
        } else if (z) {
            eVar.d.setBackgroundResource(R$drawable.circle_ff2869_oval);
            TextView textView = eVar.d;
            textView.setText(image.getShowNum() + "");
            eVar.e.setAlpha(0.5f);
            cb1.c("ImageAdapter", "click选中位置=" + i + " 设置顺序数字=" + image.getShowNum());
        } else {
            eVar.d.setBackgroundResource(R$drawable.circle_per60_white_oval);
            eVar.d.setText("");
            eVar.e.setAlpha(0.2f);
            int showNum = image.getShowNum();
            image.setShowNum(0);
            if (z2) {
                return;
            }
            s(showNum);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(Image image) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "138873710")) {
            ipChange.ipc$dispatch("138873710", new Object[]{this, image});
            return;
        }
        this.d.remove(image);
        OnImageSelectListener onImageSelectListener = this.e;
        if (onImageSelectListener != null) {
            onImageSelectListener.OnImageSelect(image, false, this.d.size());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "72276601")) {
            return ((Integer) ipChange.ipc$dispatch("72276601", new Object[]{this})).intValue();
        }
        ArrayList<Image> arrayList = this.b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public ArrayList<Image> k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1239319048") ? (ArrayList) ipChange.ipc$dispatch("-1239319048", new Object[]{this}) : this.b;
    }

    public ArrayList<Image> l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2093386958") ? (ArrayList) ipChange.ipc$dispatch("2093386958", new Object[]{this}) : this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n */
    public void onBindViewHolder(e eVar, int i) {
        Bitmap bitmap;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "921127647")) {
            ipChange.ipc$dispatch("921127647", new Object[]{this, eVar, Integer.valueOf(i)});
            return;
        }
        Image image = this.b.get(i);
        if ("3".equals(image.getType())) {
            eVar.a.setImageResource(R$drawable.take_picture_bg);
        } else {
            if ("2".equals(image.getType())) {
                if (eVar.a.getTag() instanceof ImageTask) {
                    ((ImageTask) eVar.a.getTag()).cancel(true);
                }
                eVar.a.setImageResource(R$drawable.uikit_default_image_rightangle_bg_grey);
                int i2 = Build.VERSION.SDK_INT;
                bitmap = i2 >= 12 ? xe.a.get(image.getPath()) : null;
                if (bitmap != null) {
                    eVar.a.setImageBitmap(bitmap);
                } else if (i2 >= 3) {
                    ImageTask imageTask = new ImageTask(this.a, new a(this, eVar));
                    imageTask.execute(image.getPath(), image.getName());
                    eVar.a.setTag(imageTask);
                }
            } else {
                if (eVar.a.getTag() instanceof ImageTask2) {
                    ((ImageTask2) eVar.a.getTag()).cancel(true);
                }
                eVar.a.setImageDrawable(this.a.getResources().getDrawable(R$drawable.uikit_default_image_rightangle_bg_grey));
                Log.d("xxtag", "sLruCache getBitmap pos :" + i + " : url " + image.getPath());
                bitmap = Build.VERSION.SDK_INT >= 12 ? xe.a.get(image.getPath()) : null;
                if (bitmap == null) {
                    ImageTask2 imageTask2 = new ImageTask2(this.a, true, eVar.a, new b(this, eVar));
                    imageTask2.execute(image.getPath());
                    eVar.a.setTag(imageTask2);
                } else {
                    eVar.a.setImageBitmap(bitmap);
                }
            }
        }
        if ("2".equals(image.getType())) {
            if (eVar.c.getVisibility() == 8) {
                eVar.c.setVisibility(0);
            }
            if (eVar.b.getVisibility() == 8) {
                eVar.b.setVisibility(0);
            }
            eVar.c.setText(image.getDurationShow());
            eVar.b.setText(image.getSizeShow());
        } else {
            if (eVar.c.getVisibility() == 0) {
                eVar.c.setVisibility(8);
            }
            if (eVar.b.getVisibility() == 0) {
                eVar.b.setVisibility(8);
            }
        }
        t(eVar, i(image), i, true, image);
        if (!"2".equals(image.getType()) && !"3".equals(image.getType())) {
            eVar.d.setVisibility(0);
            eVar.d.setOnClickListener(new c(image, eVar, i));
        } else {
            eVar.d.setVisibility(8);
        }
        eVar.itemView.setOnClickListener(new d(image, eVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onBindViewHolder(e eVar, int i, List<Object> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1845872176")) {
            ipChange.ipc$dispatch("-1845872176", new Object[]{this, eVar, Integer.valueOf(i), list});
        } else if (list.isEmpty()) {
            onBindViewHolder(eVar, i);
        } else {
            TextView textView = eVar.d;
            textView.setText(this.b.get(i).getShowNum() + "");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public e onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "699947191") ? (e) ipChange.ipc$dispatch("699947191", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new e(this.c.inflate(R$layout.adapter_images_item, viewGroup, false));
    }

    public void q(ArrayList<Image> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1592279801")) {
            ipChange.ipc$dispatch("-1592279801", new Object[]{this, arrayList});
            return;
        }
        this.b = arrayList;
        int e2 = wh2.e(arrayList);
        for (int i = 0; i < e2; i++) {
            Image image = this.b.get(i);
            if (image == null || TextUtils.isEmpty(image.getPath())) {
                this.b.remove(image);
            }
        }
        notifyDataSetChanged();
    }

    public void r(Image image) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1930400953")) {
            ipChange.ipc$dispatch("-1930400953", new Object[]{this, image});
            return;
        }
        image.setShowNum(this.d.size() + 1);
        this.d.add(image);
        OnImageSelectListener onImageSelectListener = this.e;
        if (onImageSelectListener != null) {
            onImageSelectListener.OnImageSelect(image, true, this.d.size());
        }
    }

    public void u(OnImageSelectListener onImageSelectListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "685786642")) {
            ipChange.ipc$dispatch("685786642", new Object[]{this, onImageSelectListener});
        } else {
            this.e = onImageSelectListener;
        }
    }

    public void v(OnItemClickListener onItemClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "981807318")) {
            ipChange.ipc$dispatch("981807318", new Object[]{this, onItemClickListener});
        } else {
            this.f = onItemClickListener;
        }
    }

    public void w(ArrayList<String> arrayList) {
        IpChange ipChange = $ipChange;
        int i = 1;
        if (AndroidInstantRuntime.support(ipChange, "724357473")) {
            ipChange.ipc$dispatch("724357473", new Object[]{this, arrayList});
        } else if (this.b == null || arrayList == null) {
        } else {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (m()) {
                    return;
                }
                Iterator<Image> it2 = this.b.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Image next2 = it2.next();
                        if (next.equals(next2.getPath())) {
                            if (!this.d.contains(next2)) {
                                if (next2.getShowNum() == 0) {
                                    next2.setShowNum(i);
                                    i++;
                                }
                                this.d.add(next2);
                            }
                        }
                    }
                }
            }
            notifyDataSetChanged();
        }
    }
}
