package com.alibaba.poplayerconsole.view;

import android.app.AlertDialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.alibaba.poplayer.Domain;
import com.alibaba.poplayer.factory.view.base.PopLayerBaseView;
import com.alibaba.poplayer.layermanager.e;
import com.alibaba.poplayer.layermanager.view.PopLayerViewContainer;
import com.alibaba.poplayer.trigger.BaseConfigItem;
import com.alibaba.poplayer.utils.Monitor;
import com.alibaba.poplayerconsole.R$id;
import com.alibaba.poplayerconsole.R$layout;
import com.alibaba.poplayerconsole.lib.Window;
import com.taobao.android.dinamic.property.DAttrConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import tb.ip1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PopLayerInfoLogView extends LinearLayout implements ILogView {
    private int[] mConfigDomains;
    private Spinner mConfigSpinner;
    private int mCurrentConfigDomain;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a extends ClickableSpan {
        final /* synthetic */ Map a;
        final /* synthetic */ String b;

        a(Map map, String str) {
            this.a = map;
            this.b = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str;
            Map map = this.a;
            List<BaseConfigItem> list = (List) ((Monitor.a) map.get(this.b + ip1.MONITOR_CONFIG_ITEMS)).b;
            AlertDialog create = new AlertDialog.Builder(PopLayerInfoLogView.this.getContext().getApplicationContext(), 3).setTitle("Current Configuration Items").create();
            ScrollView scrollView = new ScrollView(create.getContext());
            LinearLayout linearLayout = new LinearLayout(create.getContext());
            linearLayout.setPadding(20, 20, 20, 20);
            TextView textView = new TextView(create.getContext());
            textView.setTextSize(14.0f);
            if (list == null || list.size() <= 0) {
                str = "Configuration item list is null";
            } else {
                StringBuilder sb = new StringBuilder();
                for (BaseConfigItem baseConfigItem : list) {
                    sb.append(baseConfigItem.uuid);
                    sb.append(":\r\n");
                    sb.append(baseConfigItem.toString());
                    sb.append("\n\r\n");
                }
                str = sb.toString();
            }
            textView.setText(str);
            linearLayout.addView(textView);
            scrollView.addView(linearLayout);
            create.setView(scrollView);
            create.getWindow().setType(2003);
            create.show();
        }
    }

    public PopLayerInfoLogView(Context context) {
        super(context);
        this.mCurrentConfigDomain = 2;
        this.mConfigDomains = new int[]{2, 3, 1};
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.console_poplayer_info, (ViewGroup) this, true);
        this.mConfigSpinner = (Spinner) findViewById(R$id.configset_switch);
        String[] strArr = new String[this.mConfigDomains.length];
        for (int i = 0; i < this.mConfigDomains.length; i++) {
            strArr[i] = Domain.toString(this.mConfigDomains[i]) + "ConfigSet";
        }
        this.mConfigSpinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, R$layout.console_spinner_text, strArr));
        this.mConfigSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.alibaba.poplayerconsole.view.PopLayerInfoLogView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                if (PopLayerInfoLogView.this.mCurrentConfigDomain != PopLayerInfoLogView.this.mConfigDomains[i2]) {
                    PopLayerInfoLogView popLayerInfoLogView = PopLayerInfoLogView.this;
                    popLayerInfoLogView.mCurrentConfigDomain = popLayerInfoLogView.mConfigDomains[i2];
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void addStatus(SpannableStringBuilder spannableStringBuilder, String str, String str2, Object obj, Object obj2) {
        int length = spannableStringBuilder.length();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str).append(jn1.CONDITION_IF_MIDDLE);
        }
        if (obj == null) {
            obj = new ForegroundColorSpan(-3355444);
        }
        spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        int length2 = spannableStringBuilder.length();
        if (str2 == null) {
            str2 = "Null";
        }
        spannableStringBuilder.append((CharSequence) str2).append('\n');
        int i = str2 == null ? SupportMenu.CATEGORY_MASK : -7829368;
        if (obj2 == null) {
            obj2 = new ForegroundColorSpan(i);
        }
        spannableStringBuilder.setSpan(obj2, length2, spannableStringBuilder.length(), 33);
    }

    private void updateConfigSet(Map<String, Monitor.a> map) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String domain = Domain.toString(this.mCurrentConfigDomain);
        Monitor.a aVar = map.get(domain + ip1.MONITOR_CONFIG_SET);
        if (aVar != null) {
            Object obj = aVar.b;
            addStatus(spannableStringBuilder, "", obj == null ? null : obj.toString(), null, new a(map, domain));
        }
        if (this.mCurrentConfigDomain == 1) {
            List list = (List) map.get(domain + ip1.MONITOR_WHITELIST).b;
            addStatus(spannableStringBuilder, "WhiteList", list == null ? null : Arrays.toString(list.toArray()), null, null);
        }
        List list2 = (List) map.get(domain + ip1.MONITOR_BLACKLIST).b;
        addStatus(spannableStringBuilder, "BlackList", list2 == null ? null : Arrays.toString(list2.toArray()), null, null);
        TextView textView = (TextView) findViewById(R$id.configset);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
    }

    private void updateCurrentPopLayer(Map<String, Monitor.a> map) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.mCurrentConfigDomain == 2) {
            PopLayerViewContainer d = e.f().d();
            if (d == null) {
                addStatus(spannableStringBuilder, "Popped List", null, null, null);
            } else {
                ArrayList<View> all = d.getCanvas().all();
                if (!all.isEmpty()) {
                    int size = all.size();
                    addStatus(spannableStringBuilder, "Popped List", "" + size, null, null);
                    for (int i = 0; i < size; i++) {
                        View view = all.get(i);
                        if (view instanceof PopLayerBaseView) {
                            String str = jn1.ARRAY_START_STR + i + jn1.ARRAY_END_STR;
                            StringBuilder sb = new StringBuilder();
                            sb.append(view.getClass().getSimpleName());
                            sb.append("-");
                            sb.append(view.getVisibility() == 0 ? "visible" : 8 == view.getVisibility() ? "gone" : DAttrConstant.VISIBILITY_INVISIBLE);
                            addStatus(spannableStringBuilder, str, sb.toString(), null, null);
                            spannableStringBuilder.append((CharSequence) ((PopLayerBaseView) view).getInfo()).append('\n');
                        } else {
                            addStatus(spannableStringBuilder, "【" + i + "】", "unknow type layer.", null, null);
                        }
                    }
                }
            }
        } else {
            addStatus(spannableStringBuilder, "Popped List", "Unsupport Domain.", null, null);
        }
        TextView textView = (TextView) findViewById(R$id.current_poplayer);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
    }

    private void updatePopLayerInfo(Map<String, Monitor.a> map) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Object obj = map.get("version").b;
        addStatus(spannableStringBuilder, "Version", obj == null ? null : obj.toString(), null, null);
        Object obj2 = map.get(ip1.MONITOR_ADAPTER_VERSION).b;
        addStatus(spannableStringBuilder, "AdapterVersion", obj2 == null ? null : obj2.toString(), null, null);
        WeakReference weakReference = (WeakReference) map.get("page").b;
        addStatus(spannableStringBuilder, "NativePage", weakReference.get() == null ? null : weakReference.get().getClass().getName(), null, null);
        Object obj3 = map.get(ip1.MONITOR_NATIVE_URL).b;
        addStatus(spannableStringBuilder, "NativeUrl", obj3 == null ? null : obj3.toString(), null, null);
        spannableStringBuilder.subSequence(spannableStringBuilder.length() - 2, spannableStringBuilder.length() - 1);
        ((TextView) findViewById(R$id.status)).setText(spannableStringBuilder);
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void destoryView() {
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public String getTitle() {
        return "PopLayer Info";
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public View getView() {
        return this;
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void update(Window window) throws Throwable {
        Map<String, Monitor.a> d = com.alibaba.poplayerconsole.a.d();
        updatePopLayerInfo(d);
        updateConfigSet(d);
        updateCurrentPopLayer(d);
    }

    public void updateDomain(int i) {
        this.mCurrentConfigDomain = i;
        int i2 = 0;
        while (true) {
            int[] iArr = this.mConfigDomains;
            if (i2 >= iArr.length) {
                return;
            }
            if (i == iArr[i2]) {
                this.mConfigSpinner.setSelection(i2);
            }
            i2++;
        }
    }
}
