package cn.damai.uikit.view;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.uikit.R$style;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.Serializable;
import java.util.List;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class BottomActionDialog extends Dialog implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String EDIT = "编辑";
    public static final String REPORT = "举报";
    private OnActionListener a;
    private List<Action> b;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class Adapter extends RecyclerView.Adapter<VH> {
        private static transient /* synthetic */ IpChange $ipChange;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.uikit.view.BottomActionDialog$Adapter$a */
        /* loaded from: classes8.dex */
        public class C2568a implements OnActionListener {
            private static transient /* synthetic */ IpChange $ipChange;

            C2568a() {
            }

            @Override // cn.damai.uikit.view.BottomActionDialog.OnActionListener
            public void onItemClick(Action action, int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "681881901")) {
                    ipChange.ipc$dispatch("681881901", new Object[]{this, action, Integer.valueOf(i)});
                    return;
                }
                BottomActionDialog.this.dismiss();
                BottomActionDialog.this.a.onItemClick(action, i);
            }
        }

        public Adapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(@NonNull VH vh, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2063692661")) {
                ipChange.ipc$dispatch("-2063692661", new Object[]{this, vh, Integer.valueOf(i)});
            } else {
                vh.a((Action) BottomActionDialog.this.b.get(i), i);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        /* renamed from: b */
        public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "1201490699") ? (VH) ipChange.ipc$dispatch("1201490699", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new VH(LayoutInflater.from(BottomActionDialog.this.getContext()).inflate(R$layout.dialog_item_action, viewGroup, false), new C2568a());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "595991032")) {
                return ((Integer) ipChange.ipc$dispatch("595991032", new Object[]{this})).intValue();
            }
            if (BottomActionDialog.this.b == null) {
                return 0;
            }
            return BottomActionDialog.this.b.size();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnActionListener {
        void onItemClick(Action action, int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class VH extends RecyclerView.ViewHolder implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private final ImageView a;
        private final TextView b;
        private OnActionListener c;
        private TextView d;
        public Action e;
        public int f;

        public VH(@NonNull View view, OnActionListener onActionListener) {
            super(view);
            view.setOnClickListener(this);
            this.a = (ImageView) view.findViewById(R$id.dialog_item_action_img);
            this.d = (TextView) view.findViewById(R$id.dialog_item_action_icon_f);
            this.b = (TextView) view.findViewById(R$id.dialog_item_action_tv);
            this.c = onActionListener;
        }

        public void a(Action action, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1776962876")) {
                ipChange.ipc$dispatch("1776962876", new Object[]{this, action, Integer.valueOf(i)});
                return;
            }
            this.e = action;
            this.f = i;
            if (action == null) {
                return;
            }
            this.a.setVisibility(8);
            this.d.setVisibility(8);
            int i2 = action.imgDrawableRid;
            if (i2 != -1) {
                this.a.setImageResource(i2);
                this.a.setVisibility(0);
            } else {
                int i3 = action.iconFontRid;
                if (i3 != -1) {
                    this.d.setText(i3);
                    this.d.setVisibility(0);
                }
            }
            this.b.setText(action.name);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1706008377")) {
                ipChange.ipc$dispatch("1706008377", new Object[]{this, view});
                return;
            }
            Action action = this.e;
            if (action != null) {
                this.c.onItemClick(action, this.f);
            }
        }
    }

    public BottomActionDialog(@NonNull Context context, OnActionListener onActionListener, List<Action> list) {
        this(context, R$style.translucent_dialog_style, onActionListener, list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1561294513")) {
            ipChange.ipc$dispatch("1561294513", new Object[]{this, view});
        } else if (view.getId() == R$id.dialog_bottom_action_container) {
            dismiss();
        }
    }

    @Override // android.app.Dialog
    public void show() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771096349")) {
            ipChange.ipc$dispatch("-1771096349", new Object[]{this});
            return;
        }
        super.show();
        Window window = getWindow();
        Context context = getContext();
        if (context == null || window == null || window.getAttributes() == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = DisplayMetrics.getwidthPixels(l62.b(context));
        window.setAttributes(attributes);
    }

    public BottomActionDialog(@NonNull Context context, int i, OnActionListener onActionListener, List<Action> list) {
        super(context, i);
        this.a = onActionListener;
        this.b = list;
        View inflate = LayoutInflater.from(context).inflate(R$layout.dialog_bottom_action_list, (ViewGroup) null);
        View findViewById = inflate.findViewById(R$id.dialog_bottom_action_container);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R$id.dialog_bottom_action_lv);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 5, 1, false));
        recyclerView.setAdapter(new Adapter());
        findViewById.setOnClickListener(this);
        setContentView(inflate);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class Action implements Serializable {
        public int iconFontRid;
        public int imgDrawableRid;
        public String name;

        public Action(String str, int i) {
            this.imgDrawableRid = -1;
            this.iconFontRid = -1;
            this.name = str;
            this.imgDrawableRid = i;
        }

        public Action(String str, int i, int i2) {
            this.imgDrawableRid = -1;
            this.iconFontRid = -1;
            this.name = str;
            this.imgDrawableRid = i;
            this.iconFontRid = i2;
        }
    }
}
