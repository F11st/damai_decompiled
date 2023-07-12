package cn.damai.mine.activity;

import android.app.DatePickerDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.base.DamaiBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.R$string;
import cn.damai.homepage.R$style;
import cn.damai.mine.bean.ProfileInfo;
import cn.damai.mine.contract.EditAccountInfoContract;
import cn.damai.mine.model.EditAccountInfoModel;
import cn.damai.mine.param.SaveUserRequest;
import cn.damai.mine.presenter.EditAccountInfoPresenter;
import cn.damai.mine.view.SelectDialog;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;
import tb.cb1;
import tb.cm2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class EditAccountInfoActivity extends DamaiBaseActivity<EditAccountInfoPresenter, EditAccountInfoModel> implements EditAccountInfoContract.View {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "EditAccountInfoActivity";
    private RelativeLayout birthdayChoiceLayout;
    private TextView birthdayText;
    private TextView cancleTV;
    private TextView confirmTV;
    private EditText desContentText;
    private EditText nickNameTV;
    private RelativeLayout sexChoiceLayout;
    private TextView sexText;
    private int mSex = 0;
    private String mBirthDate = "";
    private String birth = "";
    private String mNickName = "";
    private String mUserIntro = "";
    DatePickerDialog.OnDateSetListener dateListener = new C1373b();

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.EditAccountInfoActivity$a */
    /* loaded from: classes6.dex */
    public class C1372a implements SelectDialog.OnDialogClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1372a() {
        }

        @Override // cn.damai.mine.view.SelectDialog.OnDialogClickListener
        public void onDismiss() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1681642652")) {
                ipChange.ipc$dispatch("1681642652", new Object[]{this});
            }
        }

        @Override // cn.damai.mine.view.SelectDialog.OnDialogClickListener
        public void onFirstSel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "917361114")) {
                ipChange.ipc$dispatch("917361114", new Object[]{this});
                return;
            }
            EditAccountInfoActivity.this.mSex = 1;
            EditAccountInfoActivity editAccountInfoActivity = EditAccountInfoActivity.this;
            editAccountInfoActivity.setUserSex(editAccountInfoActivity.mSex);
        }

        @Override // cn.damai.mine.view.SelectDialog.OnDialogClickListener
        public void onSecondSel() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "52922912")) {
                ipChange.ipc$dispatch("52922912", new Object[]{this});
                return;
            }
            EditAccountInfoActivity.this.mSex = 0;
            EditAccountInfoActivity editAccountInfoActivity = EditAccountInfoActivity.this;
            editAccountInfoActivity.setUserSex(editAccountInfoActivity.mSex);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.mine.activity.EditAccountInfoActivity$b */
    /* loaded from: classes15.dex */
    public class C1373b implements DatePickerDialog.OnDateSetListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C1373b() {
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
            String str;
            String str2;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1435868806")) {
                ipChange.ipc$dispatch("-1435868806", new Object[]{this, datePicker, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                return;
            }
            int i4 = i2 + 1;
            if (i4 < 10) {
                str = "0" + i4;
            } else {
                str = i4 + "";
            }
            if (i3 < 10) {
                str2 = "0" + i3;
            } else {
                str2 = i3 + "";
            }
            if (EditAccountInfoActivity.this.birth.equals(i + "-" + str + "-" + str2)) {
                return;
            }
            EditAccountInfoActivity.this.birth = i + "-" + str + "-" + str2;
            EditAccountInfoActivity editAccountInfoActivity = EditAccountInfoActivity.this;
            editAccountInfoActivity.parseBirthDay(editAccountInfoActivity.birth);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseBirthDay(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1334741550")) {
            ipChange.ipc$dispatch("1334741550", new Object[]{this, str});
            return;
        }
        try {
            Date parse = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT).parse(str);
            this.mBirthDate = new SimpleDateFormat("yyyy" + cm2.b(this, R$string.damai_modifyuserdata_year) + "MM" + cm2.b(this, R$string.damai_modifyuserdata_month) + "dd" + cm2.b(this, R$string.damai_modifyuserdata_day)).format(parse);
        } catch (ParseException e) {
            cb1.d(e);
            this.birth = "1990-01-01";
            this.mBirthDate = "1990" + cm2.b(this, R$string.damai_modifyuserdata_year) + HiAnalyticsConstant.KeyAndValue.NUMBER_01 + cm2.b(this, R$string.damai_modifyuserdata_month) + HiAnalyticsConstant.KeyAndValue.NUMBER_01 + cm2.b(this, R$string.damai_modifyuserdata_day);
        }
        this.birthdayText.setText(this.mBirthDate);
    }

    private void parseUserData(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1235384970")) {
            ipChange.ipc$dispatch("-1235384970", new Object[]{this, str});
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optBoolean("os")) {
                this.birth = jSONObject.optString("birthday");
                int optInt = jSONObject.optInt("sex");
                this.mSex = optInt;
                setUserSex(optInt);
                if (TextUtils.isEmpty(this.birth)) {
                    this.birth = "1970-01-01";
                }
                parseBirthDay(this.birth);
                this.birthdayText.setText(this.mBirthDate);
            }
        } catch (Exception e) {
            cb1.d(e);
        }
    }

    private void requestSaveAccountInfoMsg() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2127062782")) {
            ipChange.ipc$dispatch("-2127062782", new Object[]{this});
        } else if (TextUtils.isEmpty(this.nickNameTV.getText().toString())) {
            ToastUtil.i("请输入昵称");
        } else if (TextUtils.isEmpty(this.birthdayText.getText().toString())) {
            ToastUtil.i("请输入生日");
        } else {
            showLoading("加载中");
            SaveUserRequest saveUserRequest = new SaveUserRequest();
            if ("男".equals(this.sexText.getText().toString())) {
                saveUserRequest.sex = 1;
            } else {
                saveUserRequest.sex = 0;
            }
            saveUserRequest.nickName = this.nickNameTV.getText().toString();
            saveUserRequest.birthday = this.birth;
            saveUserRequest.userIntro = this.desContentText.getText().toString();
            saveUserRequest.loginKey = z20.q();
            ((EditAccountInfoPresenter) this.mPresenter).saveProfileInfo(saveUserRequest);
        }
    }

    private void selectBirth() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1036852561")) {
            ipChange.ipc$dispatch("1036852561", new Object[]{this});
            return;
        }
        Calendar calendar = Calendar.getInstance();
        if (!TextUtils.isEmpty(this.birth)) {
            String[] split = this.birth.split("-");
            if (TextUtils.isEmpty(split[0])) {
                return;
            }
            new DatePickerDialog(this, this.dateListener, Integer.parseInt(split[0]), Integer.parseInt(split[1]) - 1, Integer.parseInt(split[2])).show();
            return;
        }
        new DatePickerDialog(this, this.dateListener, calendar.get(1), calendar.get(2), calendar.get(5)).show();
    }

    private void selectSex() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1279714058")) {
            ipChange.ipc$dispatch("1279714058", new Object[]{this});
            return;
        }
        SelectDialog selectDialog = new SelectDialog(this, R$style.custom_dialog_style);
        selectDialog.e(cm2.b(this, R$string.damai_modifyuserdata_male), cm2.b(this, R$string.damai_modifyuserdata_girl));
        selectDialog.f(new C1372a());
        selectDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUserSex(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1711292058")) {
            ipChange.ipc$dispatch("-1711292058", new Object[]{this, Integer.valueOf(i)});
        } else if (i == 0) {
            this.sexText.setText(cm2.b(this, R$string.damai_modifyuserdata_girl));
        } else {
            this.sexText.setText(cm2.b(this, R$string.damai_modifyuserdata_male));
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void dealHeaderClick(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "343783198")) {
            ipChange.ipc$dispatch("343783198", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "365707276") ? ((Integer) ipChange.ipc$dispatch("365707276", new Object[]{this})).intValue() : R$layout.edit_account_info_layout;
    }

    @Override // cn.damai.commonbusiness.base.ResponseErrorPage.ErrorRefreshListener
    public void handleError(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884992239")) {
            ipChange.ipc$dispatch("884992239", new Object[]{this, Integer.valueOf(i)});
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initPresenter() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1259150564")) {
            ipChange.ipc$dispatch("-1259150564", new Object[]{this});
        } else {
            ((EditAccountInfoPresenter) this.mPresenter).setVM(this, (EditAccountInfoContract.Model) this.mModel);
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public void initView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1750114817")) {
            ipChange.ipc$dispatch("1750114817", new Object[]{this});
            return;
        }
        removeHeadTitleView();
        setDamaiUTKeyBuilder(new C0525a.C0527b().i("account_info_edit"));
        this.mSex = getIntent().getIntExtra("sex", 0);
        this.mNickName = getIntent().getStringExtra("nickName");
        this.mUserIntro = getIntent().getStringExtra("userIntro");
        String stringExtra = getIntent().getStringExtra("birthday");
        this.birth = stringExtra;
        if (stringExtra == null) {
            this.birth = "";
        }
        TextView textView = (TextView) findViewById(R$id.tv_cancle);
        this.cancleTV = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R$id.tv_confirm);
        this.confirmTV = textView2;
        textView2.setOnClickListener(this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R$id.sex_layout);
        this.sexChoiceLayout = relativeLayout;
        relativeLayout.setOnClickListener(this);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R$id.birthday_layout);
        this.birthdayChoiceLayout = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        this.desContentText = (EditText) findViewById(R$id.desc_content);
        TextView textView3 = (TextView) findViewById(R$id.sex_content);
        this.sexText = textView3;
        if (this.mSex == 0) {
            textView3.setText("女");
        } else {
            textView3.setText("男");
        }
        this.birthdayText = (TextView) findViewById(R$id.birthday_content);
        if (!TextUtils.isEmpty(this.birth)) {
            parseBirthDay(this.birth);
        }
        EditText editText = (EditText) findViewById(R$id.nick_name);
        this.nickNameTV = editText;
        editText.setText(this.mNickName);
        EditText editText2 = this.nickNameTV;
        editText2.setSelection(editText2.getSelectionEnd());
        this.desContentText.setText(this.mUserIntro);
        EditText editText3 = this.desContentText;
        editText3.setSelection(editText3.getSelectionEnd());
    }

    @Override // cn.damai.common.app.base.BaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1293832793")) {
            ipChange.ipc$dispatch("-1293832793", new Object[]{this, view});
            return;
        }
        super.onClick(view);
        if (view == this.cancleTV) {
            finish();
        } else if (view == this.confirmTV) {
            requestSaveAccountInfoMsg();
        } else if (view == this.sexChoiceLayout) {
            selectSex();
        } else if (view == this.birthdayChoiceLayout) {
            selectBirth();
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadFinish() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2127542814")) {
            ipChange.ipc$dispatch("2127542814", new Object[]{this});
        }
    }

    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity
    public void onLoadStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-711911369")) {
            ipChange.ipc$dispatch("-711911369", new Object[]{this});
        }
    }

    @Override // cn.damai.mine.contract.EditAccountInfoContract.View
    public void returnProfileInfo(ProfileInfo profileInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1443482787")) {
            ipChange.ipc$dispatch("1443482787", new Object[]{this, profileInfo});
        }
    }

    @Override // cn.damai.mine.contract.EditAccountInfoContract.View
    public void returnProfileInfoFalse(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1559409678")) {
            ipChange.ipc$dispatch("1559409678", new Object[]{this, str, str2});
        }
    }

    @Override // cn.damai.mine.contract.EditAccountInfoContract.View
    public void returnSaveUserProfile(ProfileInfo profileInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1616298297")) {
            ipChange.ipc$dispatch("1616298297", new Object[]{this, profileInfo});
            return;
        }
        if (profileInfo != null) {
            if (!TextUtils.isEmpty(profileInfo.successMsg)) {
                ToastUtil.i(profileInfo.successMsg);
            }
            C0529c.e().z(new C0528b().c("account_info_edit", "top", "submit", Boolean.TRUE));
        }
        stopLoading();
        setResult(-1);
        finish();
    }

    @Override // cn.damai.mine.contract.EditAccountInfoContract.View
    public void returnSaveUserProfileFalse(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1258326072")) {
            ipChange.ipc$dispatch("1258326072", new Object[]{this, str, str2});
            return;
        }
        ToastUtil.i(str2);
        stopLoading();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1113006464")) {
            return (String) ipChange.ipc$dispatch("1113006464", new Object[]{this});
        }
        return null;
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showEmptyView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1808693855")) {
            ipChange.ipc$dispatch("1808693855", new Object[]{this});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showErrorTips(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-298293413")) {
            ipChange.ipc$dispatch("-298293413", new Object[]{this, str});
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void showLoading(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "317823999")) {
            ipChange.ipc$dispatch("317823999", new Object[]{this, str});
        } else {
            startProgressDialog();
        }
    }

    @Override // cn.damai.common.app.base.BaseView
    public void stopLoading() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1485336634")) {
            ipChange.ipc$dispatch("1485336634", new Object[]{this});
        } else {
            stopProgressDialog();
        }
    }
}
