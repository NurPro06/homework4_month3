package com.example.homework3_month3.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework3_month3.R;
import com.example.homework3_month3.adapter.CountryAdapter;
import com.example.homework3_month3.data.CountryCitiesData;
import com.example.homework3_month3.databinding.FragmentCountryBinding;

import java.util.ArrayList;
import java.util.List;


public class CountryFragment extends Fragment {

    private FragmentCountryBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCountryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<String> countries = getArguments() != null ? getArguments().getStringArrayList("Countries") : new ArrayList<>();

        CountryAdapter countryAdapter = new CountryAdapter(country -> {
            CityFragment cityFragment = new CityFragment();
            Bundle bundle = new Bundle();
            bundle.putString("Country", country);
            bundle.putString("City", getCitiesForCountry(country));
            cityFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, cityFragment)
                    .addToBackStack(null)
                    .commit();
        });

        binding.rvCountry.setAdapter(countryAdapter);
        countryAdapter.submitList(countries);
    }

    private String getCitiesForCountry(String country) {
        return CountryCitiesData.getCapitalForCountry(country);
    }
}
