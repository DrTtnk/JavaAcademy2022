package com.company;

import java.util.Date;

class HappyException extends Exception {
    Date timestamp;
    HappyException(String message) {
        super(message + " <3");
        this.timestamp = new Date();
    }
}

class HappyCustomException {

    public static void functionNested1() throws Exception {
        functionNested2();
    }

    public static void functionNested2() throws Exception {
        functionNested3();
    }

    public static void functionNested3() throws Exception {
        IWillExplode(false);
    }


    public static void IWillExplode(boolean bigException) throws HappyException {
        if(bigException){
            throw new HappyException("I'm a big exception");
        }else {
            throw new RuntimeException("I'm exploding");
        }
    }

    public static void main(String[] args) {
        try {
            IWillExplode(true);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }catch (HappyException e){
            System.out.println(e.timestamp);
            System.out.println("something big happened: " + e.getMessage());
        }

        System.out.println("I'm alive in the end!!!");
    }
}