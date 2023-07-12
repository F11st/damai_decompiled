package android.taobao.windvane.extra.performance2;

import android.taobao.windvane.WVPerformanceManager;
import android.taobao.windvane.monitor.WVMonitorService;
import android.taobao.windvane.util.TaoLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class WVFSPManager implements Serializable {
    private static final String TAG = "FSP";
    public static final int WV_FSP_STATE_Initialize = 0;
    public static final int WV_FSP_STATE_NavigationDidEnd = 2;
    public static final int WV_FSP_STATE_NavigationDidStart = 1;
    public static final int WV_FSP_STATE_UnitFinished = 3;
    private List<FSPCallback> fspCallbacks;
    private long startTime;
    private int state;
    private long time;
    public long time_H5Pages;
    private String url;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface CompletionHandler {
        void stopObserving();

        void uploadFSPInfo(String str, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface FSPCallback {
        void onFSPBack(long j);
    }

    private void commitStat() {
        if (WVPerformanceManager.getInstance().getConfig().isOpenFSP()) {
            if (WVMonitorService.getPerformanceMonitor() != null) {
                WVMonitorService.getPerformanceMonitor().didPageStartInFSP(this.url, this.time - this.startTime);
            }
            TaoLog.i("FSP", "FSP_URL: " + this.url + "\nFSP_Time: " + (this.time - this.startTime));
        }
    }

    public String eventForFSPStop() {
        return "Event_FSP_Stop";
    }

    public String jsCodeForFSP() {
        if (WVPerformanceManager.getInstance().getConfig().isOpenFSP()) {
            String str = WVPerformanceManager.getInstance().getConfig().getfSPFilterAnimation();
            return "javascript:(function(){var badCaseMetaName=undefined;var classNames={};var ids={};var plainTextLabels={'SPAN':1,'I':1};var badCaseDOMName=\"data-observe-windvane-FSP-badcase-domname\";var previousTime=0;var callback=function(records){if(badCaseMetaName==undefined){if(document.querySelector('meta[name=\"windvane-AIT-badcase-metaname\"]')){badCaseMetaName=document.querySelector('meta[name=\"windvane-AIT-badcase-metaname\"]').getAttribute('content');if(badCaseMetaName){var metaNames=[];metaNames=badCaseMetaName.split('|');for(var i=0;i<metaNames.length;i++){var metaName=metaNames[i].substring(1,metaNames[i].length);if(metaNames[i].substring(0,1)=='.'){classNames[metaName]=true}else if(metaNames[i].substring(0,1)=='#'){ids[metaName]=true}}}}}var visibleTop=0;var visibleBottom=document.documentElement.clientHeight;var visibleLeft=0;var visibleRight=document.documentElement.clientWidth;var isAlreadySendMessage=false;var show=undefined;var hasBadCase=undefined;for(var record of records){var domNode=record.target;if(domNode==undefined){continue}if(record.addedNodes.length==0){continue}if(domNode.nodeType==1){}else if(domNode.nodeType==3){var parentNode=domNode.parentElement;if(parentNode.nodeType==1){domNode=parentNode}else{continue}}else{continue}var isPlainText=true;for(var i=0;i<record.addedNodes.length;i++){var addedDom=record.addedNodes[i];if(addedDom.nodeType==1&&plainTextLabels[addedDom.tagName]!=1){isPlainText=false;break}}if(isPlainText){continue}if(show==undefined){var domNodeTop=domNode.getBoundingClientRect().top;var domNodeBottom=domNode.getBoundingClientRect().bottom;var domNodeLeft=domNode.getBoundingClientRect().left;var domNodeRight=domNode.getBoundingClientRect().right;show=domNodeTop<visibleBottom&&domNodeBottom>visibleTop&&domNodeLeft<visibleRight&&domNodeRight>visibleLeft;if(record.addedNodes.length>0){var firstAddedDom=record.addedNodes[0];if(firstAddedDom.nodeType==1){var addedDomNodeTop=firstAddedDom.getBoundingClientRect().top;var addedDomNodeBottom=firstAddedDom.getBoundingClientRect().bottom;var addedDomNodeLeft=firstAddedDom.getBoundingClientRect().left;var addedDomNodeRight=firstAddedDom.getBoundingClientRect().right;show=addedDomNodeTop<visibleBottom&&addedDomNodeBottom>visibleTop&&addedDomNodeLeft<visibleRight&&addedDomNodeRight>visibleLeft}}}var filter=domNode.tagName!='HTML'&&domNode.tagName!='BODY'&&domNode.tagName!='HEAD'&&domNode.tagName!='SCRIPT'&&domNode.tagName!='STYLE';if(!show&&filter){break}if(show&&filter){if(window.getComputedStyle&&" + str + "){var domNodeCssStyle=window.getComputedStyle(domNode,null);if((domNodeCssStyle.getPropertyValue(\"transform\")!=\"\"&&domNodeCssStyle.getPropertyValue(\"transform\")!=\"none\")||(domNodeCssStyle.getPropertyValue(\"animation-name\")!=\"\"&&domNodeCssStyle.getPropertyValue(\"animation-name\")!=\"none\")){continue}var allHasAnimation=true;for(var i=0;i<record.addedNodes.length;i++){var addedDom=record.addedNodes[i];var addedDomCssStyle=window.getComputedStyle(addedDom,null);if(addedDom.nodeType==1){if((addedDomCssStyle.getPropertyValue(\"transform\")!=\"\"&&addedDomCssStyle.getPropertyValue(\"transform\")!=\"none\")||(addedDomCssStyle.getPropertyValue(\"animation-name\")!=\"\"&&addedDomCssStyle.getPropertyValue(\"animation-name\")!=\"none\")){}else{allHasAnimation=false;break}}}if(allHasAnimation==true){continue}}if(badCaseMetaName==undefined){var currentTime=(new Date()).getTime();if(currentTime-previousTime>10){console.log('hybrid://WVPerformance:FSP/receiveFSPTime?{\"time\":'+currentTime+'}');previousTime=currentTime}break}var isInIds=ids[domNode.id]==true;var isInClassNames=false;for(var i=0;i<domNode.classList.length;i++){if(classNames[domNode.classList[i]]==true){isInClassNames=true;break}}if(isInClassNames||isInIds){domNode.setAttribute(badCaseDOMName,'true');hasBadCase=true;continue}if(domNode.parentNode!=document){if(domNode.parentNode.getAttribute(badCaseDOMName)=='true'){domNode.setAttribute(badCaseDOMName,'true');hasBadCase=true;continue}}if(hasBadCase==undefined&&isAlreadySendMessage==false){var currentTime=(new Date()).getTime();if(currentTime-previousTime>10){console.log('hybrid://WVPerformance:FSP/receiveFSPTime?{\"time\":'+currentTime+'}');previousTime=currentTime;isAlreadySendMessage=true}}}}};var mo=new MutationObserver(callback);var options={'childList':true,'subtree':true};mo.observe(document.body,options);document.addEventListener('" + eventForFSPStop() + "',function(){mo.disconnect();mo.takeRecords()})})()";
        }
        return "";
    }

    public void navigationDidFinishWithURL(String str) {
        if (WVPerformanceManager.getInstance().getConfig().isOpenFSP() && this.state == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            this.time = currentTimeMillis;
            this.time_H5Pages = currentTimeMillis;
            this.url = str;
            this.state = 2;
            TaoLog.i("FSP", "navigationDidFinishWithURL: " + str);
        }
    }

    public void navigationDidStart() {
        if (WVPerformanceManager.getInstance().getConfig().isOpenFSP()) {
            int i = this.state;
            if (i == 0 || i == 2 || i == 3) {
                this.state = 1;
                this.startTime = System.currentTimeMillis();
                TaoLog.i("FSP", "navigationDidStart");
            }
        }
    }

    public void receiveJSMessage(long j) {
        if (WVPerformanceManager.getInstance().getConfig().isOpenFSP()) {
            this.time = j;
            List<FSPCallback> list = this.fspCallbacks;
            if (list != null) {
                for (FSPCallback fSPCallback : list) {
                    fSPCallback.onFSPBack(j);
                }
            }
            TaoLog.i("FSP", "sendTime: " + j);
        }
    }

    public void setFspCallback(FSPCallback fSPCallback) {
        if (this.fspCallbacks == null) {
            this.fspCallbacks = new ArrayList();
        }
        if (this.fspCallbacks.contains(fSPCallback)) {
            return;
        }
        this.fspCallbacks.add(fSPCallback);
    }

    public void unitDidFinish(CompletionHandler completionHandler) {
        if (WVPerformanceManager.getInstance().getConfig().isOpenFSP() && completionHandler != null && this.state == 2) {
            this.state = 3;
            commitStat();
            TaoLog.i("FSP", "unitDidFinish");
            completionHandler.stopObserving();
            completionHandler.uploadFSPInfo(this.url, this.time);
            this.time_H5Pages = this.time;
        }
    }
}
