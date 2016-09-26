package com.paulwoodiii;

/**
 * Created by paul on 9/22/16.
 */
public class Country {
    String name;
    String abbreviation;

    public Country() {
    }

    public Country(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        if (!getName().equals(country.getName())) return false;
        return getAbbreviation().equals(country.getAbbreviation());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 92821 * result + getAbbreviation().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return  "name: " + name + ", abbreviation: " + abbreviation;
    }
}
