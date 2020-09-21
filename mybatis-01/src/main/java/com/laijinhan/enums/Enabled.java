package com.laijinhan.enums;

/**
 * @Author laijinhan
 * @date 2020/9/16 9:16 下午
 */
public enum Enabled {
    disabled(0),
    enabled(1);
    private  final  int value;
    private  Enabled(int value){
        this.value=value;
    }
    public  int getValue(){
        return this.value;
    }
}
