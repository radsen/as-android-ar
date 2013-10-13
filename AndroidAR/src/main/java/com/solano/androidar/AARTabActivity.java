package com.solano.androidar;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TabHost;

/**
 * Created by pfhats0 on 10/8/13.
 */
public class AARTabActivity extends FragmentActivity {

    private TabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab_host_activity);

        tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
    }

    protected TabHost.TabSpec createTabSpec(String tag, int tabContentId){
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tag);
        tabSpec.setIndicator(tag);
        tabSpec.setContent(tabContentId);
        return tabSpec;
    }

    public void addTab(TabHost.TabSpec tabSpec){
        tabHost.addTab(tabSpec);
    }

    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangedListener){
        tabHost.setOnTabChangedListener(onTabChangedListener);
    }

    protected TabHost getTabHost(){
        return tabHost;
    }

}
