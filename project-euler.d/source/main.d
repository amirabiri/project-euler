import euler.common.solutions;
import euler.common.colors;
import euler.common.data;
import std.getopt;



struct Options
{
	bool outputTime;
	bool benchmark;
	int  times = 10;	
}

void main(string[] args)
{
	Options opts;
	
	try {
		getopt(args,
			"output-time|t", &opts.outputTime,
			"benchmark|b",   &opts.benchmark,
			"times|n",       &opts.times
		);		
	}
	catch (Exception e) {
		writeln(e.msg.red);
		show_usage();
		return;
	}
	
	if (args.length == 1) {
		show_usage();
		return;
	}
	
	initialize_base_path(args[0]);

	if (args[1] != "all") {
		run_single_solution(args[1], opts);
	}
	else {
		run_all_solutions(opts);
	}
}

void run_single_solution(string numStr, Options opts)
{
	try {
		int num;
		
		try {
			num = to!int(numStr);
		}
		catch (ConvException e) {
			writeln("Invalid solution number".red);
			return;
		}
		
		try {
			run_solution_by_opts(num, opts);
		}
		catch (SolutionNotFoundException e) {
			writeln(e.msg.red);
			return;
		}
	}
	catch (Exception e) {
		writeln(to!string(e).red);
	}
}

void run_all_solutions(Options opts)
{
	try {
		foreach (num; solution_numbers()) {
			try {
				run_solution_by_opts(num, opts);
			}
			catch (Exception e) {
				writeln(to!string(e).red);
			}
		}
	}
	catch (Exception e) {
		writeln(to!string(e).red);
	}
}

void run_solution_by_opts(int num, Options opts)
{
	if (!opts.benchmark) {
		run_solution(num, opts.outputTime);				
	}
	else {
		benchmark_solution(num, opts.times);
	}	
}

void show_usage()
{
	writeln("Usage: " ~ "ProjectEuler <solution>|all [--output-time] [--benchmark] [--times=<n>]".green);
}