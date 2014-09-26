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



enum SolutionResultType { Integer, Long, String }

struct SolutionResult
{
	immutable int                intResult;
	immutable long               longResult;
	immutable string             stringResult;
	immutable SolutionResultType resultType;
	
	
	public this(int result)
	{
		intResult  = result;
		resultType = SolutionResultType.Integer;
	}
	
	public this(long result)
	{
		longResult  = result;
		resultType  = SolutionResultType.Long;
	}
	
	public this(string result)
	{
		stringResult = result;
		resultType   = SolutionResultType.String;
	}
	
	public string toString()
	{
		switch (resultType)
		{
			case SolutionResultType.Integer: return intResult.to!string;
			case SolutionResultType.Long:    return longResult.to!string;
			case SolutionResultType.String:  return stringResult;
			default:                         return null;
		}
	}
}

class SolutionNotFoundException : Exception
{
	public this(string message)
	{
		super(message);
	}
}

private SolutionResult function()[int] solutions;

void register_solution(int num, SolutionResult function() func)
{
	solutions[num] = func;
}

mixin template solution(int num, alias F)
{
	static this()
	{
		register_solution(num, () => SolutionResult(F()));
	}
}

void run_solution(int num, bool outputTime)
{
	SolutionResult function()* func = (num in solutions);

	string numStr = to!string(num);

	if (func is null) {
		throw new SolutionNotFoundException("Solution " ~ numStr ~ " not found");
	}
	
	init_solution_data(num);

	StopWatch sw;
	sw.start;
	
	auto result = (*func)();
	
	sw.stop;
	writeln(result);
	if (outputTime) {
		writeln(sw.peek().msecs);
	}
}

void benchmark_solution(int num, int run_times)
{
	SolutionResult function()* func = (num in solutions);

	string numStr = to!string(num);

	if (func is null) {
		throw new SolutionNotFoundException("Solution " ~ numStr ~ " not found");
	}
	
	init_solution_data(num);

	auto lala = () => (*func)();
	version (LDC)
	{
		auto r = benchmark!(lala)(run_times);
	}
	else
	{
		import std.datetime;
		auto r = benchmark!(lala)(run_times);
	}
	
	writeln(r[0].msecs);
}

int[] solution_numbers()
{
	return solutions.keys.sort;
}