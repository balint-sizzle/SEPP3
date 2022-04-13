package main.model;

import main.state.IBookingState;

import java.util.Arrays;

enum BookingStatus {
    Active,
    CancelledByConsumer,
    CancelledByProvider,
    PaymentFailed
}

//    public static BookingStatus[] values(Class<? extends Enum<?>> e) {
//        return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(BookingStatus[]::new);
//    }
////    public static String[] names() {
////        State[] states = values();
////        String[] names = new String[states.length];
////
////        for (int i = 0; i < states.length; i++) {
////            names[i] = states[i].name();
////        }
////
////        return names;
////    }
//
//    @Override
//    public BookingStatus valueOf(String name){
////        Throws:
////        IllegalArgumentException - if this enum type has no constant with the specified name
////                NullPointerException - if the argument is null
//        String BookingStatus[] = {"Active",
//                                  "CancelledByConsumer",
//                                  "CancelledByProvider",
//                                  "PaymentFailed"};
//        if (name.equals("Active") ||
//            name.equals("CanCelledByConsumer") ||
//            name.equals("CancelledByProvider") ||
//            name.equals("PaymentFailed")) {
//            return null;
//        }
//        else if (name == null) {
//            throw new NullPointerException("the argument can not be null");
//
//        }
//        else {
//            throw new IllegalArgumentException("should has constant with the specified name");
//        }
//    }


