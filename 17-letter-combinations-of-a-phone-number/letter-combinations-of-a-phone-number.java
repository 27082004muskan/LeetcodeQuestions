

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) return res;

        Map<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");

        backtrack(0, "", digits, digitToChar, res);

        return res;
    }

    private void backtrack(int index, String current, String digits,
                           Map<Character, String> digitToChar, List<String> res) {
        if (current.length() == digits.length()) {
            res.add(current);
            return;
        }

        String possibleLetters = digitToChar.get(digits.charAt(index));
        for (char c : possibleLetters.toCharArray()) {
            backtrack(index + 1, current + c, digits, digitToChar, res);
        }
    }
}
