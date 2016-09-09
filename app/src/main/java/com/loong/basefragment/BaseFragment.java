package com.loong.basefragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Describe the function of the class
 *
 * @author zhujinlong@ichoice.com
 * @date 2016/9/9
 * @time 18:23
 * @description Describe the place where the class needs to pay attention.
 */
public abstract class BaseFragment extends Fragment {

    protected boolean isViewInitiated;
    protected boolean isVisibleToUser;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(getUserVisibleHint()){
            onFragmentResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(getUserVisibleHint()){
            onFragmentPause();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(!this.isVisibleToUser && isVisibleToUser && isViewInitiated){
            onFragmentResume();
        }else if (this.isVisibleToUser && !isVisibleToUser && isViewInitiated){
            onFragmentPause();
        }
        this.isVisibleToUser = isVisibleToUser;
    }

    public abstract void onFragmentResume();

    public abstract void onFragmentPause();
}