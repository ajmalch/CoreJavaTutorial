package com.pattern.decorator;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by AjmalCholassery on 6/15/15.
 */
public class IceCream {
    private Function<Flavour,Flavour> flavour;

    public Flavour makeIceCream(final Flavour iflavour){
        return flavour.apply(iflavour);
    }

    public void  setFlavours(final Function<Flavour,Flavour>... flavours){
        flavour= Stream.of(flavours).reduce((flavor,next)->flavour.compose(next)).orElse(flavour->flavour);
    }

    public IceCream() {
        setFlavours();
    }

    public static void main(String[] args) {
        final IceCream  iceCream= new IceCream();

        final Consumer<String> printCaptured = (flavourInfo) ->
                System.out.println(String.format("with %s: %s", flavourInfo, iceCream.makeIceCream(new Flavour()).getFlavourDetails()));


        System.out.println("//" + "Start: no Flavour output");
        printCaptured.accept("no flavor");
        System.out.println("//" + "End: no Flavour output");

        System.out.println("//" + "Start: Honey Flavour output");
        iceCream.setFlavours(Flavour::addHoney);
        printCaptured.accept("honey");
        System.out.println("//" + "End: no Flavour output");

        System.out.println("//" + "Start: Honey and Nuts Flavour output");
        iceCream.setFlavours(Flavour::addHoney,Flavour::addNuts);
        printCaptured.accept("honey and nuts");
        System.out.println("//" + "End: no Flavour output");

        System.out.println("//" + "Start: no Flavour output");
        iceCream.setFlavours();
        printCaptured.accept("no flavor");
        System.out.println("//" + "End: no Flavour output");

    }
}
