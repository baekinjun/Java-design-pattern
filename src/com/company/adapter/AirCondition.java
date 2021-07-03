package com.company.adapter;

public class AirCondition implements Electronic220v{
    @Override
    public void connect(){
        System.out.println("에어컨 220v on");
    }
}
