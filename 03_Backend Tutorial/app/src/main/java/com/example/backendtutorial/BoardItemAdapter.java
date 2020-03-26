package com.example.backendtutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BoardItemAdapter extends BaseAdapter {
    Context context;
    ArrayList<BoardItemData> items = new ArrayList<>();

    public BoardItemAdapter(Context context, ArrayList<BoardItemData> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) { //인덱스랑 같은 말
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View를 불러옴
        View board_item = inflater.inflate(R.layout.board_item,parent,false);
        //Data를 불러옴
        BoardItemData item = items.get(position);

        TextView titleView = board_item.findViewById(R.id.titleView);
        titleView.setText(item.getTitle());
        TextView contentView = board_item.findViewById(R.id.contentView);
        contentView.setText(item.getContent());

        return board_item;
    }
}
