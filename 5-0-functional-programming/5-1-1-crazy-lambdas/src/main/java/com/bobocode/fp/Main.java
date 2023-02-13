package com.bobocode.fp;


import java.math.BigDecimal;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args) {
        var threeTimesString = CrazyLambdas.stringMultiplier().apply("Sokura ", 2);
        System.out.println("stringMultiplier\n" + threeTimesString + "\n");

        var toDollarString = CrazyLambdas.toDollarStringFunction().apply(BigDecimal.valueOf(10));
        System.out.println("toDollarString\n" + toDollarString + "\n");

        var lengthInRangePredicate = CrazyLambdas.lengthInRangePredicate(4, 10).test("Hola");
        System.out.println("lengthInRangePredicate\n" + lengthInRangePredicate + "\n");

        var randomIntSupplier = CrazyLambdas.randomIntSupplier().getAsInt();
        System.out.println("randomIntSupplier\n" + randomIntSupplier + "\n");

        var boundedRandomIntSupplier = CrazyLambdas.boundedRandomIntSupplier().applyAsInt(4);
        System.out.println("boundedRandomIntSupplier\n" + boundedRandomIntSupplier + "\n");

        var intSquareOperation = CrazyLambdas.intSquareOperation().applyAsInt(10);
        System.out.println("intSquareOperation\n" + intSquareOperation + "\n");

        var nMultiplyFunctionSupplier = CrazyLambdas.nMultiplyFunctionSupplier(5).get().applyAsInt(11);
        System.out.println("nMultiplyFunctionSupplier\n" + nMultiplyFunctionSupplier + "\n");

        var composeWithTrimFunction = CrazyLambdas.composeWithTrimFunction().apply(s -> s.repeat(3)).apply("  Hi  ");;
        System.out.println("composeWithTrimFunction\n" + composeWithTrimFunction + "\n");

        var runningThreadSupplier = CrazyLambdas.runningThreadSupplier(() -> {   // lambda expression
                System.out.println("Runnable with Lambda Expression");
        }).get();
        System.out.println("runningThreadSupplier\n" + runningThreadSupplier + "\n");

        var newThreadRunnableConsumer = CrazyLambdas.newThreadRunnableConsumer();
        newThreadRunnableConsumer.accept(Thread::new);

        var functionToConditionalFunction = CrazyLambdas.functionToConditionalFunction()
                .apply(a -> a * a, a -> a <= 5);

        int i = functionToConditionalFunction.applyAsInt(5);

        System.out.println("functionToConditionalFunction\n" + i + "\n");



    }

}
