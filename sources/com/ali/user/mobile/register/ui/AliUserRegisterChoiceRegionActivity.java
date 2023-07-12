package com.ali.user.mobile.register.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.ali.user.mobile.base.helper.SDKExceptionHelper;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.data.LoginComponent;
import com.ali.user.mobile.data.RegisterComponent;
import com.ali.user.mobile.exception.RpcException;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.RegionInfo;
import com.ali.user.mobile.register.RegistConstants;
import com.ali.user.mobile.register.model.BaseRegistRequest;
import com.ali.user.mobile.register.model.MtopCountryCodeContextResult;
import com.ali.user.mobile.register.model.MtopRegisterInitcontextResponseData;
import com.ali.user.mobile.ui.R;
import com.ali.user.mobile.ui.widget.AUBladeView;
import com.ali.user.mobile.ui.widget.AUPinnedHeaderListView;
import com.ali.user.mobile.utils.BackgroundExecutor;
import com.ali.user.mobile.utils.CountryCodeUtil;
import com.ali.user.mobile.utils.MainThreadExecutor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserRegisterChoiceRegionActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final int CHOOSE_REGION_REQUEST = 2001;
    private boolean isFromJSBridge;
    private boolean isFromLogin;
    protected String mErrorMessage;
    protected String mHotCountryTitle;
    private List<String> mLetterList;
    private HashMap<String, Integer> mLetterMap;
    protected AUBladeView mLetterView;
    private List<RegionInfo> mList;
    protected AUPinnedHeaderListView mListView;
    protected String mLocale;
    private String mTitle;

    /* JADX INFO: Access modifiers changed from: private */
    public void getCountryCodeReq(final MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData) {
        MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.register.ui.AliUserRegisterChoiceRegionActivity.3
            @Override // java.lang.Runnable
            public void run() {
                if (AliUserRegisterChoiceRegionActivity.this.isFinishing()) {
                    return;
                }
                AliUserRegisterChoiceRegionActivity.this.afterCountryCode(mtopRegisterInitcontextResponseData);
            }
        });
    }

    private void init() {
        try {
            this.mList = getIntent().getParcelableArrayListExtra(RegistConstants.REGION_INFO);
            this.mLetterMap = (HashMap) getIntent().getSerializableExtra(RegistConstants.LETTER);
            this.mLetterList = getIntent().getStringArrayListExtra(RegistConstants.LETTER_STR);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.mLetterMap == null) {
            this.mLetterMap = new HashMap<>();
        }
        if (this.mLetterList == null) {
            this.mLetterList = new ArrayList();
        }
        if (this.mList != null && this.mLetterMap != null && this.mLetterList.size() > 0) {
            setupAdapter();
        } else {
            getCountryCode();
        }
    }

    private void setupAdapter() {
        this.mListView.setAdapter((ListAdapter) new RegionAdapter(this, this.mList));
        this.mListView.setPinnedHeaderView(LayoutInflater.from(this).inflate(R.C2965layout.aliuser_contact_list_head, (ViewGroup) this.mListView, false));
        this.mListView.setOnItemClickListener(this);
        this.mLetterView.setOnItemClickListener(new AUBladeView.OnItemClickListener() { // from class: com.ali.user.mobile.register.ui.AliUserRegisterChoiceRegionActivity.1
            @Override // com.ali.user.mobile.ui.widget.AUBladeView.OnItemClickListener
            public void onItemClick(String str) {
                int intValue;
                if (str == null || !AliUserRegisterChoiceRegionActivity.this.mLetterMap.containsKey(str) || (intValue = ((Integer) AliUserRegisterChoiceRegionActivity.this.mLetterMap.get(str)).intValue()) == -1) {
                    return;
                }
                AliUserRegisterChoiceRegionActivity.this.mListView.setSelection(intValue);
            }
        });
    }

    void afterCountryCode(MtopRegisterInitcontextResponseData mtopRegisterInitcontextResponseData) {
        T t;
        List<String> list;
        dismissProgressDialog();
        if (mtopRegisterInitcontextResponseData == null || (t = mtopRegisterInitcontextResponseData.returnValue) == 0) {
            return;
        }
        if (((MtopCountryCodeContextResult) t).countrycodes != null) {
            if (TextUtils.isEmpty(this.mHotCountryTitle)) {
                this.mHotCountryTitle = getResources().getString(R.string.aliuser_common_region);
            }
            ArrayList<RegionInfo> fillData = CountryCodeUtil.fillData(this.mHotCountryTitle, ((MtopCountryCodeContextResult) mtopRegisterInitcontextResponseData.returnValue).countrycodes, this.mLetterMap, this.mLetterList);
            this.mList = fillData;
            if (fillData != null && this.mLetterMap != null && (list = this.mLetterList) != null && list.size() > 0) {
                setupAdapter();
                return;
            }
            if (TextUtils.isEmpty(this.mErrorMessage)) {
                this.mErrorMessage = getResources().getString(R.string.aliuser_network_error);
            }
            toast(this.mErrorMessage, 3000);
            return;
        }
        toast(mtopRegisterInitcontextResponseData.message, 3000);
    }

    void getCountryCode() {
        BackgroundExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.register.ui.AliUserRegisterChoiceRegionActivity.2
            @Override // java.lang.Runnable
            public void run() {
                MtopRegisterInitcontextResponseData countryCodeRes;
                try {
                    AliUserRegisterChoiceRegionActivity.this.startAnimation();
                    HashMap hashMap = new HashMap();
                    BaseRegistRequest baseRegistRequest = new BaseRegistRequest();
                    baseRegistRequest.ext = hashMap;
                    if (AliUserRegisterChoiceRegionActivity.this.isFromLogin) {
                        countryCodeRes = (MtopRegisterInitcontextResponseData) LoginComponent.getInstance().getCountryList();
                    } else {
                        countryCodeRes = RegisterComponent.getInstance().countryCodeRes(baseRegistRequest);
                    }
                    AliUserRegisterChoiceRegionActivity.this.getCountryCodeReq(countryCodeRes);
                } catch (RpcException e) {
                    AliUserRegisterChoiceRegionActivity.this.stopAnimation();
                    SDKExceptionHelper.getInstance().rpcExceptionHandler(e);
                }
            }
        });
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity
    protected int getLayoutContent() {
        return R.C2965layout.aliuser_register_region;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        this.mLetterView = (AUBladeView) findViewById(R.id.contacts_letters_list);
        this.mListView = (AUPinnedHeaderListView) findViewById(R.id.register_list);
        if (getSupportActionBar() != null) {
            if (TextUtils.isEmpty(this.mTitle)) {
                this.mTitle = getResources().getString(R.string.aliuser_choose_region);
            }
            getSupportActionBar().setTitle(this.mTitle);
        }
        init();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        setResult(0);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (getIntent() != null) {
            try {
                this.isFromLogin = getIntent().getBooleanExtra("from_login", false);
                this.isFromJSBridge = getIntent().getBooleanExtra("from_jsbridge", false);
                this.mTitle = getIntent().getStringExtra("title");
                this.mHotCountryTitle = getIntent().getStringExtra("hotCountryTitle");
                this.mLocale = getIntent().getStringExtra("locale");
                this.mErrorMessage = getIntent().getStringExtra("errorMsg");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.onCreate(bundle);
    }

    @Override // com.ali.user.mobile.base.ui.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AUPinnedHeaderListView aUPinnedHeaderListView = this.mListView;
        if (aUPinnedHeaderListView != null) {
            aUPinnedHeaderListView.setOnItemClickListener(null);
        }
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        RegionInfo regionInfo = this.mList.get(i);
        Intent intent = new Intent();
        if (!this.isFromJSBridge) {
            intent.putExtra(RegistConstants.REGION_INFO, regionInfo);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("checkPattern", regionInfo.checkPattern);
            jSONObject.put("code", regionInfo.code);
            jSONObject.put("pinyin", regionInfo.pinyin);
            jSONObject.put("domain", regionInfo.domain);
            jSONObject.put("name", regionInfo.name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        intent.putExtra("regionString", jSONObject.toString());
        Properties properties = new Properties();
        properties.put("position", i + "");
        properties.put("countryCode", regionInfo.domain + "");
        UserTrackAdapter.sendUT("List_Reg_selectCountry", properties);
        setResult(-1, intent);
        finish();
    }

    void startAnimation() {
        showProgress("");
    }

    void stopAnimation() {
        MainThreadExecutor.execute(new Runnable() { // from class: com.ali.user.mobile.register.ui.AliUserRegisterChoiceRegionActivity.4
            @Override // java.lang.Runnable
            public void run() {
                AliUserRegisterChoiceRegionActivity.this.dismissProgressDialog();
            }
        });
    }
}
