package com.spring.enums;

public enum RoleEnum 
{
   
    SUPER_ADMIN ("SUPER_ADMIN"),
    ADMIN ("ADMIN"),
    CUSTOMER ("CUSTOMER");

    private String value;

    RoleEnum(String value){
        this.value = value;
    }
    
    
    @Override
    public String toString() {

        return value;
    }

   
}
