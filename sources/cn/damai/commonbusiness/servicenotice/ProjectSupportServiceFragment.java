package cn.damai.commonbusiness.servicenotice;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.commonbusiness.contacts.bean.IdCardTypes;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.irecycler.IRecyclerView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ProjectSupportServiceFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String TAG = ProjectSupportServiceFragment.class.getSimpleName();
    private ArrayList<IdCardTypes> mCardTypes;
    private View.OnClickListener mOnCompleteClickListener;
    private OnCompleteListener mOnCompleteListener;
    private ArrayList<ServiceNote> mServiceNoteList;
    private IRecyclerView mServiceRecyclerView;
    private ProjectSupportServiceAdapter mSupportServiceAdapter;
    private DMIconFontTextView mTvComplete;
    private TextView mTvTitle;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-32189729")) {
                ipChange.ipc$dispatch("-32189729", new Object[]{this, view});
            } else if (ProjectSupportServiceFragment.this.mOnCompleteListener != null) {
                ProjectSupportServiceFragment.this.mOnCompleteListener.onComplete(3);
            }
        }
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1142979615")) {
            ipChange.ipc$dispatch("1142979615", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mServiceNoteList = arguments.getParcelableArrayList("service_notes");
            this.mCardTypes = arguments.getParcelableArrayList("card_types");
        }
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1222558618")) {
            ipChange.ipc$dispatch("1222558618", new Object[]{this});
        } else {
            this.mOnCompleteClickListener = new a();
        }
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1524835573")) {
            ipChange.ipc$dispatch("-1524835573", new Object[]{this});
            return;
        }
        TextView textView = (TextView) this.rootView.findViewById(R$id.layer_title);
        this.mTvTitle = textView;
        textView.setText("服务说明");
        this.mTvComplete = (DMIconFontTextView) this.rootView.findViewById(R$id.layer_close);
        IRecyclerView iRecyclerView = (IRecyclerView) this.rootView.findViewById(R$id.project_support_service_irc);
        this.mServiceRecyclerView = iRecyclerView;
        iRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mServiceRecyclerView.setRefreshEnabled(false);
        this.mServiceRecyclerView.setLoadMoreEnabled(false);
        this.mServiceRecyclerView.setIsAutoToDefault(false);
        this.mServiceRecyclerView.setOnLoadMoreListener(null);
        ProjectSupportServiceAdapter projectSupportServiceAdapter = new ProjectSupportServiceAdapter(getActivity(), this.mServiceNoteList);
        this.mSupportServiceAdapter = projectSupportServiceAdapter;
        projectSupportServiceAdapter.a(this.mCardTypes);
        this.mServiceRecyclerView.setAdapter(this.mSupportServiceAdapter);
    }

    public static final ProjectSupportServiceFragment newInstance(ArrayList<ServiceNote> arrayList, ArrayList<IdCardTypes> arrayList2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "801436193")) {
            return (ProjectSupportServiceFragment) ipChange.ipc$dispatch("801436193", new Object[]{arrayList, arrayList2});
        }
        ProjectSupportServiceFragment projectSupportServiceFragment = new ProjectSupportServiceFragment();
        if (arrayList != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("service_notes", arrayList);
            bundle.putParcelableArrayList("card_types", arrayList2);
            projectSupportServiceFragment.setArguments(bundle);
        }
        return projectSupportServiceFragment;
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2129700063")) {
            ipChange.ipc$dispatch("2129700063", new Object[]{this});
        } else {
            this.mTvComplete.setOnClickListener(this.mOnCompleteClickListener);
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1196307950") ? ((Integer) ipChange.ipc$dispatch("1196307950", new Object[]{this})).intValue() : R$layout.layout_service_notice;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1728903898")) {
            ipChange.ipc$dispatch("1728903898", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-867692911")) {
            ipChange.ipc$dispatch("-867692911", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127470228")) {
            ipChange.ipc$dispatch("-2127470228", new Object[]{this});
            return;
        }
        initExtraData();
        initViews();
        initListeners();
        setupListeners();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "950634635")) {
            ipChange.ipc$dispatch("950634635", new Object[]{this, context});
            return;
        }
        super.onAttach(context);
        try {
            this.mOnCompleteListener = (OnCompleteListener) getParentFragment();
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1760004178")) {
            ipChange.ipc$dispatch("1760004178", new Object[]{this, view});
        }
    }

    public void setOnCompleteListener(OnCompleteListener onCompleteListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1180935821")) {
            ipChange.ipc$dispatch("-1180935821", new Object[]{this, onCompleteListener});
        } else {
            this.mOnCompleteListener = onCompleteListener;
        }
    }

    public static final ProjectSupportServiceFragment newInstance(ArrayList<ServiceNote> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465996573")) {
            return (ProjectSupportServiceFragment) ipChange.ipc$dispatch("-1465996573", new Object[]{arrayList});
        }
        ProjectSupportServiceFragment projectSupportServiceFragment = new ProjectSupportServiceFragment();
        if (arrayList != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("service_notes", arrayList);
            projectSupportServiceFragment.setArguments(bundle);
        }
        return projectSupportServiceFragment;
    }
}
