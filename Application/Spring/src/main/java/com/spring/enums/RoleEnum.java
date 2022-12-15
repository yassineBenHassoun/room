package com.spring.enums;

public enum RoleEnum 
{
   

    
    ADMIN ("ADMIN"),
    MODERATOR("MODERATOR"),
    USER ("USER");

    private String value;

    RoleEnum(String value){
        this.value = value;
    }
    
    
    @Override
    public String toString() {

        return value;
    }

   
}
