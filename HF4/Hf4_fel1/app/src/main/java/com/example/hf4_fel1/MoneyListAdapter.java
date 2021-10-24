package com.example.hf4_fel1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MoneyListAdapter extends ArrayAdapter {

    private ArrayList<Money> theCurrencyList;
    private Activity context;


    public MoneyListAdapter(Activity context, ArrayList<Money> theCurrencyList) {
        super(context, R.layout.listview_row, theCurrencyList);
        this.context = context;
        this.theCurrencyList = theCurrencyList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row, null, true);

        ImageView imgFlag = rowView.findViewById(R.id.flagID);
        TextView twCurrency = rowView.findViewById(R.id.currencyID);
        TextView twExtraInformation = rowView.findViewById(R.id.extraInformationID);
        TextView twBuyValue = rowView.findViewById(R.id.valueCumparaId);
        TextView twSellValue = rowView.findViewById(R.id.valueVindeId);
        TextView twBuy = rowView.findViewById(R.id.twCumparaId);
        TextView twSell = rowView.findViewById(R.id.twVindeId);

        imgFlag.setImageResource(theCurrencyList.get(position).getImage());
        twCurrency.setText(theCurrencyList.get(position).getCurrency());
        twExtraInformation.setText(theCurrencyList.get(position).getExtraInformation());
        twBuyValue.setText(String.format("%.4f RON", theCurrencyList.get(position).getBuyValue()));
        twSellValue.setText(String.format("%.4f RON", theCurrencyList.get(position).getSellValue()));
        twBuy.setText("Cumpara");
        twSell.setText("Vinde");

        return rowView;
    }
}
