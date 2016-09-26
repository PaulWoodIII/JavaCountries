package com.paulwoodiii;

import java.util.ArrayList;

/**
 * Created by paul on 9/22/16.
 */
public class CountryWrapper {
    ArrayList<Country> countries;

    public CountryWrapper() {
    }

    public CountryWrapper(ArrayList<Country> countries) {
        this.countries = countries;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void setCountries(ArrayList<Country> countries) {
        this.countries = countries;
    }
}
