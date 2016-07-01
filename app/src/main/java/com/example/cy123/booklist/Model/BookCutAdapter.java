package com.example.cy123.booklist.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cy123.booklist.R;

import java.util.List;

/**
 * Created by cy123 on 2016/6/29.
 */
public class BookCutAdapter extends ArrayAdapter<BookShortCut> {

    public BookCutAdapter(Context context,
                          List<BookShortCut> bookShortCuts){
        super(context, 0, bookShortCuts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.bookcut_item, null);
        }

        BookShortCut bookShortCut = getItem(position);

        TextView titleText = (TextView)convertView.findViewById(R.id.bookcut_title);
        TextView authorText = (TextView)convertView.findViewById(R.id.bookcut_author);
        titleText.setText(bookShortCut.getTitle());
        authorText.setText(bookShortCut.getAuthorString());

        return convertView;
    }
}
