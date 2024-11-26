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
import com.example.homework3_month3.databinding.FragmentCountryBinding;

import java.util.Arrays;
import java.util.List;


public class CountryFragment extends Fragment {

    private FragmentCountryBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCountryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String continent = getArguments() != null ? getArguments().getString("Continent") : "Unknown";

        CountryAdapter countryAdapter = new CountryAdapter(country -> {
            CityFragment cityFragment = new CityFragment();
            Bundle bundle = new Bundle();
            bundle.putString("Country", country);
            cityFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, cityFragment)
                    .addToBackStack(null)
                    .commit();
        });

        binding.rvCountry.setAdapter(countryAdapter);

        List<String> countries = getCountriesByContinent(continent);
        countryAdapter.submitList(countries);
    }

    private List<String> getCountriesByContinent(String continent) {
        switch (continent) {
            case "Africa":
                return Arrays.asList("Nigeria", "South Africa", "Egypt");
            case "Eurasia":
                return Arrays.asList("China","Germany", "Kyrgyzstan");
            case "South America":
                return Arrays.asList("Argentina", "Brazil", "Colombia");
            case "North America":
                return Arrays.asList("Mexico","USA", "Canada");
            case "Oceania":
                return Arrays.asList("Australia","New Zealand", "Fiji");
            default:
                return Arrays.asList();
        }
    }
}
