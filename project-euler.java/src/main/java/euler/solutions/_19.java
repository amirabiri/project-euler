package euler.solutions;

import euler.common.BaseSolution;
import euler.common.Result;

import java.time.LocalDate;

import static java.time.DayOfWeek.SUNDAY;

public class _19 extends BaseSolution
{
    @Override
    public Result solve() {
        int sundays_first = 0;
        for (int year = 1901; year <= 2000; year++) {
            for (int month = 1; month <= 12; month++) {
                if (LocalDate.of(year, month, 1).getDayOfWeek() == SUNDAY) {
                    sundays_first++;
                }
            }
        }
        return new Result(sundays_first);
    }
}
