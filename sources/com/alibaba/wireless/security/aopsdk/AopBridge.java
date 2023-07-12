package com.alibaba.wireless.security.aopsdk;

import android.util.Log;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.alibaba.wireless.security.aopsdk.e.d;
import com.alibaba.wireless.security.aopsdk.e.f.e;
import com.alibaba.wireless.security.aopsdk.e.f.g;
import com.alibaba.wireless.security.aopsdk.report.ReportManager;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public class AopBridge {
    public static final String TAG = "AopBase";
    public static final boolean TIME_PROFILE = true;
    private final com.alibaba.wireless.security.aopsdk.e.d ruleManager = com.alibaba.wireless.security.aopsdk.e.d.a();

    private void applyDefaultSamplingRule(Invocation invocation) {
        if (shouldSampleDefault(invocation)) {
            invocation.shouldReport = true;
        }
    }

    public void afterMethod(Invocation invocation) {
    }

    public void applyRulesToInvocation(Invocation invocation) {
        List<d.b> a = this.ruleManager.a(invocation.getProxyName());
        com.alibaba.wireless.security.aopsdk.i.a.b(TAG, "Strategy get for " + invocation.getProxyName() + " with " + (a != null ? a.size() : 0) + " strategies");
        invocation.basicIncTimeCost = (System.nanoTime() - invocation.aopStartTime) / 1000;
        d.a();
        if (a == null) {
            applyDefaultSamplingRule(invocation);
            return;
        }
        for (d.b bVar : a) {
            for (d.a aVar : bVar.b) {
                com.alibaba.wireless.security.aopsdk.i.a.b(TAG, "Start to process rule " + aVar.a);
                if (aVar.b.c()) {
                    com.alibaba.wireless.security.aopsdk.i.a.b(TAG, "Sampling check passed");
                    if (aVar.b.g(invocation)) {
                        if (invocation.invocationConfig == null) {
                            invocation.invocationConfig = new InvocationConfig();
                        }
                        InvocationConfig invocationConfig = invocation.invocationConfig;
                        invocationConfig.matchedStrategyId = bVar.a;
                        e eVar = aVar.b;
                        invocationConfig.matchedRule = eVar;
                        int i = invocationConfig.matchedAction;
                        int i2 = eVar.p;
                        invocationConfig.matchedAction = i | i2;
                        if (i2 != 1) {
                            if (i2 == 2) {
                                invocationConfig.shouldBlock = true;
                            } else if (i2 == 4) {
                                invocationConfig.shouldChangeReturnValue = true;
                                invocationConfig.newReturnValue = eVar.t;
                            } else if (i2 == 8) {
                                Map<Integer, Object> d = eVar.d();
                                for (Integer num : d.keySet()) {
                                    int intValue = num.intValue();
                                    Object[] objArr = invocation.args;
                                    if (intValue < objArr.length) {
                                        objArr[intValue] = d.get(Integer.valueOf(intValue));
                                    }
                                }
                            } else if (i2 == 32) {
                                invocationConfig.setCacheRule(eVar);
                                aVar.b.i(invocation);
                                if (aVar.b.a(invocation)) {
                                    if (aVar.b.r != 0) {
                                        invocationConfig.shouldCacheResult = true;
                                    }
                                } else if (invocationConfig.getCacheRule().f(invocation)) {
                                    invocationConfig.shouldBlock = true;
                                    e eVar2 = aVar.b;
                                    int i3 = eVar2.r;
                                    if (i3 == 0) {
                                        invocation.setResult(eVar2.d(invocation));
                                        invocation.setThrowable(aVar.b.e(invocation));
                                    } else if (i3 != 2) {
                                        invocation.setResult(eVar2.b(invocation));
                                        invocation.setThrowable(aVar.b.e(invocation));
                                    }
                                }
                            }
                        } else if (eVar.b()) {
                            invocation.shouldReport = true;
                        }
                    }
                }
                if (aVar.b.o == 1) {
                    break;
                }
            }
        }
    }

    public void beforeMethod(Invocation invocation) {
    }

    public void callAfterBridge(Invocation invocation) {
        if (ConfigManager.getInstance().isEnabled()) {
            InvocationConfig invocationConfig = invocation.invocationConfig;
            if (invocationConfig != null) {
                if (invocationConfig.shouldCacheResult) {
                    invocationConfig.getCacheRule().h(invocation);
                    invocationConfig.getCacheRule().a(invocation.getThrowable());
                }
                if (invocation.getThrowable() != null && invocationConfig.shouldCatch) {
                    if (ConfigManager.DEBUG) {
                        Log.d(TAG, "Method exception catched");
                    }
                    invocation.setThrowable(null);
                }
                if (invocationConfig.shouldCallback) {
                    if (ConfigManager.DEBUG) {
                        Log.v(TAG, "Method callback triggered");
                    }
                    invokeCallback(invocation);
                }
                Throwable th = invocationConfig.newThrowable;
                if (th != null) {
                    if (ConfigManager.DEBUG) {
                        Log.d(TAG, "Method throw throwable");
                    }
                    invocation.setThrowable(th);
                }
                if (invocationConfig.shouldChangeReturnValue) {
                    if (ConfigManager.DEBUG) {
                        Log.d(TAG, "Method call return value changed");
                    }
                    invocation.setResult(invocationConfig.newReturnValue);
                }
            }
            afterMethod(invocation);
        }
    }

    public boolean callBeforeBridge(Invocation invocation) {
        if (ConfigManager.getInstance().isEnabled()) {
            applyRulesToInvocation(invocation);
            InvocationConfig invocationConfig = invocation.invocationConfig;
            beforeMethod(invocation);
            if (invocationConfig != null) {
                if (invocationConfig.shouldBlock) {
                    invocation.setShouldBlock(true);
                    com.alibaba.wireless.security.aopsdk.i.a.b(TAG, "block call for " + invocation.getProxyName());
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void callOnConstructor(Invocation invocation) {
        if (ConfigManager.getInstance().isEnabled()) {
            applyRulesToInvocation(invocation);
            beforeMethod(invocation);
            if (invocation.invocationConfig != null && shouldModifyThisObject(invocation)) {
                if (ConfigManager.DEBUG) {
                    Log.v(TAG, "Method call args changed");
                }
                modifyThiz(invocation);
            }
            afterMethod(invocation);
        }
    }

    public Object[] getNewArgs(Invocation invocation) {
        return null;
    }

    public Objects getNewReturnValue(Invocation invocation) {
        return null;
    }

    public Throwable getNewThrowable(Invocation invocation) {
        return null;
    }

    public boolean getTp() {
        return true;
    }

    public void invokeCallback(Invocation invocation) {
    }

    public boolean isWatchMode(Invocation invocation) {
        return true;
    }

    public void modifyThiz(Invocation invocation) {
    }

    public void report(Invocation invocation) {
        if (invocation.shouldReport) {
            InvocationConfig invocationConfig = invocation.invocationConfig;
            long nanoTime = (System.nanoTime() - invocation.aopStartTime) / 1000;
            if (ConfigManager.DEBUG) {
                Log.d(TAG, "ProxyName=" + invocation.getProxyName() + ", StackTimeCost=" + invocation.stackTimeCost + ", invokeTimeCost=" + invocation.invokeTimeCost + ", basicIncTimeCost=" + invocation.basicIncTimeCost + ", fullProxyTimeCost=" + nanoTime);
            }
            ReportManager.a(invocation, invocationConfig != null ? invocationConfig.matchedStrategyId : 0, invocationConfig != null ? invocationConfig.getRuleId() : 0, invocation.invokeTimeCost, invocation.basicIncTimeCost, nanoTime);
        }
    }

    public void reportTimeCost(Invocation invocation) {
        report(invocation);
    }

    public Object resultBridge(Invocation invocation) throws Throwable {
        if (!invocation.hasThrowable()) {
            return invocation.getResult();
        }
        throw invocation.getThrowable();
    }

    public void resultBridgeV(Invocation invocation) throws Throwable {
        if (invocation.hasThrowable()) {
            throw invocation.getThrowable();
        }
    }

    public boolean shouldBlock(Invocation invocation) {
        InvocationConfig invocationConfig = invocation.invocationConfig;
        return invocationConfig != null && invocationConfig.shouldBlock;
    }

    public boolean shouldCallback(Invocation invocation) {
        return false;
    }

    public boolean shouldCatch(Invocation invocation) {
        return false;
    }

    public boolean shouldChangeArgs(Invocation invocation) {
        return false;
    }

    public boolean shouldChangeReturnValue(Invocation invocation) {
        return false;
    }

    public boolean shouldModifyThisObject(Invocation invocation) {
        return false;
    }

    public boolean shouldSampleDefault(Invocation invocation) {
        com.alibaba.wireless.security.aopsdk.e.f.c cVar;
        g c = this.ruleManager.c();
        return (c == null || (cVar = c.f) == null || !cVar.c()) ? false : true;
    }
}
