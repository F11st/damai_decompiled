package com.alibaba.android.umbrella.performance;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class ProcessEntity implements Serializable {
    public List<String> abTest;
    public Map<String, String> args;
    public Map<String, Long> bindData;
    public String bizName;
    public String childBizName;
    public Map<String, Long> createView;
    public Map<String, Long> dataParse;
    public Map<String, Long> init;
    public Map<String, Long> lifeCycle;
    public Map<String, Long> netWork;
    public long pageLoad;
    public Map<String, Long> process;
    private long registerTime;

    public ProcessEntity(String str) {
        this(str, System.currentTimeMillis());
    }

    public void addAbTest(String str, String str2) {
        if (this.abTest == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        List<String> list = this.abTest;
        list.add(str + ":" + str2);
    }

    public void addArgs(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.args.put(str, str2);
    }

    public void addBindView(String str, long j) {
        if (this.bindData == null || TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        if (this.bindData.containsKey(str)) {
            this.bindData.put(str, Long.valueOf((j + this.bindData.get(str).longValue()) / 2));
            return;
        }
        this.bindData.put(str, Long.valueOf(j));
    }

    public void addCreateView(String str, long j) {
        if (this.createView == null || TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        if (this.createView.containsKey(str)) {
            this.createView.put(str, Long.valueOf((j + this.createView.get(str).longValue()) / 2));
            return;
        }
        this.createView.put(str, Long.valueOf(j));
    }

    public void addDataParse(String str, long j) {
        Map<String, Long> map = this.dataParse;
        if (map == null || map.containsKey(str) || TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        this.dataParse.put(str, Long.valueOf(j));
    }

    public void addInit(String str, long j) {
        Map<String, Long> map = this.init;
        if (map == null || map.containsKey(str) || TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        this.init.put(str, Long.valueOf(j));
    }

    public void addLifeCycle(String str, long j) {
        Map<String, Long> map = this.lifeCycle;
        if (map == null || map.containsKey(str) || TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        this.lifeCycle.put(str, Long.valueOf(j));
    }

    public void addNetwork(String str, long j) {
        Map<String, Long> map = this.netWork;
        if (map == null || map.containsKey(str) || TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        this.netWork.put(str, Long.valueOf(j));
    }

    public void addPageLoad(long j) {
        this.pageLoad = j;
    }

    public void addProcess(String str, long j) {
        Map<String, Long> map = this.process;
        if (map == null || map.containsKey(str) || TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        this.process.put(str, Long.valueOf(j));
    }

    long getRegisterTime() {
        return this.registerTime;
    }

    public void setChildBizName(String str) {
        this.childBizName = str;
    }

    public String toJsonString() {
        return JSON.toJSONString(this);
    }

    public ProcessEntity(String str, long j) {
        this.bizName = str;
        this.registerTime = j;
        this.process = new HashMap();
        this.init = new HashMap();
        this.lifeCycle = new HashMap();
        this.netWork = new HashMap();
        this.dataParse = new HashMap();
        this.createView = new HashMap();
        this.bindData = new HashMap();
        this.abTest = new ArrayList();
        this.args = new HashMap();
    }

    public void addArgs(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.args.putAll(map);
    }
}
