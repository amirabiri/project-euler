module euler.common.colors;
import std.stdio;



string color(S, C)(S str, C color) if(isSomeString!S)
{
	return "\033[" ~ color ~ "m" ~ str ~ "\033[0m";
}

string red   (S)(S str) if(isSomeString!S) { return str.color("91"); }
string green (S)(S str) if(isSomeString!S) { return str.color("92"); }
string yellow(S)(S str) if(isSomeString!S) { return str.color("93"); }
string blue  (S)(S str) if(isSomeString!S) { return str.color("94"); }

string RED   (S)(S str) if(isSomeString!S) { return str.color("1;91"); }
string GREEN (S)(S str) if(isSomeString!S) { return str.color("1;92"); }
string YELLOW(S)(S str) if(isSomeString!S) { return str.color("1;93"); }
string BLUE  (S)(S str) if(isSomeString!S) { return str.color("1;94"); }