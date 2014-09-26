module euler.solutions._16;
import euler.common.solutions;
import std.bigint;
import std.conv;



mixin solution!(16,
{
    auto twoPow1000 = (BigInt(2) ^^ 1000).to!string;
    int sum;
    foreach (chr; twoPow1000) {
    	sum += chr - 48;
    }
    return sum;
});