package com.mhdarslan.mydoctorapp.covidtracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.mhdarslan.mydoctorapp.R;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<CountryModel> {

    private Context context;
    private List<CountryModel> countryModelList;
    private List<CountryModel> countryModelListFiltered;


    public MyCustomAdapter(Context context, List<CountryModel> countryModelList) {
        super(context, R.layout.list_custom_item, countryModelList);

        this.context = context;
        this.countryModelList = countryModelList;

        // copy countryModelList data into countryModelListFiltered
        this.countryModelListFiltered = countryModelList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item, null, true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);
        ImageView imageView = view.findViewById(R.id.imageFlag);

        // set Data into the views
        tvCountryName.setText(countryModelListFiltered.get(position).getCountry());

        // for imageView we use glide library
        Glide.with(context).load(countryModelListFiltered.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {
        return countryModelListFiltered.size();
    }

    @Nullable
    @Override
    public CountryModel getItem(int position) {
        return countryModelListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                FilterResults filterResults = new FilterResults();
                if(constraint == null || constraint.length() == 0){
                    filterResults.count = countryModelList.size();
                    filterResults.values = countryModelList;
                }else {
                    List<CountryModel> resultsModel = new ArrayList<>();
                    String searchStr = constraint.toString().toLowerCase();

                    for (CountryModel itemModel:countryModelList){
                        if(itemModel.getCountry().toLowerCase().contains(searchStr)){
                            resultsModel.add(itemModel);
                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;
                    }
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                countryModelListFiltered = (List<CountryModel>) results.values;
                AffectedCountries.countryModelList = (List<CountryModel>) results.values;
                notifyDataSetChanged();
            }
        };

        return filter;
    }
}
