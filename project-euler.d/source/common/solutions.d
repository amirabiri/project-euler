module euler.common.solutions;
import euler.common.colors;
import euler.common.data;

public import euler.common.platforms;
public import std.stdio;
public import std.conv;
public import std.algorithm;
public import std.array;
public import std.container;
public import std.string;
import std.datetime : StopWatch;



class SolutionNotFoundException : Exception
{
	public this(string message)
	{
		super(message);
	}
}

private long function()[int] solutions;

void register_solution(int num, long function() func)
{
	solutions[num] = func;
}

mixin template solution(int num, alias F)
{
	static this()
	{
		register_solution(num, F);
	}
}

void run_solution(int num, bool outputTime)
{
	string numStr = to!string(num);

	long function()* funcPtr = (num in solutions);
	if (funcPtr is null) {
		throw new SolutionNotFoundException("Solution " ~ numStr ~ " not found");
	}
	
	auto func = (*funcPtr);
	
	init_solution_data(num);

	StopWatch sw;
	sw.start;
	
	auto result = func();
	
	sw.stop;
	writeln(result);
	if (outputTime) {
		writeln(sw.peek().msecs);
	}
}

void benchmark_solution(int num, int run_times)
{
	string numStr = to!string(num);

	long function()* funcPtr = (num in solutions);
	if (funcPtr is null) {
		throw new SolutionNotFoundException("Solution " ~ numStr ~ " not found");
	}
	
	auto func = (*funcPtr);
	
	init_solution_data(num);

	//auto lala = () => (*func)();
	version (LDC)
	{
		auto r = benchmark!(func)(run_times);
	}
	else
	{
		import std.datetime;
		auto r = benchmark!(func)(run_times);
	}
	
	writeln(r[0].msecs);
}

int[] solution_numbers()
{
	return solutions.keys.sort;
}