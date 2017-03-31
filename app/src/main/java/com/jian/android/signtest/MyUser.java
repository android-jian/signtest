package com.jian.android.signtest;

import java.util.List;

import cn.bmob.v3.BmobUser;

/**
 * Created by dell on 2017/3/22.
 */

public class MyUser extends BmobUser {

    private String icon;        //我的头像

    private List<TopInfo> keep;       //我的收藏

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<TopInfo> getKeep() {
        return keep;
    }

    public void setKeep(List<TopInfo> keep) {
        this.keep = keep;
    }

    public class TopInfo{

    }

}
