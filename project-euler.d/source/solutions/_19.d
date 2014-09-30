module euler.solutions._19;
import euler.common.solutions;
import std.datetime;



mixin solution!(19,
{
    long sundays_first = 0;
    for (int year = 1901; year <= 2000; year++) {
        for (int month = 1; month <= 12; month++) {
            if (Date(year, month, 1).dayOfWeek == DayOfWeek.sun) {
                sundays_first++;
            }
        }
    }
	return sundays_first;
});