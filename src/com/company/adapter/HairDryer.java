package com.company.adapter;

public class HairDryer implements Electronic110v{

    @Override
    public void powerOn(){
        System.out.println("헤어 드라이어 110v");
    }
}
