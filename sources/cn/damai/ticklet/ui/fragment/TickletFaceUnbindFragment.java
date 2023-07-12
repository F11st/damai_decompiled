package cn.damai.ticklet.ui.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cn.damai.common.app.widget.DMDialog;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseMvpFragment;
import cn.damai.login.LoginManager;
import cn.damai.member.R$id;
import cn.damai.member.R$layout;
import cn.damai.member.R$string;
import cn.damai.ticklet.bean.TicketDeatilResult;
import cn.damai.ticklet.bean.TickletFaceUnbindResult;
import cn.damai.ticklet.bean.UserTicketTable;
import cn.damai.ticklet.net.TickletFaceUnbindRequest;
import cn.damai.ticklet.ui.activity.TickletFaceSettingActivity;
import cn.damai.ticklet.view.TickletFaceUnbindDialogView;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.cb1;
import tb.py2;
import tb.un2;
import tb.xn2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class TickletFaceUnbindFragment extends DamaiBaseMvpFragment {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final int REQUEST_CODE_UNBIND_FOR_LOGIN = 1;
    private static final String TAG = TickletFaceUnbindFragment.class.getSimpleName();
    private LinearLayout mLvFaceUnbindTicketSeat;
    private OnFaceUnbindListener mOnFaceUnbindListener;
    private View.OnClickListener mOnShowCredentialsClickListener;
    private View.OnClickListener mOnUnbindFaceClickListener;
    private TicketDeatilResult mTicketDetailResult;
    private String mTicketId;
    private UserTicketTable mTicketTable;
    private TextView mTvFaceShowCredentials;
    private TextView mTvFaceUnbind;
    private TextView mTvFaceUnbindCertNum;
    private TextView mTvFaceUnbindNote;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface OnFaceUnbindListener {
        void onFaceUnbind(boolean z, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "984261476")) {
                ipChange.ipc$dispatch("984261476", new Object[]{this, view});
                return;
            }
            if (TickletFaceUnbindFragment.this.mTicketTable != null && TickletFaceUnbindFragment.this.mTicketDetailResult != null) {
                cn.damai.common.user.c.e().x(un2.k().E(TickletFaceUnbindFragment.this.mTicketDetailResult.getProjectId(), TickletFaceUnbindFragment.this.mTicketTable.performId, TickletFaceUnbindFragment.this.mTicketTable.voucherUniqueKey));
            }
            TickletFaceUnbindFragment.this.showTicketFaceUnbindDialog();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1199415451")) {
                ipChange.ipc$dispatch("-1199415451", new Object[]{this, view});
                return;
            }
            FragmentActivity activity = TickletFaceUnbindFragment.this.getActivity();
            if (activity == null || !(activity instanceof TickletFaceSettingActivity) || TickletFaceUnbindFragment.this.mTicketTable == null || TickletFaceUnbindFragment.this.mTicketDetailResult == null) {
                return;
            }
            cn.damai.common.user.c.e().x(un2.k().M(TickletFaceUnbindFragment.this.mTicketDetailResult.getProjectId(), TickletFaceUnbindFragment.this.mTicketTable.performId, TickletFaceUnbindFragment.this.mTicketTable.voucherUniqueKey));
            ((TickletFaceSettingActivity) activity).showCredentialsInfoDialog(TickletFaceUnbindFragment.this.mTicketDetailResult, TickletFaceUnbindFragment.this.mTicketTable);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1070009417")) {
                ipChange.ipc$dispatch("1070009417", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else if (TickletFaceUnbindFragment.this.mTicketTable == null || TickletFaceUnbindFragment.this.mTicketDetailResult == null) {
            } else {
                cn.damai.common.user.c.e().x(un2.k().G(TickletFaceUnbindFragment.this.mTicketDetailResult.getProjectId(), TickletFaceUnbindFragment.this.mTicketTable.performId, TickletFaceUnbindFragment.this.mTicketTable.voucherUniqueKey));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class d implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2039590440")) {
                ipChange.ipc$dispatch("2039590440", new Object[]{this, dialogInterface, Integer.valueOf(i)});
                return;
            }
            if (TickletFaceUnbindFragment.this.mTicketTable != null && TickletFaceUnbindFragment.this.mTicketDetailResult != null) {
                cn.damai.common.user.c.e().x(un2.k().F(TickletFaceUnbindFragment.this.mTicketDetailResult.getProjectId(), TickletFaceUnbindFragment.this.mTicketTable.performId, TickletFaceUnbindFragment.this.mTicketTable.voucherUniqueKey));
            }
            TickletFaceUnbindFragment.this.executeFaceUnbindRequest();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeFaceUnbindRequest() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1699746303")) {
            ipChange.ipc$dispatch("1699746303", new Object[]{this});
            return;
        }
        cb1.b(TAG, "executeFaceUnbindRequest()");
        if (TextUtils.isEmpty(this.mTicketId)) {
            return;
        }
        if (LoginManager.k().q()) {
            startProgressDialog();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mTicketId);
            TickletFaceUnbindRequest tickletFaceUnbindRequest = new TickletFaceUnbindRequest();
            tickletFaceUnbindRequest.ticketIdList = JSON.toJSONString(arrayList);
            tickletFaceUnbindRequest.loginKey = z20.q();
            tickletFaceUnbindRequest.request(new DMMtopRequestListener<TickletFaceUnbindResult>(TickletFaceUnbindResult.class) { // from class: cn.damai.ticklet.ui.fragment.TickletFaceUnbindFragment.5
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onFail(String str, String str2) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "1259324366")) {
                        ipChange2.ipc$dispatch("1259324366", new Object[]{this, str, str2});
                        return;
                    }
                    TickletFaceUnbindFragment.this.stopProgressDialog();
                    ToastUtil.a().j(TickletFaceUnbindFragment.this.mActivity, str2);
                    TickletFaceUnbindFragment tickletFaceUnbindFragment = TickletFaceUnbindFragment.this;
                    tickletFaceUnbindFragment.unbindErrorXFlushMonitor(str, str2, tickletFaceUnbindFragment.mTicketId);
                }

                @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                public void onSuccess(TickletFaceUnbindResult tickletFaceUnbindResult) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1336336265")) {
                        ipChange2.ipc$dispatch("-1336336265", new Object[]{this, tickletFaceUnbindResult});
                        return;
                    }
                    TickletFaceUnbindFragment.this.stopProgressDialog();
                    TickletFaceUnbindFragment.this.faceUnbindResultProcess(tickletFaceUnbindResult);
                }
            });
            return;
        }
        LoginManager.k().y(this, new Intent(), 1);
    }

    private void faceUnbindFailure(TickletFaceUnbindResult tickletFaceUnbindResult) {
        TickletFaceUnbindResult.UserFaceUnbindInfo userFaceUnbindInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "882139385")) {
            ipChange.ipc$dispatch("882139385", new Object[]{this, tickletFaceUnbindResult});
            return;
        }
        List<TickletFaceUnbindResult.UserFaceUnbindInfo> list = tickletFaceUnbindResult.userFaceUnbindingInfoList;
        if (list == null || list.size() <= 0 || (userFaceUnbindInfo = list.get(0)) == null) {
            return;
        }
        ToastUtil.a().j(getActivity(), userFaceUnbindInfo.opResultNote);
        unbindErrorXFlushMonitor(xn2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FACE_UNBIND_FAIL, tickletFaceUnbindResult.userFaceUnbindingInfoList.get(0).opResultMsg, this.mTicketId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void faceUnbindResultProcess(TickletFaceUnbindResult tickletFaceUnbindResult) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-489450879")) {
            ipChange.ipc$dispatch("-489450879", new Object[]{this, tickletFaceUnbindResult});
        } else if (tickletFaceUnbindResult != null) {
            if ("1".equals(tickletFaceUnbindResult.allSuccess)) {
                if (tickletFaceUnbindResult.userFaceUnbindingInfoList.size() > 0 && tickletFaceUnbindResult.userFaceUnbindingInfoList.get(0) != null && !TextUtils.isEmpty(tickletFaceUnbindResult.userFaceUnbindingInfoList.get(0).opResultMsg)) {
                    faceUnbindSuccess(tickletFaceUnbindResult.userFaceUnbindingInfoList.get(0).opResultMsg);
                    return;
                } else {
                    faceUnbindSuccess("解绑成功");
                    return;
                }
            }
            faceUnbindFailure(tickletFaceUnbindResult);
        } else {
            renderErrorXFlushMonitor(xn2.TICKLET_PERFORM_DETAIL_RENDER_BIND_FAIL_MSG, this.mTicketId);
        }
    }

    private void faceUnbindSuccess(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1119649538")) {
            ipChange.ipc$dispatch("-1119649538", new Object[]{this, str});
            return;
        }
        ToastUtil.a().j(getActivity(), str);
        OnFaceUnbindListener onFaceUnbindListener = this.mOnFaceUnbindListener;
        if (onFaceUnbindListener != null) {
            onFaceUnbindListener.onFaceUnbind(true, str);
        }
    }

    private void initExtraData() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "46551610")) {
            ipChange.ipc$dispatch("46551610", new Object[]{this});
            return;
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mTicketId = arguments.getString("voucherUniqueKey");
            this.mTicketDetailResult = (TicketDeatilResult) arguments.getSerializable("detailResult");
            this.mTicketTable = (UserTicketTable) arguments.getSerializable("ticketTable");
        }
    }

    private void initListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "126130613")) {
            ipChange.ipc$dispatch("126130613", new Object[]{this});
            return;
        }
        this.mOnUnbindFaceClickListener = new a();
        this.mOnShowCredentialsClickListener = new b();
    }

    private void initViews() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "675280550")) {
            ipChange.ipc$dispatch("675280550", new Object[]{this});
            return;
        }
        this.mTvFaceUnbind = (TextView) this.rootView.findViewById(R$id.ticklet_face_unbind_tv);
        this.mTvFaceShowCredentials = (TextView) this.rootView.findViewById(R$id.ticklet_face_show_credentials_tv);
        this.mTvFaceUnbindNote = (TextView) this.rootView.findViewById(R$id.ticklet_face_unbind_note_tv);
        this.mLvFaceUnbindTicketSeat = (LinearLayout) this.rootView.findViewById(R$id.ticklet_face_unbind_ticket_seat_lv);
        this.mTvFaceUnbindCertNum = (TextView) this.rootView.findViewById(R$id.ticklet_face_unbind_cert_num_tv);
    }

    public static Fragment newInstance(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1414467223")) {
            return (Fragment) ipChange.ipc$dispatch("-1414467223", new Object[]{bundle});
        }
        TickletFaceUnbindFragment tickletFaceUnbindFragment = new TickletFaceUnbindFragment();
        if (bundle != null) {
            tickletFaceUnbindFragment.setArguments(bundle);
        }
        return tickletFaceUnbindFragment;
    }

    private void renderErrorXFlushMonitor(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-918509154")) {
            ipChange.ipc$dispatch("-918509154", new Object[]{this, str, str2});
            return;
        }
        xn2.d(xn2.f(xn2.TICKLET_PERFORM_DETAIL_RENDER_UNBIND_FAIL_MSG, "", "", str, "voucherUniqueKey:" + str2), xn2.TICKLET_PERFORM_DETAIL_RENDER_ERROR_CODE, "", "票夹场次详情渲染失败");
    }

    private void setSeatInfo(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1927186819")) {
            ipChange.ipc$dispatch("1927186819", new Object[]{this, str, str2});
            return;
        }
        this.mLvFaceUnbindTicketSeat.removeAllViews();
        if (!TextUtils.isEmpty(str2)) {
            this.mLvFaceUnbindTicketSeat.setVisibility(0);
            TextView textView = new TextView(getActivity());
            textView.setGravity(17);
            textView.setTextSize(1, 16.0f);
            py2.z(str, textView, "#111111", "#999999");
            textView.setText(str2);
            this.mLvFaceUnbindTicketSeat.addView(textView);
            return;
        }
        this.mLvFaceUnbindTicketSeat.setVisibility(8);
    }

    private void setTicketBindInfo() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109885515")) {
            ipChange.ipc$dispatch("1109885515", new Object[]{this});
        }
    }

    private void setupListeners() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1794797020")) {
            ipChange.ipc$dispatch("-1794797020", new Object[]{this});
            return;
        }
        this.mTvFaceUnbind.setOnClickListener(this.mOnUnbindFaceClickListener);
        this.mTvFaceShowCredentials.setOnClickListener(this.mOnShowCredentialsClickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTicketFaceUnbindDialog() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "404813026")) {
            ipChange.ipc$dispatch("404813026", new Object[]{this});
        } else if (getActivity() == null || getActivity().isFinishing() || this.mTicketTable == null) {
        } else {
            String string = getResources().getString(R$string.ticklet_face_unbind_message_title);
            TickletFaceUnbindDialogView tickletFaceUnbindDialogView = new TickletFaceUnbindDialogView(getContext());
            tickletFaceUnbindDialogView.initSeatData(this.mTicketTable);
            DMDialog dMDialog = new DMDialog(getContext());
            dMDialog.v(string).u(tickletFaceUnbindDialogView).h(getContext().getString(R$string.ticklet_face_unbind), Color.parseColor("#111111"), new d()).m(getContext().getString(R$string.ticklet_transfer_cancel_button_thought), Color.parseColor("#111111"), new c());
            dMDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unbindErrorXFlushMonitor(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439717080")) {
            ipChange.ipc$dispatch("-439717080", new Object[]{this, str, str2, str3});
            return;
        }
        xn2.d(xn2.f(xn2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG_FACE_UNBIND, "mtop.damai.wireless.ticklet2.perform.detail.get", str, str2, "voucherUniqueKey:" + str3), xn2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_CODE, str, xn2.TICKLET_PERFORM_DETAIL_NETWORK_ERROR_MSG);
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected int getLayoutResource() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-191527287") ? ((Integer) ipChange.ipc$dispatch("-191527287", new Object[]{this})).intValue() : R$layout.ticklet_fragment_face_unbind;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-107580065")) {
            ipChange.ipc$dispatch("-107580065", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1964120916")) {
            ipChange.ipc$dispatch("-1964120916", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseFragment
    protected void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-809572751")) {
            ipChange.ipc$dispatch("-809572751", new Object[]{this});
            return;
        }
        initExtraData();
        initViews();
        initListeners();
        setupListeners();
        setTicketBindInfo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2068889642")) {
            ipChange.ipc$dispatch("2068889642", new Object[]{this, bundle});
        } else {
            super.onActivityCreated(bundle);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1412473368")) {
            ipChange.ipc$dispatch("1412473368", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), intent});
            return;
        }
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            executeFaceUnbindRequest();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "390671540")) {
            ipChange.ipc$dispatch("390671540", new Object[]{this, activity});
            return;
        }
        super.onAttach(activity);
        try {
            this.mOnFaceUnbindListener = (OnFaceUnbindListener) activity;
        } catch (ClassCastException unused) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1756252649")) {
            ipChange.ipc$dispatch("-1756252649", new Object[]{this, view});
        }
    }
}
