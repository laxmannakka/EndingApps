package com.bridgelabz.appystore.interfaces;

import com.bridgelabz.appystore.view.ContentListView;
import com.bridgelabz.appystore.viewmodel.CategoryViewmodel;
import com.bridgelabz.appystore.viewmodel.ContentListViewmodel;

import java.util.ArrayList;

/**
 * Created by bridgeit007 on 29/8/16.
 */

public interface FetchContentLIst {
    public void getcontentviewdata(ArrayList<ContentListViewmodel> viewmodelArrayList);
}
