package tb;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.collection.ArrayMap;
import com.alibaba.android.ultron.vfw.downgrade.IDowngradeSupport;
import com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider;
import com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder;
import com.alibaba.android.umbrella.trace.UmbrellaTracker;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.AliLogInterface;
import com.taobao.android.dinamic.exception.DinamicException;
import com.taobao.android.dinamic.tempate.DTemplateManager;
import com.taobao.android.dinamicx.C6387n;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.ultron.common.model.IDMComponent;
import com.taobao.weex.ui.component.WXImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class n90 implements IViewHolderProvider {
    public static final String KEY_FESTRUE_COMPONT = "componentRender";
    public static final String KEY_FESTRUE_VERSION = "1.0";
    public static final String TAG_DINAMICX_VIEW_COMPONENT = "DinamicXComponent";
    private static final Boolean d = Boolean.FALSE;
    private C9466c a;
    private ay2 b;
    private ViewGroup c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.n90$a */
    /* loaded from: classes6.dex */
    public class DialogInterface$OnClickListenerC9464a implements DialogInterface.OnClickListener {
        final /* synthetic */ View a;
        final /* synthetic */ String b;

        DialogInterface$OnClickListenerC9464a(n90 n90Var, View view, String str) {
            this.a = view;
            this.b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            ((ClipboardManager) this.a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("url", this.b));
            Toast.makeText(this.a.getContext(), "URL已复制成功！", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.n90$b */
    /* loaded from: classes6.dex */
    public class View$OnLongClickListenerC9465b implements View.OnLongClickListener {
        final /* synthetic */ Dialog a;

        View$OnLongClickListenerC9465b(n90 n90Var, Dialog dialog) {
            this.a = dialog;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            this.a.show();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: tb.n90$c */
    /* loaded from: classes6.dex */
    public static class C9466c {
        private ay2 a;
        private int b = 0;
        private ArrayMap<String, Integer> c = new ArrayMap<>();
        private ArrayMap<Integer, DXTemplateItem> d = new ArrayMap<>();
        private ArrayMap<Integer, ArrayList<IDMComponent>> e = new ArrayMap<>();

        public C9466c(ay2 ay2Var) {
            this.a = ay2Var;
        }

        public ArrayList<IDMComponent> a(int i) {
            return this.e.get(Integer.valueOf(i));
        }

        public DXTemplateItem b(int i) {
            return this.d.get(Integer.valueOf(i));
        }

        public int c(IDMComponent iDMComponent) {
            if (iDMComponent == null || iDMComponent.getContainerInfo() == null) {
                return -1;
            }
            DXTemplateItem a = ((l90) ((vl2) this.a.getService(vl2.class)).b(iDMComponent.getContainerType())).a(iDMComponent.getContainerInfo().getString("name"));
            if (a == null) {
                return -1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a.name);
            sb.append(a.version);
            Integer num = this.c.get(sb.toString());
            if (num == null) {
                int i = this.b;
                this.b = i + 1;
                num = Integer.valueOf(i);
                this.c.put(sb.toString(), num);
                this.d.put(num, a);
                ArrayList<IDMComponent> arrayList = new ArrayList<>();
                arrayList.add(iDMComponent);
                this.e.put(num, arrayList);
            } else {
                this.e.get(num).add(iDMComponent);
            }
            return num.intValue();
        }
    }

    public n90(ay2 ay2Var) {
        this.b = ay2Var;
        this.a = new C9466c(ay2Var);
        DTemplateManager.q(this.b.p()).p(DTemplateManager.CacheStrategy.STRATEGY_ALLOW_VERSION_DEGRADE);
        g();
    }

    private View a(View view, DXTemplateItem dXTemplateItem) {
        String str;
        String str2;
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        String str3 = "";
        if (dXTemplateItem != null) {
            String str4 = dXTemplateItem.name;
            str2 = String.valueOf(dXTemplateItem.version);
            str3 = dXTemplateItem.templateUrl;
            str = str4;
        } else {
            str = "";
            str2 = str;
        }
        AlertDialog.Builder title = new AlertDialog.Builder(view.getContext()).setTitle(str);
        frameLayout.setOnLongClickListener(new View$OnLongClickListenerC9465b(this, title.setMessage("version: " + str2 + StringUtils.LF + "url: " + str3).setPositiveButton("复制URL", new DialogInterface$OnClickListenerC9464a(this, view, str3)).create()));
        frameLayout.addView(view);
        return frameLayout;
    }

    private View b(View view, DXTemplateItem dXTemplateItem) {
        String str;
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        String str2 = "";
        if (dXTemplateItem != null) {
            str2 = dXTemplateItem.name;
            str = String.valueOf(dXTemplateItem.version);
        } else {
            str = "";
        }
        TextView textView = new TextView(view.getContext());
        textView.setText("d: " + str2 + " : " + str);
        textView.setTextColor(858993459);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 48));
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        view.setTag("DXRootView");
        frameLayout.addView(view);
        frameLayout.addView(textView);
        return frameLayout;
    }

    private void c(long j, DXTemplateItem dXTemplateItem) {
        if (d.booleanValue()) {
            String str = dXTemplateItem.name;
            long currentTimeMillis = System.currentTimeMillis() - j;
            AliLogInterface c = o4.c();
            if (c != null) {
                c.logd("ultron-view-kit", "templateName: " + str + "\n create duration -------> " + currentTimeMillis);
            }
        }
    }

    private void d(long j, IDMComponent iDMComponent) {
        if (d.booleanValue()) {
            String tag = iDMComponent.getTag();
            String type = iDMComponent.getType();
            String string = iDMComponent.getContainerInfo().getString("name");
            long currentTimeMillis = System.currentTimeMillis() - j;
            vt2.a("ultron-view-kit", "tag: " + tag + ", type: " + type + ", templateName: " + string + "\n bind duration --------> " + currentTimeMillis);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder e(android.view.ViewGroup r19, com.taobao.android.dinamicx.template.download.DXTemplateItem r20, java.util.List<com.taobao.android.ultron.common.model.IDMComponent> r21) {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.n90.e(android.view.ViewGroup, com.taobao.android.dinamicx.template.download.DXTemplateItem, java.util.List):com.alibaba.android.ultron.vfw.viewholder.RecyclerViewHolder");
    }

    private void g() {
        try {
            this.b.n().f(iz.a("handleDinamicXEvent"), new k90());
            this.b.n().g("handleDinamicXEvent", new j90());
        } catch (DinamicException e) {
            vt2.b("registerEventHandler error", e.toString());
        }
    }

    private void h(List<IDMComponent> list, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).getExtMap().put(IDowngradeSupport.KEY_DOWNGRADE_STATE, Boolean.valueOf(z));
        }
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public void bindData(RecyclerViewHolder recyclerViewHolder, IDMComponent iDMComponent) {
        DXRootView dXRootView;
        String key;
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject containerInfo = iDMComponent.getContainerInfo();
        String string = containerInfo != null ? containerInfo.getString("name") : "";
        try {
            JSONObject data = iDMComponent.getData();
            int modifiedCount = iDMComponent.getModifiedCount();
            Map<String, Object> a = recyclerViewHolder.a(iDMComponent);
            a.putAll(this.b.m());
            View view = recyclerViewHolder.itemView;
            C6387n d2 = this.b.n().d();
            int f = z00.f();
            int e = z00.e();
            if (view instanceof DXRootView) {
                dXRootView = (DXRootView) view;
            } else {
                dXRootView = (DXRootView) view.findViewWithTag("DXRootView");
            }
            ViewGroup viewGroup = this.c;
            t00<DXRootView> n = d2.n(this.b.l(), data, dXRootView, viewGroup != null ? View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824) : f, e, a);
            if (dXRootView != null && r40.a(this.b.l())) {
                dXRootView.setImportantForAccessibility(1);
                if (TextUtils.isEmpty(iDMComponent.getTag())) {
                    key = iDMComponent.getId();
                } else {
                    key = iDMComponent.getKey();
                }
                dXRootView.setContentDescription(key);
            }
            if (n != null && n.c()) {
                vt2.b("DinamicXViewHolderProvider", "bindData", "error component", iDMComponent.getTag(), iDMComponent.getType(), containerInfo != null ? containerInfo.toJSONString() : "");
                String a2 = c90.a(n.a());
                vt2.b("DinamicXViewHolderProvider", "bindData", WXImage.ERRORDESC, a2);
                String k = this.b.k();
                UmbrellaTracker.commitFailureStability(KEY_FESTRUE_COMPONT, "bindDataError", "1.0", k, null, null, "bindDataError$" + string, a2);
                if (r40.a(this.b.l())) {
                    AlertDialog create = new AlertDialog.Builder(this.b.l()).create();
                    create.setTitle("模板bind错误");
                    create.setMessage("模板： " + string + StringUtils.LF + a2);
                    create.show();
                }
            }
            recyclerViewHolder.e(modifiedCount);
        } catch (Exception e2) {
            vt2.b("DinamicXViewHolderProvider", "bindData", WXImage.ERRORDESC, e2.getMessage());
            String k2 = this.b.k();
            UmbrellaTracker.commitFailureStability(KEY_FESTRUE_COMPONT, "bindDataException", "1.0", k2, null, null, "bindDataExp$" + string, e2.getMessage());
        }
        d(currentTimeMillis, iDMComponent);
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public RecyclerViewHolder createViewHolder(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.c = viewGroup;
        DXTemplateItem b = this.a.b(i);
        RecyclerViewHolder e = e(viewGroup, b, this.a.a(i));
        if (b == null) {
            return e;
        }
        c(currentTimeMillis, b);
        return e;
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public void destroy() {
    }

    public DXTemplateItem f(int i) {
        return this.a.b(i);
    }

    @Override // com.alibaba.android.ultron.vfw.viewholder.IViewHolderProvider
    public int getItemViewType(IDMComponent iDMComponent) {
        return this.a.c(iDMComponent);
    }
}
