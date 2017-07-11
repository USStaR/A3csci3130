package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

class Business implements Serializable {

    public String address;
    public  String name;
    public String province;
    public int businessNumber;
    public String primaryBusiness;
    public String id;

    public Business() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    Business(String id, String address, String name, String province, int businessNumber, String primaryBusiness) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.province = province;
        this.businessNumber = businessNumber;
        this.primaryBusiness = primaryBusiness;
    }

    /**
     * Updates the data for the business
     *
     * @param address         new address, string
     * @param name            new name, string
     * @param province        new province, string
     * @param businessNumber  new business number, int
     * @param primaryBusiness new primary business, string
     */
    void updateData(String address, String name, String province, int businessNumber, String primaryBusiness) {
        this.address = address;
        this.name = name;
        this.province = province;
        this.businessNumber = businessNumber;
        this.primaryBusiness = primaryBusiness;
    }
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("address", address);
        result.put("name", name);
        result.put("province", province);
        result.put("businessNumber", businessNumber);
        result.put("primaryBusiness", primaryBusiness);
        result.put("id", id);
        return result;
    }
}
