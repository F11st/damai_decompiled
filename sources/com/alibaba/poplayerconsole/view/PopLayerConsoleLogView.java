package com.alibaba.poplayerconsole.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.poplayerconsole.LogCache;
import com.alibaba.poplayerconsole.R$id;
import com.alibaba.poplayerconsole.R$layout;
import com.alibaba.poplayerconsole.lib.Window;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class PopLayerConsoleLogView extends FrameLayout implements ILogView {
    private boolean mAutoScrollButtom;
    private String mCurrentTag;
    private LogViewAdapter mLogViewAdapter;
    private RecyclerView mLogs;
    private Spinner mTagSpinner;
    final String[] mTags;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class LogViewAdapter extends RecyclerView.Adapter<LogVH> {
        private List<LogCache.LogDO> a;

        /* compiled from: Taobao */
        /* loaded from: classes8.dex */
        public static class LogVH extends RecyclerView.ViewHolder {
            TextView a;

            public LogVH(View view) {
                super(view);
                this.a = (TextView) view.findViewById(R$id.log);
            }
        }

        public LogViewAdapter(List<LogCache.LogDO> list, Context context) {
            this.a = list;
        }

        public void a(LogCache.LogDO logDO) {
            this.a.add(logDO);
            if (this.a.size() > LogCache.a) {
                this.a.subList(0, 1).clear();
            }
            notifyDataSetChanged();
        }

        public void b(List<LogCache.LogDO> list) {
            this.a.addAll(list);
            if (this.a.size() > LogCache.a) {
                this.a.subList(0, list.size()).clear();
            }
            notifyDataSetChanged();
        }

        public void c() {
            this.a.clear();
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(LogVH logVH, int i) {
            logVH.a.setText(this.a.get(i).toSpannableString());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: e */
        public LogVH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new LogVH(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.console_log, (ViewGroup) null));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }
    }

    public PopLayerConsoleLogView(Context context) {
        super(context);
        this.mTags = new String[]{LogCache.LOG_TAG_ALL, "Console", "PopLayer", "WindVane"};
        this.mCurrentTag = LogCache.LOG_TAG_ALL;
        this.mAutoScrollButtom = true;
        initViews(context);
    }

    private ArrayList<LogCache.LogDO> getInitData() {
        return new ArrayList<>(LogCache.e(this.mCurrentTag));
    }

    private void initViews(Context context) {
        this.mLogs = new RecyclerView(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.mLogs.setLayoutManager(linearLayoutManager);
        LogViewAdapter logViewAdapter = new LogViewAdapter(getInitData(), getContext());
        this.mLogViewAdapter = logViewAdapter;
        this.mLogs.setAdapter(logViewAdapter);
        addView(this.mLogs, new FrameLayout.LayoutParams(-1, -1));
        Spinner spinner = new Spinner(context);
        this.mTagSpinner = spinner;
        spinner.setGravity(5);
        this.mTagSpinner.setAdapter((SpinnerAdapter) new ArrayAdapter(context, R$layout.console_spinner_text, this.mTags));
        this.mTagSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.alibaba.poplayerconsole.view.PopLayerConsoleLogView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                String str = PopLayerConsoleLogView.this.mCurrentTag;
                PopLayerConsoleLogView popLayerConsoleLogView = PopLayerConsoleLogView.this;
                String[] strArr = popLayerConsoleLogView.mTags;
                if (str != strArr[i]) {
                    popLayerConsoleLogView.mCurrentTag = strArr[i];
                    PopLayerConsoleLogView.this.resetData();
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 53;
        addView(this.mTagSpinner, layoutParams);
    }

    public void addLog(LogCache.LogDO logDO) {
        if (logDO == null) {
            return;
        }
        if (LogCache.LOG_TAG_ALL.equals(this.mCurrentTag) || this.mCurrentTag.equals(logDO.tag)) {
            this.mLogViewAdapter.a(logDO);
        }
        if (this.mAutoScrollButtom) {
            this.mLogs.scrollToPosition(this.mLogViewAdapter.getItemCount() - 1);
        }
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void destoryView() {
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public String getTitle() {
        return "Logcat";
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public View getView() {
        return this;
    }

    public void resetData() {
        this.mLogViewAdapter.c();
        this.mLogViewAdapter.b(getInitData());
        this.mLogs.scrollToPosition(this.mLogViewAdapter.getItemCount() - 1);
    }

    @Override // com.alibaba.poplayerconsole.view.ILogView
    public void update(Window window) throws Throwable {
    }

    public void updateConsoleTag(String str) {
        if (this.mCurrentTag != str) {
            this.mCurrentTag = str;
            resetData();
        }
        int i = 0;
        while (true) {
            String[] strArr = this.mTags;
            if (i >= strArr.length) {
                return;
            }
            if (this.mCurrentTag == strArr[i]) {
                this.mTagSpinner.setSelection(i);
            }
            i++;
        }
    }
}
