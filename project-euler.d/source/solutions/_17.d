module euler.solutions._17;
import euler.common.solutions;
import std.range;



auto number_words_map = [null, "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
					           "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"];

auto number10s_words_map = [null, null, "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"];

mixin solution!(17,
{
	long sum;
	foreach (number; iota(1, 1001)) {
		foreach (word; number_words(number)) {
			sum += word.length;
		}
	}
	return sum;
});

string[] number_words(int number)
{
	if (number < 20) {
		return [number_words_map[number]];
	}
	
	if (number < 100) {
		auto words = [number10s_words_map[number / 10]];
		if (number % 10 != 0) {
			words ~= number_words_map[number % 10];
		}
		return words;
	}
	
	if (number < 1000) {
		auto words = [number_words_map[number / 100], "hundred"];
		if (number % 100 != 0) {
			words ~= "and";
			words ~= number_words(number % 100);
		}
		return words;		
	}
	
	return ["one", "thousand"];
}