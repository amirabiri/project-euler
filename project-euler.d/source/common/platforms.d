module euler.common.platforms;
import std.algorithm;
import std.range;
import std.traits;
import std.datetime;



version(LDC)
{
	auto sum(R)(R r) if (isInputRange!R && !isInfinite!R && is(typeof(r.front + r.front)))
	{
		return r.reduce!"a + b";
	}

	@safe size_t lengthof(aliases...)() nothrow
	{
		return aliases.length;
	}
	
	TickDuration[lengthof!(fun)()] benchmark(fun...)(uint n)
	{
		TickDuration[lengthof!(fun)()] result;
		StopWatch sw;
		sw.start();
		
		foreach(i, unused; fun)
		{
			sw.reset();
			foreach(j; 0 .. n)
				fun[i]();
			result[i] = sw.peek();
		}
		
		return result;
	}
}