package com.mhdarslan.mydoctorapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GuidelineAdapter extends ArrayAdapter<Word> {
    public GuidelineAdapter(Activity context, ArrayList<Word> words) {
        super(context, 0,words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.prev_listitem,parent,false);
        }

        // Get the {@link currentWord} object located at this position in the list
        Word currentWord = getItem(position);

        // for Heading
        TextView headingText = listItemView.findViewById(R.id.headingText);
        // Get the word from the current Word object and
        // set this text on the heading TextView
        headingText.setText(currentWord.getmHeading());

        // for Description
        TextView descText = listItemView.findViewById(R.id.descText);
        // Get the word from the current Word object and
        // set this text on the description TextView
        descText.setText(currentWord.getmDesc());

        // Return the whole list item layout
        // so that it can be shown in the ListView
        return listItemView;
    }
}
