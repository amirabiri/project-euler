package euler;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.common.base.CharMatcher;
import com.google.inject.Guice;
import com.google.inject.Injector;
import euler.common.Solution;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static class CmdLineArgs {
        @Parameter
        public List<String> parameters = new ArrayList<>();

        @Parameter(names = { "--output-time", "-t" }, description = "Output solution time")
        public boolean outputTime;

        @Parameter(names = { "--benchmark", "-b" }, description = "Benchmark solution")
        public boolean benchmark;

        @Parameter(names = { "--times", "-n" }, description = "Number of benchmark runs")
        public int benchmarkTimes = 10;
    }

    private static class UsageException extends RuntimeException {
        private UsageException() {}
    }



    private static CmdLineArgs args;
    private static JCommander  cmndr;
    private static Injector    injector;
    private static Solution    solution;
    private static long        result;
    private static long        time;

    public static void main(String[] argv) {
        try {
            doMain(argv);
        }
        catch (ParameterException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        catch (UsageException e) {
            cmndr.setProgramName("project-euler");
            cmndr.setColumnSize(140);
            cmndr.usage();
            System.exit(1);
        }
        catch (Exception e) {
            e.printStackTrace(System.out);
            System.exit(1);
        }
    }

    private static void doMain(String[] argv) throws Exception {
        parseArgs(argv);

        injector = Guice.createInjector(new ProjectEulerModule());

        createSolutionInstance();

        if (args.benchmark) {
            benchmarkSolution();
            System.out.println(time);
        }
        else if (args.outputTime) {
            runAndTimeSolution();
            System.out.println(result);
            System.out.println(time);
        }
        else {
            runSolution();
            System.out.println(result);
        }
    }

    private static void parseArgs(String[] argv) {
        args  = new CmdLineArgs();
        cmndr = new JCommander(args);
        cmndr.parse(argv);

        if (args.parameters.size() == 0 ) {
            throw new UsageException();
        }

        if (args.parameters.size() > 1 ) {
            throw new ParameterException("Too many arguments - can only run one solution");
        }

        String solution = args.parameters.get(0);
        if (!CharMatcher.DIGIT.matchesAllOf(solution)) {
            throw new ParameterException("Invalid solution: " + solution);
        }
    }

    private static void createSolutionInstance() throws IllegalAccessException, InstantiationException {
        try {
            Class<?> solutionClass = Class.forName("euler.solutions._" + args.parameters.get(0));
            solution = (Solution)solutionClass.newInstance();
        }
        catch (ClassNotFoundException e) {
            throw new ParameterException("Invalid solution");
        }
        injector.injectMembers(solution);
    }

    private static void runSolution() {
        try {
            solution.initialize();
        }
        catch (Throwable e) {
            throw new RuntimeException("Exception in solution initialize", e);
        }

        result = solution.solve();
    }

    private static void runAndTimeSolution() {
        try {
            solution.initialize();
        }
        catch (Throwable e) {
            throw new RuntimeException("Exception in solution initialize", e);
        }

        solution.solve(); // Warm up

        long start = System.currentTimeMillis();

        result = solution.solve();

        time = System.currentTimeMillis() - start;
    }

    private static void benchmarkSolution() {
        try {
            solution.initialize();
        }
        catch (Throwable e) {
            throw new RuntimeException("Exception in solution initialize", e);
        }

        solution.solve(); // Warm up

        long start = System.currentTimeMillis();

        for (int i = 0; i < args.benchmarkTimes; i++) {
            solution.solve();
        }

        time = System.currentTimeMillis() - start;
    }
}
