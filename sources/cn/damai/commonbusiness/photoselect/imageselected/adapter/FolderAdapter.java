package cn.damai.commonbusiness.photoselect.imageselected.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.photoselect.imageselected.entry.Image;
import cn.damai.uikit.view.DMPosterView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import tb.h62;
import tb.jn1;
import tb.vo0;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class FolderAdapter extends RecyclerView.Adapter<C0752b> {
    private static transient /* synthetic */ IpChange $ipChange;
    private ArrayList<vo0> a;
    private LayoutInflater b;
    private OnFolderSelectListener c;

    /* compiled from: Taobao */
    /* loaded from: classes4.dex */
    public interface OnFolderSelectListener {
        int OnFolderSelect(vo0 vo0Var);

        void OnFolderSelect(int i);
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.adapter.FolderAdapter$a */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC0751a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ int a;

        View$OnClickListenerC0751a(int i) {
            this.a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1688051929")) {
                ipChange.ipc$dispatch("1688051929", new Object[]{this, view});
                return;
            }
            FolderAdapter.this.notifyDataSetChanged();
            if (FolderAdapter.this.c != null) {
                FolderAdapter.this.c.OnFolderSelect(this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.photoselect.imageselected.adapter.FolderAdapter$b */
    /* loaded from: classes4.dex */
    public static class C0752b extends RecyclerView.ViewHolder {
        DMPosterView a;
        TextView b;
        TextView c;
        TextView d;

        public C0752b(View view) {
            super(view);
            this.a = (DMPosterView) view.findViewById(R$id.iv_image);
            this.b = (TextView) view.findViewById(R$id.tv_select_num);
            this.c = (TextView) view.findViewById(R$id.tv_folder_name);
            this.d = (TextView) view.findViewById(R$id.tv_folder_size);
        }
    }

    public FolderAdapter(Context context, ArrayList<vo0> arrayList) {
        this.a = arrayList;
        this.b = LayoutInflater.from(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(C0752b c0752b, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1930929821")) {
            ipChange.ipc$dispatch("1930929821", new Object[]{this, c0752b, Integer.valueOf(i)});
            return;
        }
        vo0 vo0Var = this.a.get(i);
        ArrayList<Image> b = vo0Var.b();
        c0752b.c.setText(vo0Var.c());
        if (b != null && !b.isEmpty()) {
            TextView textView = c0752b.d;
            textView.setText(jn1.BRACKET_START_STR + b.size() + jn1.BRACKET_END_STR);
            c0752b.a.setPlaceholder(R$drawable.uikit_default_image_bg_trans_white);
            c0752b.a.setImageUrl(h62.q(b.get(0).getPath()));
        } else {
            c0752b.d.setText("(0)");
        }
        OnFolderSelectListener onFolderSelectListener = this.c;
        if (onFolderSelectListener != null) {
            int OnFolderSelect = onFolderSelectListener.OnFolderSelect(vo0Var);
            if (OnFolderSelect > 0) {
                if (c0752b.b.getVisibility() == 8) {
                    c0752b.b.setVisibility(0);
                }
                c0752b.b.setText(String.valueOf(OnFolderSelect));
            } else if (c0752b.b.getVisibility() == 0) {
                c0752b.b.setVisibility(8);
            }
        } else if (c0752b.b.getVisibility() == 0) {
            c0752b.b.setVisibility(8);
        }
        c0752b.itemView.setOnClickListener(new View$OnClickListenerC0751a(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public C0752b onCreateViewHolder(ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1122169351") ? (C0752b) ipChange.ipc$dispatch("-1122169351", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new C0752b(this.b.inflate(R$layout.adapter_folder, viewGroup, false));
    }

    public void d(OnFolderSelectListener onFolderSelectListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "598327388")) {
            ipChange.ipc$dispatch("598327388", new Object[]{this, onFolderSelectListener});
        } else {
            this.c = onFolderSelectListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "230306952")) {
            return ((Integer) ipChange.ipc$dispatch("230306952", new Object[]{this})).intValue();
        }
        ArrayList<vo0> arrayList = this.a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }
}
