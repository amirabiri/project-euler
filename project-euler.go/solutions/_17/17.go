package _17

var NUMBER_WORDS_MAP     []string
var NUMBER_10S_WORDS_MAP []string

func init() {
	NUMBER_WORDS_MAP = []string{ "",
		"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
		"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" }

	NUMBER_10S_WORDS_MAP = []string{ "", "",
		"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" }
}

func Solve() int64 {
	sum := 0
	for number := 1; number <= 1000; number++ {
		for _,word := range numberWords(number) {
			sum += len(word)
		}
	}
	return int64(sum)
}

func numberWords(number int) []string {
	if number < 20 {
		return []string{ NUMBER_WORDS_MAP[number] }
	}

	if number < 100 {
		words := []string{ NUMBER_10S_WORDS_MAP[number / 10] }
		if number % 10 != 0 {
			words = append(words, NUMBER_WORDS_MAP[number % 10])
		}
		return words
	}

	if number < 1000 {
		words := []string{ NUMBER_WORDS_MAP[number / 100], "hundred" }
		if number % 100 != 0 {
			words = append(words, "and")
			words = append(words, numberWords(number % 100)...)
		}
		return words
	}

	return []string{ "one", "thousand" }
}
