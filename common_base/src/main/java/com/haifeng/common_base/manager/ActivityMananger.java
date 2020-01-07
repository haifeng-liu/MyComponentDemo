package com.haifeng.common_base.manager;

import android.app.Activity;

import java.util.HashSet;
import java.util.Set;

/**
 * 创建人：Liuhaifeng
 * 时间：2020/1/6
 * 描述：
 */
public class ActivityMananger {

    private Set<Activity> activities=new HashSet<>();

    public void addActivity(Activity activity){

        if (activity!=null){
            activities.add(activity);
        }
    }


    public void removeActivity(Activity activity){
     if (activity!=null){
         activities.remove(activity);
     }
    }

    public void finishall(){
        for (Activity activity:activities){
            activity.finish();
        }
    }
}
