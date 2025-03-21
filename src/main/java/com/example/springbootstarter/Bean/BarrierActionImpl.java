package com.example.springbootstarter.Bean;

public class BarrierActionImpl implements BarrierAction {
    @Override
    public void action() {
        System.out.println("барьер сработал");
    }
}
