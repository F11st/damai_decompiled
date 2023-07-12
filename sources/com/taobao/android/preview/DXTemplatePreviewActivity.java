package com.taobao.android.preview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.R$array;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.android.dinamicx.C6387n;
import com.taobao.android.dinamicx.monitor.DXFontSize;
import com.taobao.android.dinamicx.notification.IDXNotificationListener;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import com.taobao.android.purchase.core.utils.PurchaseConstants;
import com.vivo.push.PushClientConstants;
import com.youku.arch.v3.data.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.e01;
import tb.rz;
import tb.s10;

/* compiled from: Taobao */
@Keep
/* loaded from: classes11.dex */
public class DXTemplatePreviewActivity extends AppCompatActivity implements IDXNotificationListener {
    public static final String FONTSIZE_FLAG = "fontSize";
    public static final String PREVIEW_DINAMIC_MODULE = "preview";
    public static final String PREVIEW_INFO = "previewInfo";
    public static final String PREVIEW_TAG = "DXTemplatePreviewActivity";
    private DXTemplatePreviewAdapter adapter;
    JSONArray array;
    private boolean canScrollVertical = true;
    private int currentLevel;
    C6387n engineRouter;
    LinearLayout linearLayout;
    private RecyclerView rvMainContainer;

    /* compiled from: Taobao */
    @Keep
    /* loaded from: classes12.dex */
    public interface DXPreviewInterface extends Serializable {
        void previewEngineDidInitialized(C6387n c6387n);
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.preview.DXTemplatePreviewActivity$a */
    /* loaded from: classes12.dex */
    class View$OnClickListenerC6555a implements View.OnClickListener {
        View$OnClickListenerC6555a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DXTemplatePreviewActivity.this.finish();
            DXTemplatePreviewActivity.this.overridePendingTransition(0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.preview.DXTemplatePreviewActivity$b */
    /* loaded from: classes11.dex */
    public class C6556b extends StaggeredGridLayoutManager {
        C6556b(int i, int i2) {
            super(i, i2);
        }

        @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return DXTemplatePreviewActivity.this.canScrollVertical;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.preview.DXTemplatePreviewActivity$c */
    /* loaded from: classes12.dex */
    public class DialogInterface$OnClickListenerC6557c implements DialogInterface.OnClickListener {
        DialogInterface$OnClickListenerC6557c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            DXTemplatePreviewActivity dXTemplatePreviewActivity = DXTemplatePreviewActivity.this;
            dXTemplatePreviewActivity.downLoadMockData(dXTemplatePreviewActivity.getIntent().getStringExtra(DXTemplatePreviewActivity.PREVIEW_INFO));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.preview.DXTemplatePreviewActivity$d */
    /* loaded from: classes12.dex */
    public class DialogInterface$OnClickListenerC6558d implements DialogInterface.OnClickListener {
        DialogInterface$OnClickListenerC6558d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            DXTemplatePreviewActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.preview.DXTemplatePreviewActivity$e */
    /* loaded from: classes12.dex */
    public class AsyncTaskC6559e extends AsyncTask<String, Void, JSONArray> {
        AsyncTaskC6559e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public JSONArray doInBackground(String... strArr) {
            try {
                byte[] download = new e01().download(strArr[0]);
                String str = download != null ? new String(download) : null;
                if (str != null) {
                    DXTemplatePreviewActivity dXTemplatePreviewActivity = DXTemplatePreviewActivity.this;
                    dXTemplatePreviewActivity.log("respnese.body =" + str);
                    return JSON.parseArray(str);
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onPostExecute(JSONArray jSONArray) {
            if (jSONArray == null || jSONArray.size() <= 0) {
                DXTemplatePreviewActivity.this.showErrorDialog();
                return;
            }
            DXTemplatePreviewActivity.this.log("获取mock数据成功");
            JSONObject jSONObject = jSONArray.getJSONObject(0);
            if (jSONObject.containsKey("dx_canScrollVertical")) {
                DXTemplatePreviewActivity.this.canScrollVertical = jSONObject.getBoolean("dx_canScrollVertical").booleanValue();
            }
            DXTemplatePreviewActivity.this.initEngineRouter(jSONArray);
            DXTemplatePreviewActivity.this.gotoImplPreviewInterface(jSONArray);
            DXTemplatePreviewActivity.this.refreshUI(jSONArray);
            DXTemplatePreviewActivity.this.downLoadTemplate(jSONArray);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.preview.DXTemplatePreviewActivity$f */
    /* loaded from: classes12.dex */
    public static class C6560f {
        public String a;
    }

    private void callMethod(C6560f c6560f) {
        if (c6560f != null && !TextUtils.isEmpty(c6560f.a)) {
            try {
                Class<?> cls = Class.forName(c6560f.a);
                cls.getMethod("previewEngineDidInitialized", C6387n.class).invoke(cls.newInstance(), this.engineRouter);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downLoadMockData(String str) {
        new AsyncTaskC6559e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downLoadTemplate(JSONArray jSONArray) {
        boolean z;
        ArrayList arrayList = new ArrayList(jSONArray.size());
        Iterator<Object> it = jSONArray.iterator();
        loop0: while (true) {
            z = false;
            while (it.hasNext()) {
                DXTemplateItem dinamicTemplate = getDinamicTemplate((JSONObject) it.next());
                if (dinamicTemplate != null) {
                    arrayList.add(dinamicTemplate);
                }
                if (!z) {
                    if (this.engineRouter.e(dinamicTemplate) != null) {
                        z = true;
                    }
                }
            }
        }
        log("开始下载模版");
        this.engineRouter.d(arrayList);
        if (z) {
            log("模版已经存在，直接刷新");
            this.adapter.notifyDataSetChanged();
        }
    }

    public static DXTemplateItem getDinamicTemplate(JSONObject jSONObject) {
        DXTemplateItem dXTemplateItem = new DXTemplateItem();
        JSONObject jSONObject2 = jSONObject.getJSONObject(Constants.TEMPLATE);
        if (jSONObject2 == null) {
            return null;
        }
        dXTemplateItem.name = jSONObject2.getString("name");
        dXTemplateItem.version = Long.parseLong(jSONObject2.getString("version"));
        dXTemplateItem.templateUrl = jSONObject2.getString("url");
        return dXTemplateItem;
    }

    private List<C6560f> getPreviewInfoList(JSONArray jSONArray) {
        JSONArray jSONArray2;
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.size(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i).getJSONObject("__preview__");
            if (jSONObject != null && (jSONArray2 = jSONObject.getJSONArray("android")) != null) {
                for (int i2 = 0; i2 < jSONArray2.size(); i2++) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    if (jSONObject2 != null) {
                        C6560f c6560f = new C6560f();
                        c6560f.a = jSONObject2.getString(PushClientConstants.TAG_CLASS_NAME);
                        jSONObject2.getString("bundlerPath");
                        arrayList.add(c6560f);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoImplPreviewInterface(JSONArray jSONArray) {
        log("开始进行组建注册");
        List<C6560f> previewInfoList = getPreviewInfoList(jSONArray);
        if (previewInfoList == null) {
            return;
        }
        for (int i = 0; i < previewInfoList.size(); i++) {
            callMethod(previewInfoList.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
        if (android.text.TextUtils.isEmpty(r2) == false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initEngineRouter(com.alibaba.fastjson.JSONArray r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1c
            r0 = 0
            com.alibaba.fastjson.JSONObject r2 = r2.getJSONObject(r0)
            java.lang.String r0 = "__preview__"
            com.alibaba.fastjson.JSONObject r2 = r2.getJSONObject(r0)
            if (r2 == 0) goto L1c
            java.lang.String r0 = "bizType"
            java.lang.String r2 = r2.getString(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L1c
            goto L1e
        L1c:
            java.lang.String r2 = "preview"
        L1e:
            com.taobao.android.dinamicx.DXEngineConfig$b r0 = new com.taobao.android.dinamicx.DXEngineConfig$b
            r0.<init>(r2)
            r2 = 1
            com.taobao.android.dinamicx.DXEngineConfig$b r2 = r0.v(r2)
            r0 = 2
            com.taobao.android.dinamicx.DXEngineConfig$b r2 = r2.w(r0)
            com.taobao.android.dinamicx.DXEngineConfig r2 = r2.t()
            com.taobao.android.dinamicx.n r0 = new com.taobao.android.dinamicx.n
            r0.<init>(r2)
            r1.engineRouter = r0
            r0.l(r1)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = "完成engine的初始化 "
            r2.append(r0)
            com.taobao.android.dinamicx.n r0 = r1.engineRouter
            java.lang.String r0 = r0.a()
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            r1.log(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.preview.DXTemplatePreviewActivity.initEngineRouter(com.alibaba.fastjson.JSONArray):void");
    }

    private void initRecyclerView() {
        this.rvMainContainer.setLayoutManager(new C6556b(2, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        Log.e(PREVIEW_TAG, str + " : " + System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUI(JSONArray jSONArray) {
        log("refreshUI");
        this.array = jSONArray;
        DXTemplatePreviewAdapter dXTemplatePreviewAdapter = this.adapter;
        if (dXTemplatePreviewAdapter == null) {
            DXTemplatePreviewAdapter dXTemplatePreviewAdapter2 = new DXTemplatePreviewAdapter(this, jSONArray, this.rvMainContainer, this.engineRouter);
            this.adapter = dXTemplatePreviewAdapter2;
            this.rvMainContainer.setAdapter(dXTemplatePreviewAdapter2);
            return;
        }
        dXTemplatePreviewAdapter.h(jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("获取mock数据失败，是否重试？").setTitle(PurchaseConstants.NORMAL_WARNING_TITLE);
        builder.setPositiveButton("重试", new DialogInterface$OnClickListenerC6557c());
        builder.setNegativeButton(PurchaseConstants.PART_SUCCESS_CANCEL, new DialogInterface$OnClickListenerC6558d());
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_template_preview);
        log("onCreate");
        overridePendingTransition(0, 0);
        this.currentLevel = DXFontSize.b().a();
        this.rvMainContainer = (RecyclerView) findViewById(R$id.rv_main_container);
        this.linearLayout = (LinearLayout) findViewById(R$id.ll);
        ((TextView) findViewById(R$id.dinamic_preview_back)).setOnClickListener(new View$OnClickListenerC6555a());
        Spinner spinner = (Spinner) findViewById(R$id.fontSize_select);
        initEngineRouter(null);
        initRecyclerView();
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(this, R$array.preview_array, R$layout.fontsize_spinner_item);
        createFromResource.setDropDownViewResource(17367049);
        spinner.setAdapter((SpinnerAdapter) createFromResource);
        spinner.setSelection(this.currentLevel, true);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.taobao.android.preview.DXTemplatePreviewActivity.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                TextView textView = (TextView) view;
                textView.setTextColor(-16777216);
                textView.setGravity(17);
                DXFontSize.b().i(i);
                DXTemplatePreviewActivity dXTemplatePreviewActivity = DXTemplatePreviewActivity.this;
                if (dXTemplatePreviewActivity.array != null) {
                    dXTemplatePreviewActivity.engineRouter.g().R();
                    DXTemplatePreviewActivity dXTemplatePreviewActivity2 = DXTemplatePreviewActivity.this;
                    dXTemplatePreviewActivity2.refreshUI(dXTemplatePreviewActivity2.array);
                    DXTemplatePreviewActivity.this.adapter.notifyDataSetChanged();
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        try {
            Intent intent = getIntent();
            String stringExtra = intent.getStringExtra(PREVIEW_INFO);
            String stringExtra2 = intent.getStringExtra("fontSize");
            if (!TextUtils.isEmpty(stringExtra2) ? Boolean.valueOf(stringExtra2).booleanValue() : false) {
                spinner.setVisibility(0);
            } else {
                spinner.setVisibility(8);
            }
            if (!TextUtils.isEmpty(stringExtra)) {
                log("onCreate info :" + stringExtra);
                downLoadMockData(stringExtra);
                return;
            }
            finish();
            log("onCreate info isEmpty");
        } catch (Throwable th) {
            finish();
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy");
        DXFontSize.b().i(this.currentLevel);
        this.engineRouter.g().A();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        log("onNewIntent");
        try {
            String stringExtra = intent.getStringExtra(PREVIEW_INFO);
            if (!TextUtils.isEmpty(stringExtra)) {
                log("onNewIntent" + stringExtra);
                downLoadMockData(stringExtra);
            } else {
                finish();
                log("onNewIntent info isEmpty");
            }
        } catch (Throwable th) {
            finish();
            th.printStackTrace();
        }
    }

    @Override // com.taobao.android.dinamicx.notification.IDXNotificationListener
    public void onNotificationListener(rz rzVar) {
        if (rzVar != null) {
            List<s10> list = rzVar.c;
            if (list != null && list.size() > 0) {
                if (rzVar.c.get(0).c == 1000) {
                    this.adapter.b();
                    log("收到降级刷新请求开始刷新: " + rzVar.c.get(0).c);
                } else {
                    log(" 收到 templateUpdateRequestList: " + rzVar.c.get(0).c);
                }
            } else {
                List<DXTemplateItem> list2 = rzVar.a;
                if (list2 != null && list2.size() > 0) {
                    log("收到下载新请求开始刷新" + rzVar.a.get(0).toString());
                }
            }
            refreshUI(this.array);
            this.adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        log("onResume");
    }
}
