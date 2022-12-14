package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        //update this
        int chargesSum = 0;
        for(int i = 0; i < charges.size();i++)
            {
                chargesSum += charges.get(i).getCharge();
            }
        return chargesSum;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update this
        String infoString = "(CustomerID: " + getId() + ", CustomerName: " + getName() + ", CustomerBalance: " + getBalance() + ")\n";
        return infoString;
    }
}
