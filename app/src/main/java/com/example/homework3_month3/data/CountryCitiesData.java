package com.example.homework3_month3.data;

import java.util.Arrays;

public class CountryCitiesData {
    public static String getCapitalForCountry(String country) {
        switch (country) {
            case "Nigeria":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "Egypt":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "South Africa":
                return "Nairobi";
            case "China":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "India":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "Japan":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "Germany":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "France":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "United Kingdom":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "United States":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "Canada":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "Mexico":
                return Arrays.asList("Nigeria", "Egypt", "South Africa").toString();
            case "Brazil":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "Argentina":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "Colombia":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "Australia":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
                case "New Zealand":
                    return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "Fiji":
                return Arrays.asList("Nigeria", "Egypt", "South Africa", "Kenya", "Ethiopia").toString();
            case "Antarctica":
                return "No cities";
            default:
                return "";
        }
    }
}
