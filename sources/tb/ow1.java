package tb;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.R$style;
import cn.damai.commonbusiness.servicenotice.OnCompleteListener;
import cn.damai.commonbusiness.servicenotice.ProjectSupportServiceAdapter;
import cn.damai.commonbusiness.servicenotice.ServiceNote;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
@RequiresApi(api = 11)
/* loaded from: classes.dex */
public class ow1 extends DialogFragment implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private IRecyclerView b;
    private ProjectSupportServiceAdapter c;
    private ArrayList<ServiceNote> d;
    private OnCompleteListener e;

    private void a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-987051342")) {
            ipChange.ipc$dispatch("-987051342", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.d = arguments.getParcelableArrayList("service_notes");
        }
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-7566092")) {
            ipChange.ipc$dispatch("-7566092", new Object[]{this, view});
            return;
        }
        TextView textView = (TextView) view.findViewById(R$id.layer_title);
        this.a = textView;
        textView.setText("服务说明");
        view.findViewById(R$id.v_outside).setOnClickListener(this);
        view.findViewById(R$id.layer_close).setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.rl_bottom);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = (int) (DisplayMetrics.getheightPixels(m62.b(getActivity())) * 0.75d);
        linearLayout.setLayoutParams(layoutParams);
        IRecyclerView iRecyclerView = (IRecyclerView) view.findViewById(R$id.project_support_service_irc);
        this.b = iRecyclerView;
        iRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.b.setRefreshEnabled(false);
        this.b.setLoadMoreEnabled(false);
        this.b.setIsAutoToDefault(false);
        this.b.setOnLoadMoreListener(null);
        ProjectSupportServiceAdapter projectSupportServiceAdapter = new ProjectSupportServiceAdapter(getActivity(), this.d);
        this.c = projectSupportServiceAdapter;
        this.b.setAdapter(projectSupportServiceAdapter);
    }

    public static final ow1 c(ArrayList<ServiceNote> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1636862473")) {
            return (ow1) ipChange.ipc$dispatch("1636862473", new Object[]{arrayList});
        }
        ow1 ow1Var = new ow1();
        if (arrayList != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("service_notes", arrayList);
            ow1Var.setArguments(bundle);
        }
        return ow1Var;
    }

    public void d(OnCompleteListener onCompleteListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-202033338")) {
            ipChange.ipc$dispatch("-202033338", new Object[]{this, onCompleteListener});
        } else {
            this.e = onCompleteListener;
        }
    }

    public void e(FragmentManager fragmentManager) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "136620193")) {
            ipChange.ipc$dispatch("136620193", new Object[]{this, fragmentManager});
            return;
        }
        try {
            show(fragmentManager, ow1.class.getName());
            fragmentManager.executePendingTransactions();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "606093490")) {
            ipChange.ipc$dispatch("606093490", new Object[]{this, bundle});
            return;
        }
        getDialog().requestWindowFeature(1);
        super.onActivityCreated(bundle);
        int i = (int) (DisplayMetrics.getheightPixels(m62.b(getActivity())) * 0.75d);
        Window window = getDialog().getWindow();
        window.setLayout(-1, i);
        window.setGravity(80);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.windowAnimations = R$style.ActionSheetDialogAnimation;
        window.setAttributes(attributes);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnCompleteListener onCompleteListener;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1377386337")) {
            ipChange.ipc$dispatch("-1377386337", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if ((R$id.v_outside == id || R$id.layer_close == id) && (onCompleteListener = this.e) != null) {
            onCompleteListener.onComplete(3);
        }
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1173455009")) {
            ipChange.ipc$dispatch("1173455009", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setStyle(2, R$style.MyDialogStyle);
    }

    @Override // android.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "70924355")) {
            return (View) ipChange.ipc$dispatch("70924355", new Object[]{this, layoutInflater, viewGroup, bundle});
        }
        View inflate = layoutInflater.inflate(R$layout.layout_service_notice_rl, viewGroup);
        a();
        b(inflate);
        return inflate;
    }
}
