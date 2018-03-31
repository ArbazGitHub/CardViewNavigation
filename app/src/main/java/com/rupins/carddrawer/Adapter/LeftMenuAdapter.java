package com.rupins.carddrawer.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rupins.carddrawer.Model.MenuMain;
import com.rupins.carddrawer.R;

import java.util.ArrayList;

/**
 * Created by Arbaz.
 * Date: 31/3/18
 * Time: 3:16 PM
 */
public class LeftMenuAdapter extends RecyclerView.Adapter<LeftMenuAdapter.ViewHolder> {

    ArrayList<MenuMain> menuMainArrayList;
    Context context;
    MenuMain menuMain;

    public LeftMenuAdapter(ArrayList<MenuMain> menuMainArrayList, Context context) {
        this.menuMainArrayList = menuMainArrayList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_row, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        menuMain = menuMainArrayList.get(position);
        try {
            holder.tvPMenuTxt.setText(menuMain.getItemName());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return menuMainArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public RelativeLayout menuRL;
        public ImageView ivPMenuImg;
        public TextView tvPMenuTxt;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            menuRL = (RelativeLayout) view.findViewById(R.id.menuRL);
            ivPMenuImg = (ImageView) view.findViewById(R.id.ivPMenuImg);
            tvPMenuTxt = (TextView) view.findViewById(R.id.tvPMenuTxt);

        }
    }
}