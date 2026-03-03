class Solution {
    public String minWindow(String s, String t) {

        int Ns = s.length();
        int Nt = t.length();

        // If s is shorter than t, it's impossible to form a valid window
        if (Nt > Ns) return "";

        // Frequency array to track how many characters of t are still needed
        // Using ASCII size 128 to directly index characters
        int[] tCounter = new int[128];

        // Total number of characters still required (including duplicates)
        int required = Nt;

        // Build frequency map of characters in t
        for (int i = 0; i < Nt; i++) {
            tCounter[t.charAt(i)]++;
        }

        // start → starting index of the smallest valid window
        int start = 0;

        // minLength → length of the smallest valid window found
        int minLength = Integer.MAX_VALUE;

        // Two pointers defining window [left, right)
        int left = 0;
        int right = 0;

        // Expand window using right pointer
        while (right < Ns) {

            char cRight = s.charAt(right);

            /*
             If this character is still needed (count > 0),
             we successfully matched one required character.
             So decrease required.
            */
            if (tCounter[cRight] > 0) {
                required--;
            }

            /*
             Decrement count regardless.
             Why?
             Because this character is now part of the window.
             If it becomes negative, it means we have extra copies.
            */
            tCounter[cRight]--;

            // Expand window (right is exclusive boundary)
            right++;

            /*
             When required == 0:
             Window currently contains ALL required characters.
             Now try to shrink it to make it minimum.
            */
            while (required == 0) {

                // Update minimum window if current one is smaller
                if (minLength > right - left) {
                    minLength = right - left;
                    start = left;
                }

                // Remove character at left from window
                char cLeft = s.charAt(left);

                // Put it back into counter (since it's leaving window)
                tCounter[cLeft]++;

                /*
                 If count becomes > 0,
                 it means we just removed a required character,
                 so window is no longer valid.
                */
                if (tCounter[cLeft] > 0) {
                    required++;
                }

                // Shrink window from left
                left++;
            }
        }

        // If no valid window found, return empty string
        if (minLength == Integer.MAX_VALUE) return "";

        // Return smallest window substring
        return s.substring(start, start + minLength);
    }
}