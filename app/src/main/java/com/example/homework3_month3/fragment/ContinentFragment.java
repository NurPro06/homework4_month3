package com.example.homework3_month3.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework3_month3.R;
import com.example.homework3_month3.adapter.ContinentAdapter;
import com.example.homework3_month3.databinding.FragmentContinentBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContinentFragment extends Fragment {

    private FragmentContinentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ContinentAdapter continentAdapter = new ContinentAdapter(continent -> {
            CountryFragment countryFragment = new CountryFragment();
            Bundle bundle = new Bundle();

            bundle.putString("Continent", continent);
            bundle.putStringArrayList("Countries", new ArrayList<>(getCountriesByContinent(continent)));
            countryFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, countryFragment)
                    .addToBackStack(null)
                    .commit();
        });

        binding.rvContinent.setAdapter(continentAdapter);

        List<String> continents = Arrays.asList("Africa", "Asia", "Europe", "North America", "South America", "Australia", "Antarctica");
        continentAdapter.submitList(continents);
    }

    private List<String> getCountriesByContinent(String continent) {
        switch (continent) {
            case "Africa":
                return Arrays.asList("Nigeria", "Egypt", "South Africa");
            case "Asia":
                return Arrays.asList("China", "India", "Japan");
            case "Europe":
                return Arrays.asList("Germany", "France", "United Kingdom");
            case "North America":
                return Arrays.asList("United States", "Canada", "Mexico");
            case "South America":
                return Arrays.asList("Brazil", "Argentina", "Colombia");
            case "Australia":
                return Arrays.asList("Australia", "New Zealand", "Fiji");
            case "Antarctica":
                return Arrays.asList("Research Station 1", "Research Station 2", "Research Station 3", "Research Station 4", "Research Station 5");
            default:
                return new ArrayList<>();
        }
    }
}