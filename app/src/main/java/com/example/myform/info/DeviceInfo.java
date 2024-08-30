package com.example.myform.info;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;

import java.util.List;

public class DeviceInfo {
    public void MemoryInfoGet(Context context){
        try{
            ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
            ActivityManager activityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.getMemoryInfo(mi);
            long totalRAM=mi.totalMem / 1048576;//mb
            long availableRAM = mi.availMem / 1048576;//mb

            long perAvailableRAM=(availableRAM*100)/totalRAM;//%
            String x="";
        }catch (Exception ex){}
    }
    public void StorageInfoGet(Context context){
        try{
            StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long totalStorage=stat.getTotalBytes()/1048576;//mb
            long availableStorage=stat.getAvailableBytes()/1048576;//mb

            long perAvailableStorage=(availableStorage*100)/totalStorage;//%
            String x="";
        }catch (Exception ex){}
    }

    public void AppListGet(Context context){
        List<PackageInfo> packList = context.getPackageManager().getInstalledPackages(0);
        for (int i=0; i < packList.size(); i++)
        {
            PackageInfo packInfo = packList.get(i);
            if (  (packInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0)
            {
                String appName = packInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
                Log.e("App № " + Integer.toString(i), appName);
            }
        }
        String x="";
    }
}
