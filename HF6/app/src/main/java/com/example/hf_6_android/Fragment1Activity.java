package com.example.hf_6_android;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1Activity#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1Activity extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    protected static final String FRAG2 = "2";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<Money> currencyList = new ArrayList<>();
    ListView list;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment1Activity() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1Activity.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1Activity newInstance(String param1, String param2) {
        Fragment1Activity fragment = new Fragment1Activity();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        Context c = getActivity().getApplicationContext();
        View vw = inflater.inflate(R.layout.fragment1, container, false);

        currencyList.add(new Money(R.drawable.unio, "EUR", "Euro", 4.4100, 4.5500));
        currencyList.add(new Money(R.drawable.usa, "USD", "Dolar american", 3.9750, 4.1450));
        currencyList.add(new Money(R.drawable.uk, "GBP", "Lira sterlina", 6.1250, 6.3550));
        currencyList.add(new Money(R.drawable.australia, "AUD", "Dolar australian", 2.9600, 3.0600));
        currencyList.add(new Money(R.drawable.canada, "CAD", "Dolar canadian", 3.0950, 3.2650));
        currencyList.add(new Money(R.drawable.switzerland, "CHF", "Franc elvetian", 4.2300, 4.3300));
        currencyList.add(new Money(R.drawable.dania, "DKK", "Coroana daneaza", 0.5850, 0.6150));
        currencyList.add(new Money(R.drawable.hungary, "HUF", "Forint maghiar", 0.0136, 0.0146));

        list = vw.findViewById(R.id.currency_list);
        MoneyListAdapter theAdapter = new MoneyListAdapter(c, currencyList);
        list.setAdapter(theAdapter);

        final FragmentManager fm = getFragmentManager();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                TextView twCurrency = v.findViewById(R.id.currencyID);
                TextView twBuyValue = v.findViewById(R.id.valueCumparaId);
                if(fm.findFragmentByTag(FRAG2)!=null){
                    TextView selectedOpt = getActivity().findViewById(R.id.selectedopt);
                    selectedOpt.setText("You have selected: "+(twCurrency.getText().toString() + " " + twBuyValue.getText().toString()));
                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(),  ShowItemActivity.class);
                    intent.putExtra("item", (twCurrency.getText().toString() + " " + twBuyValue.getText().toString()));
                    startActivity(intent);
                }
            }
        });
        return vw;
    }
}